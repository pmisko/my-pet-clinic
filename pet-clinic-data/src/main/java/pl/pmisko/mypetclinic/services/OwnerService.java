package pl.pmisko.mypetclinic.services;

import pl.pmisko.mypetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName (String lastName);

}
