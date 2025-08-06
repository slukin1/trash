package com.huobi.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.huobi.index.bean.IndexFeatureItem;
import is.a;
import java.io.Serializable;
import java.util.HashMap;
import yl.o;

public class JumpActivity extends BaseCoreActivity {
    public static Intent Af(Context context, String str) {
        Intent intent = new Intent(context, JumpActivity.class);
        intent.putExtra("PUSH_DATA", str);
        return intent;
    }

    public static Intent nf(Context context, IndexFeatureItem indexFeatureItem) {
        Intent intent = new Intent(context, JumpActivity.class);
        intent.putExtra("PUSH_FEATURE_DATA", indexFeatureItem);
        return intent;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(new View(this));
        String stringExtra = getIntent().getStringExtra("PUSH_DATA");
        if (!TextUtils.isEmpty(stringExtra)) {
            o.p(this, o.w(stringExtra));
        } else if (getIntent().hasExtra("PUSH_FEATURE_DATA")) {
            Serializable serializableExtra = getIntent().getSerializableExtra("PUSH_FEATURE_DATA");
            if (serializableExtra instanceof IndexFeatureItem) {
                IndexFeatureItem indexFeatureItem = (IndexFeatureItem) serializableExtra;
                o.p(this, indexFeatureItem);
                HashMap hashMap = new HashMap();
                hashMap.put("title", indexFeatureItem.getTitle());
                a.i("4826", hashMap);
            }
        }
        finish();
    }
}
