package kotlinx.serialization.json.internal;

import com.sumsub.sns.internal.core.analytics.d;
import net.sf.scuba.smartcards.ISO7816;
import net.sf.scuba.smartcards.ISOFileInfo;

public final class n0 {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f57933a;

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f57934b;

    static {
        String[] strArr = new String[93];
        for (int i11 = 0; i11 < 32; i11++) {
            strArr[i11] = "\\u" + e(i11 >> 12) + e(i11 >> 8) + e(i11 >> 4) + e(i11);
        }
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        f57933a = strArr;
        byte[] bArr = new byte[93];
        for (int i12 = 0; i12 < 32; i12++) {
            bArr[i12] = 1;
        }
        bArr[34] = ISO7816.INS_MSE;
        bArr[92] = 92;
        bArr[9] = 116;
        bArr[8] = ISOFileInfo.FCP_BYTE;
        bArr[10] = 110;
        bArr[13] = 114;
        bArr[12] = 102;
        f57934b = bArr;
    }

    public static final byte[] a() {
        return f57934b;
    }

    public static final String[] b() {
        return f57933a;
    }

    public static final void c(StringBuilder sb2, String str) {
        sb2.append('\"');
        int length = str.length();
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            char charAt = str.charAt(i12);
            String[] strArr = f57933a;
            if (charAt < strArr.length && strArr[charAt] != null) {
                sb2.append(str, i11, i12);
                sb2.append(strArr[charAt]);
                i11 = i12 + 1;
            }
        }
        if (i11 != 0) {
            sb2.append(str, i11, str.length());
        } else {
            sb2.append(str);
        }
        sb2.append('\"');
    }

    public static final Boolean d(String str) {
        if (StringsKt__StringsJVMKt.w(str, "true", true)) {
            return Boolean.TRUE;
        }
        if (StringsKt__StringsJVMKt.w(str, d.f31895b, true)) {
            return Boolean.FALSE;
        }
        return null;
    }

    public static final char e(int i11) {
        int i12 = i11 & 15;
        return (char) (i12 < 10 ? i12 + 48 : (i12 - 10) + 97);
    }
}
