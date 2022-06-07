package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "matricula")
public class Matricula {

	@Id
	@ManyToOne
	@JoinColumn(name = "ra_aluno")
	@NotNull
	private Aluno aluno;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "codigo_disciplina")
	@NotNull
	private Disciplina disciplina;
	
	@Column(name="ano")
	@NotNull
	private int ano;
	
	@Column(name="semestre")
	@NotNull
	private int semestre;

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	@Override
	public String toString() {
		return "Matricula [aluno=" + aluno + ", disciplina=" + disciplina + ", ano=" + ano + ", semestre=" + semestre
				+ "]";
	}

	
	
}
