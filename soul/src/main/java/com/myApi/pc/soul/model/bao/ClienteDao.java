package com.myApi.pc.soul.model.bao;

import com.myApi.pc.soul.model.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDao extends CrudRepository<Cliente,Integer> {
}
