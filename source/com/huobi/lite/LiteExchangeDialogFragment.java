package com.huobi.lite;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.widgets.ClipScaleLayout;
import com.hbg.lib.widgets.LoadingView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.huobi.litere.main.ui.LiteReMainActivity;
import com.huobi.main.ui.HuobiMainActivity;
import com.huobi.view.roundimg.RoundedDrawable;
import fn.b;
import i6.i;
import i6.r;
import pro.huobi.R;

public class LiteExchangeDialogFragment extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public View f75354b;

    /* renamed from: c  reason: collision with root package name */
    public View f75355c;

    /* renamed from: d  reason: collision with root package name */
    public ClipScaleLayout f75356d;

    /* renamed from: e  reason: collision with root package name */
    public ClipScaleLayout f75357e;

    /* renamed from: f  reason: collision with root package name */
    public LoadingView f75358f;

    /* renamed from: g  reason: collision with root package name */
    public LoadingView f75359g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f75360h;

    /* renamed from: i  reason: collision with root package name */
    public Intent f75361i;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b() {
            LiteExchangeDialogFragment.this.wh();
        }

        public void onAnimationEnd(Animator animator) {
            LiteExchangeDialogFragment.this.f75358f.c();
            LiteExchangeDialogFragment.this.f75359g.c();
            i.b().g(new b(this), 700);
        }
    }

    public static void Ah(FragmentActivity fragmentActivity, boolean z11) {
        if (fragmentActivity != null) {
            LiteExchangeDialogFragment liteExchangeDialogFragment = new LiteExchangeDialogFragment();
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            liteExchangeDialogFragment.yh(supportFragmentManager, (Intent) null, "LiteExchange" + z11, z11);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void xh(float f11) {
        this.f75357e.setRate(f11 - 0.05f);
    }

    public static void zh(FragmentActivity fragmentActivity, Intent intent, boolean z11) {
        if (fragmentActivity != null) {
            LiteExchangeDialogFragment liteExchangeDialogFragment = new LiteExchangeDialogFragment();
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            liteExchangeDialogFragment.yh(supportFragmentManager, intent, "LiteExchange" + z11, z11);
        }
    }

    public void addEvent(r rVar) {
    }

    public void afterInit() {
        if (this.f75360h) {
            this.f75354b.setBackgroundColor(getResources().getColor(R.color.color_account_exchange_lite_bg));
            this.f75355c.setBackgroundColor(getResources().getColor(R.color.color_account_exchange_lite_bg));
            if (AppLanguageHelper.getInstance().isChineseLanguage()) {
                this.f75359g.setLottieAnimationRes(R.raw.huobi_global_lite_cn);
            } else {
                this.f75359g.setLottieAnimationRes(R.raw.huobi_global_lite_en);
            }
            this.f75358f.setLottieAnimationRes(R.raw.switch_lite_new);
        } else {
            this.f75354b.setBackgroundColor(RoundedDrawable.DEFAULT_BORDER_COLOR);
            this.f75355c.setBackgroundColor(RoundedDrawable.DEFAULT_BORDER_COLOR);
            if (AppLanguageHelper.getInstance().isChineseLanguage()) {
                this.f75359g.setLottieAnimationRes(R.raw.huobi_global_pro_cn);
            } else {
                this.f75359g.setLottieAnimationRes(R.raw.huobi_global_pro_en);
            }
            this.f75358f.setLottieAnimationRes(R.raw.switch_global);
        }
        this.f75356d.setCallback(new fn.a(this));
        this.f75356d.c(new a());
    }

    public int getContentViewResId() {
        return R.layout.activity_lite_exchange;
    }

    public int getGravity() {
        return 17;
    }

    public void initView(r rVar) {
        this.f75354b = rVar.b(R.id.id_lite_exchange_bg);
        this.f75356d = (ClipScaleLayout) rVar.b(R.id.id_lite_exchange_parent);
        this.f75357e = (ClipScaleLayout) rVar.b(R.id.id_lite_exchange_layout);
        this.f75355c = rVar.b(R.id.id_lite_exchange_alpha_view);
        this.f75358f = (LoadingView) rVar.b(R.id.id_lite_exchange_lotti_bg);
        this.f75359g = (LoadingView) rVar.b(R.id.id_lite_exchange_lotti_tv);
    }

    public boolean isFullScreen() {
        return true;
    }

    public boolean isTransparent() {
        return true;
    }

    public final void wh() {
        if (getActivity() != null && !getActivity().isFinishing()) {
            if (this.f75360h) {
                SP.y("SP_KEY_PRO_NIGHT_MODE", NightHelper.e().g());
                if (NightHelper.e().g()) {
                    NightHelper.e().c(false);
                }
                Intent intent = new Intent(getActivity(), LiteReMainActivity.class);
                intent.addFlags(32768);
                startActivity(intent);
            } else {
                if (this.f75361i == null) {
                    this.f75361i = new Intent(getContext(), HuobiMainActivity.class);
                }
                if (SP.l("SP_KEY_PRO_NIGHT_MODE", false)) {
                    NightHelper.e().c(true);
                }
                this.f75361i.addFlags(32768);
                getActivity().startActivity(this.f75361i);
            }
            getActivity().overridePendingTransition(R.anim.alpha_in_300, R.anim.alpha_out_300);
            getActivity().finish();
        }
    }

    public void yh(FragmentManager fragmentManager, Intent intent, String str, boolean z11) {
        this.f75360h = z11;
        if (intent != null) {
            this.f75361i = intent;
        }
        show(fragmentManager, str);
    }
}
