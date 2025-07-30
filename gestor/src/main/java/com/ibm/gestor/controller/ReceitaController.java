package com.ibm.gestor.controller;

import com.ibm.gestor.service.ReceitaService;
import com.ibm.model.Receita;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/receita")
public class ReceitaController {

    @Autowired
    ReceitaService receitaService;

    @GetMapping
    public ResponseEntity<Page<Receita>> getAllReceitas(@PageableDefault(page = 0, size = 10, sort = "name", direction = Sort.Direction.ASC)Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(receitaService.getAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneReceita(@PathVariable(value = "id") Long id) {
        Optional<Receita> receitaOptional = receitaService.getById(id);
        if(receitaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Receita não encontrada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(receitaOptional.get());
    }

}
