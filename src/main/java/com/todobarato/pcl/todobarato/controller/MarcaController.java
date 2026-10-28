package com.todobarato.pcl.todobarato.controller;

import com.todobarato.pcl.todobarato.dto.request.MarcaRequestDTO;
import com.todobarato.pcl.todobarato.dto.response.MarcaResponseDTO;
import com.todobarato.pcl.todobarato.service.MarcaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/marcas")
@RequiredArgsConstructor
public class MarcaController {
    private final MarcaService marcaService;
    @GetMapping
    public ResponseEntity<List<MarcaResponseDTO>> listarTodos(){
        return ResponseEntity.ok(marcaService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<MarcaResponseDTO> crear(@Valid @RequestBody MarcaRequestDTO request){
        MarcaResponseDTO response = marcaService.crear(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
