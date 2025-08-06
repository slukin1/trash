package yl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import com.blankj.utilcode.util.x;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.google.gson.Gson;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.HomePageEarnData;
import com.hbg.lib.network.hbg.core.bean.HomePageJumpData;
import com.hbg.lib.network.hbg.core.util.MgtConfigNumber;
import com.hbg.lib.network.hbg.integration.IntegrationConfig;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.router.HbgRouter;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.community.ui.DynamicDetailActivity;
import com.hbg.module.community.ui.PersonalCenterActivity;
import com.hbg.module.content.ui.activity.CommentDetailActivity;
import com.hbg.module.content.ui.activity.NewsDetailActivity;
import com.hbg.module.exchange.grid.ui.GridTradeActivity;
import com.hbg.module.otc.OtcModuleConfig;
import com.huobi.account.ui.SecuritySetActivity;
import com.huobi.apm.TimeMonitorManager;
import com.huobi.finance.ui.CurrencySearchActivity;
import com.huobi.finance.ui.UnifyTransferActivity;
import com.huobi.index.bean.IndexFeatureItem;
import com.huobi.integration.IntegrationActivity;
import com.huobi.invite.ui.InviteActivity;
import com.huobi.login.bean.JumpTarget;
import com.huobi.notice.NoticeActivity;
import com.huobi.operation.MoreOperationActivity;
import com.huobi.otc.enums.OtcTradeAreaEnum;
import com.huobi.otc.ui.CouponActivity;
import com.huobi.otc.ui.OtcTradeActivity;
import com.huobi.otcoption.util.OtcOptionsEntryHelper;
import com.huobi.store.AppConfigManager;
import com.huobi.utils.a0;
import com.huobi.utils.k0;
import com.huobi.view.CurrencyIntroWebActivity;
import com.huochat.community.base.CommunityConstants;
import com.iproov.sdk.bridge.OptionsBridge;
import i6.k;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.HashMap;
import jp.c1;
import org.json.JSONObject;
import pro.huobi.R;
import q6.d;
import rn.c;
import sn.f;
import tg.r;
import u6.g;
import v7.b;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    public static int f76853a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f76854b = false;

    public class a extends d<IntegrationConfig> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f76855e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(g gVar, boolean z11, Activity activity) {
            super(gVar, z11);
            this.f76855e = activity;
        }

        /* renamed from: f */
        public void onNext(IntegrationConfig integrationConfig) {
            if (integrationConfig.isDisplay()) {
                this.f76855e.startActivity(new Intent(this.f76855e, IntegrationActivity.class));
                return;
            }
            HuobiToastUtil.j(R.string.integration_coming_soon);
        }

        public void onError2(Throwable th2) {
            th2.printStackTrace();
            k.g("IndexHelper", "GO_INTEGRATION", th2);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            aPIStatusErrorException.printStackTrace();
            k.g("IndexHelper", "GO_INTEGRATION", aPIStatusErrorException);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0099 A[SYNTHETIC, Splitter:B:26:0x0099] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a1 A[Catch:{ Exception -> 0x009d }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b4 A[SYNTHETIC, Splitter:B:38:0x00b4] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00bc A[Catch:{ Exception -> 0x00b8 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String A(java.lang.String r10) {
        /*
            java.lang.String r0 = "--"
            java.lang.String r1 = "getIndexCacheFromLocalJson "
            java.lang.String r2 = "IndexHelper"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "index/"
            r3.append(r4)
            r3.append(r10)
            java.lang.String r10 = r3.toString()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            android.app.Application r4 = bh.j.c()
            android.content.res.AssetManager r4 = r4.getAssets()
            r5 = 0
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0074, all -> 0x0071 }
            java.io.InputStream r4 = r4.open(r10)     // Catch:{ IOException -> 0x0074, all -> 0x0071 }
            java.lang.String r7 = "utf-8"
            r6.<init>(r4, r7)     // Catch:{ IOException -> 0x0074, all -> 0x0071 }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ IOException -> 0x006c, all -> 0x006a }
            r4.<init>(r6)     // Catch:{ IOException -> 0x006c, all -> 0x006a }
        L_0x0035:
            java.lang.String r5 = r4.readLine()     // Catch:{ IOException -> 0x0068 }
            if (r5 == 0) goto L_0x003f
            r3.append(r5)     // Catch:{ IOException -> 0x0068 }
            goto L_0x0035
        L_0x003f:
            r4.close()     // Catch:{ IOException -> 0x0068 }
            r4.close()     // Catch:{ Exception -> 0x004a }
            r6.close()     // Catch:{ Exception -> 0x004a }
            goto L_0x00ab
        L_0x004a:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
        L_0x0050:
            r5.append(r1)
            r5.append(r10)
            r5.append(r0)
            java.lang.String r10 = r4.toString()
            r5.append(r10)
            java.lang.String r10 = r5.toString()
            i6.k.d(r2, r10)
            goto L_0x00ab
        L_0x0068:
            r5 = move-exception
            goto L_0x0078
        L_0x006a:
            r3 = move-exception
            goto L_0x00b2
        L_0x006c:
            r4 = move-exception
            r9 = r5
            r5 = r4
            r4 = r9
            goto L_0x0078
        L_0x0071:
            r3 = move-exception
            r6 = r5
            goto L_0x00b2
        L_0x0074:
            r4 = move-exception
            r6 = r5
            r5 = r4
            r4 = r6
        L_0x0078:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b0 }
            r7.<init>()     // Catch:{ all -> 0x00b0 }
            r7.append(r1)     // Catch:{ all -> 0x00b0 }
            r7.append(r10)     // Catch:{ all -> 0x00b0 }
            r7.append(r0)     // Catch:{ all -> 0x00b0 }
            java.lang.String r8 = r5.toString()     // Catch:{ all -> 0x00b0 }
            r7.append(r8)     // Catch:{ all -> 0x00b0 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00b0 }
            i6.k.d(r2, r7)     // Catch:{ all -> 0x00b0 }
            r5.printStackTrace()     // Catch:{ all -> 0x00b0 }
            if (r4 == 0) goto L_0x009f
            r4.close()     // Catch:{ Exception -> 0x009d }
            goto L_0x009f
        L_0x009d:
            r4 = move-exception
            goto L_0x00a5
        L_0x009f:
            if (r6 == 0) goto L_0x00ab
            r6.close()     // Catch:{ Exception -> 0x009d }
            goto L_0x00ab
        L_0x00a5:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            goto L_0x0050
        L_0x00ab:
            java.lang.String r10 = r3.toString()
            return r10
        L_0x00b0:
            r3 = move-exception
            r5 = r4
        L_0x00b2:
            if (r5 == 0) goto L_0x00ba
            r5.close()     // Catch:{ Exception -> 0x00b8 }
            goto L_0x00ba
        L_0x00b8:
            r4 = move-exception
            goto L_0x00c0
        L_0x00ba:
            if (r6 == 0) goto L_0x00dc
            r6.close()     // Catch:{ Exception -> 0x00b8 }
            goto L_0x00dc
        L_0x00c0:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r1)
            r5.append(r10)
            r5.append(r0)
            java.lang.String r10 = r4.toString()
            r5.append(r10)
            java.lang.String r10 = r5.toString()
            i6.k.d(r2, r10)
        L_0x00dc:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: yl.o.A(java.lang.String):java.lang.String");
    }

    public static boolean B() {
        int e11 = SP.e("sp_key_index_home_flow_config_operposition", 0);
        int e12 = SP.e("sp_key_index_home_flow_config_task_progress", 0);
        Log.d("IndexHelper", "operPosition:" + e11 + " taskProgress:" + e12);
        if (e11 != 0) {
            return true;
        }
        return false;
    }

    public static void C(Context context, String str) {
        NoticeActivity.start(context, str);
    }

    public static void D(Context context, String str, String str2, boolean z11) {
        if (context != null && !TextUtils.isEmpty(str)) {
            if (!NetworkStatus.c(context)) {
                HuobiToastUtil.k(context, R.string.string_network_disconnect);
                return;
            }
            Intent intent = new Intent(context, CurrencyIntroWebActivity.class);
            intent.putExtra("url", str);
            if (!TextUtils.isEmpty(str2)) {
                intent.putExtra("title", str2);
            }
            intent.putExtra("isauth", z11);
            intent.addFlags(67108864);
            context.startActivity(intent);
        }
    }

    public static IndexFeatureItem E(HomePageEarnData.IndexAreaContentJumpVo indexAreaContentJumpVo) {
        if (indexAreaContentJumpVo == null) {
            return null;
        }
        IndexFeatureItem indexFeatureItem = new IndexFeatureItem();
        indexFeatureItem.setTitle(indexAreaContentJumpVo.title);
        indexFeatureItem.setJumpMode(indexAreaContentJumpVo.jumpMode);
        indexFeatureItem.setJumpUrl(indexAreaContentJumpVo.jumpUrl);
        return indexFeatureItem;
    }

    public static IndexFeatureItem F(HomePageJumpData homePageJumpData) {
        if (homePageJumpData == null) {
            return null;
        }
        IndexFeatureItem indexFeatureItem = new IndexFeatureItem();
        indexFeatureItem.setTitle(homePageJumpData.getTitle());
        indexFeatureItem.setJumpMode(homePageJumpData.getJumpMode());
        indexFeatureItem.setJumpUrl(homePageJumpData.getJumpUrl());
        indexFeatureItem.setJumpSymbol(homePageJumpData.getJumpSymbol());
        indexFeatureItem.setNeedLogin(homePageJumpData.getNeedLogin());
        return indexFeatureItem;
    }

    public static boolean G(int i11) {
        if (SP.e("sp_key_index_home_flow_config_user_guide", 0) == 1) {
            return i11 == 0 || i11 == 1;
        }
        return false;
    }

    public static Spannable a(Context context, String str, int i11, int i12, boolean z11) {
        SpannableStringBuilder spannableStringBuilder = null;
        if (context == null) {
            return null;
        }
        try {
            int indexOf = str.indexOf("{");
            int indexOf2 = str.indexOf("}");
            String replace = str.replace("{", "").replace("}", "");
            int i13 = indexOf2 - 1;
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(replace);
            if (indexOf == -1 || i13 == -1) {
                return spannableStringBuilder2;
            }
            try {
                spannableStringBuilder2.setSpan(new ForegroundColorSpan(context.getResources().getColor(i11)), 0, indexOf, 18);
                if (z11) {
                    spannableStringBuilder2.setSpan(new AbsoluteSizeSpan(10, true), 0, indexOf, 18);
                    spannableStringBuilder2.setSpan(new AbsoluteSizeSpan(14, true), indexOf, i13, 18);
                    spannableStringBuilder2.setSpan(new AbsoluteSizeSpan(10, true), i13, replace.length(), 18);
                }
                spannableStringBuilder2.setSpan(new ForegroundColorSpan(context.getResources().getColor(i12)), indexOf, i13, 18);
                spannableStringBuilder2.setSpan(new ForegroundColorSpan(context.getResources().getColor(i11)), i13, replace.length(), 18);
                return spannableStringBuilder2;
            } catch (Exception e11) {
                e = e11;
                spannableStringBuilder = spannableStringBuilder2;
                e.printStackTrace();
                return spannableStringBuilder;
            }
        } catch (Exception e12) {
            e = e12;
            e.printStackTrace();
            return spannableStringBuilder;
        }
    }

    public static String b(String str, Context context, String str2) {
        return context.getSharedPreferences(str, 0).getString(str2, "");
    }

    public static void c(Activity activity, Intent intent) {
        if (r.x().F0()) {
            CurrencySearchActivity.jj(activity, "1", 1, false);
            return;
        }
        Intent intent2 = new Intent(activity, CurrencySearchActivity.class);
        intent2.putExtra("extra_type", "1");
        c.i().d(activity, new JumpTarget(intent2, intent));
    }

    public static void d(int i11, Activity activity, String str, Intent intent) {
        Intent intent2;
        Intent intent3;
        Class<GridTradeActivity> cls = GridTradeActivity.class;
        if (i11 == 1) {
            if (!r.x().F0()) {
                c.i().d(activity, new JumpTarget(intent, intent));
            } else if (ad.o.c()) {
                if (!TextUtils.isEmpty(str)) {
                    intent3 = new Intent(activity, cls);
                    intent3.putExtra("EXTRA_SYMBOL", str);
                } else {
                    intent3 = new Intent(activity, cls);
                }
                activity.startActivity(intent3);
            } else {
                HuobiToastUtil.j(R.string.n_grid_trade_not_open);
            }
        } else if (ad.o.c()) {
            if (!TextUtils.isEmpty(str)) {
                intent2 = new Intent(activity, cls);
                intent2.putExtra("EXTRA_SYMBOL", str);
            } else {
                intent2 = new Intent(activity, cls);
            }
            activity.startActivity(intent2);
        } else {
            HuobiToastUtil.j(R.string.n_grid_trade_not_open);
        }
    }

    public static void e(Activity activity, IndexFeatureItem indexFeatureItem, Intent intent) {
        if (!TextUtils.isEmpty(indexFeatureItem.getJumpUrl())) {
            Intent intent2 = new Intent();
            intent2.putExtra("url", indexFeatureItem.getJumpUrl());
            intent2.putExtra("title_back", activity.getString(R.string.head_return));
            intent2.putExtra("title", indexFeatureItem.getTitle());
            intent2.putExtra("homeFunction", indexFeatureItem.isHomeFunction);
            intent2.setClass(activity, HBBaseWebActivity.class);
            if (indexFeatureItem.getNeedLogin() == 1) {
                o(activity, intent2, intent);
            } else {
                activity.startActivity(intent2);
            }
        }
    }

    public static void f(Activity activity, Intent intent) {
        if (r.x().F0()) {
            BaseActivity baseActivity = null;
            if (activity instanceof BaseActivity) {
                baseActivity = (BaseActivity) activity;
            }
            if (r.x().F0() && !r.x().X()) {
                b.a().integrationConfig().b().compose(RxJavaHelper.t(baseActivity)).subscribe(new a(baseActivity, true, activity));
                return;
            }
            return;
        }
        c.i().d(activity, new JumpTarget(intent, intent));
    }

    public static void g(Activity activity, IndexFeatureItem indexFeatureItem, Intent intent) {
        Intent l11 = k0.l(activity);
        if (indexFeatureItem.getNeedLogin() == 1) {
            o(activity, l11, intent);
        } else {
            activity.startActivity(l11);
        }
    }

    public static void h(Activity activity, IndexFeatureItem indexFeatureItem, Intent intent, int i11) {
        Intent m11 = k0.m(activity, i11);
        if (indexFeatureItem.getNeedLogin() == 1) {
            o(activity, m11, intent);
        } else {
            activity.startActivity(m11);
        }
    }

    public static void i(Activity activity) {
        Intent l11 = k0.l(activity);
        l11.putExtra("MARKET_GO_PIONEER", true);
        activity.startActivity(l11);
    }

    public static void j(Activity activity) {
        if (SP.l("FIRST_OPEN_POTENTIALS", true)) {
            SP.y("FIRST_OPEN_POTENTIALS", false);
            HBBaseWebActivity.showWebView(activity, a0.p(), "", "", false);
            return;
        }
        Intent l11 = k0.l(activity);
        l11.putExtra("MARKET_GO_POTENTIALS", true);
        activity.startActivity(l11);
    }

    public static void k(Activity activity, IndexFeatureItem indexFeatureItem, Intent intent) {
        if (!TextUtils.isEmpty(indexFeatureItem.getJumpUrl())) {
            try {
                Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(indexFeatureItem.getJumpUrl()));
                if (indexFeatureItem.getNeedLogin() == 1) {
                    o(activity, intent2, intent);
                } else {
                    activity.startActivity(intent2);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public static void l(String str, boolean z11, TradeType tradeType, IndexFeatureItem indexFeatureItem, Activity activity, Intent intent) {
        if (indexFeatureItem.getNeedLogin() == 1) {
            o(activity, f.n(activity, str, z11, tradeType), intent);
        } else {
            f.D(activity, str, z11, tradeType, indexFeatureItem.getFrom());
        }
    }

    public static void m(Activity activity) {
        jp.k0.m(activity, OtcTradeAreaEnum.AD_AREA);
    }

    public static void n(Activity activity, IndexFeatureItem indexFeatureItem) {
        if (!TextUtils.isEmpty(indexFeatureItem.getJumpSymbol())) {
            k0.O(activity, indexFeatureItem.getJumpSymbol(), true);
        } else {
            activity.startActivity(k0.t(activity, false));
        }
    }

    public static void o(Activity activity, Intent intent, Intent intent2) {
        if (r.x().F0()) {
            activity.startActivity(intent);
        } else {
            c.i().d(activity, new JumpTarget(intent, intent2));
        }
    }

    public static void p(FragmentActivity fragmentActivity, IndexFeatureItem indexFeatureItem) {
        q(fragmentActivity, indexFeatureItem, false);
    }

    public static void q(FragmentActivity fragmentActivity, IndexFeatureItem indexFeatureItem, boolean z11) {
        Intent intent;
        Intent h11 = k0.h(fragmentActivity);
        if (z11) {
            h11 = k0.a(fragmentActivity);
        }
        Intent intent2 = h11;
        Bundle bundle = new Bundle();
        int jumpMode = indexFeatureItem.getJumpMode();
        if (jumpMode != 23) {
            if (jumpMode != 24) {
                if (jumpMode == 26) {
                    j(fragmentActivity);
                } else if (jumpMode == 27) {
                    fragmentActivity.startActivity(new Intent(fragmentActivity, CouponActivity.class));
                } else if (jumpMode == 29) {
                    f(fragmentActivity, intent2);
                } else if (jumpMode == 31) {
                    Intent i11 = k0.i(fragmentActivity, false);
                    if (indexFeatureItem.getNeedLogin() == 1) {
                        o(fragmentActivity, i11, intent2);
                    } else {
                        fragmentActivity.startActivity(i11);
                    }
                } else if (jumpMode == 201) {
                    String jumpUrl = indexFeatureItem.getJumpUrl();
                    if (!x.d(jumpUrl)) {
                        BaseModuleConfig.a().k0(jumpUrl);
                    }
                } else if (jumpMode == 402) {
                    jp.k0.d().h(fragmentActivity, (Intent) null);
                } else if (jumpMode == 999) {
                    Intent intent3 = new Intent(fragmentActivity, MoreOperationActivity.class);
                    if (indexFeatureItem.getNeedLogin() == 1) {
                        k0.y(fragmentActivity, intent3, intent2);
                    } else {
                        fragmentActivity.startActivity(intent3);
                    }
                } else if (jumpMode == 1001) {
                    bundle.putString("register_type", "register_email");
                    if (gj.a.b().c()) {
                        HbgRouter.i(fragmentActivity, "/login/register_v2", bundle);
                    } else {
                        HbgRouter.i(fragmentActivity, "/login/register", bundle);
                    }
                } else if (jumpMode != 1002) {
                    switch (jumpMode) {
                        case 1:
                            e(fragmentActivity, indexFeatureItem, intent2);
                            return;
                        case 2:
                            k(fragmentActivity, indexFeatureItem, intent2);
                            return;
                        case 3:
                            if (indexFeatureItem.getNeedLogin() == 1) {
                                if (!TextUtils.isEmpty(indexFeatureItem.getJumpSymbol())) {
                                    intent = k0.s(fragmentActivity, indexFeatureItem.getJumpSymbol(), true);
                                } else {
                                    intent = k0.t(fragmentActivity, false);
                                }
                                c.i().d(fragmentActivity, new JumpTarget(intent, intent2));
                                return;
                            }
                            n(fragmentActivity, indexFeatureItem);
                            return;
                        case 4:
                            if (indexFeatureItem.getNeedLogin() == 1) {
                                o(fragmentActivity, new Intent(fragmentActivity, OtcTradeActivity.class), intent2);
                                return;
                            } else {
                                jp.k0.k(fragmentActivity);
                                return;
                            }
                        case 5:
                            Intent j11 = k0.j(fragmentActivity, false);
                            if (indexFeatureItem.getNeedLogin() == 1) {
                                o(fragmentActivity, j11, intent2);
                                return;
                            } else {
                                fragmentActivity.startActivity(j11);
                                return;
                            }
                        case 6:
                            Intent d11 = k0.d(fragmentActivity, false);
                            if (indexFeatureItem.getNeedLogin() == 1) {
                                o(fragmentActivity, d11, intent2);
                                return;
                            } else {
                                fragmentActivity.startActivity(d11);
                                return;
                            }
                        case 7:
                            Intent h12 = f.h(fragmentActivity);
                            if (indexFeatureItem.getNeedLogin() == 1) {
                                o(fragmentActivity, h12, intent2);
                                return;
                            } else {
                                fragmentActivity.startActivity(h12);
                                return;
                            }
                        case 8:
                            c(fragmentActivity, intent2);
                            return;
                        case 9:
                            r(fragmentActivity, intent2);
                            return;
                        case 10:
                            if (r.x().F0()) {
                                UnifyTransferActivity.Th(fragmentActivity, (String) null, (String) null);
                                return;
                            }
                            c.i().d(fragmentActivity, new JumpTarget(new Intent(fragmentActivity, UnifyTransferActivity.class), intent2));
                            return;
                        case 11:
                            l("huobi10", false, TradeType.INDEX, indexFeatureItem, fragmentActivity, intent2);
                            return;
                        case 12:
                            l("hb10usdt", false, TradeType.PRO, indexFeatureItem, fragmentActivity, intent2);
                            return;
                        case 13:
                            l(indexFeatureItem.getJumpSymbol(), false, TradeType.getTradeTypeBySymbol(indexFeatureItem.getJumpSymbol()), indexFeatureItem, fragmentActivity, intent2);
                            return;
                        case 14:
                            Intent intent4 = new Intent(fragmentActivity, InviteActivity.class);
                            if (r.x().F0()) {
                                fragmentActivity.startActivity(intent4);
                                return;
                            } else {
                                c.i().d(fragmentActivity, new JumpTarget(intent4, intent2));
                                return;
                            }
                        default:
                            switch (jumpMode) {
                                case 18:
                                    g(fragmentActivity, indexFeatureItem, intent2);
                                    return;
                                case 19:
                                    c.i().d(fragmentActivity, new JumpTarget(k0.c(fragmentActivity), k0.h(fragmentActivity)));
                                    return;
                                case 20:
                                    Intent u11 = k0.u(fragmentActivity, false);
                                    if (indexFeatureItem.getNeedLogin() == 1) {
                                        o(fragmentActivity, u11, intent2);
                                        return;
                                    } else {
                                        fragmentActivity.startActivity(u11);
                                        return;
                                    }
                                case 21:
                                    Intent v11 = k0.v(fragmentActivity, false);
                                    if (indexFeatureItem.getNeedLogin() == 1) {
                                        o(fragmentActivity, v11, intent2);
                                        return;
                                    } else {
                                        fragmentActivity.startActivity(v11);
                                        return;
                                    }
                                default:
                                    switch (jumpMode) {
                                        case 33:
                                            Intent intent5 = new Intent(fragmentActivity, SecuritySetActivity.class);
                                            if (r.x().F0()) {
                                                fragmentActivity.startActivity(intent5);
                                                return;
                                            } else {
                                                c.i().d(fragmentActivity, new JumpTarget(intent5, intent2));
                                                return;
                                            }
                                        case 34:
                                            d(indexFeatureItem.getNeedLogin(), fragmentActivity, indexFeatureItem.getJumpSymbol(), intent2);
                                            return;
                                        case 35:
                                            OtcOptionsEntryHelper.g().h(fragmentActivity, intent2, (String) null, (String) null);
                                            return;
                                        default:
                                            switch (jumpMode) {
                                                case 37:
                                                    i(fragmentActivity);
                                                    return;
                                                case 38:
                                                    if (indexFeatureItem.getNeedLogin() == 1 && !r.x().F0()) {
                                                        c.i().d(fragmentActivity, (kn.a) null);
                                                        return;
                                                    }
                                                    return;
                                                case 39:
                                                    jp.k0.k(fragmentActivity);
                                                    return;
                                                case 40:
                                                    h(fragmentActivity, indexFeatureItem, intent2, 40);
                                                    return;
                                                case 41:
                                                    m(fragmentActivity);
                                                    return;
                                                default:
                                                    switch (jumpMode) {
                                                        case 100:
                                                            y(fragmentActivity, OtcTradeAreaEnum.FAST_AREA);
                                                            return;
                                                        case 101:
                                                            y(fragmentActivity, OtcTradeAreaEnum.FREE_AREA);
                                                            return;
                                                        case 102:
                                                            x(fragmentActivity);
                                                            return;
                                                        default:
                                                            switch (jumpMode) {
                                                                case 1004:
                                                                    if (fragmentActivity != null) {
                                                                        try {
                                                                            Intent intent6 = new Intent(fragmentActivity, CommentDetailActivity.class);
                                                                            intent6.putExtra(CommunityConstants.TOPIC_ID, indexFeatureItem.getTopicId());
                                                                            intent6.putExtra("topicType", indexFeatureItem.getTopicType());
                                                                            intent6.putExtra("commentId", indexFeatureItem.getCommentId());
                                                                            fragmentActivity.startActivity(intent6);
                                                                            return;
                                                                        } catch (ClassCastException | NumberFormatException e11) {
                                                                            e11.printStackTrace();
                                                                            return;
                                                                        }
                                                                    } else {
                                                                        return;
                                                                    }
                                                                case 1005:
                                                                    if (fragmentActivity != null) {
                                                                        try {
                                                                            if (!com.hbg.module.libkt.base.ext.b.x(indexFeatureItem.dynamicId)) {
                                                                                b2.a.d().a("/content/DynamicDetail").withString("dynamicId", indexFeatureItem.dynamicId).navigation();
                                                                                return;
                                                                            }
                                                                            Intent intent7 = new Intent(fragmentActivity, HBBaseWebActivity.class);
                                                                            intent7.putExtra("url", a0.k("pretender/news-detail-long?id=" + indexFeatureItem.getJumpOrder()));
                                                                            fragmentActivity.startActivity(intent7);
                                                                            return;
                                                                        } catch (Throwable th2) {
                                                                            i6.d.b(th2.toString());
                                                                            return;
                                                                        }
                                                                    } else {
                                                                        return;
                                                                    }
                                                                case 1006:
                                                                    if (AppConfigManager.h(MgtConfigNumber.ALL_SWITCH.number, "huobiLive", false)) {
                                                                        h(fragmentActivity, indexFeatureItem, intent2, 40);
                                                                        Bundle bundle2 = new Bundle();
                                                                        bundle2.putString("liveId", indexFeatureItem.getJumpOrder());
                                                                        HbgRouter.i(fragmentActivity, "/live/room", bundle2);
                                                                        HashMap hashMap = new HashMap();
                                                                        hashMap.put("liveid", indexFeatureItem.getJumpOrder());
                                                                        gs.g.i("APP_LIVE_notice_pushclk", hashMap);
                                                                        return;
                                                                    }
                                                                    return;
                                                                case 1007:
                                                                    b2.a.d().a("/content/FansFollowList").withString("uidUnique", indexFeatureItem.getUidUnique()).navigation();
                                                                    return;
                                                                case 1008:
                                                                    if (fragmentActivity != null) {
                                                                        try {
                                                                            Intent intent8 = new Intent(fragmentActivity, DynamicDetailActivity.class);
                                                                            intent8.putExtra("dynamicId", indexFeatureItem.getDynamicId());
                                                                            fragmentActivity.startActivity(intent8);
                                                                            return;
                                                                        } catch (ClassCastException | NumberFormatException e12) {
                                                                            e12.printStackTrace();
                                                                            return;
                                                                        }
                                                                    } else {
                                                                        return;
                                                                    }
                                                                case 1009:
                                                                    b2.a.d().a("/content/PersonalCenter").withString("uidUnique", indexFeatureItem.getUidUnique()).navigation();
                                                                    return;
                                                                case 1010:
                                                                    if (fragmentActivity != null) {
                                                                        try {
                                                                            Intent intent9 = new Intent(fragmentActivity, PersonalCenterActivity.class);
                                                                            intent9.putExtra("uidUnique", indexFeatureItem.getUidUnique());
                                                                            fragmentActivity.startActivity(intent9);
                                                                            return;
                                                                        } catch (ClassCastException | NumberFormatException e13) {
                                                                            e13.printStackTrace();
                                                                            return;
                                                                        }
                                                                    } else {
                                                                        return;
                                                                    }
                                                                default:
                                                                    return;
                                                            }
                                                    }
                                            }
                                    }
                            }
                    }
                } else if (fragmentActivity != null) {
                    try {
                        if (!com.hbg.module.libkt.base.ext.b.x(indexFeatureItem.dynamicId)) {
                            b2.a.d().a("/content/DynamicDetail").withString("dynamicId", indexFeatureItem.dynamicId).navigation();
                            return;
                        }
                        Intent intent10 = new Intent(fragmentActivity, NewsDetailActivity.class);
                        intent10.putExtra("newflashId", indexFeatureItem.getJumpOrder());
                        intent10.putExtra("from", 1);
                        fragmentActivity.startActivity(intent10);
                    } catch (Throwable th3) {
                        i6.d.b(th3.toString());
                    }
                }
            } else if (indexFeatureItem.getNeedLogin() == 1) {
                k0.y(fragmentActivity, k0.A(fragmentActivity, (String) null), intent2);
            } else {
                k0.K(fragmentActivity, "");
            }
        } else if (indexFeatureItem.getNeedLogin() == 1) {
            k0.y(fragmentActivity, k0.B(fragmentActivity), intent2);
        } else {
            k0.I(fragmentActivity);
        }
    }

    public static void r(Activity activity, Intent intent) {
        if (r.x().F0()) {
            CurrencySearchActivity.lj(activity, "2", false);
            return;
        }
        Intent intent2 = new Intent(activity, CurrencySearchActivity.class);
        intent2.putExtra("extra_type", "2");
        c.i().d(activity, new JumpTarget(intent2, intent));
    }

    public static void s(String str, int i11, String str2) {
        t(str, i11, str2, "");
    }

    public static void t(String str, int i11, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", str);
        hashMap.put("status", Integer.valueOf(i11));
        hashMap.put("type", str2);
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("button_type", str3);
        }
        gs.g.i("appclick_home", hashMap);
    }

    public static void u(String str, int i11) {
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", str);
        hashMap.put("status", Integer.valueOf(i11));
        gs.g.i("appexposure_home", hashMap);
    }

    public static void v(int i11) {
        if (i11 >= 7 && !f76854b) {
            TimeMonitorManager.a().b("huobiapp_home_start").a("huobiapp_home_end", OptionsBridge.NETWORK_KEY, true);
            Log.d("TimeMonitor", "TimeMonitor -- end:" + System.currentTimeMillis() + "count:" + i11);
            f76854b = true;
        }
    }

    public static IndexFeatureItem w(String str) {
        IndexFeatureItem indexFeatureItem;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("type");
            String optString2 = jSONObject.optString("template_code");
            if (FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT.equalsIgnoreCase(optString)) {
                indexFeatureItem = new IndexFeatureItem();
                indexFeatureItem.setJumpMode(16);
            } else if ("h5".equalsIgnoreCase(optString)) {
                indexFeatureItem = new IndexFeatureItem();
                indexFeatureItem.setJumpMode(201);
                indexFeatureItem.setJumpUrl(jSONObject.optString("value"));
            } else if (MTPushConstants.Analysis.KEY_JSON.equalsIgnoreCase(optString)) {
                indexFeatureItem = (IndexFeatureItem) new Gson().fromJson(jSONObject.optString("value"), IndexFeatureItem.class);
            } else {
                indexFeatureItem = new IndexFeatureItem();
                indexFeatureItem.setJumpMode(16);
            }
            if ("1.QUOTATION.MONITOR".equals(optString2)) {
                gs.g.i("APP_MC_market_broadcast_Hits_pv", (HashMap) null);
                indexFeatureItem.setFrom("1");
                return indexFeatureItem;
            } else if (!"1.PRO.NEWSFLASH".equals(optString2)) {
                return indexFeatureItem;
            } else {
                gs.g.i("APP_MC_intelligent_disk_Hits_pv", (HashMap) null);
                return indexFeatureItem;
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            IndexFeatureItem indexFeatureItem2 = new IndexFeatureItem();
            indexFeatureItem2.setJumpMode(16);
            return indexFeatureItem2;
        }
    }

    public static void x(FragmentActivity fragmentActivity) {
        g gVar = null;
        if (r.x().F0()) {
            if (fragmentActivity instanceof g) {
                gVar = (g) fragmentActivity;
            }
            OtcModuleConfig.a().A(fragmentActivity, gVar, c1.h().k(up.g.c("otc_select_trade_currency_quote_asset")));
            return;
        }
        c.i().d(fragmentActivity, new JumpTarget((Intent) null, (Intent) null));
    }

    public static void y(Activity activity, OtcTradeAreaEnum otcTradeAreaEnum) {
        jp.k0.m(activity, otcTradeAreaEnum);
    }

    public static boolean z(String str, Context context, String str2, String str3) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putString(str2, str3);
        return edit.commit();
    }
}
