package antonio.viaggio.payloads;


import java.time.LocalDate;
import java.util.UUID;

public record RichiestaPrenotazioneDTO(UUID viaggioId, UUID dipendenteId, LocalDate dataRichiesta, String note
) {

}
