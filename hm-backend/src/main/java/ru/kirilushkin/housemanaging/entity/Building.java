package ru.kirilushkin.housemanaging.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Building {

    @Id
    @GeneratedValue
    private int id;

    private String address;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="company_id")
    private Company company;

    public Building(String address) {
        this.address = address;
    }
}
