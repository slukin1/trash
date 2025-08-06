package com.hbg.module.huobi.im.group.ui;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import com.hbg.lib.network.hbg.core.bean.GroupInfoData;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.huobi.im.R$string;
import d10.p;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class GroupChatInfoActivity$joinFuncChange$2 extends Lambda implements p<Throwable, APIStatusErrorException, Unit> {
    public final /* synthetic */ GroupChatInfoActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GroupChatInfoActivity$joinFuncChange$2(GroupChatInfoActivity groupChatInfoActivity) {
        super(2);
        this.this$0 = groupChatInfoActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Throwable) obj, (APIStatusErrorException) obj2);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2, APIStatusErrorException aPIStatusErrorException) {
        GroupInfoData wh2 = this.this$0.F;
        SwitchCompat switchCompat = null;
        Integer valueOf = wh2 != null ? Integer.valueOf(wh2.getType()) : null;
        if (valueOf != null && valueOf.intValue() == 2) {
            View Ih = this.this$0.f19911y;
            if (Ih == null) {
                Ih = null;
            }
            Ih.setVisibility(0);
            LinearLayout xh2 = this.this$0.f19912z;
            if (xh2 == null) {
                xh2 = null;
            }
            xh2.setVisibility(0);
            TextView Gh = this.this$0.A;
            if (Gh == null) {
                Gh = null;
            }
            Gh.setText(this.this$0.getResources().getString(R$string.n_live_group_admin_verify_join));
            RelativeLayout zh2 = this.this$0.B;
            if (zh2 == null) {
                zh2 = null;
            }
            zh2.setVisibility(0);
            SwitchCompat Dh = this.this$0.f19910x;
            if (Dh != null) {
                switchCompat = Dh;
            }
            switchCompat.setChecked(true);
        } else if (valueOf != null && valueOf.intValue() == 1) {
            View Ih2 = this.this$0.f19911y;
            if (Ih2 == null) {
                Ih2 = null;
            }
            Ih2.setVisibility(8);
            LinearLayout xh3 = this.this$0.f19912z;
            if (xh3 == null) {
                xh3 = null;
            }
            xh3.setVisibility(8);
            RelativeLayout zh3 = this.this$0.B;
            if (zh3 == null) {
                zh3 = null;
            }
            zh3.setVisibility(8);
            SwitchCompat Dh2 = this.this$0.f19910x;
            if (Dh2 != null) {
                switchCompat = Dh2;
            }
            switchCompat.setChecked(false);
        } else if (valueOf != null && valueOf.intValue() == 3) {
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
            if (zh4 == null) {
                zh4 = null;
            }
            zh4.setVisibility(8);
            SwitchCompat Dh3 = this.this$0.f19910x;
            if (Dh3 != null) {
                switchCompat = Dh3;
            }
            switchCompat.setChecked(true);
        }
        if (aPIStatusErrorException != null) {
            HuobiToastUtil.i(aPIStatusErrorException.getErrMsg());
        }
    }
}
