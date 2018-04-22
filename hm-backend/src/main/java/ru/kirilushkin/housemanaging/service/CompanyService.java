package ru.kirilushkin.housemanaging.service;

import org.springframework.stereotype.Service;
import ru.kirilushkin.housemanaging.entity.Building;
import ru.kirilushkin.housemanaging.entity.Company;
import ru.kirilushkin.housemanaging.repository.CompanyRepository;

import java.util.Optional;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    private final BuildingService buildingService;


    public CompanyService(CompanyRepository companyRepository, BuildingService buildingService) {
        this.companyRepository = companyRepository;
        this.buildingService = buildingService;
    }

    public void create(Company company) {
        companyRepository.save(company);
    }

    public void addBuilding(int companyId, Building building) {
        Optional<Company> company = companyRepository.findById(companyId);
        building.setCompany(company.get());
        buildingService.addBuilding(building);
    }
}
