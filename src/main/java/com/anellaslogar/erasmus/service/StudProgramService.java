package com.anellaslogar.erasmus.service;

import com.anellaslogar.erasmus.entity.StudProgram;
import com.anellaslogar.erasmus.entityDTO.StudProgramDTO;

import java.util.List;
import java.util.Optional;

public interface StudProgramService {
    List<StudProgramDTO> findAll();

    Optional<StudProgramDTO> findById(int theIdStudProgramDTO);

    StudProgram save(StudProgramDTO theStudProgramDTO);

    void deleteById(int theIdStudProgramDTO);
}
