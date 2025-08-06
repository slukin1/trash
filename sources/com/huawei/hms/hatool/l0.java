package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.amazonaws.services.s3.model.UploadObjectRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class l0 {

    /* renamed from: a  reason: collision with root package name */
    private String f38216a;

    /* renamed from: b  reason: collision with root package name */
    private String f38217b;

    /* renamed from: c  reason: collision with root package name */
    private String f38218c;

    /* renamed from: d  reason: collision with root package name */
    private List<b1> f38219d;

    /* renamed from: e  reason: collision with root package name */
    private String f38220e;

    public l0(String str, String str2, String str3, List<b1> list, String str4) {
        this.f38216a = str;
        this.f38217b = str2;
        this.f38218c = str3;
        this.f38219d = list;
        this.f38220e = str4;
    }

    private String a(String str, String str2) {
        String str3;
        String f11 = a1.f(str, str2);
        if (TextUtils.isEmpty(f11)) {
            v.a("hmsSdk", "No report address,TAG : %s,TYPE: %s ", str, str2);
            return "";
        }
        if ("oper".equals(str2)) {
            str3 = "{url}/common/hmshioperqrt";
        } else if ("maint".equals(str2)) {
            str3 = "{url}/common/hmshimaintqrt";
        } else if (!"diffprivacy".equals(str2)) {
            return "";
        } else {
            str3 = "{url}/common/common2";
        }
        return str3.replace("{url}", f11);
    }

    private byte[] a(h1 h1Var) {
        String str;
        try {
            JSONObject a11 = h1Var.a();
            if (a11 != null) {
                return k1.a(a11.toString().getBytes("UTF-8"));
            }
            v.e("hmsSdk", "uploadEvents is null");
            return new byte[0];
        } catch (JSONException unused) {
            str = "uploadEvents to json error";
            v.e("hmsSdk", str);
            return new byte[0];
        } catch (UnsupportedEncodingException unused2) {
            str = "sendData(): getBytes - Unsupported coding format!!";
            v.e("hmsSdk", str);
            return new byte[0];
        }
    }

    private void b() {
        if (c0.a(q0.i(), "backup_event", (int) UploadObjectRequest.MIN_PART_SIZE)) {
            v.d("hmsSdk", "backup file reach max limited size, discard new event ");
            return;
        }
        JSONArray c11 = c();
        String a11 = n1.a(this.f38216a, this.f38217b, this.f38220e);
        v.c("hmsSdk", "Update data cached into backup,spKey: " + a11);
        d.b(q0.i(), "backup_event", a11, c11.toString());
    }

    private JSONArray c() {
        JSONArray jSONArray = new JSONArray();
        for (b1 d11 : this.f38219d) {
            try {
                jSONArray.put(d11.d());
            } catch (JSONException unused) {
                v.c("hmsSdk", "handleEvents: json error,Abandon this data");
            }
        }
        return jSONArray;
    }

    private h1 d() {
        return k.a(this.f38219d, this.f38216a, this.f38217b, this.f38220e, this.f38218c);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: com.huawei.hms.hatool.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: com.huawei.hms.hatool.d1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: com.huawei.hms.hatool.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: com.huawei.hms.hatool.f} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a() {
        /*
            r9 = this;
            java.lang.String r0 = r9.f38216a
            java.lang.String r1 = r9.f38217b
            java.lang.String r4 = r9.a(r0, r1)
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            java.lang.String r1 = "hmsSdk"
            if (r0 == 0) goto L_0x0020
            java.lang.String r0 = r9.f38217b
            java.lang.String r2 = "preins"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x0020
            java.lang.String r0 = "collectUrl is empty"
        L_0x001c:
            com.huawei.hms.hatool.v.e(r1, r0)
            return
        L_0x0020:
            java.lang.String r0 = r9.f38216a
            java.lang.String r2 = "_hms_config_tag"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x0037
            java.lang.String r0 = r9.f38216a
            java.lang.String r2 = "_openness_config_tag"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x0037
            r9.b()
        L_0x0037:
            com.huawei.hms.hatool.h1 r0 = r9.d()
            if (r0 == 0) goto L_0x005a
            byte[] r3 = r9.a(r0)
            int r0 = r3.length
            if (r0 != 0) goto L_0x0047
            java.lang.String r0 = "request body is empty"
            goto L_0x001c
        L_0x0047:
            com.huawei.hms.hatool.f r0 = new com.huawei.hms.hatool.f
            java.lang.String r5 = r9.f38216a
            java.lang.String r6 = r9.f38217b
            java.lang.String r7 = r9.f38220e
            java.util.List<com.huawei.hms.hatool.b1> r8 = r9.f38219d
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8)
            com.huawei.hms.hatool.b0 r1 = com.huawei.hms.hatool.b0.b()
            goto L_0x006b
        L_0x005a:
            com.huawei.hms.hatool.d1 r0 = new com.huawei.hms.hatool.d1
            java.util.List<com.huawei.hms.hatool.b1> r1 = r9.f38219d
            java.lang.String r2 = r9.f38216a
            java.lang.String r3 = r9.f38220e
            java.lang.String r4 = r9.f38217b
            r0.<init>(r1, r2, r3, r4)
            com.huawei.hms.hatool.b0 r1 = com.huawei.hms.hatool.b0.c()
        L_0x006b:
            r1.a(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.hatool.l0.a():void");
    }
}
