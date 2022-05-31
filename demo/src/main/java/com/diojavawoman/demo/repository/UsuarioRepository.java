package com.diojavawoman.demo.repository;

import com.diojavawoman.demo.model.UsuarioModel;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<UsuarioModel, Integer> {
}
