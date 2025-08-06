package com.sumsub.sns.prooface.network;

import android.util.Base64;
import com.sumsub.sns.internal.log.c;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import kotlin.jvm.internal.r;

public final class b implements a {

    /* renamed from: c  reason: collision with root package name */
    public static final a f40260c = new a((r) null);

    /* renamed from: d  reason: collision with root package name */
    public static final String f40261d = "AES";

    /* renamed from: e  reason: collision with root package name */
    public static final String f40262e = "AES/GCM/NoPadding";

    /* renamed from: f  reason: collision with root package name */
    public static final byte f40263f = 2;

    /* renamed from: g  reason: collision with root package name */
    public static final String f40264g = "secp256r1";

    /* renamed from: a  reason: collision with root package name */
    public final KeyPair f40265a = a();

    /* renamed from: b  reason: collision with root package name */
    public SecretKey f40266b;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public a() {
        }
    }

    public void a(String str) {
        this.f40266b = a((Key) this.f40265a.getPrivate(), b(str));
    }

    public final Key b(String str) {
        byte[] decode = Base64.decode(str, 2);
        return KeyFactory.getInstance("EC").generatePublic(new ECPublicKeySpec(new ECPoint(a(decode, 1, 32), a(decode, 33, 32)), c.f40267a.b()));
    }

    public final KeyPair a() {
        KeyPairGenerator instance = KeyPairGenerator.getInstance("EC");
        instance.initialize(c.f40267a.b());
        return instance.generateKeyPair();
    }

    public final SecretKey a(Key key, Key key2) {
        KeyAgreement instance = KeyAgreement.getInstance("ECDH");
        instance.init(key);
        instance.doPhase(key2, true);
        SecretKey generateSecret = instance.generateSecret(f40261d);
        com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
        String a11 = c.a(this);
        com.sumsub.log.logger.a.a(aVar, a11, "Crypto: secret=" + Base64.encodeToString(generateSecret.getEncoded(), 2), (Throwable) null, 4, (Object) null);
        return generateSecret;
    }

    public final byte[] b(byte[] bArr, byte[] bArr2) {
        if (this.f40266b != null) {
            Cipher instance = Cipher.getInstance(f40262e);
            instance.init(1, this.f40266b, new IvParameterSpec(bArr2));
            return instance.doFinal(bArr);
        }
        throw new InvalidParameterException("Session key is not set");
    }

    public byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] b11 = b(bArr, bArr2);
        byte[] encoded = this.f40265a.getPublic().getEncoded();
        ByteBuffer allocate = ByteBuffer.allocate(encoded.length + 3 + bArr2.length + 4 + b11.length);
        allocate.put((byte) 2);
        allocate.putShort((short) encoded.length);
        allocate.put(encoded);
        allocate.put(bArr2);
        allocate.putInt(b11.length);
        allocate.put(b11);
        return allocate.array();
    }

    public final BigInteger a(byte[] bArr, int i11, int i12) {
        if (!(i11 == 0 && i12 == bArr.length)) {
            byte[] bArr2 = new byte[i12];
            System.arraycopy(bArr, i11, bArr2, 0, i12);
            bArr = bArr2;
        }
        return new BigInteger(1, bArr);
    }
}
