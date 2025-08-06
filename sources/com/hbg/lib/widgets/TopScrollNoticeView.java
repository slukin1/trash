package com.hbg.lib.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.widgets.TopScrollItemView;
import com.hbg.lib.widgets.TopScrollView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.d;
import i6.t;
import java.util.List;

public class TopScrollNoticeView extends FrameLayout implements View.OnClickListener, t.a {

    /* renamed from: b  reason: collision with root package name */
    public TopScrollNoticeItemView f71649b;

    /* renamed from: c  reason: collision with root package name */
    public TopScrollNoticeItemView f71650c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f71651d;

    /* renamed from: e  reason: collision with root package name */
    public View f71652e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f71653f;

    /* renamed from: g  reason: collision with root package name */
    public TopScrollView.b f71654g;

    /* renamed from: h  reason: collision with root package name */
    public int f71655h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f71656i;

    /* renamed from: j  reason: collision with root package name */
    public int f71657j;

    /* renamed from: k  reason: collision with root package name */
    public List<TopScrollData> f71658k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f71659l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f71660m;

    public class a implements TopScrollItemView.a {
        public a() {
        }

        public void a(TopScrollData topScrollData) {
            TopScrollNoticeView.this.setLeftIcon(topScrollData);
        }
    }

    public TopScrollNoticeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final TopScrollData a(int i11) {
        List<TopScrollData> list = this.f71658k;
        if (list == null || list.isEmpty() || i11 >= this.f71658k.size()) {
            return null;
        }
        return this.f71658k.get(i11);
    }

    public void b() {
        ViewUtil.m(this.f71652e, false);
    }

    public final void c(Context context, AttributeSet attributeSet) {
        this.f71653f = new t(this);
        d(context);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.TopScrollNoticeView);
        if (obtainStyledAttributes != null) {
            int integer = obtainStyledAttributes.getInteger(R$styleable.TopScrollNoticeView_notice_more_visibility, 0);
            boolean z11 = obtainStyledAttributes.getBoolean(R$styleable.TopScrollNoticeView_notice_text_style_bold, true);
            obtainStyledAttributes.getInteger(R$styleable.TopScrollNoticeView_notice_left_visibility, 0);
            int integer2 = obtainStyledAttributes.getInteger(R$styleable.TopScrollNoticeView_notice_cover_visibility, 0);
            int color = obtainStyledAttributes.getColor(R$styleable.TopScrollNoticeView_notice_first_text_color, ContextCompat.getColor(getContext(), R$color.baseColorPrimaryText));
            int integer3 = obtainStyledAttributes.getInteger(R$styleable.TopScrollNoticeView_notice_item_gravity, 0);
            if (integer == 0) {
                this.f71651d.setVisibility(0);
            } else if (integer == 1) {
                this.f71651d.setVisibility(4);
            } else if (integer != 2) {
                this.f71651d.setVisibility(0);
            } else {
                this.f71651d.setVisibility(8);
            }
            this.f71649b.setTextBold(z11);
            this.f71650c.setTextBold(z11);
            if (integer2 == 0) {
                this.f71652e.setVisibility(0);
            } else if (integer2 == 1) {
                this.f71652e.setVisibility(4);
            } else if (integer2 != 2) {
                this.f71652e.setVisibility(0);
            } else {
                this.f71652e.setVisibility(8);
            }
            this.f71649b.setFirstTextColor(color);
            this.f71650c.setFirstTextColor(color);
            if (integer3 == 0) {
                this.f71649b.setGravity(19);
                this.f71650c.setGravity(19);
            } else if (integer3 == 1) {
                this.f71649b.setGravity(21);
                this.f71650c.setGravity(21);
            }
            obtainStyledAttributes.recycle();
        }
        setOnClickListener(this);
        this.f71649b.setCallback(new a());
        this.f71651d.setOnClickListener(this);
    }

    public final void d(Context context) {
        FrameLayout.inflate(context, R$layout.top_scroll_notice_view, this);
        this.f71649b = (TopScrollNoticeItemView) findViewById(R$id.top_scroll_item_view1);
        this.f71650c = (TopScrollNoticeItemView) findViewById(R$id.top_scroll_item_view2);
        this.f71651d = (ImageView) findViewById(R$id.index_notice_more);
        this.f71652e = findViewById(R$id.cover_view);
    }

    public boolean e() {
        return this.f71660m;
    }

    public void f(List<TopScrollData> list, boolean z11) {
        d.b("TopScrollView-->setDatas-->" + list + " reset:" + z11);
        this.f71658k = list;
        if (z11) {
            this.f71659l = false;
            this.f71649b.i();
            this.f71650c.i();
        }
        if (!this.f71659l) {
            this.f71659l = true;
            this.f71657j = 0;
            this.f71656i = true;
            i();
        }
    }

    public void g() {
        this.f71660m = true;
        Handler handler = this.f71653f;
        if (handler != null) {
            handler.removeMessages(1);
            this.f71653f.sendEmptyMessageDelayed(1, 5000);
        }
    }

    public void h() {
        this.f71660m = false;
        Handler handler = this.f71653f;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
    }

    public void handleMessage(Message message) {
        if (message.what == 1) {
            int i11 = this.f71657j + 1;
            this.f71657j = i11;
            List<TopScrollData> list = this.f71658k;
            if (list == null || i11 >= list.size()) {
                this.f71657j = 0;
            }
            i();
            if (this.f71660m) {
                this.f71653f.sendEmptyMessageDelayed(1, 5000);
            }
        }
    }

    public final void i() {
        TopScrollData a11 = a(this.f71657j);
        TopScrollView.b bVar = this.f71654g;
        if (bVar != null) {
            bVar.a(a11);
        }
        if (this.f71656i) {
            this.f71649b.j(a11);
            this.f71650c.c();
            this.f71650c.e();
        } else {
            this.f71650c.j(a11);
            this.f71649b.c();
            this.f71649b.e();
        }
        this.f71656i = !this.f71656i;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        TopScrollView.b bVar;
        if (view.getId() != R$id.index_notice_more || (bVar = this.f71654g) == null) {
            if (this.f71654g != null) {
                TopScrollData a11 = a(this.f71657j);
                if (a11 == null) {
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    return;
                }
                this.f71654g.c(a11);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        bVar.b();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        this.f71655h = getHeight();
    }

    public void setCallback(TopScrollView.b bVar) {
        this.f71654g = bVar;
    }

    public void setDatas(List<TopScrollData> list) {
        f(list, false);
    }

    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        TopScrollNoticeItemView topScrollNoticeItemView = this.f71649b;
        if (topScrollNoticeItemView != null) {
            topScrollNoticeItemView.setEllipsize(truncateAt);
        }
        TopScrollNoticeItemView topScrollNoticeItemView2 = this.f71650c;
        if (topScrollNoticeItemView2 != null) {
            topScrollNoticeItemView2.setEllipsize(truncateAt);
        }
    }

    public void setFirstTextColor(int i11) {
        this.f71649b.setFirstTextColor(i11);
        this.f71650c.setFirstTextColor(i11);
    }

    public void setLeftIcon(TopScrollData topScrollData) {
        TopScrollNoticeItemView topScrollNoticeItemView = this.f71649b;
        if (topScrollNoticeItemView != null) {
            topScrollNoticeItemView.setText(topScrollData);
        }
    }

    public TopScrollNoticeView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f71656i = true;
        c(context, attributeSet);
    }
}
