package com.huobi.litere.main.ui;

import android.content.Intent;
import com.huobi.litere.BaseLiteReFlutterActivity;
import com.huobi.utils.q0;
import i6.d;
import java.util.HashMap;

public class LiteReMainActivity extends BaseLiteReFlutterActivity {
    public String Nh() {
        return "lite_re_main_page";
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        String stringExtra = intent.getStringExtra("lite_navigator_action");
        d.i("LiteReMainActivity onNewIntent " + stringExtra);
        HashMap hashMap = new HashMap();
        hashMap.put("lite_navigator_action", stringExtra);
        this.f75409l.invokeMethod("toLiteMainPage", hashMap);
    }

    public void onStart() {
        super.onStart();
        q0.d().c(this);
    }
}
