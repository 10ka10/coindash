package com.tenkaten.coindash.services;

import com.tenkaten.coindash.model.coinmarketcap.CryptoCoin;

import java.util.List;

public interface DashboardService {
    List<CryptoCoin> getCryptoCoins();
}
