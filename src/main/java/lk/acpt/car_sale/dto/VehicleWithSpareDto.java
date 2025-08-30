package lk.acpt.car_sale.dto;

import lk.acpt.car_sale.entity.SpareParts;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleWithSpareDto {
    private Integer id;
    private String Brand;
    private String Model;
    private double engineCap;
    private int noOfGear;
    private List<SpareParts> sparePart;
}
