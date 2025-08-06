package up;

import android.app.Activity;
import android.view.View;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.module.otc.OtcModuleConfig;
import com.hbg.module.otc.R$string;
import com.huobi.otc.enums.OtcTradeAreaEnum;
import com.huobi.otc.ui.OtcTradeActivity;
import com.huobi.view.HighLightPopup;
import com.huobi.view.OtcHeavyBubbleDialog;
import jp.h0;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import uf.d;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f84912a = false;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f84913b = false;

    /* renamed from: c  reason: collision with root package name */
    public static OtcHeavyBubbleDialog f84914c = null;

    /* renamed from: d  reason: collision with root package name */
    public static OtcHeavyBubbleDialog f84915d = null;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f84916e = false;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f84917f = false;

    public class a implements h0.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OtcTradeActivity f84918a;

        public a(OtcTradeActivity otcTradeActivity) {
            this.f84918a = otcTradeActivity;
        }

        public void a(boolean z11) {
            OtcHeavyBubbleDialog unused = h.f84914c = null;
            if (!z11) {
                boolean unused2 = h.m(this.f84918a);
            }
        }
    }

    public class b implements d.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OtcTradeActivity f84919a;

        public class a implements h0.c {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ View f84920a;

            public a(View view) {
                this.f84920a = view;
            }

            public void a(boolean z11) {
                OtcHeavyBubbleDialog unused = h.f84914c = null;
                this.f84920a.setVisibility(8);
                if (!z11) {
                    boolean unused2 = h.p(b.this.f84919a);
                }
            }
        }

        public b(OtcTradeActivity otcTradeActivity) {
            this.f84919a = otcTradeActivity;
        }

        public void a(View view) {
            a aVar = new a(view);
            h0 c11 = h0.c();
            OtcTradeActivity otcTradeActivity = this.f84919a;
            OtcHeavyBubbleDialog unused = h.f84914c = c11.i(otcTradeActivity, view, aVar, UIUtil.a(otcTradeActivity, 10.0d), true, 2, 3, this.f84919a.getString(R$string.n_otc_guide_switch_tip), (String) null, 0);
        }
    }

    public class c implements h0.c {
        public void a(boolean z11) {
            OtcHeavyBubbleDialog unused = h.f84914c = null;
        }
    }

    public static void d(Activity activity) {
        try {
            if (!f(activity)) {
                HighLightPopup b11 = h0.c().b();
                if (b11 != null && b11.isShowing()) {
                    b11.dismiss();
                }
                OtcHeavyBubbleDialog otcHeavyBubbleDialog = f84915d;
                if (otcHeavyBubbleDialog != null && otcHeavyBubbleDialog.isAdded()) {
                    f84915d.dismiss();
                    h0.c().g(activity, (h0.c) null, f84915d, true);
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static boolean e() {
        Activity b11 = oa.a.g().b();
        if ((b11 == null || (b11 instanceof OtcTradeActivity)) && !((OtcTradeActivity) b11).di()) {
            return true;
        }
        return false;
    }

    public static boolean f(Activity activity) {
        return activity == null || activity.isDestroyed() || activity.isFinishing() || !f84916e;
    }

    public static boolean g() {
        return f84914c != null;
    }

    public static boolean h() {
        return f84915d != null;
    }

    public static boolean i() {
        return g() || h();
    }

    public static boolean j(OtcTradeActivity otcTradeActivity) {
        if (e() && !f(otcTradeActivity) && !i()) {
            if (otcTradeActivity.bi() && h0.c().e()) {
                ConfigPreferences.n("otc_config", "show_new_user_trade_guide", true);
                OtcModuleConfig.b().h(otcTradeActivity, false);
                return true;
            } else if (f84916e && !f84913b && otcTradeActivity.Ed() == OtcTradeAreaEnum.FAST_AREA) {
                n(otcTradeActivity);
            }
        }
        return false;
    }

    public static void k(OtcTradeActivity otcTradeActivity, boolean z11) {
        f84912a = z11;
        j(otcTradeActivity);
    }

    public static void l(OtcTradeActivity otcTradeActivity, boolean z11) {
        f84916e = z11;
        j(otcTradeActivity);
    }

    public static boolean m(OtcTradeActivity otcTradeActivity) {
        otcTradeActivity.Th(new b(otcTradeActivity));
        return true;
    }

    public static void n(OtcTradeActivity otcTradeActivity) {
        if (e() && !f(otcTradeActivity) && otcTradeActivity.ci() && !otcTradeActivity.bi() && f84917f) {
            d(otcTradeActivity);
            if (!g()) {
                f84913b = true;
                q(otcTradeActivity);
            }
        }
    }

    public static void o(OtcTradeActivity otcTradeActivity) {
        f84917f = true;
        n(otcTradeActivity);
    }

    public static boolean p(OtcTradeActivity otcTradeActivity) {
        c cVar = new c();
        f84914c = h0.c().i(otcTradeActivity, otcTradeActivity.Ph(), cVar, UIUtil.a(otcTradeActivity, 8.0d), true, 3, 3, otcTradeActivity.getString(R$string.n_otc_guide_more_function), (String) null, 0);
        return true;
    }

    public static boolean q(OtcTradeActivity otcTradeActivity) {
        if (!h0.c().d()) {
            return false;
        }
        ConfigPreferences.n("otc_config", "show_otc_fast_tab_guide", true);
        a aVar = new a(otcTradeActivity);
        h0 c11 = h0.c();
        View Nh = otcTradeActivity.Nh();
        String string = otcTradeActivity.getString(R$string.n_otc_guide_switch);
        f84914c = c11.i(otcTradeActivity, Nh, aVar, -1, false, 1, 3, string, otcTradeActivity.getString(R$string.n_otc_guide_new_tab_des_second_no_punctuation) + "\n" + otcTradeActivity.getString(R$string.n_otc_guide_new_tab_des_third_no_punctuation) + "\n" + otcTradeActivity.getString(R$string.n_otc_guide_new_tab_des_fourth_no_punctuation), 0);
        return true;
    }
}
