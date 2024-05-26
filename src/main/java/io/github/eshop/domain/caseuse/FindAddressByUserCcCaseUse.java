package io.github.eshop.domain.caseuse;

import io.github.eshop.data.repository.ShippingAddressRepository;
import io.github.eshop.domain.entity.AddressDomain;
import io.github.eshop.domain.mapper.AddressDomainMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.BigInteger;

@Component
public class FindAddressByUserCcCaseUse {
    private final ShippingAddressRepository shippingAddressRepository;
    private final AddressDomainMapper addressMapper;

    public FindAddressByUserCcCaseUse(ShippingAddressRepository shippingAddressRepository, AddressDomainMapper addressMapper) {
        this.shippingAddressRepository = shippingAddressRepository;
        this.addressMapper = addressMapper;
    }

    public AddressDomain findAddressByCc(BigInteger cc) {
        return addressMapper.fromEntityToDomain(shippingAddressRepository.findShippingAddressesByCC(cc));
    }
}
