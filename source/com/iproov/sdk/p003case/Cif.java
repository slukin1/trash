package com.iproov.sdk.p003case;

import android.content.Context;
import com.iproov.sdk.core.Celse;
import com.iproov.sdk.p005class.Ccase;
import com.iproov.sdk.p010else.Cnew;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.iproov.sdk.case.if  reason: invalid class name and invalid package */
public final class Cif {

    /* renamed from: break  reason: not valid java name */
    private final boolean f158break;

    /* renamed from: case  reason: not valid java name */
    private final Cnew f159case;

    /* renamed from: catch  reason: not valid java name */
    private final boolean f160catch;

    /* renamed from: class  reason: not valid java name */
    private final com.iproov.sdk.p019interface.Cif f161class;

    /* renamed from: do  reason: not valid java name */
    private final Cfor f162do;

    /* renamed from: else  reason: not valid java name */
    private final Celse f163else;

    /* renamed from: for  reason: not valid java name */
    private final com.iproov.sdk.p033throws.Celse f164for;

    /* renamed from: goto  reason: not valid java name */
    private final Double f165goto;

    /* renamed from: if  reason: not valid java name */
    private final com.iproov.sdk.p010else.Cif f166if;

    /* renamed from: new  reason: not valid java name */
    private final Cdo f167new;

    /* renamed from: this  reason: not valid java name */
    private final boolean f168this;

    /* renamed from: try  reason: not valid java name */
    private final Ccase f169try;

    public Cif(Context context, JSONObject jSONObject) throws JSONException {
        com.iproov.sdk.p019interface.Cif ifVar = new com.iproov.sdk.p019interface.Cif(context);
        this.f161class = ifVar;
        jSONObject.getString("token");
        this.f162do = Cfor.m228do(jSONObject.getString("type"));
        if (!jSONObject.isNull("flash_pattern")) {
            this.f166if = new com.iproov.sdk.p010else.Cif(jSONObject.getJSONArray("flash_pattern"));
        } else {
            this.f166if = new com.iproov.sdk.p010else.Cif(jSONObject.getString("flash_code"));
        }
        com.iproov.sdk.utils.Cif.m2277if(jSONObject, "user_name");
        jSONObject.optString("sp_name");
        this.f165goto = com.iproov.sdk.utils.Cif.m2259do(jSONObject, "omega", (Double) null);
        this.f164for = com.iproov.sdk.p033throws.Celse.m1946do(context, jSONObject.optJSONObject("clux_parameters"));
        com.iproov.sdk.utils.Cif.m2268do(jSONObject, "deprecation_warning", (String) null);
        this.f158break = jSONObject.optBoolean("sim", false);
        this.f168this = jSONObject.optBoolean("rtf", false);
        this.f160catch = jSONObject.optBoolean("slg", false);
        Cdo doVar = Cdo.m227do(com.iproov.sdk.utils.Cif.m2268do(jSONObject, "assurance_type", (String) null));
        this.f167new = doVar == null ? Cdo.GENUINE_PRESENCE_ASSURANCE : doVar;
        this.f163else = Celse.m365do(new Celse(jSONObject.optJSONObject("lvn_parameters")), ifVar);
        this.f169try = new Ccase(com.iproov.sdk.p005class.Celse.m270do(jSONObject.optString("codec", com.iproov.sdk.p005class.Celse.AVC.f190do)), jSONObject.optJSONObject("factors"));
        this.f159case = Cnew.m595do(new Cnew(jSONObject.optJSONObject("gpa_parameters")), ifVar);
    }

    /* renamed from: break  reason: not valid java name */
    public boolean m229break() {
        return this.f168this;
    }

    /* renamed from: case  reason: not valid java name */
    public Celse m230case() {
        return this.f163else;
    }

    /* renamed from: catch  reason: not valid java name */
    public boolean m231catch() {
        return this.f158break;
    }

    /* renamed from: do  reason: not valid java name */
    public Cdo m232do() {
        return this.f167new;
    }

    /* renamed from: else  reason: not valid java name */
    public Double m233else() {
        return this.f165goto;
    }

    /* renamed from: for  reason: not valid java name */
    public com.iproov.sdk.p010else.Cif m234for() {
        return this.f166if;
    }

    /* renamed from: goto  reason: not valid java name */
    public Cfor m235goto() {
        return this.f162do;
    }

    /* renamed from: if  reason: not valid java name */
    public Ccase m236if() {
        return this.f169try;
    }

    /* renamed from: new  reason: not valid java name */
    public Cnew m237new() {
        return this.f159case;
    }

    /* renamed from: this  reason: not valid java name */
    public boolean m238this() {
        return this.f160catch;
    }

    /* renamed from: try  reason: not valid java name */
    public com.iproov.sdk.p033throws.Celse m239try() {
        return this.f164for;
    }
}
