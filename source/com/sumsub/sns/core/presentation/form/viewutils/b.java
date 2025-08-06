package com.sumsub.sns.core.presentation.form.viewutils;

import android.content.Context;
import android.util.AttributeSet;
import com.sumsub.sns.core.data.listener.SNSCountryPicker;
import com.sumsub.sns.core.presentation.form.c;
import com.sumsub.sns.core.presentation.form.f;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataBaseFieldView;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataSelectionCountryFieldView;
import com.sumsub.sns.internal.core.presentation.form.model.FormItem;
import d10.l;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.r;

public final class b {

    public static final class a extends Lambda implements l<SNSCountryPicker.CountryItem, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f31054a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FormItem.c f31055b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SNSApplicantDataSelectionCountryFieldView f31056c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(c cVar, FormItem.c cVar2, SNSApplicantDataSelectionCountryFieldView sNSApplicantDataSelectionCountryFieldView) {
            super(1);
            this.f31054a = cVar;
            this.f31055b = cVar2;
            this.f31056c = sNSApplicantDataSelectionCountryFieldView;
        }

        public final void a(SNSCountryPicker.CountryItem countryItem) {
            c cVar = this.f31054a;
            if (cVar != null) {
                FormItem.c cVar2 = this.f31055b;
                cVar.b(cVar2, f.b(this.f31056c, cVar2));
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((SNSCountryPicker.CountryItem) obj);
            return Unit.f56620a;
        }
    }

    public static final SNSApplicantDataBaseFieldView a(FormItem.c cVar, Context context, c cVar2) {
        SNSApplicantDataSelectionCountryFieldView sNSApplicantDataSelectionCountryFieldView = new SNSApplicantDataSelectionCountryFieldView(context, (AttributeSet) null, 0, 0, 14, (r) null);
        sNSApplicantDataSelectionCountryFieldView.setItems(SNSCountryPicker.CountryItem.Companion.fromMap(cVar.r()));
        sNSApplicantDataSelectionCountryFieldView.setOnCountrySelectedCallback(new a(cVar2, cVar, sNSApplicantDataSelectionCountryFieldView));
        return sNSApplicantDataSelectionCountryFieldView;
    }

    public static final void a(SNSApplicantDataSelectionCountryFieldView sNSApplicantDataSelectionCountryFieldView, FormItem.c cVar, String str) {
        Map<String, String> r11 = cVar.r();
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        String str3 = r11.get(str);
        if (str3 != null) {
            str2 = str3;
        }
        sNSApplicantDataSelectionCountryFieldView.setValue(str2);
    }
}
