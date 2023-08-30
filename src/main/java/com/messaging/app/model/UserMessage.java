//package com.messaging.app.model;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.ToString;
//
//import javax.persistence.*;
//import java.util.Date;
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
//@Table
//@Entity(name = "user_message")
//public class UserMessage {
//
//
//    @Id
//    @GeneratedValue
//    private long id;
//
//    @Column(name = "from_user_id")
//    private long fromUserId;
//
//    @Column(name = "message_Id")
//    private long messageId;
//    @Column(name = "to_user_id")
//    private long toUserId;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "created_at", nullable = false)
//    private Date createdAt;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "updated_at", nullable = false)
//    private Date updatedAt;
//
//    @Column(name = "created_by")
//    private String createdBy;
//
//    @Column(name = "updated_by")
//    private String updatedBy;
//
//    @PrePersist
//    protected void onCreate() {
//        updatedAt = createdAt = new Date();
//    }
//
//    @PreUpdate
//    protected void onUpdate() {
//        updatedAt = new Date();
//    }
//}
