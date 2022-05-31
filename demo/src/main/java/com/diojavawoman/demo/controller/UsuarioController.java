package com.diojavawoman.demo.controller;

import com.diojavawoman.demo.model.UsuarioModel;
import com.diojavawoman.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;
//consulta usuario pelo codigo, recebe o codigo do usuario e faz a consulta
    @GetMapping(path = "/api/usuario/{codigo}")
    public ResponseEntity consultar(@PathVariable("codigo") Integer codigo){
        return repository.findById(codigo)
                .map(record -> ResponseEntity.ok().body(record))//se ele retornou algo ok e monta o body
                .orElse(ResponseEntity.notFound().build());//se não ele traz o notfound
    }
    @PostMapping(path = "/api/usuario/salvar")//requestbody diz que os dados do usuario vem pelo corpo da requisicao
    public UsuarioModel salvar(@RequestBody UsuarioModel usuario){
        return repository.save(usuario);
    }
}
