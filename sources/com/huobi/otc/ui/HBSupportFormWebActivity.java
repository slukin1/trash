package com.huobi.otc.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.R$string;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.core.webview.HBWebView;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.otc.event.FromWebPageBackEvent;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;
import sp.q;
import v6.w;

public class HBSupportFormWebActivity extends HBBaseWebActivity {

    /* renamed from: c  reason: collision with root package name */
    public static List<Map<String, Object>> f79245c;

    /* renamed from: b  reason: collision with root package name */
    public String f79246b;

    public static boolean Ah(Context context, Intent intent, List<Map<String, Object>> list) {
        if (context == null || !(context instanceof Activity)) {
            return false;
        }
        if (!NetworkStatus.c(context)) {
            HuobiToastUtil.k(context, R$string.string_network_disconnect);
            return false;
        }
        ArrayList arrayList = new ArrayList(list.size());
        f79245c = arrayList;
        arrayList.addAll(list);
        intent.putExtra("post_commit_type", "post_commit_queue");
        context.startActivity(intent);
        return true;
    }

    public static boolean Bh(Context context, String str, String str2, String str3, boolean z11, String str4) {
        if (context == null || !(context instanceof Activity)) {
            return false;
        }
        if (!NetworkStatus.c(context)) {
            HuobiToastUtil.k(context, R$string.string_network_disconnect);
            return false;
        }
        Intent intent = new Intent(context, HBSupportFormWebActivity.class);
        intent.putExtra("url", str);
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra("title", str2);
        }
        intent.putExtra("title_back", str3);
        intent.putExtra("isauth", z11);
        intent.putExtra("form_data", str4);
        intent.putExtra("post_commit_type", "post_commit_common");
        context.startActivity(intent);
        return true;
    }

    public static Intent yh(Context context, String str, String str2, String str3, boolean z11) {
        Intent intent = new Intent(context, HBSupportFormWebActivity.class);
        intent.putExtra("url", str);
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra("title", str2);
        }
        intent.putExtra("title_back", str3);
        intent.putExtra("isauth", z11);
        return intent;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void zh(String str, String str2) {
        HBWebView hBWebView = this.mWebView;
        byte[] bytes = str2.getBytes();
        hBWebView.postUrl(str, bytes);
        SensorsDataAutoTrackHelper.postUrl2(hBWebView, str, bytes);
    }

    public void loadUrl(String str) {
        String w11 = StringUtils.w(buildParams(str));
        this.mWebView.clearHistory();
        HashMap hashMap = new HashMap();
        hashMap.put("Accept-Language", AppLanguageHelper.getInstance().getCurLanguageHeader());
        if (this.mIsAuth) {
            w.e().m(this.mWebView, w11);
        }
        if (getIntent().getBooleanExtra("is_support_third_cookies", false)) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(this.mWebView, true);
        }
        if (TextUtils.equals(getIntent().getStringExtra("post_commit_type"), "post_commit_common")) {
            if (!TextUtils.isEmpty(this.f79246b)) {
                HBWebView hBWebView = this.mWebView;
                byte[] bytes = this.f79246b.getBytes();
                hBWebView.postUrl(w11, bytes);
                SensorsDataAutoTrackHelper.postUrl2(hBWebView, w11, bytes);
                return;
            }
            HBWebView hBWebView2 = this.mWebView;
            Map<String, String> buildHeaders = buildHeaders(hashMap);
            hBWebView2.loadUrl(w11, buildHeaders);
            SensorsDataAutoTrackHelper.loadUrl2(hBWebView2, w11, buildHeaders);
        } else if (!TextUtils.equals(getIntent().getStringExtra("post_commit_type"), "post_commit_queue")) {
        } else {
            if (!CollectionsUtils.b(f79245c)) {
                for (Map next : f79245c) {
                    String str2 = (String) next.get("postUrl");
                    String str3 = (String) next.get("postForm");
                    if (str3 == null) {
                        str3 = "";
                    }
                    if (f79245c.indexOf(next) == 0) {
                        HBWebView hBWebView3 = this.mWebView;
                        byte[] bytes2 = str3.getBytes();
                        hBWebView3.postUrl(str2, bytes2);
                        SensorsDataAutoTrackHelper.postUrl2(hBWebView3, str2, bytes2);
                    } else {
                        this.mWebView.postDelayed(new q(this, str2, str3), 3000);
                    }
                }
                return;
            }
            HBWebView hBWebView4 = this.mWebView;
            Map<String, String> buildHeaders2 = buildHeaders(hashMap);
            hBWebView4.loadUrl(w11, buildHeaders2);
            SensorsDataAutoTrackHelper.loadUrl2(hBWebView4, w11, buildHeaders2);
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        EventBus.d().k(new FromWebPageBackEvent());
    }

    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.f79246b = intent.getStringExtra("form_data");
        }
        super.onCreate(bundle);
    }

    public void onDestroy() {
        super.onDestroy();
        List<Map<String, Object>> list = f79245c;
        if (list != null) {
            list.clear();
            f79245c = null;
        }
    }
}
