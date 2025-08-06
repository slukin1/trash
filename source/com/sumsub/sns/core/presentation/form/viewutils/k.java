package com.sumsub.sns.core.presentation.form.viewutils;

import android.content.Context;
import android.util.AttributeSet;
import com.sumsub.sns.core.presentation.form.c;
import com.sumsub.sns.core.presentation.form.f;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataBaseFieldView;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataRadioGroupView;
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

public final class k {

    public static final class a extends Lambda implements l<String, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SNSApplicantDataRadioGroupView f31086a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FormItem.m f31087b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f31088c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SNSApplicantDataRadioGroupView sNSApplicantDataRadioGroupView, FormItem.m mVar, c cVar) {
            super(1);
            this.f31086a = sNSApplicantDataRadioGroupView;
            this.f31087b = mVar;
            this.f31088c = cVar;
        }

        public final void a(String str) {
            c cVar;
            if (f.a(this.f31086a, this.f31087b) && (cVar = this.f31088c) != null) {
                cVar.b(this.f31087b, str);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((String) obj);
            return Unit.f56620a;
        }
    }

    public static final SNSApplicantDataBaseFieldView a(FormItem.m mVar, Context context, c cVar) {
        List list;
        SNSApplicantDataRadioGroupView sNSApplicantDataRadioGroupView = new SNSApplicantDataRadioGroupView(context, (AttributeSet) null, 0, 0, 14, (r) null);
        List<com.sumsub.sns.internal.core.data.source.applicant.remote.r> r11 = mVar.d().r();
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
        sNSApplicantDataRadioGroupView.setItems(list);
        sNSApplicantDataRadioGroupView.setOnSelectionChanged(new a(sNSApplicantDataRadioGroupView, mVar, cVar));
        return sNSApplicantDataRadioGroupView;
    }

    public static final void a(SNSApplicantDataRadioGroupView sNSApplicantDataRadioGroupView, String str) {
        T t11;
        Iterator<T> it2 = sNSApplicantDataRadioGroupView.getItems().iterator();
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
        sNSApplicantDataRadioGroupView.setSelectedItem((h.e.a.C0341a) t11);
    }
}
