package gj;

import android.text.TextUtils;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.o;
import com.hbg.lib.network.hbg.core.bean.AppContentConfig;
import com.hbg.lib.network.hbg.core.bean.AppOtherContentConfig;
import com.hbg.lib.network.hbg.core.bean.AppUrlInfo;
import com.huobi.domain.DomainSwitcher;
import com.huobi.utils.x;
import com.huochat.community.CommunityManager;
import com.xiaomi.mipush.sdk.Constants;
import i6.k;
import java.util.HashMap;
import java.util.Locale;
import u6.g;

public final class b {

    /* renamed from: g  reason: collision with root package name */
    public static final b f47535g = new b();

    /* renamed from: a  reason: collision with root package name */
    public AppContentConfig f47536a;

    /* renamed from: b  reason: collision with root package name */
    public AppOtherContentConfig f47537b;

    /* renamed from: c  reason: collision with root package name */
    public String f47538c = "https://www.baymaxchat.com/#/h5/?sceneCode=1";

    /* renamed from: d  reason: collision with root package name */
    public String f47539d = "https://www.baymaxchat.com/#/h5/?sceneCode=1110";

    /* renamed from: e  reason: collision with root package name */
    public String f47540e = "https://pledge.huobi.bo/pledge/?hideNav=1";

    /* renamed from: f  reason: collision with root package name */
    public String f47541f = "https://pledge.huobi.bo/pledge/his_orders/";

    public class a extends q6.a<AppUrlInfo> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ StringBuilder f47542a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(g gVar, boolean z11, StringBuilder sb2) {
            super(gVar, z11);
            this.f47542a = sb2;
        }

        public void onRequestFailure(Throwable th2) {
            super.onRequestFailure(th2);
            k.g("CONTENT_CONFIG", "important/app/url/get?types=" + this.f47542a.toString(), th2);
        }

        public void onRequestSuccess(AppUrlInfo appUrlInfo) {
            b.this.v(appUrlInfo);
            b.this.u(appUrlInfo);
            b.this.r(appUrlInfo);
            b.this.p(appUrlInfo);
            b.this.o(appUrlInfo);
            b.this.s(appUrlInfo);
            b.this.t(appUrlInfo);
            b.this.q(appUrlInfo);
        }
    }

    public static b j() {
        return f47535g;
    }

    public String i() {
        if (TextUtils.isEmpty(this.f47538c)) {
            this.f47538c = "https://www.baymaxchat.com/#/h5/?sceneCode=1";
        }
        return this.f47538c;
    }

    public String k() {
        if (TextUtils.isEmpty(this.f47539d)) {
            this.f47539d = "https://www.baymaxchat.com/#/h5/?sceneCode=1110";
        }
        return this.f47539d;
    }

    public String l() {
        if (TextUtils.isEmpty(this.f47540e)) {
            this.f47540e = "https://pledge.huobi.bo/pledge/?hideNav=1";
        }
        return this.f47540e;
    }

    public String m() {
        if (TextUtils.isEmpty(this.f47541f)) {
            this.f47541f = "https://pledge.huobi.bo/pledge/his_orders/";
        }
        return this.f47541f;
    }

    public AppContentConfig n() {
        return this.f47536a;
    }

    public final void o(AppUrlInfo appUrlInfo) {
        if (appUrlInfo == null || appUrlInfo.getBaymaxchat() == null) {
            k.f("CONTENT_CONFIG", "config BayMaxChat url is empty");
            return;
        }
        if (x.d()) {
            if (appUrlInfo.getBaymaxchat().containsKey("cn")) {
                String str = appUrlInfo.getBaymaxchat().get("cn");
                if (!TextUtils.isEmpty(str)) {
                    this.f47538c = str;
                } else {
                    this.f47538c = "https://www.baymaxchat.com/#/h5/?sceneCode=1";
                }
            }
        } else if (appUrlInfo.getBaymaxchat().containsKey("overseas")) {
            String str2 = appUrlInfo.getBaymaxchat().get("overseas");
            if (!TextUtils.isEmpty(str2)) {
                this.f47538c = str2;
            } else {
                this.f47538c = "https://www.baymaxchat.com/#/h5/?sceneCode=1";
            }
        }
        k.d("CONTENT_CONFIG", "initBayMaxChatBaseUrlConfig bayMaxChatBaseUrl - " + this.f47538c);
    }

    public final void p(AppUrlInfo appUrlInfo) {
        if (appUrlInfo == null) {
            k.f("CONTENT_CONFIG", "config community url is empty!");
        } else {
            CommunityManager.Companion.resetCommunityDomain(appUrlInfo.getHuobichat(), appUrlInfo.getHuobichatWeb());
        }
    }

    public final void q(AppUrlInfo appUrlInfo) {
        if (appUrlInfo == null || appUrlInfo.getKyc() == null) {
            k.f("CONTENT_CONFIG", "config kycService url is empty");
            return;
        }
        if (x.d()) {
            if (appUrlInfo.getKyc().containsKey("cn")) {
                String str = appUrlInfo.getKyc().get("cn");
                if (!TextUtils.isEmpty(str)) {
                    this.f47539d = str;
                } else {
                    this.f47539d = "https://www.baymaxchat.com/#/h5/?sceneCode=1110";
                }
            }
        } else if (appUrlInfo.getKyc().containsKey("overseas")) {
            String str2 = appUrlInfo.getKyc().get("overseas");
            if (!TextUtils.isEmpty(str2)) {
                this.f47539d = str2;
            } else {
                this.f47539d = "https://www.baymaxchat.com/#/h5/?sceneCode=1110";
            }
        }
        k.d("CONTENT_CONFIG", "initKycServiceUrlConfig kycServiceBaseUrl - " + this.f47539d);
    }

    public final void r(AppUrlInfo appUrlInfo) {
        if (appUrlInfo == null || appUrlInfo.getOther() == null) {
            k.f("CONTENT_CONFIG", "config appUrlInfo url is empty");
            return;
        }
        this.f47537b = appUrlInfo.getOther();
        k.d("CONTENT_CONFIG", "initShareAppUrlInfo otherConfig - " + this.f47537b);
        HashMap hashMap = new HashMap();
        hashMap.put(Locale.SIMPLIFIED_CHINESE.toString(), this.f47537b.getWebHostZh());
        hashMap.put(Locale.ENGLISH.toString(), this.f47537b.getWebHostEn());
        hashMap.put(Locale.KOREA.toString(), this.f47537b.getWebHostKo());
        hashMap.put(AppLanguageHelper.VIETNAM_LOCALE.toString(), this.f47537b.getWebHostVi());
        hashMap.put(AppLanguageHelper.TURKEY_LOCALE.toString(), this.f47537b.getWebHostTr());
        o.l(hashMap);
    }

    public final void s(AppUrlInfo appUrlInfo) {
        if (appUrlInfo == null || appUrlInfo.getPledgeloanBorrow() == null) {
            k.f("CONTENT_CONFIG", "config PledgeLoanBorrow url is empty");
            return;
        }
        if (x.d()) {
            if (appUrlInfo.getPledgeloanBorrow().containsKey("cn")) {
                String str = appUrlInfo.getPledgeloanBorrow().get("cn");
                if (!TextUtils.isEmpty(str)) {
                    this.f47540e = str;
                } else {
                    this.f47540e = "https://pledge.huobi.bo/pledge/?hideNav=1";
                }
            }
        } else if (appUrlInfo.getPledgeloanBorrow().containsKey("overseas")) {
            String str2 = appUrlInfo.getPledgeloanBorrow().get("overseas");
            if (!TextUtils.isEmpty(str2)) {
                this.f47540e = str2;
            } else {
                this.f47540e = "https://pledge.huobi.bo/pledge/?hideNav=1";
            }
        }
        k.d("CONTENT_CONFIG", "initPledgeLoanBorrowBaseUrlConfig pledgeLoanBorrowBaseUrl - " + this.f47540e);
    }

    public final void t(AppUrlInfo appUrlInfo) {
        if (appUrlInfo == null || appUrlInfo.getPledgeloanOrder() == null) {
            k.f("CONTENT_CONFIG", "config PledgeLoanOrders url is empty");
            return;
        }
        if (x.d()) {
            if (appUrlInfo.getPledgeloanOrder().containsKey("cn")) {
                String str = appUrlInfo.getPledgeloanOrder().get("cn");
                if (!TextUtils.isEmpty(str)) {
                    this.f47541f = str;
                } else {
                    this.f47541f = "https://pledge.huobi.bo/pledge/his_orders/";
                }
            }
        } else if (appUrlInfo.getPledgeloanOrder().containsKey("overseas")) {
            String str2 = appUrlInfo.getPledgeloanOrder().get("overseas");
            if (!TextUtils.isEmpty(str2)) {
                this.f47541f = str2;
            } else {
                this.f47541f = "https://pledge.huobi.bo/pledge/his_orders/";
            }
        }
        k.d("CONTENT_CONFIG", "initPledgeLoanOrdersBaseUrlConfig pledgeLoanOrdersBaseUrl - " + this.f47541f);
    }

    public final void u(AppUrlInfo appUrlInfo) {
        if (appUrlInfo == null || appUrlInfo.getShare() == null) {
            k.f("CONTENT_CONFIG", "config appUrlInfo url is empty");
            return;
        }
        this.f47536a = appUrlInfo.getShare();
        k.d("CONTENT_CONFIG", "initShareAppUrlInfo shareConfig - " + this.f47536a);
    }

    public final void v(AppUrlInfo appUrlInfo) {
        if (appUrlInfo == null || appUrlInfo.getZendesk() == null) {
            k.f("CONTENT_CONFIG", "config zendesk url is empty");
            return;
        }
        boolean d11 = x.d();
        if (d11) {
            DomainSwitcher.T0("global", appUrlInfo.getZendesk().getGlobalCn());
        } else {
            DomainSwitcher.T0("global", appUrlInfo.getZendesk().getGlobalOversea());
        }
        if (d11) {
            DomainSwitcher.T0(com.sumsub.sentry.a.f30241h, appUrlInfo.getZendesk().getAppCn());
        } else {
            DomainSwitcher.T0(com.sumsub.sentry.a.f30241h, appUrlInfo.getZendesk().getAppOversea());
        }
        k.d("CONTENT_CONFIG", "initZendeskConfig ZendeskInfo - " + appUrlInfo.getZendesk());
    }

    public void w() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("share");
        sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb2.append("other");
        sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb2.append("zendesk");
        sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb2.append("huobichat");
        sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb2.append("huobichatWeb");
        sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb2.append("bayMaxChat");
        sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb2.append("cloudWallet");
        sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb2.append("pledgeloanBorrow");
        sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb2.append("pledgeloanOrder");
        sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb2.append("kyc");
        v7.b.a().appUrlGet(sb2.toString()).d(new a((g) null, false, sb2));
    }
}
