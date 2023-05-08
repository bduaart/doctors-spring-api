package med.voll.api.domain.doctor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface DoctorRepository extends JpaRepository<Doctor, UUID> {

    Page<Doctor> findAllByEnableTrue(Pageable page);
}
