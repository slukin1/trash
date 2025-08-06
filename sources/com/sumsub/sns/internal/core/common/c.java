package com.sumsub.sns.internal.core.common;

import d10.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.collections.IntIterator;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.r;

public final class c {

    /* renamed from: c  reason: collision with root package name */
    public static final a f31994c = new a((r) null);

    /* renamed from: d  reason: collision with root package name */
    public static final int f31995d = 31;

    /* renamed from: a  reason: collision with root package name */
    public final String f31996a;

    /* renamed from: b  reason: collision with root package name */
    public final i f31997b = LazyKt__LazyJVMKt.a(new b(this));

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public a() {
        }
    }

    public static final class b extends Lambda implements d10.a<b> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f31998a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(c cVar) {
            super(0);
            this.f31998a = cVar;
        }

        /* renamed from: a */
        public final b invoke() {
            return d.a(this.f31998a.f31996a, false, 2, (Object) null);
        }
    }

    /* renamed from: com.sumsub.sns.internal.core.common.c$c  reason: collision with other inner class name */
    public static final class C0324c extends Lambda implements l<Integer, Integer> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f31999a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0324c(c cVar) {
            super(1);
            this.f31999a = cVar;
        }

        public final Integer a(int i11) {
            return Integer.valueOf(d.a(i11, Math.min(this.f31999a.f31996a.length(), 31)));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    public static final class d extends Lambda implements l<Integer, Integer> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f32000a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(c cVar) {
            super(1);
            this.f32000a = cVar;
        }

        public final Integer a(int i11) {
            return Integer.valueOf(d.a(i11, Math.min(this.f32000a.f31996a.length(), 31)));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    public c(String str) {
        this.f31996a = str;
    }

    public final List<String> b(int i11, String... strArr) {
        int i12 = i11;
        String[] strArr2 = strArr;
        ArrayList arrayList = new ArrayList();
        d dVar = new d(this);
        int i13 = i12 + 1;
        Integer[] numArr = new Integer[i13];
        int i14 = 0;
        for (int i15 = 0; i15 < i13; i15++) {
            numArr[i15] = 0;
        }
        ArrayList<String> arrayList2 = new ArrayList<>();
        int length = strArr2.length;
        int i16 = 0;
        while (true) {
            boolean z11 = true;
            if (i16 >= length) {
                break;
            }
            String str = strArr2[i16];
            if (str.length() < this.f31996a.length()) {
                z11 = false;
            }
            if (z11) {
                arrayList2.add(str);
            }
            i16++;
        }
        ArrayList<String> arrayList3 = new ArrayList<>(CollectionsKt__IterablesKt.u(arrayList2, 10));
        for (String lowerCase : arrayList2) {
            arrayList3.add(lowerCase.toLowerCase(Locale.ROOT));
        }
        for (String str2 : arrayList3) {
            if (StringsKt__StringsKt.P(str2, this.f31996a, true)) {
                arrayList.add(str2);
            } else if (i12 > 0 && this.f31996a.length() > i12) {
                ArraysKt___ArraysJvmKt.p(numArr, (Object) null, 0, 0, 6, (Object) null);
                int i17 = i14;
                while (i17 < str2.length()) {
                    char charAt = str2.charAt(i17);
                    numArr[i14] = Integer.valueOf(((Number) dVar.invoke(numArr[i14])).intValue() & ((Number) a().get(Character.valueOf(charAt))).intValue());
                    Iterator it2 = RangesKt___RangesKt.l(i12, 1).iterator();
                    while (it2.hasNext()) {
                        int a11 = ((IntIterator) it2).a();
                        numArr[a11] = Integer.valueOf((((Number) dVar.invoke(numArr[a11])).intValue() & ((Number) a().get(Character.valueOf(charAt))).intValue()) | ((Number) dVar.invoke(numArr[a11 - 1])).intValue());
                    }
                    if ((numArr[i12].intValue() & 1) > 0) {
                        arrayList.add(str2);
                    }
                    i17++;
                    i14 = 0;
                }
            }
        }
        return arrayList;
    }

    public final b a() {
        return (b) this.f31997b.getValue();
    }

    public final boolean a(int i11, String... strArr) {
        C0324c cVar = new C0324c(this);
        int i12 = i11 + 1;
        Integer[] numArr = new Integer[i12];
        for (int i13 = 0; i13 < i12; i13++) {
            numArr[i13] = 0;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        int length = strArr.length;
        int i14 = 0;
        while (true) {
            boolean z11 = true;
            if (i14 >= length) {
                break;
            }
            String str = strArr[i14];
            if (str.length() < this.f31996a.length()) {
                z11 = false;
            }
            if (z11) {
                arrayList.add(str);
            }
            i14++;
        }
        ArrayList<String> arrayList2 = new ArrayList<>(CollectionsKt__IterablesKt.u(arrayList, 10));
        for (String lowerCase : arrayList) {
            arrayList2.add(lowerCase.toLowerCase(Locale.ROOT));
        }
        for (String str2 : arrayList2) {
            if (StringsKt__StringsKt.P(str2, this.f31996a, true)) {
                return true;
            }
            if (i11 > 0 && this.f31996a.length() > i11) {
                ArraysKt___ArraysJvmKt.p(numArr, (Object) null, 0, 0, 6, (Object) null);
                for (int i15 = 0; i15 < str2.length(); i15++) {
                    char charAt = str2.charAt(i15);
                    numArr[0] = Integer.valueOf(((Number) cVar.invoke(numArr[0])).intValue() & ((Number) a().get(Character.valueOf(charAt))).intValue());
                    Iterator it2 = RangesKt___RangesKt.l(i11, 1).iterator();
                    while (it2.hasNext()) {
                        int a11 = ((IntIterator) it2).a();
                        numArr[a11] = Integer.valueOf((((Number) cVar.invoke(numArr[a11])).intValue() & ((Number) a().get(Character.valueOf(charAt))).intValue()) | ((Number) cVar.invoke(numArr[a11 - 1])).intValue());
                    }
                    if ((numArr[i11].intValue() & 1) > 0) {
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }
}
