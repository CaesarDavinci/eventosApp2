package br.com.axis.eventosApp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
//import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Convidado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private String rg;
	

	private String nomeConvidado;
		
	@ManyToOne
	private Evento evento;
}
