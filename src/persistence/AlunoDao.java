package persistence;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import model.Aluno;

public class AlunoDao implements IObjDao<Aluno> {

	private SessionFactory sf;
	
	public AlunoDao(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public void insert(Aluno aluno) {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(aluno);
		transaction.commit();
		
	}

	@Override
	public void update(Aluno aluno) {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(aluno);
		transaction.commit();
		
	}

	@Override
	public void delete(Aluno aluno) {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.remove(aluno);
		transaction.commit();
		
	}

	@Override
	public Aluno selectOne(Aluno aluno) {
		EntityManager entityManager = sf.createEntityManager();
		aluno = entityManager.find(Aluno.class, aluno.getRa());
		return aluno;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Aluno> selectAll() {
		String sql = "SELECT ra, nome, email, posicao_vestibular FROM aluno";
		EntityManager entityManager = sf.createEntityManager();
		Query query = entityManager.createNativeQuery(sql);
		List<Object[]> alunosResultSet = query.getResultList();
		List<Aluno> alunos = new ArrayList<Aluno>();
		for (Object[] obj : alunosResultSet) {
			Aluno aluno = new Aluno();
			aluno.setRa(obj[0].toString());
			aluno.setNome(obj[1].toString());
			aluno.setEmail(obj[2].toString());
			aluno.setPosicaoVestibular(Integer.parseInt(obj[3].toString()));
			
			alunos.add(aluno);
		}
		
		return alunos;
		
	}

	

}
