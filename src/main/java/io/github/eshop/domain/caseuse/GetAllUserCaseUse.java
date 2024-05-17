package io.github.eshop.domain.caseuse;

import io.github.eshop.data.repository.UserRepository;
import io.github.eshop.domain.entity.UserDomain;
import io.github.eshop.domain.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetAllUserCaseUse {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public GetAllUserCaseUse(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserDomain> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::fromEntityToDomain).collect(Collectors.toList());
    }
}
