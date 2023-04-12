package med.voll.api.doctor;


import med.voll.api.address.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Table(name = "medico")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id = UUID.randomUUID();
    private String name;
    private String email;
    private String crm;
    @Enumerated(EnumType.STRING)
    private ExpertiseEnum expertise;
    @Embedded
    private Address address;

    public Doctor(DoctorDto data) {
        this.name = data.name();
        this.email = data.email();
        this.crm = data.crm();
        this.expertise = data.expertiseEnum();
        this.address = new Address(data.address());
    }


}
