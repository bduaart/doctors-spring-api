package med.voll.api.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String street;
    private String district;
    private String cep;
    private String city;
    private String state;
    private String complement;

    public Address(AddressDto address) {
        this.street = address.street();
        this.district = address.district();
        this.cep = address.cep();
        this.state = address.state();
        this.city = address.city();
        this.complement = address.complement();
    }
}
