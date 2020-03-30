package br.com.siberius.siberiusevent.service;

import br.com.siberius.siberiusevent.exception.EntidadeEmUsoException;
import br.com.siberius.siberiusevent.exception.EntidadeNaoEncontradaException;
import br.com.siberius.siberiusevent.model.Evento;
import br.com.siberius.siberiusevent.model.Palestrante;
import br.com.siberius.siberiusevent.repository.PalestranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class PalestranteService {

    private static final String MSG_ENTIDADE_NAO_ENCONTRADO = "Não existe um cadastro com o código %s";
    private static final String MSG_ENTIDADE_EM_USO = "Entidade de código %s não pode ser removido, pois está em uso";

    @Autowired
    private PalestranteRepository palestranteRepository;

    @Autowired
    private EventoService eventoService;

    public Palestrante salvar(Palestrante palestrante) {

        Evento evento = eventoService.buscarOuFalhar(palestrante.getEvento().getId());

        palestrante.setEvento(evento);

        return palestranteRepository.save(palestrante);
    }

    public Palestrante buscarOuFalhar(Long palestranteId) {
        return palestranteRepository.findById(palestranteId).orElseThrow(
                () -> new EntidadeNaoEncontradaException(
                        String.format(MSG_ENTIDADE_NAO_ENCONTRADO, palestranteId))
        );
    }

    public void excluir(Long palestranteId) {
        try {

        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(
                    String.format(MSG_ENTIDADE_NAO_ENCONTRADO, palestranteId)
            );
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format(MSG_ENTIDADE_EM_USO, palestranteId)
            );
        }
    }
}
