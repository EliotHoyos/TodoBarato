package com.todobarato.pcl.todobarato.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MarcaRequestDTO {
    @Schema(description = "Nombre de la marca", example = "Toyota")
    @NotBlank(message = "El nombre del área es obligatorio")
    @Size(max = 200, message = "El nombre no puede superar los 200 caracteres")
    private String nombre;
    @Schema(description = "Estado de la marca (activo/inactivo)", example = "true")
    @Builder.Default
    private Boolean estado = true;
}
