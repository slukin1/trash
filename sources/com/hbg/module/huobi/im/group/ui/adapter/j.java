package com.hbg.module.huobi.im.group.ui.adapter;

import android.view.View;
import com.hbg.module.huobi.im.group.bean.GroupNoticeItemEntity;

public final /* synthetic */ class j implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ m f20243b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ GroupNoticeItemEntity f20244c;

    public /* synthetic */ j(m mVar, GroupNoticeItemEntity groupNoticeItemEntity) {
        this.f20243b = mVar;
        this.f20244c = groupNoticeItemEntity;
    }

    public final void onClick(View view) {
        m.i(this.f20243b, this.f20244c, view);
    }
}
