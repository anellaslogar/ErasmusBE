package com.anellaslogar.erasmus.service;

import com.anellaslogar.erasmus.entity.NominacijaDok;
import com.anellaslogar.erasmus.entityDTO.NominacijaDokDTO;
import com.anellaslogar.erasmus.repository.NominacijaDokRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

public class NominacijaDokServiceImpl implements NominacijaDokService{
    @Autowired
    NominacijaDokRepository nominacijaDokRepository;

    @Override
    public List<NominacijaDokDTO> findAll() {
        return nominacijaDokRepository.findAll().stream().map(NominacijaDok::toDTO).toList();
    }

    @Override
    public Optional<NominacijaDokDTO> findById(int theIdNominacijaDokDTO) {
        return nominacijaDokRepository.findById(theIdNominacijaDokDTO).map(NominacijaDok::toDTO);
    }

    @Transactional
    @Override
    public NominacijaDok save(NominacijaDokDTO theNominacijaDokDTO) {
        NominacijaDok theNominacijaDok;

        if (theNominacijaDokDTO.getIdNominacijaDok() == 0) {
            theNominacijaDok = new NominacijaDok();
        } else {
            theNominacijaDok = nominacijaDokRepository.findById(theNominacijaDokDTO.getIdNominacijaDok())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        }

        theNominacijaDok.setIdNominacijaDok(theNominacijaDokDTO.getIdNominacijaDok());
        theNominacijaDok.setNazivNomDok(theNominacijaDokDTO.getNazivNomDok());
        theNominacijaDok.setDatumObjave(theNominacijaDokDTO.getDatumObjave());
        theNominacijaDok.setNominacijeDok(theNominacijaDokDTO.getNominacijeDok());
        // prijava many to one ?
        return nominacijaDokRepository.save(theNominacijaDok);
    }

    @Override
    public void deleteById(int theIdNominacijaDokDTO) {
    nominacijaDokRepository.deleteById(theIdNominacijaDokDTO);
    }
}
