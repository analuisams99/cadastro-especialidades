package app.trybe.specialityapp.service;

import app.trybe.specialityapp.model.Professional;
import app.trybe.specialityapp.repository.ProfessionalRepository;
import java.util.List;
import javax.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**Classe ProfessionalService. */
@Service
public class ProfessionalService {
  @Autowired
  private ProfessionalRepository repository;
  
  /**Método de encontrar todos os profissionais listados.*/
  public List<Professional> findAll() {
    return repository.findAll();
  }
  
  /**Método de achar um profissional pelo id.*/
  public Professional findById(Integer id) {
    return repository.findById(id).orElseThrow(() -> 
        new NotFoundException("Não foi possível encontrar o profissional com o ID informado."));
  }
  
  /**Método de inserir um novo profissional.*/
  public Professional save(Professional professional) {
    return repository.save(professional);
  }
  
  /**Método de atualizar o nome e a especialidade de um profissional.*/
  public Professional update(Integer id, Professional professional) {
    Professional existingProfessional = findById(id);
    existingProfessional.setName(professional.getName());
    existingProfessional.setSpeciality(professional.getSpeciality());
    return repository.save(existingProfessional);
  }
  
  /**Método de deletar um profissional pelo id..*/
  public void delete(Integer id) {
    Professional existingProfessional = findById(id);
    repository.delete(existingProfessional);
  }
}

