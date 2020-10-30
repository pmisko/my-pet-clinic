package pl.pmisko.mypetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.pmisko.mypetclinic.model.Owner;
import pl.pmisko.mypetclinic.model.PetType;
import pl.pmisko.mypetclinic.model.Vet;
import pl.pmisko.mypetclinic.services.OwnerService;
import pl.pmisko.mypetclinic.services.PetTypeService;
import pl.pmisko.mypetclinic.services.VetService;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        petTypeService.save(savedCatPetType);
        petTypeService.save(savedDogPetType);



        Owner owner1 = new Owner();
        owner1.setFirstName("Piotr");
        owner1.setLastName("Misko");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Piotrek");
        owner2.setLastName("Misko2");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Wet1");
        vet1.setLastName("Jeden");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("WET2");
        vet2.setLastName("Drugi");

        vetService.save(vet2);

        System.out.println("Loaded Vets");
    }
}
