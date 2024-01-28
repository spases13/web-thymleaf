package ma.epolytechnique.metier;

import java.util.List;

import ma.epolytechnique.entities.Employe;

public interface IEmploye {
	public List<Employe> alleemployes();
	public List<Employe> employebygenre(String genre);
	public String addemploye(Employe e);
	public String deleteemploye(long id);
	public String updateemploye(long id, String nom, String genre, double salaire);
}
