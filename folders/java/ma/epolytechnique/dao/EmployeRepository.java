package ma.epolytechnique.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.epolytechnique.entities.Employe;


@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long>  {

}
