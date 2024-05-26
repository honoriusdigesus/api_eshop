package io.github.eshop.persistence.controller;

import io.github.eshop.domain.caseuse.CreateAddressCaseUse;
import io.github.eshop.domain.caseuse.DeleteShippingAddressCaseUse;
import io.github.eshop.domain.caseuse.GetAllShippingAddressCaseUse;
import io.github.eshop.domain.caseuse.UpdateShippingAddressCaseUse;
import io.github.eshop.persistence.entity.AddressPersistence;
import io.github.eshop.persistence.mapper.AddressPersistenceMapper;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final CreateAddressCaseUse createAddressCaseUse;
    private final AddressPersistenceMapper addressMapper;
    private final UpdateShippingAddressCaseUse updateShippingAddressCaseUse;
    private final DeleteShippingAddressCaseUse deleteShippingAddressCaseUse;
    private final GetAllShippingAddressCaseUse getAllShippingAddressCaseUse;


    public AddressController(CreateAddressCaseUse createAddressCaseUse, AddressPersistenceMapper addressMapper, UpdateShippingAddressCaseUse updateShippingAddressCaseUse, DeleteShippingAddressCaseUse deleteShippingAddressCaseUse, GetAllShippingAddressCaseUse getAllShippingAddressCaseUse) {
        this.createAddressCaseUse = createAddressCaseUse;
        this.addressMapper = addressMapper;
        this.updateShippingAddressCaseUse = updateShippingAddressCaseUse;
        this.deleteShippingAddressCaseUse = deleteShippingAddressCaseUse;
        this.getAllShippingAddressCaseUse = getAllShippingAddressCaseUse;
    }

    @PostMapping("/create")
    public void createAddress(@RequestBody AddressPersistence addressPersistence) {
        System.out.println(addressPersistence.getUsers());
        createAddressCaseUse.createAddress(addressMapper.fromPersistenceToDomain(addressPersistence));
    }

    @PutMapping("/update/{cc}")
    public void updateAddress(@PathVariable BigInteger cc, @RequestBody AddressPersistence addressPersistence) {
        updateShippingAddressCaseUse.updateShippingAddress(cc, addressMapper.fromPersistenceToDomain(addressPersistence));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAddress(@PathVariable Integer id) {
        deleteShippingAddressCaseUse.deleteShippingAddress(id);
    }

    @GetMapping("/all")
    public List<AddressPersistence> getAllAddresses() {
        return getAllShippingAddressCaseUse.getAllShippingAddress().stream().map(addressMapper::fromDomainToPersistence).collect(Collectors.toList());
    }

}
