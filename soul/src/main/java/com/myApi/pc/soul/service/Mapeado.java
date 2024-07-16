package com.myApi.pc.soul.service;

import org.mapstruct.Mapper;

import com.myApi.pc.soul.model.DTO.ClienteDTO;
import com.myApi.pc.soul.model.entity.Cliente;

@Mapper(componentModel = "spring")
public interface Mapeado {
public Cliente toEntity(ClienteDTO clienteDTO);
public ClienteDTO toDto(Cliente cliente);

}
// Cliente cliente2 = mapeado.clienteDTOToCliente(cliente);