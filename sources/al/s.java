package al;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.google.gson.Gson;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.network.pro.core.bean.UserAddrInfo;
import com.hbg.module.asset.R$drawable;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$string;
import com.huobi.utils.x0;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import g6.b;
import tx.a;

public final class s {

    /* renamed from: a  reason: collision with root package name */
    public static UserAddrInfo f40739a;

    public static String c() {
        return "DEFI_BOX_SELECT_CHAIN" + BaseModuleConfig.a().getUid();
    }

    public static UserAddrInfo d() {
        UserAddrInfo userAddrInfo = f40739a;
        if (userAddrInfo != null) {
            return userAddrInfo;
        }
        String i11 = SP.i(c(), (String) null);
        if (!TextUtils.isEmpty(i11)) {
            try {
                return (UserAddrInfo) new Gson().fromJson(i11, UserAddrInfo.class);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return null;
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void e(View view, String str, View view2) {
        x0.c(view, str, true);
        SensorsDataAutoTrackHelper.trackViewOnClick(view2);
    }

    public static /* synthetic */ void f(String str, View view, String str2) {
        if (!SP.l(str, false)) {
            x0.d(view, str2);
            SP.y(str, true);
        }
    }

    public static void g(ImageView imageView, String str) {
        int i11 = NightHelper.e().g() ? R$drawable.default_icon_night : R$drawable.default_icon;
        b.c().j(imageView, str, i11, b.c().e(i11), (a) null);
    }

    public static void h(UserAddrInfo userAddrInfo) {
        f40739a = userAddrInfo;
        SP.s(c(), userAddrInfo == null ? "" : new Gson().toJson((Object) userAddrInfo));
    }

    public static String i(String str) {
        if (TextUtils.isEmpty(str) || str.length() <= 14) {
            return str;
        }
        return String.format("%s...%s", new Object[]{str.substring(0, 6), str.substring(str.length() - 8)});
    }

    public static void j(View view) {
        String string = view.getResources().getString(R$string.n_on_chain_asset_not_count_tips);
        View findViewById = view.findViewById(R$id.tv_total_i);
        q qVar = new q(findViewById, string);
        view.findViewById(R$id.tv_total_w).setOnClickListener(qVar);
        findViewById.setOnClickListener(qVar);
        view.postDelayed(new r("on_chain_asset_not_count_tips", findViewById, string), 500);
    }
}
