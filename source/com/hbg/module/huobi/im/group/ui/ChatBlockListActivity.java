package com.hbg.module.huobi.im.group.ui;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.module.huobi.im.R$color;
import com.hbg.module.huobi.im.R$id;
import com.hbg.module.huobi.im.R$layout;
import com.hbg.module.huobi.im.R$string;
import com.hbg.module.huobi.im.group.base.BaseActivity;
import com.hbg.module.huobi.im.group.bean.ChatBlockEntity;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.List;
import ld.e;
import ld.f;
import rd.s;

public final class ChatBlockListActivity extends BaseActivity {

    /* renamed from: d  reason: collision with root package name */
    public LoadingLayout f19878d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f19879e;

    /* renamed from: f  reason: collision with root package name */
    public RecyclerView f19880f;

    /* renamed from: g  reason: collision with root package name */
    public com.hbg.module.huobi.im.group.ui.adapter.b f19881g;

    /* renamed from: h  reason: collision with root package name */
    public f f19882h = new f((e) null);

    public static final class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f19883b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f19884c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ChatBlockListActivity f19885d;

        public a(View view, long j11, ChatBlockListActivity chatBlockListActivity) {
            this.f19883b = view;
            this.f19884c = j11;
            this.f19885d = chatBlockListActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f19883b) > this.f19884c || (this.f19883b instanceof Checkable)) {
                sVar.e(this.f19883b, currentTimeMillis);
                this.f19885d.oh();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f19886b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f19887c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ChatBlockListActivity f19888d;

        public b(View view, long j11, ChatBlockListActivity chatBlockListActivity) {
            this.f19886b = view;
            this.f19887c = j11;
            this.f19888d = chatBlockListActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f19886b) > this.f19887c || (this.f19886b instanceof Checkable)) {
                sVar.e(this.f19886b, currentTimeMillis);
                ImageView imageView = (ImageView) this.f19886b;
                this.f19888d.finish();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class c implements kd.a<List<? extends ChatBlockEntity>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ChatBlockListActivity f19889a;

        public c(ChatBlockListActivity chatBlockListActivity) {
            this.f19889a = chatBlockListActivity;
        }

        /* renamed from: a */
        public void onSuccess(List<ChatBlockEntity> list) {
            if (list.size() > 0) {
                this.f19889a.f1().g();
                this.f19889a.Og().i(list);
                this.f19889a.Og().notifyDataSetChanged();
                return;
            }
            this.f19889a.f1().i();
        }

        public void onFailed(int i11, String str) {
            if (i11 == 10) {
                this.f19889a.f1().i();
            } else {
                this.f19889a.f1().k();
            }
        }
    }

    public final com.hbg.module.huobi.im.group.ui.adapter.b Og() {
        com.hbg.module.huobi.im.group.ui.adapter.b bVar = this.f19881g;
        if (bVar != null) {
            return bVar;
        }
        return null;
    }

    public final ImageView Pg() {
        ImageView imageView = this.f19879e;
        if (imageView != null) {
            return imageView;
        }
        return null;
    }

    public final RecyclerView Qg() {
        RecyclerView recyclerView = this.f19880f;
        if (recyclerView != null) {
            return recyclerView;
        }
        return null;
    }

    public final LoadingLayout f1() {
        LoadingLayout loadingLayout = this.f19878d;
        if (loadingLayout != null) {
            return loadingLayout;
        }
        return null;
    }

    public final void gg() {
        View findViewById = f1().findViewById(R$id.viewErrorRetry);
        if (findViewById != null) {
            s sVar = s.f23381a;
            findViewById.setOnClickListener(new a(findViewById, 800, this));
        }
        s sVar2 = s.f23381a;
        ImageView Pg = Pg();
        Pg.setOnClickListener(new b(Pg, 800, this));
    }

    public final void initView() {
        rh((LoadingLayout) findViewById(R$id.loading_layout));
        qh((ImageView) findViewById(R$id.iv_back));
        sh((RecyclerView) findViewById(R$id.rv_block_list));
        ((TextView) f1().findViewById(R$id.tv_error_msg)).setText(getString(R$string.n_im_black_list_empth));
        ph(new com.hbg.module.huobi.im.group.ui.adapter.b(this));
        Qg().setLayoutManager(new LinearLayoutManager(this));
        Qg().setAdapter(Og());
    }

    public final void oh() {
        f1().p();
        this.f19882h.g(BaseModuleConfig.a().f(), new c(this));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(getResources().getColor(R$color.baseColorDeepestBackground));
            getWindow().setNavigationBarColor(getResources().getColor(R$color.white_day_black_night_color));
            Xf(this, !NightHelper.e().g());
        }
        setContentView(R$layout.layout_chat_bolck_list);
        initView();
        gg();
        oh();
    }

    public final void ph(com.hbg.module.huobi.im.group.ui.adapter.b bVar) {
        this.f19881g = bVar;
    }

    public final void qh(ImageView imageView) {
        this.f19879e = imageView;
    }

    public final void rh(LoadingLayout loadingLayout) {
        this.f19878d = loadingLayout;
    }

    public final void sh(RecyclerView recyclerView) {
        this.f19880f = recyclerView;
    }
}
