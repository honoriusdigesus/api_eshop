package io.github.eshop.domain.caseuse;

import io.github.eshop.data.repository.UserRepository;
import io.github.eshop.domain.entity.UserDomain;
import io.github.eshop.domain.exception.UserNotFoundException;
import io.github.eshop.domain.mapper.UserDomainMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.BigInteger;

@Component
public class FindUserByCcCaseUse {
    private final UserRepository userRepository;
    private UserDomainMapper userMapper;

    public FindUserByCcCaseUse(UserRepository userRepository, UserDomainMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDomain findUserByCc(BigInteger cc) {
        var user = userRepository.findUserByCC(cc);
        if (user == null) {
            throw new UserNotFoundException("No user found with cc: " + cc);
        }
        return userMapper.fromEntityToDomain(user);
    }
}
