package com.spodin.v.graphql.demo.cards;

import io.quarkus.runtime.Startup;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;
import org.jboss.logging.Logger;

@Startup
@ApplicationScoped
public class CardsCvvService {

    private static final Logger log = Logger.getLogger(CardsCvvService.class);

    private static final Jsonb JSONB = JsonbBuilder.create(new JsonbConfig().withFormatting(true));

    private final Map<Long, CvvEntry> cvvStorage = new HashMap<>();

    public String retrieveCvv(Long cardId) {
        log.info("Retrieving CVV value for cardId=" + cardId);

        return cvvStorage.get(cardId).getCvv();
    }

    @PostConstruct
    void init() {
        try (var jsonStream = resourceStream("card_cvv.json")) {
            List<CvvEntry> cvvEntries = JSONB.fromJson(jsonStream,
                new ArrayList<CvvEntry>() {}.getClass().getGenericSuperclass());

            for (var entry : cvvEntries) {
                cvvStorage.put(entry.getCardId(), entry);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load CVV values", e);
        }
    }

    private InputStream resourceStream(String name) throws FileNotFoundException {
        var resourceStream = Thread.currentThread().getContextClassLoader()
            .getResourceAsStream(name);

        if (resourceStream == null) {
            throw new FileNotFoundException(String.format(
                "Resource with name '%s' not found", name));
        }

        return resourceStream;
    }

    public static class CvvEntry {

        private final Long cardId;
        private final String cvv;

        @JsonbCreator
        public CvvEntry(@JsonbProperty("cardId") Long cardId, @JsonbProperty("cvv") String cvv) {
            this.cardId = cardId;
            this.cvv = cvv;
        }

        public Long getCardId() {
            return cardId;
        }

        public String getCvv() {
            return cvv;
        }
    }
}
