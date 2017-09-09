package com.tenkaten.coindash.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tenkaten.coindash.model.coinmarketcap.CryptoCoin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

@Service
public class DashboardServiceImpl implements DashboardService {

    private static final String TICKER_ENDPOINT = "/v1/ticker/?limit=";
    private static final String TICKER_LIMIT = "10";

    private final ObjectMapper objectMapper;
    private final String apiUrl;

    @Autowired
    public  DashboardServiceImpl(ObjectMapper objectMapper, @Value("${coinmarketcap.api.url}") String apiUrl) {
        this.objectMapper = objectMapper;
        this.apiUrl = apiUrl;
    }

    @Override
    public List<CryptoCoin> getCryptoCoins() {
        try {
            URL url;
            url = new URL(apiUrl + TICKER_ENDPOINT + TICKER_LIMIT);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            CryptoCoin[] cryptoCoins = objectMapper.readValue(con.getInputStream(), CryptoCoin[].class);
            return Arrays.asList(cryptoCoins);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
