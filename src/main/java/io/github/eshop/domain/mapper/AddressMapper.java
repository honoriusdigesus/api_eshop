package io.github.eshop.domain.mapper;

import io.github.eshop.data.entity.Address;
import io.github.eshop.domain.entity.AddressDomain;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
    public AddressDomain fromEntityToDomain(Address address) {
        AddressDomain addressDomain = new AddressDomain();
        addressDomain.setCountry(address.getCountry());
        addressDomain.setState(address.getState());
        addressDomain.setCity(address.getCity());
        addressDomain.setAddress_line(address.getAddress_line());
        addressDomain.setUsers(address.getUsers());
        return addressDomain;
    }

    public Address fromDomainToEntity(AddressDomain addressDomain) {
        Address address = new Address();
        address.setCountry(addressDomain.getCountry());
        address.setState(addressDomain.getState());
        address.setCity(addressDomain.getCity());
        address.setAddress_line(addressDomain.getAddress_line());
        address.setUsers(addressDomain.getUsers());
        return address;
    }
}
