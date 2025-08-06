package dp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.network.otc.core.bean.OtcActionBean;
import com.hbg.lib.network.otc.core.bean.OtcFAQBean;
import com.hbg.module.otc.OtcModuleConfig;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.huobi.otc.persenter.OtcFAQPresenter;
import com.huobi.otc.ui.OtcFAQActivity;
import com.huobi.otc.widget.FAQGestureFrameLayout;
import com.huobi.view.FontIconTextView;
import com.huochat.community.network.domain.DomainTool;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.functions.Action1;

public class p extends k {

    /* renamed from: d  reason: collision with root package name */
    public h f83926d;

    /* renamed from: e  reason: collision with root package name */
    public FontIconTextView f83927e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f83928f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f83929g;

    /* renamed from: h  reason: collision with root package name */
    public ScrollView f83930h;

    /* renamed from: i  reason: collision with root package name */
    public View f83931i;

    /* renamed from: j  reason: collision with root package name */
    public View f83932j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f83933k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f83934l;

    /* renamed from: m  reason: collision with root package name */
    public TextView f83935m;

    /* renamed from: n  reason: collision with root package name */
    public OtcFAQBean f83936n;

    /* renamed from: o  reason: collision with root package name */
    public View f83937o;

    /* renamed from: p  reason: collision with root package name */
    public FAQGestureFrameLayout f83938p;

    /* renamed from: q  reason: collision with root package name */
    public OtcFAQActivity f83939q;

    /* renamed from: r  reason: collision with root package name */
    public Runnable f83940r = new a();

    /* renamed from: s  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f83941s;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            p.this.dismiss();
        }
    }

    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public b() {
        }

        public void onGlobalLayout() {
            int measuredHeight = p.this.f83938p.getMeasuredHeight();
            int measuredHeight2 = p.this.f83937o.getMeasuredHeight();
            int measuredHeight3 = p.this.f83932j.getMeasuredHeight();
            if (measuredHeight3 < measuredHeight) {
                ViewGroup.LayoutParams layoutParams = p.this.f83938p.getLayoutParams();
                layoutParams.height = measuredHeight3;
                p.this.f83938p.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = p.this.f83937o.getLayoutParams();
                layoutParams2.height = measuredHeight2 + (measuredHeight - measuredHeight3);
                p.this.f83937o.setLayoutParams(layoutParams2);
            }
            p.this.f83931i.getViewTreeObserver().removeOnGlobalLayoutListener(p.this.f83941s);
        }
    }

    public class c implements Action1<Void> {
        public c() {
        }

        /* renamed from: a */
        public void call(Void voidR) {
            p.this.dismiss();
        }
    }

    public class d implements Action1<Void> {
        public d() {
        }

        /* renamed from: a */
        public void call(Void voidR) {
            p.this.dismiss();
        }
    }

    public class e implements Action1<Void> {
        public e() {
        }

        /* renamed from: a */
        public void call(Void voidR) {
            if (p.this.f83936n.getLike() != 1) {
                p.this.f83936n.setLike(1);
                p.this.f83934l.setSelected(true);
                p.this.f83935m.setSelected(false);
                if (p.this.f83926d != null) {
                    p.this.f83926d.P3(p.this.f83936n, true);
                }
                HashMap hashMap = new HashMap();
                hashMap.put("faq_code", p.this.f83936n.getCode());
                hashMap.put("useful", Boolean.TRUE);
                uf.c.b().i("click_faq_useful", hashMap);
            }
        }
    }

    public class f implements Action1<Void> {
        public f() {
        }

        /* renamed from: a */
        public void call(Void voidR) {
            if (p.this.f83936n.getLike() != 2) {
                p.this.f83936n.setLike(2);
                p.this.f83934l.setSelected(false);
                p.this.f83935m.setSelected(true);
                if (p.this.f83926d != null) {
                    p.this.f83926d.P3(p.this.f83936n, false);
                }
                HashMap hashMap = new HashMap();
                hashMap.put("faq_code", p.this.f83936n.getCode());
                hashMap.put("useful", Boolean.FALSE);
                uf.c.b().i("click_faq_useful", hashMap);
            }
        }
    }

    public class g implements Action1<Void> {
        public g() {
        }

        /* renamed from: a */
        public void call(Void voidR) {
            p.this.dismiss();
            p.y(p.this.f83939q, p.this.f83936n, p.this.f83939q);
        }
    }

    public interface h {
        void P3(OtcFAQBean otcFAQBean, boolean z11);
    }

    public p(Activity activity) {
        super(activity);
    }

    public static void A(FragmentActivity fragmentActivity) {
        if (BaseModuleConfig.a().n()) {
            BaseModuleConfig.a().G(fragmentActivity, "total_balance_type_legal");
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("total_balance_type", "total_balance_type_legal");
            Intent intent = new Intent();
            intent.putExtras(bundle);
            ra.c.b().b(fragmentActivity, intent, "balance", false);
        }
        i6.d.e("transfer", "transferFailed");
    }

    public static void B(Activity activity, OtcFAQPresenter.c cVar) {
        if (!OtcModuleConfig.a().a()) {
            OtcModuleConfig.a().l(activity, (Intent) null, (Intent) null);
        } else if (cVar.f2().X() == null) {
            cVar.f2().W();
        } else {
            cVar.w6(cVar.f2().X());
        }
    }

    public static void y(Context context, OtcFAQBean otcFAQBean, OtcFAQPresenter.c cVar) {
        OtcActionBean action = otcFAQBean.getAction();
        if (TextUtils.equals("blank", action.getType())) {
            HBBaseWebActivity.showWebView(context, action.getLink(), "", "", false);
        } else if (TextUtils.equals("self", action.getType())) {
            if ("1".equals(action.getLink())) {
                z(context);
            } else if ("2".equals(action.getLink())) {
                A((FragmentActivity) context);
            } else if ("3".equals(action.getLink())) {
                B((Activity) context, cVar);
            }
        } else if (TextUtils.equals("customerService", action.getType())) {
            OtcModuleConfig.b().x(context, "Started chat with mandatory pre-chat form");
        } else if (TextUtils.equals("splicing", action.getType())) {
            String link = action.getLink();
            String t11 = OtcModuleConfig.a().t();
            if (!TextUtils.isEmpty(t11) && !t11.startsWith("http")) {
                t11 = DomainTool.DOMAIN_PREFIX + t11;
            }
            HBBaseWebActivity.showWebView(context, t11 + File.separator + AppLanguageHelper.getInstance().getCurAppLocale().toString() + link, "", "", false);
        }
    }

    public static void z(Context context) {
        if (OtcModuleConfig.a().a()) {
            OtcModuleConfig.b().U(context, (Intent) null);
        } else {
            OtcModuleConfig.a().l((Activity) context, (Intent) null, (Intent) null);
        }
    }

    public void j() {
        Observable<Void> a11 = dw.a.a(this.f83927e);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        a11.throttleFirst(300, timeUnit).subscribe(new c());
        dw.a.a(this.f83937o).throttleFirst(300, timeUnit).subscribe(new d());
        dw.a.a(this.f83934l).throttleFirst(300, timeUnit).subscribe(new e());
        dw.a.a(this.f83935m).throttleFirst(300, timeUnit).subscribe(new f());
        dw.a.a(this.f83933k).throttleFirst(300, timeUnit).subscribe(new g());
    }

    public int k() {
        return R$layout.dialog_faq_item_layout;
    }

    public void l() {
        this.f83931i = findViewById(R$id.cl_root);
        this.f83932j = findViewById(R$id.cl_dialog_root);
        this.f83930h = (ScrollView) findViewById(R$id.sv_tv);
        FAQGestureFrameLayout fAQGestureFrameLayout = (FAQGestureFrameLayout) findViewById(R$id.fl_faq_gesture);
        this.f83938p = fAQGestureFrameLayout;
        fAQGestureFrameLayout.setEndRunnable(this.f83940r);
        this.f83937o = findViewById(R$id.view_top);
        this.f83927e = (FontIconTextView) findViewById(R$id.rl_top);
        this.f83928f = (TextView) findViewById(R$id.tv_title);
        this.f83929g = (TextView) findViewById(R$id.tv_content);
        this.f83933k = (TextView) findViewById(R$id.tv_action);
        this.f83934l = (TextView) findViewById(R$id.tv_fix);
        this.f83935m = (TextView) findViewById(R$id.tv_unfix);
        OtcFAQBean otcFAQBean = this.f83936n;
        boolean z11 = false;
        if (otcFAQBean != null) {
            this.f83928f.setText(otcFAQBean.getTitle());
            this.f83929g.setText(this.f83936n.getContent());
            if (this.f83936n.getAction() == null || TextUtils.isEmpty(this.f83936n.getAction().getName())) {
                this.f83933k.setVisibility(8);
            } else {
                this.f83933k.setVisibility(0);
                this.f83933k.setText(this.f83936n.getAction().getName());
            }
        }
        int like = this.f83936n.getLike();
        this.f83934l.setSelected(like == 1);
        TextView textView = this.f83935m;
        if (like == 2) {
            z11 = true;
        }
        textView.setSelected(z11);
        this.f83941s = new b();
        this.f83931i.getViewTreeObserver().addOnGlobalLayoutListener(this.f83941s);
    }

    public void w(Activity activity, h hVar) {
        this.f83926d = hVar;
        if (activity instanceof OtcFAQActivity) {
            this.f83939q = (OtcFAQActivity) activity;
        }
    }

    public void x(OtcFAQBean otcFAQBean) {
        this.f83936n = otcFAQBean;
    }
}
