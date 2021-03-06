package com.dreamsearcher.notifier.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notification
{
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "notification_id", unique = true)
    private String notificationId;
    @Column(columnDefinition = "TEXT")
    private String notificationText;
    private String itemId;
    private String userId;
    private String userWishId;
    private String shopName;
    private boolean deliveryStatus;
    private int retryCount;
    private String creationTime;
    private String deliveredTime;

    @Transient
    private String username;
    @Transient
    private String userEmail;
    @Transient
    private boolean isSend = false;

    public Notification(String notificationId, String notificationText, String itemId, String userId, String userWishId, String shopName, boolean deliveryStatus, int retryCount, String creationTime, String deliveredTime)
    {
        this.notificationId = notificationId;
        this.notificationText = notificationText;
        this.itemId = itemId;
        this.userId = userId;
        this.userWishId = userWishId;
        this.shopName = shopName;
        this.deliveryStatus = deliveryStatus;
        this.retryCount = retryCount;
        this.creationTime = creationTime;
        this.deliveredTime = deliveredTime;
    }

    public Notification(String notificationText, String itemId, String userId, String userWishId, String shopName, boolean deliveryStatus, int retryCount, String creationTime, String deliveredTime)
    {
        this.notificationText = notificationText;
        this.itemId = itemId;
        this.userId = userId;
        this.userWishId = userWishId;
        this.shopName = shopName;
        this.deliveryStatus = deliveryStatus;
        this.retryCount = retryCount;
        this.creationTime = creationTime;
        this.deliveredTime = deliveredTime;
    }
}
