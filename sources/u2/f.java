package u2;

import android.text.TextUtils;
import t2.b;
import t2.c;
import t2.d;
import t2.e;
import t2.h;
import t2.i;
import t2.j;
import t2.k;

public class f {

    public static class a implements j<e> {
        /* renamed from: b */
        public e a(String str) {
            return e.a(str);
        }
    }

    public static void a(q2.a aVar, String str, i<e> iVar) {
        String str2;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("/");
        sb2.append(aVar.s());
        sb2.append("/ss?platform=android&sdk_version=");
        sb2.append("2.2.2");
        if (TextUtils.isEmpty(str)) {
            str2 = "";
        } else {
            str2 = "&region=" + str;
        }
        sb2.append(str2);
        sb2.append(com.alibaba.sdk.android.httpdns.f.f.h());
        String sb3 = sb2.toString();
        b[] b11 = b(aVar.e().e(), aVar.e().f(), aVar.d().e(), aVar.d().f());
        try {
            aVar.c().execute(new e(new k(new t2.f(new t2.f(new t2.f(new b(new c(aVar.m(), b11[0].b(), b11[0].a(aVar.m()), sb3, aVar.v()), new a()), new d(s2.b.b(aVar.s()))), new h(aVar.l())), new d(b11)), b11.length - 1), iVar));
        } catch (Throwable th2) {
            iVar.a(th2);
        }
    }

    public static b[] b(String[] strArr, int[] iArr, String[] strArr2, int[] iArr2) {
        b[] bVarArr = new b[(strArr.length + strArr2.length)];
        int i11 = 0;
        int i12 = 0;
        while (true) {
            int i13 = -1;
            if (i12 >= strArr.length) {
                break;
            }
            String str = strArr[i12];
            if (iArr != null && iArr.length > i12) {
                i13 = iArr[i12];
            }
            bVarArr[i12] = new b(str, i13);
            i12++;
        }
        int length = strArr.length;
        while (i11 < strArr2.length) {
            bVarArr[length + i11] = new b(strArr2[i11], (iArr2 == null || iArr2.length <= i11) ? -1 : iArr2[i11]);
            i11++;
        }
        return bVarArr;
    }
}
