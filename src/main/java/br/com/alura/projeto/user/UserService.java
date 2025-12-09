package br.com.alura.projeto.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User verifyAndGetInstructorByEmail(String email) {
        if (!repository.existsByEmail(email)) throw new IllegalArgumentException("This instructor does not exist");

        return repository.findByEmail(email);
    }
}
