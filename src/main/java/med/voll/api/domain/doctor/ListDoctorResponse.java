package med.voll.api.domain.doctor;

import med.voll.api.domain.ExpertiseEnum;

import java.util.UUID;

public record ListDoctorResponse(UUID id, String name, String email, String crm, ExpertiseEnum expertise, String phone, Boolean enable) {

    public ListDoctorResponse(Doctor doctor){
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getExpertise(), doctor.getPhone(), doctor.getEnable());
    }
}
