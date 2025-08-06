package com.sumsub.sns.core.presentation.form.viewutils;

import android.content.Context;
import android.util.AttributeSet;
import com.sumsub.sns.core.presentation.form.c;
import com.sumsub.sns.core.presentation.form.f;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataBaseFieldView;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataSelectionFieldView;
import com.sumsub.sns.internal.core.data.model.h;
import com.sumsub.sns.internal.core.presentation.form.model.FormItem;
import d10.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class j {

    public static final class a extends Lambda implements l<h.e.a.C0341a, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f31083a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FormItem.n f31084b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SNSApplicantDataSelectionFieldView f31085c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(c cVar, FormItem.n nVar, SNSApplicantDataSelectionFieldView sNSApplicantDataSelectionFieldView) {
            super(1);
            this.f31083a = cVar;
            this.f31084b = nVar;
            this.f31085c = sNSApplicantDataSelectionFieldView;
        }

        public final void a(h.e.a.C0341a aVar) {
            c cVar = this.f31083a;
            if (cVar != null) {
                FormItem.n nVar = this.f31084b;
                cVar.b(nVar, f.b(this.f31085c, nVar));
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((h.e.a.C0341a) obj);
            return Unit.f56620a;
        }
    }

    public static final SNSApplicantDataBaseFieldView a(FormItem.n nVar, Context context, c cVar) {
        List list;
        SNSApplicantDataSelectionFieldView sNSApplicantDataSelectionFieldView = new SNSApplicantDataSelectionFieldView(context, (AttributeSet) null, 0, 6, (r) null);
        List<com.sumsub.sns.internal.core.data.source.applicant.remote.r> r11 = nVar.d().r();
        if (r11 != null) {
            list = new ArrayList(CollectionsKt__IterablesKt.u(r11, 10));
            int i11 = 0;
            for (T next : r11) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    CollectionsKt__CollectionsKt.t();
                }
                com.sumsub.sns.internal.core.data.source.applicant.remote.r rVar = (com.sumsub.sns.internal.core.data.source.applicant.remote.r) next;
                String e11 = rVar.e();
                if (e11 == null) {
                    e11 = String.valueOf(i11);
                }
                String c11 = rVar.c();
                if (c11 == null) {
                    c11 = String.valueOf(i11);
                }
                list.add(new h.e.a.C0341a(e11, c11));
                i11 = i12;
            }
        } else {
            list = CollectionsKt__CollectionsKt.k();
        }
        sNSApplicantDataSelectionFieldView.setItems(list);
        sNSApplicantDataSelectionFieldView.setOnSelectedCallback(new a(cVar, nVar, sNSApplicantDataSelectionFieldView));
        return sNSApplicantDataSelectionFieldView;
    }

    public static final void a(SNSApplicantDataSelectionFieldView sNSApplicantDataSelectionFieldView, String str) {
        T t11;
        Iterator<T> it2 = sNSApplicantDataSelectionFieldView.getItems().iterator();
        while (true) {
            if (!it2.hasNext()) {
                t11 = null;
                break;
            }
            t11 = it2.next();
            if (x.b(((h.e.a.C0341a) t11).c(), str)) {
                break;
            }
        }
        sNSApplicantDataSelectionFieldView.setSelectedItem((h.e.a.C0341a) t11);
    }
}
