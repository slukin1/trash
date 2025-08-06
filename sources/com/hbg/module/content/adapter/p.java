package com.hbg.module.content.adapter;

import android.view.View;
import com.hbg.lib.network.hbg.core.bean.NewFlashInformation;

public final /* synthetic */ class p implements View.OnLongClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NewsAdapter f17924b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ NewFlashInformation f17925c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f17926d;

    public /* synthetic */ p(NewsAdapter newsAdapter, NewFlashInformation newFlashInformation, int i11) {
        this.f17924b = newsAdapter;
        this.f17925c = newFlashInformation;
        this.f17926d = i11;
    }

    public final boolean onLongClick(View view) {
        return NewsAdapter.q(this.f17924b, this.f17925c, this.f17926d, view);
    }
}
