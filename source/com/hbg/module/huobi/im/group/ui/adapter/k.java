package com.hbg.module.huobi.im.group.ui.adapter;

import com.hbg.lib.widgets.expandable.ExpandableTextView;
import com.hbg.lib.widgets.expandable.StatusType;
import com.hbg.module.huobi.im.group.bean.GroupNoticeItemEntity;

public final /* synthetic */ class k implements ExpandableTextView.g {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ m f20245a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GroupNoticeItemEntity f20246b;

    public /* synthetic */ k(m mVar, GroupNoticeItemEntity groupNoticeItemEntity) {
        this.f20245a = mVar;
        this.f20246b = groupNoticeItemEntity;
    }

    public final void a(StatusType statusType) {
        m.j(this.f20245a, this.f20246b, statusType);
    }
}
