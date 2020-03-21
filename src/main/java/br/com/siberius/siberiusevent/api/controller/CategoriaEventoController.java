package br.com.siberius.siberiusevent.api.controller;

import br.com.siberius.siberiusevent.model.CategoriaEvento;
import br.com.siberius.siberiusevent.repository.CategoriaEventoRepository;
import br.com.siberius.siberiusevent.service.CategoriaEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categorias-eventos")
public class CategoriaEventoController {

    @Autowired
    private CategoriaEventoRepository categoriaEventoRepository;

    @Autowired
    private CategoriaEventoService categoriaEventoService;

    @GetMapping
    public List<CategoriaEvento> listar(){
        return categoriaEventoRepository.findAll();
    }

    @GetMapping("/{categoriaEventoId}")
    public CategoriaEvento buscar(@PathVariable Long categoriaEventoId){
        return categoriaEventoService.buscarOuFalhar(categoriaEventoId);
    }

}
