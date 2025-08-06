package com.huochat.community.widget;

import android.widget.PopupWindow;
import com.cpiz.android.bubbleview.b;

public final /* synthetic */ class a implements PopupWindow.OnDismissListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f38708b;

    public /* synthetic */ a(b bVar) {
        this.f38708b = bVar;
    }

    public final void onDismiss() {
        CommunityBubbleHintHelper.showCommunityTips$lambda$1$lambda$0(this.f38708b);
    }
}
