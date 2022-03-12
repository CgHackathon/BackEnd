package App.services.Implementation;

import App.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import App.models.User;
import App.repos.UserRepo;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserDetailsService , UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    PasswordEncoder passwordEncoder;

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
}

