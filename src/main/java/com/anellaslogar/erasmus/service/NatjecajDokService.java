package com.anellaslogar.erasmus.service;

import com.anellaslogar.erasmus.entity.NatjecajDok;
import com.anellaslogar.erasmus.entityDTO.NatjecajDokDTO;

import java.util.List;
import java.util.Optional;

public interface NatjecajDokService {
    List<NatjecajDokDTO> findAll();

    Optional<NatjecajDokDTO> findById(int theIdNatjecajDokDTO);

    NatjecajDok save(NatjecajDokDTO theNatjecajDokDTO);

    void deleteById(int theIdNatjecajDokDTO);
}
