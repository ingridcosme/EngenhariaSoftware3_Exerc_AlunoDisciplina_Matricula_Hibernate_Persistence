package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import model.Disciplina;
import persistence.DisciplinaDao;
import util.HibernateUtil;

public class DisciplinaController implements OperacoesController<Disciplina> {

	@Override
	public void salvar(Disciplina disciplina) throws SQLException {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		DisciplinaDao disciplinaDao = new DisciplinaDao(sessionFactory);
		disciplinaDao.insert(disciplina);
		
	}

	@Override
	public void modificar(Disciplina disciplina) throws SQLException {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		DisciplinaDao disciplinaDao = new DisciplinaDao(sessionFactory);
		disciplinaDao.update(disciplina);
		
	}

	@Override
	public void remover(Disciplina disciplina) throws SQLException {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		DisciplinaDao disciplinaDao = new DisciplinaDao(sessionFactory);
		disciplinaDao.delete(disciplina);
		
	}

	@Override
	public Disciplina consultar(Disciplina disciplina) throws SQLException {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		DisciplinaDao disciplinaDao = new DisciplinaDao(sessionFactory);
		disciplina = disciplinaDao.selectOne(disciplina);
		return disciplina;
		
	}

	@Override
	public List<Disciplina> listar() throws SQLException {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		DisciplinaDao disciplinaDao = new DisciplinaDao(sessionFactory);
		List<Disciplina> disciplinas = new ArrayList<Disciplina>();
		disciplinas = disciplinaDao.selectAll();
		return disciplinas;
		
	}
	
}
