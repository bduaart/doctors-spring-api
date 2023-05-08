package med.voll.api.domain.doctor;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.Address;
import med.voll.api.domain.ExpertiseEnum;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Table(name = "medicos")
@Entity(name = "Doctor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;
    private String name;
    private String email;
    private String phone;
    private String crm;
    @Enumerated(EnumType.STRING)
    private ExpertiseEnum expertise;
    @Embedded
    private Address address;

    private Boolean enable;

    public Doctor(DoctorCreateRequest data) {
        this.enable = true;
        this.name = data.name();
        this.email = data.email();
        this.phone = data.phone();
        this.crm = data.crm();
        this.expertise = data.expertise();
        this.address = new Address(data.address());
    }


    public void updateDoctor(DoctorUpdateRequest data) {
        if (data.name() != null) {
            this.name = data.name();
        }
        if (data.phone() != null) {
            this.phone = data.phone();
        }
        if (data.address() != null) {
            this.address.updateAddress(data.address());
        }

    }

    public void delete() {
        this.enable = false;
    }
}
