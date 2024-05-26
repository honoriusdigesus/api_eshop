package io.github.eshop.persistence.mapper;

import io.github.eshop.domain.entity.UserDomain;
import io.github.eshop.persistence.entity.UserPersistence;
import org.springframework.stereotype.Component;

@Component
public class UserPersistenceMapper {
    public UserPersistence fromDomainToPersistence(UserDomain userDomain) {
        return new UserPersistence(
                userDomain.getId(),
                userDomain.getCc(),
                userDomain.getFirstname(),
                userDomain.getLastname(),
                userDomain.getEmail(),
                userDomain.getPassword(),
                userDomain.getRole());
    }

    public UserDomain fromPersistenceToDomain(UserPersistence userPersistence) {
        return new UserDomain(
                userPersistence.getId(),
                userPersistence.getCc(),
                userPersistence.getFirstname(),
                userPersistence.getLastname(),
                userPersistence.getEmail(),
                userPersistence.getPassword(),
                userPersistence.getRole());
    }
}
