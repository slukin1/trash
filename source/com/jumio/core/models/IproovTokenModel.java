package com.jumio.core.models;

import com.jumio.commons.PersistWith;
import com.jumio.core.model.StaticModel;
import jumio.core.o;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import org.json.JSONObject;

@PersistWith("IproovTokenModel")
public final class IproovTokenModel implements StaticModel {
    public static final Companion Companion = new Companion((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f39314a;

    /* renamed from: b  reason: collision with root package name */
    public final String f39315b;

    /* renamed from: c  reason: collision with root package name */
    public final String f39316c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f39317d;

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final IproovTokenModel fromJson(JSONObject jSONObject) {
            return new IproovTokenModel(jSONObject.getString("token"), jSONObject.getString("url"), jSONObject.getString("productType"));
        }
    }

    public IproovTokenModel() {
        this((String) null, (String) null, (String) null, 7, (r) null);
    }

    public IproovTokenModel(String str, String str2, String str3) {
        this.f39314a = str;
        this.f39315b = str2;
        this.f39316c = str3;
    }

    public static /* synthetic */ IproovTokenModel copy$default(IproovTokenModel iproovTokenModel, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = iproovTokenModel.f39314a;
        }
        if ((i11 & 2) != 0) {
            str2 = iproovTokenModel.f39315b;
        }
        if ((i11 & 4) != 0) {
            str3 = iproovTokenModel.f39316c;
        }
        return iproovTokenModel.copy(str, str2, str3);
    }

    public final String component1() {
        return this.f39314a;
    }

    public final String component2() {
        return this.f39315b;
    }

    public final String component3() {
        return this.f39316c;
    }

    public final IproovTokenModel copy(String str, String str2, String str3) {
        return new IproovTokenModel(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IproovTokenModel)) {
            return false;
        }
        IproovTokenModel iproovTokenModel = (IproovTokenModel) obj;
        return x.b(this.f39314a, iproovTokenModel.f39314a) && x.b(this.f39315b, iproovTokenModel.f39315b) && x.b(this.f39316c, iproovTokenModel.f39316c);
    }

    public final String getProductType() {
        return this.f39316c;
    }

    public final String getToken() {
        return this.f39314a;
    }

    public final String getUrl() {
        return this.f39315b;
    }

    public final boolean getUsed() {
        return this.f39317d;
    }

    public int hashCode() {
        return this.f39316c.hashCode() + o.a(this.f39315b, this.f39314a.hashCode() * 31, 31);
    }

    public final boolean isEmpty() {
        if (this.f39314a.length() == 0) {
            if (this.f39315b.length() == 0) {
                return true;
            }
        }
        return false;
    }

    public final void setUsed(boolean z11) {
        this.f39317d = z11;
    }

    public String toString() {
        String str = this.f39314a;
        String str2 = this.f39315b;
        String str3 = this.f39316c;
        return "IproovTokenModel(token=" + str + ", url=" + str2 + ", productType=" + str3 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ IproovTokenModel(String str, String str2, String str3, int i11, r rVar) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? "" : str2, (i11 & 4) != 0 ? "iproov_standard" : str3);
    }
}
