package br.com.axis.eventosApp.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Convidado {
	
	@Id
	@NotBlank
	private String rg;
	
	@NotBlank
	private String nomeConvidado;
		
	@ManyToOne
	private Evento evento;
}
