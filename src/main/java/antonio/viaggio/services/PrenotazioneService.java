package antonio.viaggio.services;

import antonio.viaggio.entities.Prenotazione;
import antonio.viaggio.exceptions.PrenotazioneNotFoundException;
import antonio.viaggio.repositories.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public List<Prenotazione> getAllPrenotazioni() {
        return prenotazioneRepository.findAll();
    }

    public Prenotazione getPrenotazioneById(UUID id) {
        return prenotazioneRepository.findById(id)
                .orElseThrow(() -> new PrenotazioneNotFoundException("Prenotazione non trovata"));
    }

    public Prenotazione createPrenotazione(Prenotazione prenotazione) {
        if (prenotazioneRepository.existsByDipendenteAndDataRichiesta(prenotazione.getDipendente(), prenotazione.getDataRichiesta())) {
            throw new IllegalStateException("Il dipendente ha già una prenotazione per questa data.");
        }
        return prenotazioneRepository.save(prenotazione);
    }

    public void deletePrenotazione(UUID id) {
        Prenotazione prenotazione = getPrenotazioneById(id);
        prenotazioneRepository.delete(prenotazione);
    }
}
