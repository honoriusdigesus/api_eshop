package io.github.eshop.domain.caseuse;

import io.github.eshop.data.repository.UserRepository;
import io.github.eshop.domain.entity.UserDomain;
import io.github.eshop.domain.exception.InvalidUserException;
import io.github.eshop.domain.mapper.UserMapper;
import io.github.eshop.utils.Validator;
import org.springframework.stereotype.Component;

@Component
public class CreateUserCaseUse {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final Validator validator;

    public CreateUserCaseUse(UserRepository userRepository, UserMapper userMapper, Validator validator) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.validator = validator;
    }

    public void createUser(UserDomain userDomain) {
        if (validator.validateUser(userDomain)==false) {
            throw new InvalidUserException("The user is not valid");
        }
        userRepository.save(userMapper.fromDomainToEntity(userDomain));
    }
}
