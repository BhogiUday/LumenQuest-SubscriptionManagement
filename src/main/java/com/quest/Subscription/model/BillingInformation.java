package com.dinesh.lumen_hackathon_1.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "billing_information")
public class BillingInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "billing_id")
    private Long billingId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subscription_id", nullable = false)
    private Subscription subscription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @Column(name = "billing_date", nullable = false)
    private LocalDate billingDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status")
    private PaymentStatus paymentStatus = PaymentStatus.pending;

    // Constructors
    public BillingInformation() {}

    public BillingInformation(Long billingId, Subscription subscription, User user,
                              BigDecimal amount, LocalDate billingDate, PaymentStatus paymentStatus) {
        this.billingId = billingId;
        this.subscription = subscription;
        this.user = user;
        this.amount = amount;
        this.billingDate = billingDate;
        this.paymentStatus = paymentStatus;
    }

    // Getters and Setters
    public Long getBillingId() { return billingId; }
    public void setBillingId(Long billingId) { this.billingId = billingId; }

    public Subscription getSubscription() { return subscription; }
    public void setSubscription(Subscription subscription) { this.subscription = subscription; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public LocalDate getBillingDate() { return billingDate; }
    public void setBillingDate(LocalDate billingDate) { this.billingDate = billingDate; }

    public PaymentStatus getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(PaymentStatus paymentStatus) { this.paymentStatus = paymentStatus; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BillingInformation that = (BillingInformation) o;
        return Objects.equals(billingId, that.billingId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(billingId);
    }

    @Override
    public String toString() {
        return "BillingInformation{" +
                "billingId=" + billingId +
                ", amount=" + amount +
                ", billingDate=" + billingDate +
                ", paymentStatus=" + paymentStatus +
                '}';
    }

    public enum PaymentStatus {
        paid, pending, failed
    }
}