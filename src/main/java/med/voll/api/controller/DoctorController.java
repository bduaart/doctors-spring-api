package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.doctor.Doctor;
import med.voll.api.doctor.DoctorDto;
import med.voll.api.doctor.DoctorRepository;
import med.voll.api.doctor.DoctorUpdate;
import med.voll.api.doctor.ListDoctorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medico")

public class DoctorController {
    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping
    @Transactional
    public void create(@RequestBody @Valid DoctorDto data) {
        doctorRepository.save(new Doctor(data));
    }

    @GetMapping
    //Listagem sem paginação
//    public List<ListDoctorResponse> list() {
//        return doctorRepository.findAll().stream().map(ListDoctorResponse::new).toList();
    //Listagem com paginação
    //-> Permite chamar a rota com os parâmetros sort, size, page
    public Page<ListDoctorResponse> list(@PageableDefault(size = 10, sort = {"name"}) Pageable page) {
        return doctorRepository.findAll(page).map(ListDoctorResponse::new);
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid DoctorUpdate data){
        var doctor = doctorRepository.getReferenceById(data.id());
        doctor.updateDoctor(data);

    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id){
        var doctor = doctorRepository.getReferenceById(id);
        doctor.delete();
    }
}
