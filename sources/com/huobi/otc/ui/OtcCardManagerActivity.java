package com.huobi.otc.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.gson.Gson;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.network.hbg.core.bean.UserBillingAddressBean;
import com.hbg.lib.network.hbg.core.bean.UserCardInfoBean;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.otc.OtcModuleConfig;
import com.hbg.module.otc.R$color;
import com.hbg.module.otc.R$drawable;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$string;
import com.huobi.otc.enums.OtcTradeAreaEnum;
import com.huobi.otc.persenter.OtcCardManagerPresenter;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.functions.Action1;
import sp.e0;
import sp.f0;

public class OtcCardManagerActivity extends BaseActivity<OtcCardManagerPresenter, OtcCardManagerPresenter.d> implements OtcCardManagerPresenter.d {

    /* renamed from: b  reason: collision with root package name */
    public LoadingLayout f79337b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f79338c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f79339d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f79340e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f79341f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f79342g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f79343h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f79344i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f79345j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f79346k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f79347l;

    /* renamed from: m  reason: collision with root package name */
    public RelativeLayout f79348m;

    /* renamed from: n  reason: collision with root package name */
    public LinearLayout f79349n;

    /* renamed from: o  reason: collision with root package name */
    public ViewPager f79350o;

    /* renamed from: p  reason: collision with root package name */
    public int f79351p;

    /* renamed from: q  reason: collision with root package name */
    public g f79352q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f79353r;

    /* renamed from: s  reason: collision with root package name */
    public UserBillingAddressBean f79354s;

    /* renamed from: t  reason: collision with root package name */
    public int f79355t;

    public class a implements ViewPager.OnPageChangeListener {
        public a() {
        }

        public void onPageScrollStateChanged(int i11) {
        }

        public void onPageScrolled(int i11, float f11, int i12) {
            if (f11 >= 0.5f) {
                int i13 = i11 + 1;
                UserCardInfoBean b11 = OtcCardManagerActivity.this.f79352q.b(i13);
                OtcCardManagerActivity.this.Ch(b11);
                if (i13 != OtcCardManagerActivity.this.f79352q.getCount() - 1 || (b11 != null && !b11.isShowTypeAdd())) {
                    OtcCardManagerActivity.this.f79349n.setAlpha((f11 - 0.5f) * 2.0f);
                } else {
                    OtcCardManagerActivity.this.f79349n.setAlpha(0.0f);
                }
            } else {
                OtcCardManagerActivity otcCardManagerActivity = OtcCardManagerActivity.this;
                otcCardManagerActivity.Ch(otcCardManagerActivity.f79352q.b(i11));
                OtcCardManagerActivity.this.f79349n.setAlpha((0.5f - f11) * 2.0f);
            }
        }

        public void onPageSelected(int i11) {
            int unused = OtcCardManagerActivity.this.f79351p = i11;
            if (OtcCardManagerActivity.this.f79351p != OtcCardManagerActivity.this.f79352q.getCount() - 1 || !OtcCardManagerActivity.this.f79352q.b(OtcCardManagerActivity.this.f79351p).isShowTypeAdd()) {
                OtcCardManagerActivity.this.Fh();
            } else {
                OtcCardManagerActivity.this.wh();
            }
        }
    }

    public class b implements Action1<Void> {
        public b() {
        }

        /* renamed from: a */
        public void call(Void voidR) {
            boolean unused = OtcCardManagerActivity.this.f79353r = true;
            OtcCardManagerActivity otcCardManagerActivity = OtcCardManagerActivity.this;
            AddNewAddressActivity.uh(otcCardManagerActivity, true, otcCardManagerActivity.f79354s);
        }
    }

    public class c implements Action1<Void> {
        public c() {
        }

        /* renamed from: a */
        public void call(Void voidR) {
            OtcCardManagerActivity.this.Eh();
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            ((OtcCardManagerPresenter) OtcCardManagerActivity.this.getPresenter()).getUserCardList();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class e implements Action1<Void> {
        public e() {
        }

        /* renamed from: a */
        public void call(Void voidR) {
            OtcModuleConfig.b().y(OtcCardManagerActivity.this);
            HashMap hashMap = new HashMap();
            hashMap.put("otc_step", "click_bind_crad_record");
            uf.c.b().h("otc_bind_card_record", hashMap);
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            boolean unused = OtcCardManagerActivity.this.f79353r = true;
            OtcCardManagerActivity otcCardManagerActivity = OtcCardManagerActivity.this;
            OtcBindBankCardActivity.Qh(otcCardManagerActivity, otcCardManagerActivity.f79355t);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class g extends PagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public List<UserCardInfoBean> f79362a;

        /* renamed from: b  reason: collision with root package name */
        public View.OnClickListener f79363b;

        public class a implements View.OnClickListener {
            public a() {
            }

            @SensorsDataInstrumented
            public void onClick(View view) {
                if (g.this.f79363b != null) {
                    g.this.f79363b.onClick(view);
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }

        public g(View.OnClickListener onClickListener) {
            this.f79363b = onClickListener;
        }

        public UserCardInfoBean b(int i11) {
            if (i11 < 0 || i11 >= getCount()) {
                return null;
            }
            return this.f79362a.get(i11);
        }

        public long c(int i11) {
            return this.f79362a.get(i11).getCardId();
        }

        public List<UserCardInfoBean> d() {
            return this.f79362a;
        }

        public void destroyItem(ViewGroup viewGroup, int i11, Object obj) {
            if (obj instanceof View) {
                viewGroup.removeView((View) obj);
            }
        }

        public boolean e() {
            List<UserCardInfoBean> list = this.f79362a;
            if (list == null || list.isEmpty()) {
                return false;
            }
            List<UserCardInfoBean> list2 = this.f79362a;
            return list2.get(list2.size() - 1).isShowTypeAdd();
        }

        public final void f(View view, UserCardInfoBean userCardInfoBean) {
            View findViewById = view.findViewById(R$id.cl_card);
            ImageView imageView = (ImageView) view.findViewById(R$id.iv_shade);
            ((TextView) view.findViewById(R$id.tv_bank_num_4)).setText(userCardInfoBean.getAccountNumber());
            String lowerCase = userCardInfoBean.getScheme().toLowerCase();
            ((TextView) view.findViewById(R$id.tv_bank_bottom)).setText(userCardInfoBean.getBankName().toUpperCase());
            if (!TextUtils.isEmpty(lowerCase) && TextUtils.equals(lowerCase.toLowerCase(), "visa")) {
                imageView.setImageResource(R$drawable.otc_card_visa_shade);
                findViewById.setBackgroundResource(R$drawable.otc_card_visa_icon);
            } else if (TextUtils.isEmpty(lowerCase) || !TextUtils.equals(lowerCase.toLowerCase(), "mastercard")) {
                imageView.setImageResource(R$drawable.otc_card_bank_shade);
                findViewById.setBackgroundResource(R$drawable.otc_card_bank_icon);
            } else {
                imageView.setImageResource(R$drawable.otc_card_master_shade);
                findViewById.setBackgroundResource(R$drawable.otc_card_master_icon);
            }
        }

        public void g(long j11) {
            List<UserCardInfoBean> list = this.f79362a;
            if (list != null && list.size() > 1) {
                int i11 = 0;
                while (true) {
                    if (i11 >= this.f79362a.size()) {
                        i11 = -1;
                        break;
                    } else if (this.f79362a.get(i11).getCardId() == j11) {
                        break;
                    } else {
                        i11++;
                    }
                }
                if (i11 != -1) {
                    this.f79362a.remove(i11);
                    notifyDataSetChanged();
                }
            }
        }

        public int getCount() {
            List<UserCardInfoBean> list = this.f79362a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public int getItemPosition(Object obj) {
            if (obj instanceof View) {
                Object tag = ((View) obj).getTag();
                if (tag instanceof UserCardInfoBean) {
                    if (!this.f79362a.contains(tag)) {
                        return -2;
                    }
                    return this.f79362a.indexOf(tag);
                }
            }
            return super.getItemPosition(obj);
        }

        public void h(List<UserCardInfoBean> list) {
            this.f79362a = list;
            notifyDataSetChanged();
        }

        public Object instantiateItem(ViewGroup viewGroup, int i11) {
            View view;
            UserCardInfoBean userCardInfoBean = this.f79362a.get(i11);
            if (userCardInfoBean.isShowTypeAdd()) {
                view = View.inflate(viewGroup.getContext(), R$layout.otc_bind_card_add_item, (ViewGroup) null);
                view.findViewById(R$id.ll_add).setOnClickListener(new a());
            } else {
                view = View.inflate(viewGroup.getContext(), R$layout.otc_bind_card_item, (ViewGroup) null);
                f(view, userCardInfoBean);
            }
            view.setTag(userCardInfoBean);
            viewGroup.addView(view);
            return view;
        }

        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ah(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        ((OtcCardManagerPresenter) getPresenter()).removeCard(this.f79352q.c(this.f79351p));
    }

    public static void Bh(Activity activity, int i11) {
        Intent intent = new Intent(activity, OtcCardManagerActivity.class);
        intent.putExtra("parma_current_area", i11);
        activity.startActivity(intent);
    }

    public void Cb() {
        if (this.f79352q == null) {
            this.f79348m.setVisibility(8);
            this.f79337b.k();
        }
    }

    public final void Ch(UserCardInfoBean userCardInfoBean) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        UserBillingAddressBean userBillingAddressBean = null;
        if (userCardInfoBean == null) {
            this.f79354s = null;
            return;
        }
        String billingAddress = userCardInfoBean.getBillingAddress();
        if (!TextUtils.isEmpty(billingAddress)) {
            try {
                userBillingAddressBean = (UserBillingAddressBean) new Gson().fromJson(billingAddress, UserBillingAddressBean.class);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        this.f79354s = userBillingAddressBean;
        if (userBillingAddressBean != null) {
            userBillingAddressBean.setCardId(userCardInfoBean.getCardId());
        }
        TextView textView = this.f79341f;
        if (userBillingAddressBean == null) {
            str = "";
        } else {
            str = userBillingAddressBean.getAddressLine1();
        }
        Dh(textView, str);
        TextView textView2 = this.f79342g;
        if (userBillingAddressBean == null) {
            str2 = "";
        } else {
            str2 = userBillingAddressBean.getAddressLine2();
        }
        Dh(textView2, str2);
        TextView textView3 = this.f79343h;
        if (userBillingAddressBean == null) {
            str3 = "";
        } else {
            str3 = userBillingAddressBean.getCity();
        }
        Dh(textView3, str3);
        TextView textView4 = this.f79344i;
        if (userBillingAddressBean == null) {
            str4 = "";
        } else {
            str4 = userBillingAddressBean.getState();
        }
        Dh(textView4, str4);
        TextView textView5 = this.f79345j;
        if (userBillingAddressBean == null) {
            str5 = "";
        } else {
            str5 = userBillingAddressBean.getZip();
        }
        Dh(textView5, str5);
        Dh(this.f79346k, "");
        if (userBillingAddressBean != null) {
            ((OtcCardManagerPresenter) getPresenter()).getCountryName(userBillingAddressBean.getCardId(), userBillingAddressBean.getCountry());
        }
    }

    public final void Dh(TextView textView, String str) {
        if (!TextUtils.equals(textView.getText(), str)) {
            textView.setText(str);
        }
    }

    public final void Eh() {
        new DialogUtils.b.d(this).c1(getString(R$string.n_otc_card_pay_bind_card_remove_card)).C0(getString(R$string.n_otc_card_pay_bind_card_remove_content_one)).R0(getString(R$string.n_otc_card_pay_bind_card_remove_content_two)).P0(getString(R$string.n_coupon_select_confirm)).T0(true).s0(getString(R$string.n_cancel)).S0(Integer.valueOf(getResources().getColor(R$color.baseColorPrimaryText))).q0(true).N0(f0.f26013a).Q0(new e0(this)).j0().show(getSupportFragmentManager(), "");
    }

    public final void Fh() {
        this.f79348m.setVisibility(0);
        this.f79349n.setVisibility(0);
    }

    public void Ja(long j11, String str) {
        UserBillingAddressBean userBillingAddressBean = this.f79354s;
        if (userBillingAddressBean != null && userBillingAddressBean.getCardId() == j11) {
            this.f79354s.setCountryName(str);
            Dh(this.f79346k, str);
        }
    }

    public void Q9(long j11) {
        HuobiToastUtil.v(getString(R$string.n_otc_card_remove_success));
        this.f79352q.g(j11);
        if (this.f79352q.getCount() == 1 && !this.f79352q.e()) {
            List d11 = this.f79352q.d();
            if (d11 == null) {
                d11 = new ArrayList();
            }
            UserCardInfoBean userCardInfoBean = new UserCardInfoBean();
            userCardInfoBean.setShowTypeAdd(true);
            d11.add(userCardInfoBean);
            this.f79352q.h(d11);
        }
        g gVar = this.f79352q;
        if (yh(gVar.b(gVar.getCount() - 1))) {
            wh();
        } else {
            Fh();
        }
    }

    public void addEvent() {
        Observable<Void> a11 = dw.a.a(this.f79339d);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        a11.throttleFirst(300, timeUnit).subscribe(new b());
        dw.a.a(this.f79340e).throttleFirst(300, timeUnit).subscribe(new c());
        this.f79337b.setOnRetryClickListener(new d());
        dw.a.a(this.f79347l).throttleFirst(300, timeUnit).subscribe(new e());
    }

    public void finishActivity() {
        finish();
    }

    public int getContentView() {
        return R$layout.activity_otc_bind_card;
    }

    public Context getContext() {
        return this;
    }

    public void initView() {
        this.f79355t = getIntent().getIntExtra("parma_current_area", OtcTradeAreaEnum.FAST_AREA.getCode());
        xh();
        this.f79337b = (LoadingLayout) this.viewFinder.b(R$id.ll_loading);
        this.f79338c = (LinearLayout) this.viewFinder.b(R$id.ll_top_view_pager);
        this.f79350o = (ViewPager) this.viewFinder.b(R$id.view_pager);
        this.f79348m = (RelativeLayout) this.viewFinder.b(R$id.rl_bottom);
        this.f79339d = (TextView) this.viewFinder.b(R$id.tv_modify);
        this.f79349n = (LinearLayout) this.viewFinder.b(R$id.ll_card_info);
        this.f79340e = (TextView) this.viewFinder.b(R$id.tv_delete);
        this.f79341f = (TextView) this.viewFinder.b(R$id.tv_right_1);
        this.f79342g = (TextView) this.viewFinder.b(R$id.tv_right_2);
        this.f79343h = (TextView) this.viewFinder.b(R$id.tv_right_3);
        this.f79344i = (TextView) this.viewFinder.b(R$id.tv_right_4);
        this.f79345j = (TextView) this.viewFinder.b(R$id.tv_right_5);
        this.f79346k = (TextView) this.viewFinder.b(R$id.tv_right_6);
        this.f79347l = (TextView) this.viewFinder.b(R$id.tv_bind_card_record);
        this.f79350o.addOnPageChangeListener(new a());
        wh();
        this.f79338c.setVisibility(4);
    }

    public void kh(List<UserCardInfoBean> list) {
        this.f79337b.g();
        this.f79338c.setVisibility(0);
        if (this.f79352q == null) {
            g gVar = new g(new f());
            this.f79352q = gVar;
            this.f79350o.setAdapter(gVar);
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        if (list.size() < 2) {
            UserCardInfoBean userCardInfoBean = new UserCardInfoBean();
            userCardInfoBean.setShowTypeAdd(true);
            list.add(userCardInfoBean);
        }
        this.f79352q.h(list);
        if (this.f79352q.getCount() > 1) {
            int size = this.f79351p >= list.size() ? list.size() - 1 : this.f79351p;
            this.f79351p = size;
            this.f79350o.setCurrentItem(size);
            if (yh(this.f79352q.b(this.f79351p))) {
                wh();
                return;
            }
            Ch(list.get(this.f79351p));
            Fh();
            return;
        }
        wh();
    }

    public void onResume() {
        super.onResume();
        if (this.f79353r) {
            this.f79353r = false;
            ((OtcCardManagerPresenter) getPresenter()).getUserCardList();
        }
    }

    /* renamed from: uh */
    public OtcCardManagerPresenter createPresenter() {
        return new OtcCardManagerPresenter();
    }

    /* renamed from: vh */
    public OtcCardManagerPresenter.d getUI() {
        return this;
    }

    public final void wh() {
        this.f79348m.setVisibility(8);
        this.f79349n.setVisibility(4);
    }

    public final void xh() {
        setToolBar((Toolbar) this.viewFinder.b(R$id.toolbar), "", true);
    }

    public final boolean yh(UserCardInfoBean userCardInfoBean) {
        if (this.f79350o.getCurrentItem() != this.f79352q.getCount() - 1 || userCardInfoBean == null || !userCardInfoBean.isShowTypeAdd()) {
            return false;
        }
        return true;
    }
}
