package ru.kirilushkin.housemanaging.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kirilushkin.housemanaging.dto.RegistrationInfo;
import ru.kirilushkin.housemanaging.entity.Account;
import ru.kirilushkin.housemanaging.exception.RestValidationException;
import ru.kirilushkin.housemanaging.repository.AccountRepository;

import java.util.Arrays;
import java.util.Optional;

@Service
public class SignupServiceImpl implements SignupService {

    private static final Logger logger = LoggerFactory.getLogger(SignupServiceImpl.class);

    private final AccountRepository accountRepository;

    private final PasswordEncoder encoder;

    public SignupServiceImpl(AccountRepository accountRepository, PasswordEncoder encoder) {
        this.accountRepository = accountRepository;
        this.encoder = encoder;
    }

    @Override
    public void signup(RegistrationInfo registrationInfo) {
        Optional<Account> account = accountRepository.findAccountByUsername(registrationInfo.getLogin());
        if (account.isPresent()) {
            logger.warn("Unable to sign up: " + registrationInfo.getLogin() + " already in use");
            throw new RestValidationException("validation.error.signup.login.unique", "login");
        }

        Account newAccount = new Account(
                registrationInfo.getLogin(),
                encoder.encode(registrationInfo.getPassword()),
                Arrays.asList(
                        new SimpleGrantedAuthority("VIEW"),
                        new SimpleGrantedAuthority("EDIT"),
                        new SimpleGrantedAuthority("MANAGER")
                )
        );
        accountRepository.save(newAccount);
    }
}
