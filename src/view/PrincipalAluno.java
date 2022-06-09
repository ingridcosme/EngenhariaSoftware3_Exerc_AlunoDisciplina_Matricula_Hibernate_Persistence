package view;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.SessionFactory;

import controller.AlunoController;
import model.Aluno;
import util.HibernateUtil;

public class PrincipalAluno {

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
		
		AlunoController aCont = new AlunoController();
		
		try {
			aCont.salvar(a1);
			aCont.salvar(a2);
			aCont.salvar(a3);
			aCont.salvar(a4);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			a4.setPosicaoVestibular(191);
			aCont.modificar(a4);
			a4 = aCont.consultar(a4);
			System.out.println(a4);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			List<Aluno> alunos = aCont.listar();
			alunos.forEach(a -> System.out.println(a));
			aCont.remover(a3);
			alunos = aCont.listar();
			alunos.forEach(a -> System.out.println(a));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
