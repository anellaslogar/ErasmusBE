package com.anellaslogar.erasmus.repository;

import com.anellaslogar.erasmus.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
