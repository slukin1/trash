package com.iproov.sdk.core;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.iproov.sdk.logging.IPLog;
import com.iproov.sdk.p035try.Ccase;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Pair;
import kotlin.jvm.internal.x;

/* renamed from: com.iproov.sdk.core.class  reason: invalid class name */
public final class Cclass {

    /* renamed from: case  reason: not valid java name */
    private final int f273case;

    /* renamed from: do  reason: not valid java name */
    private final PackageManager f274do;

    /* renamed from: else  reason: not valid java name */
    private final boolean f275else;

    /* renamed from: for  reason: not valid java name */
    private final List<Pair<String, String>> f276for = CollectionsKt__CollectionsKt.n(new Pair(Ctry.A(), "1"), new Pair(Ctry.B(), "0"));

    /* renamed from: goto  reason: not valid java name */
    private final int f277goto;

    /* renamed from: if  reason: not valid java name */
    private final List<String> f278if = CollectionsKt__CollectionsKt.n(Ctry.d(), Ctry.e(), Ctry.f(), Ctry.F(), Ctry.H(), Ctry.M(), Ctry.K(), Ctry.L(), Ctry.P(), Ctry.Q(), Ctry.S(), Ctry.m450case(), Ctry.c(), Ctry.g());

    /* renamed from: new  reason: not valid java name */
    private final List<String> f279new = CollectionsKt__CollectionsKt.n(Ctry.m472private(), Ctry.m448abstract(), Ctry.j(), Ctry.m471package(), Ctry.m484transient(), Ctry.m480synchronized(), Ctry.m465implements(), Ctry.m455default(), Ctry.m483throws(), Ctry.m468interface(), Ctry.a(), Ctry.m481this(), Ctry.m459extends(), Ctry.m461finally(), Ctry.m475return(), Ctry.m466import(), Ctry.m454continue(), Ctry.m477strictfp(), Ctry.m452class(), Ctry.m453const(), Ctry.m469native(), Ctry.m482throw(), Ctry.u(), Ctry.m449break(), Ctry.m486volatile(), Ctry.v(), Ctry.m478super(), Ctry.b(), Ctry.m476static(), Ctry.x(), Ctry.m460final(), Ctry.m451catch(), Ctry.m463goto(), Ctry.m473protected(), Ctry.w(), Ctry.m467instanceof(), Ctry.m474public(), Ctry.m487while(), Ctry.m458else());

    /* renamed from: try  reason: not valid java name */
    private final List<String> f280try = CollectionsKt__CollectionsKt.n(Ctry.I(), Ctry.J(), Ctry.O(), Ctry.R(), Ctry.W(), Ctry.E(), Ctry.i());

    public Cclass(Context context) {
        this.f274do = context.getPackageManager();
        boolean z11 = false;
        int i11 = 4;
        int i12 = Build.VERSION.SDK_INT;
        this.f273case = i12;
        z11 = i12 < 23 ? true : z11;
        this.f275else = z11;
        this.f277goto = !z11 ? 6 : i11;
    }

    /* renamed from: case  reason: not valid java name */
    private final boolean m333case() {
        boolean z11;
        String[] strArr = Ccase.m2125do(Ctry.n(), (String[]) null, 1, (Object) null);
        if (strArr == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            List<Pair<String, String>> list = this.f276for;
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.u(list, 10));
            for (Pair pair : list) {
                if (StringsKt__StringsKt.R(str, (CharSequence) pair.getFirst(), false, 2, (Object) null)) {
                    if (StringsKt__StringsKt.R(str, '[' + ((String) pair.getSecond()) + ']', false, 2, (Object) null)) {
                        z11 = true;
                        arrayList2.add(Boolean.valueOf(z11));
                    }
                }
                z11 = false;
                arrayList2.add(Boolean.valueOf(z11));
            }
            arrayList.add(Boolean.valueOf(Ccase.m2123do(arrayList2)));
        }
        return Ccase.m2123do(arrayList);
    }

    /* renamed from: do  reason: not valid java name */
    private final boolean m334do() {
        List<String> list = this.f278if;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(list, 10));
        for (String str : list) {
            arrayList.add(Boolean.valueOf(Ccase.m2122do(str, Ctry.s())));
        }
        return Ccase.m2123do(arrayList);
    }

    /* renamed from: else  reason: not valid java name */
    private final boolean m337else() {
        String[] strArr = Ccase.m2125do(Ctry.t(), (String[]) null, 1, (Object) null);
        if (strArr == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String L0 : strArr) {
            arrayList.add(StringsKt__StringsKt.L0(L0, new String[]{" "}, false, 0, 6, (Object) null));
        }
        ArrayList<List> arrayList2 = new ArrayList<>();
        for (Object next : arrayList) {
            if (((List) next).size() >= this.f277goto) {
                arrayList2.add(next);
            }
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.u(arrayList2, 10));
        for (List list : arrayList2) {
            List<String> list2 = this.f280try;
            ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.u(list2, 10));
            for (String str : list2) {
                arrayList4.add(Boolean.valueOf(m336do(str, list)));
            }
            arrayList3.add(Boolean.valueOf(Ccase.m2123do(arrayList4)));
        }
        return Ccase.m2123do(arrayList3);
    }

    /* renamed from: for  reason: not valid java name */
    private final boolean m338for() {
        boolean z11 = false;
        String[] strArr = Ccase.m2124do(Ctry.X(), new String[]{Ctry.G()});
        if (strArr == null) {
            return false;
        }
        if (strArr.length == 0) {
            z11 = true;
        }
        return !z11;
    }

    /* renamed from: goto  reason: not valid java name */
    private final boolean m339goto() {
        String str = Build.TAGS;
        if (str == null) {
            return false;
        }
        return StringsKt__StringsKt.R(str, Ctry.T(), false, 2, (Object) null);
    }

    /* renamed from: if  reason: not valid java name */
    private final boolean m340if() {
        List<String> list = this.f278if;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(list, 10));
        for (String str : list) {
            arrayList.add(Boolean.valueOf(Ccase.m2122do(str, Ctry.G())));
        }
        return Ccase.m2123do(arrayList);
    }

    /* renamed from: new  reason: not valid java name */
    private final boolean m341new() {
        if (!NativeLibraryLoader.f228do) {
            return true;
        }
        List<String> list = this.f278if;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(list, 10));
        for (String i11 : list) {
            arrayList.add(x.i(i11, Ctry.G()));
        }
        Object[] array = arrayList.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        try {
            if (new NativeLibraryLoader().suNativeCheck((String[]) array) > 0) {
                return true;
            }
        } catch (UnsatisfiedLinkError unused) {
            IPLog.w("NativeLib", "Not loaded");
        }
        return false;
    }

    /* renamed from: try  reason: not valid java name */
    private final boolean m342try() {
        List<String> list = this.f279new;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(list, 10));
        for (String str : list) {
            arrayList.add(Boolean.valueOf(m335do(str)));
        }
        return Ccase.m2123do(arrayList);
    }

    /* renamed from: this  reason: not valid java name */
    public final boolean m343this() {
        return m340if() || m338for() || m339goto() || m333case() || m337else() || m334do() || m342try() || m341new();
    }

    /* renamed from: do  reason: not valid java name */
    private final boolean m336do(String str, List<String> list) {
        List<String> list2 = list;
        String str2 = this.f275else ? list2.get(1) : list2.get(2);
        String str3 = list2.get(this.f275else ? 3 : 5);
        if (!StringsKt__StringsJVMKt.w(str2, str, true)) {
            return false;
        }
        if (!this.f275else) {
            str3 = StringsKt__StringsJVMKt.G(StringsKt__StringsJVMKt.G(str3, "(", "", false, 4, (Object) null), ")", "", false, 4, (Object) null);
        }
        List<String> L0 = StringsKt__StringsKt.L0(str3, new String[]{Constants.ACCEPT_TIME_SEPARATOR_SP}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(L0, 10));
        for (String w11 : L0) {
            arrayList.add(Boolean.valueOf(StringsKt__StringsJVMKt.w(w11, Ctry.C(), true)));
        }
        return Ccase.m2123do(arrayList);
    }

    /* renamed from: do  reason: not valid java name */
    private final boolean m335do(String str) {
        try {
            this.f274do.getPackageInfo(str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
