package pe.upc.learningcenterplatform.iam.infrastructure.tokens.jwt;

import org.springframework.security.core.Authentication;
import pe.upc.learningcenterplatform.iam.application.internal.outboundservices.tokens.TokenService;

public interface BearerTokenService extends TokenService {

    String getBearerToken(String token);

    String generateToken(Authentication authentication);
}
