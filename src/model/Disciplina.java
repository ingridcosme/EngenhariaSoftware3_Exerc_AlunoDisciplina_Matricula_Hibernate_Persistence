package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "disciplina")
public class Disciplina {

	@Id
	@Column(name = "codigo")
	@NotNull
	private int codigoDisciplina;
	
	@Column(name = "nome_disc", length = 50)
	@NotNull
	private String nomeDisciplina;
	
	@Column(name = "carga_horaria")
	@NotNull
	private int cargaHoraria;

	public int getCodigoDisciplina() {
		return codigoDisciplina;
	}

	public void setCodigoDisciplina(int codigoDisciplina) {
		this.codigoDisciplina = codigoDisciplina;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	@Override
	public String toString() {
		return "Disciplina [codigoDisciplina=" + codigoDisciplina + ", nomeDisciplina=" + nomeDisciplina
				+ ", cargaHoraria=" + cargaHoraria + "]";
	}
	
	
}
