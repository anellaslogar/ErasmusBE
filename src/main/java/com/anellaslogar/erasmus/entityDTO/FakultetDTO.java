package com.anellaslogar.erasmus.entityDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FakultetDTO {
    private Integer idFakultet;
    private String nazivFakulteta;
    private String drzava;
    private String adresaFakulteta;
    private String emailKontakt;

}
