package io.github.eshop.persistence.mapper;

import io.github.eshop.domain.entity.AddressDomain;
import io.github.eshop.persistence.entity.AddressPersistence;
import org.springframework.stereotype.Component;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

@Component
public class AddressPersistenceMapper {
    private final UserPersistenceMapper userPersistenceMapper;

    public AddressPersistenceMapper(UserPersistenceMapper userPersistenceMapper) {
        this.userPersistenceMapper = userPersistenceMapper;
    }

    public AddressPersistence fromDomainToPersistence(AddressDomain addressDomain) {
        return new AddressPersistence(
                addressDomain.getId(),
                addressDomain.getCountry(),
                addressDomain.getState(),
                addressDomain.getCity(),
                addressDomain.getAddress_line(),
                userPersistenceMapper.fromDomainToPersistence(addressDomain.getUsers())
        );
    }

    public AddressDomain fromPersistenceToDomain(AddressPersistence addressPersistence) {
        return new AddressDomain(
                addressPersistence.getId(),
                addressPersistence.getCountry(),
                addressPersistence.getState(),
                addressPersistence.getCity(),
                addressPersistence.getAddress_line(),
                userPersistenceMapper.fromPersistenceToDomain(addressPersistence.getUsers())
        );
    }
}
