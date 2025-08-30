package lk.acpt.car_sale.repo;

import lk.acpt.car_sale.dto.SparepartDto;
import lk.acpt.car_sale.entity.SpareParts;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SpareRepo extends JpaRepository<SpareParts,Integer> {

}
