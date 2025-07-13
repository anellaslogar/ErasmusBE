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
public class NominacijaDokDTO {
    private Integer idNominacijaDok;
    private String nazivNomDok;
    private byte[] nominacijeDok;
    private Date datumObjave;
}
