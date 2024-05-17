package io.github.eshop.persistence.controller;

import io.github.eshop.domain.caseuse.CreateAddressCaseUse;
import io.github.eshop.domain.mapper.AddressMapper;
import io.github.eshop.persistence.entity.AddressPersistence;
import io.github.eshop.persistence.mapper.AddressMapperPersistence;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final CreateAddressCaseUse createAddressCaseUse;
    private final AddressMapperPersistence addressMapper;

    public AddressController(CreateAddressCaseUse createAddressCaseUse, AddressMapperPersistence addressMapper) {
        this.createAddressCaseUse = createAddressCaseUse;
        this.addressMapper = addressMapper;
    }

    @PostMapping("/create")
    public void createAddress(@RequestBody AddressPersistence addressPersistence) {
        System.out.println(addressPersistence.getUsers());
        createAddressCaseUse.createAddress(addressMapper.fromPersistenceToDomain(addressPersistence));
    }
}
