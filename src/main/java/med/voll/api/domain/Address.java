package med.voll.api.domain;

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

    public void updateAddress(AddressDto address) {
        if (address.cep() != null) {
            this.cep = address.cep();
        }
        if (address.city() != null) {
            this.city = address.city();
        }
        if (address.state() != null) {
            this.state = address.state();
        }
        if (address.street() != null) {
            this.street = address.street();
        }
        if (address.district() != null) {
            this.district = address.district();
        }
        if (address.complement() != null) {
            this.complement = address.complement();
        }
    }
}
