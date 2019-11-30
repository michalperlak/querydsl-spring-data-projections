package pl.michalperlak.querydsl;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class QueryExecutor {
    private final UserRepository userRepository;
    private final QueryBuilder queryBuilder;

    QueryExecutor(UserRepository userRepository, QueryBuilder queryBuilder) {
        this.userRepository = userRepository;
        this.queryBuilder = queryBuilder;
    }

    Page<UserProjection> getFirstNameLikePage(String firstNameLike, Pageable pageable) {
        QUser user = QUser.user;
        return userRepository.findAll(
                Projections.constructor(UserProjection.class, user.id, user.username),
                user.firstName.like(firstNameLike),
                pageable
        );
    }

    List<SubscriptionProjection> getAllSubscriptions() {
        QUser user = QUser.user;
        QSubscription subscription = QSubscription.subscription;
        JPQLQuery<SubscriptionProjection> query = queryBuilder
                .createQuery()
                .select(Projections.constructor(SubscriptionProjection.class, subscription.name, user.username))
                .from(user)
                .innerJoin(subscription)
                .on(user.id.eq(subscription.userId));
        return userRepository.findAll(query);
    }
}
