package io.github.eshop.persistence.controller;

import io.github.eshop.domain.caseuse.CreateUserCaseUse;
import io.github.eshop.domain.caseuse.FindUserByCcCaseUse;
import io.github.eshop.persistence.entity.UserPersistence;
import io.github.eshop.persistence.mapper.UserMapperPersistence;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("user")
public class UserController {

    private final CreateUserCaseUse createUserCaseUse;
    private final UserMapperPersistence userMapperPersistence;
    private final FindUserByCcCaseUse findUserByCcCaseUse;

    public UserController(CreateUserCaseUse createUserCaseUse, UserMapperPersistence userMapperPersistence, FindUserByCcCaseUse findUserByCcCaseUse) {
        this.createUserCaseUse = createUserCaseUse;
        this.userMapperPersistence = userMapperPersistence;
        this.findUserByCcCaseUse = findUserByCcCaseUse;
    }

    @PostMapping("/create")
    public void createUser(@RequestBody UserPersistence userPersistence) {
        createUserCaseUse.createUser(userMapperPersistence.fromPersistenceToDomain(userPersistence));
    }

    @GetMapping("/find/{cc}")
    public UserPersistence getUserByCc(@PathVariable BigDecimal cc) {
        return userMapperPersistence.fromDomainToPersistence(findUserByCcCaseUse.findUserByCc(cc));
    }
}
