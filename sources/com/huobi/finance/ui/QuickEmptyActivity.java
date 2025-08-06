package com.huobi.finance.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.core.ui.EmptyMVPActivity;
import com.huobi.utils.k0;
import d7.a1;
import nq.a;
import pro.huobi.R;

public class QuickEmptyActivity extends EmptyMVPActivity {
    /* access modifiers changed from: private */
    public /* synthetic */ void Zf() {
        finish();
    }

    public static void fg(Context context, String str, boolean z11) {
        Intent intent = new Intent(context, QuickEmptyActivity.class);
        intent.putExtra(FirebaseAnalytics.Param.CURRENCY, str);
        intent.putExtra("isBuy", z11);
        context.startActivity(intent);
    }

    public final void Yf(String str, boolean z11) {
        String t11 = a1.v().t(str);
        if (a.d(t11)) {
            a.i(this, getSupportFragmentManager(), t11, z11, new h7(this));
            return;
        }
        k0.O(this, t11, z11);
        finish();
    }

    public int getContentView() {
        return R.layout.activity_quick_empty_layout;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        Yf(intent.getStringExtra(FirebaseAnalytics.Param.CURRENCY), intent.getBooleanExtra("isBuy", false));
    }
}
