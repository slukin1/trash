package com.sumsub.sns.prooface.network;

import java.math.BigInteger;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f40267a = new c();

    /* renamed from: b  reason: collision with root package name */
    public static final BigInteger f40268b = new BigInteger("115792089210356248762697446949407573530086143415290314195533631308867097853951");

    /* renamed from: c  reason: collision with root package name */
    public static final BigInteger f40269c = new BigInteger("115792089210356248762697446949407573529996955224135760342422259061068512044369");

    /* renamed from: d  reason: collision with root package name */
    public static final BigInteger f40270d = new BigInteger("115792089210356248762697446949407573530086143415290314195533631308867097853948");

    /* renamed from: e  reason: collision with root package name */
    public static final BigInteger f40271e = new BigInteger("41058363725152142129326129780047268409114441015993725554835256314039467401291");

    /* renamed from: f  reason: collision with root package name */
    public static final BigInteger f40272f = new BigInteger("48439561293906451759052585252797914202762949526041747995844080717082404635286");

    /* renamed from: g  reason: collision with root package name */
    public static final BigInteger f40273g = new BigInteger("36134250956749795798585127919587881956611106672985015071877198253568414405109");

    public final EllipticCurve a() {
        return new EllipticCurve(new ECFieldFp(f40268b), f40270d, f40271e);
    }

    public final ECParameterSpec b() {
        return new ECParameterSpec(a(), new ECPoint(f40272f, f40273g), f40269c, 1);
    }
}
