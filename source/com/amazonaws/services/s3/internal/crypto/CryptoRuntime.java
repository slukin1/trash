package com.amazonaws.services.s3.internal.crypto;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.security.Provider;
import java.security.Security;
import javax.crypto.Cipher;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

@Deprecated
public class CryptoRuntime {

    /* renamed from: a  reason: collision with root package name */
    public static final Log f15197a = LogFactory.b(CryptoRuntime.class);

    public static final class AesGcm {
        public static boolean b(Provider provider) {
            try {
                Cipher.getInstance(ContentCryptoScheme.f15195b.b(), provider);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    public static synchronized void a() {
        synchronized (CryptoRuntime.class) {
            if (!c()) {
                try {
                    Security.addProvider((Provider) Class.forName("org.bouncycastle.jce.provider.BouncyCastleProvider").newInstance());
                } catch (Exception e11) {
                    f15197a.d("Bouncy Castle not available", e11);
                }
            } else {
                return;
            }
        }
        return;
    }

    public static boolean b(Provider provider) {
        if (provider == null) {
            provider = Security.getProvider(BouncyCastleProvider.PROVIDER_NAME);
        }
        return AesGcm.b(provider);
    }

    public static synchronized boolean c() {
        boolean z11;
        synchronized (CryptoRuntime.class) {
            z11 = Security.getProvider(BouncyCastleProvider.PROVIDER_NAME) != null;
        }
        return z11;
    }
}
