package br.com.siberius.siberiusevent.service;

import br.com.siberius.siberiusevent.exception.EntidadeNaoEncontradaException;
import br.com.siberius.siberiusevent.model.CategoriaEvento;
import br.com.siberius.siberiusevent.repository.CategoriaEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaEventoService {

    private static final String MSG_ENTIDADE_NAO_ENCONTRADO = "Não existe um cadastro com o código %s";
    private static final String MSG_ENTIDADE_EM_USO = "Entidade de código %s não pode ser removido, pois está em uso";

    @Autowired
    private CategoriaEventoRepository categoriaEventoRepository;

    public CategoriaEvento buscarOuFalhar(Long categoriaEventoId) {
        return categoriaEventoRepository.findById(categoriaEventoId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        String.format(MSG_ENTIDADE_NAO_ENCONTRADO, categoriaEventoId))
                );
    }
}
