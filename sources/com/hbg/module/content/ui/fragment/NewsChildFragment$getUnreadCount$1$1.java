package com.hbg.module.content.ui.fragment;

import com.facebook.login.widget.ToolTipPopup;
import com.hbg.lib.network.hbg.core.bean.FastNewsUnread;
import com.hbg.module.content.R$string;
import com.huobi.view.roundview.RoundTextView;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class NewsChildFragment$getUnreadCount$1$1 extends Lambda implements l<FastNewsUnread, Unit> {
    public final /* synthetic */ NewsChildFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewsChildFragment$getUnreadCount$1$1(NewsChildFragment newsChildFragment) {
        super(1);
        this.this$0 = newsChildFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((FastNewsUnread) obj);
        return Unit.f56620a;
    }

    public final void invoke(FastNewsUnread fastNewsUnread) {
        this.this$0.sh();
        if ((fastNewsUnread != null ? fastNewsUnread.getNum() : 0) > 0) {
            NewsChildFragment.Zh(this.this$0).G.setVisibility(0);
            RoundTextView roundTextView = NewsChildFragment.Zh(this.this$0).G;
            NewsChildFragment newsChildFragment = this.this$0;
            int i11 = R$string.n_content_append_new_message_count;
            Object[] objArr = new Object[1];
            objArr[0] = String.valueOf(fastNewsUnread != null ? Integer.valueOf(fastNewsUnread.getNum()) : null);
            roundTextView.setText(newsChildFragment.getString(i11, objArr));
        }
        this.this$0.F.sendEmptyMessageDelayed(102, ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME);
    }
}
