package pl.michalperlak.querydsl;

import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
class QueryBuilder {
    @PersistenceContext
    private final EntityManager entityManager;

    QueryBuilder(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    <T> JPQLQuery<T> createQuery() {
        return new JPAQuery<>(entityManager);
    }
}
