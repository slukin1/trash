package com.jumio.core.models;

import com.jumio.commons.log.Log;
import com.jumio.core.model.StaticModel;
import com.jumio.sdk.enums.JumioDataCenter;
import com.sumsub.sns.prooface.network.b;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Objects;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.x;

public final class AuthorizationModel implements StaticModel {

    /* renamed from: a  reason: collision with root package name */
    public JumioDataCenter f39247a = JumioDataCenter.US;

    /* renamed from: b  reason: collision with root package name */
    public String f39248b = "";

    /* renamed from: c  reason: collision with root package name */
    public SessionKey f39249c = new SessionKey();

    public final class SessionKey implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public SecretKey f39250a;

        /* renamed from: b  reason: collision with root package name */
        public byte[] f39251b;

        public SessionKey() {
        }

        public final void clear() {
            this.f39250a = null;
            byte[] bArr = this.f39251b;
            if (bArr != null) {
                ArraysKt___ArraysJvmKt.n(bArr, (byte) 0, 0, 0, 6, (Object) null);
            }
            this.f39251b = null;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null) {
                if (x.b(SessionKey.class, obj.getClass())) {
                    SessionKey sessionKey = (SessionKey) obj;
                    if (!Objects.equals(this.f39250a, sessionKey.f39250a) || !Arrays.equals(this.f39251b, sessionKey.f39251b)) {
                        return false;
                    }
                    return true;
                }
            }
            return false;
        }

        public final void generate() {
            try {
                KeyGenerator instance = KeyGenerator.getInstance(b.f40261d);
                instance.init(256);
                this.f39250a = instance.generateKey();
                byte[] bArr = new byte[12];
                new SecureRandom().nextBytes(bArr);
                this.f39251b = bArr;
            } catch (NoSuchAlgorithmException e11) {
                Log.printStackTrace(e11);
            }
        }

        public final Cipher getDecryptCipher() {
            Cipher instance = Cipher.getInstance(b.f40262e);
            SecretKey secretKey = AuthorizationModel.this.getSessionKey().f39250a;
            instance.init(2, new SecretKeySpec(secretKey != null ? secretKey.getEncoded() : null, b.f40261d), new GCMParameterSpec(128, AuthorizationModel.this.getSessionKey().f39251b));
            return instance;
        }

        public final Cipher getEncryptCipher() {
            Cipher instance = Cipher.getInstance(b.f40262e);
            SecretKey secretKey = AuthorizationModel.this.getSessionKey().f39250a;
            instance.init(1, new SecretKeySpec(secretKey != null ? secretKey.getEncoded() : null, b.f40261d), new GCMParameterSpec(128, AuthorizationModel.this.getSessionKey().f39251b));
            return instance;
        }

        public int hashCode() {
            SecretKey secretKey = this.f39250a;
            return Arrays.hashCode(this.f39251b) + Arrays.hashCode(secretKey != null ? secretKey.getEncoded() : null);
        }

        public final boolean isValid() {
            return (this.f39250a == null || this.f39251b == null) ? false : true;
        }
    }

    public final String getAuthorization() {
        String str = this.f39248b;
        return "Bearer " + str;
    }

    public final JumioDataCenter getDataCenter() {
        return this.f39247a;
    }

    public final SessionKey getSessionKey() {
        return this.f39249c;
    }

    public final String getToken() {
        return this.f39248b;
    }

    public final void setDataCenter(JumioDataCenter jumioDataCenter) {
        this.f39247a = jumioDataCenter;
    }

    public final void setSessionKey(SessionKey sessionKey) {
        this.f39249c = sessionKey;
    }

    public final void setToken(String str) {
        this.f39248b = str;
    }
}
