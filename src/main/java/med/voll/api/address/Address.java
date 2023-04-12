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
    private String address;
    private String district;
    private String cep;
    private String city;
    private String uf;
    private String complement;
    private String number;

    public Address(AddressDto address) {
        this.address = address.address();
        this.district = address.district();
        this.cep = address.cep();
        this.uf = address.uf();
        this.city = address.city();
        this.number = address.number();
        this.complement = address.complement();
    }
}
