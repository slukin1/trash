package com.huobi.account.ui;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.core.content.ContextCompat;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.content.interfaces.NoDoubleClickListener;
import com.huobi.account.bean.AccountLoadSuccessEvent;
import com.huobi.account.entity.MultipleAccountData;
import com.huobi.account.presenter.MultipleAccountPresenter;
import com.huobi.login.bean.JumpTarget;
import com.huobi.utils.k0;
import com.huobi.view.rv.VerticalDividerItemDecoration;
import com.huobi.view.title.HbTitleBar;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import rn.c;
import tg.g;

@Route(path = "/account/multiple")
public class MultipleAccountActivity extends BaseActivity<MultipleAccountPresenter, MultipleAccountPresenter.b> implements MultipleAccountPresenter.b {

    /* renamed from: b  reason: collision with root package name */
    public View f41225b;

    /* renamed from: c  reason: collision with root package name */
    public EasyRecyclerView f41226c;

    /* renamed from: d  reason: collision with root package name */
    public HbTitleBar f41227d;

    /* renamed from: e  reason: collision with root package name */
    public List<MultipleAccountData> f41228e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public boolean f41229f = false;

    /* renamed from: g  reason: collision with root package name */
    public MultipleAccountData.a f41230g = new a();

    public class a implements MultipleAccountData.a {
        public a() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void e(MultipleAccountData multipleAccountData, HBDialogFragment hBDialogFragment) {
            ArrayList arrayList = new ArrayList();
            List<MultipleAccountData> a11 = g.a();
            MultipleAccountData multipleAccountData2 = null;
            for (MultipleAccountData next : a11) {
                if (next.getUid().equals(multipleAccountData.getUid())) {
                    multipleAccountData2 = next;
                }
                next.setEditMode(MultipleAccountActivity.this.f41229f);
                next.setOnAccountItemClickListener(MultipleAccountActivity.this.f41230g);
            }
            a11.remove(multipleAccountData2);
            arrayList.addAll(a11);
            MultipleAccountActivity.this.f41228e.clear();
            MultipleAccountActivity.this.f41228e.addAll(arrayList);
            MultipleAccountActivity.this.f41226c.setData(MultipleAccountActivity.this.f41228e);
            g.c(a11);
            HuobiToastUtil.s(R.string.n_delete_account_success_hint);
            hBDialogFragment.dismiss();
        }

        public void a(MultipleAccountData multipleAccountData, int i11) {
            MultipleAccountActivity.this.showProgressDialog(false);
            MultipleAccountActivity.this.Z4(i11, 1);
            ((MultipleAccountPresenter) MultipleAccountActivity.this.getPresenter()).W(multipleAccountData, i11);
        }

        public void b(MultipleAccountData multipleAccountData) {
            new DialogUtils.b.d(MultipleAccountActivity.this).c1(MultipleAccountActivity.this.getString(R.string.n_login_tip)).C0(String.format(Locale.ENGLISH, MultipleAccountActivity.this.getString(R.string.n_delete_account_hint), new Object[]{multipleAccountData.getAccount()})).P0(MultipleAccountActivity.this.getString(R.string.n_confirm)).s0(MultipleAccountActivity.this.getString(R.string.n_cancel)).Q0(new k0(this, multipleAccountData)).N0(l0.f41739a).k0().show(MultipleAccountActivity.this.getSupportFragmentManager(), "");
        }
    }

    public class b extends NoDoubleClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ImageView f41232b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TextView f41233c;

        public b(ImageView imageView, TextView textView) {
            this.f41232b = imageView;
            this.f41233c = textView;
        }

        public void onViewClick(View view) {
            if (MultipleAccountActivity.this.f41229f) {
                MultipleAccountActivity.this.sh();
            } else {
                this.f41232b.setVisibility(8);
                this.f41233c.setVisibility(0);
                MultipleAccountActivity.this.f41227d.getBackAction().setVisibility(4);
                MultipleAccountActivity.this.f41227d.setTitle("");
                MultipleAccountActivity.this.vh(true, false);
                MultipleAccountActivity.this.f41225b.setVisibility(8);
            }
            MultipleAccountActivity multipleAccountActivity = MultipleAccountActivity.this;
            boolean unused = multipleAccountActivity.f41229f = true ^ multipleAccountActivity.f41229f;
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        Intent k11 = c.i().k(this, false, (String) null);
        k11.putExtra("login_multiple_account", true);
        c.i().c(k11, new JumpTarget(k0.a(this), (Intent) null));
        startActivity(k11);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void U4(MultipleAccountData multipleAccountData) {
    }

    public void Z4(int i11, int i12) {
        this.f41228e.get(i11).setStatus(i12);
        this.f41226c.getAdapter().notifyDataSetChanged();
    }

    public void addEvent() {
        this.f41225b.setOnClickListener(new j0(this));
        TextView tvAction = this.f41227d.getTvAction();
        tvAction.setVisibility(8);
        this.f41227d.setOnClickActionListener(new b(this.f41227d.getIvAction(), tvAction));
    }

    public int getContentView() {
        return R.layout.activity_multiple_account;
    }

    public void initView() {
        this.f41227d = (HbTitleBar) this.viewFinder.b(R.id.title_bar);
        EasyRecyclerView easyRecyclerView = (EasyRecyclerView) this.viewFinder.b(R.id.account_rv);
        this.f41226c = easyRecyclerView;
        easyRecyclerView.addItemDecoration(new VerticalDividerItemDecoration(ContextCompat.getDrawable(this, R.color.baseColorPrimarySeparator), PixelUtils.a(0.5f), false, false));
        this.f41225b = this.viewFinder.b(R.id.add_account_ll);
        vh(false, true);
        if (!EventBus.d().i(this)) {
            EventBus.d().p(this);
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onAccountLoadSuccess(AccountLoadSuccessEvent accountLoadSuccessEvent) {
        uh();
    }

    public void onBackPressed() {
        if (this.f41229f) {
            sh();
            this.f41229f = false;
            return;
        }
        super.onBackPressed();
    }

    public void onDestroy() {
        super.onDestroy();
        if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
    }

    public void onResume() {
        super.onResume();
        uh();
    }

    /* renamed from: rh */
    public MultipleAccountPresenter createPresenter() {
        return new MultipleAccountPresenter();
    }

    public final void sh() {
        this.f41227d.getIvAction().setVisibility(0);
        this.f41227d.getTvAction().setVisibility(8);
        this.f41227d.getBackAction().setVisibility(0);
        this.f41227d.setTitleRes(R.string.n_login_switch_title);
        vh(false, false);
        this.f41225b.setVisibility(0);
    }

    /* renamed from: th */
    public MultipleAccountPresenter.b getUI() {
        return this;
    }

    public final void uh() {
        List<MultipleAccountData> a11 = g.a();
        MultipleAccountData multipleAccountData = null;
        for (MultipleAccountData next : a11) {
            if (next.isCurrentAccount()) {
                multipleAccountData = next;
            }
            next.setEditMode(this.f41229f);
            next.setOnAccountItemClickListener(this.f41230g);
        }
        if (multipleAccountData != null) {
            a11.remove(multipleAccountData);
            a11.add(0, multipleAccountData);
        }
        this.f41228e.clear();
        this.f41228e.addAll(a11);
        this.f41226c.setData(this.f41228e);
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }

    public final void vh(boolean z11, boolean z12) {
        List<MultipleAccountData> a11 = g.a();
        for (MultipleAccountData next : a11) {
            next.setEditMode(z11);
            next.setOnAccountItemClickListener(this.f41230g);
        }
        this.f41228e.clear();
        this.f41228e.addAll(a11);
        this.f41226c.setData(this.f41228e);
        if (z12) {
            g.c(a11);
        }
    }
}
