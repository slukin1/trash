package com.huobi.swap.ui;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import com.hbg.lib.common.utils.ViewUtil;
import com.huobi.contract.countdown.ContractTopTipsLayout;
import com.huobi.contract.entity.FuturesActivityInfo;
import com.huobi.webview2.ui.ContractWebActivity;
import java.util.Locale;
import java.util.Set;
import pro.huobi.R;

public class SwapTopTipsLayout extends ContractTopTipsLayout {
    public SwapTopTipsLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void c(int i11) {
        if (i11 == 1 || i11 == 2) {
            this.f43049g.setStatus(3);
            FuturesActivityInfo futuresActivityInfo = this.f43049g;
            futuresActivityInfo.setCurrentTime(futuresActivityInfo.getStartTime() + 1);
        } else {
            this.f43049g.setStatus(4);
            FuturesActivityInfo futuresActivityInfo2 = this.f43049g;
            futuresActivityInfo2.setCurrentTime(futuresActivityInfo2.getEndTime() + 1);
        }
        j(this.f43049g, this.f43050h);
        ContractTopTipsLayout.a aVar = this.f43051i;
        if (aVar != null) {
            aVar.b();
        }
    }

    public boolean f() {
        boolean z11;
        String str = this.f43050h;
        if (str != null) {
            Set set = ContractTopTipsLayout.f43043j.get(str);
            z11 = set != null ? set.contains(String.valueOf(this.f43049g.getStatus())) : false;
        } else {
            z11 = true;
        }
        FuturesActivityInfo futuresActivityInfo = this.f43049g;
        if (futuresActivityInfo == null || futuresActivityInfo.getStatus() == 4 || z11) {
            return true;
        }
        return false;
    }

    public void i() {
        if (this.f43049g != null) {
            ContractWebActivity.Th((Activity) getContext(), this.f43049g.getUrl(), 2);
        }
    }

    public long l() {
        long j11;
        long j12;
        int status = this.f43049g.getStatus();
        if (status == 1 || status == 2) {
            ViewUtil.m(this.f43044b, true);
            ViewUtil.m(this.f43045c, false);
            this.f43044b.setText(String.format(Locale.US, getResources().getString(R.string.n_swap_trade_contest_tips_title), new Object[]{this.f43049g.getActivityId(), this.f43049g.getTitle()}));
            ViewUtil.m(this.f43048f, true);
            k(true);
            j12 = this.f43049g.getStartTime();
            j11 = this.f43049g.getCurrentTime();
        } else {
            ViewUtil.m(this.f43044b, false);
            ViewUtil.m(this.f43045c, true);
            this.f43045c.setText(String.format(Locale.US, getResources().getString(R.string.n_swap_trade_contest_tips_title2), new Object[]{this.f43049g.getActivityId(), this.f43049g.getTitle()}));
            ViewUtil.m(this.f43048f, false);
            k(false);
            j12 = this.f43049g.getEndTime();
            j11 = this.f43049g.getCurrentTime();
        }
        return j12 - j11;
    }

    public SwapTopTipsLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
