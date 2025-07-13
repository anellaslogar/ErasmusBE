package com.anellaslogar.erasmus.service;

import com.anellaslogar.erasmus.entity.Korisnik;

import com.anellaslogar.erasmus.entityDTO.KorisnikDTO;
import com.anellaslogar.erasmus.repository.KorisnikRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

public class KorisnikServiceImpl implements KorisnikService{
    @Autowired

    private KorisnikRepository korisnikRepository;

    @Override
    public List<KorisnikDTO> findAll() {
        return korisnikRepository.findAll().stream().map(Korisnik::toDTO).toList();
    }

    @Override
    public Optional<KorisnikDTO> findById(Integer theIdKorisnikDTO) {
        return korisnikRepository.findById(theIdKorisnikDTO).map(Korisnik::toDTO);
    }

    @Transactional
    @Override
    public Korisnik save(KorisnikDTO theKorisnikDTO) {
        Korisnik theKorisnik;

        if (theKorisnikDTO.getIdKorisnik().toString().length() == 0) {
            Korisnik korisnikDTO = null;
            theKorisnik = new Korisnik(korisnikDTO.getEmail(), korisnikDTO.getIme(), korisnikDTO.getPrezime() );
        } else {
            theKorisnik = korisnikRepository.findById(theKorisnikDTO.getIdKorisnik())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        }

        theKorisnik.setEmail(theKorisnik.getEmail());
        theKorisnik.setIme(theKorisnik.getIme());
        theKorisnik.setPrezime(theKorisnik.getPrezime());

        return korisnikRepository.save(theKorisnik);
    }

    @Override
    public void deleteById(Integer theIdKorisnikDTO) {
        korisnikRepository.deleteById(theIdKorisnikDTO);
    }
}
