package com.chatbonfire.server.Models.Repositories;

import com.chatbonfire.server.Models.UserModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<UserModel, Integer> {
    UserModel findOneByMail(String mail);
    UserModel findOneByMailAndPassword(String mail, String password);
}