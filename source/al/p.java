package al;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.b;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$color;
import com.hbg.module.asset.R$dimen;
import com.hbg.module.asset.R$drawable;
import com.hbg.module.asset.R$string;
import com.huobi.view.rv.VerticalDividerItemDecoration;
import com.luck.picture.lib.config.PictureMimeType;
import d7.k;
import i6.d;
import i6.m;
import java.util.ArrayList;

public final class p {

    public interface a {
        String a(String str);
    }

    public static boolean d(Context context) {
        if (NetworkStatus.c(context)) {
            return true;
        }
        HuobiToastUtil.j(R$string.server_error);
        return false;
    }

    public static void e(TextView textView, String str) {
        textView.setText(o(textView.getContext(), str, u(), new m(str)));
    }

    public static void f(TextView textView, String str, String str2) {
        textView.setText(o(textView.getContext(), str, u(), new n(str, str2)));
    }

    public static void g(TextView textView, String str, String str2) {
        boolean u11 = u();
        String o11 = o(textView.getContext(), str2, u11, o.f3585a);
        if (u11) {
            o11 = String.format("%s%s", new Object[]{str, o11});
        }
        textView.setText(o11);
    }

    public static String h(String str) {
        return i(str, 8);
    }

    public static String i(String str, int i11) {
        String u02 = m.u0(str, Integer.MAX_VALUE, i11);
        if (!u02.contains(InstructionFileId.DOT)) {
            return u02;
        }
        String[] split = u02.split("\\.");
        if (split.length != 2) {
            return u02;
        }
        while (split[1].endsWith("0") && split[1].length() > 2) {
            split[1] = split[1].substring(0, split[1].length() - 1);
        }
        while (split[1].length() < 2) {
            split[1] = split[1] + "0";
        }
        return split[0] + InstructionFileId.DOT + split[1];
    }

    public static String j(String str, String str2) {
        return i(str, k.C().p(str2));
    }

    public static String k(String str) {
        String j11 = AssetModuleConfig.a().j();
        if (j11 == null) {
            j11 = "";
        }
        return j11 + "/-/x/hb/p/api/contents/currency/icon/" + str.toLowerCase() + PictureMimeType.PNG;
    }

    public static String l(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        String j11 = AssetModuleConfig.a().j();
        d.c("getAssetCurrencyIcon_PngType", j11);
        if (j11 != null) {
            str2 = j11;
        }
        return str2 + "/-/x/hb/p/api/contents/currency/icon_png/" + str.toLowerCase() + PictureMimeType.PNG;
    }

    public static int m() {
        if (NightHelper.e().g()) {
            return R$drawable.balances_currencyicon_night;
        }
        return R$drawable.balances_currencyicon;
    }

    public static int n() {
        if (NightHelper.e().g()) {
            return R$drawable.home_ranking_item_avator_night;
        }
        return R$drawable.home_ranking_item_avator;
    }

    public static String o(Context context, String str, boolean z11, a aVar) {
        Resources resources = context.getResources();
        String string = resources.getString(R$string.global_crossbar);
        String string2 = resources.getString(R$string.balance_hide_star);
        if (TextUtils.isEmpty(str)) {
            return string;
        }
        return z11 ? aVar.a(str) : string2;
    }

    public static VerticalDividerItemDecoration p(Context context) {
        VerticalDividerItemDecoration verticalDividerItemDecoration = new VerticalDividerItemDecoration((Drawable) new ColorDrawable(ContextCompat.getColor(context, R$color.baseColorPrimarySeparator)), (int) context.getResources().getDimension(R$dimen.dimen_0_5), true, true);
        ArrayList arrayList = new ArrayList();
        arrayList.add(0);
        arrayList.add(1);
        verticalDividerItemDecoration.setIgnoreDividerAtIndexList(arrayList);
        return verticalDividerItemDecoration;
    }

    public static /* synthetic */ String s(String str) {
        return str;
    }

    public static void t(boolean z11) {
        b.c().h(z11, BaseModuleConfig.a().i0());
    }

    public static boolean u() {
        return b.c().b(BaseModuleConfig.a().i0());
    }

    public static void v() {
        t(!u());
    }
}
