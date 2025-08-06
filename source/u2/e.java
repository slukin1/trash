package u2;

import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public boolean f16619a;

    /* renamed from: b  reason: collision with root package name */
    public String[] f16620b;

    /* renamed from: c  reason: collision with root package name */
    public String[] f16621c;

    /* renamed from: d  reason: collision with root package name */
    public int[] f16622d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f16623e;

    public e(boolean z11, String[] strArr, String[] strArr2, int[] iArr, int[] iArr2) {
        this.f16619a = z11;
        this.f16620b = strArr;
        this.f16621c = strArr2;
        this.f16622d = iArr;
        this.f16623e = iArr2;
    }

    public static e a(String str) {
        String[] strArr;
        String[] strArr2;
        int[] iArr;
        int[] iArr2;
        JSONObject jSONObject = new JSONObject(str);
        boolean z11 = true;
        if (jSONObject.has("service_status")) {
            z11 = true ^ jSONObject.optString("service_status").equals("disable");
        }
        boolean z12 = z11;
        if (jSONObject.has("service_ip")) {
            JSONArray jSONArray = jSONObject.getJSONArray("service_ip");
            int length = jSONArray.length();
            strArr = new String[length];
            for (int i11 = 0; i11 < length; i11++) {
                strArr[i11] = jSONArray.getString(i11);
            }
        } else {
            strArr = null;
        }
        if (jSONObject.has("service_ipv6")) {
            JSONArray jSONArray2 = jSONObject.getJSONArray("service_ipv6");
            int length2 = jSONArray2.length();
            strArr2 = new String[length2];
            for (int i12 = 0; i12 < length2; i12++) {
                strArr2[i12] = jSONArray2.getString(i12);
            }
        } else {
            strArr2 = null;
        }
        if (jSONObject.has("service_ip_port")) {
            JSONArray jSONArray3 = jSONObject.getJSONArray("service_ip_port");
            int length3 = jSONArray3.length();
            iArr = new int[length3];
            for (int i13 = 0; i13 < length3; i13++) {
                iArr[i13] = jSONArray3.optInt(i13);
            }
        } else {
            iArr = null;
        }
        if (jSONObject.has("service_ipv6_port")) {
            JSONArray jSONArray4 = jSONObject.getJSONArray("service_ipv6_port");
            int length4 = jSONArray4.length();
            int[] iArr3 = new int[length4];
            for (int i14 = 0; i14 < length4; i14++) {
                iArr3[i14] = jSONArray4.optInt(i14);
            }
            iArr2 = iArr3;
        } else {
            iArr2 = null;
        }
        return new e(z12, strArr, strArr2, iArr, iArr2);
    }

    public int[] b() {
        return this.f16622d;
    }

    public String[] c() {
        return this.f16620b;
    }

    public boolean d() {
        return this.f16619a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return this.f16619a == eVar.f16619a && Arrays.equals(this.f16620b, eVar.f16620b) && Arrays.equals(this.f16621c, eVar.f16621c) && Arrays.equals(this.f16622d, eVar.f16622d) && Arrays.equals(this.f16623e, eVar.f16623e);
    }

    public int hashCode() {
        return (((((((Arrays.hashCode(new Object[]{Boolean.valueOf(this.f16619a)}) * 31) + Arrays.hashCode(this.f16620b)) * 31) + Arrays.hashCode(this.f16621c)) * 31) + Arrays.hashCode(this.f16622d)) * 31) + Arrays.hashCode(this.f16623e);
    }

    public String toString() {
        return "UpdateServerResponse{enable=" + this.f16619a + ", serverIps=" + Arrays.toString(this.f16620b) + ", serverIpv6s=" + Arrays.toString(this.f16621c) + ", serverPorts=" + Arrays.toString(this.f16622d) + ", serverIpv6Ports=" + Arrays.toString(this.f16623e) + '}';
    }
}
