package com.spodin.v.graphql.demo.clients;

import com.spodin.v.graphql.demo.common.model.Client;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;

@GraphQLApi
public class ClientsGraphQLApi {

    @Inject
    ClientsService clientsService;

    @Query("viewer")
    public Client profile() {
        return clientsService.getCurrentClient();
    }

    @Mutation("updateProfile")
    public Client updateProfile(@NotNull ClientUpdate update) {
        return clientsService.updateClient(update);
    }
}
