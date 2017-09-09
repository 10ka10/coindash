package com.tenkaten.coindash.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tenkaten.coindash.model.coinmarketcap.CryptoCoin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.HttpURLConnection;
import java.net.URL;

@Controller
public class DashboardController {

    private final ObjectMapper objectMapper;

    @Autowired
    public DashboardController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @GetMapping({"/", "/dashboard"})
    public String getDashboard(Model model) {
        try {
            URL url = new URL("https://api.coinmarketcap.com/v1/ticker/?limit=10");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            CryptoCoin[] cryptoCoins = objectMapper.readValue(con.getInputStream(), CryptoCoin[].class);
            model.addAttribute("cryptoCoins", cryptoCoins);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return "dashboard";
    }
}
