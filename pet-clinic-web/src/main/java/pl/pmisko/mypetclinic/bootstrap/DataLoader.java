package pl.pmisko.mypetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.pmisko.mypetclinic.model.Owner;
import pl.pmisko.mypetclinic.model.Vet;
import pl.pmisko.mypetclinic.services.OwnerService;
import pl.pmisko.mypetclinic.services.VetService;
import pl.pmisko.mypetclinic.services.map.OwnerServiceMap;
import pl.pmisko.mypetclinic.services.map.VetServiceMap;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Piotr");
        owner1.setLastName("Misko");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Piotrek");
        owner2.setLastName("Misko2");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Wet1");
        vet1.setLastName("Jeden");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("WET2");
        vet2.setLastName("Drugi");

        vetService.save(vet2);

        System.out.println("Loaded Vets");
    }
}
