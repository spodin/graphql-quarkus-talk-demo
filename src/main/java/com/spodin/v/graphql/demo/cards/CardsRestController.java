package com.spodin.v.graphql.demo.cards;

import com.spodin.v.graphql.demo.common.model.Card;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/cards")
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "Cards", description = "Operations with cards")
public class CardsRestController {

    @Inject
    CardsService cardsService;

    @Inject
    CardsCvvService cvvService;

    @GET
    @Operation(summary = "Retrieve all client cards")
    public List<Card> getCards() {
        return cardsService.findCardsByClient(1);
    }

    @GET
    @Path("/cvv/{cardId}")
    @Operation(summary = "Retrieves card CVV")
    public CardCvvResponse getCardCvv(@PathParam("cardId") Long cardId) {
        var cvv = cvvService.retrieveCvv(cardId);
        return new CardCvvResponse(cvv);
    }
}