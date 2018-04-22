package ru.kirilushkin.housemanaging.service;

import org.springframework.stereotype.Service;
import ru.kirilushkin.housemanaging.entity.Manager;
import ru.kirilushkin.housemanaging.repository.ManagerRepository;

@Service
public class ManagerService {

    private final ManagerRepository managerRepository;

    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    public Manager save(Manager manager) {
        return managerRepository.save(manager);
    }
}
