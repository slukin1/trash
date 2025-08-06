package com.sumsub.sns.core.presentation.form.viewadapter;

import android.view.View;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataFileFieldView;
import com.sumsub.sns.internal.core.presentation.form.model.FormItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class l extends k<FormItem.i, SNSApplicantDataFileFieldView> {

    /* renamed from: b  reason: collision with root package name */
    public com.sumsub.sns.core.presentation.form.c f31016b;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f31017a;

        static {
            int[] iArr = new int[FormItem.ItemState.values().length];
            iArr[FormItem.ItemState.LOADING.ordinal()] = 1;
            f31017a = iArr;
        }
    }

    public static final class b extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f31018a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FormItem.i f31019b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(l lVar, FormItem.i iVar) {
            super(0);
            this.f31018a = lVar;
            this.f31019b = iVar;
        }

        public final void a() {
            com.sumsub.sns.core.presentation.form.c d11 = this.f31018a.d();
            if (d11 != null) {
                d11.a(this.f31019b);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f56620a;
        }
    }

    public static final class c extends Lambda implements d10.l<String, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f31020a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FormItem.i f31021b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(l lVar, FormItem.i iVar) {
            super(1);
            this.f31020a = lVar;
            this.f31021b = iVar;
        }

        public final void a(String str) {
            com.sumsub.sns.core.presentation.form.c d11 = this.f31020a.d();
            if (d11 != null) {
                d11.a((FormItem) this.f31021b, str);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((String) obj);
            return Unit.f56620a;
        }
    }

    public l(SNSApplicantDataFileFieldView sNSApplicantDataFileFieldView, com.sumsub.sns.core.presentation.form.c cVar) {
        super(sNSApplicantDataFileFieldView);
        this.f31016b = cVar;
    }

    public void c() {
        View view = this.itemView;
        SNSApplicantDataFileFieldView sNSApplicantDataFileFieldView = view instanceof SNSApplicantDataFileFieldView ? (SNSApplicantDataFileFieldView) view : null;
        if (sNSApplicantDataFileFieldView != null) {
            sNSApplicantDataFileFieldView.cleanup();
        }
    }

    public final com.sumsub.sns.core.presentation.form.c d() {
        return this.f31016b;
    }

    public final void a(com.sumsub.sns.core.presentation.form.c cVar) {
        this.f31016b = cVar;
    }

    public void a(SNSApplicantDataFileFieldView sNSApplicantDataFileFieldView, FormItem.i iVar, int i11) {
        SNSApplicantDataFileFieldView.State state;
        SNSApplicantDataFileFieldView.State state2;
        sNSApplicantDataFileFieldView.setPickFileClickListener(new b(this, iVar));
        sNSApplicantDataFileFieldView.setDeleteFileClickListener(new c(this, iVar));
        String v11 = iVar.v();
        if (v11 == null) {
            v11 = "";
        }
        sNSApplicantDataFileFieldView.setPickFileLabel(v11);
        if (a.f31017a[iVar.x().ordinal()] == 1) {
            state = SNSApplicantDataFileFieldView.State.LOADING;
        } else {
            state = SNSApplicantDataFileFieldView.State.DEFAULT;
        }
        sNSApplicantDataFileFieldView.setState(state);
        List<FormItem.ItemState> u11 = iVar.u();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(u11, 10));
        for (FormItem.ItemState ordinal : u11) {
            if (a.f31017a[ordinal.ordinal()] == 1) {
                state2 = SNSApplicantDataFileFieldView.State.LOADING;
            } else {
                state2 = SNSApplicantDataFileFieldView.State.DEFAULT;
            }
            arrayList.add(state2);
        }
        sNSApplicantDataFileFieldView.setItemStates(arrayList);
    }
}
