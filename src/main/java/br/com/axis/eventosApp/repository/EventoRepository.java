package br.com.axis.eventosApp.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.axis.eventosApp.models.Evento;

public interface EventoRepository extends CrudRepository<Evento, String>{
	Evento findByCodigo(Long codigo);
}
