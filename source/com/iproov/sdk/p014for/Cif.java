package com.iproov.sdk.p014for;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.iproov.sdk.for.if  reason: invalid class name and invalid package */
public class Cif implements Cdo {

    /* renamed from: do  reason: not valid java name */
    private final String f568do;

    /* renamed from: if  reason: not valid java name */
    private final Map<String, Object> f569if;

    public Cif(String str, Map<String, Object> map) {
        this.f568do = str;
        this.f569if = map;
    }

    /* renamed from: do  reason: not valid java name */
    public String m688do() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f569if != null) {
                jSONObject.put("detail", new JSONObject(this.f569if));
            }
            return String.format("window.dispatchEvent(new CustomEvent('%s', %s));", new Object[]{"iproov-" + this.f568do, jSONObject.toString()});
        } catch (JSONException unused) {
            throw new IllegalStateException("Error parsing JSDispatchEvent parameters for type: " + this.f568do);
        }
    }
}
