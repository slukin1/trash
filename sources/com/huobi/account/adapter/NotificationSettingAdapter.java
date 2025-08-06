package com.huobi.account.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.network.hbg.core.bean.NoticeManageResp;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import gs.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import og.h;
import og.i;
import og.j;
import og.k;
import og.l;
import og.m;
import pro.huobi.R;

public class NotificationSettingAdapter extends BaseExpandableListAdapter {

    /* renamed from: a  reason: collision with root package name */
    public List<NoticeManageResp> f40931a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public c f40932b;

    /* renamed from: c  reason: collision with root package name */
    public a f40933c;

    public interface a {
        void w8(int i11, int i12, SwitchCompat switchCompat, NoticeManageResp noticeManageResp, boolean z11);
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public SwitchCompat f40934a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f40935b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f40936c;

        /* renamed from: d  reason: collision with root package name */
        public View f40937d;
    }

    public interface c {
        void Dc(int i11, SwitchCompat switchCompat, NoticeManageResp noticeManageResp, boolean z11);
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public SwitchCompat f40938a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f40939b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f40940c;

        /* renamed from: d  reason: collision with root package name */
        public View f40941d;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i(int i11, int i12, b bVar, NoticeManageResp noticeManageResp, HashMap hashMap, HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        this.f40933c.w8(i11, i12, bVar.f40934a, noticeManageResp, false);
        g.i("app_inform_window_Close_click", hashMap);
    }

    public static /* synthetic */ void j(b bVar, HashMap hashMap, HBDialogFragment hBDialogFragment) {
        bVar.f40934a.setChecked(true);
        hBDialogFragment.dismiss();
        g.i("app_inform_window_noClose_click", hashMap);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void k(boolean z11, int i11, int i12, b bVar, NoticeManageResp noticeManageResp, CompoundButton compoundButton, boolean z12) {
        b bVar2 = bVar;
        boolean z13 = z12;
        a aVar = this.f40933c;
        if (!(aVar == null || z11 == z13)) {
            if (z13) {
                aVar.w8(i11, i12, bVar2.f40934a, noticeManageResp, true);
            } else {
                HashMap hashMap = new HashMap();
                hashMap.put("notiId", Integer.valueOf(noticeManageResp.getId()));
                String string = bVar2.f40934a.getContext().getString(R.string.n_push_setting_close_title);
                String string2 = bVar2.f40934a.getContext().getString(R.string.n_push_setting_close_sub_title);
                String string3 = bVar2.f40934a.getContext().getString(R.string.n_push_setting_close_anyway);
                String string4 = bVar2.f40934a.getContext().getString(R.string.n_push_setting_not_closed);
                FragmentActivity h11 = h(bVar2.f40934a);
                if (h11 == null) {
                    SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
                    return;
                } else {
                    DialogUtils.b0(h11, string, string2, "", string3, string4, new l(this, i11, i12, bVar, noticeManageResp, hashMap), new j(bVar2, hashMap));
                    g.i("app_inform_window_show", hashMap);
                }
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l(int i11, d dVar, NoticeManageResp noticeManageResp, HashMap hashMap, HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        this.f40932b.Dc(i11, dVar.f40938a, noticeManageResp, false);
        g.i("app_inform_window_Close_click", hashMap);
    }

    public static /* synthetic */ void m(d dVar, HashMap hashMap, HBDialogFragment hBDialogFragment) {
        dVar.f40938a.setChecked(true);
        hBDialogFragment.dismiss();
        g.i("app_inform_window_noClose_click", hashMap);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void n(boolean z11, int i11, d dVar, NoticeManageResp noticeManageResp, CompoundButton compoundButton, boolean z12) {
        d dVar2 = dVar;
        boolean z13 = z12;
        c cVar = this.f40932b;
        if (!(cVar == null || z11 == z13)) {
            if (z13) {
                cVar.Dc(i11, dVar2.f40938a, noticeManageResp, true);
            } else {
                int i12 = i11;
                NoticeManageResp noticeManageResp2 = noticeManageResp;
                HashMap hashMap = new HashMap();
                hashMap.put("notiId", Integer.valueOf(noticeManageResp.getId()));
                String string = dVar2.f40938a.getContext().getString(R.string.n_push_setting_close_title);
                String string2 = dVar2.f40938a.getContext().getString(R.string.n_push_setting_close_sub_title);
                String string3 = dVar2.f40938a.getContext().getString(R.string.n_push_setting_close_anyway);
                String string4 = dVar2.f40938a.getContext().getString(R.string.n_push_setting_not_closed);
                FragmentActivity h11 = h(dVar2.f40938a);
                if (h11 == null) {
                    SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
                    return;
                } else {
                    DialogUtils.b0(h11, string, string2, "", string3, string4, new m(this, i11, dVar, noticeManageResp, hashMap), new k(dVar2, hashMap));
                    g.i("app_inform_window_show", hashMap);
                }
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }

    public List<NoticeManageResp> g() {
        return this.f40931a;
    }

    public Object getChild(int i11, int i12) {
        List<NoticeManageResp> subList = this.f40931a.get(i11).getSubList();
        if (subList != null) {
            return subList.get(i12);
        }
        return null;
    }

    public long getChildId(int i11, int i12) {
        return (((long) i11) * 100) + ((long) i12);
    }

    public View getChildView(int i11, int i12, boolean z11, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.notification_manager_chlid_item, (ViewGroup) null);
            bVar = new b();
            bVar.f40935b = (TextView) view.findViewById(R.id.notificationChildTitle);
            bVar.f40936c = (TextView) view.findViewById(R.id.notificationChildSubTitle);
            bVar.f40934a = (SwitchCompat) view.findViewById(R.id.notificationChildSwitch);
            bVar.f40937d = view.findViewById(R.id.notificationChildDivider);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        b bVar2 = bVar;
        bVar2.f40934a.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        if (z11) {
            bVar2.f40937d.setVisibility(0);
        } else {
            bVar2.f40937d.setVisibility(8);
        }
        NoticeManageResp noticeManageResp = this.f40931a.get(i11).getSubList().get(i12);
        bVar2.f40935b.setText(noticeManageResp.getTitle());
        if (!TextUtils.isEmpty(noticeManageResp.getExplain())) {
            bVar2.f40936c.setText(noticeManageResp.getExplain());
            bVar2.f40936c.setVisibility(0);
        } else {
            bVar2.f40936c.setVisibility(8);
        }
        boolean equals = "1".equals(noticeManageResp.getSubState());
        bVar2.f40934a.setChecked(equals);
        bVar2.f40934a.setOnCheckedChangeListener(new h(this, equals, i11, i12, bVar2, noticeManageResp));
        return view;
    }

    public int getChildrenCount(int i11) {
        List<NoticeManageResp> subList = this.f40931a.get(i11).getSubList();
        if (subList != null) {
            return subList.size();
        }
        return 0;
    }

    public Object getGroup(int i11) {
        return this.f40931a.get(i11);
    }

    public int getGroupCount() {
        return this.f40931a.size();
    }

    public long getGroupId(int i11) {
        return (long) i11;
    }

    public View getGroupView(int i11, boolean z11, View view, ViewGroup viewGroup) {
        d dVar;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.notification_manager_group_item, (ViewGroup) null);
            dVar = new d();
            dVar.f40939b = (TextView) view.findViewById(R.id.notificationGroupTitle);
            dVar.f40940c = (TextView) view.findViewById(R.id.notificationGroupSubTitle);
            dVar.f40938a = (SwitchCompat) view.findViewById(R.id.notificationSwitch);
            dVar.f40941d = view.findViewById(R.id.notificationDivider);
            view.setTag(dVar);
        } else {
            dVar = (d) view.getTag();
        }
        d dVar2 = dVar;
        dVar2.f40938a.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        NoticeManageResp noticeManageResp = this.f40931a.get(i11);
        if (noticeManageResp.getSubList() == null || noticeManageResp.getSubList().size() <= 0) {
            dVar2.f40941d.setVisibility(0);
        } else {
            dVar2.f40941d.setVisibility(8);
        }
        dVar2.f40939b.setText(noticeManageResp.getTitle());
        if (!TextUtils.isEmpty(noticeManageResp.getExplain())) {
            dVar2.f40940c.setText(noticeManageResp.getExplain());
            dVar2.f40940c.setVisibility(0);
        } else {
            dVar2.f40940c.setVisibility(8);
        }
        boolean equals = "1".equals(noticeManageResp.getSubState());
        dVar2.f40938a.setChecked(equals);
        dVar2.f40938a.setOnCheckedChangeListener(new i(this, equals, i11, dVar2, noticeManageResp));
        return view;
    }

    public final FragmentActivity h(View view) {
        Context context = view.getContext();
        if (context instanceof FragmentActivity) {
            return (FragmentActivity) context;
        }
        if (context instanceof ContextWrapper) {
            ContextWrapper contextWrapper = (ContextWrapper) context;
            if (contextWrapper.getBaseContext() instanceof FragmentActivity) {
                return (FragmentActivity) contextWrapper.getBaseContext();
            }
        }
        Activity c11 = com.blankj.utilcode.util.a.c();
        if (c11 instanceof FragmentActivity) {
            return (FragmentActivity) c11;
        }
        return null;
    }

    public boolean hasStableIds() {
        return true;
    }

    public boolean isChildSelectable(int i11, int i12) {
        return true;
    }

    public void o(a aVar) {
        this.f40933c = aVar;
    }

    public void p(List<NoticeManageResp> list) {
        this.f40931a = list;
        notifyDataSetChanged();
    }

    public void q(c cVar) {
        this.f40932b = cVar;
    }
}
