package app.trybe.specialityapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**Classe Professional. */
@Entity
public class Professional {

  @Id
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  
  @Column
  private String name;
  
  @Column
  private String speciality;
  
  /**Construtor vazio para uso do JPA.*/
  public Professional() {}

  /**Construtor da classe Professional.*/
  public Professional(Integer id, String name, String  speciality) {
    this.id = id;
    this.name = name;
    this.speciality = speciality;
  }

  public Integer getId() {
    return id;
  }
  
  public void setId(Integer id) {
    this.id = id;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getSpeciality() {
    return speciality;
  }
  
  public void setSpeciality(String speciality) {
    this.speciality = speciality;
  }
  
}
