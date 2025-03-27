package my.test.Task.Management.System.Usr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        System.out.println("UserRepository injected: " + (userRepository != null));
    }

//    public User getUserById(Long userId) {
//        return userRepository.findById(userId)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
//    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(
                String.format("User '%s' not found", email)
        ));
        return UserDetailsImpl.build(user);
    }
}
