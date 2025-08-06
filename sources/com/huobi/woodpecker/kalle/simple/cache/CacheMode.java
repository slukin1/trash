package com.huobi.woodpecker.kalle.simple.cache;

public enum CacheMode {
    HTTP,
    HTTP_YES_THEN_WRITE_CACHE,
    NETWORK,
    NETWORK_YES_THEN_HTTP,
    NETWORK_YES_THEN_WRITE_CACHE,
    NETWORK_NO_THEN_READ_CACHE,
    READ_CACHE,
    READ_CACHE_NO_THEN_NETWORK,
    READ_CACHE_NO_THEN_HTTP
}
