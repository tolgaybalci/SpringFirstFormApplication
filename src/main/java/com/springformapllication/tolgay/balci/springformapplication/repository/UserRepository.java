package com.springformapllication.tolgay.balci.springformapplication.repository;

import com.springformapllication.tolgay.balci.springformapplication.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

    <Optional> User findByEmail(String email);
}
