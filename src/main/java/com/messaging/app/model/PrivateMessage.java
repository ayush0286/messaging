package com.messaging.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table
@Entity(name = "private_message")
public class PrivateMessage {

    @Id
    @GeneratedValue
    private long id;
    @Column(name = "user_name",columnDefinition = "TEXT") //add unique constraint
    private String content;

    @Column(name = "see_at")
    private Date seenAt;
    @Column(name = "sent_at")
    private Date sentAt;
    @Column(name = "delivered_at")
    private Date deliveredAt;
    @Column(name = "msg_status")
    private String  msg_status;

    @Column(name = "message_sequence_id")
    private String  messageSequenceId;

    @Column(name = "chat_id_user_to_user")
    private String chatIdUserToUser; //add unique constraint
    @Column(name = "sent_by_user_id") //add unique constraint
    private String sentByUser;

    @Column(name = "sent_for_id")
    private String sentForUser;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_by")
    private String updatedBy;

    @PrePersist
    protected void onCreate() {
        updatedAt = createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Date();
    }
}
