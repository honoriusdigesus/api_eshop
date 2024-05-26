package io.github.eshop.domain.caseuse;

import io.github.eshop.data.entity.Shipping_Address;
import io.github.eshop.data.repository.ShippingAddressRepository;
import io.github.eshop.domain.entity.AddressDomain;
import io.github.eshop.domain.exception.UserNotFoundException;
import io.github.eshop.domain.mapper.AddressDomainMapper;
import io.github.eshop.domain.mapper.UserDomainMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.BigInteger;

@Component
public class UpdateShippingAddressCaseUse {
    private final ShippingAddressRepository addressRepository;
    private final AddressDomainMapper addressMapper;
    private final UpdateUserCaseUse updateUserCaseUse;
    private final FindUserByCcCaseUse findUserByCcCaseUse;
    private final UserDomainMapper userMapper;

    public UpdateShippingAddressCaseUse(ShippingAddressRepository addressRepository, AddressDomainMapper addressMapper, UpdateUserCaseUse updateUserCaseUse, FindUserByCcCaseUse findUserByCcCaseUse, UserDomainMapper userMapper) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
        this.updateUserCaseUse = updateUserCaseUse;
        this.findUserByCcCaseUse = findUserByCcCaseUse;
        this.userMapper = userMapper;
    }

    public void updateShippingAddress(BigInteger cc, AddressDomain newAddressDomain) {
        var existingAddress = addressRepository.findShippingAddressesByCC(cc);
        var user = findUserByCcCaseUse.findUserByCc(cc);
        if (existingAddress == null || user == null) {
            throw new UserNotFoundException("The unregistered user and/or without address");
        }

        user.setCc(newAddressDomain.getUsers().getCc());
        user.setFirstname(newAddressDomain.getUsers().getFirstname());
        user.setLastname(newAddressDomain.getUsers().getLastname());
        user.setEmail(newAddressDomain.getUsers().getEmail());
        user.setPassword(newAddressDomain.getUsers().getPassword());
        user.setRole(newAddressDomain.getUsers().getRole());

        Shipping_Address updatedAddress = addressMapper.fromDomainToEntity(newAddressDomain);
        existingAddress.setCountry(updatedAddress.getCountry());
        existingAddress.setState(updatedAddress.getState());
        existingAddress.setCity(updatedAddress.getCity());
        existingAddress.setAddress_line(updatedAddress.getAddress_line());
        existingAddress.setUsers(userMapper.fromDomainToEntity(user));

        updateUserCaseUse.updateUser(cc, user);
        addressRepository.save(existingAddress);
    }
}
