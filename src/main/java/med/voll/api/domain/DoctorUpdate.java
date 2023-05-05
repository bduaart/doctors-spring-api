package med.voll.api.domain;

import jakarta.validation.constraints.NotNull;

public record DoctorUpdate(@NotNull Long id, String name, String phone, AddressDto address) {
}
