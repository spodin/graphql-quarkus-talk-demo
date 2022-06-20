package com.spodin.v.graphql.demo.cards;

import com.spodin.v.graphql.demo.common.model.Card;
import com.spodin.v.graphql.demo.common.model.CardStatus;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.jboss.logging.Logger;

@ApplicationScoped
public class CardsService {

    private static final Logger log = Logger.getLogger(CardsService.class);

    @PersistenceContext
    EntityManager em;

    public List<Card> findCardsByClient(long clientId) {
        var fetchedCards = em.createQuery("SELECT c from Card c WHERE c.client.id = :clientId",
                Card.class)
            .setParameter("clientId", clientId)
            .getResultList();

        log.info(String.format("Fetched %d cards", fetchedCards.size()));

        return fetchedCards;
    }

    public Card findCardById(Long id) {
        var card = em.find(Card.class, id);

        if (card == null) {
            log.warn(String.format("Card with id=%d not found", id));
        } else {
            log.info(String.format("Fetched card with id=%d", card.getId()));

        }

        return card;
    }

    @Transactional
    public Card blockCard(Long id) {
        var card = findCardById(id);

        if (card != null) {
            card.setStatus(CardStatus.BLOCKED);
            em.merge(card);
        }

        return card;
    }
}
