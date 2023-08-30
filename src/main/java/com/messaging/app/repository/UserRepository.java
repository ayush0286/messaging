package com.messaging.app.repository;

import com.messaging.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository  extends JpaRepository<User,Long> {
    User findByUserNameAndPhoneNumber(String userName,String phoneNumber);

    User findByUserName(String userName);

    @Query(value = "SELECT * FROM messaging_app.users WHERE user_name like %:userInput% or phone_number like  %:userInput%", nativeQuery = true)
    List<User> getAllUserForMatchingInputFromUserNameOrPhoneNumber(@Param(value = "userInput") String userInput);

    List<User> findByUserNameIn(List<String> userNames);
}
