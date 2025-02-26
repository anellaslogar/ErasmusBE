package com.anellaslogar.erasmus.service;

import com.anellaslogar.erasmus.entity.NominacijaDok;
import com.anellaslogar.erasmus.entityDTO.NominacijaDokDTO;
import java.util.List;
import java.util.Optional;

public interface NominacijaDokService {
    List<NominacijaDokDTO> findAll();

    Optional<NominacijaDokDTO> findById(int theIdNominacijaDokDTO);

    NominacijaDok save(NominacijaDokDTO theNominacijaDokDTO);

    void deleteById(int theIdNominacijaDokDTO);
}
