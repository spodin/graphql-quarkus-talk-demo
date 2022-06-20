package com.spodin.v.graphql.demo.common.model;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cards_tokens")
public class CardTokenInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "token_id")
    private String tokenId;

    @ManyToOne
    @JoinColumn(name = "card_id", nullable = false)
    @JsonbTransient
    private Card card;

    public CardTokenInfo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "CardTokenInfo{" +
            "id=" + id +
            ", tokenId='" + tokenId + '\'' +
            ", card=" + card +
            '}';
    }
}
