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
public class NatjecajDTO {

    private Integer idNatjecaj;
    private String natjecajNaziv;
    private Date pocetak;
    private Date zavrsetak;
    private String godina;
}
