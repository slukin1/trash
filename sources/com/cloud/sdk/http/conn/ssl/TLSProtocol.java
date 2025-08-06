package com.cloud.sdk.http.conn.ssl;

import com.tencent.android.tpns.mqtt.internal.security.SSLSocketFactoryFactory;

enum TLSProtocol {
    TLSv1_2("TLSv1.2"),
    TLSv1_1("TLSv1.1"),
    TLSv1("TLSv1"),
    TLS(SSLSocketFactoryFactory.DEFAULT_PROTOCOL);
    
    private final String protocolName;

    private TLSProtocol(String str) {
        this.protocolName = str;
    }

    public String getProtocolName() {
        return this.protocolName;
    }
}
