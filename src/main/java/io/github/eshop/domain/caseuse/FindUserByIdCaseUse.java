package io.github.eshop.domain.caseuse;

import io.github.eshop.data.repository.UserRepository;
import io.github.eshop.domain.entity.UserDomain;
import io.github.eshop.domain.mapper.UserDomainMapper;
import org.springframework.stereotype.Component;

@Component
public class FindUserByIdCaseUse {

    private final UserRepository userRepository;
    private final UserDomainMapper userMapper;

    public FindUserByIdCaseUse(UserRepository userRepository, UserDomainMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDomain findUserById(Integer id) {
        return userMapper.fromEntityToDomain(userRepository.findById(id).orElseThrow());
    }
}
