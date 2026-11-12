package com.todobarato.pcl.todobarato.controller;

import com.todobarato.pcl.todobarato.dto.request.MarcaRequestDTO;
import com.todobarato.pcl.todobarato.dto.response.MarcaResponseDTO;
import com.todobarato.pcl.todobarato.model.entity.Marca;
import com.todobarato.pcl.todobarato.service.MarcaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Tag(name = "Marcas", description = "Enpoint para la gestión y consulta de marcas")
@RestController
@RequestMapping("/marcas")
@RequiredArgsConstructor
public class MarcaController {
    private final MarcaService marcaService;

    @Operation(summary = "Listar marcas", description = "Obtiene la lista de completa de todas las marcas registradas")
    @ApiResponse(responseCode = "200", description = "Marcas listadas con éxito")
    @GetMapping
    public ResponseEntity<List<MarcaResponseDTO>> listarTodos(){
        return ResponseEntity.ok(marcaService.listarTodos());
    }

    @Operation(summary = "Crear marca", description = "Crea una nueva marca validando campos y evitando duplicados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Marca creada correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos o la marca ya existe")
    })
    @PostMapping
    public ResponseEntity<MarcaResponseDTO> crear(@Valid @RequestBody MarcaRequestDTO request){
        MarcaResponseDTO response = marcaService.crear(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Actualizar marca", description = "Actualiza el nombre y estado de una marca existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Marca actualizada correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos o la marca ya está en uso"),
            @ApiResponse(responseCode = "404", description = "No existe una marca con ese id")
    })
    @PutMapping("/{idmarca}")
    public ResponseEntity<MarcaResponseDTO> actualizar(@PathVariable Integer idmarca, @Valid @RequestBody
                                                       MarcaRequestDTO request){
        MarcaResponseDTO response = marcaService.actualizar(idmarca, request);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Eliminar marca", description = "Elimina una marca existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Marca eliminada correctamente"),
            @ApiResponse(responseCode = "404", description = "No existe una marca con ese id")
    })
    @DeleteMapping("/{idmarca}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer idmarca){
        MarcaResponseDTO marcaEliminar = marcaService.buscarPorId(idmarca);
        marcaService.eliminar(idmarca);
        return ResponseEntity.noContent().build();
    }

}
