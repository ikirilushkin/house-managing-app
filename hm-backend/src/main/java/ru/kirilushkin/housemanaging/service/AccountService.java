package ru.kirilushkin.housemanaging.service;

import ru.kirilushkin.housemanaging.entity.Account;

public interface AccountService {
    Account getSettings();

    void updateSettings(Account account);
}
