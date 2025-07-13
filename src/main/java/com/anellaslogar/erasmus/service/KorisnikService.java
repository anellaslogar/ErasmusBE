package com.anellaslogar.erasmus.service;

import com.anellaslogar.erasmus.entityDTO.KorisnikDTO;
import com.anellaslogar.erasmus.entity.Korisnik;
import java.util.List;
import java.util.Optional;

public interface KorisnikService {

    List<KorisnikDTO> findAll();

    Optional<KorisnikDTO> findById(Integer theIdKorisnikDTO);

    Korisnik save(KorisnikDTO theKorisnikDTO);

    void deleteById(Integer theIdKorisnikDTO);
}
