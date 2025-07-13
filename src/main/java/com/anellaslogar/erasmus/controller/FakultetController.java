package com.anellaslogar.erasmus.controller;

import com.anellaslogar.erasmus.entity.Fakultet;
import com.anellaslogar.erasmus.repository.FakultetRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fakulteti")
@CrossOrigin(origins = "http://localhost:3000")

public class FakultetController {

        private final FakultetRepository faksRepo;

        public FakultetController(FakultetRepository faksRepo) {
            this.faksRepo = faksRepo;
        }

        @GetMapping
        public List<Fakultet> getAllColleges() {
            return faksRepo.findAll();
        }
}
