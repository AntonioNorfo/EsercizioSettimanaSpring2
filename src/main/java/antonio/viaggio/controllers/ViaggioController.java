package antonio.viaggio.controllers;

import antonio.viaggio.entities.Viaggio;
import antonio.viaggio.enums.StatoViaggio;
import antonio.viaggio.services.ViaggioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/viaggi")
public class ViaggioController {

    @Autowired
    private ViaggioService viaggioService;

    @GetMapping
    public List<Viaggio> getAllViaggi() {
        return viaggioService.getAllViaggi();
    }

    @GetMapping("/{id}")
    public Viaggio getViaggioById(@PathVariable UUID id) {
        return viaggioService.getViaggioById(id);
    }

    @PostMapping
    public ResponseEntity<Viaggio> createViaggio(@RequestBody Viaggio viaggio) {
        Viaggio nuovoViaggio = viaggioService.createViaggio(viaggio);
        return new ResponseEntity<>(nuovoViaggio, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/stato")
    public ResponseEntity<Viaggio> updateStatoViaggio(@PathVariable UUID id, @RequestParam StatoViaggio stato) {
        Viaggio viaggioAggiornato = viaggioService.updateStatoViaggio(id, stato);
        return new ResponseEntity<>(viaggioAggiornato, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteViaggio(@PathVariable UUID id) {
        viaggioService.deleteViaggio(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
