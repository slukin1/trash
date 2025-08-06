package com.hbg.lib.apng.decode;

import java.io.IOException;
import z5.a;

public class j extends d {

    /* renamed from: h  reason: collision with root package name */
    public static final int f66210h = d.a("IHDR");

    /* renamed from: e  reason: collision with root package name */
    public int f66211e;

    /* renamed from: f  reason: collision with root package name */
    public int f66212f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f66213g = new byte[5];

    public void b(a aVar) throws IOException {
        this.f66211e = aVar.f();
        this.f66212f = aVar.f();
        byte[] bArr = this.f66213g;
        aVar.read(bArr, 0, bArr.length);
    }
}
