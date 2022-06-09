package view;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.SessionFactory;

import controller.MatriculaController;
import model.Aluno;
import model.Disciplina;
import model.Matricula;
import util.HibernateUtil;

public class PrincipalMatricula {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		SessionFactory sf = HibernateUtil.getSessionFactory();
		
		Aluno a1 = new Aluno();
		a1.setRa("8945880");
		a1.setNome("Ingrid Santos");
		a1.setEmail("ingrid.santos@gmail.com");
		a1.setPosicaoVestibular(130);
		
		Aluno a2 = new Aluno();
		a2.setRa("8843850");
		a2.setNome("Camila Silva");
		a2.setEmail("camila.silva@gmail.com");
		a2.setPosicaoVestibular(530);
		
		Aluno a3 = new Aluno();
		a3.setRa("8348820");
		a3.setNome("Andre Souza");
		a3.setEmail("andre.souza@gmail.com");
		a3.setPosicaoVestibular(258);
		
		Aluno a4 = new Aluno();
		a4.setRa("8949970");
		a4.setNome("Carlos Andrade");
		a4.setEmail("carlos.andrade@gmail.com");
		a4.setPosicaoVestibular(192);
		
		Disciplina d1 = new Disciplina();
		d1.setCodigoDisciplina(100);
		d1.setNomeDisciplina("Engenharia de Software");
		d1.setCargaHoraria(360);
		
		Disciplina d2 = new Disciplina();
		d2.setCodigoDisciplina(101);
		d2.setNomeDisciplina("Banco de Dados");
		d2.setCargaHoraria(360);
		
		Disciplina d3 = new Disciplina();
		d3.setCodigoDisciplina(102);
		d3.setNomeDisciplina("Linguagem de Progamação");
		d3.setCargaHoraria(280);
		
		Disciplina d4 = new Disciplina();
		d4.setCodigoDisciplina(103);
		d4.setNomeDisciplina("Gestão de Projetos");
		d4.setCargaHoraria(280);
		
		Matricula m1 = new Matricula();
		m1.setAluno(a1);
		m1.setDisciplina(d2);
		m1.setAno(2022);
		m1.setSemestre(1);
		
		Matricula m2 = new Matricula();
		m2.setAluno(a1);
		m2.setDisciplina(d4);
		m2.setAno(2022);
		m2.setSemestre(2);
		
		Matricula m3 = new Matricula();
		m3.setAluno(a2);
		m3.setDisciplina(d1);
		m3.setAno(2022);
		m3.setSemestre(1);
		
		Matricula m4 = new Matricula();
		m4.setAluno(a2);
		m4.setDisciplina(d2);
		m4.setAno(2022);
		m4.setSemestre(2);
		
		Matricula m5 = new Matricula();
		m5.setAluno(a4);
		m5.setDisciplina(d2);
		m5.setAno(2022);
		m5.setSemestre(1);
		
		Matricula m6 = new Matricula();
		m6.setAluno(a4);
		m6.setDisciplina(d4);
		m6.setAno(2022);
		m6.setSemestre(2);
		
		MatriculaController mCont = new MatriculaController();
		
		try {
			mCont.salvar(m1);
			mCont.salvar(m2);
			mCont.salvar(m3);
			mCont.salvar(m4);
			mCont.salvar(m5);
			mCont.salvar(m6);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			m1.setAno(2021);
			mCont.modificar(m1);
			List<Matricula> matriculas = mCont.consultar(m1);
			matriculas.forEach(m -> System.out.println(m));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			List<Matricula> matriculas = mCont.listarMatriculadosNaDisciplina(m6);
			matriculas.forEach(m -> System.out.println(m));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			List<Matricula> matriculas = mCont.listar();
			matriculas.forEach(m -> System.out.println(m));
			mCont.remover(m6);
			matriculas = mCont.listar();
			matriculas.forEach(m -> System.out.println(m));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
