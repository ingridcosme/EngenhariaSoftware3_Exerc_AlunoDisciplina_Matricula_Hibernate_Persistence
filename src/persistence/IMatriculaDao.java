package persistence;

import java.util.List;

import model.Matricula;

public interface IMatriculaDao {

	public List<Matricula> selectOneAluno(Matricula matricula);
	public List<Matricula> selectOneDisciplina(Matricula matricula);
	
}
