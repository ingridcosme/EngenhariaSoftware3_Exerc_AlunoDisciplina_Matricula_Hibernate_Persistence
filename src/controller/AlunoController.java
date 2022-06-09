package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import model.Aluno;
import persistence.AlunoDao;
import util.HibernateUtil;

public class AlunoController implements OperacoesController<Aluno> {

	@Override
	public void salvar(Aluno aluno) throws SQLException {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		AlunoDao alunoDao = new AlunoDao(sessionFactory);
		alunoDao.insert(aluno);
		
	}

	@Override
	public void modificar(Aluno aluno) throws SQLException {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		AlunoDao alunoDao = new AlunoDao(sessionFactory);
		alunoDao.update(aluno);
		
	}

	@Override
	public void remover(Aluno aluno) throws SQLException {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		AlunoDao alunoDao = new AlunoDao(sessionFactory);
		alunoDao.delete(aluno);
		
	}

	@Override
	public Aluno consultar(Aluno aluno) throws SQLException {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		AlunoDao alunoDao = new AlunoDao(sessionFactory);
		aluno = alunoDao.selectOne(aluno);
		return aluno;
		
	}

	@Override
	public List<Aluno> listar() throws SQLException {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		AlunoDao alunoDao = new AlunoDao(sessionFactory);
		List<Aluno> alunos = new ArrayList<Aluno>();
		alunos = alunoDao.selectAll();
		return alunos;
		
	}

}
