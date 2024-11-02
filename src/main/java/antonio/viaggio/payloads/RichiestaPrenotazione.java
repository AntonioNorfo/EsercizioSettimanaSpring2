package antonio.viaggio.payloads;


import java.time.LocalDate;
import java.util.UUID;

public record RichiestaPrenotazione(UUID viaggioId, UUID dipendenteId, LocalDate dataRichiesta, String note
) {
}
