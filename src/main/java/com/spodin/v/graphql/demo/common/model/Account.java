package com.spodin.v.graphql.demo.common.model;

import java.math.BigDecimal;
import java.util.List;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private AccountType type;

    @Column(name = "iban")
    private String iban;

    @Column(name = "currency")
    @Enumerated(EnumType.STRING)
    private Currency currency;

    @Column(name = "balance")
    private BigDecimal balance;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonbTransient
    private List<Card> cards;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    @JsonbTransient
    private Client client;

    public Account() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Account{" +
            "id=" + id +
            ", type=" + type +
            ", iban='" + iban + '\'' +
            ", currency=" + currency +
            ", balance=" + balance +
            ", cards=" + cards +
            ", client=" + client +
            '}';
    }
}
