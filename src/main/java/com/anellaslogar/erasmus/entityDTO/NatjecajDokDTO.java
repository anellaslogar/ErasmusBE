package com.anellaslogar.erasmus.entityDTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NatjecajDokDTO {
    private Integer idNatjecajDok;
    private String nazivNatDok;
    private byte[] natjecajDok;
}
