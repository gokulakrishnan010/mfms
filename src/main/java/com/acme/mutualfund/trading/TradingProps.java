package com.acme.mutualfund.trading;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="app.trading")
public record TradingProps(String zone) {}