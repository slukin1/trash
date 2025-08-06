package zn;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.util.p;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.data.future.controller.FutureContractInfoController;
import com.hbg.lib.data.future.util.FutureTypeUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.swap.core.controller.SwapCurrencyInfoController;
import com.hbg.lib.router.HbgRouter;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huobi.asset2.page.Asset2Activity;
import com.huobi.contract.helper.ContractCurrencyUtils;
import com.huobi.contract.helper.ContractUserInfoProvider;
import com.huobi.contract.ui.ContractTradeBaseFragment;
import com.huobi.index.ui.widget.QuickAdditionFragment;
import com.huobi.linearswap.ui.LinearSwapTradeBaseFragment;
import com.huobi.login.bean.JumpTarget;
import com.huobi.main.ui.LoginCallBackActivity;
import com.huobi.swap.ui.SwapTradeBaseFragment;
import com.huobi.utils.k0;
import com.tencent.imsdk.v2.V2TIMConversation;
import gs.g;
import hh.f;
import i6.d;
import java.util.HashMap;
import java.util.Map;
import pro.huobi.R;
import qk.n0;
import rn.c;
import tg.r;

public final class a {

    /* renamed from: f  reason: collision with root package name */
    public static a f85089f;

    /* renamed from: a  reason: collision with root package name */
    public boolean f85090a = true;

    /* renamed from: b  reason: collision with root package name */
    public String f85091b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f85092c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f85093d;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, String> f85094e;

    public a() {
        HashMap hashMap = new HashMap();
        this.f85094e = hashMap;
        hashMap.put("pro", "total_balance_type_balance");
        this.f85094e.put("contract", "total_balance_type_contract");
        this.f85094e.put("otc", "total_balance_type_legal");
        this.f85094e.put("margin", "total_balance_type_super_margin");
        this.f85094e.put("pool", "total_balance_type_mine");
        this.f85094e.put("mining", "total_balance_type_mining");
        this.f85094e.put("savings", "total_balance_type_savings");
    }

    public static a d() {
        if (f85089f == null) {
            f85089f = new a();
        }
        return f85089f;
    }

    public static void f(Activity activity, String str, boolean z11) {
        if (!TextUtils.isEmpty(str)) {
            Intent intent = new Intent();
            intent.putExtra("url", str);
            intent.putExtra("title_back", activity.getString(R.string.head_return));
            intent.setClass(activity, HBBaseWebActivity.class);
            if (z11) {
                h(activity, intent, k0.h(activity));
            } else {
                activity.startActivity(intent);
            }
        }
    }

    public static void g(Activity activity, String str, boolean z11) {
        if (!TextUtils.isEmpty(str)) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                if (z11) {
                    h(activity, intent, k0.h(activity));
                } else {
                    activity.startActivity(intent);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public static void h(Activity activity, Intent intent, Intent intent2) {
        if (r.x().F0()) {
            activity.startActivity(intent);
        } else {
            c.i().d(activity, new JumpTarget(intent, intent2));
        }
    }

    public static void n(Activity activity, String str, String str2, String str3) {
        if (StringUtils.p(str3)) {
            Log.e("JumpUtils", "groupCode is null");
            return;
        }
        g.i("call_addServer2home", (HashMap) null);
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        bundle.putString("imgUrl", str2);
        bundle.putString("groupCode", str3);
        if (r.x().F0()) {
            Fragment fragment = (Fragment) HbgRouter.i(activity, "/home/ReplaceFunction", bundle);
            if ((fragment instanceof QuickAdditionFragment) && (activity instanceof FragmentActivity)) {
                ((QuickAdditionFragment) fragment).show(((FragmentActivity) activity).getSupportFragmentManager(), "mQuickAdditionFragment");
                return;
            }
            return;
        }
        c.i().d(activity, (kn.a) null);
        Log.d("JumpUtils", "请先登录");
    }

    public a a() {
        if (!StringUtils.p(this.f85091b)) {
            this.f85090a = i(this.f85091b);
            Log.d("JumpUtils", "checkIt() called =isSafe=" + this.f85090a + "   ,url=" + this.f85091b);
        }
        return this;
    }

    public final void b(Activity activity) {
        if (this.f85093d) {
            o();
            return;
        }
        Intent intent = new Intent(activity, LoginCallBackActivity.class);
        c.i().d(activity, new JumpTarget(intent, intent));
        this.f85093d = true;
    }

    public void c() {
        if (!TextUtils.isEmpty(this.f85091b)) {
            d.b("tryPushJumpUrl consumeJumpUrl = " + this.f85091b + "; needLogin = " + this.f85092c);
            l(oa.a.g().b(), this.f85091b, this.f85092c);
            return;
        }
        o();
    }

    public String e(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String str3 = str2 + ContainerUtils.KEY_VALUE_DELIMITER;
        int indexOf = str.indexOf(str3);
        if (indexOf == -1) {
            return "";
        }
        String substring = str.substring(indexOf + str3.length());
        int indexOf2 = substring.indexOf(ContainerUtils.FIELD_DELIMITER);
        if (indexOf2 == -1) {
            return substring;
        }
        return substring.substring(0, indexOf2);
    }

    public final boolean i(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith("ihuobiglobal") || HbgRouter.e(str)) {
            return true;
        }
        return false;
    }

    public boolean j(Uri uri) {
        if (uri == null) {
            return false;
        }
        String scheme = uri.getScheme();
        String host = uri.getHost();
        String path = uri.getPath();
        if (!TextUtils.equals(scheme, "holigeit") || !TextUtils.equals(host, "open") || !TextUtils.equals(path, "/v1")) {
            return false;
        }
        return !TextUtils.isEmpty(uri.getQueryParameter("url"));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00cd, code lost:
        r4 = r0;
        r0 = null;
        r7 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x012a, code lost:
        if (android.text.TextUtils.isEmpty(r7) != false) goto L_0x0130;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x012c, code lost:
        t(r6, r7, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x012f, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean k(android.app.Activity r6, java.lang.String r7) {
        /*
            r5 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            r1 = 0
            if (r0 != 0) goto L_0x0130
            r7.hashCode()
            r0 = -1
            int r2 = r7.hashCode()
            r3 = 1
            switch(r2) {
                case -2009594746: goto L_0x009a;
                case -1481577479: goto L_0x008f;
                case -796934155: goto L_0x0084;
                case -789663081: goto L_0x0079;
                case -725761348: goto L_0x006e;
                case -211047603: goto L_0x0063;
                case -210877350: goto L_0x0058;
                case -210685542: goto L_0x004d;
                case -113476235: goto L_0x003f;
                case 1087895421: goto L_0x0031;
                case 2051687314: goto L_0x0023;
                case 2135086489: goto L_0x0015;
                default: goto L_0x0013;
            }
        L_0x0013:
            goto L_0x00a4
        L_0x0015:
            java.lang.String r2 = "total_balance_type_contract"
            boolean r7 = r7.equals(r2)
            if (r7 != 0) goto L_0x001f
            goto L_0x00a4
        L_0x001f:
            r0 = 11
            goto L_0x00a4
        L_0x0023:
            java.lang.String r2 = "total_balance_type_legal"
            boolean r7 = r7.equals(r2)
            if (r7 != 0) goto L_0x002d
            goto L_0x00a4
        L_0x002d:
            r0 = 10
            goto L_0x00a4
        L_0x0031:
            java.lang.String r2 = "total_balance_type_otc_option"
            boolean r7 = r7.equals(r2)
            if (r7 != 0) goto L_0x003b
            goto L_0x00a4
        L_0x003b:
            r0 = 9
            goto L_0x00a4
        L_0x003f:
            java.lang.String r2 = "total_balance_type_balance"
            boolean r7 = r7.equals(r2)
            if (r7 != 0) goto L_0x0049
            goto L_0x00a4
        L_0x0049:
            r0 = 8
            goto L_0x00a4
        L_0x004d:
            java.lang.String r2 = "total_balance_type_swap"
            boolean r7 = r7.equals(r2)
            if (r7 != 0) goto L_0x0056
            goto L_0x00a4
        L_0x0056:
            r0 = 7
            goto L_0x00a4
        L_0x0058:
            java.lang.String r2 = "total_balance_type_mine"
            boolean r7 = r7.equals(r2)
            if (r7 != 0) goto L_0x0061
            goto L_0x00a4
        L_0x0061:
            r0 = 6
            goto L_0x00a4
        L_0x0063:
            java.lang.String r2 = "total_balance_type_grid"
            boolean r7 = r7.equals(r2)
            if (r7 != 0) goto L_0x006c
            goto L_0x00a4
        L_0x006c:
            r0 = 5
            goto L_0x00a4
        L_0x006e:
            java.lang.String r2 = "total_balance_type_option"
            boolean r7 = r7.equals(r2)
            if (r7 != 0) goto L_0x0077
            goto L_0x00a4
        L_0x0077:
            r0 = 4
            goto L_0x00a4
        L_0x0079:
            java.lang.String r2 = "total_balance_type_mining"
            boolean r7 = r7.equals(r2)
            if (r7 != 0) goto L_0x0082
            goto L_0x00a4
        L_0x0082:
            r0 = 3
            goto L_0x00a4
        L_0x0084:
            java.lang.String r2 = "total_balance_type_margin"
            boolean r7 = r7.equals(r2)
            if (r7 != 0) goto L_0x008d
            goto L_0x00a4
        L_0x008d:
            r0 = 2
            goto L_0x00a4
        L_0x008f:
            java.lang.String r2 = "total_balance_type_super_margin"
            boolean r7 = r7.equals(r2)
            if (r7 != 0) goto L_0x0098
            goto L_0x00a4
        L_0x0098:
            r0 = r3
            goto L_0x00a4
        L_0x009a:
            java.lang.String r2 = "total_balance_type_linear_swap"
            boolean r7 = r7.equals(r2)
            if (r7 != 0) goto L_0x00a3
            goto L_0x00a4
        L_0x00a3:
            r0 = r1
        L_0x00a4:
            r7 = 0
            switch(r0) {
                case 0: goto L_0x011a;
                case 1: goto L_0x010d;
                case 2: goto L_0x0100;
                case 3: goto L_0x00f9;
                case 4: goto L_0x00ec;
                case 5: goto L_0x00e5;
                case 6: goto L_0x00de;
                case 7: goto L_0x00d1;
                case 8: goto L_0x00c7;
                case 9: goto L_0x00c0;
                case 10: goto L_0x00b9;
                case 11: goto L_0x00ab;
                default: goto L_0x00a8;
            }
        L_0x00a8:
            r0 = r7
            goto L_0x0126
        L_0x00ab:
            com.huobi.asset.AssetAccountType r7 = com.huobi.asset.AssetAccountType.FUTURE
            java.lang.String r7 = r7.toString()
            com.huobi.asset.feature.summary.AssetSummaryAccountType r0 = com.huobi.asset.feature.summary.AssetSummaryAccountType.CONTRACT
            java.lang.String r0 = r0.toString()
            goto L_0x0126
        L_0x00b9:
            com.huobi.asset.AssetAccountType r0 = com.huobi.asset.AssetAccountType.OTC
            java.lang.String r0 = r0.toString()
            goto L_0x00cd
        L_0x00c0:
            com.huobi.asset.AssetAccountType r0 = com.huobi.asset.AssetAccountType.WARRANT
            java.lang.String r0 = r0.toString()
            goto L_0x00cd
        L_0x00c7:
            com.huobi.asset.AssetAccountType r0 = com.huobi.asset.AssetAccountType.SPOT
            java.lang.String r0 = r0.toString()
        L_0x00cd:
            r4 = r0
            r0 = r7
            r7 = r4
            goto L_0x0126
        L_0x00d1:
            com.huobi.asset.AssetAccountType r7 = com.huobi.asset.AssetAccountType.FUTURE
            java.lang.String r7 = r7.toString()
            com.huobi.asset.feature.summary.AssetSummaryAccountType r0 = com.huobi.asset.feature.summary.AssetSummaryAccountType.SWAP
            java.lang.String r0 = r0.toString()
            goto L_0x0126
        L_0x00de:
            com.huobi.asset.AssetAccountType r0 = com.huobi.asset.AssetAccountType.POOL
            java.lang.String r0 = r0.toString()
            goto L_0x00cd
        L_0x00e5:
            com.huobi.asset.AssetAccountType r0 = com.huobi.asset.AssetAccountType.QUANT
            java.lang.String r0 = r0.toString()
            goto L_0x00cd
        L_0x00ec:
            com.huobi.asset.AssetAccountType r7 = com.huobi.asset.AssetAccountType.FUTURE
            java.lang.String r7 = r7.toString()
            com.huobi.asset.feature.summary.AssetSummaryAccountType r0 = com.huobi.asset.feature.summary.AssetSummaryAccountType.OPTION
            java.lang.String r0 = r0.toString()
            goto L_0x0126
        L_0x00f9:
            com.huobi.asset.AssetAccountType r0 = com.huobi.asset.AssetAccountType.HUOBI_EARN
            java.lang.String r0 = r0.toString()
            goto L_0x00cd
        L_0x0100:
            com.huobi.asset.AssetAccountType r7 = com.huobi.asset.AssetAccountType.MARGIN
            java.lang.String r7 = r7.toString()
            com.huobi.asset.feature.summary.AssetSummaryAccountType r0 = com.huobi.asset.feature.summary.AssetSummaryAccountType.SINGLE_MARGIN
            java.lang.String r0 = r0.toString()
            goto L_0x0126
        L_0x010d:
            com.huobi.asset.AssetAccountType r7 = com.huobi.asset.AssetAccountType.MARGIN
            java.lang.String r7 = r7.toString()
            com.huobi.asset.feature.summary.AssetSummaryAccountType r0 = com.huobi.asset.feature.summary.AssetSummaryAccountType.SUPER_MARGIN
            java.lang.String r0 = r0.toString()
            goto L_0x0126
        L_0x011a:
            com.huobi.asset.AssetAccountType r7 = com.huobi.asset.AssetAccountType.FUTURE
            java.lang.String r7 = r7.toString()
            com.huobi.asset.feature.summary.AssetSummaryAccountType r0 = com.huobi.asset.feature.summary.AssetSummaryAccountType.LINEAR_SWAP
            java.lang.String r0 = r0.toString()
        L_0x0126:
            boolean r2 = android.text.TextUtils.isEmpty(r7)
            if (r2 != 0) goto L_0x0130
            r5.t(r6, r7, r0)
            return r3
        L_0x0130:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: zn.a.k(android.app.Activity, java.lang.String):boolean");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0151 A[Catch:{ all -> 0x0164 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void l(android.app.Activity r18, java.lang.String r19, boolean r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = r20
            java.lang.Class<com.huobi.main.ui.HuobiMainActivity> r4 = com.huobi.main.ui.HuobiMainActivity.class
            boolean r5 = com.hbg.lib.common.utils.StringUtils.p(r19)
            if (r5 != 0) goto L_0x0930
            if (r1 != 0) goto L_0x0014
            goto L_0x0930
        L_0x0014:
            android.net.Uri r5 = android.net.Uri.parse(r19)
            java.lang.String r6 = r5.getScheme()
            java.lang.String r7 = ""
            r8 = 0
            if (r6 == 0) goto L_0x0095
            java.lang.String r6 = r5.getScheme()
            java.lang.String r9 = "http"
            boolean r6 = r6.startsWith(r9)
            if (r6 == 0) goto L_0x0095
            java.lang.String r4 = "hbOpenType"
            java.lang.String r4 = r5.getQueryParameter(r4)
            java.lang.String r6 = "1"
            boolean r4 = r6.equals(r4)
            if (r4 == 0) goto L_0x004b
            java.lang.String r4 = "?hbOpenType=1"
            java.lang.String r2 = r2.replace(r4, r7)
            java.lang.String r4 = "&hbOpenType=1"
            java.lang.String r2 = r2.replace(r4, r7)
            g(r1, r2, r3)
            goto L_0x0090
        L_0x004b:
            boolean r4 = r0.f85090a
            if (r4 != 0) goto L_0x008d
            android.net.Uri$Builder r2 = r5.buildUpon()
            java.lang.String r4 = "hb_unsafe"
            android.net.Uri$Builder r2 = r2.appendQueryParameter(r4, r6)
            java.lang.String r2 = r2.toString()
            java.lang.String r4 = "h5_huobi_url_whitelist"
            com.blankj.utilcode.util.t r5 = com.blankj.utilcode.util.t.a(r4)
            java.util.Set r4 = r5.e(r4, r8)
            boolean r5 = com.hbg.module.libkt.base.ext.b.w(r4)
            if (r5 != 0) goto L_0x008d
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "UnSafe Url : "
            r5.append(r6)
            r5.append(r2)
            java.lang.String r6 = "\n"
            r5.append(r6)
            java.lang.String r4 = com.hbg.module.libkt.base.ext.f.f(r4)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            i6.k.e(r4)
        L_0x008d:
            f(r1, r2, r3)
        L_0x0090:
            r17.o()
            goto L_0x0930
        L_0x0095:
            java.lang.String r6 = r5.getPath()
            java.lang.String r9 = "/account/multiple"
            boolean r9 = r9.equals(r6)
            if (r9 == 0) goto L_0x00bd
            tg.r r2 = tg.r.x()
            boolean r2 = r2.F0()
            if (r2 == 0) goto L_0x00b3
            com.hbg.lib.router.HbgRouter.h(r1, r6)
            r17.o()
            goto L_0x0930
        L_0x00b3:
            r17.o()
            if (r3 == 0) goto L_0x0930
            r17.b(r18)
            goto L_0x0930
        L_0x00bd:
            java.lang.String r9 = "/home/index"
            boolean r9 = r9.equals(r6)
            if (r9 == 0) goto L_0x00d1
            android.content.Intent r2 = com.huobi.utils.k0.h(r18)
            r1.startActivity(r2)
            r17.o()
            goto L_0x0930
        L_0x00d1:
            java.lang.String r9 = "/market/index"
            boolean r9 = r9.equals(r6)
            if (r9 == 0) goto L_0x00e5
            android.content.Intent r2 = com.huobi.utils.k0.l(r18)
            r1.startActivity(r2)
            r17.o()
            goto L_0x0930
        L_0x00e5:
            java.lang.String r9 = "/market/collection"
            boolean r9 = r9.equals(r6)
            r12 = 0
            r13 = 1
            if (r9 == 0) goto L_0x0170
            java.lang.String r2 = "secTab"
            java.lang.String r2 = r5.getQueryParameter(r2)     // Catch:{ all -> 0x0164 }
            int r3 = r2.hashCode()     // Catch:{ all -> 0x0164 }
            r4 = -566947566(0xffffffffde351112, float:-3.26180735E18)
            if (r3 == r4) goto L_0x011d
            r4 = 3537154(0x35f902, float:4.956608E-39)
            if (r3 == r4) goto L_0x0113
            r4 = 109757523(0x68ac453, float:5.2198303E-35)
            if (r3 == r4) goto L_0x0109
            goto L_0x0127
        L_0x0109:
            java.lang.String r3 = "stare"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0164 }
            if (r2 == 0) goto L_0x0127
            r10 = r13
            goto L_0x0128
        L_0x0113:
            java.lang.String r3 = "spot"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0164 }
            if (r2 == 0) goto L_0x0127
            r10 = 2
            goto L_0x0128
        L_0x011d:
            java.lang.String r3 = "contract"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0164 }
            if (r2 == 0) goto L_0x0127
            r10 = r12
            goto L_0x0128
        L_0x0127:
            r10 = -1
        L_0x0128:
            java.lang.String r2 = "config_collection_market_sec_tab_memory_content"
            java.lang.String r3 = "config_home_collection_index"
            java.lang.String r4 = "user_config"
            if (r10 == 0) goto L_0x0151
            if (r10 == r13) goto L_0x013b
            com.hbg.lib.core.util.ConfigPreferences.k(r4, r3, r12)     // Catch:{ all -> 0x0164 }
            java.lang.String r3 = "100"
            com.hbg.lib.core.util.ConfigPreferences.m(r4, r2, r3)     // Catch:{ all -> 0x0164 }
            goto L_0x0164
        L_0x013b:
            gj.d r5 = gj.d.n()     // Catch:{ all -> 0x0164 }
            boolean r5 = r5.E()     // Catch:{ all -> 0x0164 }
            if (r5 == 0) goto L_0x0147
            r11 = 2
            goto L_0x0148
        L_0x0147:
            r11 = r13
        L_0x0148:
            com.hbg.lib.core.util.ConfigPreferences.k(r4, r3, r11)     // Catch:{ all -> 0x0164 }
            java.lang.String r3 = "101"
            com.hbg.lib.core.util.ConfigPreferences.m(r4, r2, r3)     // Catch:{ all -> 0x0164 }
            goto L_0x0164
        L_0x0151:
            gj.d r5 = gj.d.n()     // Catch:{ all -> 0x0164 }
            boolean r5 = r5.E()     // Catch:{ all -> 0x0164 }
            if (r5 == 0) goto L_0x015c
            r12 = r13
        L_0x015c:
            com.hbg.lib.core.util.ConfigPreferences.k(r4, r3, r12)     // Catch:{ all -> 0x0164 }
            java.lang.String r3 = "104"
            com.hbg.lib.core.util.ConfigPreferences.m(r4, r2, r3)     // Catch:{ all -> 0x0164 }
        L_0x0164:
            android.content.Intent r2 = com.huobi.utils.k0.l(r18)
            r1.startActivity(r2)
            r17.o()
            goto L_0x0930
        L_0x0170:
            java.lang.String r9 = "/trade/index"
            boolean r9 = r9.equals(r6)
            if (r9 == 0) goto L_0x0180
            r0.u(r1, r5)
            r17.o()
            goto L_0x0930
        L_0x0180:
            java.lang.String r9 = "/contract/index"
            boolean r9 = r9.equals(r6)
            if (r9 == 0) goto L_0x0190
            r0.q(r1, r5)
            r17.o()
            goto L_0x0930
        L_0x0190:
            java.lang.String r9 = "/balance/dWRecord"
            boolean r9 = r9.equals(r6)
            if (r9 == 0) goto L_0x01aa
            java.lang.String r2 = "pageType"
            java.lang.String r2 = r5.getQueryParameter(r2)     // Catch:{ all -> 0x01a2 }
            int r13 = java.lang.Integer.parseInt(r2)     // Catch:{ all -> 0x01a2 }
        L_0x01a2:
            com.huobi.finance.ui.DwRecordActivity.Ji(r1, r13)
            r17.o()
            goto L_0x0930
        L_0x01aa:
            java.lang.String r9 = "/balance/index"
            boolean r9 = r9.equals(r6)
            if (r9 == 0) goto L_0x01c9
            tg.r r2 = tg.r.x()
            boolean r2 = r2.F0()
            if (r2 == 0) goto L_0x01c4
            r0.p(r1, r5)
            r17.o()
            goto L_0x0930
        L_0x01c4:
            r17.b(r18)
            goto L_0x0930
        L_0x01c9:
            java.lang.String r9 = "/asset/index"
            boolean r9 = r9.equals(r6)
            if (r9 == 0) goto L_0x01e8
            tg.r r2 = tg.r.x()
            boolean r2 = r2.F0()
            if (r2 == 0) goto L_0x01e3
            r0.r(r1, r5)
            r17.o()
            goto L_0x0930
        L_0x01e3:
            r17.b(r18)
            goto L_0x0930
        L_0x01e8:
            java.lang.String r9 = "/otc/trade"
            boolean r9 = r9.equals(r6)
            if (r9 == 0) goto L_0x01f8
            jp.k0.k(r18)
            r17.o()
            goto L_0x0930
        L_0x01f8:
            java.lang.String r9 = "/account/coupon"
            boolean r9 = r9.equals(r6)
            if (r9 == 0) goto L_0x021e
            tg.r r2 = tg.r.x()
            boolean r2 = r2.F0()
            if (r2 == 0) goto L_0x0219
            android.content.Intent r2 = new android.content.Intent
            java.lang.Class<com.huobi.otc.ui.CouponActivity> r3 = com.huobi.otc.ui.CouponActivity.class
            r2.<init>(r1, r3)
            r1.startActivity(r2)
            r17.o()
            goto L_0x0930
        L_0x0219:
            r17.b(r18)
            goto L_0x0930
        L_0x021e:
            java.lang.String r9 = "/webView/index"
            boolean r9 = r9.equals(r6)
            java.lang.String r14 = "url"
            if (r9 == 0) goto L_0x023a
            java.lang.String r2 = r5.getQueryParameter(r14)
            boolean r3 = com.hbg.lib.router.HbgRouter.e(r2)
            if (r3 == 0) goto L_0x0235
            com.hbg.lib.core.webview.HBBaseWebActivity.showWebView(r1, r2, r8, r8, r12)
        L_0x0235:
            r17.o()
            goto L_0x0930
        L_0x023a:
            java.lang.String r9 = "/Contract/OtcOptions"
            boolean r9 = r9.equals(r6)
            java.lang.String r15 = "symbol"
            if (r9 == 0) goto L_0x025a
            java.lang.String r2 = "source"
            java.lang.String r2 = r5.getQueryParameter(r2)
            java.lang.String r3 = r5.getQueryParameter(r15)
            com.huobi.otcoption.util.OtcOptionsEntryHelper r4 = com.huobi.otcoption.util.OtcOptionsEntryHelper.g()
            r4.h(r1, r8, r2, r3)
            r17.o()
            goto L_0x0930
        L_0x025a:
            java.lang.String r9 = "/balance/convert"
            boolean r9 = r9.equals(r6)
            if (r9 == 0) goto L_0x02ad
            java.lang.String r2 = "currency"
            java.lang.String r2 = r5.getQueryParameter(r2)
            tg.r r3 = tg.r.x()
            boolean r3 = r3.F0()
            if (r3 == 0) goto L_0x02a8
            if (r2 == 0) goto L_0x028f
            java.lang.String r3 = "ht"
            boolean r3 = r2.equalsIgnoreCase(r3)
            if (r3 != 0) goto L_0x0284
            java.lang.String r3 = "htx"
            boolean r3 = r2.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x028f
        L_0x0284:
            android.content.Intent r2 = new android.content.Intent
            java.lang.Class<com.huobi.finance.ui.HtExchangeActivity> r3 = com.huobi.finance.ui.HtExchangeActivity.class
            r2.<init>(r1, r3)
            r1.startActivity(r2)
            goto L_0x02a3
        L_0x028f:
            if (r2 == 0) goto L_0x02a3
            java.lang.String r3 = "usdt"
            boolean r2 = r2.equalsIgnoreCase(r3)
            if (r2 == 0) goto L_0x02a3
            android.content.Intent r2 = new android.content.Intent
            java.lang.Class<com.huobi.finance.ui.UsdtExchangeActivity> r3 = com.huobi.finance.ui.UsdtExchangeActivity.class
            r2.<init>(r1, r3)
            r1.startActivity(r2)
        L_0x02a3:
            r17.o()
            goto L_0x0930
        L_0x02a8:
            r17.b(r18)
            goto L_0x0930
        L_0x02ad:
            java.lang.String r9 = "/market/plateDetail"
            boolean r16 = r9.equals(r6)
            if (r16 == 0) goto L_0x02e2
            java.lang.String r2 = "plateId"
            java.lang.String r3 = r5.getQueryParameter(r2)
            b2.a r4 = b2.a.d()
            com.alibaba.android.arouter.facade.Postcard r4 = r4.a(r9)
            com.alibaba.android.arouter.facade.Postcard r2 = r4.withString(r2, r3)
            r2.navigation(r1)
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.lang.String r2 = "plate_name"
            r1.put(r2, r3)
            com.hbg.lib.core.BaseModuleConfig$a r2 = com.hbg.lib.core.BaseModuleConfig.a()
            java.lang.String r3 = "plate_list_click"
            r2.w(r3, r1)
            r17.o()
            goto L_0x0930
        L_0x02e2:
            java.lang.String r9 = "/setting/tradingSetting"
            boolean r9 = r9.equals(r6)
            if (r9 == 0) goto L_0x02fc
            android.content.Intent r2 = new android.content.Intent
            r2.<init>()
            java.lang.Class<com.huobi.otc.ui.OtcTradeSettingActivity> r3 = com.huobi.otc.ui.OtcTradeSettingActivity.class
            r2.setClass(r1, r3)
            r1.startActivity(r2)
            r17.o()
            goto L_0x0930
        L_0x02fc:
            java.lang.String r9 = "/market/plateList"
            boolean r9 = r9.equals(r6)
            if (r9 == 0) goto L_0x032e
            android.content.Intent r2 = new android.content.Intent
            r2.<init>()
            java.lang.Class<com.huobi.activity.ContainerFlutterActivity> r3 = com.huobi.activity.ContainerFlutterActivity.class
            r2.setClass(r1, r3)
            android.os.Bundle r3 = new android.os.Bundle
            r3.<init>()
            java.lang.String r4 = "class_name"
            java.lang.String r5 = "market_platelist"
            r3.putString(r4, r5)
            r2.putExtras(r3)
            r1.startActivity(r2)
            com.hbg.lib.core.BaseModuleConfig$a r1 = com.hbg.lib.core.BaseModuleConfig.a()
            java.lang.String r2 = "plate_list_view"
            r1.w(r2, r8)
            r17.o()
            goto L_0x0930
        L_0x032e:
            java.lang.String r9 = "/balance/withdraw"
            boolean r9 = r9.equals(r6)
            java.lang.String r10 = "coin"
            if (r9 == 0) goto L_0x0346
            java.lang.String r2 = r5.getQueryParameter(r10)
            com.hbg.lib.data.symbol.TradeType r3 = com.hbg.lib.data.symbol.TradeType.PRO
            com.huobi.finance.ui.UnifyWithdrawActivity.Di(r1, r2, r3)
            r17.o()
            goto L_0x0930
        L_0x0346:
            java.lang.String r9 = "/balance/deposit"
            boolean r9 = r9.equals(r6)
            if (r9 == 0) goto L_0x035a
            java.lang.String r2 = r5.getQueryParameter(r10)
            com.huobi.finance.ui.UnifyDepositActivity.wh(r1, r2)
            r17.o()
            goto L_0x0930
        L_0x035a:
            java.lang.String r9 = "/kline/index"
            boolean r10 = r9.equals(r6)
            if (r10 == 0) goto L_0x0378
            java.lang.String r2 = r5.getQueryParameter(r15)
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L_0x0373
            com.hbg.lib.data.symbol.TradeType r3 = com.hbg.lib.data.symbol.TradeType.getTradeTypeBySymbol(r2)
            sn.f.E(r1, r2, r12, r12, r3)
        L_0x0373:
            r17.o()
            goto L_0x0930
        L_0x0378:
            java.lang.String r10 = "/market/content"
            boolean r10 = r10.equals(r6)
            java.lang.String r15 = "navigator_action"
            java.lang.String r11 = "type"
            if (r10 == 0) goto L_0x03b9
            java.lang.String r2 = r5.getQueryParameter(r11)
            java.lang.String r3 = "category"
            java.lang.String r5 = r5.getQueryParameter(r3)
            android.content.Intent r6 = new android.content.Intent
            r6.<init>(r1, r4)
            java.lang.String r4 = "pro.huobi.markets"
            android.content.Intent r4 = r6.putExtra(r15, r4)
            java.lang.String r6 = "typeView"
            android.content.Intent r2 = r4.putExtra(r6, r2)
            android.content.Intent r2 = r2.putExtra(r3, r5)
            java.lang.String r3 = "isFromJump"
            android.content.Intent r2 = r2.putExtra(r3, r13)
            android.os.Bundle r3 = new android.os.Bundle
            r3.<init>()
            r2.putExtras(r3)
            r1.startActivity(r2)
            r17.o()
            goto L_0x0930
        L_0x03b9:
            java.lang.String r10 = "/home/ReplaceFunction"
            boolean r10 = r10.equals(r6)
            if (r10 == 0) goto L_0x03e5
            java.lang.String r2 = "title"
            java.lang.String r2 = r5.getQueryParameter(r2)
            java.lang.String r3 = "imgUrl"
            java.lang.String r3 = r5.getQueryParameter(r3)
            java.lang.String r4 = "moduleId"
            r5.getQueryParameter(r4)
            java.lang.String r4 = "moduleContentId"
            r5.getQueryParameter(r4)
            java.lang.String r4 = "groupCode"
            java.lang.String r4 = r5.getQueryParameter(r4)
            n(r1, r2, r3, r4)
            r17.o()
            goto L_0x0930
        L_0x03e5:
            java.lang.String r10 = "/live/List"
            boolean r10 = r10.equals(r6)
            if (r10 == 0) goto L_0x03fb
            r2 = 40
            android.content.Intent r2 = com.huobi.utils.k0.m(r1, r2)
            r1.startActivity(r2)
            r17.o()
            goto L_0x0930
        L_0x03fb:
            java.lang.String r10 = "/market/newflashDetail"
            boolean r10 = r10.equals(r6)
            if (r10 == 0) goto L_0x041e
            java.lang.String r2 = "newflashId"
            java.lang.String r2 = r5.getQueryParameter(r2)
            android.content.Intent r3 = new android.content.Intent
            java.lang.Class<com.hbg.module.content.ui.activity.NewsDetailActivity> r4 = com.hbg.module.content.ui.activity.NewsDetailActivity.class
            r3.<init>(r1, r4)
            java.lang.String r4 = "newflashId"
            android.content.Intent r2 = r3.putExtra(r4, r2)
            r1.startActivity(r2)
            r17.o()
            goto L_0x0930
        L_0x041e:
            java.lang.String r10 = "/market/newsDetail"
            boolean r10 = r10.equals(r6)
            if (r10 == 0) goto L_0x0457
            java.lang.String r2 = "newsId"
            java.lang.String r2 = r5.getQueryParameter(r2)
            android.content.Intent r3 = new android.content.Intent
            java.lang.Class<com.hbg.lib.core.webview.HBBaseWebActivity> r4 = com.hbg.lib.core.webview.HBBaseWebActivity.class
            r3.<init>(r1, r4)
            com.hbg.lib.core.BaseModuleConfig$a r4 = com.hbg.lib.core.BaseModuleConfig.a()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "pretender/news-detail-long?id="
            r5.append(r6)
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            java.lang.String r2 = r4.k(r2)
            r3.putExtra(r14, r2)
            r1.startActivity(r3)
            r17.o()
            goto L_0x0930
        L_0x0457:
            java.lang.String r10 = "/account/order"
            boolean r10 = r10.equals(r6)
            if (r10 == 0) goto L_0x0477
            android.content.Intent r2 = new android.content.Intent
            java.lang.Class<com.huobi.account.ui.AccountOrderManageActivity> r3 = com.huobi.account.ui.AccountOrderManageActivity.class
            r2.<init>(r1, r3)
            rn.c r3 = rn.c.i()
            com.huobi.login.bean.JumpTarget r4 = new com.huobi.login.bean.JumpTarget
            r4.<init>(r2, r8)
            r3.d(r1, r4)
            r17.o()
            goto L_0x0930
        L_0x0477:
            java.lang.String r10 = "/market/realTimeReminder"
            boolean r10 = r10.equals(r6)
            if (r10 == 0) goto L_0x0487
            com.hbg.module.market.widget.ui.MarketWidgetSettingActivity.vh(r18)
            r17.o()
            goto L_0x0930
        L_0x0487:
            java.lang.String r10 = "/reminder/all"
            boolean r10 = r10.equals(r6)
            if (r10 == 0) goto L_0x04a4
            android.content.Intent r2 = com.huobi.staring.ui.AllRemindNewActivity.Og(r18)
            rn.c r3 = rn.c.i()
            com.huobi.login.bean.JumpTarget r4 = new com.huobi.login.bean.JumpTarget
            r4.<init>(r2, r8)
            r3.d(r1, r4)
            r17.o()
            goto L_0x0930
        L_0x04a4:
            java.lang.String r10 = "/account/dominicaKyc"
            boolean r10 = r10.equals(r6)
            if (r10 == 0) goto L_0x04cb
            java.lang.String r2 = r5.getQueryParameter(r11)
            android.content.Intent r3 = new android.content.Intent
            java.lang.Class<com.huobi.account.ui.DominicaKycPageActivity> r4 = com.huobi.account.ui.DominicaKycPageActivity.class
            r3.<init>(r1, r4)
            r3.putExtra(r11, r2)
            rn.c r2 = rn.c.i()
            com.huobi.login.bean.JumpTarget r4 = new com.huobi.login.bean.JumpTarget
            r4.<init>(r3, r8)
            r2.d(r1, r4)
            r17.o()
            goto L_0x0930
        L_0x04cb:
            java.lang.String r10 = "/account/chatGroup"
            boolean r10 = r10.equals(r6)
            if (r10 == 0) goto L_0x04fb
            b2.a r2 = b2.a.d()
            java.lang.String r4 = "/provider/content"
            com.alibaba.android.arouter.facade.Postcard r2 = r2.a(r4)
            java.lang.Object r2 = r2.navigation()
            com.hbg.module.libkt.provider.HbgBaseProvider r2 = (com.hbg.module.libkt.provider.HbgBaseProvider) r2
            if (r3 == 0) goto L_0x04f1
            boolean r2 = r2.j(r1)
            if (r2 == 0) goto L_0x04f6
            dd.b r2 = dd.b.f22740a
            r2.g(r1)
            goto L_0x04f6
        L_0x04f1:
            dd.b r2 = dd.b.f22740a
            r2.g(r1)
        L_0x04f6:
            r17.o()
            goto L_0x0930
        L_0x04fb:
            java.lang.String r10 = "/thirdOrderResult"
            boolean r10 = r10.equals(r6)
            if (r10 == 0) goto L_0x0515
            android.content.Intent r2 = com.huobi.utils.k0.q(r18)
            r2.setData(r5)
            r1.startActivity(r2)
            r17.o()
            r18.finish()
            goto L_0x0930
        L_0x0515:
            java.lang.String r10 = "/im/groupchat"
            boolean r10 = r10.equals(r6)
            if (r10 == 0) goto L_0x055b
            b2.a r3 = b2.a.d()
            java.lang.String r4 = "/provider/content"
            com.alibaba.android.arouter.facade.Postcard r3 = r3.a(r4)
            java.lang.Object r3 = r3.navigation()
            com.hbg.module.libkt.provider.HbgBaseProvider r3 = (com.hbg.module.libkt.provider.HbgBaseProvider) r3
            boolean r3 = r3.j(r1)
            if (r3 == 0) goto L_0x0556
            java.lang.String r3 = "groupId"
            java.lang.String r3 = r0.e(r2, r3)
            boolean r4 = com.hbg.module.libkt.base.ext.b.x(r3)
            if (r4 == 0) goto L_0x0545
            java.lang.String r3 = "chatId"
            java.lang.String r3 = r0.e(r2, r3)
        L_0x0545:
            java.lang.String r4 = "title"
            java.lang.String r4 = r0.e(r2, r4)
            java.lang.String r5 = "messageId"
            java.lang.String r2 = r0.e(r2, r5)
            dd.b r5 = dd.b.f22740a
            r5.j(r1, r3, r4, r2)
        L_0x0556:
            r17.o()
            goto L_0x0930
        L_0x055b:
            java.lang.String r10 = "/login/register_v2"
            boolean r10 = r10.equals(r6)
            if (r10 == 0) goto L_0x0582
            boolean r10 = wn.c0.h()
            if (r10 == 0) goto L_0x0582
            android.content.Intent r2 = new android.content.Intent
            java.lang.Class<com.huobi.login.v3.ui.UserRegisterActivityV3> r3 = com.huobi.login.v3.ui.UserRegisterActivityV3.class
            r2.<init>(r1, r3)
            com.huobi.login.bean.JumpTarget r3 = new com.huobi.login.bean.JumpTarget
            r3.<init>(r8, r8)
            java.lang.String r4 = "target"
            r2.putExtra(r4, r3)
            r1.startActivity(r2)
            r17.o()
            goto L_0x0930
        L_0x0582:
            java.lang.String r10 = "/login/index"
            boolean r10 = r10.equals(r6)
            if (r10 == 0) goto L_0x05ab
            java.lang.String r2 = "jumpType"
            java.lang.String r2 = r5.getQueryParameter(r2)
            java.lang.String r3 = "2"
            boolean r2 = java.util.Objects.equals(r2, r3)
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            rn.c r3 = rn.c.i()
            com.huobi.login.bean.JumpTarget r4 = new com.huobi.login.bean.JumpTarget
            r4.<init>(r8, r8)
            r3.n(r1, r4, r2, r12)
            r17.o()
            goto L_0x0930
        L_0x05ab:
            java.lang.String r10 = "/Contract/CopyTrading"
            boolean r10 = r10.equals(r6)
            if (r10 == 0) goto L_0x05d8
            java.lang.String r2 = "index"
            java.lang.String r2 = r5.getQueryParameter(r2)
            java.lang.String r3 = "detailId"
            java.lang.String r3 = r5.getQueryParameter(r3)
            android.content.Intent r4 = new android.content.Intent
            java.lang.Class<com.huobi.copytrading.ui.CopyTradingMainActivity> r5 = com.huobi.copytrading.ui.CopyTradingMainActivity.class
            r4.<init>(r1, r5)
            java.lang.String r5 = "index"
            r4.putExtra(r5, r2)
            java.lang.String r2 = "detailId"
            r4.putExtra(r2, r3)
            r1.startActivity(r4)
            r17.o()
            goto L_0x0930
        L_0x05d8:
            java.lang.String r10 = "/trade/bot"
            boolean r10 = r10.equals(r6)
            if (r10 == 0) goto L_0x060b
            android.content.Intent r2 = new android.content.Intent
            java.lang.Class<com.huobi.tradingbot.ui.TradingBotActivity> r3 = com.huobi.tradingbot.ui.TradingBotActivity.class
            r2.<init>(r1, r3)
            java.util.Set r3 = r5.getQueryParameterNames()     // Catch:{ all -> 0x0603 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0603 }
        L_0x05ef:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x0603 }
            if (r4 == 0) goto L_0x0603
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x0603 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0603 }
            java.lang.String r6 = r5.getQueryParameter(r4)     // Catch:{ all -> 0x0603 }
            r2.putExtra(r4, r6)     // Catch:{ all -> 0x0603 }
            goto L_0x05ef
        L_0x0603:
            r1.startActivity(r2)
            r17.o()
            goto L_0x0930
        L_0x060b:
            java.lang.String r10 = "/trade/contractGrid"
            boolean r10 = r10.equals(r6)
            if (r10 == 0) goto L_0x0647
            android.content.Intent r2 = new android.content.Intent
            java.lang.Class<com.huobi.tradingbot.ui.ContractGridActivity> r3 = com.huobi.tradingbot.ui.ContractGridActivity.class
            r2.<init>(r1, r3)
            java.util.Set r3 = r5.getQueryParameterNames()     // Catch:{ all -> 0x0636 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0636 }
        L_0x0622:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x0636 }
            if (r4 == 0) goto L_0x0636
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x0636 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0636 }
            java.lang.String r6 = r5.getQueryParameter(r4)     // Catch:{ all -> 0x0636 }
            r2.putExtra(r4, r6)     // Catch:{ all -> 0x0636 }
            goto L_0x0622
        L_0x0636:
            rn.c r3 = rn.c.i()
            com.huobi.login.bean.JumpTarget r4 = new com.huobi.login.bean.JumpTarget
            r4.<init>(r2, r8)
            r3.d(r1, r4)
            r17.o()
            goto L_0x0930
        L_0x0647:
            java.lang.String r10 = "/trade/contractBotDetail"
            boolean r10 = r10.equals(r6)
            if (r10 == 0) goto L_0x0683
            android.content.Intent r2 = new android.content.Intent
            java.lang.Class<com.huobi.tradingbot.ui.BotDetailActivity> r3 = com.huobi.tradingbot.ui.BotDetailActivity.class
            r2.<init>(r1, r3)
            java.util.Set r3 = r5.getQueryParameterNames()     // Catch:{ all -> 0x0672 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0672 }
        L_0x065e:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x0672 }
            if (r4 == 0) goto L_0x0672
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x0672 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0672 }
            java.lang.String r6 = r5.getQueryParameter(r4)     // Catch:{ all -> 0x0672 }
            r2.putExtra(r4, r6)     // Catch:{ all -> 0x0672 }
            goto L_0x065e
        L_0x0672:
            rn.c r3 = rn.c.i()
            com.huobi.login.bean.JumpTarget r4 = new com.huobi.login.bean.JumpTarget
            r4.<init>(r2, r8)
            r3.d(r1, r4)
            r17.o()
            goto L_0x0930
        L_0x0683:
            java.lang.String r10 = "/trade/botCompletion"
            boolean r10 = r10.equals(r6)
            if (r10 == 0) goto L_0x06bf
            android.content.Intent r2 = new android.content.Intent
            java.lang.Class<com.huobi.tradingbot.ui.BotCompleteActivity> r3 = com.huobi.tradingbot.ui.BotCompleteActivity.class
            r2.<init>(r1, r3)
            java.util.Set r3 = r5.getQueryParameterNames()     // Catch:{ all -> 0x06ae }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x06ae }
        L_0x069a:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x06ae }
            if (r4 == 0) goto L_0x06ae
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x06ae }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x06ae }
            java.lang.String r6 = r5.getQueryParameter(r4)     // Catch:{ all -> 0x06ae }
            r2.putExtra(r4, r6)     // Catch:{ all -> 0x06ae }
            goto L_0x069a
        L_0x06ae:
            rn.c r3 = rn.c.i()
            com.huobi.login.bean.JumpTarget r4 = new com.huobi.login.bean.JumpTarget
            r4.<init>(r2, r8)
            r3.d(r1, r4)
            r17.o()
            goto L_0x0930
        L_0x06bf:
            java.lang.String r10 = "/Contract/CopyTrading_TraderInfo"
            boolean r10 = r10.equals(r6)
            if (r10 == 0) goto L_0x06e1
            java.lang.String r2 = "userSign"
            java.lang.String r2 = r5.getQueryParameter(r2)
            android.content.Intent r3 = new android.content.Intent
            java.lang.Class<com.huobi.copytrading.ui.CopyTradingTraderInfoActivity> r4 = com.huobi.copytrading.ui.CopyTradingTraderInfoActivity.class
            r3.<init>(r1, r4)
            java.lang.String r4 = "userSign"
            r3.putExtra(r4, r2)
            r1.startActivity(r3)
            r17.o()
            goto L_0x0930
        L_0x06e1:
            java.lang.String r10 = "/edgeengine/page"
            boolean r10 = r10.equals(r6)
            if (r10 == 0) goto L_0x071d
            android.content.Intent r2 = new android.content.Intent
            java.lang.Class<com.huobi.edgeengine.ui.EdgeEnginePageActivity> r3 = com.huobi.edgeengine.ui.EdgeEnginePageActivity.class
            r2.<init>(r1, r3)
            java.util.Set r3 = r5.getQueryParameterNames()
            java.util.Iterator r3 = r3.iterator()
        L_0x06f8:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x070c
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r6 = r5.getQueryParameter(r4)
            r2.putExtra(r4, r6)
            goto L_0x06f8
        L_0x070c:
            rn.c r3 = rn.c.i()
            com.huobi.login.bean.JumpTarget r4 = new com.huobi.login.bean.JumpTarget
            r4.<init>(r2, r8)
            r3.d(r1, r4)
            r17.o()
            goto L_0x0930
        L_0x071d:
            java.lang.String r10 = "/edgeengine/container"
            boolean r10 = r10.equals(r6)
            if (r10 == 0) goto L_0x075f
            android.content.Intent r2 = new android.content.Intent
            java.lang.Class<com.huobi.edgeengine.ui.EdgeEngineContainerActivity> r4 = com.huobi.edgeengine.ui.EdgeEngineContainerActivity.class
            r2.<init>(r1, r4)
            java.util.Set r4 = r5.getQueryParameterNames()
            java.util.Iterator r4 = r4.iterator()
        L_0x0734:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x0748
            java.lang.Object r6 = r4.next()
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r7 = r5.getQueryParameter(r6)
            r2.putExtra(r6, r7)
            goto L_0x0734
        L_0x0748:
            if (r3 == 0) goto L_0x0757
            rn.c r3 = rn.c.i()
            com.huobi.login.bean.JumpTarget r4 = new com.huobi.login.bean.JumpTarget
            r4.<init>(r2, r8)
            r3.d(r1, r4)
            goto L_0x075a
        L_0x0757:
            r1.startActivity(r2)
        L_0x075a:
            r17.o()
            goto L_0x0930
        L_0x075f:
            java.lang.String r10 = "/contract/activityZero"
            boolean r10 = r10.equals(r6)
            if (r10 == 0) goto L_0x07b1
            boolean r2 = com.hbg.lib.core.util.p.f(r18)
            if (r2 == 0) goto L_0x0775
            gj.d r2 = gj.d.n()
            boolean r13 = r2.E()
        L_0x0775:
            if (r13 == 0) goto L_0x07ac
            android.content.Intent r2 = new android.content.Intent
            java.lang.Class<com.huobi.zeroswap.ui.ZeroSwapActivity> r4 = com.huobi.zeroswap.ui.ZeroSwapActivity.class
            r2.<init>(r1, r4)
            java.util.Set r4 = r5.getQueryParameterNames()
            java.util.Iterator r4 = r4.iterator()
        L_0x0786:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x079a
            java.lang.Object r6 = r4.next()
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r7 = r5.getQueryParameter(r6)
            r2.putExtra(r6, r7)
            goto L_0x0786
        L_0x079a:
            if (r3 == 0) goto L_0x07a9
            rn.c r3 = rn.c.i()
            com.huobi.login.bean.JumpTarget r4 = new com.huobi.login.bean.JumpTarget
            r4.<init>(r2, r8)
            r3.d(r1, r4)
            goto L_0x07ac
        L_0x07a9:
            r1.startActivity(r2)
        L_0x07ac:
            r17.o()
            goto L_0x0930
        L_0x07b1:
            java.lang.String r10 = "/account/logUpload"
            boolean r10 = r10.equals(r6)
            if (r10 == 0) goto L_0x07c7
            r0.f85091b = r7
            android.content.Intent r2 = new android.content.Intent
            java.lang.Class<com.huobi.account.ui.FeedbackActivity> r3 = com.huobi.account.ui.FeedbackActivity.class
            r2.<init>(r1, r3)
            r1.startActivity(r2)
            goto L_0x0930
        L_0x07c7:
            java.lang.String r7 = "/Account/ApiManage"
            boolean r7 = r7.equals(r6)
            if (r7 == 0) goto L_0x07fc
            tg.r r2 = tg.r.x()
            boolean r2 = r2.F0()
            if (r2 == 0) goto L_0x07e4
            android.content.Intent r2 = new android.content.Intent
            java.lang.Class<com.huobi.activity.ApiManagerActivity> r3 = com.huobi.activity.ApiManagerActivity.class
            r2.<init>(r1, r3)
            r1.startActivity(r2)
            goto L_0x07f7
        L_0x07e4:
            rn.c r2 = rn.c.i()
            com.huobi.login.bean.JumpTarget r3 = new com.huobi.login.bean.JumpTarget
            android.content.Intent r4 = new android.content.Intent
            java.lang.Class<com.huobi.activity.ApiManagerActivity> r5 = com.huobi.activity.ApiManagerActivity.class
            r4.<init>(r1, r5)
            r3.<init>(r4, r8)
            r2.d(r1, r3)
        L_0x07f7:
            r17.o()
            goto L_0x0930
        L_0x07fc:
            java.lang.String r7 = "/content/redPacket"
            boolean r6 = r7.equals(r6)
            if (r6 == 0) goto L_0x0913
            java.lang.String r2 = "topicId"
            java.lang.String r2 = r5.getQueryParameter(r2)
            java.lang.String r3 = "topicType"
            java.lang.String r5 = r5.getQueryParameter(r3)
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            r5.hashCode()
            int r7 = r5.hashCode()
            switch(r7) {
                case 52: goto L_0x0842;
                case 1598: goto L_0x0837;
                case 1602: goto L_0x082c;
                case 1606: goto L_0x0821;
                default: goto L_0x081f;
            }
        L_0x081f:
            r10 = -1
            goto L_0x084c
        L_0x0821:
            java.lang.String r7 = "28"
            boolean r5 = r5.equals(r7)
            if (r5 != 0) goto L_0x082a
            goto L_0x081f
        L_0x082a:
            r10 = 3
            goto L_0x084c
        L_0x082c:
            java.lang.String r7 = "24"
            boolean r5 = r5.equals(r7)
            if (r5 != 0) goto L_0x0835
            goto L_0x081f
        L_0x0835:
            r10 = 2
            goto L_0x084c
        L_0x0837:
            java.lang.String r7 = "20"
            boolean r5 = r5.equals(r7)
            if (r5 != 0) goto L_0x0840
            goto L_0x081f
        L_0x0840:
            r10 = r13
            goto L_0x084c
        L_0x0842:
            java.lang.String r7 = "4"
            boolean r5 = r5.equals(r7)
            if (r5 != 0) goto L_0x084b
            goto L_0x081f
        L_0x084b:
            r10 = r12
        L_0x084c:
            switch(r10) {
                case 0: goto L_0x08f2;
                case 1: goto L_0x08dd;
                case 2: goto L_0x08b0;
                case 3: goto L_0x0851;
                default: goto L_0x084f;
            }
        L_0x084f:
            goto L_0x090d
        L_0x0851:
            java.lang.String r4 = "28"
            r6.put(r3, r4)
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L_0x08ac
            com.hbg.lib.data.symbol.TradeType r3 = com.hbg.lib.data.symbol.TradeType.getTradeTypeBySymbol(r2)
            com.hbg.lib.data.symbol.TradeType r4 = com.hbg.lib.data.symbol.TradeType.getTradeTypeBySymbol(r2)
            android.content.Intent r4 = sn.f.o(r1, r2, r12, r12, r4)
            if (r4 == 0) goto L_0x08ac
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            d7.a1 r5 = d7.a1.v()
            java.lang.String r5 = r5.X(r2, r3)
            java.lang.String r7 = "symbolId"
            r4.putString(r7, r2)
            d7.a1 r2 = d7.a1.v()
            boolean r2 = r2.N(r5)
            java.lang.String r7 = "market_is_hadax"
            r4.getBoolean(r7, r2)
            d7.a1 r2 = d7.a1.v()
            boolean r2 = r2.T(r5)
            java.lang.String r7 = "market_is_st"
            r4.getBoolean(r7, r2)
            java.lang.String r2 = "market_title"
            r4.putString(r2, r5)
            java.lang.String r2 = r3.toString()
            java.lang.String r3 = "market_trade_type"
            r4.putString(r3, r2)
            java.lang.String r2 = "airdrop"
            r4.putBoolean(r2, r13)
            com.hbg.lib.router.HbgRouter.i(r1, r9, r4)
        L_0x08ac:
            r17.o()
            goto L_0x090d
        L_0x08b0:
            java.lang.String r2 = "24"
            r6.put(r3, r2)
            android.content.Intent r2 = new android.content.Intent
            r2.<init>(r1, r4)
            java.lang.String r3 = "pro.huobi.markets"
            android.content.Intent r2 = r2.putExtra(r15, r3)
            java.lang.String r3 = "typeView"
            java.lang.String r4 = "5"
            android.content.Intent r2 = r2.putExtra(r3, r4)
            java.lang.String r3 = "isFromJump"
            android.content.Intent r2 = r2.putExtra(r3, r13)
            android.os.Bundle r3 = new android.os.Bundle
            r3.<init>()
            r2.putExtras(r3)
            r1.startActivity(r2)
            r17.o()
            goto L_0x090d
        L_0x08dd:
            java.lang.String r2 = "20"
            r6.put(r3, r2)
            android.content.Intent r2 = com.huobi.utils.k0.h(r18)
            java.lang.String r3 = "airdrop"
            r2.putExtra(r3, r13)
            r1.startActivity(r2)
            r17.o()
            goto L_0x090d
        L_0x08f2:
            java.lang.String r1 = "4"
            r6.put(r3, r1)
            b2.a r1 = b2.a.d()
            java.lang.String r3 = "/content/DynamicDetail"
            com.alibaba.android.arouter.facade.Postcard r1 = r1.a(r3)
            java.lang.String r3 = "dynamicId"
            com.alibaba.android.arouter.facade.Postcard r1 = r1.withString(r3, r2)
            r1.navigation()
            r17.o()
        L_0x090d:
            java.lang.String r1 = "app_community_airdrop_share_return_show"
            gs.g.g(r1, r6)
            goto L_0x0930
        L_0x0913:
            if (r3 == 0) goto L_0x092a
            tg.r r3 = tg.r.x()
            boolean r3 = r3.F0()
            if (r3 == 0) goto L_0x0926
            com.hbg.lib.router.HbgRouter.j(r18, r19)
            r17.o()
            goto L_0x0930
        L_0x0926:
            r17.b(r18)
            goto L_0x0930
        L_0x092a:
            com.hbg.lib.router.HbgRouter.j(r18, r19)
            r17.o()
        L_0x0930:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: zn.a.l(android.app.Activity, java.lang.String, boolean):void");
    }

    public void m(Activity activity, Uri uri) {
        String uri2 = uri.toString();
        if (!TextUtils.isEmpty(uri2) && uri2.startsWith("huobicard")) {
            Intent q11 = k0.q(activity);
            q11.setData(uri);
            activity.startActivity(q11);
            o();
            activity.finish();
        }
    }

    public final void o() {
        this.f85091b = null;
        this.f85090a = true;
        this.f85092c = false;
        this.f85093d = false;
    }

    public final void p(Context context, Uri uri) {
        String str = this.f85094e.get(uri.getQueryParameter("type"));
        if (TextUtils.isEmpty(str)) {
            str = "total_balance_type_balance";
        }
        if (!f.h().l()) {
            Intent c11 = k0.c(context);
            Bundle bundle = new Bundle();
            bundle.putString("total_balance_type", str);
            c11.putExtras(bundle);
            context.startActivity(c11);
        } else if (context instanceof Activity) {
            d().k((Activity) context, str);
        }
    }

    public final void q(Context context, Uri uri) {
        TradeType tradeType;
        int i11 = 1;
        if (p.f(context) ? gj.d.n().E() : true) {
            String queryParameter = uri.getQueryParameter("code");
            String queryParameter2 = uri.getQueryParameter("isCross");
            Bundle bundle = new Bundle();
            bundle.putString("type", uri.getQueryParameter("type"));
            int i12 = -1;
            if (!TextUtils.isEmpty(queryParameter2)) {
                try {
                    if (Double.parseDouble(queryParameter2) != 1.0d) {
                        i11 = 2;
                    }
                    i12 = i11;
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
            if (!TextUtils.isEmpty(queryParameter)) {
                tradeType = FutureTypeUtil.a((String) null, queryParameter, (String) null);
            } else if (n0.a() == 0) {
                tradeType = TradeType.LINEAR_SWAP;
            } else {
                tradeType = ContractUserInfoProvider.i().j();
            }
            if (TradeType.isContract(tradeType)) {
                ContractTradeBaseFragment.Ti(context, ContractCurrencyUtils.b(queryParameter), bundle);
            } else if (TradeType.isSwap(tradeType)) {
                SwapTradeBaseFragment.Si(context, SwapCurrencyInfoController.k().q(queryParameter), bundle);
            } else if (TradeType.isLinearSwap(tradeType)) {
                LinearSwapTradeBaseFragment.Nj(context, FutureContractInfoController.n().o(queryParameter), i12, bundle);
            }
        }
    }

    public final void r(Context context, Uri uri) {
        Intent c11 = k0.c(context);
        c11.putExtras(new Bundle());
        context.startActivity(c11);
    }

    public void s(Activity activity, String str) {
        t(activity, str, (String) null);
    }

    public void t(Activity activity, String str, String str2) {
        if (activity != null) {
            Intent intent = new Intent(activity, Asset2Activity.class);
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra("ASSET_ACCOUNT_TYPE", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                intent.putExtra("ASSET_SUMMARY_ACCOUNT_TYPE", str2);
            }
            c.i().d(activity, new JumpTarget(intent, (Intent) null));
        }
    }

    public final void u(Context context, Uri uri) {
        String queryParameter = uri.getQueryParameter("type");
        String queryParameter2 = uri.getQueryParameter("symbol");
        String queryParameter3 = uri.getQueryParameter("backFirstLevelPage");
        if (TextUtils.equals(queryParameter, "pro")) {
            k0.O(context, queryParameter2, true);
        } else if (TextUtils.equals(queryParameter, "margin")) {
            k0.M(queryParameter2, queryParameter3, true, context);
        } else if (TextUtils.equals(queryParameter, "super_margin")) {
            k0.R(queryParameter2, queryParameter3, true, context);
        } else if (TextUtils.equals(queryParameter, V2TIMConversation.CONVERSATION_C2C_TYPE)) {
            k0.J(context, queryParameter2, true);
        } else if (TextUtils.equals(queryParameter, "c2c_lend")) {
            k0.K(context, queryParameter2);
        }
    }

    public a v(Uri uri) {
        if (uri != null) {
            String scheme = uri.getScheme();
            String host = uri.getHost();
            String path = uri.getPath();
            d.b("tryPushJumpUrl scheme = " + scheme + "；host = " + host + "； path = " + path);
            if (j(uri)) {
                StringBuilder sb2 = new StringBuilder(uri.getQueryParameter("url"));
                for (String next : uri.getQueryParameterNames()) {
                    String queryParameter = uri.getQueryParameter(next);
                    if (!TextUtils.isEmpty(queryParameter) && !TextUtils.equals("url", next)) {
                        if (!sb2.toString().contains("?")) {
                            sb2.append("?");
                            sb2.append(next);
                            sb2.append(ContainerUtils.KEY_VALUE_DELIMITER);
                            sb2.append(queryParameter);
                        } else {
                            sb2.append(ContainerUtils.FIELD_DELIMITER);
                            sb2.append(next);
                            sb2.append(ContainerUtils.KEY_VALUE_DELIMITER);
                            sb2.append(queryParameter);
                        }
                    }
                }
                this.f85091b = sb2.toString();
                this.f85092c = TextUtils.equals(uri.getQueryParameter(FirebaseAnalytics.Event.LOGIN), "1");
            } else if (scheme != null && scheme.startsWith("http")) {
                this.f85091b = uri.toString();
                this.f85092c = TextUtils.equals(uri.getQueryParameter(FirebaseAnalytics.Event.LOGIN), "1");
            }
        }
        return this;
    }
}
