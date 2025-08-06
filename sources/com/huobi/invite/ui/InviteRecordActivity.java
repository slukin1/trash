package com.huobi.invite.ui;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.huobi.invite.bean.InviteRecordListItem;
import com.huobi.invite.bean.InviteReturnRecordListItem;
import com.huobi.invite.presenter.InviteRecordPresenter;
import com.huobi.page.SmartRefreshFooter;
import com.huobi.page.SmartRefreshHeader;
import com.huobi.view.bottompopfragmentmenu.BottomMenuFragment;
import com.huobi.view.bottompopfragmentmenu.MenuItem;
import com.huobi.view.bottompopfragmentmenu.MenuItemOnClickListener;
import com.huobi.view.pickerview.PickerViewManager;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import ky.j;
import ny.d;
import pro.huobi.R;
import rx.Observable;

public class InviteRecordActivity extends BaseActivity<InviteRecordPresenter, InviteRecordPresenter.a> implements InviteRecordPresenter.a, InviteReturnRecordListItem.a, View.OnClickListener, MenuItemOnClickListener, PickerViewManager.Callback {

    /* renamed from: b  reason: collision with root package name */
    public View f74576b;

    /* renamed from: c  reason: collision with root package name */
    public View f74577c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f74578d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f74579e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f74580f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f74581g;

    /* renamed from: h  reason: collision with root package name */
    public View f74582h;

    /* renamed from: i  reason: collision with root package name */
    public View f74583i;

    /* renamed from: j  reason: collision with root package name */
    public EasyRecyclerView f74584j;

    /* renamed from: k  reason: collision with root package name */
    public SmartRefreshLayout f74585k;

    /* renamed from: l  reason: collision with root package name */
    public SmartRefreshHeader f74586l;

    /* renamed from: m  reason: collision with root package name */
    public SmartRefreshFooter f74587m;

    /* renamed from: n  reason: collision with root package name */
    public int f74588n = 1;

    /* renamed from: o  reason: collision with root package name */
    public BottomMenuFragment f74589o = new BottomMenuFragment();

    /* renamed from: p  reason: collision with root package name */
    public MenuItem f74590p;

    /* renamed from: q  reason: collision with root package name */
    public MenuItem f74591q;

    /* renamed from: r  reason: collision with root package name */
    public MenuItem f74592r;

    /* renamed from: s  reason: collision with root package name */
    public MenuItem f74593s;

    /* renamed from: t  reason: collision with root package name */
    public int f74594t = -1;

    /* renamed from: u  reason: collision with root package name */
    public PickerViewManager f74595u;

    /* renamed from: v  reason: collision with root package name */
    public SimpleDateFormat f74596v = new SimpleDateFormat("yy/MM", Locale.US);

    /* renamed from: w  reason: collision with root package name */
    public Date f74597w = new Date();

    /* renamed from: x  reason: collision with root package name */
    public boolean f74598x;

    public class a implements d {
        public a() {
        }

        public void P8(j jVar) {
            InviteRecordActivity.this.uh();
        }

        public void bf(j jVar) {
            int fg2 = InviteRecordActivity.this.f74588n;
            if (fg2 == 1) {
                ((InviteRecordPresenter) InviteRecordActivity.this.getPresenter()).k0();
            } else if (fg2 == 2) {
                ((InviteRecordPresenter) InviteRecordActivity.this.getPresenter()).l0();
            }
            InviteRecordActivity.this.uh();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List sh(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            s9.a aVar = (s9.a) it2.next();
            if (aVar != null && (aVar instanceof InviteRecordListItem)) {
                InviteRecordListItem inviteRecordListItem = (InviteRecordListItem) aVar;
                int i11 = this.f74594t;
                if (i11 == -1) {
                    arrayList.add(inviteRecordListItem);
                } else if (i11 != 0) {
                    if (i11 != 1) {
                        if (i11 == 2 && inviteRecordListItem.getState() == 2) {
                            arrayList.add(inviteRecordListItem);
                        }
                    } else if (inviteRecordListItem.getState() == 1) {
                        arrayList.add(inviteRecordListItem);
                    }
                } else if (inviteRecordListItem.getState() == 0) {
                    arrayList.add(inviteRecordListItem);
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void th(List list) {
        tc(list);
        xh(true);
    }

    public final void Ah() {
        TextView textView = this.f74578d;
        if (textView != null && this.f74579e != null) {
            int i11 = this.f74588n;
            if (i11 == 1) {
                textView.setBackgroundResource(R.drawable.shape_invite_record_tab_left_focus);
                this.f74579e.setBackgroundResource(R.drawable.shape_invite_record_tab_right);
                this.f74578d.setTextColor(oh(R.color.invite_record_tab_focus_text_color));
                this.f74579e.setTextColor(oh(R.color.invite_record_tab_unfocus_text_color));
                this.f74582h.setVisibility(8);
                this.f74583i.setVisibility(0);
                vh();
            } else if (i11 == 2) {
                textView.setBackgroundResource(R.drawable.shape_invite_record_tab_left);
                this.f74579e.setBackgroundResource(R.drawable.shape_invite_record_tab_right_focus);
                this.f74578d.setTextColor(oh(R.color.invite_record_tab_unfocus_text_color));
                this.f74579e.setTextColor(oh(R.color.invite_record_tab_focus_text_color));
                this.f74582h.setVisibility(0);
                this.f74583i.setVisibility(8);
                if (this.f74598x) {
                    vh();
                    return;
                }
                this.f74598x = true;
                uh();
            }
        }
    }

    public void D6() {
        hideLoading();
        vh();
    }

    public void M5(InviteReturnRecordListItem inviteReturnRecordListItem) {
    }

    public final void Pg(int i11) {
        if (this.f74588n != i11) {
            this.f74588n = i11;
            Ah();
        }
    }

    /* renamed from: Qg */
    public InviteRecordPresenter createPresenter() {
        return new InviteRecordPresenter();
    }

    public void addEvent() {
        this.f74578d.setOnClickListener(this);
        this.f74579e.setOnClickListener(this);
        this.f74582h.setOnClickListener(this);
        this.f74583i.setOnClickListener(this);
        this.f74585k.e0(new a());
    }

    public int getContentView() {
        return R.layout.activity_invite_record;
    }

    public final void hideLoading() {
        if (this.f74585k.M()) {
            this.f74585k.finishRefresh();
        }
        if (this.f74585k.K()) {
            this.f74585k.w();
        }
        this.f74586l.b(DateTimeUtils.h(DateTimeUtils.v(), "MM-dd HH:mm:ss"));
    }

    public void i4(List<s9.a> list) {
        hideLoading();
        vh();
    }

    public void initView() {
        this.f74576b = this.viewFinder.b(R.id.id_common_empty_view);
        this.f74577c = this.viewFinder.b(R.id.id_invite_record_group_layout);
        this.f74578d = (TextView) this.viewFinder.b(R.id.id_invite_record_tab_invite_tv);
        this.f74579e = (TextView) this.viewFinder.b(R.id.id_invite_record_tab_return_tv);
        this.f74584j = (EasyRecyclerView) this.viewFinder.b(R.id.id_invite_record_recyclerView);
        this.f74582h = this.viewFinder.b(R.id.id_invite_record_expand_date);
        this.f74580f = (TextView) this.viewFinder.b(R.id.id_invite_record_expand_date_tv);
        this.f74583i = this.viewFinder.b(R.id.id_invite_record_expand_state);
        this.f74581g = (TextView) this.viewFinder.b(R.id.id_invite_record_expand_state_tv);
        this.f74585k = (SmartRefreshLayout) this.viewFinder.b(R.id.invite_record_ptrLayout);
        rh();
        qh();
        PickerViewManager pickerViewManager = new PickerViewManager(this);
        this.f74595u = pickerViewManager;
        pickerViewManager.setCallback(this);
        this.f74580f.setText(this.f74596v.format(this.f74597w));
        this.f74585k.V(true);
        this.f74586l = new SmartRefreshHeader(this);
        this.f74587m = new SmartRefreshFooter(this);
        this.f74585k.j0(this.f74586l);
        this.f74585k.h0(this.f74587m);
    }

    public void jb() {
        hideLoading();
        vh();
    }

    public final int oh(int i11) {
        return getResources().getColor(i11);
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_invite_record_expand_date:
                PickerViewManager pickerViewManager = this.f74595u;
                if (pickerViewManager != null) {
                    pickerViewManager.show();
                    break;
                }
                break;
            case R.id.id_invite_record_expand_state:
                yh();
                break;
            case R.id.id_invite_record_tab_invite_tv:
                Pg(1);
                break;
            case R.id.id_invite_record_tab_return_tv:
                Pg(2);
                break;
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onClickMenuItem(View view, MenuItem menuItem, int i11) {
        BottomMenuFragment bottomMenuFragment = this.f74589o;
        if (bottomMenuFragment != null) {
            bottomMenuFragment.dismiss();
        }
        if (menuItem != null && this.f74594t != menuItem.getType()) {
            this.f74594t = menuItem.getType();
            zh();
            ((InviteRecordPresenter) getPresenter()).k0();
            ((InviteRecordPresenter) getPresenter()).i0();
        }
    }

    public void onTimeSelect(Date date) {
        this.f74597w = date;
        ((InviteRecordPresenter) getPresenter()).l0();
        ((InviteRecordPresenter) getPresenter()).j0(date);
    }

    /* renamed from: ph */
    public InviteRecordPresenter.a getUI() {
        return this;
    }

    public final void qh() {
        String string = getString(R.string.invite_record_expand_state_all);
        MenuItem.MenuItemStyle menuItemStyle = MenuItem.MenuItemStyle.COMMON;
        this.f74590p = new MenuItem(-1, "", string, menuItemStyle, this);
        MenuItem.MenuItemStyle menuItemStyle2 = menuItemStyle;
        this.f74591q = new MenuItem(1, "", getString(R.string.invite_record_expand_state_valid), menuItemStyle2, this);
        this.f74592r = new MenuItem(0, "", getString(R.string.invite_record_expand_state_invalid), menuItemStyle2, this);
        this.f74593s = new MenuItem(2, "", getString(R.string.invite_record_expand_state_can_not_use), menuItemStyle2, this);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f74590p);
        arrayList.add(this.f74591q);
        arrayList.add(this.f74592r);
        arrayList.add(this.f74593s);
        this.f74589o.setMenuItems(arrayList);
        zh();
    }

    public int re() {
        return this.f74594t;
    }

    public final void rh() {
        setToolBar((Toolbar) this.viewFinder.b(R.id.toolbar), "", true);
    }

    public final void tc(List<s9.a> list) {
        wh(list == null || list.isEmpty());
        EasyRecyclerView easyRecyclerView = this.f74584j;
        if (easyRecyclerView != null) {
            easyRecyclerView.setData(list);
        }
    }

    public final void uh() {
        int i11 = this.f74588n;
        if (i11 == 1) {
            ((InviteRecordPresenter) getPresenter()).i0();
        } else if (i11 == 2) {
            ((InviteRecordPresenter) getPresenter()).j0(this.f74597w);
        }
    }

    public final void vh() {
        int i11 = this.f74588n;
        if (i11 == 1) {
            Observable.just(((InviteRecordPresenter) getPresenter()).X()).compose(RxJavaHelper.t(getUI())).map(new i(this)).subscribe(q6.d.c(getUI(), new h(this)));
        } else if (i11 == 2) {
            tc(((InviteRecordPresenter) getPresenter()).Y());
            xh(false);
            this.f74580f.setText(this.f74596v.format(this.f74597w));
        }
    }

    public final void wh(boolean z11) {
        View view = this.f74576b;
        if (view != null) {
            view.setVisibility(z11 ? 0 : 8);
        }
    }

    public final void xh(boolean z11) {
        View view = this.f74577c;
        if (view != null) {
            view.setVisibility(z11 ? 0 : 8);
        }
    }

    public final void yh() {
        BottomMenuFragment bottomMenuFragment = this.f74589o;
        if (bottomMenuFragment != null) {
            bottomMenuFragment.show(getFragmentManager(), "mStateMenuFragment");
        }
    }

    public void za(List<s9.a> list) {
        hideLoading();
        vh();
    }

    public final void zh() {
        MenuItem.MenuItemStyle menuItemStyle;
        MenuItem.MenuItemStyle menuItemStyle2;
        MenuItem.MenuItemStyle menuItemStyle3;
        MenuItem.MenuItemStyle menuItemStyle4;
        MenuItem menuItem = this.f74590p;
        if (this.f74594t == -1) {
            menuItemStyle = MenuItem.MenuItemStyle.STRESS;
        } else {
            menuItemStyle = MenuItem.MenuItemStyle.COMMON;
        }
        menuItem.setStyle(menuItemStyle);
        MenuItem menuItem2 = this.f74591q;
        if (this.f74594t == 1) {
            menuItemStyle2 = MenuItem.MenuItemStyle.STRESS;
        } else {
            menuItemStyle2 = MenuItem.MenuItemStyle.COMMON;
        }
        menuItem2.setStyle(menuItemStyle2);
        MenuItem menuItem3 = this.f74592r;
        if (this.f74594t == 0) {
            menuItemStyle3 = MenuItem.MenuItemStyle.STRESS;
        } else {
            menuItemStyle3 = MenuItem.MenuItemStyle.COMMON;
        }
        menuItem3.setStyle(menuItemStyle3);
        MenuItem menuItem4 = this.f74593s;
        if (this.f74594t == 2) {
            menuItemStyle4 = MenuItem.MenuItemStyle.STRESS;
        } else {
            menuItemStyle4 = MenuItem.MenuItemStyle.COMMON;
        }
        menuItem4.setStyle(menuItemStyle4);
        int i11 = this.f74594t;
        if (i11 == -1) {
            this.f74581g.setText(this.f74590p.getText());
        } else if (i11 == 0) {
            this.f74581g.setText(this.f74592r.getText());
        } else if (i11 == 1) {
            this.f74581g.setText(this.f74591q.getText());
        } else if (i11 == 2) {
            this.f74581g.setText(this.f74593s.getText());
        }
    }
}
