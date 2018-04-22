package ru.kirilushkin.housemanaging.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Apartment {

    @Id
    @GeneratedValue
    private int id;

    private int number;

    private int roomsCount;

    private int floor;

    private int entrance;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="building_id")
    private Building building;

    public Apartment(int number, int roomsCount, int floor, int entrance) {
        this.number = number;
        this.roomsCount = roomsCount;
        this.floor = floor;
        this.entrance = entrance;
    }
}
