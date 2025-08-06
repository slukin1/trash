package com.huochat.community.util;

import android.view.View;
import android.widget.PopupWindow;
import com.huochat.community.util.MomentUtils;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f38704b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PopupWindow f38705c;

    public /* synthetic */ a(String str, PopupWindow popupWindow) {
        this.f38704b = str;
        this.f38705c = popupWindow;
    }

    public final void onClick(View view) {
        MomentUtils.Companion.showPopupWindow$lambda$1(this.f38704b, this.f38705c, view);
    }
}
