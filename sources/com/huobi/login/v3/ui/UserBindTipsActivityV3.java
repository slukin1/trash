package com.huobi.login.v3.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import b2.a;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.ui.BaseActivity;
import com.huobi.login.v3.presenter.UserBindTipsPresenter;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.android.tpush.common.Constants;
import com.tencent.imsdk.BaseConstants;
import gs.g;
import java.util.HashMap;
import pro.huobi.R;

public class UserBindTipsActivityV3 extends BaseActivity<UserBindTipsPresenter, UserBindTipsPresenter.a> implements UserBindTipsPresenter.a, View.OnClickListener {
    /* renamed from: Xf */
    public UserBindTipsPresenter createPresenter() {
        return new UserBindTipsPresenter();
    }

    /* renamed from: Yf */
    public UserBindTipsPresenter.a getUI() {
        return this;
    }

    public final void Zf() {
        a.d().a("/login/password_set_v2").withString("register_type", "register_email").withString(Constants.FLAG_ACCOUNT, ((UserBindTipsPresenter) getPresenter()).R()).withString("auth_token", ((UserBindTipsPresenter) getPresenter()).Q()).withString("third_token", ((UserBindTipsPresenter) getPresenter()).T()).withString("bindType", ((UserBindTipsPresenter) getPresenter()).U()).navigation((Activity) this, (int) BaseConstants.ERR_SVR_CONV_ACCOUNT_NOT_FOUND);
        overridePendingTransition(0, 0);
        HashMap hashMap = new HashMap(2);
        hashMap.put("button_name", "新建账号");
        hashMap.put("sign_type", ((UserBindTipsPresenter) getPresenter()).U());
        g.i("app_login_button_click", hashMap);
    }

    public void addEvent() {
        this.viewFinder.b(R.id.login_close_btn).setOnClickListener(this);
        this.viewFinder.b(R.id.btn_create_new_account).setOnClickListener(this);
        this.viewFinder.b(R.id.btn_bind_account).setOnClickListener(this);
    }

    public int getContentView() {
        return R.layout.activity_user_binding_tips_v3;
    }

    public int getStatusBarColor() {
        return getResources().getColor(R.color.baseColorContentBackground);
    }

    public void initView() {
    }

    @SuppressLint({"NonConstantResourceId"})
    @SensorsDataInstrumented
    public void onClick(View view) {
        if (ViewUtil.c(1000)) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        int id2 = view.getId();
        if (id2 == R.id.btn_bind_account) {
            Intent intent = new Intent(this, UserRegisterActivityV3.class);
            intent.putExtra("bindType", ((UserBindTipsPresenter) getPresenter()).U());
            intent.putExtra("third_token", ((UserBindTipsPresenter) getPresenter()).T());
            intent.putExtra("bindEmail", ((UserBindTipsPresenter) getPresenter()).R());
            if (((UserBindTipsPresenter) getPresenter()).S() != null) {
                intent.putExtra("login_name", ((UserBindTipsPresenter) getPresenter()).S());
            }
            if (((UserBindTipsPresenter) getPresenter()).V() != null) {
                intent.putExtra("target", ((UserBindTipsPresenter) getPresenter()).V());
            }
            startActivityForResult(intent, BaseConstants.ERR_SVR_CONV_ACCOUNT_NOT_FOUND);
            overridePendingTransition(0, 0);
            HashMap hashMap = new HashMap(2);
            hashMap.put("button_name", "绑定已有账号");
            hashMap.put("sign_type", ((UserBindTipsPresenter) getPresenter()).U());
            g.i("app_login_button_click", hashMap);
        } else if (id2 == R.id.btn_create_new_account) {
            Zf();
        } else if (id2 == R.id.login_close_btn) {
            onBackPressed();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        HashMap hashMap = new HashMap(2);
        hashMap.put("Page_name", "绑定账号引导页");
        hashMap.put("sign_type", ((UserBindTipsPresenter) getPresenter()).U());
        g.i("App_login_pageview", hashMap);
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }
}
