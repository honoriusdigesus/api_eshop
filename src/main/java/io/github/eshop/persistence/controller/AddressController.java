package io.github.eshop.persistence.controller;

import io.github.eshop.domain.caseuse.CreateAddressCaseUse;
import io.github.eshop.domain.caseuse.DeleteShippingAddressCaseUse;
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
    private final DeleteShippingAddressCaseUse deleteShippingAddressCaseUse;

    public AddressController(CreateAddressCaseUse createAddressCaseUse, AddressMapperPersistence addressMapper, UpdateShippingAddressCaseUse updateShippingAddressCaseUse, DeleteShippingAddressCaseUse deleteShippingAddressCaseUse) {
        this.createAddressCaseUse = createAddressCaseUse;
        this.addressMapper = addressMapper;
        this.updateShippingAddressCaseUse = updateShippingAddressCaseUse;
        this.deleteShippingAddressCaseUse = deleteShippingAddressCaseUse;
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

    @DeleteMapping("/delete/{id}")
    public void deleteAddress(@PathVariable Integer id) {
        deleteShippingAddressCaseUse.deleteShippingAddress(id);
    }

}
