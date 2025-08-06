package com.hbg.module.huobi.im.group.ui;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.hbg.lib.network.hbg.core.bean.GroupInfoData;
import com.hbg.module.huobi.im.R$string;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class GroupChatInfoActivity$joinFuncChange$1 extends Lambda implements l<String, Unit> {
    public final /* synthetic */ int $type;
    public final /* synthetic */ GroupChatInfoActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GroupChatInfoActivity$joinFuncChange$1(GroupChatInfoActivity groupChatInfoActivity, int i11) {
        super(1);
        this.this$0 = groupChatInfoActivity;
        this.$type = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.f56620a;
    }

    public final void invoke(String str) {
        GroupInfoData wh2 = this.this$0.F;
        if (wh2 != null) {
            wh2.setType(this.$type);
        }
        int i11 = this.$type;
        RelativeLayout relativeLayout = null;
        if (i11 == 1) {
            View Ih = this.this$0.f19911y;
            if (Ih == null) {
                Ih = null;
            }
            Ih.setVisibility(8);
            LinearLayout xh2 = this.this$0.f19912z;
            if (xh2 == null) {
                xh2 = null;
            }
            xh2.setVisibility(8);
            RelativeLayout zh2 = this.this$0.B;
            if (zh2 != null) {
                relativeLayout = zh2;
            }
            relativeLayout.setVisibility(8);
        } else if (i11 == 2) {
            View Ih2 = this.this$0.f19911y;
            if (Ih2 == null) {
                Ih2 = null;
            }
            Ih2.setVisibility(0);
            LinearLayout xh3 = this.this$0.f19912z;
            if (xh3 == null) {
                xh3 = null;
            }
            xh3.setVisibility(0);
            TextView Gh = this.this$0.A;
            if (Gh == null) {
                Gh = null;
            }
            Gh.setText(this.this$0.getResources().getString(R$string.n_live_group_admin_verify_join));
            RelativeLayout zh3 = this.this$0.B;
            if (zh3 != null) {
                relativeLayout = zh3;
            }
            relativeLayout.setVisibility(0);
        } else if (i11 == 3) {
            View Ih3 = this.this$0.f19911y;
            if (Ih3 == null) {
                Ih3 = null;
            }
            Ih3.setVisibility(0);
            LinearLayout xh4 = this.this$0.f19912z;
            if (xh4 == null) {
                xh4 = null;
            }
            xh4.setVisibility(0);
            TextView Gh2 = this.this$0.A;
            if (Gh2 == null) {
                Gh2 = null;
            }
            Gh2.setText(this.this$0.getResources().getString(R$string.n_live_group_pay_join));
            RelativeLayout zh4 = this.this$0.B;
            if (zh4 != null) {
                relativeLayout = zh4;
            }
            relativeLayout.setVisibility(8);
        }
    }
}
