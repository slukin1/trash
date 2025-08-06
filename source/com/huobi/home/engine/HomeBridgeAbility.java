package com.huobi.home.engine;

import a7.e;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSONObject;
import com.eclipsesource.v8.V8Object;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.zxing.client.android.CaptureActivity;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.permissions.AfterPermissionGranted;
import com.hbg.lib.core.permissions.EasyPermissions;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.controller.FutureContractInfoController;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.hbg.core.bean.Favorite;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.network.swap.core.controller.SwapCurrencyInfoController;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.lib.widgets.utils.PermissionUtils;
import com.hbg.module.market.MarketModuleConfig;
import com.huobi.contract.helper.ContractCurrencyUtils;
import com.huobi.edgeengine.ability.AbilityFunction;
import com.huobi.edgeengine.ability.AbstractAbility;
import com.huobi.entity.HomeActivityEntity;
import com.huobi.home.ui.TransferAmountGuideActivity;
import com.huobi.index.bean.IndexFeatureItem;
import com.huobi.index.ui.RankingActivity;
import com.huobi.login.bean.JumpTarget;
import com.huobi.message.ui.MessageActivity;
import com.huobi.search.ui.SearchFlutterActivity;
import com.huobi.utils.k0;
import com.huochat.community.util.JsonTool;
import com.luck.picture.lib.permissions.PermissionConfig;
import com.tencent.qcloud.tuicore.TUIConstants;
import gs.g;
import i6.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.x;
import pro.huobi.R;
import sn.f;
import sn.t;
import tg.r;
import us.j;
import yl.o;

public final class HomeBridgeAbility extends AbstractAbility {

    public static final class a extends TypeToken<HomeActivityEntity> {
    }

    public static final class b extends TypeToken<IndexFeatureItem> {
    }

    public static final class c extends TypeToken<IndexFeatureItem> {
    }

    public static final void o(String str, Ref$ObjectRef ref$ObjectRef) {
        HomeEngineCore.f72473a.f(str, (String) ref$ObjectRef.element);
    }

    public static final void y(Activity activity, String[] strArr, int i11) {
        if (i11 == 0) {
            d.i("HasPermissions, start CaptureActivity.");
            Intent intent = new Intent(activity, CaptureActivity.class);
            intent.putExtra(CaptureActivity.PARAM_HINT_TEXT, activity.getString(R.string.n_scan_automation_tips));
            activity.startActivityForResult(intent, 1001);
        } else if (i11 == 2) {
            d.i("Has not Permissions, start request permissions.");
            EasyPermissions.requestPermissions(activity, 123, (String[]) Arrays.copyOf(strArr, strArr.length));
        }
    }

    public final void A(Activity activity, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("hotWord", str);
        SearchFlutterActivity.Gi(activity, bundle);
    }

    public void a(rj.b bVar, Object obj, AbilityFunction.a aVar) {
        if (aVar == null || obj == null || bVar == null) {
            Log.d("Console", "call HomeBridgeAbility error");
            return;
        }
        try {
            V8Object v8Object = (V8Object) obj;
            String string = v8Object.contains("action") ? v8Object.getString("action") : "";
            if (string != null) {
                switch (string.hashCode()) {
                    case -2137898495:
                        if (!string.equals("getVolumeStr")) {
                            break;
                        } else {
                            k(v8Object, bVar.d(), aVar);
                            return;
                        }
                    case -518119660:
                        if (!string.equals("operationClickItem")) {
                            break;
                        } else {
                            m(v8Object, bVar.d(), aVar);
                            return;
                        }
                    case -504772615:
                        if (!string.equals("openPage")) {
                            break;
                        } else {
                            l(v8Object, bVar.d(), aVar);
                            return;
                        }
                    case -490545237:
                        if (!string.equals("addFavoritesSymbolsToLocal")) {
                            break;
                        } else {
                            e(v8Object, bVar.d(), aVar);
                            return;
                        }
                    case -486117632:
                        if (!string.equals("setModuleStatus")) {
                            break;
                        } else {
                            n(v8Object, aVar);
                            return;
                        }
                    case 521084936:
                        if (!string.equals("bannerClickBanner")) {
                            break;
                        } else {
                            f(v8Object, bVar.d(), aVar);
                            return;
                        }
                    case 593010722:
                        if (!string.equals("getLocalFavorites")) {
                            break;
                        } else {
                            i(bVar.d(), aVar);
                            return;
                        }
                    case 793960056:
                        if (!string.equals("getContractBusinessTypeTag")) {
                            break;
                        } else {
                            h(v8Object, bVar.d(), aVar);
                            return;
                        }
                    case 1323787057:
                        if (!string.equals("bannerClickMore")) {
                            break;
                        } else {
                            g(v8Object, bVar.d(), aVar);
                            return;
                        }
                }
            }
            aVar.a(true, "");
        } catch (Throwable th2) {
            Log.d("Console", "call HomeBridgeAbility error ");
            th2.printStackTrace();
            aVar.a(false, th2.getMessage());
        }
    }

    public boolean b() {
        return false;
    }

    public final void e(V8Object v8Object, Context context, AbilityFunction.a aVar) {
        boolean z11 = false;
        if (v8Object != null && v8Object.contains("symbols")) {
            z11 = true;
        }
        t.E(JsonTool.parseArray(z11 ? v8Object != null ? v8Object.getString("symbols") : null : "", String.class), context);
        aVar.a(true, "");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0015  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x001e A[Catch:{ Exception -> 0x000e }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003b A[Catch:{ Exception -> 0x000e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f(com.eclipsesource.v8.V8Object r6, android.content.Context r7, com.huobi.edgeengine.ability.AbilityFunction.a r8) {
        /*
            r5 = this;
            java.lang.String r0 = "data"
            r1 = 1
            r2 = 0
            if (r6 == 0) goto L_0x0010
            boolean r3 = r6.contains(r0)     // Catch:{ Exception -> 0x000e }
            if (r3 != r1) goto L_0x0010
            r3 = r1
            goto L_0x0011
        L_0x000e:
            r6 = move-exception
            goto L_0x0044
        L_0x0010:
            r3 = r2
        L_0x0011:
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x001e
            if (r6 == 0) goto L_0x001c
            java.lang.String r6 = r6.getString(r0)     // Catch:{ Exception -> 0x000e }
            goto L_0x001f
        L_0x001c:
            r6 = 0
            goto L_0x001f
        L_0x001e:
            r6 = r4
        L_0x001f:
            com.google.gson.Gson r0 = new com.google.gson.Gson     // Catch:{ Exception -> 0x000e }
            r0.<init>()     // Catch:{ Exception -> 0x000e }
            com.huobi.home.engine.HomeBridgeAbility$a r3 = new com.huobi.home.engine.HomeBridgeAbility$a     // Catch:{ Exception -> 0x000e }
            r3.<init>()     // Catch:{ Exception -> 0x000e }
            java.lang.reflect.Type r3 = r3.getType()     // Catch:{ Exception -> 0x000e }
            java.lang.Object r6 = r0.fromJson((java.lang.String) r6, (java.lang.reflect.Type) r3)     // Catch:{ Exception -> 0x000e }
            com.huobi.entity.HomeActivityEntity r6 = (com.huobi.entity.HomeActivityEntity) r6     // Catch:{ Exception -> 0x000e }
            java.lang.String r0 = r6.url     // Catch:{ Exception -> 0x000e }
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x000e }
            if (r3 != 0) goto L_0x0040
            java.lang.String r6 = r6.title     // Catch:{ Exception -> 0x000e }
            com.huobi.utils.v.a(r7, r0, r6)     // Catch:{ Exception -> 0x000e }
        L_0x0040:
            r8.a(r1, r4)     // Catch:{ Exception -> 0x000e }
            goto L_0x0055
        L_0x0044:
            java.lang.String r7 = "Console"
            java.lang.String r0 = "call HomeBridgeAbility bannerClickBanner error "
            android.util.Log.d(r7, r0)
            r6.printStackTrace()
            java.lang.String r6 = r6.getMessage()
            r8.a(r2, r6)
        L_0x0055:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.home.engine.HomeBridgeAbility.f(com.eclipsesource.v8.V8Object, android.content.Context, com.huobi.edgeengine.ability.AbilityFunction$a):void");
    }

    public final void g(V8Object v8Object, Context context, AbilityFunction.a aVar) {
        o.D(oa.a.g().b(), BaseModuleConfig.a().o(""), "", false);
        HashMap hashMap = new HashMap();
        hashMap.put("testKey", "A");
        hashMap.put("module_name", TUIConstants.TUIChat.NOTICE);
        hashMap.put("button_name", "more");
        g.i("appclick_home", hashMap);
        aVar.a(true, "");
    }

    public final void h(V8Object v8Object, Context context, AbilityFunction.a aVar) {
        boolean z11 = false;
        if (v8Object != null && v8Object.contains("symbol")) {
            z11 = true;
        }
        aVar.a(true, j(z11 ? v8Object != null ? v8Object.getString("symbol") : null : ""));
    }

    public final void i(Context context, AbilityFunction.a aVar) {
        List<String> t11 = t.t(context);
        ArrayList arrayList = new ArrayList();
        int size = t11.size();
        for (int i11 = 0; i11 < size; i11++) {
            Favorite favorite = new Favorite();
            favorite.setFavSymbol(t11.get(i11));
            favorite.setFavType(t.v(t11.get(i11)));
            arrayList.add(favorite);
        }
        aVar.a(true, JsonTool.toJSONString(arrayList));
    }

    public final String j(String str) {
        List<ContractCurrencyInfo> m11 = ContractCurrencyUtils.m();
        List<SwapCurrencyInfo> e11 = SwapCurrencyInfoController.k().e();
        List<FutureContractInfo> f11 = FutureContractInfoController.n().f();
        int size = m11.size();
        for (int i11 = 0; i11 < size; i11++) {
            ContractCurrencyInfo contractCurrencyInfo = m11.get(i11);
            if (contractCurrencyInfo != null && StringsKt__StringsJVMKt.w(str, contractCurrencyInfo.getContractShortType(), true)) {
                return ej.g.k(BaseApplication.b(), contractCurrencyInfo.getContractCode(), contractCurrencyInfo.getContractType());
            }
        }
        int size2 = e11.size();
        for (int i12 = 0; i12 < size2; i12++) {
            SwapCurrencyInfo swapCurrencyInfo = e11.get(i12);
            if (swapCurrencyInfo != null && StringsKt__StringsJVMKt.w(str, swapCurrencyInfo.getContractShortType(), true)) {
                return j.k(BaseApplication.b());
            }
        }
        int size3 = f11.size();
        for (int i13 = 0; i13 < size3; i13++) {
            FutureContractInfo futureContractInfo = f11.get(i13);
            if (futureContractInfo != null && StringsKt__StringsJVMKt.w(str, futureContractInfo.getContractShortType(), true)) {
                return e.r(BaseApplication.b(), futureContractInfo.getContractCode(), futureContractInfo.getContractType());
            }
        }
        return x.b(MarketModuleConfig.a().x(), MarketModuleConfig.a().e0(str)) ? ej.g.c(str) : "";
    }

    public final void k(V8Object v8Object, Context context, AbilityFunction.a aVar) {
        aVar.a(true, yl.t.j(v8Object.contains("data") ? v8Object.getString("data") : ""));
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void l(com.eclipsesource.v8.V8Object r9, android.content.Context r10, com.huobi.edgeengine.ability.AbilityFunction.a r11) {
        /*
            r8 = this;
            java.lang.String r0 = "params"
            java.lang.String r1 = "type"
            r2 = 0
            r3 = 1
            if (r9 == 0) goto L_0x0010
            boolean r4 = r9.contains(r1)
            if (r4 != r3) goto L_0x0010
            r4 = r3
            goto L_0x0011
        L_0x0010:
            r4 = r2
        L_0x0011:
            r5 = 0
            java.lang.String r6 = ""
            if (r4 == 0) goto L_0x001f
            if (r9 == 0) goto L_0x001d
            java.lang.String r1 = r9.getString(r1)
            goto L_0x0020
        L_0x001d:
            r1 = r5
            goto L_0x0020
        L_0x001f:
            r1 = r6
        L_0x0020:
            java.lang.String r4 = "page"
            if (r9 == 0) goto L_0x002c
            boolean r7 = r9.contains(r4)
            if (r7 != r3) goto L_0x002c
            r7 = r3
            goto L_0x002d
        L_0x002c:
            r7 = r2
        L_0x002d:
            if (r7 == 0) goto L_0x0036
            if (r9 == 0) goto L_0x0037
            java.lang.String r5 = r9.getString(r4)
            goto L_0x0037
        L_0x0036:
            r5 = r6
        L_0x0037:
            if (r9 != 0) goto L_0x003a
            goto L_0x0049
        L_0x003a:
            boolean r4 = r9.contains(r0)     // Catch:{ all -> 0x0045 }
            if (r4 != r3) goto L_0x0049
            java.lang.String r9 = r9.getString(r0)     // Catch:{ all -> 0x0045 }
            goto L_0x004a
        L_0x0045:
            r9 = move-exception
            r9.printStackTrace()
        L_0x0049:
            r9 = r6
        L_0x004a:
            if (r1 == 0) goto L_0x0055
            java.lang.String r0 = "url"
            boolean r0 = r1.equals(r0)
            if (r0 != r3) goto L_0x0055
            r2 = r3
        L_0x0055:
            if (r2 == 0) goto L_0x006c
            zn.a r9 = zn.a.d()
            android.net.Uri r10 = android.net.Uri.parse(r5)
            zn.a r9 = r9.v(r10)
            zn.a r9 = r9.a()
            r9.c()
            goto L_0x0124
        L_0x006c:
            if (r5 == 0) goto L_0x0124
            int r0 = r5.hashCode()
            switch(r0) {
                case -1948770067: goto L_0x0116;
                case -1925774507: goto L_0x0107;
                case -1061197229: goto L_0x00f8;
                case -933809467: goto L_0x00e9;
                case -906336856: goto L_0x00da;
                case 3364: goto L_0x00cb;
                case 110366: goto L_0x00bb;
                case 3524221: goto L_0x00aa;
                case 98712316: goto L_0x0099;
                case 102138591: goto L_0x0088;
                case 103149417: goto L_0x0077;
                default: goto L_0x0075;
            }
        L_0x0075:
            goto L_0x0124
        L_0x0077:
            java.lang.String r9 = "login"
            boolean r9 = r5.equals(r9)
            if (r9 != 0) goto L_0x0081
            goto L_0x0124
        L_0x0081:
            android.app.Activity r10 = (android.app.Activity) r10
            r8.u(r10)
            goto L_0x0124
        L_0x0088:
            java.lang.String r0 = "kline"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0092
            goto L_0x0124
        L_0x0092:
            android.app.Activity r10 = (android.app.Activity) r10
            r8.t(r10, r9)
            goto L_0x0124
        L_0x0099:
            java.lang.String r9 = "guide"
            boolean r9 = r5.equals(r9)
            if (r9 != 0) goto L_0x00a3
            goto L_0x0124
        L_0x00a3:
            android.app.Activity r10 = (android.app.Activity) r10
            r8.r(r10)
            goto L_0x0124
        L_0x00aa:
            java.lang.String r9 = "scan"
            boolean r9 = r5.equals(r9)
            if (r9 != 0) goto L_0x00b4
            goto L_0x0124
        L_0x00b4:
            android.app.Activity r10 = (android.app.Activity) r10
            r8.x(r10)
            goto L_0x0124
        L_0x00bb:
            java.lang.String r9 = "otc"
            boolean r9 = r5.equals(r9)
            if (r9 != 0) goto L_0x00c5
            goto L_0x0124
        L_0x00c5:
            android.app.Activity r10 = (android.app.Activity) r10
            r8.w(r10)
            goto L_0x0124
        L_0x00cb:
            java.lang.String r9 = "im"
            boolean r9 = r5.equals(r9)
            if (r9 != 0) goto L_0x00d4
            goto L_0x0124
        L_0x00d4:
            android.app.Activity r10 = (android.app.Activity) r10
            r8.s(r10)
            goto L_0x0124
        L_0x00da:
            java.lang.String r0 = "search"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x00e3
            goto L_0x0124
        L_0x00e3:
            android.app.Activity r10 = (android.app.Activity) r10
            r8.A(r10, r9)
            goto L_0x0124
        L_0x00e9:
            java.lang.String r0 = "marketAdd"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x00f2
            goto L_0x0124
        L_0x00f2:
            android.app.Activity r10 = (android.app.Activity) r10
            r8.v(r10, r9)
            goto L_0x0124
        L_0x00f8:
            java.lang.String r0 = "cubeClick"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0101
            goto L_0x0124
        L_0x0101:
            android.app.Activity r10 = (android.app.Activity) r10
            r8.q(r10, r9)
            goto L_0x0124
        L_0x0107:
            java.lang.String r0 = "allRanking"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0110
            goto L_0x0124
        L_0x0110:
            android.app.Activity r10 = (android.app.Activity) r10
            r8.p(r10, r9)
            goto L_0x0124
        L_0x0116:
            java.lang.String r0 = "rankingToMarket"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x011f
            goto L_0x0124
        L_0x011f:
            android.app.Activity r10 = (android.app.Activity) r10
            r8.z(r10, r9)
        L_0x0124:
            r11.a(r3, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.home.engine.HomeBridgeAbility.l(com.eclipsesource.v8.V8Object, android.content.Context, com.huobi.edgeengine.ability.AbilityFunction$a):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0017  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0020 A[Catch:{ Exception -> 0x000e }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006a A[Catch:{ Exception -> 0x000e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m(com.eclipsesource.v8.V8Object r9, android.content.Context r10, com.huobi.edgeengine.ability.AbilityFunction.a r11) {
        /*
            r8 = this;
            java.lang.String r10 = "data"
            r0 = 0
            r1 = 1
            if (r9 == 0) goto L_0x0011
            boolean r2 = r9.contains(r10)     // Catch:{ Exception -> 0x000e }
            if (r2 != r1) goto L_0x0011
            r2 = r1
            goto L_0x0012
        L_0x000e:
            r9 = move-exception
            goto L_0x0105
        L_0x0011:
            r2 = r0
        L_0x0012:
            r3 = 0
            java.lang.String r4 = ""
            if (r2 == 0) goto L_0x0020
            if (r9 == 0) goto L_0x001e
            java.lang.String r9 = r9.getString(r10)     // Catch:{ Exception -> 0x000e }
            goto L_0x0021
        L_0x001e:
            r9 = r3
            goto L_0x0021
        L_0x0020:
            r9 = r4
        L_0x0021:
            com.google.gson.Gson r10 = new com.google.gson.Gson     // Catch:{ Exception -> 0x000e }
            r10.<init>()     // Catch:{ Exception -> 0x000e }
            com.huobi.home.engine.HomeBridgeAbility$b r2 = new com.huobi.home.engine.HomeBridgeAbility$b     // Catch:{ Exception -> 0x000e }
            r2.<init>()     // Catch:{ Exception -> 0x000e }
            java.lang.reflect.Type r2 = r2.getType()     // Catch:{ Exception -> 0x000e }
            java.lang.Object r9 = r10.fromJson((java.lang.String) r9, (java.lang.reflect.Type) r2)     // Catch:{ Exception -> 0x000e }
            com.huobi.index.bean.IndexFeatureItem r9 = (com.huobi.index.bean.IndexFeatureItem) r9     // Catch:{ Exception -> 0x000e }
            com.huobi.index.bean.IndexFeatureItem$CornerMarkContent r10 = r9.cornerMarkContent     // Catch:{ Exception -> 0x000e }
            if (r10 == 0) goto L_0x0095
            int r10 = r10.oneTime     // Catch:{ Exception -> 0x000e }
            if (r10 != r1) goto L_0x0095
            java.util.HashMap r10 = new java.util.HashMap     // Catch:{ Exception -> 0x000e }
            r10.<init>()     // Catch:{ Exception -> 0x000e }
            java.lang.String r2 = "id"
            int r5 = r9.f73183id     // Catch:{ Exception -> 0x000e }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x000e }
            r10.put(r2, r5)     // Catch:{ Exception -> 0x000e }
            java.lang.String r2 = "cornerMarkId"
            com.huobi.index.bean.IndexFeatureItem$CornerMarkContent r5 = r9.cornerMarkContent     // Catch:{ Exception -> 0x000e }
            long r5 = r5.cornerMarkId     // Catch:{ Exception -> 0x000e }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ Exception -> 0x000e }
            r10.put(r2, r5)     // Catch:{ Exception -> 0x000e }
            r5 = 0
            tg.r r2 = tg.r.x()     // Catch:{ Exception -> 0x000e }
            java.lang.String r2 = r2.J()     // Catch:{ Exception -> 0x000e }
            boolean r7 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x000e }
            if (r7 != 0) goto L_0x006e
            long r5 = java.lang.Long.parseLong(r2)     // Catch:{ Exception -> 0x000e }
        L_0x006e:
            java.lang.Long r2 = java.lang.Long.valueOf(r5)     // Catch:{ Exception -> 0x000e }
            java.lang.String r5 = "uid"
            r10.put(r5, r2)     // Catch:{ Exception -> 0x000e }
            java.lang.String r2 = "groupCode"
            java.lang.String r5 = r9.groupCode     // Catch:{ Exception -> 0x000e }
            r10.put(r2, r5)     // Catch:{ Exception -> 0x000e }
            java.lang.Class<com.huobi.index.api.IndexService> r2 = com.huobi.index.api.IndexService.class
            java.lang.Object r2 = tq.p.V(r2)     // Catch:{ Exception -> 0x000e }
            com.huobi.index.api.IndexService r2 = (com.huobi.index.api.IndexService) r2     // Catch:{ Exception -> 0x000e }
            rx.Observable r10 = r2.sendCornerMarkClickedMessage(r10)     // Catch:{ Exception -> 0x000e }
            rx.Observable$Transformer r2 = com.hbg.lib.core.util.RxJavaHelper.t(r3)     // Catch:{ Exception -> 0x000e }
            rx.Observable r10 = r10.compose(r2)     // Catch:{ Exception -> 0x000e }
            r10.subscribe()     // Catch:{ Exception -> 0x000e }
        L_0x0095:
            java.lang.String r10 = "user_event"
            java.lang.String r2 = r9.getJumpUrl()     // Catch:{ Exception -> 0x000e }
            i6.d.c(r10, r2)     // Catch:{ Exception -> 0x000e }
            com.huobi.woodpecker.WoodPeckerSDK r10 = com.huobi.woodpecker.WoodPeckerSDK.f()     // Catch:{ Exception -> 0x000e }
            jv.a r10 = r10.g()     // Catch:{ Exception -> 0x000e }
            java.lang.String r2 = "HomeFunctionEvent"
            java.lang.String r5 = r9.getJumpUrl()     // Catch:{ Exception -> 0x000e }
            r10.c(r2, r5, r4)     // Catch:{ Exception -> 0x000e }
            java.lang.String r10 = r9.getJumpUrl()     // Catch:{ Exception -> 0x000e }
            if (r10 == 0) goto L_0x00ca
            int r10 = r9.jumpMode     // Catch:{ Exception -> 0x000e }
            if (r10 != r1) goto L_0x00ca
            com.huobi.woodpecker.WoodPeckerSDK r10 = com.huobi.woodpecker.WoodPeckerSDK.f()     // Catch:{ Exception -> 0x000e }
            jv.a r10 = r10.g()     // Catch:{ Exception -> 0x000e }
            java.lang.String r2 = "FunctionWebSelected"
            java.lang.String r5 = r9.getJumpUrl()     // Catch:{ Exception -> 0x000e }
            r10.c(r2, r5, r4)     // Catch:{ Exception -> 0x000e }
        L_0x00ca:
            java.lang.String r10 = r9.getJumpUrl()     // Catch:{ Exception -> 0x000e }
            if (r10 == 0) goto L_0x00f2
            java.lang.String r10 = r9.getJumpUrl()     // Catch:{ Exception -> 0x000e }
            java.lang.String r2 = "otc/trade"
            r5 = 2
            boolean r10 = kotlin.text.StringsKt__StringsJVMKt.v(r10, r2, r0, r5, r3)     // Catch:{ Exception -> 0x000e }
            if (r10 == 0) goto L_0x00f2
            java.util.HashMap r10 = new java.util.HashMap     // Catch:{ Exception -> 0x000e }
            r10.<init>()     // Catch:{ Exception -> 0x000e }
            java.lang.String r2 = "otc_step"
            java.lang.String r3 = "click_buycrypto"
            r10.put(r2, r3)     // Catch:{ Exception -> 0x000e }
            uf.c r2 = uf.c.b()     // Catch:{ Exception -> 0x000e }
            java.lang.String r3 = "otc_home_access_point"
            r2.h(r3, r10)     // Catch:{ Exception -> 0x000e }
        L_0x00f2:
            r9.isHomeFunction = r1     // Catch:{ Exception -> 0x000e }
            oa.a r10 = oa.a.g()     // Catch:{ Exception -> 0x000e }
            android.app.Activity r10 = r10.b()     // Catch:{ Exception -> 0x000e }
            androidx.fragment.app.FragmentActivity r10 = (androidx.fragment.app.FragmentActivity) r10     // Catch:{ Exception -> 0x000e }
            yl.o.q(r10, r9, r0)     // Catch:{ Exception -> 0x000e }
            r11.a(r1, r4)     // Catch:{ Exception -> 0x000e }
            goto L_0x0116
        L_0x0105:
            java.lang.String r10 = "Console"
            java.lang.String r1 = "call HomeBridgeAbility operationClickItem error "
            android.util.Log.d(r10, r1)
            r9.printStackTrace()
            java.lang.String r9 = r9.getMessage()
            r11.a(r0, r9)
        L_0x0116:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.home.engine.HomeBridgeAbility.m(com.eclipsesource.v8.V8Object, android.content.Context, com.huobi.edgeengine.ability.AbilityFunction$a):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0016  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x001f A[Catch:{ Exception -> 0x000e }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0029 A[SYNTHETIC, Splitter:B:18:0x0029] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0034 A[Catch:{ Exception -> 0x000e }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x003b A[Catch:{ Exception -> 0x000e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void n(com.eclipsesource.v8.V8Object r9, com.huobi.edgeengine.ability.AbilityFunction.a r10) {
        /*
            r8 = this;
            java.lang.String r0 = "status"
            r1 = 1
            r2 = 0
            if (r9 == 0) goto L_0x0010
            boolean r3 = r9.contains(r0)     // Catch:{ Exception -> 0x000e }
            if (r3 != r1) goto L_0x0010
            r3 = r1
            goto L_0x0011
        L_0x000e:
            r9 = move-exception
            goto L_0x004e
        L_0x0010:
            r3 = r2
        L_0x0011:
            r4 = 0
            java.lang.String r5 = ""
            if (r3 == 0) goto L_0x001f
            if (r9 == 0) goto L_0x001d
            java.lang.String r0 = r9.getString(r0)     // Catch:{ Exception -> 0x000e }
            goto L_0x0020
        L_0x001d:
            r0 = r4
            goto L_0x0020
        L_0x001f:
            r0 = r5
        L_0x0020:
            kotlin.jvm.internal.Ref$ObjectRef r3 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch:{ Exception -> 0x000e }
            r3.<init>()     // Catch:{ Exception -> 0x000e }
            java.lang.String r6 = "moduleName"
            if (r9 == 0) goto L_0x0031
            boolean r7 = r9.contains(r6)     // Catch:{ Exception -> 0x000e }
            if (r7 != r1) goto L_0x0031
            r7 = r1
            goto L_0x0032
        L_0x0031:
            r7 = r2
        L_0x0032:
            if (r7 == 0) goto L_0x003b
            if (r9 == 0) goto L_0x003c
            java.lang.String r4 = r9.getString(r6)     // Catch:{ Exception -> 0x000e }
            goto L_0x003c
        L_0x003b:
            r4 = r5
        L_0x003c:
            r3.element = r4     // Catch:{ Exception -> 0x000e }
            i6.i r9 = i6.i.b()     // Catch:{ Exception -> 0x000e }
            com.huobi.home.engine.b r4 = new com.huobi.home.engine.b     // Catch:{ Exception -> 0x000e }
            r4.<init>(r0, r3)     // Catch:{ Exception -> 0x000e }
            r9.d(r4)     // Catch:{ Exception -> 0x000e }
            r10.a(r1, r5)     // Catch:{ Exception -> 0x000e }
            goto L_0x005f
        L_0x004e:
            java.lang.String r0 = "Console"
            java.lang.String r1 = "call HomeBridgeAbility setModuleStatus error "
            android.util.Log.d(r0, r1)
            r9.printStackTrace()
            java.lang.String r9 = r9.getMessage()
            r10.a(r2, r9)
        L_0x005f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.home.engine.HomeBridgeAbility.n(com.eclipsesource.v8.V8Object, com.huobi.edgeengine.ability.AbilityFunction$a):void");
    }

    public final void p(Activity activity, String str) {
        RankingActivity.uh(activity, Integer.parseInt(JsonTool.parseObject(str).getString("type")));
    }

    public final void q(Activity activity, String str) {
        try {
            o.q((FragmentActivity) activity, (IndexFeatureItem) new Gson().fromJson(str, new c().getType()), false);
        } catch (Throwable th2) {
            Log.d("Console", "call HomeBridgeAbility startCube error ");
            th2.printStackTrace();
        }
    }

    public final void r(Activity activity) {
        TransferAmountGuideActivity.Yf(activity);
    }

    public final void s(Activity activity) {
        Intent intent = new Intent(activity, MessageActivity.class);
        if (!r.x().F0()) {
            rn.c.i().d(activity, new JumpTarget(intent, (Intent) null));
        } else if (!NetworkStatus.c(activity)) {
            HuobiToastUtil.j(R.string.server_error);
        } else {
            activity.startActivity(intent);
        }
    }

    public final void t(Activity activity, String str) {
        String string = JsonTool.parseObject(str).getString("symbol");
        f.C(activity, string, false, TradeType.getTradeTypeBySymbol(string));
    }

    public final void u(Activity activity) {
        rn.c.i().o(activity, new JumpTarget((Intent) null, (Intent) null));
    }

    public final void v(Activity activity, String str) {
        A(activity, "");
    }

    public final void w(Activity activity) {
        zn.a.d().v(Uri.parse("holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/otc/index")).a().c();
    }

    @AfterPermissionGranted(123)
    public final void x(Activity activity) {
        String[] strArr;
        d.i("startQrScan");
        if (Build.VERSION.SDK_INT >= 33) {
            strArr = new String[]{"android.permission.CAMERA", PermissionConfig.READ_MEDIA_IMAGES};
        } else {
            strArr = new String[]{"android.permission.CAMERA", PermissionConfig.WRITE_EXTERNAL_STORAGE};
        }
        PermissionUtils.g(activity, new a(activity, strArr));
    }

    public final void z(Activity activity, String str) {
        JSONObject parseObject = JsonTool.parseObject(str);
        int parseInt = Integer.parseInt(parseObject.getString("primaryTitle"));
        String string = parseObject.getString("secondaryTitle");
        int parseInt2 = Integer.parseInt(parseObject.getString("filter"));
        Intent l11 = k0.l(activity);
        Bundle bundle = new Bundle();
        bundle.putInt("primaryTitle", parseInt);
        bundle.putString("secondaryTitle", string);
        bundle.putInt("filter", parseInt2);
        if (parseObject.getJSONObject("title") != null) {
            String string2 = parseObject.getJSONObject("title").getString("sortType");
            String string3 = parseObject.getJSONObject("title").getString("sort");
            if (string2 != null) {
                bundle.putInt("sortType", Integer.parseInt(string2));
            }
            if (string3 != null) {
                bundle.putInt("sort", Integer.parseInt(string3));
            }
        }
        l11.putExtras(bundle);
        activity.startActivity(l11);
    }
}
