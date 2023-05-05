package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.user.AuthDto;
import med.voll.api.domain.user.User;
import med.voll.api.infra.security.TokenDto;
import med.voll.api.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticatorController {
@Autowired
private AuthenticationManager authenticationManager;

@Autowired
private TokenService tokenService;
    @PostMapping
    public ResponseEntity auth(@RequestBody @Valid AuthDto authDto) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(authDto.login(), authDto.password());
        var authentication = authenticationManager.authenticate(authenticationToken);
        var tokenJWT = tokenService.generateToken((User) authentication.getPrincipal());
        return ResponseEntity.ok(new TokenDto(tokenJWT));
    }
}
