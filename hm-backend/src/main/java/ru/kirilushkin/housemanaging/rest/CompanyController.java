package ru.kirilushkin.housemanaging.rest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kirilushkin.housemanaging.entity.Building;
import ru.kirilushkin.housemanaging.entity.Company;
import ru.kirilushkin.housemanaging.service.CompanyService;

@RestController("api/company")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('MANAGER')")
    public void add(Company company) {
        companyService.create(company);
    }

    @PostMapping("/{companyId}/building")
    public void addBuilding(@PathVariable int companyId, Building building) {
        companyService.addBuilding(companyId, building);
    }
}
