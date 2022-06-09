package persistence;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import model.Aluno;
import model.Disciplina;
import model.Matricula;

public class MatriculaDao implements IObjDao<Matricula>, IMatriculaDao {

	private SessionFactory sf;

	public MatriculaDao(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public void insert(Matricula matricula) {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(matricula);
		transaction.commit();
		
	}

	@Override
	public void update(Matricula matricula) {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(matricula);
		transaction.commit();
		
	}

//	@Override
//	public void delete(Matricula t) {
//		EntityManager entityManager = sf.createEntityManager();
//		EntityTransaction transaction = entityManager.getTransaction();
//		transaction.begin();
//		entityManager.remove(t);
//		transaction.commit();
//		
//	}
	
	@Override
	public void delete(Matricula matricula) {
		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM matricula ");
		sql.append("WHERE ra_aluno = ?1 ");
		sql.append("AND codigo_disciplina = ?2 ");
		
		EntityManager entityManager = sf.createEntityManager();
		Query query = entityManager.createNativeQuery(sql.toString());
		query.setParameter(1, matricula.getAluno().getRa());
		query.setParameter(2, matricula.getDisciplina().getCodigoDisciplina());
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		query.executeUpdate();
		transaction.commit();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public Matricula selectOne(Matricula matricula) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT a.ra, a.nome, a.email, a.posicao_vestibular, ");
		sql.append("d.codigo, d.nome_disc, d.carga_horaria, ");
		sql.append("m.ano, m.semestre ");
		sql.append("FROM aluno a, disciplina d, matricula m ");
		sql.append("WHERE a.ra = m.ra_aluno AND d.codigo = m.codigo_disciplina ");
		sql.append("AND a.ra = ?1 ");
		sql.append("AND d.codigo = ?2 ");

		EntityManager entityManager = sf.createEntityManager();
		Query query = entityManager.createNativeQuery(sql.toString());
		query.setParameter(1, matricula.getAluno().getRa());
		query.setParameter(2, matricula.getDisciplina().getCodigoDisciplina());

		List<Object[]> matriculasResultSet = query.getResultList();

		for (Object[] obj : matriculasResultSet) {
			Aluno aluno = new Aluno();
			aluno.setRa(obj[0].toString());
			aluno.setNome(obj[1].toString());
			aluno.setEmail(obj[2].toString());
			aluno.setPosicaoVestibular(Integer.parseInt(obj[3].toString()));

			Disciplina disciplina = new Disciplina();
			disciplina.setCodigoDisciplina(Integer.parseInt(obj[4].toString()));
			disciplina.setNomeDisciplina(obj[5].toString());
			disciplina.setCargaHoraria(Integer.parseInt(obj[6].toString()));

			matricula = new Matricula();
			matricula.setAluno(aluno);
			matricula.setDisciplina(disciplina);
			matricula.setAno(Integer.parseInt(obj[7].toString()));
			matricula.setSemestre(Integer.parseInt(obj[8].toString()));
			
		}
		return matricula;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Matricula> selectAll() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT a.ra, a.nome, a.email, a.posicao_vestibular, ");
		sql.append("d.codigo, d.nome_disc, d.carga_horaria, ");
		sql.append("m.ano, m.semestre ");
		sql.append("FROM aluno a, disciplina d, matricula m ");
		sql.append("WHERE a.ra = m.ra_aluno AND d.codigo = m.codigo_disciplina ");

		EntityManager entityManager = sf.createEntityManager();
		Query query = entityManager.createNativeQuery(sql.toString());

		List<Object[]> matriculasResultSet = query.getResultList();
		List<Matricula> matriculas = new ArrayList<Matricula>();

		for (Object[] obj : matriculasResultSet) {
			Aluno aluno = new Aluno();
			aluno.setRa(obj[0].toString());
			aluno.setNome(obj[1].toString());
			aluno.setEmail(obj[2].toString());
			aluno.setPosicaoVestibular(Integer.parseInt(obj[3].toString()));

			Disciplina disciplina = new Disciplina();
			disciplina.setCodigoDisciplina(Integer.parseInt(obj[4].toString()));
			disciplina.setNomeDisciplina(obj[5].toString());
			disciplina.setCargaHoraria(Integer.parseInt(obj[6].toString()));

			Matricula matricula = new Matricula();
			matricula.setAluno(aluno);
			matricula.setDisciplina(disciplina);
			matricula.setAno(Integer.parseInt(obj[7].toString()));
			matricula.setSemestre(Integer.parseInt(obj[8].toString()));
			
			matriculas.add(matricula);
		}
		return matriculas;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Matricula> selectOneDisciplina(Matricula matricula) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT a.ra, a.nome, a.email, a.posicao_vestibular, ");
		sql.append("d.codigo, d.nome_disc, d.carga_horaria, ");
		sql.append("m.ano, m.semestre ");
		sql.append("FROM aluno a, disciplina d, matricula m ");
		sql.append("WHERE a.ra = m.ra_aluno AND d.codigo = m.codigo_disciplina ");
		sql.append("AND d.codigo = ?1 ");

		EntityManager entityManager = sf.createEntityManager();
		Query query = entityManager.createNativeQuery(sql.toString());
		query.setParameter(1, matricula.getDisciplina().getCodigoDisciplina());

		List<Object[]> matriculasResultSet = query.getResultList();
		List<Matricula> matriculas = new ArrayList<Matricula>();

		for (Object[] obj : matriculasResultSet) {
			Aluno aluno = new Aluno();
			aluno.setRa(obj[0].toString());
			aluno.setNome(obj[1].toString());
			aluno.setEmail(obj[2].toString());
			aluno.setPosicaoVestibular(Integer.parseInt(obj[3].toString()));

			Disciplina disciplina = new Disciplina();
			disciplina.setCodigoDisciplina(Integer.parseInt(obj[4].toString()));
			disciplina.setNomeDisciplina(obj[5].toString());
			disciplina.setCargaHoraria(Integer.parseInt(obj[6].toString()));

			matricula = new Matricula();
			matricula.setAluno(aluno);
			matricula.setDisciplina(disciplina);
			matricula.setAno(Integer.parseInt(obj[7].toString()));
			matricula.setSemestre(Integer.parseInt(obj[8].toString()));
			
			matriculas.add(matricula);
		}
		return matriculas;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Matricula> selectOneAluno(Matricula matricula) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT a.ra, a.nome, a.email, a.posicao_vestibular, ");
		sql.append("d.codigo, d.nome_disc, d.carga_horaria, ");
		sql.append("m.ano, m.semestre ");
		sql.append("FROM aluno a, disciplina d, matricula m ");
		sql.append("WHERE a.ra = m.ra_aluno AND d.codigo = m.codigo_disciplina ");
		sql.append("AND a.ra = ?1 ");

		EntityManager entityManager = sf.createEntityManager();
		Query query = entityManager.createNativeQuery(sql.toString());
		query.setParameter(1, matricula.getAluno().getRa());

		List<Object[]> matriculasResultSet = query.getResultList();
		List<Matricula> matriculas = new ArrayList<Matricula>();

		for (Object[] obj : matriculasResultSet) {
			Aluno aluno = new Aluno();
			aluno.setRa(obj[0].toString());
			aluno.setNome(obj[1].toString());
			aluno.setEmail(obj[2].toString());
			aluno.setPosicaoVestibular(Integer.parseInt(obj[3].toString()));

			Disciplina disciplina = new Disciplina();
			disciplina.setCodigoDisciplina(Integer.parseInt(obj[4].toString()));
			disciplina.setNomeDisciplina(obj[5].toString());
			disciplina.setCargaHoraria(Integer.parseInt(obj[6].toString()));

			matricula = new Matricula();
			matricula.setAluno(aluno);
			matricula.setDisciplina(disciplina);
			matricula.setAno(Integer.parseInt(obj[7].toString()));
			matricula.setSemestre(Integer.parseInt(obj[8].toString()));
			
			matriculas.add(matricula);
		}
		return matriculas;
		
	}

}
