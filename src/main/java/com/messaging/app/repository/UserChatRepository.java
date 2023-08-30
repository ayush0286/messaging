package com.messaging.app.repository;

import com.messaging.app.model.UserChat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserChatRepository extends JpaRepository<UserChat,Long> {
//    List<UserChat> findByFromUserId(long userId);

    @Query(value = "SELECT * FROM messaging_app.user_chat WHERE user_one = :userId or user_two = :userId", nativeQuery = true)
    List<UserChat> findAllUserChat(@Param(value = "userId") long userId);

//    @Query(value = "SELECT chat_id_user_to_user FROM messaging_app.user_chat WHERE user_one = :userId or user_two = :userId", nativeQuery = true)
//    String findUserToUserChatId(@Param(value = "user_one") long userOne, @Param(value = "user_two") long userTwo);
}
