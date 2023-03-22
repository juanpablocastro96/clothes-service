package com.sasha.store.clothesservice.dao.repositories;

import com.sasha.store.clothesservice.dao.entities.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserAppRepository extends JpaRepository<UserApp, Long> {
    Optional<UserApp> findUserAppByEmail(String email);
}
