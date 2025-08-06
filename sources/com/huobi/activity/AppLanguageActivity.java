package com.huobi.activity;

import android.view.View;
import android.widget.LinearLayout;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.lang.BaseLang;
import com.hbg.lib.core.lang.LocalLang;
import com.hbg.lib.core.ui.EmptyMVPActivity;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.huobi.utils.LanguageHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.d;
import java.util.ArrayList;
import java.util.List;
import pro.huobi.R;
import xg.p;

@Route(path = "/app/language")
public class AppLanguageActivity extends EmptyMVPActivity {

    /* renamed from: b  reason: collision with root package name */
    public final List<LanguageView> f42053b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public b f42054c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f42055d;

    /* renamed from: e  reason: collision with root package name */
    public int f42056e;

    /* renamed from: f  reason: collision with root package name */
    public int f42057f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f42058g = false;

    public class b implements View.OnClickListener {
        public b() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (!(view instanceof LanguageView)) {
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            LanguageView languageView = (LanguageView) view;
            if (languageView.isSelected()) {
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            AppLanguageActivity.this.Pg(languageView.getLang(), false);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Og() {
        dismissProgressDialog();
        finish();
    }

    public final void Pg(BaseLang baseLang, boolean z11) {
        d.e("AppLanguageActivity", "onSelectedLang:" + baseLang);
        if (!this.f42058g) {
            this.f42058g = true;
            LanguageHelper.b(baseLang);
            gg();
            showProgressDialog();
            ek.b.f47515a.g();
            oa.a.g().j(AppLanguageActivity.class);
            this.f42055d.postDelayed(new p(this), 1000);
        }
    }

    public final void Zf(BaseLang baseLang) {
        LanguageView languageView = new LanguageView(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.f42056e);
        int i11 = this.f42057f;
        languageView.setPadding(i11, 0, i11, 0);
        this.f42055d.addView(languageView, layoutParams);
        fg(languageView, baseLang);
    }

    public boolean canFullScreen() {
        return true;
    }

    public final void fg(LanguageView languageView, BaseLang baseLang) {
        languageView.setLocale(baseLang.getLocale());
        languageView.setText(baseLang.getCurAppLocaleName());
        languageView.setLang(baseLang);
        this.f42053b.add(languageView);
        languageView.setOnClickListener(this.f42054c);
    }

    public void finish() {
        super.finish();
    }

    public int getContentView() {
        return R.layout.app_language_view;
    }

    public final void gg() {
        String locale = AppLanguageHelper.getInstance().getCurAppLocale().toString();
        for (LanguageView next : this.f42053b) {
            if (locale.equals(next.getLocale().toString())) {
                next.d();
            } else {
                next.a();
            }
        }
    }

    public void initView() {
        super.initView();
        this.f42056e = PixelUtils.a(60.0f);
        this.f42057f = PixelUtils.a(15.0f);
        this.f42055d = (LinearLayout) findViewById(R.id.ll_content);
        this.f42054c = new b();
        for (LocalLang Zf : m6.a.f69017d) {
            Zf(Zf);
        }
        gg();
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }
}
