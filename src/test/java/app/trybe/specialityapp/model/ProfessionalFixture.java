package app.trybe.specialityapp.model;

public class ProfessionalFixture {

    public static Professional anyToEdit(){
        return new Professional(1, "Bruce Wayne", "Scientist");
    }
    
    public static Professional anyToInsert(){
        return new Professional(null, "William Birkin", "Scientist");
    }

}
