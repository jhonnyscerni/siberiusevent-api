package br.com.siberius.siberiusevent.repository;

import br.com.siberius.siberiusevent.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
}
