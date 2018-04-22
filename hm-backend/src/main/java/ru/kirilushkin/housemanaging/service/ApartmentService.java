package ru.kirilushkin.housemanaging.service;

import org.springframework.stereotype.Service;
import ru.kirilushkin.housemanaging.entity.Apartment;
import ru.kirilushkin.housemanaging.repository.ApartmentRepository;

@Service
public class ApartmentService {

    private final ApartmentRepository apartmentRepository;

    public ApartmentService(ApartmentRepository apartmentRepository) {
        this.apartmentRepository = apartmentRepository;
    }

    public void addApartment(Apartment apartment) {
        apartmentRepository.save(apartment);
    }
}
