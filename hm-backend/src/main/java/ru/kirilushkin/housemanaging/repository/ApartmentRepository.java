package ru.kirilushkin.housemanaging.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kirilushkin.housemanaging.entity.Apartment;

public interface ApartmentRepository extends JpaRepository<Apartment, Integer> {
}
