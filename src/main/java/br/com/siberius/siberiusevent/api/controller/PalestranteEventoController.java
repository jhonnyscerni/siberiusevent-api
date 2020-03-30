package br.com.siberius.siberiusevent.api.controller;

import br.com.siberius.siberiusevent.exception.EntidadeNaoEncontradaException;
import br.com.siberius.siberiusevent.exception.NegocioException;
import br.com.siberius.siberiusevent.model.Evento;
import br.com.siberius.siberiusevent.model.Palestrante;
import br.com.siberius.siberiusevent.repository.PalestranteRepository;
import br.com.siberius.siberiusevent.service.EventoService;
import br.com.siberius.siberiusevent.service.PalestranteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/eventos/{eventoId}/palestrantes")
public class PalestranteEventoController {

    @Autowired
    private PalestranteRepository palestranteRepository;

    @Autowired
    private PalestranteService palestranteService;

    @Autowired
    private EventoService eventoService;

    @GetMapping
    public List<Palestrante> listarPalestrantesEvento(@PathVariable Long eventoId) {
        return palestranteRepository.findAllByEventoId(eventoId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Palestrante salvar(@PathVariable Long eventoId, @RequestBody @Valid Palestrante palestrante) {

        Evento evento = eventoService.buscarOuFalhar(eventoId);
        palestrante.setEvento(evento);

        return palestranteService.salvar(palestrante);
    }

}
