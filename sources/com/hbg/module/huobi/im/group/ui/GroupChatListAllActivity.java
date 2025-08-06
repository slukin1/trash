package com.hbg.module.huobi.im.group.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.page.SmartRefreshFooter;
import com.hbg.lib.core.page.SmartRefreshHeader;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.module.huobi.im.R$id;
import com.hbg.module.huobi.im.R$layout;
import com.hbg.module.huobi.im.group.bean.ImGroupChatBean;
import com.hbg.module.huobi.im.group.bean.ImGroupChatItemBean;
import com.huobi.utils.StatusBarUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.List;
import ky.j;
import ld.a;
import ld.c;
import ny.d;
import rd.s;

public final class GroupChatListAllActivity extends AppCompatActivity implements c, d {

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f19954b;

    /* renamed from: c  reason: collision with root package name */
    public SmartRefreshLayout f19955c;

    /* renamed from: d  reason: collision with root package name */
    public int f19956d = 1;

    /* renamed from: e  reason: collision with root package name */
    public final int f19957e = 20;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f19958f;

    /* renamed from: g  reason: collision with root package name */
    public final List<ImGroupChatItemBean> f19959g;

    /* renamed from: h  reason: collision with root package name */
    public final com.hbg.module.huobi.im.group.ui.adapter.d f19960h;

    /* renamed from: i  reason: collision with root package name */
    public final a f19961i;

    public GroupChatListAllActivity() {
        ArrayList arrayList = new ArrayList();
        this.f19959g = arrayList;
        this.f19960h = new com.hbg.module.huobi.im.group.ui.adapter.d(this, arrayList);
        this.f19961i = new a(this);
    }

    @SensorsDataInstrumented
    public static final void Bf(GroupChatListAllActivity groupChatListAllActivity, View view) {
        groupChatListAllActivity.finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final ImageView Af() {
        ImageView imageView = this.f19958f;
        if (imageView != null) {
            return imageView;
        }
        return null;
    }

    public final void Df(ImageView imageView) {
        this.f19958f = imageView;
    }

    public void P8(j jVar) {
        this.f19961i.a(BaseModuleConfig.a().getUid(), this.f19956d, this.f19957e);
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(AppLanguageHelper.getInstance().attachBaseContext(context));
    }

    public void bf(j jVar) {
        this.f19956d = 1;
        SmartRefreshLayout smartRefreshLayout = this.f19955c;
        if (smartRefreshLayout == null) {
            smartRefreshLayout = null;
        }
        smartRefreshLayout.setNoMoreData(false);
        this.f19961i.a(BaseModuleConfig.a().getUid(), this.f19956d, this.f19957e);
    }

    public void onCreate(Bundle bundle) {
        s.f23381a.n(getWindow(), false);
        getWindow().getDecorView().setSystemUiVisibility(9216);
        super.onCreate(bundle);
        setContentView(R$layout.activity_group_chat_list_all);
        ((ConstraintLayout.LayoutParams) ((RelativeLayout) findViewById(R$id.titleBar)).getLayoutParams()).setMargins(0, StatusBarUtils.a(this), 0, 0);
        Df((ImageView) findViewById(R$id.iv_group_list_back));
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) findViewById(R$id.rlRefresh);
        this.f19955c = smartRefreshLayout;
        RecyclerView recyclerView = null;
        if (smartRefreshLayout == null) {
            smartRefreshLayout = null;
        }
        smartRefreshLayout.j0(new SmartRefreshHeader(this));
        SmartRefreshLayout smartRefreshLayout2 = this.f19955c;
        if (smartRefreshLayout2 == null) {
            smartRefreshLayout2 = null;
        }
        smartRefreshLayout2.h0(new SmartRefreshFooter(this));
        SmartRefreshLayout smartRefreshLayout3 = this.f19955c;
        if (smartRefreshLayout3 == null) {
            smartRefreshLayout3 = null;
        }
        smartRefreshLayout3.e0(this);
        RecyclerView recyclerView2 = (RecyclerView) findViewById(R$id.rv_group_chat_list);
        this.f19954b = recyclerView2;
        if (recyclerView2 != null) {
            recyclerView = recyclerView2;
        }
        recyclerView.setAdapter(this.f19960h);
        Af().setOnClickListener(new r(this));
    }

    public void onResume() {
        super.onResume();
        this.f19956d = 1;
        SmartRefreshLayout smartRefreshLayout = this.f19955c;
        if (smartRefreshLayout == null) {
            smartRefreshLayout = null;
        }
        smartRefreshLayout.setNoMoreData(false);
        this.f19961i.a(BaseModuleConfig.a().getUid(), this.f19956d, this.f19957e);
    }

    public void t7(ImGroupChatBean imGroupChatBean) {
        SmartRefreshLayout smartRefreshLayout = this.f19955c;
        SmartRefreshLayout smartRefreshLayout2 = null;
        if (smartRefreshLayout == null) {
            smartRefreshLayout = null;
        }
        smartRefreshLayout.finishRefresh();
        SmartRefreshLayout smartRefreshLayout3 = this.f19955c;
        if (smartRefreshLayout3 == null) {
            smartRefreshLayout3 = null;
        }
        smartRefreshLayout3.w();
        List<ImGroupChatItemBean> listData = imGroupChatBean.getListData();
        if (!(listData == null || listData.isEmpty())) {
            if (this.f19956d == 1) {
                this.f19959g.clear();
            }
            List<ImGroupChatItemBean> listData2 = imGroupChatBean.getListData();
            if (listData2 != null) {
                for (ImGroupChatItemBean add : listData2) {
                    this.f19959g.add(add);
                }
            }
            this.f19960h.notifyDataSetChanged();
            this.f19956d++;
            return;
        }
        SmartRefreshLayout smartRefreshLayout4 = this.f19955c;
        if (smartRefreshLayout4 != null) {
            smartRefreshLayout2 = smartRefreshLayout4;
        }
        smartRefreshLayout2.e();
    }
}
