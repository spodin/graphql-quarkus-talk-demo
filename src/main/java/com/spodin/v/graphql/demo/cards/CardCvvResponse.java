package com.spodin.v.graphql.demo.cards;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CardCvvResponse {

    @JsonProperty("cvv")
    private String cvv;

    public CardCvvResponse(String cvv) {
        this.cvv = cvv;
    }

    public String getCvv() {
        return cvv;
    }

    @Override
    public String toString() {
        return "CardCvvResponse{" +
            "cvv='" + (cvv == null ? null : "<sensitive>") + '\'' +
            '}';
    }
}
