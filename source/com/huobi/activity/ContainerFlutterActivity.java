package com.huobi.activity;

import android.os.Bundle;
import android.text.TextUtils;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;

public class ContainerFlutterActivity extends AbsGlobalFlutterActivity {

    /* renamed from: k  reason: collision with root package name */
    public String f42060k;

    public String Nh() {
        return this.f42060k;
    }

    public void onCreate(Bundle bundle) {
        try {
            String stringExtra = getIntent().getStringExtra("class_name");
            this.f42060k = stringExtra;
            if (TextUtils.isEmpty(stringExtra)) {
                finish();
            }
        } catch (Throwable unused) {
            finish();
        }
        super.onCreate(bundle);
    }
}
