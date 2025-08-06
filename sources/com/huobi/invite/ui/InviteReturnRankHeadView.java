package com.huobi.invite.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.huobi.invite.bean.InviteReturnDetail;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import dm.a;
import i6.m;
import java.util.List;
import pro.huobi.R;

public class InviteReturnRankHeadView extends LinearLayout implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public TextView f74600b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f74601c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f74602d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f74603e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f74604f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f74605g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f74606h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f74607i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f74608j;

    /* renamed from: k  reason: collision with root package name */
    public a f74609k;

    /* renamed from: l  reason: collision with root package name */
    public List<InviteReturnDetail> f74610l;

    public InviteReturnRankHeadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public final void a(Context context) {
        LinearLayout.inflate(context, R.layout.layout_invite_return_rank_head, this);
        setOrientation(0);
        setGravity(1);
        b(context);
    }

    public final void b(Context context) {
        this.f74600b = (TextView) findViewById(R.id.invite_no1_account);
        this.f74601c = (TextView) findViewById(R.id.invite_no1_usdt_amount);
        this.f74602d = (TextView) findViewById(R.id.invite_no1_point_amount);
        this.f74603e = (TextView) findViewById(R.id.invite_no2_account);
        this.f74604f = (TextView) findViewById(R.id.invite_no2_usdt_amount);
        this.f74605g = (TextView) findViewById(R.id.invite_no2_point_amount);
        this.f74606h = (TextView) findViewById(R.id.invite_no3_account);
        this.f74607i = (TextView) findViewById(R.id.invite_no3_usdt_amount);
        this.f74608j = (TextView) findViewById(R.id.invite_no3_point_amount);
        findViewById(R.id.invite_no1_layout).setOnClickListener(this);
        findViewById(R.id.invite_no2_layout).setOnClickListener(this);
        findViewById(R.id.invite_no3_layout).setOnClickListener(this);
    }

    public void c(List<InviteReturnDetail> list) {
        TextView textView;
        TextView textView2;
        if (list != null) {
            this.f74610l = list;
        }
        int i11 = 0;
        String str = "--";
        String str2 = str;
        String str3 = str2;
        while (i11 < 3) {
            TextView textView3 = null;
            InviteReturnDetail inviteReturnDetail = (list == null || i11 >= list.size()) ? null : list.get(i11);
            if (inviteReturnDetail != null) {
                str = inviteReturnDetail.getAccount();
                str2 = m.i(inviteReturnDetail.getAmountSum().doubleValue(), PrecisionUtil.h());
                str3 = m.i(inviteReturnDetail.getPointSum().doubleValue(), PrecisionUtil.h());
            }
            if (i11 == 0) {
                textView3 = this.f74600b;
                textView2 = this.f74601c;
                textView = this.f74602d;
            } else if (i11 == 1) {
                textView3 = this.f74603e;
                textView2 = this.f74604f;
                textView = this.f74605g;
            } else if (i11 != 2) {
                textView2 = null;
                textView = null;
            } else {
                textView3 = this.f74606h;
                textView2 = this.f74607i;
                textView = this.f74608j;
            }
            if (textView3 != null) {
                textView3.setText(str);
            }
            if (textView2 != null) {
                textView2.setText(str2);
            }
            if (textView != null) {
                textView.setText(str3);
            }
            i11++;
        }
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        List<InviteReturnDetail> list;
        if (this.f74609k == null) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        int id2 = view.getId();
        if (id2 == R.id.invite_no1_layout) {
            List<InviteReturnDetail> list2 = this.f74610l;
            if (list2 != null && list2.size() > 0) {
                this.f74609k.O(this.f74610l.get(0));
            }
        } else if (id2 == R.id.invite_no2_layout) {
            List<InviteReturnDetail> list3 = this.f74610l;
            if (list3 != null && list3.size() > 1) {
                this.f74609k.O(this.f74610l.get(1));
            }
        } else if (id2 == R.id.invite_no3_layout && (list = this.f74610l) != null && list.size() > 2) {
            this.f74609k.O(this.f74610l.get(2));
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void setCallback(a aVar) {
        this.f74609k = aVar;
    }

    public InviteReturnRankHeadView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a(context);
    }
}
