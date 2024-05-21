package io.github.eshop.domain.caseuse;

import io.github.eshop.data.repository.ShippingAddressRepository;
import org.springframework.stereotype.Component;

@Component
public class DeleteShippingAddressCaseUse {
    private final ShippingAddressRepository addressRepository;

    public DeleteShippingAddressCaseUse(ShippingAddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public void deleteShippingAddress(Integer id) {
        addressRepository.deleteById(id);
    }
}
