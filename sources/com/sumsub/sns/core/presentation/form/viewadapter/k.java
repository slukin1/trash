package com.sumsub.sns.core.presentation.form.viewadapter;

import com.sumsub.sns.core.presentation.base.adapter.b;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataBaseFieldView;
import com.sumsub.sns.internal.core.presentation.form.model.FormItem;

public abstract class k<T extends FormItem, V extends SNSApplicantDataBaseFieldView> extends b<T> {

    /* renamed from: a  reason: collision with root package name */
    public final V f31015a;

    public k(V v11) {
        super(v11);
        this.f31015a = v11;
    }

    public abstract void a(V v11, T t11, int i11);

    public final V b() {
        return this.f31015a;
    }

    public void c() {
    }

    public final void a(T t11, int i11) {
        a(this.f31015a, t11, i11);
    }
}
