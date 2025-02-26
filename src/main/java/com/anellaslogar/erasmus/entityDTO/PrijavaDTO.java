package com.anellaslogar.erasmus.entityDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PrijavaDTO {
    private Integer idPrijava;
    private String status;
    private String smjer;
    private String pocetak;
    private String zavrsetak;
    private String semestar;
    private Date rezultatDatum;
    private String vrstaPrijave;
}
