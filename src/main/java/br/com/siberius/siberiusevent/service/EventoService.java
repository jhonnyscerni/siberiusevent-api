package br.com.siberius.siberiusevent.service;

import br.com.siberius.siberiusevent.exception.EntidadeEmUsoException;
import br.com.siberius.siberiusevent.exception.EntidadeNaoEncontradaException;
import br.com.siberius.siberiusevent.model.CategoriaEvento;
import br.com.siberius.siberiusevent.model.Evento;
import br.com.siberius.siberiusevent.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class EventoService {

    private static final String MSG_ENTIDADE_NAO_ENCONTRADO = "Não existe um cadastro com o código %s";
    private static final String MSG_ENTIDADE_EM_USO = "Entidade de código %s não pode ser removido, pois está em uso";

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private CategoriaEventoService categoriaEventoService;

    public Evento salvar(Evento evento) {

        CategoriaEvento categoriaEvento =
                categoriaEventoService.buscarOuFalhar(evento.getCategoriaEvento().getId());

        evento.setCategoriaEvento(categoriaEvento);

        return eventoRepository.save(evento);
    }

    public Evento buscarOuFalhar(Long eventoId) {
        return eventoRepository.findById(eventoId).orElseThrow(
                () -> new EntidadeNaoEncontradaException(
                        String.format(MSG_ENTIDADE_NAO_ENCONTRADO, eventoId))
        );
    }

    public void excluir(Long eventoId) {
        try {
            eventoRepository.deleteById(eventoId);
        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(
                    String.format(MSG_ENTIDADE_NAO_ENCONTRADO, eventoId)
            );
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format(MSG_ENTIDADE_EM_USO, eventoId)
            );
        }
    }
}
