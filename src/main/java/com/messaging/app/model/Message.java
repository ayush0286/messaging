//package com.messaging.app.model;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.ToString;
//
//import javax.persistence.*;
//import java.sql.Timestamp;
//import java.util.Date;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
//@Table
//@Entity(name = "messages")
//public class Message {
//
//    @Id
//    @GeneratedValue
//    private long id;
//
//    @Column(name = "user_id")
//    private long userId;
//
//    @Column(name = "group_id")
//    private long groupId;
//
//    @Column(name ="content")
//    private String content;
//
//    private String messageType;
//    private Timestamp deliveredAt;
//    private Timestamp seenAt;
//    private Timestamp sentAt;
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
