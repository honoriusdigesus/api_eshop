package io.github.eshop.domain.caseuse;

import io.github.eshop.data.repository.ShippingAddressRepository;
import io.github.eshop.domain.entity.AddressDomain;
import io.github.eshop.domain.mapper.AddressMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetAllShippingAddressCaseUse {
    private final ShippingAddressRepository addressRepository;
    private final AddressMapper addressMapper;

    public GetAllShippingAddressCaseUse(ShippingAddressRepository addressRepository, AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    public List<AddressDomain> getAllShippingAddress() {
        return addressRepository.findAll().stream().map(addressMapper::fromEntityToDomain).collect(Collectors.toList());
    }
}
