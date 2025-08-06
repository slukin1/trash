package com.sumsub.sns.internal.presentation.utils;

import com.sumsub.sns.internal.core.data.model.h;
import com.sumsub.sns.internal.core.data.source.applicant.remote.k;
import com.sumsub.sns.internal.core.data.source.applicant.remote.r;
import com.sumsub.sns.internal.core.presentation.form.model.FormItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f36439a = "appdata";

    public static /* synthetic */ FormItem a(h.e eVar, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = null;
        }
        return a(eVar, str);
    }

    public static final FormItem a(h.e eVar, String str) {
        if (eVar instanceof h.e.a) {
            h.e.a aVar = (h.e.a) eVar;
            List<h.e.a.C0341a> h11 = aVar.h();
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(h11, 10));
            for (h.e.a.C0341a aVar2 : h11) {
                arrayList.add(new r(aVar2.c(), aVar2.d()));
            }
            k kVar = new k(str, aVar.i(), (String) null, (String) null, (Boolean) null, (String) null, (String) null, (String) null, (List) arrayList, 252, (kotlin.jvm.internal.r) null);
            r rVar = (r) CollectionsKt___CollectionsKt.d0(arrayList, aVar.g());
            return new FormItem.n(kVar, "appdata", rVar != null ? rVar.e() : null, false, (CharSequence) null, 24, (kotlin.jvm.internal.r) null);
        } else if (eVar instanceof h.e.b) {
            return new FormItem.f(((h.e.b) eVar).e().toString(), "appdata");
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
