package com.anellaslogar.erasmus.repository;

import com.anellaslogar.erasmus.entity.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KorisnikRepository extends JpaRepository<Korisnik,Long> {
    Optional<Korisnik> findByEmail(String email);
}
