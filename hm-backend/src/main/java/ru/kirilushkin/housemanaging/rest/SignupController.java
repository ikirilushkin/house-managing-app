package ru.kirilushkin.housemanaging.rest;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import ru.kirilushkin.housemanaging.dto.RegistrationInfo;
import ru.kirilushkin.housemanaging.service.SignupService;

import javax.validation.Valid;

@RestController
@RequestMapping("/signup")
public class SignupController {

    private final SignupService signupService;

    public SignupController(SignupService signupService) {
        this.signupService = signupService;
    }

    @PostMapping
    @ApiOperation("Sign up new user")
    public void signup(@RequestBody @Valid RegistrationInfo registrationInfo, @RequestParam(required = false) String type) {
        signupService.signup(registrationInfo, type);
    }
}
