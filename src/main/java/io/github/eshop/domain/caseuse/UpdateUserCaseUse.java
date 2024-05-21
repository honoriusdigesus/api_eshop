package io.github.eshop.domain.caseuse;

import io.github.eshop.data.repository.UserRepository;
import io.github.eshop.domain.entity.UserDomain;
import io.github.eshop.domain.exception.UserNotFoundException;
import io.github.eshop.domain.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class UpdateUserCaseUse {
    private final FindUserByCcCaseUse findUserByCcCaseUse;
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UpdateUserCaseUse(FindUserByCcCaseUse findUserByCcCaseUse, UserMapper userMapper, UserRepository userRepository) {
        this.findUserByCcCaseUse = findUserByCcCaseUse;
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }


    public void updateUser(BigDecimal cc, UserDomain userUpdate) {
        UserDomain user = findUserByCcCaseUse.findUserByCc(cc);
        System.out.printf("Usuario encontrado: "+user.toString());
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        user.setId(user.getId());
        System.out.printf("ID actualizado: "+user.getId()+"\n");
        user.setCc(userUpdate.getCc());
        user.setFirstname(userUpdate.getFirstname());
        user.setLastname(userUpdate.getLastname());
        user.setEmail(userUpdate.getEmail());
        user.setPassword(userUpdate.getPassword());
        user.setRole(userUpdate.getRole());
        System.out.printf("Usuario actualizado: "+user);
        userRepository.save(userMapper.fromDomainToEntity(user));
    }
}
