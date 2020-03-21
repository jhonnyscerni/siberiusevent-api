package br.com.siberius.siberiusevent.repository;

import br.com.siberius.siberiusevent.model.CategoriaEvento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaEventoRepository extends JpaRepository<CategoriaEvento, Long> {
}
