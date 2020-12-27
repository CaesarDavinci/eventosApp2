package br.com.axis.eventosApp.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Convidado {
	
	@Id
	private String rg;
	private String nomeConvidado;
	
	@ManyToOne
	private Evento evento;
}
