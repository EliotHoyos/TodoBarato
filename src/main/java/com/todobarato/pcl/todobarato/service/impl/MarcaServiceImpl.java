package com.todobarato.pcl.todobarato.service.impl;

import com.todobarato.pcl.todobarato.dto.request.MarcaRequestDTO;
import com.todobarato.pcl.todobarato.dto.response.MarcaResponseDTO;
import com.todobarato.pcl.todobarato.model.entity.Marca;
import com.todobarato.pcl.todobarato.repository.MarcaRepository;
import com.todobarato.pcl.todobarato.service.MarcaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class MarcaServiceImpl implements MarcaService {

    private final MarcaRepository marcaRepository;

    @Override
    public MarcaResponseDTO crear(MarcaRequestDTO request) {
        String nombreTrim = request.getNombre().trim();
        if(marcaRepository.findByNombre(nombreTrim).isPresent()){
            throw new IllegalArgumentException("Ya Existe un nombre de la marca : " + nombreTrim);
        }
        Marca marca = Marca.builder()
                .nombre(nombreTrim)
                .estado(request.getEstado() != null ? request.getEstado() : true)
                .build();
        return mapToResponseDTO(marcaRepository.save(marca));
    }

    @Override
    public List<MarcaResponseDTO> listarTodos() {
        return marcaRepository.findAll()
                .stream()
                .map(this::mapToResponseDTO)
                .toList();
    }

    @Override
    public MarcaResponseDTO buscarPorId(Integer idmarca) {
        return null;
    }

    @Override
    public MarcaResponseDTO actualizar(Integer idmarca, MarcaRequestDTO request) {
        return null;
    }

    private MarcaResponseDTO mapToResponseDTO(Marca marca){
        return MarcaResponseDTO.builder()
                .idmarca(marca.getIdmarca())
                .nombre(marca.getNombre())
                .estado(marca.getEstado())
                .created_at(marca.getCreated_at())
                .updated_at(marca.getUpdated_at())
                .build();
    }

}
