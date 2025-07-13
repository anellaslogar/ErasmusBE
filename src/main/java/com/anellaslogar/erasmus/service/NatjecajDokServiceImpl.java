package com.anellaslogar.erasmus.service;

import com.anellaslogar.erasmus.entity.NatjecajDok;
import com.anellaslogar.erasmus.entityDTO.NatjecajDokDTO;
import com.anellaslogar.erasmus.repository.NatjecajDokRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

public class NatjecajDokServiceImpl implements NatjecajDokService{

    @Autowired
    private NatjecajDokRepository natjecajDokRepository;

    @Override
    public List<NatjecajDokDTO> findAll() {
        return natjecajDokRepository.findAll().stream().map(NatjecajDok::toDTO).toList();
    }

    @Override
    public Optional<NatjecajDokDTO> findById(int theIdNatjecajDokDTO) {
        return natjecajDokRepository.findById(theIdNatjecajDokDTO).map(NatjecajDok::toDTO);
    }

    @Transactional
    @Override
    public NatjecajDok save(NatjecajDokDTO theNatjecajDokDTO) {
        NatjecajDok theNatjecajDok;

        if (theNatjecajDokDTO.getIdNatjecajDok() == 0) {
            theNatjecajDok = new NatjecajDok();
        } else {
            theNatjecajDok = natjecajDokRepository.findById(theNatjecajDokDTO.getIdNatjecajDok())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        }

        theNatjecajDok.setIdNatjecajDok(theNatjecajDokDTO.getIdNatjecajDok());
        theNatjecajDok.setNazivNatDok(theNatjecajDokDTO.getNazivNatDok());
        theNatjecajDok.setNatjecajDok(theNatjecajDokDTO.getNatjecajDok());
        // natjecaj one to many

        return natjecajDokRepository.save(theNatjecajDok);
    }

    @Override
    public void deleteById(int theIdNatjecajDokDTO) {
        natjecajDokRepository.deleteById(theIdNatjecajDokDTO);
    }
}
