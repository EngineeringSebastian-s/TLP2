package practica.com.parcial1.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import practica.com.parcial1.Models.DAO.user.IUserDao;
import practica.com.parcial1.Models.Entity.User;

@Service
public class UserService implements UserDetailsService {


    @Autowired
    private IUserDao repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repository.findByEmail(email);
        if (user != null) {
            return (UserDetails) User.builder()
                    .email(user.getEmail())
                    .password(user.getPassword())
                    .role("Cliente")
                    .build();
        } else {
            throw new UsernameNotFoundException(email);
        }
    }

}