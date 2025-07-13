package com.anellaslogar.erasmus.service;

import com.anellaslogar.erasmus.entity.PrijavaDok;
import com.anellaslogar.erasmus.entityDTO.PrijavaDokDTO;
import com.anellaslogar.erasmus.repository.PrijavaDokRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

public class PrijavaDokServiceImpl implements PrijavaDokService{
    @Autowired
    PrijavaDokRepository prijavaDokRepository;

    @Override
    public List<PrijavaDokDTO> findAll() {
        return prijavaDokRepository.findAll().stream().map(PrijavaDok::toDTO).toList();
    }

    @Override
    public Optional<PrijavaDokDTO> findById(int theIdPrijavaDokDTO) {
        return prijavaDokRepository.findById(theIdPrijavaDokDTO).map(PrijavaDok::toDTO);
    }

    @Transactional
    @Override
    public PrijavaDok
    save(PrijavaDokDTO thePrijavaDokDTO) {
        PrijavaDok thePrijavaDok;

        if (thePrijavaDokDTO.getIdPrijavaDok() == 0) {
            thePrijavaDok = new PrijavaDok();
        } else {
            thePrijavaDok = prijavaDokRepository.findById(thePrijavaDokDTO.getIdPrijavaDok())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        }

        thePrijavaDok.setIdPrijavaDok(thePrijavaDokDTO.getIdPrijavaDok());
        thePrijavaDok.setNazivPriDok(thePrijavaDokDTO.getNazivPriDok());
        thePrijavaDok.setPrijavaDok(thePrijavaDokDTO.getPrijavaDok());
       // prijava one to many - natjecajDok one to one

        return prijavaDokRepository.save(thePrijavaDok);
    }

    @Override
    public void deleteById(int theIdPrijavaDokDTO) {
        prijavaDokRepository.deleteById(theIdPrijavaDokDTO);
    }
}
