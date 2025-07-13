package com.anellaslogar.erasmus.service;

import com.anellaslogar.erasmus.entity.Natjecaj;
import com.anellaslogar.erasmus.entityDTO.NatjecajDTO;
import com.anellaslogar.erasmus.repository.NatjecajRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

public class NatjecajServiceImpl implements NatjecajService{

    @Autowired
    private NatjecajRepository natjecajRepository;


    @Override
    public List<NatjecajDTO> findAll() {
        return natjecajRepository.findAll().stream().map(Natjecaj::toDTO).toList();
    }

    @Override
    public Optional<NatjecajDTO> findById(int theIdNatjecajDTO) {
        return natjecajRepository.findById(theIdNatjecajDTO).map(Natjecaj::toDTO);
    }

    @Transactional
    @Override
    public Natjecaj save(NatjecajDTO theNatjecajDTO) {
        Natjecaj theNatjecaj;

        if (theNatjecajDTO.getIdNatjecaj() == 0) {
            theNatjecaj = new Natjecaj();
        } else {
            theNatjecaj = natjecajRepository.findById(theNatjecajDTO.getIdNatjecaj())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        }

        theNatjecaj.setIdNatjecaj(theNatjecajDTO.getIdNatjecaj());
        theNatjecaj.setNatjecajNaziv(theNatjecajDTO.getNatjecajNaziv());
        theNatjecaj.setPocetak(theNatjecajDTO.getPocetak());
        theNatjecaj.setZavrsetak(theNatjecajDTO.getZavrsetak());
        theNatjecaj.setGodina(theNatjecajDTO.getGodina());

        return natjecajRepository.save(theNatjecaj);
    }

    @Override
    public void deleteById(int theIdNatjecajDTO) {
    natjecajRepository.deleteById(theIdNatjecajDTO);
    }
}
