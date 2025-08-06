package com.hbg.module.content.ui.activity;

import android.view.View;
import com.hbg.lib.network.hbg.core.bean.NewFlashInformation;

public final /* synthetic */ class h implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NewFlashInformation f18336b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ NewsDetailActivity f18337c;

    public /* synthetic */ h(NewFlashInformation newFlashInformation, NewsDetailActivity newsDetailActivity) {
        this.f18336b = newFlashInformation;
        this.f18337c = newsDetailActivity;
    }

    public final void onClick(View view) {
        NewsDetailActivity$getNewsDetail$1.invoke$lambda$0(this.f18336b, this.f18337c, view);
    }
}
