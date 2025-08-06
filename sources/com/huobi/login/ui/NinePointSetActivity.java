package com.huobi.login.ui;

import android.os.Handler;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.widgets.GesturePwdLayout;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.login.presenter.NinePointSetPresenter;
import java.util.List;
import pn.f;
import pro.huobi.R;

public class NinePointSetActivity extends BaseActivity<NinePointSetPresenter, NinePointSetPresenter.a> implements NinePointSetPresenter.a, GesturePwdLayout.a {

    /* renamed from: b  reason: collision with root package name */
    public GesturePwdLayout f75571b;

    /* renamed from: c  reason: collision with root package name */
    public Toolbar f75572c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f75573d;

    /* access modifiers changed from: private */
    public /* synthetic */ void gg() {
        if (this.f75571b != null && !isFinishing()) {
            this.f75571b.l();
        }
    }

    public void P2() {
        this.f75571b.l();
        this.f75573d.setText(getString(R.string.n_set_gesture_login_draw_again));
    }

    /* renamed from: Yf */
    public NinePointSetPresenter createPresenter() {
        return new NinePointSetPresenter();
    }

    public final void Zf() {
        new Handler().postDelayed(new f(this), 1000);
    }

    public void addEvent() {
    }

    public void doFinish() {
        ((NinePointSetPresenter) getPresenter()).S();
        super.doFinish();
    }

    /* renamed from: fg */
    public NinePointSetPresenter.a getUI() {
        return this;
    }

    public int getContentView() {
        return R.layout.activity_ninepoint_set;
    }

    public void initView() {
        this.f75571b = (GesturePwdLayout) findViewById(R.id.ninepoint_setview);
        this.f75573d = (TextView) findViewById(R.id.gesture_top_tips);
        this.f75572c = (Toolbar) findViewById(R.id.toolbar);
        this.f75571b.setCallback(this);
        setToolBar(this.f75572c, "", true);
    }

    public void onBackPressed() {
        ((NinePointSetPresenter) getPresenter()).R();
    }

    public void y7(List<Integer> list) {
        if (list.size() < 6) {
            this.f75571b.setError(true);
            Zf();
            HuobiToastUtil.m(getString(R.string.draw_gesture_need_six_dot));
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        for (Integer intValue : list) {
            sb2.append(String.valueOf(intValue.intValue() + 518));
        }
        ((NinePointSetPresenter) getPresenter()).W(sb2.toString());
    }

    public void z2() {
        this.f75571b.setError(true);
        Zf();
        HuobiToastUtil.m(getString(R.string.draw_gesture_not_same));
    }
}
