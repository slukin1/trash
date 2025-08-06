package androidx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public static DataBinderMapper f8873a = new DataBinderMapperImpl();

    /* renamed from: b  reason: collision with root package name */
    public static b f8874b = null;

    public static <T extends f> T a(b bVar, View view, int i11) {
        return f8873a.b(bVar, view, i11);
    }

    public static <T extends f> T b(b bVar, View[] viewArr, int i11) {
        return f8873a.c(bVar, viewArr, i11);
    }

    public static <T extends f> T c(b bVar, ViewGroup viewGroup, int i11, int i12) {
        int childCount = viewGroup.getChildCount();
        int i13 = childCount - i11;
        if (i13 == 1) {
            return a(bVar, viewGroup.getChildAt(childCount - 1), i12);
        }
        View[] viewArr = new View[i13];
        for (int i14 = 0; i14 < i13; i14++) {
            viewArr[i14] = viewGroup.getChildAt(i14 + i11);
        }
        return b(bVar, viewArr, i12);
    }

    public static b d() {
        return f8874b;
    }

    public static <T extends f> T e(LayoutInflater layoutInflater, int i11, ViewGroup viewGroup, boolean z11) {
        return f(layoutInflater, i11, viewGroup, z11, f8874b);
    }

    public static <T extends f> T f(LayoutInflater layoutInflater, int i11, ViewGroup viewGroup, boolean z11, b bVar) {
        int i12 = 0;
        boolean z12 = viewGroup != null && z11;
        if (z12) {
            i12 = viewGroup.getChildCount();
        }
        View inflate = layoutInflater.inflate(i11, viewGroup, z11);
        if (z12) {
            return c(bVar, viewGroup, i12, i11);
        }
        return a(bVar, inflate, i11);
    }
}
