package ma.epolytechnique.metier;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ma.epolytechnique.dao.EmployeRepository;
import ma.epolytechnique.entities.Employe;

@Service
public class EmployeService implements IEmploye{
	
	@Autowired
	EmployeRepository employerepository;

	@Override
	public List<Employe> alleemployes() {
		// TODO Auto-generated method stub
		return employerepository.findAll();
	}

	@Override
	public List<Employe> employebygenre(String genre) {
		List<Employe> employes=new ArrayList<Employe>();
		alleemployes().forEach(e ->
		{
			if(e.getGenre().equalsIgnoreCase(genre))
				employes.add(e);
		});
		
		return employes;
	}

	@Override
	public String addemploye(Employe e) {
		// TODO Auto-generated method stub
		employerepository.save(e);
		return "employe ajouter avec succes";
	}

	@Override
	public String deleteemploye(long id) {
		employerepository.deleteById(id);
		return "employe est suprimmer aves succes";
	}

	@Override
	public String updateemploye(long id, String nom, String genre, double salaire) {
			Employe e = employerepository.findById(id).orElse(null);
			
			if(e != null)
			{
				e.setNomemploye(nom);
				e.setGenre(genre);
				e.setSalaire(salaire);
			}
		return "Employe est mis a jour";
	}

}
