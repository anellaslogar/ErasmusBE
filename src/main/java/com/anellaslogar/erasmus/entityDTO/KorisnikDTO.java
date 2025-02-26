package com.anellaslogar.erasmus.entityDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class KorisnikDTO {

    private Long idKorisnik;
    private String pass;
}
