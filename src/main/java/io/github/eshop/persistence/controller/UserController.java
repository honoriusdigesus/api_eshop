package io.github.eshop.persistence.controller;

import io.github.eshop.domain.caseuse.CreateUserCaseUse;
import io.github.eshop.persistence.entity.UserPersistence;
import io.github.eshop.persistence.mapper.UserMapperPersistence;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    private final CreateUserCaseUse createUserCaseUse;
    private final UserMapperPersistence userMapperPersistence;

    public UserController(CreateUserCaseUse createUserCaseUse, UserMapperPersistence userMapperPersistence) {
        this.createUserCaseUse = createUserCaseUse;
        this.userMapperPersistence = userMapperPersistence;
    }

    @PostMapping("/create")
    public void createUser(@RequestBody UserPersistence userPersistence) {
        createUserCaseUse.createUser(userMapperPersistence.fromPersistenceToDomain(userPersistence));
    }
}
