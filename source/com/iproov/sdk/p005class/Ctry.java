package com.iproov.sdk.p005class;

import java.util.Objects;

/* renamed from: com.iproov.sdk.class.try  reason: invalid class name and invalid package */
public class Ctry {

    /* renamed from: do  reason: not valid java name */
    public final byte[] f212do;

    /* renamed from: if  reason: not valid java name */
    public final Cdo f213if;

    /* renamed from: com.iproov.sdk.class.try$do  reason: invalid class name */
    public enum Cdo {
        CODEC_CONFIG,
        FRAME;

        /* renamed from: do  reason: not valid java name */
        public static Cdo m289do(int i11) {
            if ((i11 & 2) != 0) {
                return CODEC_CONFIG;
            }
            return FRAME;
        }
    }

    public Ctry(byte[] bArr, int i11) {
        this.f212do = bArr;
        Cdo doVar = Cdo.m289do(i11);
        this.f213if = doVar;
        int length = bArr.length;
        Objects.toString(doVar);
    }

    /* renamed from: do  reason: not valid java name */
    public boolean m288do() {
        return this.f213if == Cdo.CODEC_CONFIG;
    }
}
