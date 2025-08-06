package com.huobi.login.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import bh.j;
import bh.u;
import com.blankj.utilcode.util.ToastUtils;
import com.hbg.lib.common.utils.SystemUtils;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.util.ChannelUtils;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.widgets.CommonCheckBox;
import com.huobi.app.H5CacheServiceHelper;
import com.huobi.app.HbMgtConfigHelper;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.domain.DomainSwitcher;
import com.huobi.domain.DomainTest;
import com.huobi.login.presenter.ChooseEnvironmentPresenter;
import com.huobi.utils.HBHTtoHTXManager;
import com.huobi.utils.HomeHelper;
import com.huobi.utils.d;
import com.huobi.utils.w;
import com.huobi.utils.x;
import com.huobi.view.InputView;
import com.huochat.community.network.domain.DomainTool;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import gj.e;
import i6.i;
import java.util.concurrent.TimeUnit;
import pro.huobi.R;
import rx.Observable;
import sn.l;
import u6.g;
import wn.c0;

public class ChooseEnvironmentActivity extends BaseActivity<ChooseEnvironmentPresenter, ChooseEnvironmentPresenter.a> implements ChooseEnvironmentPresenter.a, View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public Button f75541b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f75542c = true;

    /* renamed from: d  reason: collision with root package name */
    public CommonCheckBox f75543d;

    /* renamed from: e  reason: collision with root package name */
    public View f75544e;

    /* renamed from: f  reason: collision with root package name */
    public View f75545f;

    /* renamed from: g  reason: collision with root package name */
    public CommonCheckBox f75546g;

    /* renamed from: h  reason: collision with root package name */
    public InputView f75547h;

    /* renamed from: i  reason: collision with root package name */
    public InputView f75548i;

    /* renamed from: j  reason: collision with root package name */
    public InputView f75549j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f75550k;

    /* renamed from: l  reason: collision with root package name */
    public Runnable f75551l = new d();

    public class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SharedPreferences f75552b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f75553c;

        public a(SharedPreferences sharedPreferences, String str) {
            this.f75552b = sharedPreferences;
            this.f75553c = str;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            String inputText = ChooseEnvironmentActivity.this.f75547h.getInputText();
            this.f75552b.edit().putString(this.f75553c, inputText).apply();
            ToastUtils.t("已保存默认地址为" + inputText);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b extends q6.d<Long> {
        public b(g gVar) {
            super(gVar);
        }

        public void onNext(Long l11) {
            super.onNext(l11);
            boolean unused = ChooseEnvironmentActivity.this.f75542c = false;
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            boolean unused = ChooseEnvironmentActivity.this.f75542c = false;
        }
    }

    public class d implements Runnable {

        public class a implements d.b {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ int f75558a;

            public a(int i11) {
                this.f75558a = i11;
            }

            public void a() {
                ChooseEnvironmentActivity.this.qh(this.f75558a);
                l.p(ChooseEnvironmentActivity.this);
            }

            public void b() {
                ChooseEnvironmentActivity.this.qh(this.f75558a);
                l.o(ChooseEnvironmentActivity.this);
            }
        }

        public d() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b() {
            com.huobi.utils.d.b().c(new a(ConfigPreferences.g("config_username", "config_welcomes_show", 1)), false);
        }

        public void run() {
            try {
                i.b().h(this);
                if (ChooseEnvironmentActivity.this.f75542c) {
                    i.b().g(ChooseEnvironmentActivity.this.f75551l, 500);
                    return;
                }
                ConfigPreferences.k("user_config", "app_exit", 0);
                i.b().g(new pn.c(this), 0);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        DomainTest.b(!DomainTest.a());
        this.f75543d.setChecked(DomainTest.a());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void rh(View view) {
        boolean z11 = !jp.l.f84348f;
        jp.l.f84348f = z11;
        this.f75546g.setChecked(z11);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void Qg(String str, String str2) {
        i6.d.j("VulcanSdk", "debug domain - " + "https://rc-data-collection.global-base.tc-jp1.huobiapps.com");
        iu.a.f().i(j.c(), "https://rc-data-collection.global-base.tc-jp1.huobiapps.com", 1, ChannelUtils.a(), true);
        ConfigPreferences.m("user_config", "choose_environment", str2);
        wi.b.a();
        if (!TextUtils.isEmpty(str)) {
            wi.b.f48040d = String.format("https://www.%s.tc-jp1.huobiapps.com/", new Object[]{str});
            wi.b.f48048l = String.format("wss://www.%s.tc-jp1.huobiapps.com/-/s/pro/ws", new Object[]{str});
            wi.b.f48049m = String.format("wss://hbg-c2c-np.%s.tc-jp1.huobiapps.com/ws", new Object[]{str});
            wi.b.f48038b = String.format("https://www.%s.tc-jp1.huobiapps.com", new Object[]{str});
            wi.b.f48039c = String.format("https://bitex-uc-gateway.%s.tc-jp1.huobiapps.com/", new Object[]{str});
            wi.b.f48047k = String.format("https://m.%s.tc-jp1.huobiapps.com", new Object[]{str});
            wi.b.f48059w = String.format("otc-wss.%s.tc-jp1.huobiapps.com", new Object[]{str});
            wi.b.f48042f = String.format("https://www.%s.tc-jp1.huobiapps.com/-/x/otc/", new Object[]{str});
            wi.b.f48062z = String.format("https://c2c.%s.tc-jp1.huobiapps.com", new Object[]{str});
            wi.b.f48060x = String.format("https://rc-actuator.%s.tc-jp1.huobiapps.com", new Object[]{str});
            wi.b.A = String.format("https://huobi-woodpecker-app.%s.tc-jp1.huobiapps.com", new Object[]{str});
            wi.b.f48043g = String.format("https://www.%s.tc-jp1.huobiapps.com", new Object[]{str});
            wi.b.f48061y = String.format("https://www.%s.tc-jp1.huobiapps.com", new Object[]{str});
            wi.b.f48044h = String.format("https://futures.%s.tc-jp1.huobiapps.com", new Object[]{str});
            wi.b.f48045i = String.format("https://futures.%s.tc-jp1.huobiapps.com", new Object[]{str});
            wi.b.f48046j = String.format("https://futures.%s.tc-jp1.huobiapps.com", new Object[]{str});
            wi.b.f48051o = String.format("wss://futures.%s.tc-jp1.huobiapps.com/swap-ws", new Object[]{str});
            wi.b.f48052p = String.format("wss://futures.%s.tc-jp1.huobiapps.com/linear-swap-ws", new Object[]{str});
            wi.b.f48054r = String.format("wss://futures.%s.tc-jp1.huobiapps.com/option-ws", new Object[]{str});
            wi.b.f48055s = String.format("wss://futures.%s.tc-jp1.huobiapps.com/ws_index", new Object[]{str});
            wi.b.f48050n = String.format("wss://futures.%s.tc-jp1.huobiapps.com/ws", new Object[]{str});
            wi.b.f48056t = String.format("https://futures-h5.%s.tc-jp1.huobiapps.com", new Object[]{str});
            wi.b.f48053q = String.format("https://futures-h5.%s.tc-jp1.huobiapps.com", new Object[]{str});
            String inputText = this.f75548i.getInputText();
            if (!TextUtils.isEmpty(inputText)) {
                wi.b.f48044h = inputText;
                wi.b.f48045i = inputText;
                wi.b.f48046j = inputText;
                wi.b.f48051o = inputText.replace("http", "ws");
                wi.b.f48052p = inputText.replace("http", "ws");
                wi.b.f48054r = inputText.replace("http", "ws");
                wi.b.f48055s = inputText.replace("http", "ws");
                wi.b.f48050n = inputText.replace("http", "ws");
            }
            String inputText2 = this.f75549j.getInputText();
            if (!TextUtils.isEmpty(inputText2)) {
                wi.b.f48056t = inputText2;
                wi.b.f48053q = inputText2;
            }
        }
        u.c(j.c());
        DomainSwitcher.H0(wi.b.f48038b.replace(DomainTool.DOMAIN_PREFIX, ""));
        DomainSwitcher.u0(wi.b.f48043g.replace(DomainTool.DOMAIN_PREFIX, ""));
        HomeHelper.g();
        qu.d.i().t();
        gj.d.n().I();
        gj.g.e().h();
        is.a.h();
        is.a.v();
        HbMgtConfigHelper.a();
        H5CacheServiceHelper.init();
        uh.i.d().l();
        uh.i.d().m();
        w.d().f();
        LegalCurrencyConfigUtil.b0();
        c0.k();
        HBHTtoHTXManager.f83692a.c();
        x.g(true);
        Observable.timer(2, TimeUnit.SECONDS).subscribe(new b(getUI()));
    }

    public void addEvent() {
        this.viewFinder.b(R.id.choose_dev20_btn).setOnClickListener(this);
        this.f75541b.setOnClickListener(this);
        this.f75544e.setOnClickListener(new pn.a(this));
        this.f75545f.setOnClickListener(new pn.b(this));
    }

    public int getContentView() {
        return R.layout.activity_choose_enviroment;
    }

    public void initView() {
        this.f75541b = (Button) this.viewFinder.b(R.id.choose_release_btn);
        this.f75543d = (CommonCheckBox) this.viewFinder.b(R.id.id_old_version_checkbox);
        this.f75546g = (CommonCheckBox) this.viewFinder.b(R.id.id_otc_hd_checkbox);
        this.f75547h = (InputView) this.viewFinder.b(R.id.input_view_choose_env);
        this.f75548i = (InputView) this.viewFinder.b(R.id.input_view_contract_base);
        this.f75549j = (InputView) this.viewFinder.b(R.id.input_view_contract_h5);
        this.f75544e = this.viewFinder.b(R.id.layout_choose_env_release);
        this.f75545f = this.viewFinder.b(R.id.layout_choose_env_otc);
        this.f75550k = (TextView) this.viewFinder.b(R.id.save_btn);
        SharedPreferences sharedPreferences = getSharedPreferences("global-test", 0);
        this.f75547h.setInputText(sharedPreferences.getString("global-test", "global-base"));
        this.f75550k.setOnClickListener(new a(sharedPreferences, "global-test"));
    }

    /* renamed from: oh */
    public ChooseEnvironmentPresenter createPresenter() {
        return new ChooseEnvironmentPresenter();
    }

    public void onBackPressed() {
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        String inputText = this.f75547h.getInputText();
        switch (view.getId()) {
            case R.id.choose_dev20_btn:
                Qg(inputText, "environment_dev20");
                break;
            case R.id.choose_release_btn:
                ConfigPreferences.m("user_config", "choose_environment", "environment_release");
                SystemUtils.f67493a = true;
                c9.c.b().f70560a = true;
                sh();
                wi.b.a();
                u.c(j.c());
                break;
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStatusBarColor(getResources().getColor(R.color.global_large_divider_color));
        i.b().g(this.f75551l, 2000);
    }

    /* renamed from: ph */
    public ChooseEnvironmentPresenter.a getUI() {
        return this;
    }

    public final void qh(int i11) {
        int g11 = ConfigPreferences.g("config_username", "config_first_V10", 1);
        if (i11 != 1 && g11 == 1) {
            ConfigPreferences.k("config_username", "config_first_update_v10_user", 1);
        }
        if (i11 == 1) {
            if (!gj.a.b().c()) {
                ConfigPreferences.k("config_username", "config_welcomes_show", 0);
            }
            Intent d11 = e.b().d(this);
            if (i11 == 1) {
                d11.putExtra("App_launch_type", 0);
            } else {
                d11.putExtra("App_launch_type", 1);
            }
            d11.putExtra("will_return", false);
            if (gj.a.b().c()) {
                startActivity(d11);
                overridePendingTransition(R.anim.splash_alpha_in, R.anim.splash_alpha_out);
            } else {
                startActivity(d11);
            }
        } else if (e.b().f()) {
            ConfigPreferences.k("user_config", "app_exit", 0);
            startActivity(e.c(this));
        } else {
            e.b().e(this);
        }
        finish();
    }

    public final void sh() {
        DomainSwitcher.a0();
        DomainSwitcher.A().V0();
        i.b().g(new c(), 2000);
    }
}
