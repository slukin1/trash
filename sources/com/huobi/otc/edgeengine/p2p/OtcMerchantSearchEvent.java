package com.huobi.otc.edgeengine.p2p;

import com.huobi.edgeengine.ability.AbilityFunction;

public class OtcMerchantSearchEvent {

    /* renamed from: a  reason: collision with root package name */
    public String f78368a;

    /* renamed from: b  reason: collision with root package name */
    public long f78369b;

    /* renamed from: c  reason: collision with root package name */
    public AbilityFunction.a f78370c;

    public boolean a(Object obj) {
        return obj instanceof OtcMerchantSearchEvent;
    }

    public String b() {
        return this.f78368a;
    }

    public AbilityFunction.a c() {
        return this.f78370c;
    }

    public long d() {
        return this.f78369b;
    }

    public void e(String str) {
        this.f78368a = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcMerchantSearchEvent)) {
            return false;
        }
        OtcMerchantSearchEvent otcMerchantSearchEvent = (OtcMerchantSearchEvent) obj;
        if (!otcMerchantSearchEvent.a(this)) {
            return false;
        }
        String b11 = b();
        String b12 = otcMerchantSearchEvent.b();
        if (b11 != null ? !b11.equals(b12) : b12 != null) {
            return false;
        }
        if (d() != otcMerchantSearchEvent.d()) {
            return false;
        }
        AbilityFunction.a c11 = c();
        AbilityFunction.a c12 = otcMerchantSearchEvent.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public void f(AbilityFunction.a aVar) {
        this.f78370c = aVar;
    }

    public void g(long j11) {
        this.f78369b = j11;
    }

    public int hashCode() {
        String b11 = b();
        int i11 = 43;
        int hashCode = b11 == null ? 43 : b11.hashCode();
        long d11 = d();
        int i12 = ((hashCode + 59) * 59) + ((int) (d11 ^ (d11 >>> 32)));
        AbilityFunction.a c11 = c();
        int i13 = i12 * 59;
        if (c11 != null) {
            i11 = c11.hashCode();
        }
        return i13 + i11;
    }

    public String toString() {
        return "OtcMerchantSearchEvent(action=" + b() + ", uid=" + d() + ", callback=" + c() + ")";
    }
}
