package com.millky.dev.database.multi.infra.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.millky.dev.database.multi.domain.user.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

}
