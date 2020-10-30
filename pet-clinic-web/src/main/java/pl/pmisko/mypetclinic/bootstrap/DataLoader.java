package pl.pmisko.mypetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.pmisko.mypetclinic.model.*;
import pl.pmisko.mypetclinic.services.OwnerService;
import pl.pmisko.mypetclinic.services.PetTypeService;
import pl.pmisko.mypetclinic.services.SpecialtyService;
import pl.pmisko.mypetclinic.services.VetService;

import java.time.LocalDate;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");

        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        petTypeService.save(savedCatPetType);
        petTypeService.save(savedDogPetType);

        Specialty radiology = new Specialty();
        radiology.setDescription("radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);


        Owner owner1 = new Owner();
        owner1.setFirstName("Piotr");
        owner1.setLastName("Misko");
        owner1.setAddress("Lesna");
        owner1.setCity("Poznan");
        owner1.setTelephone("123123");

        Pet petersPet = new Pet();
        petersPet.setPetType(savedDogPetType);
        petersPet.setOwner(owner1);
        petersPet.setBirthDate(LocalDate.now());
        petersPet.setName("Doggy");
        owner1.getPets().add(petersPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Misko");
        owner2.setAddress("Lesna");
        owner2.setCity("Poznan");
        owner2.setTelephone("123123");

        Pet fionasPet = new Pet();
        fionasPet.setName("Meow");
        fionasPet.setBirthDate(LocalDate.now());
        fionasPet.setOwner(owner2);
        fionasPet.setPetType(savedCatPetType);
        owner2.getPets().add(fionasPet);

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Wet1");
        vet1.setLastName("Jeden");
        vet1.getSpecialties().add(savedDentistry);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("WET2");
        vet2.setLastName("Drugi");
        vet2.getSpecialties().add(savedRadiology);

        vetService.save(vet2);

        System.out.println("Loaded Vets");
    }
}
