package io.github.eshop.persistence.controller;

import io.github.eshop.domain.caseuse.*;
import io.github.eshop.persistence.entity.UserPersistence;
import io.github.eshop.persistence.mapper.UserMapperPersistence;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("user")
public class UserController {

    private final CreateUserCaseUse createUserCaseUse;
    private final UserMapperPersistence userMapperPersistence;
    private final FindUserByCcCaseUse findUserByCcCaseUse;
    private final GetAllUserCaseUse getAllUserCaseUse;
    private final UpdateUserCaseUse updateUserCaseUse;
    private final DeleteUserCaseUse deleteUserCaseUse;

    public UserController(CreateUserCaseUse createUserCaseUse, UserMapperPersistence userMapperPersistence, FindUserByCcCaseUse findUserByCcCaseUse, GetAllUserCaseUse getAllUserCaseUse, UpdateUserCaseUse updateUserCaseUse, DeleteUserCaseUse deleteUserCaseUse) {
        this.createUserCaseUse = createUserCaseUse;
        this.userMapperPersistence = userMapperPersistence;
        this.findUserByCcCaseUse = findUserByCcCaseUse;
        this.getAllUserCaseUse = getAllUserCaseUse;
        this.updateUserCaseUse = updateUserCaseUse;
        this.deleteUserCaseUse = deleteUserCaseUse;
    }

    @PostMapping("/create")
    public void createUser(@RequestBody UserPersistence userPersistence) {
        createUserCaseUse.createUser(userMapperPersistence.fromPersistenceToDomain(userPersistence));
    }

    @GetMapping("/find/{cc}")
    public UserPersistence getUserByCc(@PathVariable BigDecimal cc) {
        return userMapperPersistence.fromDomainToPersistence(findUserByCcCaseUse.findUserByCc(cc));
    }

    @GetMapping("/all")
    public List<UserPersistence> getAllUsers() {
        return getAllUserCaseUse.getAllUsers().stream().map(userMapperPersistence::fromDomainToPersistence).collect(Collectors.toList());
    }

    @PutMapping("/update/{cc}")
    public void updateUser(@PathVariable BigDecimal cc, @RequestBody UserPersistence userPersistence) {
        updateUserCaseUse.updateUser(cc, userMapperPersistence.fromPersistenceToDomain(userPersistence));
    }

    @DeleteMapping("/delete/{cc}")
    public void deleteUser(@PathVariable BigDecimal cc) {
        deleteUserCaseUse.deleteUser(cc);
    }
}
