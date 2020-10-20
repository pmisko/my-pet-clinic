package pl.pmisko.mypetclinic.services.map;

import org.springframework.stereotype.Service;
import pl.pmisko.mypetclinic.model.Vet;
import pl.pmisko.mypetclinic.services.VetService;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

        @Override
        public Set<Vet> findAll() {
            return super.findAll();
        }

        @Override
        public void deleteById(Long id) {
            super.deleteById(id);
        }

        @Override
        public void delete(Vet vet) {
            super.delete(vet);
        }

        @Override
        public Vet save(Vet vet) {
            return super.save(vet);
        }

        @Override
        public Vet findById(Long id) {
            return super.findById(id);
        }
}
