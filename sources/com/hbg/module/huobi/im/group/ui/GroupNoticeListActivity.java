package com.hbg.module.huobi.im.group.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.module.huobi.im.R$color;
import com.hbg.module.huobi.im.R$drawable;
import com.hbg.module.huobi.im.R$id;
import com.hbg.module.huobi.im.R$layout;
import com.hbg.module.huobi.im.group.base.BaseActivity;
import com.hbg.module.huobi.im.group.bean.GroupNoticeItemEntity;
import com.hbg.module.huobi.im.group.bean.GroupNoticeListEntity;
import com.hbg.module.huobi.im.group.bean.OberverData;
import com.hbg.module.huobi.im.group.ui.adapter.m;
import com.hbg.module.huobi.im.observer.ImObserverHelper;
import com.hbg.module.huobi.im.utils.HbGroupUserManager;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.imsdk.v2.V2TIMManager;
import i6.d;
import java.util.Observable;
import java.util.Observer;
import kotlin.jvm.internal.r;
import ld.e;
import ld.f;
import rd.s;

public final class GroupNoticeListActivity extends BaseActivity implements View.OnClickListener, Observer {

    /* renamed from: l  reason: collision with root package name */
    public static final a f20029l = new a((r) null);

    /* renamed from: d  reason: collision with root package name */
    public LoadingLayout f20030d;

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView f20031e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f20032f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f20033g;

    /* renamed from: h  reason: collision with root package name */
    public f f20034h;

    /* renamed from: i  reason: collision with root package name */
    public m f20035i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f20036j;

    /* renamed from: k  reason: collision with root package name */
    public String f20037k;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public static final class b implements kd.a<GroupNoticeListEntity> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GroupNoticeListActivity f20038a;

        public b(GroupNoticeListActivity groupNoticeListActivity) {
            this.f20038a = groupNoticeListActivity;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.hbg.lib.widgets.LoadingLayout} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: com.hbg.module.huobi.im.group.ui.adapter.m} */
        /* JADX WARNING: type inference failed for: r1v0 */
        /* JADX WARNING: type inference failed for: r1v2 */
        /* JADX WARNING: type inference failed for: r1v4 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onSuccess(com.hbg.module.huobi.im.group.bean.GroupNoticeListEntity r4) {
            /*
                r3 = this;
                com.hbg.module.huobi.im.group.ui.GroupNoticeListActivity r0 = r3.f20038a
                boolean r0 = r0.Bf(r0)
                if (r0 != 0) goto L_0x0009
                return
            L_0x0009:
                com.hbg.module.huobi.im.group.ui.GroupNoticeListActivity r0 = r3.f20038a
                com.hbg.lib.widgets.LoadingLayout r0 = r0.f20030d
                r1 = 0
                if (r0 != 0) goto L_0x0013
                r0 = r1
            L_0x0013:
                r0.g()
                java.util.List r0 = r4.getListData()
                if (r0 == 0) goto L_0x003b
                com.hbg.module.huobi.im.group.ui.GroupNoticeListActivity r2 = r3.f20038a
                int r0 = r0.size()
                if (r0 <= 0) goto L_0x0030
                com.hbg.module.huobi.im.group.ui.adapter.m r0 = r2.f20035i
                if (r0 != 0) goto L_0x002b
                goto L_0x002c
            L_0x002b:
                r1 = r0
            L_0x002c:
                r1.n(r4)
                goto L_0x003b
            L_0x0030:
                com.hbg.lib.widgets.LoadingLayout r4 = r2.f20030d
                if (r4 != 0) goto L_0x0037
                goto L_0x0038
            L_0x0037:
                r1 = r4
            L_0x0038:
                r1.i()
            L_0x003b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.huobi.im.group.ui.GroupNoticeListActivity.b.onSuccess(com.hbg.module.huobi.im.group.bean.GroupNoticeListEntity):void");
        }

        public void onFailed(int i11, String str) {
            GroupNoticeListActivity groupNoticeListActivity = this.f20038a;
            if (groupNoticeListActivity.Bf(groupNoticeListActivity)) {
                LoadingLayout gg2 = this.f20038a.f20030d;
                if (gg2 == null) {
                    gg2 = null;
                }
                gg2.k();
            }
        }
    }

    @SensorsDataInstrumented
    public static final void ph(GroupNoticeListActivity groupNoticeListActivity, View view) {
        groupNoticeListActivity.qh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void Pg(GroupNoticeItemEntity groupNoticeItemEntity) {
        Intent intent = new Intent(this, GroupChatNoticeActivity.class);
        intent.putExtra("isAdmin", this.f20036j);
        intent.putExtra("noticeItemData", groupNoticeItemEntity);
        intent.putExtra("groupId", this.f20037k);
        intent.putExtra("noticeEditMode", false);
        startActivityForResult(intent, 1008);
    }

    public final void Qg() {
        if (this.f20036j) {
            Intent intent = new Intent(this, GroupChatNoticeActivity.class);
            intent.putExtra("isAdmin", this.f20036j);
            intent.putExtra("groupId", this.f20037k);
            intent.putExtra("noticeEditMode", true);
            startActivityForResult(intent, 1008);
        }
    }

    public final void initView() {
        this.f20032f = (ImageView) findViewById(R$id.iv_back);
        this.f20033g = (TextView) findViewById(R$id.tv_action_right);
        this.f20031e = (RecyclerView) findViewById(R$id.rv_group_notice_list);
        this.f20030d = (LoadingLayout) findViewById(R$id.loading_layout);
        RecyclerView recyclerView = null;
        if (this.f20036j) {
            TextView textView = this.f20033g;
            if (textView == null) {
                textView = null;
            }
            textView.setVisibility(0);
        } else {
            TextView textView2 = this.f20033g;
            if (textView2 == null) {
                textView2 = null;
            }
            textView2.setVisibility(8);
        }
        m mVar = new m(this);
        this.f20035i = mVar;
        mVar.m(this.f20036j);
        RecyclerView recyclerView2 = this.f20031e;
        if (recyclerView2 == null) {
            recyclerView2 = null;
        }
        m mVar2 = this.f20035i;
        if (mVar2 == null) {
            mVar2 = null;
        }
        recyclerView2.setAdapter(mVar2);
        RecyclerView recyclerView3 = this.f20031e;
        if (recyclerView3 == null) {
            recyclerView3 = null;
        }
        recyclerView3.setLayoutManager(new LinearLayoutManager(this));
        h hVar = new h(this, 1);
        Drawable drawable = ContextCompat.getDrawable(this, R$drawable.item_notice_decoration);
        if (drawable != null) {
            hVar.setDrawable(drawable);
        }
        RecyclerView recyclerView4 = this.f20031e;
        if (recyclerView4 != null) {
            recyclerView = recyclerView4;
        }
        recyclerView.addItemDecoration(hVar);
    }

    public final void oh() {
        s sVar = s.f23381a;
        ImageView imageView = this.f20032f;
        LoadingLayout loadingLayout = null;
        s.l(sVar, imageView == null ? null : imageView, this, 0, 2, (Object) null);
        TextView textView = this.f20033g;
        s.l(sVar, textView == null ? null : textView, this, 0, 2, (Object) null);
        LoadingLayout loadingLayout2 = this.f20030d;
        if (loadingLayout2 != null) {
            loadingLayout = loadingLayout2;
        }
        View findViewById = loadingLayout.findViewById(R$id.viewErrorRetry);
        if (findViewById != null) {
            findViewById.setOnClickListener(new y(this));
        }
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i12 == -1 && i11 == 1008) {
            setResult(-1);
            finish();
        }
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        if (view.getId() == R$id.iv_back) {
            finish();
        } else if (view.getId() == R$id.tv_action_right) {
            Qg();
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
        setContentView(R$layout.layout_group_notice_list);
        String str = null;
        this.f20034h = new f((e) null);
        Intent intent = getIntent();
        if (intent != null) {
            str = intent.getStringExtra("group_id");
        }
        this.f20037k = str;
        this.f20036j = HbGroupUserManager.c().d(V2TIMManager.getInstance().getLoginUser());
        initView();
        oh();
        qh();
    }

    public void onDestroy() {
        super.onDestroy();
        ImObserverHelper.b().deleteObserver(this);
    }

    public void onStart() {
        super.onStart();
        ImObserverHelper.b().addObserver(this);
    }

    public final void qh() {
        String str = this.f20037k;
        if (str != null) {
            LoadingLayout loadingLayout = this.f20030d;
            f fVar = null;
            if (loadingLayout == null) {
                loadingLayout = null;
            }
            loadingLayout.p();
            f fVar2 = this.f20034h;
            if (fVar2 != null) {
                fVar = fVar2;
            }
            fVar.i(str, new b(this));
        }
    }

    public void update(Observable observable, Object obj) {
        if ((obj instanceof OberverData) && ((OberverData) obj).getType() == 1 && Bf(this)) {
            d.j("GroupNoticeListActivity", "oberver 刷新数据");
            qh();
        }
    }
}
