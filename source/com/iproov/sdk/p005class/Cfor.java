package com.iproov.sdk.p005class;

import com.iproov.sdk.utils.Cif;
import org.json.JSONObject;

/* renamed from: com.iproov.sdk.class.for  reason: invalid class name and invalid package */
class Cfor {

    /* renamed from: do  reason: not valid java name */
    private Double f193do;

    /* renamed from: for  reason: not valid java name */
    private String f194for = null;

    /* renamed from: if  reason: not valid java name */
    private Integer f195if = 6144000;

    /* renamed from: new  reason: not valid java name */
    private Integer f196new = 30;

    /* renamed from: try  reason: not valid java name */
    private Integer f197try = 50;

    /* renamed from: do  reason: not valid java name */
    public Integer m273do() {
        return this.f195if;
    }

    /* renamed from: for  reason: not valid java name */
    public String m275for() {
        return this.f194for;
    }

    /* renamed from: if  reason: not valid java name */
    public Integer m276if() {
        return this.f196new;
    }

    /* renamed from: new  reason: not valid java name */
    public Double m277new() {
        return this.f193do;
    }

    /* renamed from: try  reason: not valid java name */
    public Integer m278try() {
        return this.f197try;
    }

    /* renamed from: do  reason: not valid java name */
    public void m274do(JSONObject jSONObject) {
        this.f195if = Cif.m2260do(jSONObject, "video_bitrate", this.f195if);
        this.f196new = Cif.m2260do(jSONObject, "frame_rate", this.f196new);
        this.f197try = Cif.m2260do(jSONObject, "i_frame_interval", this.f197try);
        this.f193do = Cif.m2259do(jSONObject, "video_quality", this.f193do);
        this.f194for = jSONObject.optString("video_profile", this.f194for);
    }
}
