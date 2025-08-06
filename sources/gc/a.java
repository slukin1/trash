package gc;

import android.text.TextUtils;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f19130a = new a();

    public final String a(int i11, String str, String str2) {
        String obj;
        String obj2;
        if (str != null && (obj2 = StringsKt__StringsKt.i1(str).toString()) != null && !TextUtils.isEmpty(obj2)) {
            return obj2.length() > i11 ? obj2.substring(0, i11) : obj2;
        }
        if (str2 == null || (obj = StringsKt__StringsKt.i1(str2).toString()) == null || TextUtils.isEmpty(obj)) {
            return "";
        }
        return obj.length() > i11 ? obj.substring(0, i11) : obj;
    }
}
