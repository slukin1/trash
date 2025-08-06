package k10;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public Mac f56549a;

    /* renamed from: b  reason: collision with root package name */
    public int f56550b;

    /* renamed from: c  reason: collision with root package name */
    public String f56551c;

    public a(String str) {
        this.f56551c = str;
        try {
            Mac instance = Mac.getInstance(str);
            this.f56549a = instance;
            this.f56550b = instance.getMacLength();
        } catch (NoSuchAlgorithmException e11) {
            throw new RuntimeException(e11);
        }
    }

    public int a() {
        return this.f56550b;
    }

    public byte[] b(byte[] bArr) {
        return this.f56549a.doFinal(bArr);
    }

    public byte[] c() {
        return this.f56549a.doFinal();
    }

    public void d(byte[] bArr, int i11, int i12) {
        try {
            this.f56549a.update(bArr, i11, i12);
        } catch (IllegalStateException e11) {
            throw new RuntimeException(e11);
        }
    }

    public void init(byte[] bArr) {
        try {
            this.f56549a.init(new SecretKeySpec(bArr, this.f56551c));
        } catch (InvalidKeyException e11) {
            throw new RuntimeException(e11);
        }
    }
}
