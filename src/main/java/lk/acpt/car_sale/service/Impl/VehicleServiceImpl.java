package lk.acpt.car_sale.service.Impl;

import lk.acpt.car_sale.dto.SparepartDto;
import lk.acpt.car_sale.dto.VehicleDto;
import lk.acpt.car_sale.dto.VehicleWithSpareDto;
import lk.acpt.car_sale.entity.SpareParts;
import lk.acpt.car_sale.entity.Vehicle;
import lk.acpt.car_sale.repo.SpareRepo;
import lk.acpt.car_sale.repo.VehicleRepo;
import lk.acpt.car_sale.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class VehicleServiceImpl implements VehicleService {

    VehicleRepo vehicleRepo;
    SpareRepo spareRepo;

    @Autowired
    public VehicleServiceImpl(VehicleRepo repo, SpareRepo spareRepo) {
        this.vehicleRepo = repo;
        this.spareRepo = spareRepo;
    }

    @Override
    public VehicleDto saveVehicle(VehicleDto vehicleDto) {
        Vehicle save = vehicleRepo.save( new Vehicle(vehicleDto.getId(), vehicleDto.getBrand(), vehicleDto.getModel(), vehicleDto.getEngineCap(), vehicleDto.getNoOfGear()));
        return new VehicleDto(save.getId(), save.getBrand(),  save.getModel(), save.getEngineCap(), save.getNoOfGear());
    }

    @Override
    public VehicleDto updateVehicle(VehicleDto vehicleDto) {
        Optional<Vehicle> byId = vehicleRepo.findById(vehicleDto.getId());
        if (byId.isPresent()) {
            Vehicle vehicle = byId.get();
            vehicle.setBrand(vehicleDto.getBrand());
            vehicle.setModel(vehicleDto.getModel());
            vehicle.setEngineCap(vehicleDto.getEngineCap());
            vehicle.setNoOfGear(vehicleDto.getNoOfGear());

            Vehicle update = vehicleRepo.save(vehicle);
            return new VehicleDto(update.getId(),update.getBrand(),update.getModel(),update.getEngineCap(), update.getNoOfGear());

        }else {
            return null;
        }

    }

    @Override
    public VehicleDto deleteVehicle(int id) {
        Optional<Vehicle> byId = vehicleRepo.findById(id);
        if (byId.isPresent()) {
            vehicleRepo.deleteById(id);
            Vehicle vehicle = byId.get();
            return new VehicleDto(vehicle.getId(),vehicle.getBrand(), vehicle.getModel(), vehicle.getEngineCap(), vehicle.getNoOfGear());
        }else{
            return null;
        }
    }

    @Override
    public List<VehicleDto> getAllVehicles() {
        List<Vehicle> vehiclesAll = vehicleRepo.findAll();

        ArrayList<VehicleDto> vehicleDtos = new ArrayList<>();

        for (Vehicle vehicle : vehiclesAll) {
            vehicleDtos.add(new VehicleDto(vehicle.getId(), vehicle.getBrand(),  vehicle.getModel(), vehicle.getEngineCap(), vehicle.getNoOfGear()));
        }
        return vehicleDtos;
    }

    @Override
    public VehicleDto getVehicle(int id) {
        Optional<Vehicle> byId = vehicleRepo.findById(id);
        if (byId.isPresent()) {
            Vehicle vehicle = byId.get();
            return new VehicleDto(vehicle.getId(), vehicle.getBrand(), vehicle.getModel(), vehicle.getEngineCap(), vehicle.getNoOfGear());
        }
        return null;

    }

    @Override
    public SparepartDto saveSparepart(SparepartDto sparepartDto) {
        SpareParts save = spareRepo.save (new SpareParts(sparepartDto.getId(),sparepartDto.getName(),sparepartDto.getPrice()));
        return new SparepartDto(save.getId(), save.getName(), save.getPrice());

    }

    @Override
    public List<VehicleDto> getByBrand(String brand) {
        List<Vehicle> byBrand = vehicleRepo.findByBrand(brand);

        ArrayList<VehicleDto> vehicleDtos = new ArrayList<>();
        for (Vehicle vehicle : byBrand) {

            vehicleDtos.add(new VehicleDto(vehicle.getId(),vehicle.getBrand(),vehicle.getModel(),vehicle.getEngineCap(),vehicle.getNoOfGear()));
        }
        return vehicleDtos;
    }

    @Override
    public List<VehicleDto> getAllByBrandAndModel(String brand, String model) {
        List<Vehicle> vehicleByBrandAndModel = vehicleRepo.getVehicleByBrandAndModel(brand, model);

        ArrayList<VehicleDto> vehicleDtos = new ArrayList<>();
        for (Vehicle vehicle : vehicleByBrandAndModel) {
            vehicleDtos.add(new VehicleDto(vehicle.getId(),vehicle.getBrand(),vehicle.getModel(),vehicle.getEngineCap(), vehicle.getNoOfGear()));
        }
        return vehicleDtos;
    }

    @Override
    public VehicleWithSpareDto saveWithSpare(VehicleWithSpareDto vehicleWithSpareDto) {
        Vehicle vehicle = new Vehicle();
        vehicle.setBrand(vehicleWithSpareDto.getBrand());
        vehicle.setModel(vehicleWithSpareDto.getModel());
        vehicle.setEngineCap(vehicleWithSpareDto.getEngineCap());
        vehicle.setNoOfGear(vehicleWithSpareDto.getNoOfGear());

        ArrayList<SpareParts> list = new ArrayList<>();

        for (SpareParts sparepartDto : vehicleWithSpareDto.getSparePart()){
            list.add(new SpareParts(sparepartDto.getId(), sparepartDto.getName(), sparepartDto.getPrice(),vehicle));

            vehicle.setSparePart(list);
        }
        Vehicle save = vehicleRepo.save(vehicle);

        if (save!=null) {

            return vehicleWithSpareDto;
        }
        return null;

    }
}
