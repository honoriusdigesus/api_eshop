package io.github.eshop.domain.caseuse;

import io.github.eshop.data.entity.User;
import io.github.eshop.data.repository.UserRepository;
import io.github.eshop.domain.entity.UserDomain;
import io.github.eshop.domain.exception.UserNotFoundException;
import io.github.eshop.domain.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class FindUserByCcCaseUse {
    private final UserRepository userRepository;
    private UserMapper userMapper;

    public FindUserByCcCaseUse(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDomain findUserByCc(BigDecimal cc) {
        var user = userRepository.findUserByCC(cc);
        if (user == null) {
            throw new UserNotFoundException("No user found with cc: " + cc);
        }
        return userMapper.fromEntityToDomain(user);
    }
}
