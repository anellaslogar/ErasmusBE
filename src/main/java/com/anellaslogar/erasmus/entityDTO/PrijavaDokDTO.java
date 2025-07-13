package com.anellaslogar.erasmus.entityDTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PrijavaDokDTO {
    private Integer idPrijavaDok;
    private String nazivPriDok;
    private byte[] prijavaDok;
}
