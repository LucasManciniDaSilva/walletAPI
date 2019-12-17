package com.wallet.service.impl;

import com.wallet.entity.User;
import com.wallet.repository.UserRepository;
import com.wallet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Override
    public User save(User u) {
        return repository.save(u);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return repository.findByEmailEquals(email);
    }

    @Override
    public User convertDtoToEntity(UserDTO dto) {
        User u = new User();
        u.setEmail(dto.getEmail());
        u.setName(dto.getName());
        u.setPassword(dto.getPassword());

        return u;
    }

    @Override
    public UserDTO convertEntityToDto(User u) {
        UserDTO dto = new UserDTO();
        dto.setEmail(u.getEmail());
        dto.setName(u.getName());
        dto.setPassword(u.getPassword());

        return dto;
    }


}
