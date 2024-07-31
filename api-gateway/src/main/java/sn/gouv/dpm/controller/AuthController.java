package sn.gouv.dpm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import sn.gouv.dpm.model.Role;
import sn.gouv.dpm.model.RoleName;
import sn.gouv.dpm.model.User;
import sn.gouv.dpm.payload.*;
import sn.gouv.dpm.repository.RoleRepository;
import sn.gouv.dpm.security.JwtTokenProvider;
import sn.gouv.dpm.service.UserService;

import java.util.Collections;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;
    
    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(),
                loginRequest.getPassword()
            )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.generateToken(authentication);

        return ResponseEntity.ok(new JwtResponse(jwt));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody SignUpRequest signUpRequest) {
        if (userService.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new ApiResponse(false, "Nom d'utilisateur déjà utilisé!"));
        }

        if (userService.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new ApiResponse(false, "Adresse e-mail déjà utilisée!"));
        }

        // Creating user's account
        User user = new User(signUpRequest.getUsername(), signUpRequest.getPassword(), signUpRequest.getEmail());

        Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Rôle de l'utilisateur non défini."));

        user.setRoles(Collections.singleton(userRole));

        User result = userService.save(user);

        return ResponseEntity.ok(new ApiResponse(true, "Utilisateur enregistré avec succès"));
    }
}
