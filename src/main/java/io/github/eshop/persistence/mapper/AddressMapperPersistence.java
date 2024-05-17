package io.github.eshop.persistence.mapper;

import io.github.eshop.domain.entity.AddressDomain;
import io.github.eshop.persistence.entity.AddressPersistence;
import org.springframework.stereotype.Component;

@Component
public class AddressMapperPersistence {

    public AddressPersistence fromDomainToPersistence(AddressDomain addressDomain) {
        AddressPersistence addressPersistence = new AddressPersistence();
        addressPersistence.setCountry(addressDomain.getCountry());
        addressPersistence.setState(addressDomain.getState());
        addressPersistence.setCity(addressDomain.getCity());
        addressPersistence.setAddress_line(addressDomain.getAddress_line());
        addressPersistence.setUsers(addressDomain.getUsers());
        return addressPersistence;
    }

    public AddressDomain fromPersistenceToDomain(AddressPersistence addressPersistence) {
        AddressDomain addressDomain = new AddressDomain();
        addressDomain.setCountry(addressPersistence.getCountry());
        addressDomain.setState(addressPersistence.getState());
        addressDomain.setCity(addressPersistence.getCity());
        addressDomain.setAddress_line(addressPersistence.getAddress_line());
        addressDomain.setUsers(addressPersistence.getUsers());
        return addressDomain;
    }
}
