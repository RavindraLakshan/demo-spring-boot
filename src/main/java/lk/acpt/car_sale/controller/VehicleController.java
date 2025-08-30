package lk.acpt.car_sale.controller;

import lk.acpt.car_sale.dto.SparepartDto;
import lk.acpt.car_sale.dto.VehicleDto;
import lk.acpt.car_sale.dto.VehicleWithSpareDto;
import lk.acpt.car_sale.entity.Vehicle;
import lk.acpt.car_sale.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicle")
public class VehicleController {

    VehicleService vehicleService ;


    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public ResponseEntity<VehicleDto> saveVehicle(@RequestBody VehicleDto vehicleDto) {
        VehicleDto saveDto1 = vehicleService.saveVehicle(vehicleDto);
        return new ResponseEntity<>(saveDto1, HttpStatus.CREATED);

    }
    @GetMapping
    public void getAllVehicle() {

    }

    @DeleteMapping("{id}")
    public void deleteVehicle(@PathVariable Integer id) {

    }


    @PutMapping("{id}")
    public void updateVehicle(@PathVariable Integer id, @RequestBody VehicleDto vehicleDto) {
        vehicleDto.setId(id);
        vehicleService.updateVehicle(vehicleDto);
    }


    @GetMapping("/get_by_id")
    public void getVehicleById() {

    }

    @PostMapping()
    public ResponseEntity<SparepartDto> saveVwithSPart(@RequestBody SparepartDto sparepartDto) {

        SparepartDto sparepartDto1 = vehicleService.saveSparepart(sparepartDto);
        return new ResponseEntity<>(sparepartDto1, HttpStatus.CREATED);
    }

    @GetMapping("/get_by_brand/{brand}")
    public  ResponseEntity<List<VehicleDto>>  getVehicleByBrand(@PathVariable String brand) {
        List<VehicleDto> byBrand = vehicleService.getByBrand(brand);
        return new ResponseEntity<>(byBrand, HttpStatus.CREATED);

    }

    @GetMapping("/brand/{brand}/model/{model}")
    public ResponseEntity<List<VehicleDto>> getAllByBrandAndModel(@PathVariable String brand,@PathVariable String model) {
        List<VehicleDto> allByBrandAndModel = vehicleService.getAllByBrandAndModel(brand, model);
        return ResponseEntity.ok(allByBrandAndModel);
    }
    @PostMapping("/save_with_spare_parts/")
    public ResponseEntity<VehicleWithSpareDto> VehicleWithSpare(@RequestBody VehicleWithSpareDto vehicleWithSpareDto) {
        VehicleWithSpareDto saved = vehicleService.saveWithSpare(vehicleWithSpareDto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);

    }


}
