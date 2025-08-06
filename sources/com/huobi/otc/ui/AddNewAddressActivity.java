package com.huobi.otc.ui;

import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.network.hbg.core.bean.UserBillingAddressBean;
import com.hbg.lib.network.otc.core.bean.MktRuleBean;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.otc.OtcModuleConfig;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$string;
import com.huobi.otc.persenter.AddNewAddressPresenter;
import com.tencent.imsdk.BaseConstants;
import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import sp.b;
import sp.d;
import sp.e;
import uf.c;

public class AddNewAddressActivity extends BaseActivity<AddNewAddressPresenter, AddNewAddressPresenter.c> implements AddNewAddressPresenter.c {

    /* renamed from: b  reason: collision with root package name */
    public AddNewAddressPresenter f79211b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f79212c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f79213d;

    /* renamed from: e  reason: collision with root package name */
    public EditText f79214e;

    /* renamed from: f  reason: collision with root package name */
    public EditText f79215f;

    /* renamed from: g  reason: collision with root package name */
    public EditText f79216g;

    /* renamed from: h  reason: collision with root package name */
    public EditText f79217h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f79218i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f79219j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f79220k;

    /* renamed from: l  reason: collision with root package name */
    public UserBillingAddressBean f79221l;

    /* renamed from: m  reason: collision with root package name */
    public TextView f79222m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f79223n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f79224o;

    /* renamed from: p  reason: collision with root package name */
    public ConstraintLayout f79225p;

    public class a implements TextWatcher {
        public a() {
        }

        public void afterTextChanged(Editable editable) {
            AddNewAddressActivity.this.vh();
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ph(Void voidR) {
        Intent intent = new Intent();
        intent.putExtra("choose_type", "choose_type_name");
        intent.putExtra("choose_from_add_address", true);
        OtcModuleConfig.b().P(this, intent, Integer.valueOf(BaseConstants.ERR_SVR_GROUP_API_NAME_ERROR));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void qh(Void voidR) {
        setResult(0);
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void rh(Void voidR) {
        Editable text = this.f79213d.getText();
        Editable text2 = this.f79214e.getText();
        if (text != null && text.toString().trim().length() < 4) {
            HuobiToastUtil.m(getString(R$string.n_otc_card_please_enter_info, new Object[]{getString(R$string.n_otc_card_pay_address_one)}));
        } else if (text2 == null || text2.toString().trim().isEmpty() || text2.toString().trim().length() >= 4) {
            HashMap hashMap = new HashMap();
            hashMap.put("otc_step", "click_save_address");
            c.b().h("otc_card_info_typein", hashMap);
            if (this.f79220k) {
                UserBillingAddressBean userBillingAddressBean = new UserBillingAddressBean();
                String addressLine1 = this.f79221l.getAddressLine1();
                if (!(addressLine1 == null || text == null || TextUtils.equals(addressLine1.trim(), text.toString().trim()))) {
                    userBillingAddressBean.setAddressLine1(text.toString().trim());
                }
                String addressLine2 = this.f79221l.getAddressLine2();
                if (!(addressLine2 == null || text2 == null || TextUtils.equals(addressLine2.trim(), text2.toString().trim()))) {
                    userBillingAddressBean.setAddressLine2(text2.toString().trim());
                }
                if (!(this.f79221l.getCity() == null || this.f79215f.getText() == null || TextUtils.equals(this.f79221l.getCity().trim(), this.f79215f.getText().toString().trim()))) {
                    userBillingAddressBean.setCity(this.f79215f.getText().toString().trim());
                }
                if (!(this.f79221l.getState() == null || this.f79216g.getText() == null || TextUtils.equals(this.f79221l.getState().trim(), this.f79216g.getText().toString().trim()))) {
                    userBillingAddressBean.setState(this.f79216g.getText().toString().trim());
                }
                if (!(this.f79221l.getZip() == null || this.f79217h.getText() == null || TextUtils.equals(this.f79221l.getZip().trim(), this.f79217h.getText().toString().trim()))) {
                    userBillingAddressBean.setZip(this.f79217h.getText().toString().trim());
                }
                userBillingAddressBean.setCardId(this.f79221l.getCardId());
                userBillingAddressBean.setCountryName(this.f79221l.getCountryName());
                userBillingAddressBean.setCountry(this.f79221l.getCountry());
                ((AddNewAddressPresenter) getPresenter()).S(userBillingAddressBean);
                return;
            }
            String str = "";
            this.f79221l.setAddressLine1(text == null ? str : text.toString().trim());
            this.f79221l.setAddressLine2(text2 == null ? str : text2.toString().trim());
            this.f79221l.setCity(this.f79215f.getText() == null ? str : this.f79215f.getText().toString().trim());
            this.f79221l.setState(this.f79216g.getText() == null ? str : this.f79216g.getText().toString().trim());
            UserBillingAddressBean userBillingAddressBean2 = this.f79221l;
            if (this.f79217h.getText() != null) {
                str = this.f79217h.getText().toString().trim();
            }
            userBillingAddressBean2.setZip(str);
            Intent intent = new Intent();
            intent.putExtra("userBillingAddressBean", this.f79221l);
            Pg(intent);
        } else {
            HuobiToastUtil.m(getString(R$string.n_otc_card_please_enter_info, new Object[]{getString(R$string.n_otc_card_pay_address_two)}));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void sh(View view, boolean z11) {
        if (z11) {
            this.f79213d.setText("");
            this.f79213d.setOnFocusChangeListener((View.OnFocusChangeListener) null);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void th(View view, boolean z11) {
        if (z11) {
            this.f79214e.setText("");
            this.f79214e.setOnFocusChangeListener((View.OnFocusChangeListener) null);
        }
    }

    public static void uh(Activity activity, boolean z11, UserBillingAddressBean userBillingAddressBean) {
        Intent intent = new Intent(activity, AddNewAddressActivity.class);
        intent.putExtra("key_is_manager_modify", z11);
        intent.putExtra("userBillingAddressBean", userBillingAddressBean);
        activity.startActivityForResult(intent, 0);
    }

    public void A5() {
        finish();
    }

    public void Pg(Intent intent) {
        setResult(-1, intent);
        finish();
    }

    /* renamed from: Qg */
    public AddNewAddressPresenter createPresenter() {
        AddNewAddressPresenter addNewAddressPresenter = new AddNewAddressPresenter();
        this.f79211b = addNewAddressPresenter;
        return addNewAddressPresenter;
    }

    public void W(MktRuleBean mktRuleBean) {
        if (mktRuleBean != null) {
            this.f79225p.setVisibility(0);
            this.f79223n.setText(mktRuleBean.getTitle());
            this.f79224o.setText(mktRuleBean.getContent());
        }
    }

    public void addEvent() {
        this.f79218i.setFocusable(false);
        Observable<Void> a11 = dw.a.a(this.f79218i);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        a11.throttleFirst(300, timeUnit).subscribe(new e(this));
        dw.a.a(this.f79212c).throttleFirst(300, timeUnit).subscribe(new sp.c(this));
        dw.a.a(this.f79219j).throttleFirst(300, timeUnit).subscribe(new d(this));
        this.f79213d.setOnFocusChangeListener(new sp.a(this));
        this.f79214e.setOnFocusChangeListener(new b(this));
    }

    public int getContentView() {
        return R$layout.activity_add_new_address;
    }

    public void initView() {
        this.f79212c = (ImageView) findViewById(R$id.add_new_address_back);
        this.f79213d = (EditText) findViewById(R$id.add_new_address_addressline1);
        this.f79214e = (EditText) findViewById(R$id.add_new_address_addressline2);
        this.f79215f = (EditText) findViewById(R$id.add_new_address_city);
        this.f79216g = (EditText) findViewById(R$id.add_new_address_state);
        this.f79217h = (EditText) findViewById(R$id.add_new_address_zipcode);
        this.f79218i = (TextView) findViewById(R$id.add_new_address_country);
        this.f79222m = (TextView) findViewById(R$id.tv_title);
        this.f79223n = (TextView) findViewById(R$id.id_pci_title_tv);
        this.f79224o = (TextView) findViewById(R$id.id_pci_content_tv);
        this.f79225p = (ConstraintLayout) findViewById(R$id.id_pci_root);
        Intent intent = getIntent();
        if (intent != null) {
            this.f79220k = intent.getBooleanExtra("key_is_manager_modify", false);
            Serializable serializableExtra = intent.getSerializableExtra("userBillingAddressBean");
            if (serializableExtra instanceof UserBillingAddressBean) {
                UserBillingAddressBean userBillingAddressBean = (UserBillingAddressBean) serializableExtra;
                this.f79221l = userBillingAddressBean;
                this.f79213d.setText(userBillingAddressBean.getAddressLine1());
                this.f79214e.setText(this.f79221l.getAddressLine2());
                this.f79215f.setText(this.f79221l.getCity());
                this.f79216g.setText(this.f79221l.getState());
                this.f79217h.setText(this.f79221l.getZip());
                String countryName = this.f79221l.getCountryName();
                try {
                    countryName = qu.d.i().h(Integer.valueOf(this.f79221l.getCountry()).intValue(), countryName);
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
                this.f79218i.setText(countryName);
                this.f79222m.setText(R$string.n_otc_card_pay_modify_address);
            }
        }
        a aVar = new a();
        this.f79213d.addTextChangedListener(aVar);
        this.f79214e.addTextChangedListener(aVar);
        this.f79215f.addTextChangedListener(aVar);
        this.f79216g.addTextChangedListener(aVar);
        this.f79217h.addTextChangedListener(aVar);
        this.f79218i.addTextChangedListener(aVar);
        this.f79219j = (TextView) findViewById(R$id.add_new_address_save);
        vh();
        HashMap hashMap = new HashMap();
        hashMap.put("otc_step", "view_fill_card_info_address");
        c.b().h("otc_card_info_typein", hashMap);
    }

    /* renamed from: oh */
    public AddNewAddressPresenter.c getUI() {
        return this;
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i12 == -1 && i11 == 10003 && intent != null) {
            String stringExtra = intent.getStringExtra("country_name");
            intent.getStringExtra("phone_area_code");
            String stringExtra2 = intent.getStringExtra("country_area_code");
            try {
                stringExtra = qu.d.i().h(Integer.valueOf(stringExtra2).intValue(), stringExtra);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            this.f79218i.setText(stringExtra);
            if (this.f79221l == null) {
                this.f79221l = new UserBillingAddressBean();
            }
            this.f79221l.setCountry(stringExtra2);
            this.f79221l.setCountryName(stringExtra);
        }
    }

    public final void vh() {
        if (TextUtils.isEmpty(this.f79213d.getText().toString().trim()) || TextUtils.isEmpty(this.f79215f.getText().toString().trim()) || TextUtils.isEmpty(this.f79217h.getText().toString().trim()) || TextUtils.isEmpty(this.f79218i.getText().toString().trim())) {
            this.f79219j.setEnabled(false);
        } else {
            this.f79219j.setEnabled(true);
        }
    }
}
