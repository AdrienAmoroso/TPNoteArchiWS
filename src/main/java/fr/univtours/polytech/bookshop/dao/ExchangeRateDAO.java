package fr.univtours.polytech.bookshop.dao;

import fr.univtours.polytech.bookshop.model.exchange.ExchangeRateResult;

public interface ExchangeRateDAO {
    ExchangeRateResult getEuroExchangeRate();
}
