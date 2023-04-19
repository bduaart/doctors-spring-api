package med.voll.api.doctor;

public record ListDoctorResponse(Long id, String name, String email, String crm, ExpertiseEnum expertise, String phone, Boolean enable) {

    public ListDoctorResponse(Doctor doctor){
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getExpertise(), doctor.getPhone(), doctor.getEnable());
    }
}
