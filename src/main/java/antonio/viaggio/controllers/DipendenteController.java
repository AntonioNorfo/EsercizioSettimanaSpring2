package antonio.viaggio.controllers;

import antonio.viaggio.entities.Dipendente;
import antonio.viaggio.services.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/dipendenti")
public class DipendenteController {

    @Autowired
    private DipendenteService dipendenteService;

    @GetMapping
    public List<Dipendente> getAllDipendenti() {
        return dipendenteService.getAllDipendenti();
    }

    @GetMapping("/{id}")
    public Dipendente getDipendenteById(@PathVariable UUID id) {
        return dipendenteService.getDipendenteById(id);
    }

    @PostMapping
    public Dipendente createDipendente(@RequestBody Dipendente dipendente) {
        return dipendenteService.createDipendente(dipendente);
    }

    @PutMapping("/{id}")
    public Dipendente updateDipendente(@PathVariable UUID id, @RequestBody Dipendente dipendente) {
        return dipendenteService.updateDipendente(id, dipendente);
    }

    @DeleteMapping("/{id}")
    public void deleteDipendente(@PathVariable UUID id) {
        dipendenteService.deleteDipendente(id);
    }
}
