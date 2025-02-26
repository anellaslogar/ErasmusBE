package com.anellaslogar.erasmus.service;

import com.anellaslogar.erasmus.entity.StudProgram;
import com.anellaslogar.erasmus.entityDTO.StudProgramDTO;
import com.anellaslogar.erasmus.repository.StudProgramRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

public class StudProgramServiceImpl implements StudProgramService{
    @Autowired
    private StudProgramRepository studProgramRepository;

    @Override
    public List<StudProgramDTO> findAll() {
        return studProgramRepository.findAll().stream().map(StudProgram::toDTO).toList();
    }

    @Override
    public Optional<StudProgramDTO> findById(int theIdStudProgramDTO) {
        return studProgramRepository.findById(theIdStudProgramDTO).map(StudProgram::toDTO);
    }

    @Transactional
    @Override
    public StudProgram save(StudProgramDTO theStudProgramDTO) {
        StudProgram theStudProgram;

        if (theStudProgramDTO.getIdStudProgram() == 0) {
            theStudProgram = new StudProgram();
        } else {
            theStudProgram = studProgramRepository.findById(theStudProgramDTO.getIdStudProgram())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        }

        theStudProgram.setIdStudProgram(theStudProgramDTO.getIdStudProgram());
        theStudProgram.setNazivStudija(theStudProgramDTO.getNazivStudija());
        theStudProgram.setVrstaStudija(theStudProgramDTO.getVrstaStudija());

        return studProgramRepository.save(theStudProgram);
    }

    @Override
    public void deleteById(int theIdStudProgramDTO) {
    studProgramRepository.deleteById(theIdStudProgramDTO);
    }
}
