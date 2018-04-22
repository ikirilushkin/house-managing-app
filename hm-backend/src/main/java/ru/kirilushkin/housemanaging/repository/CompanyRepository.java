package ru.kirilushkin.housemanaging.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kirilushkin.housemanaging.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
}
