package br.com.siberius.siberiusevent.api.controller;

import br.com.siberius.siberiusevent.exception.EntidadeNaoEncontradaException;
import br.com.siberius.siberiusevent.exception.NegocioException;
import br.com.siberius.siberiusevent.model.CategoriaEvento;
import br.com.siberius.siberiusevent.model.Evento;
import br.com.siberius.siberiusevent.repository.EventoRepository;
import br.com.siberius.siberiusevent.service.CategoriaEventoService;
import br.com.siberius.siberiusevent.service.EventoService;
import jdk.jfr.Event;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private EventoService eventoService;

    @GetMapping
    public List<Evento> listar() {
        return eventoRepository.findAll();
    }

    @GetMapping("/{eventoId}")
    public Evento buscar(@PathVariable Long eventoId) {
        return eventoService.buscarOuFalhar(eventoId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Evento salvar(@RequestBody Evento evento) {
        try {
            return eventoService.salvar(evento);
        } catch (EntidadeNaoEncontradaException e) {
            throw new NegocioException(e.getMessage(), e.getCause());
        }

    }

    @PutMapping("/{eventoId}")
    public Evento atualizar(@PathVariable Long eventoId,
                            @RequestBody Evento evento) {

        Evento eventoAtual = eventoService.buscarOuFalhar(eventoId);

        BeanUtils.copyProperties(evento, eventoAtual);

        try {
            return eventoService.salvar(eventoAtual);
        } catch (EntidadeNaoEncontradaException e) {
            throw new NegocioException(e.getMessage(), e.getCause());
        }
    }

    @DeleteMapping("/{eventoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long eventoId) {
        eventoService.excluir(eventoId);
    }

}
