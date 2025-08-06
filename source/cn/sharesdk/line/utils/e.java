package cn.sharesdk.line.utils;

import android.text.TextUtils;
import cn.sharesdk.framework.InnerShareParams;
import com.facebook.internal.NativeProtocol;
import com.facebook.places.model.PlaceFields;
import com.google.android.gms.common.Scopes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f13659a = new e(Scopes.PROFILE);

    /* renamed from: b  reason: collision with root package name */
    public static final e f13660b = new e(NativeProtocol.AUDIENCE_FRIENDS);

    /* renamed from: c  reason: collision with root package name */
    public static final e f13661c = new e("groups");

    /* renamed from: d  reason: collision with root package name */
    public static final e f13662d = new e("message.write");

    /* renamed from: e  reason: collision with root package name */
    public static final e f13663e = new e(Scopes.OPEN_ID);

    /* renamed from: f  reason: collision with root package name */
    public static final e f13664f = new e("email");

    /* renamed from: g  reason: collision with root package name */
    public static final e f13665g = new e(PlaceFields.PHONE);

    /* renamed from: h  reason: collision with root package name */
    public static final e f13666h = new e("gender");

    /* renamed from: i  reason: collision with root package name */
    public static final e f13667i = new e("birthdate");

    /* renamed from: j  reason: collision with root package name */
    public static final e f13668j = new e(InnerShareParams.ADDRESS);

    /* renamed from: k  reason: collision with root package name */
    public static final e f13669k = new e("real_name");

    /* renamed from: l  reason: collision with root package name */
    private static final Map<String, e> f13670l = new HashMap();

    /* renamed from: m  reason: collision with root package name */
    private final String f13671m;

    public e(String str) {
        Map<String, e> map = f13670l;
        if (!map.containsKey(str)) {
            this.f13671m = str;
            map.put(str, this);
            return;
        }
        throw new IllegalArgumentException("Scope code already exists: " + str);
    }

    public static e a(String str) {
        return f13670l.get(str);
    }

    public static List<e> b(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String a11 : list) {
            e a12 = a(a11);
            if (a12 != null) {
                arrayList.add(a12);
            }
        }
        return arrayList;
    }

    public static List<String> c(List<e> list) {
        ArrayList arrayList = new ArrayList();
        for (e eVar : list) {
            arrayList.add(eVar.f13671m);
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f13671m.equals(((e) obj).f13671m);
    }

    public int hashCode() {
        return this.f13671m.hashCode();
    }

    public String toString() {
        return "Scope{code='" + this.f13671m + '\'' + '}';
    }

    public static String a(List<e> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return TextUtils.join(" ", c(list));
    }
}
