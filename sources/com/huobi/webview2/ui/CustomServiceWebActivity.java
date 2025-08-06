package com.huobi.webview2.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import java.util.List;
import java.util.Map;
import pro.huobi.R;

public class CustomServiceWebActivity extends HBBaseWebActivity {

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            CustomServiceWebActivity.this.setCloseTvVisible(false);
            int color = CustomServiceWebActivity.this.getResources().getColor(R.color.color_14181F);
            if (NightHelper.e().g()) {
                color = CustomServiceWebActivity.this.getResources().getColor(R.color.color_CFD3E9);
            }
            CustomServiceWebActivity.this.fontIconTextViewRightOne.setVisibility(0);
            CustomServiceWebActivity.this.fontIconTextViewRightOneScroll.setVisibility(0);
            CustomServiceWebActivity.this.fontIconTextViewRightOne.clearColorFilter();
            CustomServiceWebActivity.this.fontIconTextViewRightOneScroll.clearColorFilter();
            CustomServiceWebActivity.this.fontIconTextViewRightOne.setColorFilter(color);
            CustomServiceWebActivity.this.fontIconTextViewRightOneScroll.setColorFilter(color);
            CustomServiceWebActivity.this.fontIconTextViewRightOne.requestLayout();
            CustomServiceWebActivity.this.fontIconTextViewRightOneScroll.requestLayout();
        }
    }

    public static Intent createIntent(Context context, String str, String str2) {
        Intent intent = new Intent(context, CustomServiceWebActivity.class);
        intent.addFlags(67108864);
        intent.putExtra("url", str);
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra("title", str2);
        }
        return intent;
    }

    public void init() {
        super.init();
        setWebViewRefreshType("0");
        setCloseTvVisible(false);
        if (isSupportBlankLabel()) {
            this.mWebView.getSettings().setSupportMultipleWindows(true);
        }
    }

    public boolean isSupportBlankLabel() {
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onPageLoadFinished() {
        super.onPageLoadFinished();
        ViewUtil.m(this.mCloseBtn, false);
        ViewUtil.m(this.mCloseBtnScroll, false);
    }

    public void onShareClick() {
    }

    public void showTopIcon(List<Map<String, String>> list) {
        super.showTopIcon(list);
        runOnUiThread(new a());
    }
}
