package med.voll.api.domain.doctor;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.AddressDto;

import java.util.UUID;

public record DoctorUpdateRequest(@NotNull UUID id, String name, String phone, AddressDto address) {
}
