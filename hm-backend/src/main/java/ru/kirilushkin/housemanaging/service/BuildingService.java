package ru.kirilushkin.housemanaging.service;

import org.springframework.stereotype.Service;
import ru.kirilushkin.housemanaging.entity.Apartment;
import ru.kirilushkin.housemanaging.entity.Building;
import ru.kirilushkin.housemanaging.repository.BuildingRepository;

@Service
public class BuildingService {

    private final BuildingRepository buildingRepository;

    private final ApartmentService apartmentService;

    public BuildingService(BuildingRepository buildingRepository, ApartmentService apartmentService) {
        this.buildingRepository = buildingRepository;
        this.apartmentService = apartmentService;
    }

    public Building addBuilding(Building building) {
        return buildingRepository.save(building);
    }

    public void addApartment(Building building, Apartment apartment) {
        apartment.setBuilding(building);
        apartmentService.addApartment(apartment);
    }
}
