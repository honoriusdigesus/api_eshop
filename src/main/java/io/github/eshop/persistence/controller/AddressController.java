package io.github.eshop.persistence.controller;

import io.github.eshop.domain.caseuse.CreateAddressCaseUse;
import io.github.eshop.domain.caseuse.UpdateShippingAddressCaseUse;
import io.github.eshop.domain.mapper.AddressMapper;
import io.github.eshop.persistence.entity.AddressPersistence;
import io.github.eshop.persistence.mapper.AddressMapperPersistence;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final CreateAddressCaseUse createAddressCaseUse;
    private final AddressMapperPersistence addressMapper;
    private final UpdateShippingAddressCaseUse updateShippingAddressCaseUse;

    public AddressController(CreateAddressCaseUse createAddressCaseUse, AddressMapperPersistence addressMapper, UpdateShippingAddressCaseUse updateShippingAddressCaseUse) {
        this.createAddressCaseUse = createAddressCaseUse;
        this.addressMapper = addressMapper;
        this.updateShippingAddressCaseUse = updateShippingAddressCaseUse;
    }

    @PostMapping("/create")
    public void createAddress(@RequestBody AddressPersistence addressPersistence) {
        System.out.println(addressPersistence.getUsers());
        createAddressCaseUse.createAddress(addressMapper.fromPersistenceToDomain(addressPersistence));
    }

    @PutMapping("/update/{cc}")
    public void updateAddress(@PathVariable BigDecimal cc, @RequestBody AddressPersistence addressPersistence) {
        updateShippingAddressCaseUse.updateShippingAddress(cc, addressMapper.fromPersistenceToDomain(addressPersistence));
    }
}
