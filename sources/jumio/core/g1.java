package jumio.core;

import java.io.Serializable;
import java.util.Date;
import kotlin.jvm.internal.x;
import org.json.JSONObject;

public final class g1 implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final String f56206a;

    /* renamed from: b  reason: collision with root package name */
    public final Date f56207b;

    /* renamed from: c  reason: collision with root package name */
    public final Date f56208c;

    /* renamed from: d  reason: collision with root package name */
    public final String f56209d;

    /* renamed from: e  reason: collision with root package name */
    public final String f56210e;

    /* renamed from: f  reason: collision with root package name */
    public final String f56211f;

    /* renamed from: g  reason: collision with root package name */
    public final String f56212g;

    public g1() {
        this(0);
    }

    public g1(String str, Date date, Date date2, String str2, String str3, String str4, String str5) {
        this.f56206a = str;
        this.f56207b = date;
        this.f56208c = date2;
        this.f56209d = str2;
        this.f56210e = str3;
        this.f56211f = str4;
        this.f56212g = str5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g1)) {
            return false;
        }
        g1 g1Var = (g1) obj;
        return x.b(this.f56206a, g1Var.f56206a) && x.b(this.f56207b, g1Var.f56207b) && x.b(this.f56208c, g1Var.f56208c) && x.b(this.f56209d, g1Var.f56209d) && x.b(this.f56210e, g1Var.f56210e) && x.b(this.f56211f, g1Var.f56211f) && x.b(this.f56212g, g1Var.f56212g);
    }

    public final int hashCode() {
        int hashCode = this.f56206a.hashCode() * 31;
        Date date = this.f56207b;
        int i11 = 0;
        int hashCode2 = (hashCode + (date == null ? 0 : date.hashCode())) * 31;
        Date date2 = this.f56208c;
        if (date2 != null) {
            i11 = date2.hashCode();
        }
        return this.f56212g.hashCode() + o.a(this.f56211f, o.a(this.f56210e, o.a(this.f56209d, (hashCode2 + i11) * 31, 31), 31), 31);
    }

    public final String toString() {
        String str = this.f56206a;
        Date date = this.f56207b;
        Date date2 = this.f56208c;
        String str2 = this.f56209d;
        String str3 = this.f56210e;
        String str4 = this.f56211f;
        String str5 = this.f56212g;
        return "ExtractedData(issuingCountry=" + str + ", dateOfBirth=" + date + ", expiryDate=" + date2 + ", documentNumber=" + str2 + ", mrzLine1=" + str3 + ", mrzLine2=" + str4 + ", mrzLine3=" + str5 + ")";
    }

    public /* synthetic */ g1(int i11) {
        this("", (Date) null, (Date) null, "", "", "", "");
    }

    public g1(JSONObject jSONObject) {
        this(0);
        this.f56206a = jSONObject.optString("issuingCountry");
        this.f56207b = o1.a(jSONObject, "dateOfBirth", "yyyy-MM-dd");
        this.f56208c = o1.a(jSONObject, "expiryDate", "yyyy-MM-dd");
        this.f56209d = jSONObject.optString("documentNumber");
        this.f56210e = jSONObject.optString("mrzLine1");
        this.f56211f = jSONObject.optString("mrzLine2");
        this.f56212g = jSONObject.optString("mrzLine3");
    }
}
