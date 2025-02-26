package com.anellaslogar.erasmus.service;


import com.anellaslogar.erasmus.entityDTO.FakultetDTO;
import com.anellaslogar.erasmus.entity.Fakultet;
import java.util.List;
import java.util.Optional;

public interface FakultetService {

        List<FakultetDTO> findAll();

        Optional<FakultetDTO> findById(Integer theIdFakultetDTO);

        Fakultet save(FakultetDTO theFakultetDTO);

        void deleteById(int theIdFakultetDTO);


}
