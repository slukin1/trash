package com.kakao.sdk.common.util;

import android.util.Base64;
import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.common.model.ContextInfo;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.text.b;
import net.sf.scuba.smartcards.ISO7816;
import net.sf.scuba.smartcards.ISOFileInfo;

@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 !2\u00020\u0001:\u0001\bB\u0011\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0002R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\tR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\""}, d2 = {"Lcom/kakao/sdk/common/util/AESCipher;", "", "", "message", "b", "key", "c", "source", "a", "Ljava/lang/String;", "keyGenAlgorithm", "cipherAlgorithm", "Ljava/nio/charset/Charset;", "Ljava/nio/charset/Charset;", "charSet", "Ljavax/crypto/Cipher;", "d", "Ljavax/crypto/Cipher;", "encryptor", "e", "decryptor", "", "f", "[B", "initVector", "Ljavax/crypto/spec/IvParameterSpec;", "g", "Ljavax/crypto/spec/IvParameterSpec;", "ivParameterSpec", "Lcom/kakao/sdk/common/model/ContextInfo;", "contextInfo", "<init>", "(Lcom/kakao/sdk/common/model/ContextInfo;)V", "h", "common_release"}, k = 1, mv = {1, 6, 0})
public final class AESCipher {

    /* renamed from: h  reason: collision with root package name */
    public static final a f25088h = new a((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f25089a;

    /* renamed from: b  reason: collision with root package name */
    public final String f25090b;

    /* renamed from: c  reason: collision with root package name */
    public final Charset f25091c;

    /* renamed from: d  reason: collision with root package name */
    public final Cipher f25092d;

    /* renamed from: e  reason: collision with root package name */
    public final Cipher f25093e;

    /* renamed from: f  reason: collision with root package name */
    public final byte[] f25094f;

    /* renamed from: g  reason: collision with root package name */
    public final IvParameterSpec f25095g;

    @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/kakao/sdk/common/util/AESCipher$a;", "", "", "ALGORITHM", "Ljava/lang/String;", "", "ITEM_COUNT", "I", "KEY_LENGTH", "<init>", "()V", "common_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public AESCipher() {
        this((ContextInfo) null, 1, (r) null);
    }

    public AESCipher(ContextInfo contextInfo) {
        String a11 = a("My0oeSI1IzInbyA+LVFaW2wiNSokPAMiMipOLS4=");
        this.f25089a = a11;
        String a12 = a("Iio+ASgjKE4/ZSIjXDMOCUoCDww=");
        this.f25090b = a12;
        this.f25091c = b.f56908b;
        byte[] bArr = {ISO7816.INS_MANAGE_CHANNEL, 78, 75, 55, ISO7816.INS_GET_DATA, ISO7816.INS_APPEND_RECORD, -10, ISO7816.INS_UNBLOCK_CHV, 102, -126, -126, 92, ISOFileInfo.SECURITY_ATTR_COMPACT, ISO7816.INS_WRITE_BINARY, ISOFileInfo.PROP_INFO, -55};
        this.f25094f = bArr;
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
        this.f25095g = ivParameterSpec;
        String b11 = contextInfo.b();
        SecretKey generateSecret = SecretKeyFactory.getInstance(a11).generateSecret(new PBEKeySpec(b11.substring(0, Math.min(b11.length(), 16)).toCharArray(), contextInfo.getSalt(), 2, 256));
        SecretKeySpec secretKeySpec = new SecretKeySpec(generateSecret.getEncoded(), com.sumsub.sns.prooface.network.b.f40261d);
        Cipher instance = Cipher.getInstance(a12);
        this.f25092d = instance;
        Cipher instance2 = Cipher.getInstance(a12);
        this.f25093e = instance2;
        try {
            instance.init(1, secretKeySpec, ivParameterSpec);
            instance2.init(2, secretKeySpec, ivParameterSpec);
        } catch (InvalidKeyException unused) {
            SecretKeySpec secretKeySpec2 = new SecretKeySpec(Arrays.copyOfRange(generateSecret.getEncoded(), 0, generateSecret.getEncoded().length / 2), com.sumsub.sns.prooface.network.b.f40261d);
            this.f25092d.init(1, secretKeySpec2, this.f25095g);
            this.f25093e.init(2, secretKeySpec2, this.f25095g);
        }
    }

    public final String a(String str) {
        return b(new String(Base64.decode(str, 0), b.f56908b));
    }

    public final String b(String str) {
        return c(str, "com.kakao.api");
    }

    public final String c(String str, String str2) {
        if (!(str == null || str2 == null)) {
            try {
                char[] charArray = str2.toCharArray();
                char[] charArray2 = str.toCharArray();
                int length = charArray2.length;
                int length2 = charArray.length;
                char[] cArr = new char[length];
                for (int i11 = 0; i11 < length; i11++) {
                    cArr[i11] = (char) (charArray2[i11] ^ charArray[i11 % length2]);
                }
                return new String(cArr);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AESCipher(ContextInfo contextInfo, int i11, r rVar) {
        this((i11 & 1) != 0 ? KakaoSdk.f25078a.a() : contextInfo);
    }
}
