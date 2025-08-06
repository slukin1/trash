package com.huobi.sharev2.createimage.create;

import android.content.Context;
import com.huobi.sharev2.helper.NewShareHelper;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Ref$ObjectRef;

public final class CanvasImageReady {

    /* renamed from: a  reason: collision with root package name */
    public int f81048a = 1000;

    /* renamed from: b  reason: collision with root package name */
    public int f81049b = 1500;

    /* renamed from: c  reason: collision with root package name */
    public String f81050c;

    /* renamed from: d  reason: collision with root package name */
    public a f81051d;

    public final a a() {
        return this.f81051d;
    }

    public final String b() {
        return this.f81050c;
    }

    public final int c() {
        return this.f81049b;
    }

    public final int d() {
        return this.f81048a;
    }

    public final Integer[] e(String str) {
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = new Integer[0];
        if (str != null) {
            try {
                List<String> L0 = StringsKt__StringsKt.L0(str, new String[]{Constants.ACCEPT_TIME_SEPARATOR_SP}, false, 0, 6, (Object) null);
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(L0, 10));
                for (String parseInt : L0) {
                    arrayList.add(Integer.valueOf(Integer.parseInt(parseInt)));
                }
                ref$ObjectRef.element = arrayList.toArray(new Integer[0]);
            } catch (Exception unused) {
            }
        }
        return (Integer[]) ref$ObjectRef.element;
    }

    public final void f(f fVar, Context context) {
        String b11 = fVar.b();
        if (b11 != null) {
            int hashCode = b11.hashCode();
            if (hashCode != -951532658) {
                if (hashCode != 3556653) {
                    if (hashCode == 100313435 && b11.equals("image")) {
                        Integer[] e11 = e(fVar.a());
                        fVar.e(e11);
                        fVar.d(c.f81058a.b(fVar.c(), context, e11[2].intValue(), e11[3].intValue()));
                    }
                } else if (b11.equals("text")) {
                    fVar.e(e(fVar.a()));
                }
            } else if (b11.equals("qrcode")) {
                Integer[] e12 = e(fVar.a());
                fVar.e(e12);
                fVar.d(NewShareHelper.j().e(context, fVar.c(), e12[2].intValue()));
            }
        }
    }

    public final void g(a aVar) {
        this.f81051d = aVar;
        aVar.a();
        aVar.a();
        this.f81050c = null;
    }
}
