package com.spodin.v.graphql.demo.clients;

import com.spodin.v.graphql.demo.common.model.Client;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class ClientsService {

    @PersistenceContext
    EntityManager em;

    public Client getCurrentClient() {
        return em.find(Client.class, 1L);
    }

    @Transactional
    public Client updateClient(ClientUpdate update) {
        var client = getCurrentClient();

        client.setEmail(update.getEmail());
        client.setFirstName(update.getFirstName());
        client.setLastName(update.getLastName());
        client.setLanguage(update.getLanguage());
        em.merge(client);

        return client;
    }
}
