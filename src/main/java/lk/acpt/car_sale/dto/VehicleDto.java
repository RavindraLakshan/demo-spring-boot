package lk.acpt.car_sale.dto;


import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lk.acpt.car_sale.entity.SpareParts;
import lk.acpt.car_sale.entity.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDto {

    private Integer id;
    private String Brand;
    private String Model;
    private double engineCap;
    private int noOfGear;

    public VehicleDto(String brand) {
        Brand = brand;
    }

}
