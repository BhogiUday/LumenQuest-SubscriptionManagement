package com.dinesh.lumen_hackathon_1.model;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "subscriptions")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscription_id")
    private Integer subscriptionId;

    @Enumerated(EnumType.STRING)
    @Column(name = "subscription_type", nullable = false)
    private SubscriptionType subscriptionType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private SubscriptionPlan subscriptionPlan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private SubscriptionStatus status = SubscriptionStatus.active;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "last_renewed_date")
    private LocalDate lastRenewedDate;

    @Column(name = "terminated_date")
    private LocalDate terminatedDate;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Constructors
    public Subscription() {}

    public Subscription(Integer subscriptionId, SubscriptionType subscriptionType,
                        SubscriptionPlan subscriptionPlan, User user, SubscriptionStatus status,
                        LocalDate startDate, LocalDate lastRenewedDate, LocalDate terminatedDate,
                        LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.subscriptionId = subscriptionId;
        this.subscriptionType = subscriptionType;
        this.subscriptionPlan = subscriptionPlan;
        this.user = user;
        this.status = status;
        this.startDate = startDate;
        this.lastRenewedDate = lastRenewedDate;
        this.terminatedDate = terminatedDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getters and Setters
    public Integer getSubscriptionId() { return subscriptionId; }
    public void setSubscriptionId(Integer subscriptionId) { this.subscriptionId = subscriptionId; }

    public SubscriptionType getSubscriptionType() { return subscriptionType; }
    public void setSubscriptionType(SubscriptionType subscriptionType) { this.subscriptionType = subscriptionType; }

    public SubscriptionPlan getSubscriptionPlan() { return subscriptionPlan; }
    public void setSubscriptionPlan(SubscriptionPlan subscriptionPlan) { this.subscriptionPlan = subscriptionPlan; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public SubscriptionStatus getStatus() { return status; }
    public void setStatus(SubscriptionStatus status) { this.status = status; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getLastRenewedDate() { return lastRenewedDate; }
    public void setLastRenewedDate(LocalDate lastRenewedDate) { this.lastRenewedDate = lastRenewedDate; }

    public LocalDate getTerminatedDate() { return terminatedDate; }
    public void setTerminatedDate(LocalDate terminatedDate) { this.terminatedDate = terminatedDate; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscription that = (Subscription) o;
        return Objects.equals(subscriptionId, that.subscriptionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subscriptionId);
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "subscriptionId=" + subscriptionId +
                ", subscriptionType=" + subscriptionType +
                ", status=" + status +
                ", startDate=" + startDate +
                ", lastRenewedDate=" + lastRenewedDate +
                ", terminatedDate=" + terminatedDate +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    public enum SubscriptionType {
        monthly, yearly
    }

    public enum SubscriptionStatus {
        active, PAUSED, cancelled
    }
}