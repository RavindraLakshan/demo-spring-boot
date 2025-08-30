package lk.acpt.car_sale.service;

import lk.acpt.car_sale.dto.SparepartDto;
import lk.acpt.car_sale.dto.VehicleDto;
import lk.acpt.car_sale.dto.VehicleWithSpareDto;
import lk.acpt.car_sale.entity.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehicleService {
    VehicleDto saveVehicle(VehicleDto vehicleDto);
    VehicleDto updateVehicle(VehicleDto vehicleDto);

    VehicleDto deleteVehicle(int id);
    List<VehicleDto> getAllVehicles();
    VehicleDto getVehicle(int id);
    SparepartDto saveSparepart(SparepartDto sparepartDto);
    List<VehicleDto> getByBrand(String brand);
    List<VehicleDto> getAllByBrandAndModel(String brand , String model);
    VehicleWithSpareDto saveWithSpare(VehicleWithSpareDto vehicleWithSpareDto);
}

