package com.example.java_compu.PaymentDetail;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@Table
public class PaymentDetail {
    @Id
    @SequenceGenerator(name = "payment_sequence", sequenceName = "payment_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_sequence")

    private Long id;
    private int amount;
    private String provider;
    private String status;

    public PaymentDetail() {
    }

    public PaymentDetail(Long id, int amount, String provider, String status) {
        this.id = id;
        this.amount = amount;
        this.provider = provider;
        this.status = status;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getProvider() {
        return this.provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PaymentDetail id(Long id) {
        setId(id);
        return this;
    }

    public PaymentDetail amount(int amount) {
        setAmount(amount);
        return this;
    }

    public PaymentDetail provider(String provider) {
        setProvider(provider);
        return this;
    }

    public PaymentDetail status(String status) {
        setStatus(status);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PaymentDetail)) {
            return false;
        }
        PaymentDetail paymentDetails = (PaymentDetail) o;
        return Objects.equals(id, paymentDetails.id) && amount == paymentDetails.amount
                && Objects.equals(provider, paymentDetails.provider) && Objects.equals(status, paymentDetails.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, provider, status);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", amount='" + getAmount() + "'" +
                ", provider='" + getProvider() + "'" +
                ", status='" + getStatus() + "'" +
                "}";
    }

}
