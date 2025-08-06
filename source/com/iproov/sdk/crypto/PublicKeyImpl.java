package com.iproov.sdk.crypto;

import androidx.annotation.Keep;
import com.iproov.sdk.p017implements.Cimport;
import com.iproov.sdk.p031this.Cif;
import java.security.PublicKey;

@Keep
public class PublicKeyImpl implements Cif {
    private static final String PUBLIC_KEY_BEGIN = "-----BEGIN PUBLIC KEY-----\n";
    private static final String PUBLIC_KEY_END = "\n-----END PUBLIC KEY-----";
    private final PublicKey iProovPublicKey;

    public PublicKeyImpl(PublicKey publicKey) {
        this.iProovPublicKey = publicKey;
    }

    public byte[] getDer() {
        return this.iProovPublicKey.getEncoded();
    }

    public PublicKey getKey() {
        return this.iProovPublicKey;
    }

    public String getPem() {
        return PUBLIC_KEY_BEGIN + Cimport.m1016do(getDer()) + PUBLIC_KEY_END;
    }
}
