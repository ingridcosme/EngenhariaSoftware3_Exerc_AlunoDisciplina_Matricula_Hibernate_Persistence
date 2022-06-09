package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import model.Matricula;
import persistence.MatriculaDao;
import util.HibernateUtil;

public class MatriculaController implements OperacoesMatricula<Matricula> {

	@Override
	public void salvar(Matricula matricula) throws SQLException {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		MatriculaDao matriculaDao = new MatriculaDao(sessionFactory);
		matriculaDao.insert(matricula);
		
	}

	@Override
	public void modificar(Matricula matricula) throws SQLException {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		MatriculaDao matriculaDao = new MatriculaDao(sessionFactory);
		matricula = matriculaDao.selectOne(matricula);
		matriculaDao.update(matricula);
		
	}

	@Override
	public void remover(Matricula matricula) throws SQLException {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		MatriculaDao matriculaDao = new MatriculaDao(sessionFactory);
		matriculaDao.delete(matricula);
		
	}

	@Override
	public List<Matricula> consultar(Matricula matricula) throws SQLException {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		MatriculaDao matriculaDao = new MatriculaDao(sessionFactory);
		List<Matricula> matriculas = new ArrayList<Matricula>();
		if (matricula.getAluno().getRa() != null) {
			matriculas = matriculaDao.selectOneAluno(matricula);
		} else {
			if (matricula.getDisciplina().getCodigoDisciplina() > 0) {
				matriculas = matriculaDao.selectOneDisciplina(matricula);
			}
		}
		return matriculas;
		
	}

	@Override
	public List<Matricula> listar() throws SQLException {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		MatriculaDao matriculaDao = new MatriculaDao(sessionFactory);
		List<Matricula> matriculas = new ArrayList<Matricula>();
		matriculas = matriculaDao.selectAll();
		return matriculas;
		
	}
	
	public List<Matricula> listarMatriculadosNaDisciplina(Matricula matricula) throws SQLException {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		MatriculaDao matriculaDao = new MatriculaDao(sessionFactory);
		List<Matricula> matriculas = new ArrayList<Matricula>();
		matriculas = matriculaDao.selectOneDisciplina(matricula);
		return matriculas;
		
	}

}
