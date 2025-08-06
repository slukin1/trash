package com.huobi.login.ui;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.util.ConfigPreferences;
import com.huobi.login.presenter.SecurityGuidePresenter;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.d;
import java.util.Map;
import kn.a;
import pro.huobi.R;
import sn.f;

public class SecurityGuideActivity extends BaseActivity<SecurityGuidePresenter, SecurityGuidePresenter.a> implements View.OnClickListener, SecurityGuidePresenter.a {

    /* renamed from: b  reason: collision with root package name */
    public TextView f75579b;

    /* renamed from: c  reason: collision with root package name */
    public Button f75580c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f75581d;

    public static boolean Zf(Activity activity, a aVar) {
        String e11 = ConfigPreferences.e("user_config", "config_current_uid", "");
        if (TextUtils.isEmpty(e11)) {
            return false;
        }
        int g11 = ConfigPreferences.g("user_config", "UNLOCK_GUIDE_TIP_TIMES", 0);
        d.e("UNLOCK", "unlock_guide_tip_times - " + g11);
        if (g11 > 3) {
            return false;
        }
        if (ConfigPreferences.g("user_config", e11 + "_" + "config_gesture_switch", 1) != 3) {
            if (TextUtils.isEmpty(ConfigPreferences.e("user_config", e11 + "_" + "config_gesture", ""))) {
                Intent intent = new Intent(activity, UnlockGuideActivity.class);
                f.c(intent, aVar);
                activity.startActivity(intent);
                return true;
            }
        }
        return false;
    }

    /* renamed from: Xf */
    public SecurityGuidePresenter createPresenter() {
        return new SecurityGuidePresenter();
    }

    /* renamed from: Yf */
    public SecurityGuidePresenter.a getUI() {
        return this;
    }

    public void addEvent() {
        TextView textView = this.f75579b;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        Button button = this.f75580c;
        if (button != null) {
            button.setOnClickListener(this);
        }
    }

    public int getContentView() {
        return R.layout.activity_security_guide;
    }

    public void initView() {
        this.f75579b = (TextView) findViewById(R.id.btn_guide_close);
        this.f75580c = (Button) findViewById(R.id.btn_guide_into);
        this.f75581d = (TextView) findViewById(R.id.gesture_top_tips);
        if (gj.a.b().c()) {
            this.f75581d.setText(getString(R.string.n_login_fast_login_tip));
        } else {
            this.f75581d.setText(getString(R.string.gesture_guide_tips));
        }
    }

    public void onBackPressed() {
        ((SecurityGuidePresenter) getPresenter()).T();
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        if (view.getId() == R.id.btn_guide_close) {
            is.a.i("4849", (Map<String, Object>) null);
            ((SecurityGuidePresenter) getPresenter()).T();
        } else if (view.getId() == R.id.btn_guide_into) {
            is.a.i("4850", (Map<String, Object>) null);
            ((SecurityGuidePresenter) getPresenter()).U();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
