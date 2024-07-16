package com.myApi.pc.soul.controller;

import com.myApi.pc.soul.expciones.ExepcionesNotFoundXD;
import com.myApi.pc.soul.model.DTO.ClienteDTO;
import com.myApi.pc.soul.model.payload.MensajeRepsponse;
import com.myApi.pc.soul.service.Iclienet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class Controlador {

    @Autowired
    private Iclienet clieneteServicio;

    @PostMapping("cliente")
    public ResponseEntity<?> create(@RequestBody ClienteDTO clienteDTO) {
        ClienteDTO clientesave = null;
        try {
            clientesave = clieneteServicio.save(clienteDTO);
            return new ResponseEntity<>(MensajeRepsponse
                    .builder()
                    .mensaje("creado Correctamente")
                    .objeto(clientesave)
                    .build(), HttpStatus.CREATED);
        } catch (DataAccessException exDT) {
            return new ResponseEntity<>(MensajeRepsponse.builder()
                    .mensaje(exDT.getMessage())
                    .objeto(null)
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @PutMapping("cliente/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> update(@RequestBody ClienteDTO clienteDTO, @PathVariable Integer id) {

        ClienteDTO clienteupdate = null;
        if (clieneteServicio.existsById(id)) {
            clienteDTO.setIdcliente(id);
            clienteupdate = clieneteServicio.save(clienteDTO);

            return new ResponseEntity<>(MensajeRepsponse
                    .builder()
                    .mensaje("Encontrado Correctamente")
                    .objeto(clienteupdate)
                    .build(), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(MensajeRepsponse.builder()
                    .mensaje("No se incontro el id pitudo")
                    .objeto(null)
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("cliente/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            ClienteDTO clienteDelete = clieneteServicio.findbyId(id);
            clieneteServicio.deleet(clienteDelete);
            return new ResponseEntity<>(clienteDelete, HttpStatus.NO_CONTENT);

        } catch (DataAccessException exDT) {
            return new ResponseEntity<>(MensajeRepsponse.builder()
                    .mensaje(exDT.getMessage())
                    .objeto(null)
                    .build(), HttpStatus.NOT_FOUND);

        }

    }

    @GetMapping("cliente/{id}")
    public ResponseEntity<?> showById(@PathVariable Integer id) {
        ClienteDTO clienteDTO = clieneteServicio.findbyId(id);
        if (clienteDTO == null) {
            throw new ExepcionesNotFoundXD("cliente", "id", id);
        }

        return new ResponseEntity<>(
                MensajeRepsponse
                        .builder()
                        .mensaje("Si se pudo pa  ")
                        .objeto(clienteDTO)
                        .build(),
                HttpStatus.OK);

    }

    @GetMapping("clientes")
    public ResponseEntity<?> findAll() {
        List<ClienteDTO> alf = clieneteServicio.findAll();
        try {
            return new ResponseEntity<>(MensajeRepsponse
                    .builder()
                    .mensaje("si se pudo pa")
                    .objeto(alf)
                    .build(),
                    HttpStatus.OK);
        } catch (DataAccessException exDT) {
            return new ResponseEntity<>(MensajeRepsponse.builder()
                    .mensaje(exDT.getMessage())
                    .objeto(null)
                    .build(), HttpStatus.NO_CONTENT);

        }

    }

}
