package com.iproov.sdk.p005class;

import org.json.JSONObject;

/* renamed from: com.iproov.sdk.class.case  reason: invalid class name and invalid package */
public class Ccase {

    /* renamed from: do  reason: not valid java name */
    private final Celse f172do;

    /* renamed from: if  reason: not valid java name */
    private final Cfor f173if;

    public Ccase(Celse elseR, JSONObject jSONObject) {
        this(elseR, m245do(jSONObject));
    }

    /* renamed from: do  reason: not valid java name */
    private static Cfor m245do(JSONObject jSONObject) {
        Cfor forR = new Cfor();
        if (jSONObject == null) {
            return forR;
        }
        forR.m274do(jSONObject);
        return forR;
    }

    /* renamed from: if  reason: not valid java name */
    public Cfor m247if() {
        return this.f173if;
    }

    public Ccase(Celse elseR, Cfor forR) {
        this.f172do = elseR;
        this.f173if = forR;
    }

    /* renamed from: do  reason: not valid java name */
    public Celse m246do() {
        return this.f172do;
    }
}
