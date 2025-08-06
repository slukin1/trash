package com.huobi.invite.ui;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.adapter.recyclerview.StableLinearLayoutManager;
import com.huobi.invite.bean.InviteReturnDetail;
import com.huobi.invite.presenter.InviteRankingListPresenter;
import com.huobi.view.pickerview.PickerViewManager;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import pro.huobi.R;
import s9.a;

public class InviteRankingListActivity extends BaseActivity<InviteRankingListPresenter, InviteRankingListPresenter.a> implements InviteRankingListPresenter.a, View.OnClickListener, PickerViewManager.Callback {

    /* renamed from: b  reason: collision with root package name */
    public View f74568b;

    /* renamed from: c  reason: collision with root package name */
    public View f74569c;

    /* renamed from: d  reason: collision with root package name */
    public EasyRecyclerView f74570d;

    /* renamed from: e  reason: collision with root package name */
    public InviteReturnRankHeadView f74571e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f74572f;

    /* renamed from: g  reason: collision with root package name */
    public long f74573g;

    /* renamed from: h  reason: collision with root package name */
    public PickerViewManager f74574h;

    /* renamed from: i  reason: collision with root package name */
    public SimpleDateFormat f74575i = new SimpleDateFormat("yy/MM", Locale.US);

    public void Md(List<InviteReturnDetail> list, List<a> list2) {
        if (list2 == null || list2.isEmpty()) {
            this.f74571e.setVisibility(8);
            this.f74568b.setBackgroundResource(0);
            gg(true);
        } else {
            gg(false);
            this.f74568b.setBackgroundResource(R.drawable.invite_rank_bg_both_image);
            this.f74571e.setVisibility(0);
            InviteReturnRankHeadView inviteReturnRankHeadView = this.f74571e;
            if (inviteReturnRankHeadView != null) {
                inviteReturnRankHeadView.c(list);
            }
        }
        EasyRecyclerView easyRecyclerView = this.f74570d;
        if (easyRecyclerView != null) {
            easyRecyclerView.setData(list2);
        }
        Og();
        Pg();
    }

    public final void Og() {
        TextView textView = this.f74572f;
        if (textView != null) {
            textView.setText(this.f74575i.format(new Date(this.f74573g)));
        }
    }

    public final void Pg() {
        ((Toolbar) this.viewFinder.b(R.id.toolbar)).setTitle((CharSequence) Yf());
    }

    /* renamed from: Xf */
    public InviteRankingListPresenter createPresenter() {
        return new InviteRankingListPresenter();
    }

    public final String Yf() {
        return getString(R.string.invite_ranking_list_title);
    }

    /* renamed from: Zf */
    public InviteRankingListPresenter.a getUI() {
        return this;
    }

    public void addEvent() {
        this.viewFinder.b(R.id.id_invite_ranking_list_date_layout).setOnClickListener(this);
    }

    public final void fg() {
        setToolBar((Toolbar) this.viewFinder.b(R.id.toolbar), Yf(), true);
    }

    public int getContentView() {
        return R.layout.activity_invite_ranking_list;
    }

    public final void gg(boolean z11) {
        View view = this.f74569c;
        if (view != null) {
            view.setVisibility(z11 ? 0 : 8);
        }
    }

    public void initView() {
        this.f74568b = this.viewFinder.b(R.id.id_invite_ranking_list_recyclerView_parent_layout);
        this.f74569c = this.viewFinder.b(R.id.id_common_empty_view);
        this.f74571e = (InviteReturnRankHeadView) this.viewFinder.b(R.id.id_invite_ranking_list_head_view);
        this.f74572f = (TextView) this.viewFinder.b(R.id.id_invite_ranking_list_month);
        this.f74570d = (EasyRecyclerView) this.viewFinder.b(R.id.id_invite_ranking_list_recyclerView);
        StableLinearLayoutManager stableLinearLayoutManager = new StableLinearLayoutManager(this);
        stableLinearLayoutManager.setSmoothScrollbarEnabled(true);
        stableLinearLayoutManager.setAutoMeasureEnabled(true);
        this.f74570d.setLayoutManager(stableLinearLayoutManager);
        this.f74570d.setHasFixedSize(true);
        this.f74573g = Calendar.getInstance().getTimeInMillis();
        Calendar.getInstance().setTime(new Date());
        Og();
        fg();
        PickerViewManager pickerViewManager = new PickerViewManager(this);
        this.f74574h = pickerViewManager;
        pickerViewManager.setCallback(this);
    }

    public long jc() {
        return this.f74573g;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        PickerViewManager pickerViewManager;
        if (view.getId() == R.id.id_invite_ranking_list_date_layout && (pickerViewManager = this.f74574h) != null) {
            pickerViewManager.show();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onTimeSelect(Date date) {
        this.f74573g = date.getTime();
        ((InviteRankingListPresenter) getPresenter()).R();
    }
}
