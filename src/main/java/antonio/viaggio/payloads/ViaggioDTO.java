package antonio.viaggio.payloads;

import antonio.viaggio.enums.StatoViaggio;

import java.time.LocalDate;
import java.util.UUID;

public record ViaggioDTO(UUID viaggioId, String destinazione, LocalDate data, StatoViaggio stato

) {
}
