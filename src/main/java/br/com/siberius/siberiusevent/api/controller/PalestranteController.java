package br.com.siberius.siberiusevent.api.controller;

import br.com.siberius.siberiusevent.exception.EntidadeNaoEncontradaException;
import br.com.siberius.siberiusevent.exception.NegocioException;
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
@RequestMapping("/palestrantes")
public class PalestranteController {

    @Autowired
    private PalestranteRepository palestranteRepository;

    @Autowired
    private PalestranteService palestranteService;

    @GetMapping
    public List<Palestrante> listar() {
        return palestranteRepository.findAll();
    }

    @GetMapping("/{palestranteId}")
    public Palestrante buscar(@PathVariable Long palestranteId) {
        return palestranteService.buscarOuFalhar(palestranteId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Palestrante salvar(@RequestBody @Valid Palestrante palestrante) {
        return palestranteService.salvar(palestrante);
    }

    @PutMapping("/{paletranteId}")
    public Palestrante atualizar(@PathVariable Long palestranteId,
                                 @RequestBody Palestrante palestrante) {

        Palestrante palestranteAtual = palestranteService.buscarOuFalhar(palestranteId);

        BeanUtils.copyProperties(palestrante, palestranteAtual);

        try {
            return palestranteService.salvar(palestranteAtual);
        } catch (EntidadeNaoEncontradaException e) {
            throw new NegocioException(e.getMessage(), e.getCause());
        }
    }
}
