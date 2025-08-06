package com.huochat.community.util;

import android.view.View;
import android.widget.PopupWindow;
import com.huochat.community.util.MomentUtils;

public final /* synthetic */ class b implements PopupWindow.OnDismissListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f38706b;

    public /* synthetic */ b(View view) {
        this.f38706b = view;
    }

    public final void onDismiss() {
        MomentUtils.Companion.showPopupWindow$lambda$0(this.f38706b);
    }
}
