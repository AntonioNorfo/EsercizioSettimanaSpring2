package antonio.viaggio.payloads;


import java.util.UUID;

public record DipendenteDTO(UUID dipendenteId, String username, String nome, String cognome, String email
) {
}
