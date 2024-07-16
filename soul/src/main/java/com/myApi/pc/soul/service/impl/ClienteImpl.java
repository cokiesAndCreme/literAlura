package com.myApi.pc.soul.service.impl;

import com.myApi.pc.soul.model.DTO.ClienteDTO;
import com.myApi.pc.soul.model.bao.ClienteDao;
import com.myApi.pc.soul.model.entity.Cliente;
import com.myApi.pc.soul.service.Iclienet;
import com.myApi.pc.soul.service.Mapeado;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteImpl implements Iclienet {

    @Autowired
    private ClienteDao clienteDao;

    @Autowired
    Mapeado mapeado;

    @Transactional
    @Override
    public ClienteDTO save(ClienteDTO clienteDTO) {
        Cliente cliente = mapeado.toEntity(clienteDTO);
        clienteDao.save(cliente);
        return mapeado.toDto(cliente);
    }

    @Transactional(readOnly = true)
    @Override
    public ClienteDTO findbyId(Integer id) {
        Cliente cliente = clienteDao.findById(id).orElse(null);
        return mapeado.toDto(cliente);
    }

    @Transactional
    @Override
    public void deleet(ClienteDTO clientedDto) {
        Cliente cliente = mapeado.toEntity(clientedDto);
        clienteDao.delete(cliente);
    } 

    @Override
    public boolean existsById(Integer id) {
        return clienteDao.existsById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<ClienteDTO> findAll() {
        List<Cliente> cliente = (List<Cliente>) clienteDao.findAll();
        return cliente
                .stream()
                .map(e -> mapeado.toDto(e))
                .collect(Collectors.toList());
    }


}
