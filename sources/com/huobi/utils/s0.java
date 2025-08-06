package com.huobi.utils;

import android.net.Uri;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.business.common.red_packet.RedPacketManager;
import com.business.common.red_packet.RedPacketResult;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.hbg.lib.common.utils.crypt.MD5Utils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.account.ui.VerificationStartActivity;
import com.huobi.finance.api.RiskService;
import com.huobi.finance.bean.TsvMsg;
import com.huobi.home.ui.HomeFragment;
import com.tencent.android.tpush.stat.ServiceStat;
import com.twitter.sdk.android.core.identity.AuthHandler;
import i6.d;
import i6.i;
import java.util.HashMap;
import kotlin.text.b;
import pro.huobi.R;
import rn.c;
import tg.r;
import tq.p;
import u6.g;

public final class s0 {

    /* renamed from: a  reason: collision with root package name */
    public static final s0 f83775a = new s0();

    public static final class a extends EasySubscriber<TsvMsg> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FragmentActivity f83776b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f83777c;

        public a(FragmentActivity fragmentActivity, String str) {
            this.f83776b = fragmentActivity;
            this.f83777c = str;
        }

        public static final void c(FragmentActivity fragmentActivity, String str, TsvMsg tsvMsg) {
            VerificationStartActivity.fg(fragmentActivity, str, tsvMsg.tsvMsg);
        }

        /* renamed from: b */
        public void onNext(TsvMsg tsvMsg) {
            super.onNext(tsvMsg);
            i.b().g(new r0(this.f83776b, this.f83777c, tsvMsg), 20);
        }
    }

    public static final boolean a(Uri uri) {
        String queryParameter = uri.getQueryParameter(AuthHandler.EXTRA_TOKEN_SECRET);
        String queryParameter2 = uri.getQueryParameter("sign");
        String b11 = MD5Utils.b((queryParameter + ServiceStat.VERIFY_EVENT_ID).getBytes(b.f56908b));
        if (queryParameter2 == null || !StringsKt__StringsJVMKt.w(queryParameter2, b11, true)) {
            return false;
        }
        return true;
    }

    public static final void b(FragmentActivity fragmentActivity, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("tsvToken", str);
        hashMap.put("uid", r.x().s());
        hashMap.put("lang", AppLanguageHelper.getInstance().getCurLanguageHeader());
        ((RiskService) p.Y(RiskService.class)).getTsvMsg(hashMap).compose(p.Z()).compose(RxJavaHelper.t((g) null)).subscribe(new a(fragmentActivity, str));
    }

    public static final void c(FragmentActivity fragmentActivity, String str) {
        if (t0.c(str)) {
            c.i().d(fragmentActivity, new HomeFragment.AuthTarget());
        } else if (t0.b(str)) {
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("tsvToken");
            d.j("QR-SCAN", "tsvToken=" + queryParameter);
            if (!a(parse)) {
                d.e("QR-SCAN", "checkSign Failed.");
                HuobiToastUtil.j(R.string.n_qr_scan_not_available);
            } else if (queryParameter != null) {
                b(fragmentActivity, queryParameter);
            } else {
                b(fragmentActivity, "");
            }
        } else if (t0.d(str)) {
            try {
                RedPacketResult b11 = RedPacketManager.b(str);
                if (b11.isRedPacket()) {
                    BaseModuleConfig.a().v(fragmentActivity, b11.getCodeWord());
                    return;
                }
                zn.a.d().v(Uri.parse(str)).a().c();
            } catch (Exception e11) {
                e11.printStackTrace();
                HuobiToastUtil.j(R.string.n_qr_scan_not_available);
            }
        } else if (TextUtils.isEmpty(str) || !StringsKt__StringsJVMKt.M(str, ImageSource.ASSET_SCHEME, false, 2, (Object) null)) {
            HuobiToastUtil.j(R.string.n_qr_scan_not_available);
        } else {
            HBBaseWebActivity.showWebView(fragmentActivity, str, (String) null, (String) null, false);
        }
    }
}
