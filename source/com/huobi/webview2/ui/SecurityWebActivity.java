package com.huobi.webview2.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import java.io.Serializable;
import java.util.Locale;

public class SecurityWebActivity extends HBBaseWebActivity {
    public static Intent createIntent(Context context, String str, String str2) {
        Intent intent = new Intent(context, SecurityWebActivity.class);
        intent.addFlags(67108864);
        intent.putExtra("url", str);
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra("title", str2);
        }
        return intent;
    }

    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra("locale");
            if (serializableExtra instanceof Locale) {
                Resources resources = getResources();
                Configuration configuration = new Configuration(resources.getConfiguration());
                DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                configuration.locale = (Locale) serializableExtra;
                resources.updateConfiguration(configuration, displayMetrics);
            }
        }
        super.onCreate(bundle);
    }
}
