package com.huobi.finance.ui;

import android.view.View;
import com.huobi.finance.bean.ExamInfo;

public final /* synthetic */ class n8 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UnifyRiskActivity f47251b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ExamInfo f47252c;

    public /* synthetic */ n8(UnifyRiskActivity unifyRiskActivity, ExamInfo examInfo) {
        this.f47251b = unifyRiskActivity;
        this.f47252c = examInfo;
    }

    public final void onClick(View view) {
        this.f47251b.yh(this.f47252c, view);
    }
}
