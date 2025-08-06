package com.huobi.woodpecker.core;

public enum HttpEventStatus {
    callStart,
    dnsStart,
    dnsEnd,
    connectStart,
    secureConnectStart,
    secureConnectEnd,
    connectEnd,
    connectFailed,
    connectionAcquired,
    requestHeadersStart,
    requestHeadersEnd,
    requestBodyStart,
    requestBodyEnd,
    requestFailed,
    responseHeadersStart,
    responseHeadersEnd,
    responseBodyStart,
    responseBodyEnd,
    responseFailed,
    connectionReleased,
    callEnd
}
