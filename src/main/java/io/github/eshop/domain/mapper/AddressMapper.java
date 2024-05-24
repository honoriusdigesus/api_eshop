package io.github.eshop.domain.mapper;

import io.github.eshop.data.entity.Shipping_Address;
import io.github.eshop.domain.entity.AddressDomain;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
    public AddressDomain fromEntityToDomain(Shipping_Address address) {
        return new AddressDomain(address.getId(), address.getCountry(), address.getState(), address.getCity(), address.getAddress_line(), address.getUsers());
    }

    public Shipping_Address fromDomainToEntity(AddressDomain addressDomain) {
        return new Shipping_Address(addressDomain.getId(), addressDomain.getCountry(), addressDomain.getState(), addressDomain.getCity(), addressDomain.getAddress_line(), addressDomain.getUsers());
    }
}
