package ru.kirilushkin.housemanaging.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kirilushkin.housemanaging.dto.RegistrationInfo;
import ru.kirilushkin.housemanaging.entity.Account;
import ru.kirilushkin.housemanaging.entity.Manager;
import ru.kirilushkin.housemanaging.enums.UserType;
import ru.kirilushkin.housemanaging.exception.RestValidationException;
import ru.kirilushkin.housemanaging.repository.AccountRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class SignupServiceImpl implements SignupService {

    private static final Logger logger = LoggerFactory.getLogger(SignupServiceImpl.class);

    private final AccountRepository accountRepository;

    private final PasswordEncoder encoder;

    private final ManagerService managerService;

    public SignupServiceImpl(AccountRepository accountRepository, PasswordEncoder encoder, ManagerService managerService) {
        this.accountRepository = accountRepository;
        this.encoder = encoder;
        this.managerService = managerService;
    }

    @Override
    public void signup(RegistrationInfo registrationInfo, String type) {
        UserType userType = type != null ? UserType.getByType(type) : UserType.OWNER;
        Optional<Account> account = accountRepository.findAccountByUsername(registrationInfo.getLogin());
        if (account.isPresent()) {
            logger.warn("Unable to sign up: " + registrationInfo.getLogin() + " already in use");
            throw new RestValidationException("validation.error.signup.login.unique", "login");
        }

        Account newAccount = createAccount(registrationInfo, userType);
        Account createdAccount = accountRepository.save(newAccount);
        createManager(userType, createdAccount);
    }

    private Account createAccount(RegistrationInfo registrationInfo, UserType userType) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.addAll(Arrays.asList(
                new SimpleGrantedAuthority("VIEW"),
                new SimpleGrantedAuthority("EDIT")
        ));
        if (UserType.MANAGER.equals(userType)) {
            authorities.add(
                    new SimpleGrantedAuthority("MANAGER")
            );
        }
        return new Account(
                registrationInfo.getLogin(),
                encoder.encode(registrationInfo.getPassword()),
                authorities
        );
    }

    private void createManager(UserType userType, Account createdAccount) {
        if (UserType.MANAGER.equals(userType)) {
            managerService.save(new Manager(createdAccount));
        }
    }
}
