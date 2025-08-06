package androidx.credentials;

import android.os.Bundle;
import androidx.credentials.a;
import kotlin.jvm.internal.r;
import org.json.JSONObject;

public final class d extends a {

    /* renamed from: l  reason: collision with root package name */
    public static final a f8773l = new a((r) null);

    /* renamed from: i  reason: collision with root package name */
    public final String f8774i;

    /* renamed from: j  reason: collision with root package name */
    public final String f8775j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f8776k;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final a.b a(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str).getJSONObject("user");
                return new a.b(jSONObject.getString("name"), jSONObject.isNull("displayName") ? null : jSONObject.getString("displayName"));
            } catch (Exception unused) {
                throw new IllegalArgumentException("user.name must be defined in requestJson");
            }
        }

        public final Bundle b(String str, String str2, boolean z11) {
            Bundle bundle = new Bundle();
            bundle.putString("androidx.credentials.BUNDLE_KEY_SUBTYPE", "androidx.credentials.BUNDLE_VALUE_SUBTYPE_CREATE_PUBLIC_KEY_CREDENTIAL_REQUEST");
            bundle.putString("androidx.credentials.BUNDLE_KEY_REQUEST_JSON", str);
            bundle.putString("androidx.credentials.BUNDLE_KEY_CLIENT_DATA_HASH", str2);
            bundle.putBoolean("androidx.credentials.BUNDLE_KEY_PREFER_IMMEDIATELY_AVAILABLE_CREDENTIALS", z11);
            return bundle;
        }
    }

    public d(String str, String str2) {
        this(str, str2, false, (String) null, 12, (r) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public d(java.lang.String r10, java.lang.String r11, boolean r12, androidx.credentials.a.b r13, java.lang.String r14) {
        /*
            r9 = this;
            androidx.credentials.d$a r0 = f8773l
            android.os.Bundle r3 = r0.b(r10, r11, r12)
            android.os.Bundle r4 = r0.b(r10, r11, r12)
            java.lang.String r2 = "androidx.credentials.TYPE_PUBLIC_KEY_CREDENTIAL"
            r5 = 0
            r6 = 0
            r1 = r9
            r7 = r13
            r8 = r14
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            r9.f8774i = r10
            r9.f8775j = r11
            r9.f8776k = r12
            int r10 = r10.length()
            if (r10 <= 0) goto L_0x0022
            r10 = 1
            goto L_0x0023
        L_0x0022:
            r10 = 0
        L_0x0023:
            if (r10 == 0) goto L_0x0026
            return
        L_0x0026:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r11 = "requestJson must not be empty"
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.credentials.d.<init>(java.lang.String, java.lang.String, boolean, androidx.credentials.a$b, java.lang.String):void");
    }

    public final String c() {
        return this.f8774i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(String str, String str2, boolean z11, String str3, int i11, r rVar) {
        this(str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? false : z11, (i11 & 8) != 0 ? null : str3);
    }

    public d(String str, String str2, boolean z11, String str3) {
        this(str, str2, z11, f8773l.a(str), str3);
    }
}
