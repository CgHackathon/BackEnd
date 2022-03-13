package App.services.Implementation;

import App.models.DTO.LogInRequest;
import App.security.JWT.JwtTokenUtil;
import App.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import App.models.User;
import App.repos.UserRepo;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserDetailsService , UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepo.findById(username);
        if (user.isPresent())
            return user.get();
        throw new UsernameNotFoundException("User '" + username + "' not found");
    }

    @Override
    public User handleUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return user;
    }

    @Override
    public User get(String userName) {
        Optional <User> user = userRepo.findById(userName);
        return user.orElse(null);
    }

    @Override
    public ResponseEntity<?> login(LogInRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));
        final User user = userRepo.getById(request.getUserName());
        final String token = jwtTokenUtil.generateToken(user);
        return ResponseEntity.ok("{\"token\": \"" + token + "\"}");
    }

    @Override
    public void signUser(User user) {
        if (userRepo.existsById(user.getUsername()))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error: User name is already in use!");
        userRepo.save(handleUser(user));
    }
}

