package io.github.eshop.domain.mapper;

import io.github.eshop.data.entity.User;
import io.github.eshop.domain.entity.UserDomain;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User fromDomainToEntity(UserDomain userDomain) {
        User user = new User();
        user.setId(userDomain.getId());
        user.setCc(userDomain.getCc());
        user.setFirstname(userDomain.getFirstname());
        user.setLastname(userDomain.getLastname());
        user.setEmail(userDomain.getEmail());
        user.setPassword(userDomain.getPassword());
        user.setRole(userDomain.getRole());
        return user;
    }

    public UserDomain fromEntityToDomain(User user) {
        UserDomain userDomain = new UserDomain();
        userDomain.setId(user.getId());
        userDomain.setCc(user.getCc());
        userDomain.setFirstname(user.getFirstname());
        userDomain.setLastname(user.getLastname());
        userDomain.setEmail(user.getEmail());
        userDomain.setPassword(user.getPassword());
        userDomain.setRole(user.getRole());
        return userDomain;
    }
}
