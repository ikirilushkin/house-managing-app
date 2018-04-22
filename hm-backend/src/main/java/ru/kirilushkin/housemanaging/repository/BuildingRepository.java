package ru.kirilushkin.housemanaging.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kirilushkin.housemanaging.entity.Building;

public interface BuildingRepository extends JpaRepository<Building, Integer> {
}
