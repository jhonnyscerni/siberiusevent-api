package br.com.siberius.siberiusevent.repository;

import br.com.siberius.siberiusevent.model.Palestrante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PalestranteRepository extends JpaRepository<Palestrante, Long> {

    @Query("select c from Palestrante c inner join c.evento e where e.id = ?1")
    List<Palestrante> findAllByEventoId(Long idEvento);
}
