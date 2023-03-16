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
  
  public Integer getId() {
    return id;
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
