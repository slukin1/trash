package kc;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.network.hbg.core.bean.NewFlashInformationCoinTags;
import com.hbg.module.content.R$drawable;
import com.hbg.module.content.custom.CoinTagView;
import com.hbg.module.content.custom.CoinTagViewV2;
import com.hbg.module.libkt.base.ext.c;
import com.luck.picture.lib.config.PictureMimeType;
import java.util.Locale;
import kotlin.Unit;
import kotlin.jvm.internal.r;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f19139a = new a();

    public static final CoinTagView a(Context context, NewFlashInformationCoinTags newFlashInformationCoinTags, String str, String str2, String str3, int i11, boolean z11, String str4, String str5, int i12, boolean z12, d10.a<Unit> aVar) {
        CoinTagView coinTagView = new CoinTagView(context, (AttributeSet) null, 0, z11, 6, (r) null);
        coinTagView.a(newFlashInformationCoinTags, str, str2, str3, i11, str4, aVar, str5, i12, z12);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, c.d(Float.valueOf(24.0f)));
        layoutParams.setMargins(0, 0, c.a(10.0f), 0);
        coinTagView.setLayoutParams(layoutParams);
        return coinTagView;
    }

    public static /* synthetic */ CoinTagView b(Context context, NewFlashInformationCoinTags newFlashInformationCoinTags, String str, String str2, String str3, int i11, boolean z11, String str4, String str5, int i12, boolean z12, d10.a aVar, int i13, Object obj) {
        int i14 = i13;
        return a(context, newFlashInformationCoinTags, str, str2, str3, i11, (i14 & 64) != 0 ? true : z11, (i14 & 128) != 0 ? null : str4, (i14 & 256) != 0 ? "" : str5, (i14 & 512) != 0 ? 0 : i12, (i14 & 1024) != 0 ? false : z12, (i14 & 2048) != 0 ? null : aVar);
    }

    public static final CoinTagViewV2 c(Context context, NewFlashInformationCoinTags newFlashInformationCoinTags, String str, String str2, String str3, int i11, String str4, String str5, int i12, d10.a<Unit> aVar, boolean z11) {
        CoinTagViewV2 coinTagViewV2 = new CoinTagViewV2(context, (AttributeSet) null, 0, 6, (r) null);
        coinTagViewV2.a(newFlashInformationCoinTags, str, str2, str3, i11, str4, aVar, str5, i12, z11);
        return coinTagViewV2;
    }

    public static /* synthetic */ CoinTagViewV2 d(Context context, NewFlashInformationCoinTags newFlashInformationCoinTags, String str, String str2, String str3, int i11, String str4, String str5, int i12, d10.a aVar, boolean z11, int i13, Object obj) {
        int i14 = i13;
        return c(context, newFlashInformationCoinTags, str, str2, str3, i11, (i14 & 64) != 0 ? null : str4, (i14 & 128) != 0 ? "" : str5, (i14 & 256) != 0 ? 0 : i12, (i14 & 512) != 0 ? null : aVar, (i14 & 1024) != 0 ? true : z11);
    }

    public final String e(String str) {
        String j11 = BaseModuleConfig.a().j();
        return j11 + "/-/x/hb/p/api/contents/currency/icon/" + str.toLowerCase(Locale.getDefault()) + PictureMimeType.PNG;
    }

    public final int f() {
        if (NightHelper.e().g()) {
            return R$drawable.balances_currencyicon_night;
        }
        return R$drawable.balances_currencyicon;
    }
}
