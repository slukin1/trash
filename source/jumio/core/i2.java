package jumio.core;

import com.appsflyer.AppsFlyerProperties;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.x;
import org.json.JSONArray;
import org.json.JSONObject;

public final class i2 implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final String f56218a;

    /* renamed from: b  reason: collision with root package name */
    public final String f56219b;

    /* renamed from: c  reason: collision with root package name */
    public final String f56220c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f56221d;

    /* renamed from: e  reason: collision with root package name */
    public final String f56222e;

    /* renamed from: f  reason: collision with root package name */
    public final String f56223f;

    /* renamed from: g  reason: collision with root package name */
    public final List<j2> f56224g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f56225h;

    public i2() {
        this(0);
    }

    public i2(String str, String str2, String str3, boolean z11, String str4, String str5, List<j2> list, boolean z12) {
        this.f56218a = str;
        this.f56219b = str2;
        this.f56220c = str3;
        this.f56221d = z11;
        this.f56222e = str4;
        this.f56223f = str5;
        this.f56224g = list;
        this.f56225h = z12;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i2)) {
            return false;
        }
        i2 i2Var = (i2) obj;
        return x.b(this.f56218a, i2Var.f56218a) && x.b(this.f56219b, i2Var.f56219b) && x.b(this.f56220c, i2Var.f56220c) && this.f56221d == i2Var.f56221d && x.b(this.f56222e, i2Var.f56222e) && x.b(this.f56223f, i2Var.f56223f) && x.b(this.f56224g, i2Var.f56224g) && this.f56225h == i2Var.f56225h;
    }

    public final int hashCode() {
        int a11 = o.a(this.f56220c, o.a(this.f56219b, this.f56218a.hashCode() * 31, 31), 31);
        boolean z11 = this.f56221d;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int hashCode = (this.f56224g.hashCode() + o.a(this.f56223f, o.a(this.f56222e, (a11 + (z11 ? 1 : 0)) * 31, 31), 31)) * 31;
        boolean z13 = this.f56225h;
        if (!z13) {
            z12 = z13;
        }
        return hashCode + (z12 ? 1 : 0);
    }

    public final String toString() {
        String str = this.f56218a;
        String str2 = this.f56219b;
        String str3 = this.f56220c;
        boolean z11 = this.f56221d;
        String str4 = this.f56222e;
        String str5 = this.f56223f;
        List<j2> list = this.f56224g;
        boolean z12 = this.f56225h;
        return "RejectReason(channel=" + str + ", label=" + str2 + ", rejectAction=" + str3 + ", active=" + z11 + ", reasonCode=" + str4 + ", category=" + str5 + ", details=" + list + ", isRetryAllowed=" + z12 + ")";
    }

    public /* synthetic */ i2(int i11) {
        this("", "", "", false, "", "", new ArrayList(), false);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public i2(JSONObject jSONObject) {
        this(0);
        this.f56218a = jSONObject.optString(AppsFlyerProperties.CHANNEL);
        this.f56219b = jSONObject.optString("label");
        this.f56220c = jSONObject.optString("rejectAction");
        this.f56221d = jSONObject.optBoolean("active", false);
        this.f56222e = jSONObject.optString("reasonCode");
        this.f56223f = jSONObject.optString("category");
        this.f56225h = jSONObject.optBoolean("retryAllowed", false);
        JSONArray optJSONArray = jSONObject.optJSONArray("details");
        optJSONArray = optJSONArray == null ? new JSONArray() : optJSONArray;
        int length = optJSONArray.length();
        for (int i11 = 0; i11 < length; i11++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i11);
            if (optJSONObject != null) {
                this.f56224g.add(new j2(optJSONObject.optString("label", ""), optJSONObject.optString("reasonDetailCode", "")));
            }
        }
    }
}
