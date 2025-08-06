package rp;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.PopupWindow;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import com.blankj.utilcode.util.u;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.module.otc.OtcModuleConfig;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.huobi.otc.enums.OtcTradeAreaEnum;
import com.huobi.view.BasePopupWindow;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import jp.l;
import rx.Observable;
import uf.c;

public class g extends BasePopupWindow implements BasePopupWindow.PopupWindowListener, BasePopupWindow.PopupWindowBeforeListener {

    /* renamed from: b  reason: collision with root package name */
    public View f84724b;

    /* renamed from: c  reason: collision with root package name */
    public View f84725c;

    /* renamed from: d  reason: collision with root package name */
    public View f84726d;

    /* renamed from: e  reason: collision with root package name */
    public View f84727e;

    /* renamed from: f  reason: collision with root package name */
    public View f84728f;

    /* renamed from: g  reason: collision with root package name */
    public View f84729g;

    /* renamed from: h  reason: collision with root package name */
    public View f84730h;

    /* renamed from: i  reason: collision with root package name */
    public b f84731i;

    /* renamed from: j  reason: collision with root package name */
    public View f84732j;

    public class a implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PopupWindow f84733a;

        public a(PopupWindow popupWindow) {
            this.f84733a = popupWindow;
        }

        public void onAnimationEnd(Animation animation) {
            PopupWindow popupWindow = this.f84733a;
            if (popupWindow != null) {
                popupWindow.dismiss();
            }
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    public interface b {
        void a(OtcTradeAreaEnum otcTradeAreaEnum);

        void b();
    }

    public g(Context context) {
        super(context);
        h(context);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i(Void voidR) {
        dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j(Void voidR) {
        dismiss();
        b bVar = this.f84731i;
        if (bVar != null) {
            bVar.a(OtcTradeAreaEnum.FAST_AREA);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k(Void voidR) {
        dismiss();
        b bVar = this.f84731i;
        if (bVar != null) {
            bVar.a(OtcTradeAreaEnum.FREE_AREA);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l(Void voidR) {
        dismiss();
        b bVar = this.f84731i;
        if (bVar != null) {
            bVar.a(OtcTradeAreaEnum.DEPOSIT_AREA);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m(Void voidR) {
        OtcModuleConfig.b().u(getContext(), (String) null, (String) null);
        dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n(Void voidR) {
        dismiss();
        HBBaseWebActivity.showWebView(getContext(), l.p() + "fiat-crypto/otcDesk/index", (String) null, (String) null, true);
        HashMap hashMap = new HashMap();
        hashMap.put("otc_step", "otcdeskNavi_app_click");
        hashMap.put("uid", OtcModuleConfig.a().getUid());
        c.b().h("otc_otcdesk", hashMap);
    }

    public void dismiss() {
        super.dismiss();
        b bVar = this.f84731i;
        if (bVar != null) {
            bVar.b();
        }
    }

    public final void g() {
        Observable<Void> a11 = dw.a.a(this.f84729g);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        a11.throttleFirst(300, timeUnit).subscribe(new e(this));
        dw.a.a(this.f84724b).throttleFirst(300, timeUnit).subscribe(new f(this));
        dw.a.a(this.f84725c).throttleFirst(300, timeUnit).subscribe(new c(this));
        dw.a.a(this.f84726d).throttleFirst(300, timeUnit).subscribe(new a(this));
        dw.a.a(this.f84727e).throttleFirst(300, timeUnit).subscribe(new b(this));
        dw.a.a(this.f84732j).throttleFirst(300, timeUnit).subscribe(new d(this));
    }

    public final void h(Context context) {
        setWidth(-1);
        setOutsideTouchable(true);
        setTouchable(true);
        View inflate = LayoutInflater.from(context).inflate(R$layout.otc_main_header_pop_layout, (ViewGroup) null);
        setContentView(inflate);
        this.f84724b = inflate.findViewById(R$id.id_quick_area_container);
        this.f84725c = inflate.findViewById(R$id.id_p2p_area_container);
        this.f84726d = inflate.findViewById(R$id.id_deposit_area_container);
        this.f84727e = inflate.findViewById(R$id.id_exchange_container);
        this.f84730h = inflate.findViewById(R$id.id_content_list_view);
        this.f84728f = inflate.findViewById(R$id.id_root_view);
        this.f84729g = inflate.findViewById(R$id.id_bg_view);
        this.f84732j = inflate.findViewById(R$id.id_desk_area_container);
        setAnimationStyle(0);
        setPopupWindowListener(this);
        g();
    }

    public void o(b bVar) {
        this.f84731i = bVar;
    }

    public void popupWindowBeforeDismiss(PopupWindow popupWindow) {
        setPopupWindowBeforeListener((BasePopupWindow.PopupWindowBeforeListener) null);
        View view = this.f84729g;
        if (view != null && this.f84730h != null) {
            ObjectAnimator.ofFloat(view, "alpha", new float[]{0.5f, 0.0f}).setDuration(240).start();
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
            translateAnimation.setDuration(240);
            translateAnimation.setInterpolator(new FastOutLinearInInterpolator());
            translateAnimation.setAnimationListener(new a(popupWindow));
            this.f84730h.startAnimation(translateAnimation);
        }
    }

    public void popupWindowDismiss() {
    }

    public void popupWindowShow() {
        if (this.f84729g != null) {
            setPopupWindowBeforeListener(this);
            ObjectAnimator.ofFloat(this.f84729g, "alpha", new float[]{0.0f, 0.5f}).setDuration(270).start();
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
            translateAnimation.setDuration(270);
            translateAnimation.setInterpolator(new LinearOutSlowInInterpolator());
            this.f84730h.startAnimation(translateAnimation);
        }
    }

    public void showAsDropDown(View view) {
        try {
            setHeight(u.a() - view.getMeasuredHeight());
        } catch (Exception e11) {
            e11.printStackTrace();
            setHeight(-2);
        }
        super.showAsDropDown(view);
    }
}
