package com.sumsub.sns.core.presentation.form.viewadapter;

import com.sumsub.sns.core.presentation.form.c;
import com.sumsub.sns.core.presentation.form.f;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataSelectionFieldView;
import com.sumsub.sns.internal.core.data.model.h;
import com.sumsub.sns.internal.core.data.source.applicant.remote.r;
import com.sumsub.sns.internal.core.presentation.form.model.FormItem;
import d10.l;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class p extends k<FormItem.n, SNSApplicantDataSelectionFieldView> {

    /* renamed from: b  reason: collision with root package name */
    public c f31039b;

    public static final class a extends Lambda implements l<h.e.a.C0341a, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ p f31040a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FormItem.n f31041b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SNSApplicantDataSelectionFieldView f31042c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(p pVar, FormItem.n nVar, SNSApplicantDataSelectionFieldView sNSApplicantDataSelectionFieldView) {
            super(1);
            this.f31040a = pVar;
            this.f31041b = nVar;
            this.f31042c = sNSApplicantDataSelectionFieldView;
        }

        public final void a(h.e.a.C0341a aVar) {
            c d11 = this.f31040a.d();
            if (d11 != null) {
                FormItem.n nVar = this.f31041b;
                d11.b(nVar, f.b(this.f31042c, nVar));
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((h.e.a.C0341a) obj);
            return Unit.f56620a;
        }
    }

    public p(SNSApplicantDataSelectionFieldView sNSApplicantDataSelectionFieldView, c cVar) {
        super(sNSApplicantDataSelectionFieldView);
        this.f31039b = cVar;
    }

    public final c d() {
        return this.f31039b;
    }

    public final void a(c cVar) {
        this.f31039b = cVar;
    }

    public void a(SNSApplicantDataSelectionFieldView sNSApplicantDataSelectionFieldView, FormItem.n nVar, int i11) {
        List list;
        List<r> r11 = nVar.d().r();
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
        sNSApplicantDataSelectionFieldView.setItems(list);
        sNSApplicantDataSelectionFieldView.setOnSelectedCallback(new a(this, nVar, sNSApplicantDataSelectionFieldView));
    }
}
