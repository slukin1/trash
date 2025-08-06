package com.sumsub.sns.core.presentation.form.viewadapter;

import android.view.View;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataFileFieldView;
import com.sumsub.sns.internal.core.presentation.form.model.FormItem;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class h extends k<FormItem.g, SNSApplicantDataFileFieldView> {

    /* renamed from: b  reason: collision with root package name */
    public com.sumsub.sns.core.presentation.form.c f30986b;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f30987a;

        static {
            int[] iArr = new int[FormItem.ItemState.values().length];
            iArr[FormItem.ItemState.LOADING.ordinal()] = 1;
            f30987a = iArr;
        }
    }

    public static final class b extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f30988a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FormItem.g f30989b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(h hVar, FormItem.g gVar) {
            super(0);
            this.f30988a = hVar;
            this.f30989b = gVar;
        }

        public final void a() {
            com.sumsub.sns.core.presentation.form.c d11 = this.f30988a.d();
            if (d11 != null) {
                d11.a(this.f30989b);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f56620a;
        }
    }

    public static final class c extends Lambda implements l<String, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f30990a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FormItem.g f30991b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(h hVar, FormItem.g gVar) {
            super(1);
            this.f30990a = hVar;
            this.f30991b = gVar;
        }

        public final void a(String str) {
            com.sumsub.sns.core.presentation.form.c d11 = this.f30990a.d();
            if (d11 != null) {
                d11.a((FormItem) this.f30991b, str);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((String) obj);
            return Unit.f56620a;
        }
    }

    public h(SNSApplicantDataFileFieldView sNSApplicantDataFileFieldView, com.sumsub.sns.core.presentation.form.c cVar) {
        super(sNSApplicantDataFileFieldView);
        this.f30986b = cVar;
    }

    public void c() {
        View view = this.itemView;
        SNSApplicantDataFileFieldView sNSApplicantDataFileFieldView = view instanceof SNSApplicantDataFileFieldView ? (SNSApplicantDataFileFieldView) view : null;
        if (sNSApplicantDataFileFieldView != null) {
            sNSApplicantDataFileFieldView.cleanup();
        }
    }

    public final com.sumsub.sns.core.presentation.form.c d() {
        return this.f30986b;
    }

    public final void a(com.sumsub.sns.core.presentation.form.c cVar) {
        this.f30986b = cVar;
    }

    public void a(SNSApplicantDataFileFieldView sNSApplicantDataFileFieldView, FormItem.g gVar, int i11) {
        SNSApplicantDataFileFieldView.State state;
        SNSApplicantDataFileFieldView.State state2;
        sNSApplicantDataFileFieldView.setPickFileClickListener(new b(this, gVar));
        sNSApplicantDataFileFieldView.setDeleteFileClickListener(new c(this, gVar));
        String u11 = gVar.u();
        if (u11 == null) {
            u11 = "";
        }
        sNSApplicantDataFileFieldView.setPickFileLabel(u11);
        FormItem.ItemState w11 = gVar.w();
        int[] iArr = a.f30987a;
        if (iArr[w11.ordinal()] == 1) {
            state = SNSApplicantDataFileFieldView.State.LOADING;
        } else {
            state = SNSApplicantDataFileFieldView.State.DEFAULT;
        }
        sNSApplicantDataFileFieldView.setState(state);
        if (iArr[gVar.t().ordinal()] == 1) {
            state2 = SNSApplicantDataFileFieldView.State.LOADING;
        } else {
            state2 = SNSApplicantDataFileFieldView.State.DEFAULT;
        }
        sNSApplicantDataFileFieldView.setItemStates(CollectionsKt__CollectionsJVMKt.e(state2));
    }
}
