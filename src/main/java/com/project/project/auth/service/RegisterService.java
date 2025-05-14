package com.project.project.auth.service;

import com.project.project.auth.dto.RegisterDTO;
import com.project.project.auth.entity.User;
import com.project.project.auth.entity.UserRole;
import com.project.project.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    private UserRepository repository;

    public ResponseEntity registerUser(RegisterDTO data) {


        if (this.repository.findByEmail(data.email()) != null) {
           return ResponseEntity.badRequest().body("Email já cadastrado");
       }

       String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());

        User newUser = new User();
        newUser.setName(data.name());
        newUser.setEmail(data.email());
        newUser.setPassword(encryptedPassword);
        newUser.setRole(data.role());
        this.repository.save(newUser);

        return ResponseEntity.ok().body("Usuário registrado com sucesso");
   }



}
