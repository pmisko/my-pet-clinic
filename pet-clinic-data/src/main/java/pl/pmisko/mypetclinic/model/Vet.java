package pl.pmisko.mypetclinic.model;

import java.util.Set;

public class Vet extends Person {

    Set<Specialty> specialties;

    public Vet() {
    }

    public Vet(Set<Specialty> specialties) {
        this.specialties = specialties;
    }

    public Set<Specialty> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(Set<Specialty> specialties) {
        this.specialties = specialties;
    }
}