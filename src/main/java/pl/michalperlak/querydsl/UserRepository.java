package pl.michalperlak.querydsl;


import org.springframework.data.jpa.querydsl.ExtendedQuerydslPredicateExecutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface UserRepository extends JpaRepository<User, Long>, ExtendedQuerydslPredicateExecutor<User> {
}
