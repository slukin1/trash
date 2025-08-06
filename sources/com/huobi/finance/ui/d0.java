package com.huobi.finance.ui;

import android.view.View;
import android.widget.ExpandableListView;

public final /* synthetic */ class d0 implements ExpandableListView.OnGroupClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AccountChooseActivity f47082a;

    public /* synthetic */ d0(AccountChooseActivity accountChooseActivity) {
        this.f47082a = accountChooseActivity;
    }

    public final boolean onGroupClick(ExpandableListView expandableListView, View view, int i11, long j11) {
        return this.f47082a.Lh(expandableListView, view, i11, j11);
    }
}
