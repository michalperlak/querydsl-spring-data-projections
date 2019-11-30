package pl.michalperlak.querydsl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class QueryExecutorTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    SubscriptionRepository subscriptionRepository;

    @Autowired
    QueryExecutor queryExecutor;

    @BeforeEach
    void setUp() {
        userRepository.deleteAll();
        List<User> users = addUsers();
        addSubscriptions(users);
    }

    @Test
    void testGetPageByFirstName() {
        Page<UserProjection> page = queryExecutor.getFirstNameLikePage("A%", PageRequest.of(0, 10));
        List<String> userNames = page
                .get()
                .map(UserProjection::getUsername)
                .collect(Collectors.toList());
        List<String> expected = Collections.singletonList("UserA");
        assertEquals(expected, userNames);
    }

    @Test
    void testGetAllSubscriptions() {
        List<SubscriptionProjection> subscriptions = queryExecutor.getAllSubscriptions();
        List<SubscriptionProjection> expected = Arrays.asList(
                new SubscriptionProjection("STANDARD", "UserA"),
                new SubscriptionProjection("STANDARD", "UserB")
        );
        assertEquals(expected, subscriptions);
    }

    private List<User> addUsers() {
        User user1 = User
                .builder()
                .username("UserA")
                .firstName("Andrew")
                .lastName("Test")
                .dateOfBirth(LocalDate.of(1990, 10, 11))
                .build();
        User user2 = User
                .builder()
                .username("UserB")
                .firstName("John")
                .lastName("Doe")
                .dateOfBirth(LocalDate.of(1950, 12, 1))
                .build();
        return userRepository.saveAll(Arrays.asList(user1, user2));
    }

    private void addSubscriptions(List<User> users) {
        users
                .stream()
                .map(User::getId)
                .map(userId -> Subscription
                        .builder()
                        .name("STANDARD")
                        .userId(userId)
                        .activated(LocalDateTime.now())
                        .build())
                .forEach(subscriptionRepository::save);
    }
}