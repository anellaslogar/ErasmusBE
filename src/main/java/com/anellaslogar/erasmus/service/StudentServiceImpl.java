package com.anellaslogar.erasmus.service;

import com.anellaslogar.erasmus.entity.Student;
import com.anellaslogar.erasmus.entityDTO.StudentDTO;
import com.anellaslogar.erasmus.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<StudentDTO> findAll() {
        return studentRepository.findAll().stream().map(Student::toDTO).toList();
    }

    @Override
    public Optional<StudentDTO> findById(Integer theIdStudentDTO) {
        return studentRepository.findById(theIdStudentDTO).map(Student::toDTO);
    }

    @Transactional
    @Override
    public Student save(StudentDTO theStudentDTO) {
        Student theStudent;

        if (theStudentDTO.getIdStudent() == 0) {
            theStudent = new Student();
        } else {
            theStudent = studentRepository.findById(theStudentDTO.getIdStudent())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        }

        theStudent.setIdStudent(theStudentDTO.getIdStudent());
        theStudent.setIme(theStudentDTO.getIme());
        theStudent.setPrezime(theStudentDTO.getPrezime());
        // fakultet i korisnik email
        return studentRepository.save(theStudent);

    }

    @Override
    public void deleteById(int theIdStudentDTO) {
        studentRepository.deleteById(theIdStudentDTO);
    }
}
