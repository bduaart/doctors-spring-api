package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("medico")

public class DoctorController {
    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid DoctorDto data, UriComponentsBuilder uriBuilder) {
        var doctor = new Doctor(data);
        doctorRepository.save(doctor);

        var uri = uriBuilder.path("/medico/{id}").buildAndExpand(doctor.getId()).toUri();
        return ResponseEntity.created(uri).body(new ListDoctorResponse(doctor));
    }

    @GetMapping
    //Listagem sem paginação
//    public List<ListDoctorResponse> list() {
//        return doctorRepository.findAll().stream().map(ListDoctorResponse::new).toList();
    //Listagem com paginação
    //-> Permite chamar a rota com os parâmetros sort, size, page
    public ResponseEntity<Page<ListDoctorResponse>> list(@PageableDefault(size = 10, sort = {"name"}) Pageable page) {
        var pageResult = doctorRepository.findAllByEnableTrue(page).map(ListDoctorResponse::new);
        return ResponseEntity.ok(pageResult);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid DoctorUpdate data){
        var doctor = doctorRepository.getReferenceById(data.id());
        doctor.updateDoctor(data);
        return (ResponseEntity) ResponseEntity.ok();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        var doctor = doctorRepository.getReferenceById(id);
        doctor.delete();
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<ListDoctorResponse> details(@PathVariable Long id) {
        var doctor = doctorRepository.getReferenceById(id);
        return ResponseEntity.ok(new ListDoctorResponse(doctor));
    }
}
