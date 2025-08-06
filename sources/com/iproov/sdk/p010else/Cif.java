package com.iproov.sdk.p010else;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.iproov.sdk.else.if  reason: invalid class name and invalid package */
public final class Cif {

    /* renamed from: do  reason: not valid java name */
    private ArrayList<Cdo> f518do = new ArrayList<>();

    public Cif(JSONArray jSONArray) throws JSONException {
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            JSONArray jSONArray2 = jSONArray.getJSONArray(i11);
            int i12 = 0;
            while (true) {
                if (i12 >= jSONArray2.length()) {
                    break;
                }
                JSONObject optJSONObject = jSONArray2.optJSONObject(i12);
                String optString = optJSONObject.optString("type");
                String optString2 = optJSONObject.optString("colour");
                if (optString.toLowerCase().equals("flash") && optString2.length() > 0) {
                    this.f518do.add(new Cdo(optString2.charAt(0)));
                    break;
                }
                i12++;
            }
        }
    }

    /* renamed from: do  reason: not valid java name */
    private static Cdo m593do() {
        return new Cdo('0');
    }

    /* renamed from: do  reason: not valid java name */
    public List<Cdo> m594do(int i11, int i12) {
        ArrayList arrayList = new ArrayList();
        for (int i13 = 0; i13 < i11; i13++) {
            arrayList.add(m593do());
        }
        arrayList.addAll(this.f518do);
        for (int i14 = 0; i14 < i12; i14++) {
            arrayList.add(m593do());
        }
        return arrayList;
    }

    @Deprecated
    public Cif(String str) {
        for (int i11 = 0; i11 < str.length(); i11++) {
            this.f518do.add(new Cdo(str.charAt(i11)));
        }
    }
}
