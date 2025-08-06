package com.jumio.core.network;

import d10.a;
import javax.net.ssl.X509TrustManager;

public interface TrustManagerInterface extends X509TrustManager {
    String getHostname();

    a<Boolean> getKeyPinning();

    void setHostname(String str);

    void setKeyPinning(a<Boolean> aVar);
}
