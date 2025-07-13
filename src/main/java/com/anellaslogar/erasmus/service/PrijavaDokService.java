package com.anellaslogar.erasmus.service;

import com.anellaslogar.erasmus.entity.PrijavaDok;
import com.anellaslogar.erasmus.entityDTO.PrijavaDokDTO;

import java.util.List;
import java.util.Optional;

public interface PrijavaDokService {
    List<PrijavaDokDTO> findAll();

    Optional<PrijavaDokDTO> findById(int theIdPrijavaDokDTO);

    PrijavaDok save(PrijavaDokDTO thePrijavaDokDTO);

    void deleteById(int theIdPrijavaDokDTO);
}
