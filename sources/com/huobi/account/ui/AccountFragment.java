package com.huobi.account.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.h0;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.ui.BaseFragment;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.network.hbg.core.bean.AccountLevelCardData;
import com.hbg.lib.network.hbg.core.bean.CommunityData;
import com.hbg.lib.network.hbg.core.bean.MedalUserInfo;
import com.hbg.lib.network.hbg.core.bean.MyPrimeInfo;
import com.hbg.lib.network.newkyc.bean.UnifyKycInfo;
import com.hbg.lib.router.HbgRouter;
import com.hbg.lib.widgets.AutoSizeTextView;
import com.hbg.lib.widgets.MyNestedScrollView;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.huobi.im.RedPoint.a;
import com.hbg.module.libkt.utils.o;
import com.huobi.account.bean.AccountKycInfo;
import com.huobi.account.presenter.AccountPresenter;
import com.huobi.account.widget.AccountFixedQuickView;
import com.huobi.account.widget.AccountInfoView;
import com.huobi.activity.AccountContainerActivity;
import com.huobi.activity.SettingActivity;
import com.huobi.entity.HomeActivityEntity;
import com.huobi.index.bean.IndexFeature;
import com.huobi.index.bean.IndexFeatureItem;
import com.huobi.index.ui.widget.HBIndicatorView;
import com.huobi.login.bean.JumpTarget;
import com.huobi.message.ui.MessageActivity;
import com.huobi.page.SmartRefreshHeader;
import com.huobi.view.LightBubblePopup;
import com.huobi.view.rollviewpager.RollPagerView;
import com.huobi.view.rollviewpager.hintview.AnimHintView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerAdapter;
import gs.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import ky.j;
import pro.huobi.R;
import tg.r;

public class AccountFragment extends BaseFragment<AccountPresenter, AccountPresenter.q> implements AccountPresenter.q, View.OnClickListener {
    public TextView A;
    public TextView B;
    public View C;
    public LinearLayout D;
    public View E;
    public View F;
    public ImageView G;
    public ImageView H;
    public TextView I;
    public Banner J;
    public BannerAdapter<AccountLevelCardData, e> K;
    public int[] L = {R.drawable.prime0, R.drawable.prime1, R.drawable.prime2, R.drawable.prime3, R.drawable.prime4, R.drawable.prime5, R.drawable.prime6, R.drawable.prime7, R.drawable.prime8, R.drawable.prime9, R.drawable.prime10, R.drawable.prime11};
    public MyNestedScrollView M;
    public ImageView N;
    public ImageView O;
    public ImageView P;
    public ImageView Q;
    public ImageView R;
    public View S;
    public View T;
    public SmartRefreshHeader U;
    public MyPrimeInfo V;
    public TextView W;
    public LightBubblePopup X;
    public LightBubblePopup Y;
    public int Z;

    /* renamed from: a0  reason: collision with root package name */
    public String f41109a0;

    /* renamed from: l  reason: collision with root package name */
    public SmartRefreshLayout f41110l;

    /* renamed from: m  reason: collision with root package name */
    public ImageView f41111m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f41112n;

    /* renamed from: o  reason: collision with root package name */
    public View f41113o;

    /* renamed from: p  reason: collision with root package name */
    public AccountInfoView f41114p;

    /* renamed from: q  reason: collision with root package name */
    public View f41115q;

    /* renamed from: r  reason: collision with root package name */
    public AccountFixedQuickView f41116r;

    /* renamed from: s  reason: collision with root package name */
    public ViewGroup f41117s;

    /* renamed from: t  reason: collision with root package name */
    public ViewPager2 f41118t;

    /* renamed from: u  reason: collision with root package name */
    public final List<EasyRecyclerView<IndexFeatureItem>> f41119u = new ArrayList();

    /* renamed from: v  reason: collision with root package name */
    public HBIndicatorView f41120v;

    /* renamed from: w  reason: collision with root package name */
    public yg.d f41121w;

    /* renamed from: x  reason: collision with root package name */
    public Context f41122x;

    /* renamed from: y  reason: collision with root package name */
    public RollPagerView f41123y;

    /* renamed from: z  reason: collision with root package name */
    public AnimHintView f41124z;

    public class a implements ny.d {
        public a() {
        }

        public void P8(j jVar) {
        }

        public void bf(j jVar) {
            if (AccountFragment.this.zh().isCanBeSeen()) {
                ((AccountPresenter) AccountFragment.this.yh()).i1();
            }
        }
    }

    public class b implements MyNestedScrollView.a {
        public b() {
        }

        public void onScrollChange(NestedScrollView nestedScrollView, int i11, int i12, int i13, int i14) {
            int height = AccountFragment.this.T.getHeight();
            if (height != 0) {
                AccountFragment.this.W.setAlpha(Math.min(1.0f, Math.max(0.0f, ((float) i12) / ((float) height))));
            }
        }
    }

    public class c implements a.C0138a {
        public c() {
        }

        public void a(com.hbg.module.huobi.im.RedPoint.a aVar) {
            int b11 = aVar.b();
            if (!aVar.a()) {
                AccountFragment.this.f41112n.setVisibility(8);
                AccountFragment.this.f41113o.setVisibility(8);
            } else if (b11 > 0) {
                AccountFragment.this.f41113o.setVisibility(8);
                if (b11 > 99) {
                    AccountFragment.this.f41112n.setText("99+");
                } else {
                    TextView Jh = AccountFragment.this.f41112n;
                    Jh.setText(b11 + "");
                }
                AccountFragment.this.f41112n.setVisibility(0);
            } else {
                AccountFragment.this.f41112n.setVisibility(8);
                AccountFragment.this.f41113o.setVisibility(0);
            }
        }
    }

    public class d extends BannerAdapter<AccountLevelCardData, e> {
        public d(List list) {
            super(list);
        }

        /* renamed from: d */
        public void onBindView(e eVar, AccountLevelCardData accountLevelCardData, int i11, int i12) {
            switch (AccountFragment.this.Z) {
                case 2:
                case 3:
                case 4:
                    eVar.f41129a.setTextColor(AccountFragment.this.getResources().getColor(R.color.account_level1_subtitle));
                    break;
                case 5:
                case 6:
                    eVar.f41129a.setTextColor(AccountFragment.this.getResources().getColor(R.color.account_level4_subtitle));
                    break;
                case 7:
                case 8:
                case 9:
                    eVar.f41129a.setTextColor(AccountFragment.this.getResources().getColor(R.color.account_level6_subtitle));
                    break;
                case 10:
                case 11:
                case 12:
                    eVar.f41129a.setTextColor(AccountFragment.this.getResources().getColor(R.color.account_level10_subtitle));
                    break;
                default:
                    eVar.f41129a.setTextColor(AccountFragment.this.getResources().getColor(R.color.account_level0_subtitle));
                    break;
            }
            eVar.f41129a.setTextSize(0, (float) AccountFragment.this.getActivity().getResources().getDimensionPixelSize(R.dimen.global_text_size_10));
            if (!TextUtils.isEmpty(accountLevelCardData.highlightText)) {
                int indexOf = accountLevelCardData.text.indexOf(accountLevelCardData.highlightText);
                if (indexOf >= 0) {
                    SpannableString spannableString = new SpannableString(accountLevelCardData.text);
                    spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(AccountFragment.this.getActivity(), R.color.baseColorMajorTheme100)), indexOf, accountLevelCardData.highlightText.length() + indexOf, 33);
                    eVar.f41129a.setText(spannableString);
                    return;
                }
                eVar.f41129a.setText(accountLevelCardData.text);
                return;
            }
            eVar.f41129a.setText(accountLevelCardData.text);
        }

        /* renamed from: e */
        public e onCreateHolder(ViewGroup viewGroup, int i11) {
            AutoSizeTextView autoSizeTextView = new AutoSizeTextView(AccountFragment.this.getActivity());
            autoSizeTextView.setMaxLines(1);
            autoSizeTextView.setEllipsize(TextUtils.TruncateAt.END);
            autoSizeTextView.setGravity(16);
            autoSizeTextView.setTextColor(ContextCompat.getColor(AccountFragment.this.getActivity(), R.color.baseColorPrimaryText));
            autoSizeTextView.setTextSize(0, (float) AccountFragment.this.getActivity().getResources().getDimensionPixelSize(R.dimen.global_text_size_10));
            autoSizeTextView.setMinTextSize(AccountFragment.this.getActivity().getResources().getDimension(R.dimen.global_text_size_8));
            return new e(autoSizeTextView);
        }

        public int getItemCount() {
            if (getRealCount() > 1) {
                return Integer.MAX_VALUE;
            }
            return getRealCount();
        }

        public int getRealPosition(int i11) {
            return getRealCount() > 1 ? i11 % getRealCount() : i11;
        }
    }

    public static class e extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public AutoSizeTextView f41129a;

        public e(View view) {
            super(view);
            view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.f41129a = (AutoSizeTextView) view;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ai(Void voidR) {
        HbgRouter.h(getActivity(), "/app/language");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void bi(Void voidR) {
        g.i("Notification_Me_click", (HashMap) null);
        Intent intent = new Intent(getActivity(), MessageActivity.class);
        if (!r.x().F0()) {
            rn.c.i().d(getActivity(), new JumpTarget(intent, (Intent) null));
        } else if (!NetworkStatus.c(getActivity())) {
            HuobiToastUtil.j(R.string.server_error);
        } else {
            startActivity(intent);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ci(Void voidR) {
        SettingActivity.di(getContext());
        g.i("Setting_Me_click", (HashMap) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void di(Void voidR) {
        FragmentActivity activity = getActivity();
        if (activity instanceof AccountContainerActivity) {
            activity.finish();
        }
    }

    public void Ah() {
        this.M.setOnScrollChangedListener(new b());
    }

    public void C6(List<IndexFeatureItem> list) {
        this.f41116r.setData(list);
    }

    public LightBubblePopup F6() {
        return this.Y;
    }

    @SuppressLint({"SetTextI18n"})
    public void I2(int i11, int i12) {
        int i13 = 8;
        int i14 = 0;
        this.C.setVisibility(i12 > 0 ? 0 : 8);
        AnimHintView animHintView = this.f41124z;
        if (i12 > 1) {
            i13 = 0;
        }
        animHintView.setVisibility(i13);
        RollPagerView rollPagerView = this.f41123y;
        if (i12 <= 0) {
            i14 = 4;
        }
        rollPagerView.setVisibility(i14);
        this.A.setText("" + i11);
        this.B.setText("/" + i12);
    }

    public LinearLayout I8() {
        return this.D;
    }

    /* renamed from: Lh */
    public AccountPresenter xh() {
        return new AccountPresenter();
    }

    public final EasyRecyclerView<IndexFeatureItem> Mh() {
        EasyRecyclerView<IndexFeatureItem> easyRecyclerView = new EasyRecyclerView<>(this.f41122x);
        easyRecyclerView.setNestedScrollingEnabled(false);
        easyRecyclerView.setLayoutManager(new LinearLayoutManager(this.f41122x, 0, false));
        return easyRecyclerView;
    }

    /* renamed from: Nh */
    public AccountPresenter.q zh() {
        return this;
    }

    public final void Oh() {
        int currentItem;
        RollPagerView rollPagerView = this.f41123y;
        if (rollPagerView != null && rollPagerView.getViewPager() != null && this.f41123y.getViewPager().getAdapter() != null) {
            PagerAdapter adapter = this.f41123y.getViewPager().getAdapter();
            if (adapter instanceof yg.a) {
                yg.a aVar = (yg.a) adapter;
                if (!aVar.g()) {
                    List<HomeActivityEntity> e11 = aVar.e();
                    if (e11.size() > 0 && e11.size() > (currentItem = this.f41123y.getViewPager().getCurrentItem() % e11.size())) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("name", e11.get(currentItem).adName);
                        g.i("Banner_Me_show", hashMap);
                    }
                    this.f41123y.resume();
                }
            }
        }
    }

    public void Pb() {
        this.f41110l.finishRefresh();
        this.f41110l.setNoMoreData(false);
    }

    public final void Ph() {
        this.f41114p = (AccountInfoView) this.f67460i.b(R.id.view_account_info);
    }

    public final void Qh() {
        this.C = this.f67460i.b(R.id.banner_and_notice_bar_container);
        this.A = (TextView) this.f67460i.b(R.id.banner_indicator_index);
        this.B = (TextView) this.f67460i.b(R.id.banner_indicator_total);
        AnimHintView animHintView = new AnimHintView(getActivity());
        this.f41124z = animHintView;
        animHintView.setNormalResId(0);
        this.f41124z.setBgResId(R.drawable.hint_indicator_bg);
        this.f41124z.setFocusResId(R.drawable.hint_indicator_focus);
        RollPagerView rollPagerView = (RollPagerView) this.f67460i.b(R.id.roll_view_pager);
        this.f41123y = rollPagerView;
        rollPagerView.setHintView(this.f41124z);
        this.f41123y.getViewPager().setClipToPadding(false);
        this.f41123y.getViewPager().setPageMargin(0);
        if (Build.VERSION.SDK_INT >= 21) {
            this.f41123y.getViewPager().setNestedScrollingEnabled(false);
        }
        h0.N0(this.f41123y.getViewPager(), false);
    }

    public final void Rh() {
        dw.a.a(this.f67460i.b(R.id.layout_language)).throttleFirst(1, TimeUnit.SECONDS).subscribe(new a(this));
    }

    public void Sb(MedalUserInfo medalUserInfo) {
        this.f41114p.L(medalUserInfo);
    }

    public final void Sh() {
        this.E = this.f67460i.b(R.id.levelLayout);
        this.F = this.f67460i.b(R.id.levelContent);
        this.G = (ImageView) this.f67460i.b(R.id.levelImg);
        this.H = (ImageView) this.f67460i.b(R.id.levelArrowImg);
        this.I = (TextView) this.f67460i.b(R.id.levelUpTxt);
        this.F.setOnClickListener(this);
        this.H.setOnClickListener(this);
        this.I.setOnClickListener(this);
        this.J = (Banner) this.f67460i.b(R.id.level_banners);
        this.f67460i.b(R.id.level_banners_cover).setOnClickListener(this);
        d dVar = new d((List) null);
        this.K = dVar;
        this.J.setAdapter(dVar);
        this.J.setOrientation(1);
        this.J.setLoopTime(5000);
    }

    public final void Th() {
        this.f41112n = (TextView) this.f67460i.b(R.id.tv_message_count);
        this.f41113o = this.f67460i.b(R.id.v_message_count_dot);
        dw.a.a(this.f67460i.b(R.id.layout_message)).throttleFirst(1, TimeUnit.SECONDS).subscribe(new c(this));
        com.hbg.module.huobi.im.RedPoint.b.a().g(new c());
    }

    public void Uh() {
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) this.f67460i.b(R.id.refresh_layout);
        this.f41110l = smartRefreshLayout;
        smartRefreshLayout.i(true);
        this.f41110l.g(false);
        this.f41110l.V(false);
        if (this.U == null) {
            this.U = new SmartRefreshHeader(getActivity());
        }
        this.f41110l.j0(this.U);
        this.f41110l.e0(new a());
    }

    public final void Vh() {
        this.f41117s = (ViewGroup) this.f67460i.b(R.id.part_account_quick_container);
        this.f41118t = (ViewPager2) this.f67460i.b(R.id.view_pager_quick);
        yg.d dVar = new yg.d(this.f41119u);
        this.f41121w = dVar;
        this.f41118t.setAdapter(dVar);
        Wh();
        this.f41116r = (AccountFixedQuickView) this.f67460i.b(R.id.view_account_fixed_quick);
    }

    public void W9(AccountKycInfo accountKycInfo) {
        AccountInfoView accountInfoView = this.f41114p;
        if (accountInfoView != null) {
            accountInfoView.setAccountKycInfo(accountKycInfo);
        }
    }

    public final void Wh() {
        HBIndicatorView hBIndicatorView = (HBIndicatorView) this.f67460i.b(R.id.view_pager_indicator);
        this.f41120v = hBIndicatorView;
        hBIndicatorView.n(getResources().getDimension(R.dimen.dp_5), getResources().getDimension(R.dimen.dp_10));
        this.f41120v.m(getResources().getDimension(R.dimen.dp_3));
        this.f41120v.l(getResources().getDimension(R.dimen.dp_2));
        this.f41120v.j(3);
        this.f41120v.i(4);
        this.f41120v.setOrientation(0);
    }

    public final void Xh() {
        this.f41115q = this.f67460i.b(R.id.v_setting_count_dot);
        dw.a.a(this.f67460i.b(R.id.layout_setting)).throttleFirst(1, TimeUnit.SECONDS).subscribe(new d(this));
    }

    public final void Yh() {
        View b11 = this.f67460i.b(R.id.account_page_status_bar);
        ViewGroup.LayoutParams layoutParams = b11.getLayoutParams();
        layoutParams.height = BaseActivity.getStatusBarHeight(b11.getContext());
        b11.setLayoutParams(layoutParams);
    }

    public void Z3(UnifyKycInfo unifyKycInfo) {
        AccountInfoView accountInfoView = this.f41114p;
        if (accountInfoView != null) {
            accountInfoView.O(unifyKycInfo);
        }
    }

    public final void Zh() {
        this.f41111m = (ImageView) this.f67460i.b(R.id.iv_back);
        if (getActivity() instanceof AccountContainerActivity) {
            this.f41111m.setVisibility(0);
        } else {
            this.f41111m.setVisibility(8);
        }
        dw.a.a(this.f41111m).throttleFirst(1, TimeUnit.SECONDS).subscribe(new b(this));
    }

    public RollPagerView a2() {
        return this.f41123y;
    }

    public void ab() {
    }

    public void c9(boolean z11) {
        ViewUtil.m(this.f41115q, z11);
    }

    public final List<EasyRecyclerView<IndexFeatureItem>> ei(List<IndexFeatureItem> list) {
        int i11;
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        int i12 = 1;
        if (size > 5) {
            i12 = size % 5 == 0 ? size / 5 : (size / 5) + 1;
        }
        int i13 = 0;
        for (int i14 = 0; i14 < i12; i14++) {
            arrayList.add(Mh());
        }
        while (i13 < i12) {
            ArrayList arrayList2 = new ArrayList();
            EasyRecyclerView easyRecyclerView = (EasyRecyclerView) arrayList.get(i13);
            int i15 = i13 * 5;
            while (true) {
                i11 = i13 + 1;
                if (i15 >= i11 * 5 || i15 >= size) {
                    easyRecyclerView.setData(arrayList2);
                    i13 = i11;
                } else {
                    IndexFeatureItem indexFeatureItem = list.get(i15);
                    indexFeatureItem.index = i15;
                    indexFeatureItem.type = IndexFeature.ACCOUNT_NEW_QUICK;
                    arrayList2.add(indexFeatureItem);
                    i15++;
                }
            }
            easyRecyclerView.setData(arrayList2);
            i13 = i11;
        }
        return arrayList;
    }

    public void fa(boolean z11, List<IndexFeatureItem> list) {
        if (list == null || list.isEmpty()) {
            this.f41117s.setVisibility(8);
        } else if (!z11) {
            this.f41117s.setVisibility(8);
        } else {
            this.f41117s.setVisibility(0);
            List<EasyRecyclerView<IndexFeatureItem>> ei2 = ei(list);
            this.f41119u.clear();
            this.f41119u.addAll(ei2);
            this.f41121w.d(ei2);
            this.f41118t.invalidate();
            fi();
            this.f41118t.setCurrentItem(0);
        }
    }

    public final void fi() {
        this.f41120v.setupWithViewPager(this.f41118t);
    }

    public final void gi(MyPrimeInfo myPrimeInfo) {
        if (myPrimeInfo == null || myPrimeInfo.getLevel() < 7 || myPrimeInfo.getLevel() > 12) {
            myPrimeInfo = null;
        }
        this.f41114p.P(myPrimeInfo);
        if (myPrimeInfo == null) {
            this.f41111m.setImageResource(R.drawable.icon_subpage_back);
            this.N.setImageResource(R.drawable.account_language);
            this.P.setImageResource(R.drawable.account_msg);
            this.Q.setImageResource(R.drawable.account_setting);
            this.W.setTextColor(getResources().getColor(R.color.baseColorPrimaryText));
            o.f24912a.j(getActivity(), !NightHelper.e().g());
            this.O.setVisibility(8);
            this.R.setVisibility(8);
            this.S.setBackgroundColor(getResources().getColor(R.color.baseColorContentBackground));
            SmartRefreshHeader smartRefreshHeader = this.U;
            if (smartRefreshHeader != null) {
                smartRefreshHeader.setBackgroundColor(getResources().getColor(R.color.baseColorContentBackground));
            }
            this.f41112n.setBackgroundResource(R.drawable.shape_message_count_white_edge_account);
            this.f41113o.setBackgroundResource(R.drawable.shape_message_count_white_edge_account);
            this.f41115q.setBackgroundResource(R.drawable.shape_message_count_white_edge_account);
            return;
        }
        this.f41111m.setImageResource(R.drawable.icon_subpage_back_white);
        this.N.setImageResource(R.drawable.account_language_white);
        this.P.setImageResource(R.drawable.account_msg_white);
        this.Q.setImageResource(R.drawable.account_setting_white);
        this.W.setTextColor(getResources().getColor(R.color.color_F0F1F4));
        o.f24912a.j(getActivity(), false);
        this.O.setVisibility(0);
        this.R.setVisibility(0);
        if (myPrimeInfo.getLevel() > 6 && myPrimeInfo.getLevel() < 10) {
            this.O.setImageResource(R.drawable.prime_head_bg6);
            this.R.setImageResource(R.drawable.prime_head_icon_bg6);
            this.S.setBackgroundColor(getResources().getColor(R.color.color_1C1C19));
            SmartRefreshHeader smartRefreshHeader2 = this.U;
            if (smartRefreshHeader2 != null) {
                smartRefreshHeader2.setBackgroundColor(getResources().getColor(R.color.color_1C1C19));
            }
        } else if (myPrimeInfo.getLevel() > 9) {
            this.O.setImageResource(R.drawable.prime_head_bg10);
            this.R.setImageResource(R.drawable.prime_head_icon_bg10);
            this.S.setBackgroundColor(getResources().getColor(R.color.color_1A1A1A));
            SmartRefreshHeader smartRefreshHeader3 = this.U;
            if (smartRefreshHeader3 != null) {
                smartRefreshHeader3.setBackgroundColor(getResources().getColor(R.color.color_1A1A1A));
            }
        }
        this.f41112n.setBackgroundResource(R.drawable.shape_message_count_white_edge_account_dark);
        this.f41113o.setBackgroundResource(R.drawable.shape_message_count_white_edge_account_dark);
        this.f41115q.setBackgroundResource(R.drawable.shape_message_count_white_edge_account_dark);
    }

    public void initViews() {
        Zh();
        Yh();
        Uh();
        Rh();
        Th();
        Xh();
        Ph();
        Vh();
        Qh();
        this.D = (LinearLayout) this.f67460i.b(R.id.part_home_account_box);
        Sh();
        this.M = (MyNestedScrollView) this.f67460i.b(R.id.scrollView);
        this.N = (ImageView) this.f67460i.b(R.id.imgLanguage);
        this.S = this.f67460i.b(R.id.topBgView);
        this.O = (ImageView) this.f67460i.b(R.id.imgPrimeHead);
        this.P = (ImageView) this.f67460i.b(R.id.imgMessage);
        this.Q = (ImageView) this.f67460i.b(R.id.imgSetting);
        this.T = this.f67460i.b(R.id.primeLayout);
        this.W = (TextView) this.f67460i.b(R.id.topTitleMe);
        this.R = (ImageView) this.f67460i.b(R.id.imgPrimeHeadIcon);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0167  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0199  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x01a9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void ke(com.hbg.lib.network.hbg.core.bean.MyPrimeInfo r8) {
        /*
            r7 = this;
            r7.V = r8
            r7.gi(r8)
            r0 = 0
            r7.Z = r0
            if (r8 == 0) goto L_0x01b5
            int r1 = r8.getLevel()
            r2 = 1
            if (r1 < r2) goto L_0x01b5
            int r1 = r8.getLevel()
            r3 = 12
            if (r1 > r3) goto L_0x01b5
            boolean r1 = r8.isShowStatus()
            if (r1 != 0) goto L_0x0021
            goto L_0x01b5
        L_0x0021:
            int r1 = r8.getLevel()
            r7.Z = r1
            android.view.View r1 = r7.E
            r1.setVisibility(r0)
            java.lang.String r0 = r8.getUnlockText()
            java.lang.String r1 = r8.getUnlockHighlightText()
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 != 0) goto L_0x006b
            int r3 = r0.indexOf(r1)
            if (r3 < 0) goto L_0x0065
            android.text.SpannableString r4 = new android.text.SpannableString
            r4.<init>(r0)
            android.text.style.ForegroundColorSpan r0 = new android.text.style.ForegroundColorSpan
            androidx.fragment.app.FragmentActivity r5 = r7.getActivity()
            r6 = 2131099897(0x7f0600f9, float:1.781216E38)
            int r5 = androidx.core.content.ContextCompat.getColor(r5, r6)
            r0.<init>(r5)
            int r1 = r1.length()
            int r1 = r1 + r3
            r5 = 33
            r4.setSpan(r0, r3, r1, r5)
            android.widget.TextView r0 = r7.I
            r0.setText(r4)
            goto L_0x0070
        L_0x0065:
            android.widget.TextView r1 = r7.I
            r1.setText(r0)
            goto L_0x0070
        L_0x006b:
            android.widget.TextView r1 = r7.I
            r1.setText(r0)
        L_0x0070:
            int r0 = r8.getLevel()
            r1 = 0
            if (r0 <= 0) goto L_0x008d
            int r0 = r8.getLevel()
            int[] r3 = r7.L
            int r4 = r3.length
            if (r0 > r4) goto L_0x008d
            android.widget.ImageView r0 = r7.G
            int r4 = r8.getLevel()
            int r4 = r4 - r2
            r2 = r3[r4]
            r0.setImageResource(r2)
            goto L_0x0092
        L_0x008d:
            android.widget.ImageView r0 = r7.G
            r0.setImageDrawable(r1)
        L_0x0092:
            android.widget.ImageView r0 = r7.H
            android.graphics.drawable.Drawable r0 = r0.getDrawable()
            int r2 = r8.getLevel()
            r3 = 2131234571(0x7f080f0b, float:1.8085311E38)
            switch(r2) {
                case 1: goto L_0x0167;
                case 2: goto L_0x0138;
                case 3: goto L_0x0138;
                case 4: goto L_0x0138;
                case 5: goto L_0x0109;
                case 6: goto L_0x0109;
                case 7: goto L_0x00d9;
                case 8: goto L_0x00d9;
                case 9: goto L_0x00d9;
                case 10: goto L_0x00a9;
                case 11: goto L_0x00a9;
                case 12: goto L_0x00a9;
                default: goto L_0x00a2;
            }
        L_0x00a2:
            android.view.View r0 = r7.F
            r0.setBackgroundResource(r3)
            goto L_0x0192
        L_0x00a9:
            android.view.View r2 = r7.F
            r3 = 2131234574(0x7f080f0e, float:1.8085318E38)
            r2.setBackgroundResource(r3)
            android.widget.TextView r2 = r7.I
            android.content.res.Resources r3 = r7.getResources()
            r4 = 2131099735(0x7f060057, float:1.7811832E38)
            int r3 = r3.getColor(r4)
            r2.setTextColor(r3)
            android.graphics.drawable.Drawable r2 = r0.mutate()
            android.content.res.Resources r3 = r7.getResources()
            int r3 = r3.getColor(r4)
            android.graphics.PorterDuff$Mode r4 = android.graphics.PorterDuff.Mode.SRC_ATOP
            r2.setColorFilter(r3, r4)
            android.widget.ImageView r2 = r7.H
            r2.setImageDrawable(r0)
            goto L_0x0192
        L_0x00d9:
            android.view.View r2 = r7.F
            r3 = 2131234583(0x7f080f17, float:1.8085336E38)
            r2.setBackgroundResource(r3)
            android.widget.TextView r2 = r7.I
            android.content.res.Resources r3 = r7.getResources()
            r4 = 2131099747(0x7f060063, float:1.7811856E38)
            int r3 = r3.getColor(r4)
            r2.setTextColor(r3)
            android.graphics.drawable.Drawable r2 = r0.mutate()
            android.content.res.Resources r3 = r7.getResources()
            int r3 = r3.getColor(r4)
            android.graphics.PorterDuff$Mode r4 = android.graphics.PorterDuff.Mode.SRC_ATOP
            r2.setColorFilter(r3, r4)
            android.widget.ImageView r2 = r7.H
            r2.setImageDrawable(r0)
            goto L_0x0192
        L_0x0109:
            android.view.View r2 = r7.F
            r3 = 2131234580(0x7f080f14, float:1.808533E38)
            r2.setBackgroundResource(r3)
            android.widget.TextView r2 = r7.I
            android.content.res.Resources r3 = r7.getResources()
            r4 = 2131099743(0x7f06005f, float:1.7811848E38)
            int r3 = r3.getColor(r4)
            r2.setTextColor(r3)
            android.graphics.drawable.Drawable r2 = r0.mutate()
            android.content.res.Resources r3 = r7.getResources()
            int r3 = r3.getColor(r4)
            android.graphics.PorterDuff$Mode r4 = android.graphics.PorterDuff.Mode.SRC_ATOP
            r2.setColorFilter(r3, r4)
            android.widget.ImageView r2 = r7.H
            r2.setImageDrawable(r0)
            goto L_0x0192
        L_0x0138:
            android.view.View r2 = r7.F
            r3 = 2131234576(0x7f080f10, float:1.8085322E38)
            r2.setBackgroundResource(r3)
            android.widget.TextView r2 = r7.I
            android.content.res.Resources r3 = r7.getResources()
            r4 = 2131099739(0x7f06005b, float:1.781184E38)
            int r3 = r3.getColor(r4)
            r2.setTextColor(r3)
            android.graphics.drawable.Drawable r2 = r0.mutate()
            android.content.res.Resources r3 = r7.getResources()
            int r3 = r3.getColor(r4)
            android.graphics.PorterDuff$Mode r4 = android.graphics.PorterDuff.Mode.SRC_ATOP
            r2.setColorFilter(r3, r4)
            android.widget.ImageView r2 = r7.H
            r2.setImageDrawable(r0)
            goto L_0x0192
        L_0x0167:
            android.view.View r2 = r7.F
            r2.setBackgroundResource(r3)
            android.widget.TextView r2 = r7.I
            android.content.res.Resources r3 = r7.getResources()
            r4 = 2131099730(0x7f060052, float:1.7811821E38)
            int r3 = r3.getColor(r4)
            r2.setTextColor(r3)
            android.graphics.drawable.Drawable r2 = r0.mutate()
            android.content.res.Resources r3 = r7.getResources()
            int r3 = r3.getColor(r4)
            android.graphics.PorterDuff$Mode r4 = android.graphics.PorterDuff.Mode.SRC_ATOP
            r2.setColorFilter(r3, r4)
            android.widget.ImageView r2 = r7.H
            r2.setImageDrawable(r0)
        L_0x0192:
            java.util.List r0 = r8.getList()
            if (r0 != 0) goto L_0x0199
            goto L_0x01a1
        L_0x0199:
            java.util.List r0 = r8.getList()
            java.lang.String r1 = r0.toString()
        L_0x01a1:
            java.lang.String r0 = r7.f41109a0
            boolean r0 = android.text.TextUtils.equals(r0, r1)
            if (r0 != 0) goto L_0x01b2
            com.youth.banner.Banner r0 = r7.J
            java.util.List r8 = r8.getList()
            r0.setDatas(r8)
        L_0x01b2:
            r7.f41109a0 = r1
            return
        L_0x01b5:
            android.view.View r8 = r7.E
            r0 = 8
            r8.setVisibility(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.account.ui.AccountFragment.ke(com.hbg.lib.network.hbg.core.bean.MyPrimeInfo):void");
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.f41122x = context;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.levelArrowImg:
            case R.id.levelUpTxt:
                MyPrimeInfo myPrimeInfo = this.V;
                if (myPrimeInfo != null) {
                    zn.a.d().v(Uri.parse(TextUtils.isEmpty(myPrimeInfo.getUrl()) ? this.V.getBackgroundUrl() : this.V.getUrl())).c();
                    if (this.Z == 1) {
                        g.i("app_me_prime_unlockPrivilege_click", (HashMap) null);
                        break;
                    }
                } else {
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    return;
                }
                break;
            case R.id.levelContent:
            case R.id.level_banners_cover:
                if (this.V != null) {
                    HBBaseWebActivity.showWebView(getActivity(), this.V.getBackgroundUrl(), "", "", false);
                    HashMap hashMap = new HashMap();
                    hashMap.put("primeLevel", Integer.valueOf(this.Z - 1));
                    g.i("Prime_Me_click", hashMap);
                    break;
                } else {
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    return;
                }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void p4(CommunityData communityData) {
        this.f41114p.N(communityData);
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_account_layout, viewGroup, false);
    }

    public void uh(boolean z11) {
        super.uh(z11);
        if (z11) {
            g.i("PV_Me_view", (HashMap) null);
            Oh();
        } else {
            if (isAlive()) {
                dismissProgressDialog();
                if (!r.x().F0()) {
                    ViewUtil.m(this.f41112n, false);
                    ViewUtil.m(this.f41113o, false);
                }
            }
            RollPagerView rollPagerView = this.f41123y;
            if (rollPagerView != null) {
                rollPagerView.pause();
            }
            LightBubblePopup lightBubblePopup = this.X;
            if (lightBubblePopup != null) {
                lightBubblePopup.dismiss();
            }
            LightBubblePopup lightBubblePopup2 = this.Y;
            if (lightBubblePopup2 != null) {
                lightBubblePopup2.dismiss();
            }
        }
        Banner banner = this.J;
        if (banner == null) {
            return;
        }
        if (z11) {
            banner.start();
        } else {
            banner.stop();
        }
    }
}
