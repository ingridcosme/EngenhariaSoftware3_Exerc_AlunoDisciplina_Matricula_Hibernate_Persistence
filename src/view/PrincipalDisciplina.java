package view;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.SessionFactory;

import controller.DisciplinaController;
import model.Disciplina;
import util.HibernateUtil;

public class PrincipalDisciplina {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		SessionFactory sf = HibernateUtil.getSessionFactory();
		
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
		
		DisciplinaController dCont = new DisciplinaController();
		
		try {
			dCont.salvar(d1);
			dCont.salvar(d2);
			dCont.salvar(d3);
			dCont.salvar(d4);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			d4.setCodigoDisciplina(111);
			dCont.modificar(d4);
			d4 = dCont.consultar(d4);
			System.out.println(d4);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			List<Disciplina> disciplinas = dCont.listar();
			disciplinas.forEach(d -> System.out.println(d));
			dCont.remover(d3);
			disciplinas = dCont.listar();
			disciplinas.forEach(d -> System.out.println(d));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
