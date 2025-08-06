package com.sumsub.sns.core.presentation.form.viewadapter;

import com.sumsub.sns.core.presentation.form.c;
import com.sumsub.sns.core.presentation.form.f;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataRadioGroupView;
import com.sumsub.sns.internal.core.data.model.h;
import com.sumsub.sns.internal.core.data.source.applicant.remote.r;
import com.sumsub.sns.internal.core.presentation.form.model.FormItem;
import d10.l;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class q extends k<FormItem.m, SNSApplicantDataRadioGroupView> {

    /* renamed from: b  reason: collision with root package name */
    public c f31043b;

    public static final class a extends Lambda implements l<String, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SNSApplicantDataRadioGroupView f31044a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FormItem.m f31045b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ q f31046c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SNSApplicantDataRadioGroupView sNSApplicantDataRadioGroupView, FormItem.m mVar, q qVar) {
            super(1);
            this.f31044a = sNSApplicantDataRadioGroupView;
            this.f31045b = mVar;
            this.f31046c = qVar;
        }

        public final void a(String str) {
            c d11;
            if (f.a(this.f31044a, this.f31045b) && (d11 = this.f31046c.d()) != null) {
                d11.b(this.f31045b, str);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((String) obj);
            return Unit.f56620a;
        }
    }

    public q(SNSApplicantDataRadioGroupView sNSApplicantDataRadioGroupView, c cVar) {
        super(sNSApplicantDataRadioGroupView);
        this.f31043b = cVar;
    }

    public final c d() {
        return this.f31043b;
    }

    public final void a(c cVar) {
        this.f31043b = cVar;
    }

    public void a(SNSApplicantDataRadioGroupView sNSApplicantDataRadioGroupView, FormItem.m mVar, int i11) {
        List list;
        List<r> r11 = mVar.d().r();
        if (r11 != null) {
            list = new ArrayList(CollectionsKt__IterablesKt.u(r11, 10));
            int i12 = 0;
            for (T next : r11) {
                int i13 = i12 + 1;
                if (i12 < 0) {
                    CollectionsKt__CollectionsKt.t();
                }
                r rVar = (r) next;
                String e11 = rVar.e();
                if (e11 == null) {
                    e11 = String.valueOf(i12);
                }
                String c11 = rVar.c();
                if (c11 == null) {
                    c11 = String.valueOf(i12);
                }
                list.add(new h.e.a.C0341a(e11, c11));
                i12 = i13;
            }
        } else {
            list = CollectionsKt__CollectionsKt.k();
        }
        sNSApplicantDataRadioGroupView.setItems(list);
        sNSApplicantDataRadioGroupView.setOnSelectionChanged(new a(sNSApplicantDataRadioGroupView, mVar, this));
    }
}
