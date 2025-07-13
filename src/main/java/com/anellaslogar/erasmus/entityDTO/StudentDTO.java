package com.anellaslogar.erasmus.entityDTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private String supabaseUserId;
    private String ime;
    private String prezime;
    private Integer fakultetId;
}
