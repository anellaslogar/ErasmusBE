package com.anellaslogar.erasmus.service;

import com.anellaslogar.erasmus.entity.Prijava;
import com.anellaslogar.erasmus.entityDTO.PrijavaDTO;

import java.util.List;
import java.util.Optional;

public interface PrijavaService {
    List<PrijavaDTO> findAll();

    Optional<PrijavaDTO> findById(int theIdPrijavaDTO);

    Prijava save(PrijavaDTO thePrijavaDTO);

    void deleteById(int theIdPrijavaDTO);
}
