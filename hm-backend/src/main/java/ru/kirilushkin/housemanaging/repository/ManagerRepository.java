package ru.kirilushkin.housemanaging.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kirilushkin.housemanaging.entity.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Integer> {
}
