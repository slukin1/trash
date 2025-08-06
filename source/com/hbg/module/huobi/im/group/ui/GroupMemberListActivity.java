package com.hbg.module.huobi.im.group.ui;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.page.SmartRefreshFooter;
import com.hbg.lib.core.page.SmartRefreshHeader;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.GroupInfoData;
import com.hbg.lib.network.hbg.core.bean.GroupMemberListInfo;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.module.huobi.im.R$color;
import com.hbg.module.huobi.im.R$id;
import com.hbg.module.huobi.im.R$layout;
import com.hbg.module.huobi.im.R$string;
import com.hbg.module.huobi.im.group.base.BaseActivity;
import com.hbg.module.huobi.im.group.ui.adapter.i;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import ky.j;
import rd.s;
import u6.g;

public final class GroupMemberListActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: v  reason: collision with root package name */
    public static final a f20006v = new a((r) null);

    /* renamed from: d  reason: collision with root package name */
    public TextView f20007d;

    /* renamed from: e  reason: collision with root package name */
    public LoadingLayout f20008e;

    /* renamed from: f  reason: collision with root package name */
    public SmartRefreshLayout f20009f;

    /* renamed from: g  reason: collision with root package name */
    public RecyclerView f20010g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout f20011h;

    /* renamed from: i  reason: collision with root package name */
    public AppCompatTextView f20012i;

    /* renamed from: j  reason: collision with root package name */
    public AppCompatEditText f20013j;

    /* renamed from: k  reason: collision with root package name */
    public AppCompatTextView f20014k;

    /* renamed from: l  reason: collision with root package name */
    public nd.a f20015l;

    /* renamed from: m  reason: collision with root package name */
    public i f20016m;

    /* renamed from: n  reason: collision with root package name */
    public String f20017n;

    /* renamed from: o  reason: collision with root package name */
    public String f20018o;

    /* renamed from: p  reason: collision with root package name */
    public GroupMemberListInfo f20019p;

    /* renamed from: q  reason: collision with root package name */
    public String f20020q = "";

    /* renamed from: r  reason: collision with root package name */
    public final HashMap<Integer, String> f20021r = new HashMap<>();

    /* renamed from: s  reason: collision with root package name */
    public int f20022s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f20023t;

    /* renamed from: u  reason: collision with root package name */
    public List<GroupMemberListInfo.GroupMemberInfo> f20024u = new ArrayList();

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public static final class b extends BaseSubscriber<GroupMemberListInfo> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GroupMemberListActivity f20025b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f20026c;

        public b(GroupMemberListActivity groupMemberListActivity, int i11) {
            this.f20025b = groupMemberListActivity;
            this.f20026c = i11;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:32:0x007e, code lost:
            if (kotlin.jvm.internal.x.b(r7 != null ? java.lang.Integer.valueOf(r7.getPageNum()) : null, r7 != null ? java.lang.Integer.valueOf(r7.getPageAll()) : null) != false) goto L_0x0080;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onNext(com.hbg.lib.network.hbg.core.bean.GroupMemberListInfo r7) {
            /*
                r6 = this;
                super.onNext(r7)
                com.hbg.module.huobi.im.group.ui.GroupMemberListActivity r0 = r6.f20025b
                int r1 = r6.f20026c
                r0.f20019p = r7
                r2 = 0
                r3 = 1
                if (r1 != r3) goto L_0x0019
                if (r7 == 0) goto L_0x0015
                int r1 = r7.getManagerAll()
                goto L_0x0016
            L_0x0015:
                r1 = r2
            L_0x0016:
                r0.f20022s = r1
            L_0x0019:
                if (r7 == 0) goto L_0x0035
                java.util.List r0 = r7.getListData()
                if (r0 == 0) goto L_0x0035
                com.hbg.module.huobi.im.group.ui.GroupMemberListActivity r1 = r6.f20025b
                int r4 = r6.f20026c
                java.util.List r5 = r1.Ah()
                r5.addAll(r0)
                if (r4 != r3) goto L_0x0035
                java.util.List r0 = r1.Ah()
                r1.xh(r0)
            L_0x0035:
                com.hbg.module.huobi.im.group.ui.GroupMemberListActivity r0 = r6.f20025b
                r0.Ih()
                com.hbg.module.huobi.im.group.ui.GroupMemberListActivity r0 = r6.f20025b
                com.hbg.module.huobi.im.group.ui.adapter.i r0 = r0.f20016m
                r1 = 0
                if (r0 != 0) goto L_0x0044
                r0 = r1
            L_0x0044:
                r0.notifyDataSetChanged()
                com.hbg.module.huobi.im.group.ui.GroupMemberListActivity r0 = r6.f20025b
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = r0.f20009f
                if (r0 != 0) goto L_0x0050
                r0 = r1
            L_0x0050:
                if (r7 == 0) goto L_0x005d
                java.util.List r4 = r7.getListData()
                if (r4 == 0) goto L_0x005d
                int r4 = r4.size()
                goto L_0x005e
            L_0x005d:
                r4 = r2
            L_0x005e:
                r5 = 30
                if (r4 < r5) goto L_0x0080
                if (r7 == 0) goto L_0x006d
                int r4 = r7.getPageNum()
                java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
                goto L_0x006e
            L_0x006d:
                r4 = r1
            L_0x006e:
                if (r7 == 0) goto L_0x0079
                int r7 = r7.getPageAll()
                java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
                goto L_0x007a
            L_0x0079:
                r7 = r1
            L_0x007a:
                boolean r7 = kotlin.jvm.internal.x.b(r4, r7)
                if (r7 == 0) goto L_0x0081
            L_0x0080:
                r2 = r3
            L_0x0081:
                r0.setNoMoreData(r2)
                com.hbg.module.huobi.im.group.ui.GroupMemberListActivity r7 = r6.f20025b
                com.scwang.smartrefresh.layout.SmartRefreshLayout r7 = r7.f20009f
                if (r7 != 0) goto L_0x008d
                r7 = r1
            L_0x008d:
                r7.w()
                com.hbg.module.huobi.im.group.ui.GroupMemberListActivity r7 = r6.f20025b
                com.hbg.module.huobi.im.group.ui.adapter.i r7 = r7.f20016m
                if (r7 != 0) goto L_0x0099
                r7 = r1
            L_0x0099:
                int r7 = r7.getItemCount()
                if (r7 == 0) goto L_0x00ad
                com.hbg.module.huobi.im.group.ui.GroupMemberListActivity r7 = r6.f20025b
                com.hbg.lib.widgets.LoadingLayout r7 = r7.f20008e
                if (r7 != 0) goto L_0x00a8
                goto L_0x00a9
            L_0x00a8:
                r1 = r7
            L_0x00a9:
                r1.g()
                goto L_0x00ba
            L_0x00ad:
                com.hbg.module.huobi.im.group.ui.GroupMemberListActivity r7 = r6.f20025b
                com.hbg.lib.widgets.LoadingLayout r7 = r7.f20008e
                if (r7 != 0) goto L_0x00b6
                goto L_0x00b7
            L_0x00b6:
                r1 = r7
            L_0x00b7:
                r1.i()
            L_0x00ba:
                com.hbg.module.huobi.im.group.ui.GroupMemberListActivity r7 = r6.f20025b
                r7.dismissProgressDialog()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.huobi.im.group.ui.GroupMemberListActivity.b.onNext(com.hbg.lib.network.hbg.core.bean.GroupMemberListInfo):void");
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            this.f20025b.dismissProgressDialog();
            SmartRefreshLayout sh2 = this.f20025b.f20009f;
            LoadingLayout loadingLayout = null;
            if (sh2 == null) {
                sh2 = null;
            }
            sh2.w();
            LoadingLayout rh2 = this.f20025b.f20008e;
            if (rh2 != null) {
                loadingLayout = rh2;
            }
            loadingLayout.k();
        }
    }

    public static final class c implements TextWatcher {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GroupMemberListActivity f20027b;

        public c(GroupMemberListActivity groupMemberListActivity) {
            this.f20027b = groupMemberListActivity;
        }

        public void afterTextChanged(Editable editable) {
            AppCompatTextView oh2 = this.f20027b.f20014k;
            if (oh2 == null) {
                oh2 = null;
            }
            int i11 = 0;
            if (!(editable.length() > 0)) {
                i11 = 8;
            }
            oh2.setVisibility(i11);
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public static final class d implements kd.a<GroupInfoData> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GroupMemberListActivity f20028a;

        public d(GroupMemberListActivity groupMemberListActivity) {
            this.f20028a = groupMemberListActivity;
        }

        @SuppressLint({"SetTextI18n"})
        /* renamed from: a */
        public void onSuccess(GroupInfoData groupInfoData) {
            if (groupInfoData != null) {
                TextView th2 = this.f20028a.f20007d;
                TextView textView = null;
                if (th2 == null) {
                    th2 = null;
                }
                th2.setVisibility(0);
                AppCompatTextView uh2 = this.f20028a.f20012i;
                if (uh2 == null) {
                    uh2 = null;
                }
                String ph2 = this.f20028a.f20018o;
                if (ph2 == null) {
                    ph2 = null;
                }
                uh2.setText(ph2);
                TextView th3 = this.f20028a.f20007d;
                if (th3 != null) {
                    textView = th3;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append('(');
                sb2.append(groupInfoData.getUserCount());
                sb2.append(')');
                textView.setText(sb2.toString());
            }
        }

        @SuppressLint({"SetTextI18n"})
        public void onFailed(int i11, String str) {
            TextView th2 = this.f20028a.f20007d;
            TextView textView = null;
            if (th2 == null) {
                th2 = null;
            }
            th2.setVisibility(0);
            AppCompatTextView uh2 = this.f20028a.f20012i;
            if (uh2 == null) {
                uh2 = null;
            }
            String ph2 = this.f20028a.f20018o;
            if (ph2 == null) {
                ph2 = null;
            }
            uh2.setText(ph2);
            TextView th3 = this.f20028a.f20007d;
            if (th3 != null) {
                textView = th3;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append('(');
            GroupMemberListInfo qh2 = this.f20028a.f20019p;
            sb2.append(qh2 != null ? Integer.valueOf(qh2.getTotal()) : "");
            sb2.append(')');
            textView.setText(sb2.toString());
        }
    }

    public static final void Dh(GroupMemberListActivity groupMemberListActivity, j jVar) {
        String str = groupMemberListActivity.f20017n;
        AppCompatEditText appCompatEditText = null;
        if (str == null) {
            str = null;
        }
        GroupMemberListInfo groupMemberListInfo = groupMemberListActivity.f20019p;
        int pageNum = (groupMemberListInfo != null ? groupMemberListInfo.getPageNum() : 0) + 1;
        AppCompatEditText appCompatEditText2 = groupMemberListActivity.f20013j;
        if (appCompatEditText2 != null) {
            appCompatEditText = appCompatEditText2;
        }
        groupMemberListActivity.yh(str, pageNum, String.valueOf(appCompatEditText.getText()));
    }

    public static final boolean Eh(GroupMemberListActivity groupMemberListActivity, View view, int i11, KeyEvent keyEvent) {
        if (i11 != 66 || keyEvent.getAction() != 1) {
            return false;
        }
        groupMemberListActivity.Bh();
        groupMemberListActivity.f20024u.clear();
        String str = groupMemberListActivity.f20017n;
        AppCompatEditText appCompatEditText = null;
        if (str == null) {
            str = null;
        }
        AppCompatEditText appCompatEditText2 = groupMemberListActivity.f20013j;
        if (appCompatEditText2 != null) {
            appCompatEditText = appCompatEditText2;
        }
        groupMemberListActivity.yh(str, 1, String.valueOf(appCompatEditText.getText()));
        return false;
    }

    @SensorsDataInstrumented
    public static final void Fh(GroupMemberListActivity groupMemberListActivity, View view) {
        String str = groupMemberListActivity.f20017n;
        AppCompatEditText appCompatEditText = null;
        if (str == null) {
            str = null;
        }
        GroupMemberListInfo groupMemberListInfo = groupMemberListActivity.f20019p;
        int pageNum = (groupMemberListInfo != null ? groupMemberListInfo.getPageNum() : 0) + 1;
        AppCompatEditText appCompatEditText2 = groupMemberListActivity.f20013j;
        if (appCompatEditText2 != null) {
            appCompatEditText = appCompatEditText2;
        }
        groupMemberListActivity.yh(str, pageNum, String.valueOf(appCompatEditText.getText()));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final List<GroupMemberListInfo.GroupMemberInfo> Ah() {
        return this.f20024u;
    }

    public final void Bh() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        View currentFocus = getCurrentFocus();
        inputMethodManager.hideSoftInputFromWindow(currentFocus != null ? currentFocus.getWindowToken() : null, 2);
    }

    public final void Ch() {
        s sVar = s.f23381a;
        FrameLayout frameLayout = this.f20011h;
        LoadingLayout loadingLayout = null;
        s.l(sVar, frameLayout == null ? null : frameLayout, this, 0, 2, (Object) null);
        FrameLayout frameLayout2 = this.f20011h;
        s.l(sVar, frameLayout2 == null ? null : frameLayout2, this, 0, 2, (Object) null);
        AppCompatTextView appCompatTextView = this.f20014k;
        s.l(sVar, appCompatTextView == null ? null : appCompatTextView, this, 0, 2, (Object) null);
        SmartRefreshLayout smartRefreshLayout = this.f20009f;
        if (smartRefreshLayout == null) {
            smartRefreshLayout = null;
        }
        smartRefreshLayout.b0(new x(this));
        AppCompatEditText appCompatEditText = this.f20013j;
        if (appCompatEditText == null) {
            appCompatEditText = null;
        }
        appCompatEditText.setOnKeyListener(new w(this));
        AppCompatEditText appCompatEditText2 = this.f20013j;
        if (appCompatEditText2 == null) {
            appCompatEditText2 = null;
        }
        appCompatEditText2.addTextChangedListener(new c(this));
        LoadingLayout loadingLayout2 = this.f20008e;
        if (loadingLayout2 != null) {
            loadingLayout = loadingLayout2;
        }
        loadingLayout.setOnRetryClickListener(new v(this));
    }

    public final boolean Gh() {
        return this.f20023t;
    }

    public final void Hh() {
        rd.c.b().c(new d(this));
    }

    @SuppressLint({"SetTextI18n"})
    public final void Ih() {
        this.f20021r.clear();
        GroupMemberListInfo groupMemberListInfo = this.f20019p;
        int total = (groupMemberListInfo != null ? groupMemberListInfo.getTotal() : 0) - this.f20022s;
        String string = getResources().getString(R$string.n_im_group_manager_count, new Object[]{String.valueOf(this.f20022s)});
        String string2 = getResources().getString(R$string.n_im_group_normal_member_count, new Object[]{String.valueOf(total)});
        this.f20021r.put(0, string);
        this.f20021r.put(Integer.valueOf(this.f20022s), string2);
        nd.a aVar = this.f20015l;
        if (aVar == null) {
            aVar = null;
        }
        aVar.c(this.f20021r);
        Hh();
    }

    public final void initExtra() {
        String stringExtra = getIntent().getStringExtra("groupId");
        String str = "";
        if (stringExtra == null) {
            stringExtra = str;
        }
        this.f20017n = stringExtra;
        String stringExtra2 = getIntent().getStringExtra("groupTitle");
        if (stringExtra2 != null) {
            str = stringExtra2;
        }
        this.f20018o = str;
    }

    public final void initView() {
        this.f20010g = (RecyclerView) findViewById(R$id.group_member_list);
        this.f20011h = (FrameLayout) findViewById(R$id.fl_back);
        this.f20012i = (AppCompatTextView) findViewById(R$id.tv_title);
        this.f20013j = (AppCompatEditText) findViewById(R$id.aet_keyword);
        this.f20014k = (AppCompatTextView) findViewById(R$id.atv_cancel);
        this.f20009f = (SmartRefreshLayout) findViewById(R$id.srl_group_member_list);
        this.f20008e = (LoadingLayout) findViewById(R$id.member_list_loadingLayout);
        this.f20007d = (TextView) findViewById(R$id.tv_title_extra);
        SmartRefreshLayout smartRefreshLayout = this.f20009f;
        RecyclerView recyclerView = null;
        if (smartRefreshLayout == null) {
            smartRefreshLayout = null;
        }
        smartRefreshLayout.j0(new SmartRefreshHeader(this));
        SmartRefreshLayout smartRefreshLayout2 = this.f20009f;
        if (smartRefreshLayout2 == null) {
            smartRefreshLayout2 = null;
        }
        smartRefreshLayout2.h0(new SmartRefreshFooter(this));
        SmartRefreshLayout smartRefreshLayout3 = this.f20009f;
        if (smartRefreshLayout3 == null) {
            smartRefreshLayout3 = null;
        }
        smartRefreshLayout3.T(true);
        SmartRefreshLayout smartRefreshLayout4 = this.f20009f;
        if (smartRefreshLayout4 == null) {
            smartRefreshLayout4 = null;
        }
        smartRefreshLayout4.i(false);
        List<GroupMemberListInfo.GroupMemberInfo> list = this.f20024u;
        String str = this.f20017n;
        if (str == null) {
            str = null;
        }
        this.f20016m = new i(list, str);
        nd.a aVar = new nd.a(this, -16776961, getResources().getColor(R$color.baseColorSecondaryTextNew), getResources().getColor(R$color.baseColorRemarksBackground), 0.0f);
        this.f20015l = aVar;
        aVar.d((int) TypedValue.applyDimension(1, 30.0f, getResources().getDisplayMetrics()));
        RecyclerView recyclerView2 = this.f20010g;
        if (recyclerView2 == null) {
            recyclerView2 = null;
        }
        nd.a aVar2 = this.f20015l;
        if (aVar2 == null) {
            aVar2 = null;
        }
        recyclerView2.addItemDecoration(aVar2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(1);
        RecyclerView recyclerView3 = this.f20010g;
        if (recyclerView3 == null) {
            recyclerView3 = null;
        }
        recyclerView3.setLayoutManager(linearLayoutManager);
        RecyclerView recyclerView4 = this.f20010g;
        if (recyclerView4 == null) {
            recyclerView4 = null;
        }
        i iVar = this.f20016m;
        if (iVar == null) {
            iVar = null;
        }
        recyclerView4.setAdapter(iVar);
        RecyclerView recyclerView5 = this.f20010g;
        if (recyclerView5 != null) {
            recyclerView = recyclerView5;
        }
        com.hbg.module.libkt.base.ext.b.f(recyclerView);
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R$id.fl_back) {
            finish();
        } else if (id2 == R$id.atv_cancel) {
            AppCompatEditText appCompatEditText = this.f20013j;
            String str = null;
            if (appCompatEditText == null) {
                appCompatEditText = null;
            }
            appCompatEditText.setText("");
            view.setVisibility(8);
            Bh();
            this.f20024u.clear();
            String str2 = this.f20017n;
            if (str2 != null) {
                str = str2;
            }
            yh(str, 1, "");
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(getResources().getColor(R$color.baseColorDeepestBackground));
            getWindow().setNavigationBarColor(getResources().getColor(R$color.white_day_black_night_color));
            Xf(this, !NightHelper.e().g());
        }
        setContentView(R$layout.activity_member_list);
        initExtra();
        initView();
        Ch();
        String str = this.f20017n;
        if (str == null) {
            str = null;
        }
        yh(str, 1, "");
    }

    public void onResume() {
        super.onResume();
        Hh();
    }

    public final void xh(List<? extends GroupMemberListInfo.GroupMemberInfo> list) {
        for (GroupMemberListInfo.GroupMemberInfo groupMemberInfo : list) {
            if (groupMemberInfo.getRole() != 2 && groupMemberInfo.getRole() != 3) {
                return;
            }
            if (x.b(BaseModuleConfig.a().f0(), groupMemberInfo.getAccount())) {
                this.f20023t = true;
                return;
            }
        }
    }

    public final void yh(String str, int i11, String str2) {
        zh(str, i11, str2, false);
    }

    public final void zh(String str, int i11, String str2, boolean z11) {
        showProgressDialog();
        if (!x.b(this.f20020q, str2) || z11) {
            i11 = 1;
            this.f20024u.clear();
        }
        this.f20020q = str2;
        v7.b.a().getGroupMemberList(str, i11, str2).b().compose(RxJavaHelper.t((g) null)).subscribe(new b(this, i11));
    }
}
