package com.hbg.lib.widgets.notice;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.widgets.R$color;
import com.hbg.lib.widgets.R$drawable;
import com.hbg.lib.widgets.R$id;
import com.hbg.lib.widgets.R$layout;
import com.hbg.lib.widgets.R$styleable;
import com.hbg.lib.widgets.TopScrollData;
import com.hbg.lib.widgets.TopScrollItemView;
import com.hbg.lib.widgets.TopScrollView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import ha.c;
import i6.d;
import i6.t;
import java.util.List;

public class TopScrollNoticeView2 extends FrameLayout implements View.OnClickListener, t.a {

    /* renamed from: b  reason: collision with root package name */
    public TopScrollNoticeItemView2 f72096b;

    /* renamed from: c  reason: collision with root package name */
    public TopScrollNoticeItemView2 f72097c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f72098d;

    /* renamed from: e  reason: collision with root package name */
    public View f72099e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f72100f;

    /* renamed from: g  reason: collision with root package name */
    public TopScrollView.b f72101g;

    /* renamed from: h  reason: collision with root package name */
    public int f72102h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f72103i;

    /* renamed from: j  reason: collision with root package name */
    public int f72104j;

    /* renamed from: k  reason: collision with root package name */
    public List<TopScrollData> f72105k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f72106l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f72107m;

    public class a implements TopScrollItemView.a {
        public a() {
        }

        public void a(TopScrollData topScrollData) {
            TopScrollNoticeView2.this.setLeftIcon(topScrollData);
        }
    }

    public TopScrollNoticeView2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean f(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 1) {
            return false;
        }
        this.f72098d.setImageResource(R$drawable.home_notice_more_btn);
        view.performClick();
        return true;
    }

    public final TopScrollData b(int i11) {
        List<TopScrollData> list = this.f72105k;
        if (list == null || list.isEmpty() || i11 >= this.f72105k.size()) {
            return null;
        }
        return this.f72105k.get(i11);
    }

    public void c() {
        ViewUtil.m(this.f72099e, false);
    }

    public final void d(Context context, AttributeSet attributeSet) {
        this.f72100f = new t(this);
        e(context);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.TopScrollNoticeView);
        if (obtainStyledAttributes != null) {
            int integer = obtainStyledAttributes.getInteger(R$styleable.TopScrollNoticeView_notice_more_visibility, 0);
            boolean z11 = obtainStyledAttributes.getBoolean(R$styleable.TopScrollNoticeView_notice_text_style_bold, true);
            obtainStyledAttributes.getInteger(R$styleable.TopScrollNoticeView_notice_left_visibility, 0);
            int integer2 = obtainStyledAttributes.getInteger(R$styleable.TopScrollNoticeView_notice_cover_visibility, 0);
            int color = obtainStyledAttributes.getColor(R$styleable.TopScrollNoticeView_notice_first_text_color, ContextCompat.getColor(getContext(), R$color.account_box_customer_question));
            int integer3 = obtainStyledAttributes.getInteger(R$styleable.TopScrollNoticeView_notice_item_gravity, 0);
            if (integer == 0) {
                this.f72098d.setVisibility(0);
            } else if (integer == 1) {
                this.f72098d.setVisibility(4);
            } else if (integer != 2) {
                this.f72098d.setVisibility(0);
            } else {
                this.f72098d.setVisibility(8);
            }
            this.f72096b.setTextBold(z11);
            this.f72097c.setTextBold(z11);
            if (integer2 == 0) {
                this.f72099e.setVisibility(0);
            } else if (integer2 == 1) {
                this.f72099e.setVisibility(4);
            } else if (integer2 != 2) {
                this.f72099e.setVisibility(0);
            } else {
                this.f72099e.setVisibility(8);
            }
            this.f72096b.setFirstTextColor(color);
            this.f72097c.setFirstTextColor(color);
            if (integer3 == 0) {
                this.f72096b.setGravity(19);
                this.f72097c.setGravity(19);
            } else if (integer3 == 1) {
                this.f72096b.setGravity(21);
                this.f72097c.setGravity(21);
            }
            obtainStyledAttributes.recycle();
        }
        setOnClickListener(this);
        this.f72096b.setCallback(new a());
        this.f72098d.setOnClickListener(this);
        this.f72098d.setOnTouchListener(new c(this));
    }

    public final void e(Context context) {
        FrameLayout.inflate(context, R$layout.top_scroll_notice_view2, this);
        this.f72096b = (TopScrollNoticeItemView2) findViewById(R$id.top_scroll_item_view1);
        this.f72097c = (TopScrollNoticeItemView2) findViewById(R$id.top_scroll_item_view2);
        this.f72098d = (ImageView) findViewById(R$id.index_notice_more);
        this.f72099e = findViewById(R$id.cover_view);
    }

    public void g(List<TopScrollData> list, boolean z11) {
        d.b("TopScrollView-->setDatas-->" + list + " reset:" + z11);
        this.f72105k = list;
        if (z11) {
            this.f72106l = false;
            this.f72096b.h();
            this.f72097c.h();
        }
        if (!this.f72106l) {
            this.f72106l = true;
            this.f72104j = 0;
            this.f72103i = true;
            j();
        }
    }

    public void h() {
        this.f72107m = true;
        Handler handler = this.f72100f;
        if (handler != null) {
            handler.removeMessages(1);
            this.f72100f.sendEmptyMessageDelayed(1, 5000);
        }
    }

    public void handleMessage(Message message) {
        if (message.what == 1) {
            int i11 = this.f72104j + 1;
            this.f72104j = i11;
            List<TopScrollData> list = this.f72105k;
            if (list == null || i11 >= list.size()) {
                this.f72104j = 0;
            }
            j();
            if (this.f72107m) {
                this.f72100f.sendEmptyMessageDelayed(1, 5000);
            }
        }
    }

    public void i() {
        this.f72107m = false;
        Handler handler = this.f72100f;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
    }

    public final void j() {
        TopScrollData b11 = b(this.f72104j);
        TopScrollView.b bVar = this.f72101g;
        if (bVar != null) {
            bVar.a(b11);
        }
        if (this.f72103i) {
            this.f72096b.i(b11);
            this.f72097c.c();
        } else {
            this.f72097c.i(b11);
            this.f72096b.c();
        }
        this.f72103i = !this.f72103i;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        TopScrollView.b bVar;
        if (view.getId() != R$id.index_notice_more || (bVar = this.f72101g) == null) {
            if (this.f72101g != null) {
                TopScrollData b11 = b(this.f72104j);
                if (b11 == null) {
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    return;
                }
                this.f72101g.c(b11);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        bVar.b();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        this.f72102h = getHeight();
    }

    public void setCallback(TopScrollView.b bVar) {
        this.f72101g = bVar;
    }

    public void setDatas(List<TopScrollData> list) {
        g(list, false);
    }

    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        TopScrollNoticeItemView2 topScrollNoticeItemView2 = this.f72096b;
        if (topScrollNoticeItemView2 != null) {
            topScrollNoticeItemView2.setEllipsize(truncateAt);
        }
        TopScrollNoticeItemView2 topScrollNoticeItemView22 = this.f72097c;
        if (topScrollNoticeItemView22 != null) {
            topScrollNoticeItemView22.setEllipsize(truncateAt);
        }
    }

    public void setLeftIcon(TopScrollData topScrollData) {
        TopScrollNoticeItemView2 topScrollNoticeItemView2 = this.f72096b;
        if (topScrollNoticeItemView2 != null) {
            topScrollNoticeItemView2.setText(topScrollData);
        }
    }

    public TopScrollNoticeView2(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f72103i = true;
        d(context, attributeSet);
    }
}
