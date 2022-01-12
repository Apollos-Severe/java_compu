package com.example.java_compu.Users;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
@Service
public interface UserRepository
        extends JpaRepository<Users, Long> {
}
