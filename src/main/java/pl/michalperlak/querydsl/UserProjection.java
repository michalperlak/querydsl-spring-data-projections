package pl.michalperlak.querydsl;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserProjection {
    private final Long id;
    private final String username;
}
