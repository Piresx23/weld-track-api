package pt.weldtrack.weld.track_api.secutiry;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class SecurityInterceptor {

    private String passwordAdmin = "$2a$10$bIMDM1kMS1XJuuocN1k84OpWtKXJaCD0WELPsq0p3Wd/L8Dqhy7FG";

    private String passwordSupervisor = "$2a$10$iScNjehTZ3nREglGmtIMAuP1DyvZHLEQDDzDRguleN.xH8U1iN1Ja";

    public void verificarPermissao(HttpServletRequest request, String papelExigido) {
        String papelUtilizador = request.getHeader("X-Role");
        String passwordUtilizador = request.getHeader("X-API-Key");

        if (passwordUtilizador == null || papelUtilizador == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Credenciais ausentes nos Headers.");
        }

        if ("Admin".equals(papelUtilizador) && org.springframework.security.crypto.bcrypt.BCrypt.checkpw(passwordUtilizador, passwordAdmin)) {
            return;
        }

        if ("Supervisor" .equals(papelUtilizador) && org.springframework.security.crypto.bcrypt.BCrypt.checkpw(passwordUtilizador, passwordSupervisor)) {
            return;
        }

        throw new ResponseStatusException(HttpStatus.FORBIDDEN,
                "Acesso Negado: Credenciais inválidas para o cargo de " + papelExigido);
    }
}
