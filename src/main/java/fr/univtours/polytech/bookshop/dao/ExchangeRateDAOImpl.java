package fr.univtours.polytech.bookshop.dao;

import fr.univtours.polytech.bookshop.model.exchange.ExchangeRateResult;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

@ApplicationScoped
public class ExchangeRateDAOImpl implements ExchangeRateDAO {

    private static final String URL = "https://v6.exchangerate-api.com/v6/bfbcf73ca82517d1c97f8a97/latest/EUR";

    @Override
    public ExchangeRateResult getEuroExchangeRate() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(URL);

        ExchangeRateResult result = target.request(MediaType.APPLICATION_JSON).get(ExchangeRateResult.class);

        return result;
    }
}
