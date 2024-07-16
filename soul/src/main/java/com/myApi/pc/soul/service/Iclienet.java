package com.myApi.pc.soul.service;

import java.util.List;

import com.myApi.pc.soul.model.DTO.ClienteDTO;


public interface Iclienet {
    ClienteDTO save(ClienteDTO cliente);
    ClienteDTO findbyId(Integer id);
    void deleet(ClienteDTO cliente);
    boolean existsById(Integer id);
    List<ClienteDTO> findAll();

}
