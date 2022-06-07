package persistence;

import java.util.List;

import model.Matricula;

public interface IMatriculaDao {

	public List<Matricula> selectAllAlunos(Matricula matricula);
	
}
