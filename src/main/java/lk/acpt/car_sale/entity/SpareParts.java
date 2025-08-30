package lk.acpt.car_sale.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpareParts {
    @Id
    private Integer Id;
    private String Name;
    private double Price;

    public SpareParts(Integer id, String name, double price) {
        Id = id;
        Name = name;
        Price = price;
    }

    @ManyToOne (cascade = CascadeType.ALL)
    Vehicle vehicle;
}
