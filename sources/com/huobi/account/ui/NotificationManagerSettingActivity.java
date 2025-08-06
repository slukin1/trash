package com.huobi.account.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ExpandableListView;
import androidx.appcompat.widget.SwitchCompat;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.network.hbg.core.bean.NoticeManageResp;
import com.hbg.lib.widgets.LoadingLayout;
import com.huobi.account.adapter.NotificationSettingAdapter;
import com.huobi.account.presenter.NotificationSettingPresenter;
import com.huobi.setting.ui.NoDisturbSwitchView;
import com.huobi.view.title.HbTitleBar;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import pro.huobi.R;

public class NotificationManagerSettingActivity extends BaseActivity<NotificationSettingPresenter, NotificationSettingPresenter.c> implements NotificationSettingPresenter.c, NotificationSettingAdapter.c, NotificationSettingAdapter.a {

    /* renamed from: b  reason: collision with root package name */
    public ExpandableListView f41235b;

    /* renamed from: c  reason: collision with root package name */
    public NotificationSettingAdapter f41236c;

    /* renamed from: d  reason: collision with root package name */
    public LoadingLayout f41237d;

    /* renamed from: e  reason: collision with root package name */
    public NoDisturbSwitchView f41238e;

    /* access modifiers changed from: private */
    public /* synthetic */ void Og(boolean z11, int i11, int i12, SwitchCompat switchCompat, Object obj) {
        if (((Boolean) obj).booleanValue()) {
            this.f41236c.g().get(i11).getSubList().get(i12).setSubState(z11 ? "1" : "2");
            this.f41236c.notifyDataSetChanged();
        } else {
            switchCompat.setChecked(!z11);
        }
        dismissProgressDialog();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Pg(boolean z11, int i11, List list, SwitchCompat switchCompat, Object obj) {
        if (((Boolean) obj).booleanValue()) {
            String str = z11 ? "1" : "2";
            this.f41236c.g().get(i11).setSubState(str);
            if (list != null) {
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    ((NoticeManageResp) it2.next()).setSubState(str);
                }
                this.f41236c.g().get(i11).setSubList(list);
                if (z11) {
                    this.f41235b.expandGroup(i11, true);
                } else {
                    this.f41235b.collapseGroup(i11);
                }
            } else {
                this.f41236c.notifyDataSetChanged();
            }
        } else {
            switchCompat.setChecked(!z11);
        }
        dismissProgressDialog();
    }

    public static void Qg(Context context) {
        context.startActivity(new Intent(context, NotificationManagerSettingActivity.class));
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initView$0(View view) {
        ((NotificationSettingPresenter) getPresenter()).Q();
        this.f41238e.i();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void Dc(int i11, SwitchCompat switchCompat, NoticeManageResp noticeManageResp, boolean z11) {
        showProgressDialog();
        List<NoticeManageResp> subList = noticeManageResp.getSubList();
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(noticeManageResp.getId()));
        if (subList != null) {
            for (NoticeManageResp id2 : subList) {
                arrayList.add(Integer.valueOf(id2.getId()));
            }
        }
        ((NotificationSettingPresenter) getPresenter()).S(arrayList, Integer.valueOf(z11 ? 1 : 2), new o0(this, z11, i11, subList, switchCompat));
    }

    public void H6(List<NoticeManageResp> list) {
        if (list == null) {
            this.f41237d.k();
            return;
        }
        this.f41237d.g();
        this.f41236c.p(list);
        for (int i11 = 0; i11 < list.size(); i11++) {
            if ("1".equals(list.get(i11).getSubState())) {
                this.f41235b.expandGroup(i11);
            }
        }
    }

    public void addEvent() {
        this.f41236c.q(this);
        this.f41236c.o(this);
    }

    /* renamed from: fg */
    public NotificationSettingPresenter createPresenter() {
        return new NotificationSettingPresenter();
    }

    public int getContentView() {
        return R.layout.activity_notification_manager;
    }

    /* renamed from: gg */
    public NotificationSettingPresenter.c getUI() {
        return this;
    }

    public void initView() {
        ((HbTitleBar) this.viewFinder.b(R.id.title_bar)).setTitle(getString(R.string.n_user_center_notification_manager));
        this.f41235b = (ExpandableListView) this.viewFinder.b(R.id.subscribeList);
        this.f41237d = (LoadingLayout) this.viewFinder.b(R.id.loading_layout);
        this.f41238e = (NoDisturbSwitchView) this.viewFinder.b(R.id.noDisturbSwitchView);
        NotificationSettingAdapter notificationSettingAdapter = new NotificationSettingAdapter();
        this.f41236c = notificationSettingAdapter;
        this.f41235b.setAdapter(notificationSettingAdapter);
        this.f41237d.p();
        this.f41237d.setOnRetryClickListener(new m0(this));
        this.f41235b.setGroupIndicator((Drawable) null);
    }

    public void onStart() {
        BaseModuleConfig.a().w("NMG_pv", (HashMap) null);
        super.onStart();
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }

    public void w8(int i11, int i12, SwitchCompat switchCompat, NoticeManageResp noticeManageResp, boolean z11) {
        showProgressDialog();
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(noticeManageResp.getId()));
        ((NotificationSettingPresenter) getPresenter()).S(arrayList, Integer.valueOf(z11 ? 1 : 2), new n0(this, z11, i11, i12, switchCompat));
    }
}
