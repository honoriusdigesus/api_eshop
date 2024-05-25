package io.github.eshop.domain.caseuse;

import io.github.eshop.data.repository.UserRepository;
import io.github.eshop.domain.entity.UserDomain;
import io.github.eshop.domain.mapper.UserMapper;
import org.springframework.stereotype.Component;

@Component
public class FindUserByIdCaseUse {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public FindUserByIdCaseUse(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDomain findUserById(Integer id) {
        return userMapper.fromEntityToDomain(userRepository.findById(id).orElseThrow());
    }
}
