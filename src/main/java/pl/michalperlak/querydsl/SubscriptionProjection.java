package pl.michalperlak.querydsl;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
public class SubscriptionProjection {
    private final String subscriptionName;
    private final String username;
}
