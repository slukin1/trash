package com.sumsub.sns.core.presentation.form.viewadapter;

import com.sumsub.sns.core.presentation.form.c;
import com.sumsub.sns.core.presentation.form.f;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataMutilselectFieldView;
import com.sumsub.sns.internal.core.data.model.h;
import com.sumsub.sns.internal.core.data.source.applicant.remote.r;
import com.sumsub.sns.internal.core.presentation.form.model.FormItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class m extends k<FormItem.j, SNSApplicantDataMutilselectFieldView> {

    /* renamed from: b  reason: collision with root package name */
    public c f31022b;

    public static final class a extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f31023a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FormItem.j f31024b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SNSApplicantDataMutilselectFieldView f31025c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(m mVar, FormItem.j jVar, SNSApplicantDataMutilselectFieldView sNSApplicantDataMutilselectFieldView) {
            super(0);
            this.f31023a = mVar;
            this.f31024b = jVar;
            this.f31025c = sNSApplicantDataMutilselectFieldView;
        }

        public final void a() {
            c d11 = this.f31023a.d();
            if (d11 != null) {
                FormItem.j jVar = this.f31024b;
                d11.a((FormItem) jVar, f.c(this.f31025c, jVar));
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f56620a;
        }
    }

    public m(SNSApplicantDataMutilselectFieldView sNSApplicantDataMutilselectFieldView, c cVar) {
        super(sNSApplicantDataMutilselectFieldView);
        this.f31022b = cVar;
    }

    public final c d() {
        return this.f31022b;
    }

    public final void a(c cVar) {
        this.f31022b = cVar;
    }

    public void a(SNSApplicantDataMutilselectFieldView sNSApplicantDataMutilselectFieldView, FormItem.j jVar, int i11) {
        List list;
        List<r> r11 = jVar.d().r();
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
        sNSApplicantDataMutilselectFieldView.setItems(list);
        sNSApplicantDataMutilselectFieldView.setOnSelectionChanged(new a(this, jVar, sNSApplicantDataMutilselectFieldView));
    }
}
