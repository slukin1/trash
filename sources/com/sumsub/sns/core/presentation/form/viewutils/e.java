package com.sumsub.sns.core.presentation.form.viewutils;

import android.content.Context;
import android.util.AttributeSet;
import com.sumsub.sns.core.presentation.form.c;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataBaseFieldView;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataFileFieldView;
import com.sumsub.sns.internal.core.presentation.form.model.FormItem;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.r;

public final class e {

    public static final class a extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f31065a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FormItem.g f31066b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(c cVar, FormItem.g gVar) {
            super(0);
            this.f31065a = cVar;
            this.f31066b = gVar;
        }

        public final void a() {
            c cVar = this.f31065a;
            if (cVar != null) {
                cVar.a(this.f31066b);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f56620a;
        }
    }

    public static final class b extends Lambda implements l<String, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f31067a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FormItem.g f31068b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(c cVar, FormItem.g gVar) {
            super(1);
            this.f31067a = cVar;
            this.f31068b = gVar;
        }

        public final void a(String str) {
            c cVar = this.f31067a;
            if (cVar != null) {
                cVar.a((FormItem) this.f31068b, str);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((String) obj);
            return Unit.f56620a;
        }
    }

    public static final SNSApplicantDataBaseFieldView a(FormItem.g gVar, Context context, c cVar) {
        SNSApplicantDataFileFieldView sNSApplicantDataFileFieldView = new SNSApplicantDataFileFieldView(context, (AttributeSet) null, 0, 0, 14, (r) null);
        sNSApplicantDataFileFieldView.setPickFileClickListener(new a(cVar, gVar));
        sNSApplicantDataFileFieldView.setDeleteFileClickListener(new b(cVar, gVar));
        String u11 = gVar.u();
        if (u11 == null) {
            u11 = "";
        }
        sNSApplicantDataFileFieldView.setPickFileLabel(u11);
        return sNSApplicantDataFileFieldView;
    }

    public static final void a(SNSApplicantDataFileFieldView sNSApplicantDataFileFieldView, FormItem.g gVar, String str) {
        if (sNSApplicantDataFileFieldView != null) {
            if (str != null) {
                sNSApplicantDataFileFieldView.setFiles(CollectionsKt__CollectionsJVMKt.e(new SNSApplicantDataFileFieldView.Attachment(str, str, gVar.v())));
            }
            if (gVar.f() == null) {
                sNSApplicantDataFileFieldView.setFiles(CollectionsKt__CollectionsKt.k());
            }
            sNSApplicantDataFileFieldView.setShowPickFile(sNSApplicantDataFileFieldView.getFiles().isEmpty());
        }
    }
}
