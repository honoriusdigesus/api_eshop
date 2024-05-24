package io.github.eshop.domain.mapper;

import io.github.eshop.data.entity.User;
import io.github.eshop.domain.entity.UserDomain;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User fromDomainToEntity(UserDomain userDomain) {
return new User(
                userDomain.getId(),
                userDomain.getCc(),
                userDomain.getFirstname(),
                userDomain.getLastname(),
                userDomain.getEmail(),
                userDomain.getPassword(),
                userDomain.getRole());
    }

    public UserDomain fromEntityToDomain(User user) {
        return new UserDomain(
                user.getId(),
                user.getCc(),
                user.getFirstname(),
                user.getLastname(),
                user.getEmail(),
                user.getPassword(),
                user.getRole());
    }
}
