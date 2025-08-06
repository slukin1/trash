package com.jumio.core.models;

import com.jumio.commons.PersistWith;
import com.jumio.core.model.StaticModel;
import jumio.core.o;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import org.json.JSONException;
import org.json.JSONObject;

@PersistWith("InitiateModel")
public final class InitiateModel implements StaticModel {

    /* renamed from: e  reason: collision with root package name */
    public static final Companion f39309e = new Companion((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f39310a;

    /* renamed from: b  reason: collision with root package name */
    public final String f39311b;

    /* renamed from: c  reason: collision with root package name */
    public final String f39312c;

    /* renamed from: d  reason: collision with root package name */
    public final String f39313d;

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final InitiateModel fromJson(JSONObject jSONObject) throws JSONException {
            return new InitiateModel(jSONObject.getString("accountId"), jSONObject.getString("acquisitionReference"), jSONObject.optString("merchantId"), jSONObject.optString("merchantName"));
        }
    }

    public InitiateModel() {
        this(0);
    }

    public InitiateModel(String str, String str2, String str3, String str4) {
        this.f39310a = str;
        this.f39311b = str2;
        this.f39312c = str3;
        this.f39313d = str4;
    }

    public final String a() {
        return this.f39311b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InitiateModel)) {
            return false;
        }
        InitiateModel initiateModel = (InitiateModel) obj;
        return x.b(this.f39310a, initiateModel.f39310a) && x.b(this.f39311b, initiateModel.f39311b) && x.b(this.f39312c, initiateModel.f39312c) && x.b(this.f39313d, initiateModel.f39313d);
    }

    public final int hashCode() {
        String str = this.f39310a;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f39311b;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return this.f39313d.hashCode() + o.a(this.f39312c, (hashCode + i11) * 31, 31);
    }

    public final String toString() {
        String str = this.f39310a;
        String str2 = this.f39311b;
        String str3 = this.f39312c;
        String str4 = this.f39313d;
        return "InitiateModel(accountId=" + str + ", workflowExecutionId=" + str2 + ", merchantId=" + str3 + ", merchantName=" + str4 + ")";
    }

    public /* synthetic */ InitiateModel(int i11) {
        this((String) null, (String) null, "", "");
    }
}
