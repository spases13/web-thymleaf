package ma.epolytechnique.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ma.epolytechnique.entities.Employe;
import ma.epolytechnique.metier.IEmploye;

@Controller
public class EmployeController {

	@Autowired
	IEmploye employeservice;

	/*
	 * @RequestMapping(value = "/employes", method = RequestMethod.GET) public
	 * String employes(Model model) { model.addAttribute("employes",
	 * employeservice.alleemployes()); return "employes"; }
	 */
	
	@RequestMapping(value = "/employes", method = RequestMethod.GET)
	public String displayEmployes(Model model, @RequestParam(value = "genre", required = false) String genre) {
	    List<Employe> employes;

	    if (genre != null && (genre.equals("m") || genre.equals("f"))) {
	        // If genre parameter is provided and is either "m" or "f", filter by genre
	        employes = employeservice.employebygenre(genre);
	    } else {
	        // Otherwise, retrieve all employees
	        employes = employeservice.alleemployes();
	    }

	    model.addAttribute("employes", employes);
	    model.addAttribute("selectedGenre", genre); 
	    // Add selectedGenre attribute for retaining the selected genre in the view
	    return "employes";
	}
	

	@RequestMapping(value = "/addemploye", method = RequestMethod.POST)
	public String addemploye(Model model, @RequestParam String nom, @RequestParam String genre,
			@RequestParam double salaire) {
		employeservice.addemploye(new Employe(nom, genre, salaire));
		model.addAttribute("employes", employeservice.alleemployes());
		return "redirect:/employes";
	}

	@RequestMapping(value = "/newemploye", method = RequestMethod.GET)
	public String addemploye(Model model) {
		return "newemploye";
	}

	@RequestMapping(value = "/deleteemp/{id}", method = RequestMethod.POST)
	public String deleteemp(Model model, @PathVariable long id) {
		employeservice.deleteemploye(id);
		model.addAttribute("employes", employeservice.alleemployes());

		return "redirect:/employes";
	}

	/*
	 * @RequestMapping(value = "/employes/genre={genre}", method =
	 * RequestMethod.GET) public String deleteemp(Model model, @PathVariable String
	 * genre) { if (!genre.equalsIgnoreCase("All")) {
	 * 
	 * model.addAttribute("employes", employeservice.employebygenre(genre)); } else
	 * { model.addAttribute("employes", employeservice.alleemployes()); }
	 * 
	 * return "employes"; }
	 */

}
