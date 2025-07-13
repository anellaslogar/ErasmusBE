package com.anellaslogar.erasmus.entityDTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudProgramDTO {
    private Integer idStudProgram;
    private String nazivStudija;
    private String vrstaStudija;
}
