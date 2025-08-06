package com.sumsub.sns.core.presentation.form.viewadapter;

import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.sumsub.sns.core.presentation.form.c;
import com.sumsub.sns.core.presentation.form.e;
import com.sumsub.sns.core.widget.SNSApplicantDataFieldView;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataBaseFieldView;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataBoolFieldView;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataCalendarFieldView;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataDateTimeFieldView;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataDescriptionView;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataFileFieldView;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataMutilselectFieldView;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataPhoneFieldView;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataRadioGroupView;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataSectionView;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataSelectionCountryFieldView;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataSelectionFieldView;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataSubtitleView;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataTextAreaFieldView;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataTitleView;
import com.sumsub.sns.internal.core.presentation.form.model.FormItem;
import d10.l;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class i extends com.sumsub.sns.core.presentation.base.adapter.a<FormItem, k<FormItem, SNSApplicantDataBaseFieldView>> {

    /* renamed from: b  reason: collision with root package name */
    public final e f30992b;

    /* renamed from: c  reason: collision with root package name */
    public c f30993c;

    public static final class a extends Lambda implements l<String, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f30994a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FormItem f30995b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(i iVar, FormItem formItem) {
            super(1);
            this.f30994a = iVar;
            this.f30995b = formItem;
        }

        public final void a(String str) {
            c a11 = this.f30994a.a();
            if (a11 != null) {
                a11.c(this.f30995b, str);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((String) obj);
            return Unit.f56620a;
        }
    }

    public static final class b extends DiffUtil.Callback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List<FormItem> f30996a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List<FormItem> f30997b;

        public b(List<? extends FormItem> list, List<? extends FormItem> list2) {
            this.f30996a = list;
            this.f30997b = list2;
        }

        public boolean areContentsTheSame(int i11, int i12) {
            FormItem formItem = this.f30996a.get(i11);
            FormItem formItem2 = this.f30997b.get(i12);
            if (formItem.b() != null) {
                return x.b(com.sumsub.sns.internal.core.presentation.form.model.e.a(formItem, (CharSequence) null), com.sumsub.sns.internal.core.presentation.form.model.e.a(formItem2, (CharSequence) null));
            }
            return x.b(formItem, formItem2);
        }

        public boolean areItemsTheSame(int i11, int i12) {
            FormItem formItem = this.f30996a.get(i11);
            FormItem formItem2 = this.f30997b.get(i12);
            return x.b(formItem.d().p(), formItem2.d().p()) && x.b(formItem.e(), formItem2.e());
        }

        public int getNewListSize() {
            return this.f30997b.size();
        }

        public int getOldListSize() {
            return this.f30996a.size();
        }
    }

    public i(e eVar) {
        this.f30992b = eVar;
    }

    public final void a(c cVar) {
        this.f30993c = null;
        if (cVar != null) {
            this.f30993c = new c(cVar);
        }
    }

    public int getItemViewType(int i11) {
        return j.b((FormItem) a(i11));
    }

    public final c a() {
        c cVar = this.f30993c;
        if (cVar != null) {
            return cVar.a();
        }
        return null;
    }

    public DiffUtil.Callback a(List<? extends FormItem> list, List<? extends FormItem> list2) {
        return new b(list, list2);
    }

    /* renamed from: a */
    public k<FormItem, SNSApplicantDataBaseFieldView> onCreateViewHolder(ViewGroup viewGroup, int i11) {
        k<FormItem, SNSApplicantDataBaseFieldView> kVar;
        switch (i11) {
            case 0:
                kVar = new t(new SNSApplicantDataTitleView(viewGroup.getContext()));
                break;
            case 1:
                kVar = new r(new SNSApplicantDataSubtitleView(viewGroup.getContext()));
                break;
            case 2:
                kVar = new g(new SNSApplicantDataDescriptionView(viewGroup.getContext()));
                break;
            case 4:
                kVar = new o(new SNSApplicantDataSectionView(viewGroup.getContext(), (AttributeSet) null, 0, 0, 14, (r) null));
                break;
            case 5:
                kVar = new f(new SNSApplicantDataFieldView(viewGroup.getContext(), (AttributeSet) null, 0, 0, 14, (r) null), this.f30993c);
                break;
            case 6:
                kVar = new b(new SNSApplicantDataCalendarFieldView(viewGroup.getContext(), (AttributeSet) null, 0, 0, 14, (r) null), this.f30993c);
                break;
            case 7:
                kVar = new s(new SNSApplicantDataTextAreaFieldView(viewGroup.getContext(), (AttributeSet) null, 0, 0, 14, (r) null), this.f30993c);
                break;
            case 8:
                kVar = new a(new SNSApplicantDataBoolFieldView(viewGroup.getContext(), (AttributeSet) null, 0, 0, 14, (r) null), this.f30993c);
                break;
            case 9:
                kVar = new e(new SNSApplicantDataDateTimeFieldView(viewGroup.getContext(), (AttributeSet) null, 0, 0, 14, (r) null), this.f30993c);
                break;
            case 10:
                kVar = new n(new SNSApplicantDataPhoneFieldView(viewGroup.getContext(), (AttributeSet) null, 0, 0, 14, (r) null), this.f30993c);
                break;
            case 11:
                kVar = new d(new SNSApplicantDataSelectionCountryFieldView(viewGroup.getContext(), (AttributeSet) null, 0, 0, 14, (r) null), this.f30993c);
                break;
            case 12:
                kVar = new q(new SNSApplicantDataRadioGroupView(viewGroup.getContext(), (AttributeSet) null, 0, 0, 14, (r) null), this.f30993c);
                break;
            case 13:
                kVar = new p(new SNSApplicantDataSelectionFieldView(viewGroup.getContext(), (AttributeSet) null, 0, 6, (r) null), this.f30993c);
                break;
            case 14:
                kVar = new m(new SNSApplicantDataMutilselectFieldView(viewGroup.getContext(), (AttributeSet) null, 0, 0, 14, (r) null), this.f30993c);
                break;
            case 15:
                kVar = new h(new SNSApplicantDataFileFieldView(viewGroup.getContext(), (AttributeSet) null, 0, 0, 14, (r) null), this.f30993c);
                break;
            case 16:
                kVar = new l(new SNSApplicantDataFileFieldView(viewGroup.getContext(), (AttributeSet) null, 0, 0, 14, (r) null), this.f30993c);
                break;
            default:
                kVar = new f(new SNSApplicantDataFieldView(viewGroup.getContext(), (AttributeSet) null, 0, 0, 14, (r) null), this.f30993c);
                break;
        }
        kVar.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        return kVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0086, code lost:
        if (r1 != false) goto L_0x0088;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBindViewHolder(com.sumsub.sns.core.presentation.form.viewadapter.k<com.sumsub.sns.internal.core.presentation.form.model.FormItem, com.sumsub.sns.core.widget.applicantData.SNSApplicantDataBaseFieldView> r6, int r7) {
        /*
            r5 = this;
            com.sumsub.sns.core.presentation.form.viewadapter.c r0 = r5.f30993c
            r1 = 1
            if (r0 != 0) goto L_0x0006
            goto L_0x0009
        L_0x0006:
            r0.a((boolean) r1)
        L_0x0009:
            java.lang.Object r7 = r5.a((int) r7)
            if (r7 == 0) goto L_0x00aa
            com.sumsub.sns.internal.core.presentation.form.model.FormItem r7 = (com.sumsub.sns.internal.core.presentation.form.model.FormItem) r7
            int r0 = r5.getItemCount()
            r6.a(r7, (int) r0)
            com.sumsub.sns.core.widget.applicantData.SNSApplicantDataBaseFieldView r6 = r6.b()
            android.content.Context r0 = r6.getContext()
            com.sumsub.sns.internal.core.data.source.applicant.remote.k r2 = r7.d()
            java.lang.String r3 = r2.x()
            if (r3 == 0) goto L_0x003a
            android.text.Spanned r3 = com.sumsub.sns.internal.core.common.i.a((java.lang.CharSequence) r3, (android.content.Context) r0)
            if (r3 == 0) goto L_0x003a
            boolean r4 = r7.j()
            java.lang.CharSequence r3 = com.sumsub.sns.core.common.b.a((java.lang.CharSequence) r3, (android.content.Context) r0, (boolean) r4)
            if (r3 != 0) goto L_0x003c
        L_0x003a:
            java.lang.String r3 = ""
        L_0x003c:
            r6.setLabel(r3)
            java.lang.String r3 = r2.l()
            if (r3 == 0) goto L_0x004a
            android.text.Spanned r0 = com.sumsub.sns.internal.core.common.i.a((java.lang.CharSequence) r3, (android.content.Context) r0)
            goto L_0x004b
        L_0x004a:
            r0 = 0
        L_0x004b:
            r6.setExample(r0)
            boolean r0 = r7.h()
            r6.setEnabled(r0)
            java.lang.String r0 = r2.t()
            r6.setHint(r0)
            com.sumsub.sns.core.presentation.form.viewadapter.i$a r0 = new com.sumsub.sns.core.presentation.form.viewadapter.i$a
            r0.<init>(r5, r7)
            r6.setOnLinkClicked(r0)
            com.sumsub.sns.core.presentation.form.e r0 = r5.f30992b
            com.sumsub.sns.core.presentation.form.f.a(r6, r7, r0)
            java.lang.CharSequence r0 = r7.b()
            r6.setError(r0)
            boolean r0 = r7 instanceof com.sumsub.sns.internal.core.presentation.form.model.FormItem.p
            r2 = 0
            if (r0 == 0) goto L_0x0088
            r0 = r7
            com.sumsub.sns.internal.core.presentation.form.model.FormItem$p r0 = (com.sumsub.sns.internal.core.presentation.form.model.FormItem.p) r0
            java.util.List r0 = r0.r()
            if (r0 == 0) goto L_0x0086
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0085
            goto L_0x0086
        L_0x0085:
            r1 = r2
        L_0x0086:
            if (r1 == 0) goto L_0x00a1
        L_0x0088:
            com.sumsub.sns.internal.core.data.source.applicant.remote.k r7 = r7.d()
            java.lang.String r7 = r7.n()
            if (r7 == 0) goto L_0x00a1
            com.sumsub.sns.internal.core.data.model.p$e r0 = com.sumsub.sns.internal.core.data.model.p.Companion
            com.sumsub.sns.internal.core.data.model.p r7 = r0.a(r7)
            if (r7 == 0) goto L_0x00a1
            android.widget.EditText r6 = r6.getEditText()
            com.sumsub.sns.internal.core.presentation.util.a.a((com.sumsub.sns.internal.core.data.model.p) r7, (android.widget.EditText) r6)
        L_0x00a1:
            com.sumsub.sns.core.presentation.form.viewadapter.c r6 = r5.f30993c
            if (r6 != 0) goto L_0x00a6
            goto L_0x00a9
        L_0x00a6:
            r6.a((boolean) r2)
        L_0x00a9:
            return
        L_0x00aa:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "Required value was null."
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.presentation.form.viewadapter.i.onBindViewHolder(com.sumsub.sns.core.presentation.form.viewadapter.k, int):void");
    }

    /* renamed from: a */
    public void onViewRecycled(k<FormItem, SNSApplicantDataBaseFieldView> kVar) {
        super.onViewRecycled(kVar);
        if (kVar != null) {
            kVar.c();
        }
    }
}
