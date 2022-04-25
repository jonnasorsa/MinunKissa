package MinunKissa.MinunKissa;


import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cat extends AbstractPersistable<Long> {
    private String name;
    private String gender;
    private String breed;
    private String color;
    private String owner;

    private String officialName;
    private String breeder;
    private String number;
    private String chip;
    private String EMS;
    private String dob;
    private String dad;
    private String mum;
}

