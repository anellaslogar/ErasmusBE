package com.anellaslogar.erasmus.service;

import com.anellaslogar.erasmus.entity.Prijava;
import com.anellaslogar.erasmus.entityDTO.PrijavaDTO;
import com.anellaslogar.erasmus.repository.PrijavaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

public class PrijavaServiceImpl implements PrijavaService{
    @Autowired
    PrijavaRepository prijavaRepository;

    @Override
    public List<PrijavaDTO> findAll() {
        return prijavaRepository.findAll().stream().map(Prijava::toDTO).toList();
    }

    @Override
    public Optional<PrijavaDTO> findById(int theIdPrijavaDTO) {
        return prijavaRepository.findById(theIdPrijavaDTO).map(Prijava::toDTO);
    }

    @Transactional
    @Override
    public Prijava save(PrijavaDTO thePrijavaDTO) {
        Prijava thePrijava;

        if (thePrijavaDTO.getIdPrijava() == 0) {
            thePrijava = new Prijava();
        } else {
            thePrijava = prijavaRepository.findById(thePrijavaDTO.getIdPrijava())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        }

        thePrijava.setIdPrijava(thePrijavaDTO.getIdPrijava());
        thePrijava.setStatus(thePrijavaDTO.getStatus());
        thePrijava.setSmjer(thePrijavaDTO.getSmjer());
        thePrijava.setPocetak(thePrijavaDTO.getPocetak());
        thePrijava.setZavrsetak(thePrijavaDTO.getZavrsetak());
        thePrijava.setSemestar(thePrijavaDTO.getSemestar());
        thePrijava.setRezultatDatum(thePrijavaDTO.getRezultatDatum());
        thePrijava.setVrstaPrijave(thePrijavaDTO.getVrstaPrijave());
        // stud program many to one
        // natjecaj many to one
        //student many to one tocnije 2

        return prijavaRepository.save(thePrijava);
    }

    @Override
    public void deleteById(int theIdPrijavaDTO) {
        prijavaRepository.deleteById(theIdPrijavaDTO);
    }
}
