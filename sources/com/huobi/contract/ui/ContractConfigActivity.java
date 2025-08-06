package com.huobi.contract.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import bj.p0;
import com.hbg.lib.data.symbol.TradeType;
import com.huobi.app.AbstractCommonListActivity;
import com.huobi.contract.helper.ContractPriceProtectionHelper;
import com.huobi.login.bean.JumpTarget;
import com.huobi.main.ui.HuobiMainActivity;
import com.huobi.utils.k0;
import com.huobi.webview2.ui.ContractWebActivity;
import dj.f;
import dj.g;
import hr.b;
import hr.c;
import hr.d;
import java.util.List;
import pro.huobi.R;
import tg.r;

public class ContractConfigActivity extends AbstractCommonListActivity {

    /* renamed from: g  reason: collision with root package name */
    public boolean f43199g = false;

    /* renamed from: h  reason: collision with root package name */
    public c.a f43200h = new a();

    /* renamed from: i  reason: collision with root package name */
    public b.a f43201i = new b();

    /* renamed from: j  reason: collision with root package name */
    public d.a f43202j = new c();

    public class a implements c.a {
        public a() {
        }

        public String D(int i11) {
            if (i11 == 4) {
                boolean z11 = !p0.h();
                if (!z11) {
                    return ContractConfigActivity.this.getString(R.string.contract_setting_panel_same);
                }
                if (z11) {
                    return ContractConfigActivity.this.getString(R.string.contract_setting_panel_split);
                }
            }
            return "";
        }

        public void E(int i11, int i12) {
            if (i11 == 4) {
                p0.o(i12 == 0 ? 1 : 0);
            }
        }

        public boolean F() {
            return ContractConfigActivity.this.getIntent().getBooleanExtra("AUTO_EXPAND", false);
        }

        public String a(int i11) {
            return i11 != 4 ? "" : ContractConfigActivity.this.getString(R.string.n_contract_side_mode_setting_currency_standard_transaction_panel);
        }

        public void b(int i11) {
        }
    }

    public class b implements b.a {
        public b() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void f() {
            ContractConfigActivity.this.Fh(0);
        }

        public String a(int i11) {
            if (i11 == 2) {
                return ContractConfigActivity.this.getString(R.string.contract_setting_limit_order_confirmation);
            }
            if (i11 == 3) {
                return ContractConfigActivity.this.getString(R.string.contract_setting_plan_order_confirmation);
            }
            if (i11 == 5) {
                return ContractConfigActivity.this.getString(R.string.n_setting_contract_order_reverse_confirm);
            }
            if (i11 == 6) {
                return ContractConfigActivity.this.getString(R.string.n_setting_timing_order_confirm);
            }
            if (i11 == 7) {
                return ContractConfigActivity.this.getString(R.string.n_setting_market_closing_confirm);
            }
            if (i11 != 100) {
                return null;
            }
            return ContractConfigActivity.this.getString(R.string.n_contract_price_spread_protection);
        }

        public void b(int i11) {
            if (i11 == 100) {
                ContractPriceProtectionHelper.f(ContractConfigActivity.this, TradeType.parse(ContractConfigActivity.this.getIntent().getStringExtra("trade_type")), "BTC", "BTC-USDT", "BTC-USDT");
            }
        }

        public int c(int i11) {
            if (i11 != 100) {
                return 0;
            }
            return R.drawable.contract_setting_item_help;
        }

        public void d(int i11, boolean z11) {
            if (i11 == 2) {
                p0.j(z11 ? 1 : 0);
                ContractConfigActivity.this.Fh(1);
            } else if (i11 == 3) {
                p0.l(z11);
                ContractConfigActivity.this.Fh(2);
            } else if (i11 == 5) {
                p0.n(z11);
                ContractConfigActivity.this.Fh(5);
            } else if (i11 == 6) {
                p0.p(z11);
                ContractConfigActivity.this.Fh(3);
            } else if (i11 == 7) {
                p0.i(z11);
                ContractConfigActivity.this.Fh(4);
            } else if (i11 == 100) {
                ContractPriceProtectionHelper.d(z11, new g(this));
            }
        }

        public boolean s(int i11) {
            if (i11 == 2) {
                return p0.b();
            }
            if (i11 == 3) {
                return p0.c();
            }
            if (i11 == 5) {
                return p0.f();
            }
            if (i11 == 6) {
                return p0.d();
            }
            if (i11 == 7) {
                return p0.a();
            }
            if (i11 != 100) {
                return false;
            }
            return p0.e();
        }
    }

    public class c implements d.a {
        public c() {
        }

        public String D(int i11) {
            return null;
        }

        public boolean E8(int i11, View view) {
            return true;
        }

        public String a(int i11) {
            return ContractConfigActivity.this.getString(R.string.n_contract_message_email_setting);
        }

        public void onItemClick(int i11) {
            if (!r.x().F0()) {
                rn.c.i().d(ContractConfigActivity.this, new JumpTarget((Intent) null, (Intent) null));
                boolean unused = ContractConfigActivity.this.f43199g = true;
                return;
            }
            ContractWebActivity.mi(ContractConfigActivity.this, "/contract_message_settings");
        }

        public boolean v8(int i11) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ph() {
        Fh(0);
    }

    public static void Qh(Context context, boolean z11, String str, String str2) {
        if (context != null) {
            Intent intent = new Intent(context, ContractConfigActivity.class);
            intent.putExtra("AUTO_EXPAND", z11);
            intent.putExtra("action", str);
            intent.putExtra("trade_type", str2);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            rn.c.i().d(context, new JumpTarget(intent, (Intent) null));
        }
    }

    public void Bh() {
    }

    public void Ch() {
    }

    public String Qg() {
        return "";
    }

    public void finish() {
        super.finish();
        if (TextUtils.isEmpty(getIntent().getStringExtra("action"))) {
            Activity h11 = oa.a.g().h();
            boolean z11 = false;
            if (h11 != null && (h11 instanceof HuobiMainActivity)) {
                z11 = true;
            }
            startActivity(k0.d(this, z11));
            return;
        }
        Intent intent = new Intent(this, HuobiMainActivity.class);
        intent.putExtra("navigator_action", getIntent().getStringExtra("action"));
        startActivity(intent);
    }

    public String oh() {
        return getString(R.string.contract_trade_popwindow_item_unit_setting);
    }

    public void onRestart() {
        super.onRestart();
        Dh();
        if (this.f43199g && r.x().F0() && !r.x().X()) {
            ContractWebActivity.mi(this, "/contract_message_settings");
        }
        this.f43199g = false;
    }

    public void onResume() {
        super.onResume();
        ContractPriceProtectionHelper.b(new f(this));
    }

    public List<s9.a> qh(List<s9.a> list) {
        list.add(new hr.b(100, this.f43201i));
        list.add(new hr.b(2, this.f43201i));
        list.add(new hr.b(3, this.f43201i));
        list.add(new hr.b(6, this.f43201i));
        list.add(new hr.b(7, this.f43201i));
        list.add(new hr.b(5, this.f43201i));
        if (!r.x().F0() || !r.x().X()) {
            list.add(new d(3, this.f43202j));
        }
        list.add(new hr.c(4, this.f43200h));
        return list;
    }

    public boolean th() {
        return false;
    }

    public boolean uh() {
        return false;
    }
}
