package net.lingala.zip4j.crypto.PBKDF2;

public class PBKDF2Parameters {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f58324a;

    /* renamed from: b  reason: collision with root package name */
    public int f58325b;

    /* renamed from: c  reason: collision with root package name */
    public String f58326c;

    /* renamed from: d  reason: collision with root package name */
    public String f58327d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f58328e;

    public PBKDF2Parameters() {
        this.f58326c = null;
        this.f58327d = "UTF-8";
        this.f58324a = null;
        this.f58325b = 1000;
        this.f58328e = null;
    }

    public String a() {
        return this.f58326c;
    }

    public int b() {
        return this.f58325b;
    }

    public byte[] c() {
        return this.f58324a;
    }

    public PBKDF2Parameters(String str, String str2, byte[] bArr, int i11) {
        this.f58326c = str;
        this.f58327d = str2;
        this.f58324a = bArr;
        this.f58325b = i11;
        this.f58328e = null;
    }
}
