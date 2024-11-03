package antonio.viaggio.services;

import antonio.viaggio.entities.Viaggio;
import antonio.viaggio.enums.StatoViaggio;
import antonio.viaggio.exceptions.ViaggioNotFoundException;
import antonio.viaggio.repositories.ViaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ViaggioService {

    @Autowired
    private ViaggioRepository viaggioRepository;

    public List<Viaggio> getAllViaggi() {
        return viaggioRepository.findAll();
    }

    public Viaggio getViaggioById(UUID id) {
        return viaggioRepository.findById(id)
                .orElseThrow(() -> new ViaggioNotFoundException("Viaggio non trovato"));
    }

    public Viaggio createViaggio(Viaggio viaggio) {
        return viaggioRepository.save(viaggio);
    }

    public Viaggio updateStatoViaggio(UUID id, StatoViaggio stato) {
        Viaggio viaggio = getViaggioById(id);
        viaggio.setStato(stato);
        return viaggioRepository.save(viaggio);
    }

    public void deleteViaggio(UUID id) {
        Viaggio viaggio = getViaggioById(id);
        viaggioRepository.delete(viaggio);
    }
}
