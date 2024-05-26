package io.github.eshop.domain.caseuse;

import io.github.eshop.data.repository.UserRepository;
import io.github.eshop.domain.exception.UserNotFoundException;
import io.github.eshop.domain.mapper.UserDomainMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.BigInteger;

@Component
public class DeleteUserCaseUse {
    private final UserRepository userRepository;
    private final FindUserByCcCaseUse findUserByCcCaseUse;
    private final UserDomainMapper userMapper;

    public DeleteUserCaseUse(UserRepository userRepository, FindUserByCcCaseUse findUserByCcCaseUse, UserDomainMapper userMapper) {
        this.userRepository = userRepository;
        this.findUserByCcCaseUse = findUserByCcCaseUse;
        this.userMapper = userMapper;
    }

    public void deleteUser(BigInteger cc) {
        var user = findUserByCcCaseUse.findUserByCc(cc);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        userRepository.delete(userMapper.fromDomainToEntity(user));
    }
}
