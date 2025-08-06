package androidx.credentials;

import android.os.Bundle;
import androidx.credentials.internal.FrameworkClassParsingException;
import kotlin.jvm.internal.r;

public final class n extends i {

    /* renamed from: d  reason: collision with root package name */
    public static final a f8812d = new a((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f8813a;

    /* renamed from: b  reason: collision with root package name */
    public final String f8814b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f8815c;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final n a(Bundle bundle) {
            try {
                return new n(bundle.getString("androidx.credentials.BUNDLE_KEY_REQUEST_JSON"), bundle.getString("androidx.credentials.BUNDLE_KEY_CLIENT_DATA_HASH"), ((Boolean) bundle.get("androidx.credentials.BUNDLE_KEY_PREFER_IMMEDIATELY_AVAILABLE_CREDENTIALS")).booleanValue());
            } catch (Exception unused) {
                throw new FrameworkClassParsingException();
            }
        }

        public final Bundle b(String str, String str2, boolean z11) {
            Bundle bundle = new Bundle();
            bundle.putString("androidx.credentials.BUNDLE_KEY_SUBTYPE", "androidx.credentials.BUNDLE_VALUE_SUBTYPE_GET_PUBLIC_KEY_CREDENTIAL_OPTION");
            bundle.putString("androidx.credentials.BUNDLE_KEY_REQUEST_JSON", str);
            bundle.putString("androidx.credentials.BUNDLE_KEY_CLIENT_DATA_HASH", str2);
            bundle.putBoolean("androidx.credentials.BUNDLE_KEY_PREFER_IMMEDIATELY_AVAILABLE_CREDENTIALS", z11);
            return bundle;
        }
    }

    public n(String str) {
        this(str, (String) null, false, 6, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n(String str, String str2, boolean z11, int i11, r rVar) {
        this(str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? false : z11);
    }

    public final String a() {
        return this.f8813a;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public n(java.lang.String r8, java.lang.String r9, boolean r10) {
        /*
            r7 = this;
            androidx.credentials.n$a r0 = f8812d
            android.os.Bundle r3 = r0.b(r8, r9, r10)
            android.os.Bundle r4 = r0.b(r8, r9, r10)
            java.lang.String r2 = "androidx.credentials.TYPE_PUBLIC_KEY_CREDENTIAL"
            r5 = 0
            r6 = 1
            r1 = r7
            r1.<init>(r2, r3, r4, r5, r6)
            r7.f8813a = r8
            r7.f8814b = r9
            r7.f8815c = r10
            int r8 = r8.length()
            if (r8 <= 0) goto L_0x0020
            r8 = 1
            goto L_0x0021
        L_0x0020:
            r8 = 0
        L_0x0021:
            if (r8 == 0) goto L_0x0024
            return
        L_0x0024:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "requestJson must not be empty"
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.credentials.n.<init>(java.lang.String, java.lang.String, boolean):void");
    }
}
