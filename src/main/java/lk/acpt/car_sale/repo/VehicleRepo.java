package lk.acpt.car_sale.repo;


import lk.acpt.car_sale.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VehicleRepo extends JpaRepository<Vehicle,Integer> {

    List<Vehicle> findByBrand(String brand);
    List<Vehicle>  getVehicleByBrandAndModel (String brand, String model);

}
