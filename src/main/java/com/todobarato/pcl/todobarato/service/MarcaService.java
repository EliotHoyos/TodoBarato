package com.todobarato.pcl.todobarato.service;

import com.todobarato.pcl.todobarato.dto.request.MarcaRequestDTO;
import com.todobarato.pcl.todobarato.dto.response.MarcaResponseDTO;

import java.util.List;

public interface MarcaService {
    MarcaResponseDTO crear(MarcaRequestDTO request);
    List<MarcaResponseDTO> listarTodos();
    MarcaResponseDTO buscarPorId(Integer idmarca);
    MarcaResponseDTO actualizar(Integer idmarca, MarcaRequestDTO request);
}
