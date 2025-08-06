package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class fm implements fq {

    /* renamed from: a  reason: collision with root package name */
    private String f51798a;

    /* renamed from: a  reason: collision with other field name */
    private List<fm> f2866a = null;

    /* renamed from: a  reason: collision with other field name */
    private String[] f2867a = null;

    /* renamed from: b  reason: collision with root package name */
    private String f51799b;

    /* renamed from: b  reason: collision with other field name */
    private String[] f2868b = null;

    /* renamed from: c  reason: collision with root package name */
    private String f51800c;

    public fm(String str, String str2, String[] strArr, String[] strArr2) {
        this.f51798a = str;
        this.f51799b = str2;
        this.f2867a = strArr;
        this.f2868b = strArr2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m2690a() {
        return this.f51798a;
    }

    public String b() {
        return this.f51799b;
    }

    public String c() {
        if (!TextUtils.isEmpty(this.f51800c)) {
            return fy.b(this.f51800c);
        }
        return this.f51800c;
    }

    public String d() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<");
        sb2.append(this.f51798a);
        if (!TextUtils.isEmpty(this.f51799b)) {
            sb2.append(" ");
            sb2.append("xmlns=");
            sb2.append("\"");
            sb2.append(this.f51799b);
            sb2.append("\"");
        }
        String[] strArr = this.f2867a;
        if (strArr != null && strArr.length > 0) {
            for (int i11 = 0; i11 < this.f2867a.length; i11++) {
                if (!TextUtils.isEmpty(this.f2868b[i11])) {
                    sb2.append(" ");
                    sb2.append(this.f2867a[i11]);
                    sb2.append("=\"");
                    sb2.append(fy.a(this.f2868b[i11]));
                    sb2.append("\"");
                }
            }
        }
        if (!TextUtils.isEmpty(this.f51800c)) {
            sb2.append(">");
            sb2.append(this.f51800c);
            sb2.append("</");
            sb2.append(this.f51798a);
            sb2.append(">");
        } else {
            List<fm> list = this.f2866a;
            if (list == null || list.size() <= 0) {
                sb2.append("/>");
            } else {
                sb2.append(">");
                for (fm d11 : this.f2866a) {
                    sb2.append(d11.d());
                }
                sb2.append("</");
                sb2.append(this.f51798a);
                sb2.append(">");
            }
        }
        return sb2.toString();
    }

    public String toString() {
        return d();
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString("ext_ele_name", this.f51798a);
        bundle.putString("ext_ns", this.f51799b);
        bundle.putString("ext_text", this.f51800c);
        Bundle bundle2 = new Bundle();
        String[] strArr = this.f2867a;
        if (strArr != null && strArr.length > 0) {
            int i11 = 0;
            while (true) {
                String[] strArr2 = this.f2867a;
                if (i11 >= strArr2.length) {
                    break;
                }
                bundle2.putString(strArr2[i11], this.f2868b[i11]);
                i11++;
            }
        }
        bundle.putBundle("attributes", bundle2);
        List<fm> list = this.f2866a;
        if (list != null && list.size() > 0) {
            bundle.putParcelableArray("children", a(this.f2866a));
        }
        return bundle;
    }

    public fm(String str, String str2, String[] strArr, String[] strArr2, String str3, List<fm> list) {
        this.f51798a = str;
        this.f51799b = str2;
        this.f2867a = strArr;
        this.f2868b = strArr2;
        this.f51800c = str3;
        this.f2866a = list;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Parcelable m2689a() {
        return a();
    }

    public static Parcelable[] a(fm[] fmVarArr) {
        if (fmVarArr == null) {
            return null;
        }
        Parcelable[] parcelableArr = new Parcelable[fmVarArr.length];
        for (int i11 = 0; i11 < fmVarArr.length; i11++) {
            parcelableArr[i11] = fmVarArr[i11].a();
        }
        return parcelableArr;
    }

    public static Parcelable[] a(List<fm> list) {
        return a((fm[]) list.toArray(new fm[list.size()]));
    }

    public static fm a(Bundle bundle) {
        ArrayList arrayList;
        String string = bundle.getString("ext_ele_name");
        String string2 = bundle.getString("ext_ns");
        String string3 = bundle.getString("ext_text");
        Bundle bundle2 = bundle.getBundle("attributes");
        Set<String> keySet = bundle2.keySet();
        String[] strArr = new String[keySet.size()];
        String[] strArr2 = new String[keySet.size()];
        int i11 = 0;
        for (String str : keySet) {
            strArr[i11] = str;
            strArr2[i11] = bundle2.getString(str);
            i11++;
        }
        if (bundle.containsKey("children")) {
            Parcelable[] parcelableArray = bundle.getParcelableArray("children");
            ArrayList arrayList2 = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                arrayList2.add(a((Bundle) parcelable));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        return new fm(string, string2, strArr, strArr2, string3, arrayList);
    }

    public String a(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        } else if (this.f2867a == null) {
            return null;
        } else {
            int i11 = 0;
            while (true) {
                String[] strArr = this.f2867a;
                if (i11 >= strArr.length) {
                    return null;
                }
                if (str.equals(strArr[i11])) {
                    return this.f2868b[i11];
                }
                i11++;
            }
        }
    }

    public void a(fm fmVar) {
        if (this.f2866a == null) {
            this.f2866a = new ArrayList();
        }
        if (!this.f2866a.contains(fmVar)) {
            this.f2866a.add(fmVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2691a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f51800c = fy.a(str);
        } else {
            this.f51800c = str;
        }
    }
}
