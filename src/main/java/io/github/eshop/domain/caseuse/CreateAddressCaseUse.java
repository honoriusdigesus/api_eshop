package io.github.eshop.domain.caseuse;

import io.github.eshop.data.repository.AddressRepository;
import io.github.eshop.domain.entity.AddressDomain;
import io.github.eshop.domain.mapper.AddressMapper;
import org.springframework.stereotype.Component;

@Component
public class CreateAddressCaseUse {
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    public CreateAddressCaseUse(AddressRepository addressRepository, AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    public void createAddress(AddressDomain addressDomain) {
        addressRepository.save(addressMapper.fromDomainToEntity(addressDomain));
    }
}
