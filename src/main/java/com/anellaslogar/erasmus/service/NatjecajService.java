package com.anellaslogar.erasmus.service;

import com.anellaslogar.erasmus.entity.Natjecaj;
import com.anellaslogar.erasmus.entityDTO.NatjecajDTO;

import java.util.List;
import java.util.Optional;

public interface NatjecajService {
    List<NatjecajDTO> findAll();

    Optional<NatjecajDTO> findById(int theIdNatjecajDTO);

    Natjecaj save(NatjecajDTO theNatjecajDTO);

    void deleteById(int theIdNatjecajDTO);
}
