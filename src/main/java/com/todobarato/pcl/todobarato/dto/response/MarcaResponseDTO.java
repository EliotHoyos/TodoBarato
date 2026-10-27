package com.todobarato.pcl.todobarato.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MarcaResponseDTO {
    private Integer idmarca;
    private String nombre;
    private Boolean estado;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
