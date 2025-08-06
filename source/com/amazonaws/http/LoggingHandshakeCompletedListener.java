package com.amazonaws.http;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSession;

public class LoggingHandshakeCompletedListener implements HandshakeCompletedListener {

    /* renamed from: a  reason: collision with root package name */
    public static final Log f14900a = LogFactory.b(LoggingHandshakeCompletedListener.class);

    public void handshakeCompleted(HandshakeCompletedEvent handshakeCompletedEvent) {
        try {
            SSLSession session = handshakeCompletedEvent.getSession();
            String protocol = session.getProtocol();
            String cipherSuite = session.getCipherSuite();
            Log log = f14900a;
            log.h("Protocol: " + protocol + ", CipherSuite: " + cipherSuite);
        } catch (Exception e11) {
            f14900a.d("Failed to log connection protocol/cipher suite", e11);
        }
    }
}
