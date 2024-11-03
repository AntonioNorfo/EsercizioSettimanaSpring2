package antonio.viaggio.services;

import antonio.viaggio.entities.Dipendente;
import antonio.viaggio.exceptions.DipendenteNotFoundException;
import antonio.viaggio.repositories.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DipendenteService {

    @Autowired
    private DipendenteRepository dipendenteRepository;

    public List<Dipendente> getAllDipendenti() {
        return dipendenteRepository.findAll();
    }

    public Dipendente getDipendenteById(UUID id) {
        return dipendenteRepository.findById(id)
                .orElseThrow(() -> new DipendenteNotFoundException("Dipendente non trovato"));
    }

    public Dipendente createDipendente(Dipendente dipendente) {
        return dipendenteRepository.save(dipendente);
    }

    public Dipendente updateDipendente(UUID id, Dipendente dipendente) {
        Dipendente existingDipendente = getDipendenteById(id);
        existingDipendente.setUsername(dipendente.getUsername());
        existingDipendente.setNome(dipendente.getNome());
        existingDipendente.setCognome(dipendente.getCognome());
        existingDipendente.setEmail(dipendente.getEmail());
        return dipendenteRepository.save(existingDipendente);
    }

    public void deleteDipendente(UUID id) {
        Dipendente dipendente = getDipendenteById(id);
        dipendenteRepository.delete(dipendente);
    }
}
