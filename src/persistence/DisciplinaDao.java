package persistence;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import model.Disciplina;

public class DisciplinaDao implements IObjDao<Disciplina> {

	private SessionFactory sf;
	
	public DisciplinaDao(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public void insert(Disciplina disciplina) {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(disciplina);
		transaction.commit();
		
	}

	@Override
	public void update(Disciplina disciplina) {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(disciplina);
		transaction.commit();
		
	}

	@Override
	public void delete(Disciplina disciplina) {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.remove(disciplina);
		transaction.commit();
		
	}

	@Override
	public Disciplina selectOne(Disciplina disciplina) {
		EntityManager entityManager = sf.createEntityManager();
		disciplina = entityManager.find(Disciplina.class, disciplina.getCodigoDisciplina());
		return disciplina;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Disciplina> selectAll() {
		String sql = "SELECT codigo, nome_disc, carga_horaria FROM disciplina";
		EntityManager entityManager = sf.createEntityManager();
		Query query = entityManager.createNativeQuery(sql);
		List<Object[]> disciplinasResultSet = query.getResultList();
		List<Disciplina> disciplinas = new ArrayList<Disciplina>();
		for (Object[] obj : disciplinasResultSet) {
			Disciplina disciplina = new Disciplina();
			disciplina.setCodigoDisciplina(Integer.parseInt(obj[0].toString()));
			disciplina.setNomeDisciplina(obj[1].toString());
			disciplina.setCargaHoraria(Integer.parseInt(obj[2].toString()));
			
			disciplinas.add(disciplina);
		}
		
		return disciplinas;
		
	}

	

}
