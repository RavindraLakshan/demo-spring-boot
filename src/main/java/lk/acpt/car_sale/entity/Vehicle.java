package lk.acpt.car_sale.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY ) //AUTO

    

    public Vehicle(Integer id, String brand, String model, double engineCap, int noOfGear) {
        this.id = id;
        this.Brand = brand;
        this.Model = model;
        this.engineCap = engineCap;
        this.noOfGear = noOfGear;
    }

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "vehicle")
    List<SpareParts> sparePart;
}
