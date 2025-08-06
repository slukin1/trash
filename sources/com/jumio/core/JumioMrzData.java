package com.jumio.core;

import java.io.Serializable;
import jumio.core.s1;

public final class JumioMrzData implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public String f39012a;

    /* renamed from: b  reason: collision with root package name */
    public String f39013b;

    /* renamed from: c  reason: collision with root package name */
    public String f39014c;

    /* renamed from: d  reason: collision with root package name */
    public s1 f39015d = s1.MRP;

    /* renamed from: e  reason: collision with root package name */
    public boolean f39016e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f39017f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f39018g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f39019h = true;

    /* renamed from: i  reason: collision with root package name */
    public boolean f39020i;

    public final boolean getCompositeValid() {
        return this.f39020i;
    }

    public final boolean getDobValid() {
        return this.f39016e;
    }

    public final boolean getExpiryDateValid() {
        return this.f39018g;
    }

    public final s1 getFormat() {
        return this.f39015d;
    }

    public final boolean getIdNumberValid() {
        return this.f39017f;
    }

    public final String getMrzLine1() {
        return this.f39012a;
    }

    public final String getMrzLine2() {
        return this.f39013b;
    }

    public final String getMrzLine3() {
        return this.f39014c;
    }

    public final boolean getPersonalNumberValid() {
        return this.f39019h;
    }

    public final void setCompositeValid(boolean z11) {
        this.f39020i = z11;
    }

    public final void setDobValid(boolean z11) {
        this.f39016e = z11;
    }

    public final void setExpiryDateValid(boolean z11) {
        this.f39018g = z11;
    }

    public final void setFormat(s1 s1Var) {
        this.f39015d = s1Var;
    }

    public final void setIdNumberValid(boolean z11) {
        this.f39017f = z11;
    }

    public final void setMrzLine1(String str) {
        this.f39012a = str;
    }

    public final void setMrzLine2(String str) {
        this.f39013b = str;
    }

    public final void setMrzLine3(String str) {
        this.f39014c = str;
    }

    public final void setPersonalNumberValid(boolean z11) {
        this.f39019h = z11;
    }
}
