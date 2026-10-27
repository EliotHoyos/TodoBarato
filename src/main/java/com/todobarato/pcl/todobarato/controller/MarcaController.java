package com.todobarato.pcl.todobarato.controller;

import com.todobarato.pcl.todobarato.dto.response.MarcaResponseDTO;
import com.todobarato.pcl.todobarato.service.MarcaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/marcas")
@RequiredArgsConstructor
public class MarcaController {
    private final MarcaService marcaService;
    @GetMapping
    public ResponseEntity<List<MarcaResponseDTO>> listarTodos(){
        return ResponseEntity.ok(marcaService.listarTodos());
    }
}
