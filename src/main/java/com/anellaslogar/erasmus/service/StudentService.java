package com.anellaslogar.erasmus.service;

import com.anellaslogar.erasmus.entity.Student;
import com.anellaslogar.erasmus.entityDTO.StudentDTO;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<StudentDTO> findAll();

    Optional<StudentDTO> findById(Integer theIdStudentDTO);

    Student save(StudentDTO theStudentDTO);

    void deleteById(int theIdStudentDTO);
}
