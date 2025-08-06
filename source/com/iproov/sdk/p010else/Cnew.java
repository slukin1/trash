package com.iproov.sdk.p010else;

import com.huochat.community.base.CommunityConstants;
import com.iproov.sdk.p019interface.Cif;
import com.tencent.rtmp.TXLivePushConfig;
import org.json.JSONObject;

/* renamed from: com.iproov.sdk.else.new  reason: invalid class name and invalid package */
public class Cnew {

    /* renamed from: case  reason: not valid java name */
    public final int f519case;

    /* renamed from: do  reason: not valid java name */
    public final float f520do;

    /* renamed from: else  reason: not valid java name */
    public final int f521else;

    /* renamed from: for  reason: not valid java name */
    public final int f522for;

    /* renamed from: goto  reason: not valid java name */
    public final int f523goto;

    /* renamed from: if  reason: not valid java name */
    public final int f524if;

    /* renamed from: new  reason: not valid java name */
    public final int f525new;

    /* renamed from: this  reason: not valid java name */
    public final int f526this;

    /* renamed from: try  reason: not valid java name */
    public final int f527try;

    public Cnew(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19) {
        this.f520do = (float) i11;
        this.f524if = i12;
        this.f522for = i13;
        this.f525new = i14;
        this.f527try = i15;
        this.f519case = i16;
        this.f521else = i17;
        this.f523goto = i18;
        this.f526this = i19;
    }

    /* renamed from: do  reason: not valid java name */
    public static Cnew m595do(Cnew newR, Cif ifVar) {
        return new Cnew((int) newR.f520do, newR.f524if, newR.f522for, newR.f525new, newR.f527try, newR.f519case, newR.f521else, ifVar.m1103case(newR.f523goto), ifVar.m1123new(newR.f526this));
    }

    public Cnew(JSONObject jSONObject) {
        if (jSONObject == null) {
            this.f520do = 3500.0f;
            this.f524if = 2;
            this.f522for = 1;
            this.f525new = 2;
            this.f527try = 2;
            this.f519case = 250;
            this.f521else = TXLivePushConfig.DEFAULT_MIN_VIDEO_BITRATE;
            this.f523goto = 200;
            this.f526this = 350;
            return;
        }
        this.f520do = (float) jSONObject.optInt("frs", 3500);
        this.f524if = jSONObject.optInt("fpf", 2);
        this.f522for = jSONObject.optInt("cfc", 1);
        this.f525new = jSONObject.optInt("pfc", 2);
        this.f527try = jSONObject.optInt("afc", 2);
        this.f519case = jSONObject.optInt("lfd", 250);
        this.f521else = jSONObject.optInt("ufd", TXLivePushConfig.DEFAULT_MIN_VIDEO_BITRATE);
        this.f523goto = jSONObject.optInt(CommunityConstants.REQUEST_KEY_MID, 200);
        this.f526this = jSONObject.optInt("mxd", 350);
    }
}
