package br.com.axis.eventosApp.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.axis.eventosApp.models.Convidado;
import br.com.axis.eventosApp.models.Evento;

public interface ConvidadoRepository extends CrudRepository<Convidado, String>{

		Iterable<Convidado> findByEvento(Evento evento);
		Convidado findByRg(String rg);
}
