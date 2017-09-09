package com.tenkaten.coindash.model.coinmarketcap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CryptoCoin {
    private String id;
    private String name;
    private String symbol;
    private String rank;
    private String priceUsd;
    private String priceBtc;
    @JsonProperty(value = "24h_volume_usd")
    private String dayVolumeUsd;
    private String marketCapUsd;
    private String availableSupply;
    private String totalSupply;
    private String percentChangeOneHour;
    private String percentChangeOneDay;
    private String percentChangeOneWeek;
    private String lastUpdated;
}
