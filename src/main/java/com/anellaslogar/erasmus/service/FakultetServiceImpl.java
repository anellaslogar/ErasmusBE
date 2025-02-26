package com.anellaslogar.erasmus.service;

import com.anellaslogar.erasmus.entityDTO.FakultetDTO;
import com.anellaslogar.erasmus.entity.Fakultet;
import com.anellaslogar.erasmus.repository.FakultetRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

public class FakultetServiceImpl implements FakultetService{

    @Autowired
    private FakultetRepository fakultetRepository;


    @Override
    public List<FakultetDTO> findAll() {
        return fakultetRepository.findAll().stream().map(Fakultet::toDTO).toList();
    }

    @Override
    public Optional<FakultetDTO> findById(Integer theIdFakultetDTO) {
        return fakultetRepository.findById(theIdFakultetDTO).map(Fakultet::toDTO);
    }

    @Transactional
    @Override
    public Fakultet save(FakultetDTO theFakultetDTO) {
        Fakultet theFakultet;

        if (theFakultetDTO.getIdFakultet() == 0) {
            theFakultet = new Fakultet();
        } else {
            theFakultet = fakultetRepository.findById(theFakultetDTO.getIdFakultet())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        }

        theFakultet.setNazivFakulteta(theFakultetDTO.getNazivFakulteta());
        theFakultet.setAdresaFakulteta(theFakultetDTO.getAdresaFakulteta());
        theFakultet.setDrzava(theFakultetDTO.getDrzava());
        theFakultet.setEmailKontakt(theFakultetDTO.getEmailKontakt());

        return fakultetRepository.save(theFakultet);
    }

    @Override
    public void deleteById(int theIdFakultetDTO) {
        fakultetRepository.deleteById(theIdFakultetDTO);
    }

}
