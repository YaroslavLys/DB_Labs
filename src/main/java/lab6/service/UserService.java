package lab6.service;

import lab6.domain.User;
import lab6.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService extends AbstractService<User, Integer> {
    public UserRepository userRepository;

    @Override
    protected JpaRepository<User, Integer> getRepository() {
        return userRepository;
    }
}
