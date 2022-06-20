package com.spodin.v.graphql.demo.cards;

import com.spodin.v.graphql.demo.common.model.Card;
import java.util.List;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;
import org.eclipse.microprofile.graphql.Source;

@GraphQLApi
public class CardsGraphQLApi {

    @Inject
    CardsService cardsService;

    @Inject
    CardsCvvService cvvService;

    @Query("cards")
    public List<Card> getCards() {
        return cardsService.findCardsByClient(1);
    }

    @Query("card")
    public Card getCard(@NotNull Long id) {
        return cardsService.findCardById(id);
    }

    @Mutation
    public Card blockCard(@NotNull Long id) {
        return cardsService.blockCard(id);
    }

    public String getCvv(@Source(name = "cvv") Card card) {
        return cvvService.retrieveCvv(card.getId());
    }
}
