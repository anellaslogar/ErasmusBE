package com.anellaslogar.erasmus.controller;

import com.anellaslogar.erasmus.entity.Fakultet;
import com.anellaslogar.erasmus.entity.Student;
import com.anellaslogar.erasmus.entityDTO.StudentDTO;
import com.anellaslogar.erasmus.repository.FakultetRepository;
import com.anellaslogar.erasmus.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/studenti")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private FakultetRepository fakultetRepository;

    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody StudentDTO studentDTO) {
        Optional<Fakultet> fakultet = fakultetRepository.findById(studentDTO.getFakultetId());
        if (fakultet.isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid fakultet ID");
        }

        Student student = new Student();
        student.setSupabaseUserId(studentDTO.getSupabaseUserId());
        student.setIme(studentDTO.getIme());
        student.setPrezime(studentDTO.getPrezime());
        student.setFakultet(fakultet.get());

        studentRepository.save(student);
        return ResponseEntity.ok("Student created");
    }
}