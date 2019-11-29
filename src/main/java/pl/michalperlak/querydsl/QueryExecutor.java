package pl.michalperlak.querydsl;

import org.springframework.stereotype.Component;

@Component
class QueryExecutor {
    private final UserRepository userRepository;
    private final QueryBuilder queryBuilder;

    QueryExecutor(UserRepository userRepository, QueryBuilder queryBuilder) {
        this.userRepository = userRepository;
        this.queryBuilder = queryBuilder;
    }
}
