package com.huobi.otc.ui;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.module.otc.OtcModuleConfig;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.huobi.otc.widget.DragRelativeLayout;
import com.huobi.otc.widget.OtcFloatView;
import u6.g;

public abstract class BaseDragActivity<P extends ActivityPresenter<V>, V extends g> extends BaseActivity<P, V> {

    /* renamed from: b  reason: collision with root package name */
    public OtcFloatView f79227b;

    /* renamed from: c  reason: collision with root package name */
    public DragRelativeLayout f79228c;

    public class a implements OtcFloatView.f {
        public a() {
        }

        public void onClick(int i11) {
            if (!OtcModuleConfig.a().a()) {
                OtcModuleConfig.a().l(BaseDragActivity.this, (Intent) null, (Intent) null);
            } else if (i11 == 3) {
                OtcModuleConfig.b().h(BaseDragActivity.this, true);
            } else {
                BaseDragActivity.this.Og();
            }
        }
    }

    public void Og() {
        OtcFAQDialogActivity.gg(this, Xf(), R0());
    }

    public abstract String R0();

    public abstract String Xf();

    public final void Yf() {
        boolean b11 = ConfigPreferences.b("otc_config", "otc_faq_float_close");
        this.f79228c = (DragRelativeLayout) this.viewFinder.b(R$id.rl_drag);
        OtcFloatView otcFloatView = (OtcFloatView) this.viewFinder.b(R$id.fv_float);
        this.f79227b = otcFloatView;
        this.f79228c.setOnFloatDragListener(otcFloatView);
        if (b11) {
            this.f79227b.p();
            this.f79227b.setVisibility(8);
        }
        this.f79227b.setOnFloatViewClickListener(new a());
    }

    public boolean Zf() {
        return true;
    }

    public void fg(boolean z11) {
        this.f79227b.setIsClickShowTv(z11);
    }

    public void gg(boolean z11) {
        if (ConfigPreferences.b("otc_config", "otc_faq_float_close") || !z11) {
            this.f79227b.setVisibility(8);
            this.f79227b.p();
            return;
        }
        this.f79227b.setVisibility(0);
    }

    public void initView() {
        Yf();
    }

    public void onPause() {
        super.onPause();
        this.f79227b.p();
    }

    public void onResume() {
        super.onResume();
        if (Zf()) {
            this.f79227b.q();
        }
    }

    public void setContentView(int i11) {
        LayoutInflater from = LayoutInflater.from(this);
        DragRelativeLayout dragRelativeLayout = (DragRelativeLayout) from.inflate(R$layout.activity_otc_drag_base, (ViewGroup) null, false);
        dragRelativeLayout.addView(from.inflate(i11, (ViewGroup) null, false), 0, new RelativeLayout.LayoutParams(-1, -1));
        if (canFullScreen()) {
            ViewGroup parentLayout = getParentLayout();
            parentLayout.addView(dragRelativeLayout);
            setContentViewNotOverride(parentLayout);
            return;
        }
        setContentViewNotOverride(dragRelativeLayout);
    }
}
