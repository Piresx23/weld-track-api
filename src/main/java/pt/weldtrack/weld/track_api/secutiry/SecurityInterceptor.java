package pt.weldtrack.weld.track_api.secutiry;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class SecurityInterceptor {

    @Value("${weldtrack.password.admin:admin1234}")
    private String passwordAdmin;

    @Value("${weldtrack.password.supervisor:supervisor1234}")
    private String passwordSupervisor;

    public void verificarPermissao(HttpServletRequest request, String papelExigido) {
        String papelUtilizador = request.getHeader("X-Role");
        String passwordUtilizador = request.getHeader("X-API-Key");

        if ("ADMIN" .equals(papelUtilizador) && passwordAdmin.equals(passwordUtilizador)) {
            return;
        }

        if ("SUPERVISOR" .equals(papelUtilizador) && passwordSupervisor.equals(passwordUtilizador) && "SUPERVISOR" .equals(papelExigido)) {
            return;
        }

        throw new ResponseStatusException(HttpStatus.FORBIDDEN,
                "Acesso Negado: Credenciais inválidas para o cargo de " + papelExigido);
    }
}
