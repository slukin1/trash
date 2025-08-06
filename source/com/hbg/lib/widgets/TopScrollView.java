package com.hbg.lib.widgets;

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
import com.hbg.lib.widgets.TopScrollItemView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.d;
import i6.t;
import java.util.List;

public class TopScrollView extends FrameLayout implements View.OnClickListener, t.a {

    /* renamed from: b  reason: collision with root package name */
    public TopScrollItemView f71685b;

    /* renamed from: c  reason: collision with root package name */
    public TopScrollItemView f71686c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f71687d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f71688e;

    /* renamed from: f  reason: collision with root package name */
    public View f71689f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f71690g;

    /* renamed from: h  reason: collision with root package name */
    public b f71691h;

    /* renamed from: i  reason: collision with root package name */
    public int f71692i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f71693j;

    /* renamed from: k  reason: collision with root package name */
    public int f71694k;

    /* renamed from: l  reason: collision with root package name */
    public List<TopScrollData> f71695l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f71696m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f71697n;

    public class a implements TopScrollItemView.a {
        public a() {
        }

        public void a(TopScrollData topScrollData) {
            TopScrollView.this.setLeftIcon(topScrollData.i());
        }
    }

    public interface b {
        void a(TopScrollData topScrollData);

        void b();

        void c(TopScrollData topScrollData);
    }

    public TopScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean e(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 1) {
            return false;
        }
        this.f71687d.setImageResource(R$drawable.home_notice_more);
        view.performClick();
        return true;
    }

    public final TopScrollData b(int i11) {
        List<TopScrollData> list = this.f71695l;
        if (list == null || list.isEmpty() || i11 >= this.f71695l.size()) {
            return null;
        }
        return this.f71695l.get(i11);
    }

    public final void c(Context context, AttributeSet attributeSet) {
        this.f71690g = new t(this);
        d(context);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.TopScrollView);
        if (obtainStyledAttributes != null) {
            int integer = obtainStyledAttributes.getInteger(R$styleable.TopScrollView_more_visibility, 0);
            boolean z11 = obtainStyledAttributes.getBoolean(R$styleable.TopScrollView_text_style_bold, true);
            int integer2 = obtainStyledAttributes.getInteger(R$styleable.TopScrollView_left_visibility, 0);
            int integer3 = obtainStyledAttributes.getInteger(R$styleable.TopScrollView_cover_visibility, 0);
            int color = obtainStyledAttributes.getColor(R$styleable.TopScrollView_first_text_color, ContextCompat.getColor(getContext(), R$color.baseColorPrimaryText));
            int integer4 = obtainStyledAttributes.getInteger(R$styleable.TopScrollView_item_gravity, 0);
            if (integer == 0) {
                this.f71687d.setVisibility(0);
            } else if (integer == 1) {
                this.f71687d.setVisibility(4);
            } else if (integer != 2) {
                this.f71687d.setVisibility(0);
            } else {
                this.f71687d.setVisibility(8);
            }
            this.f71685b.setTextBold(z11);
            this.f71686c.setTextBold(z11);
            if (integer2 == 0) {
                this.f71688e.setVisibility(0);
            } else if (integer2 == 1) {
                this.f71688e.setVisibility(4);
            } else if (integer2 != 2) {
                this.f71688e.setVisibility(0);
            } else {
                this.f71688e.setVisibility(8);
            }
            if (integer3 == 0) {
                this.f71689f.setVisibility(0);
            } else if (integer3 == 1) {
                this.f71689f.setVisibility(4);
            } else if (integer3 != 2) {
                this.f71689f.setVisibility(0);
            } else {
                this.f71689f.setVisibility(8);
            }
            this.f71685b.setFirstTextColor(color);
            this.f71686c.setFirstTextColor(color);
            if (integer4 == 0) {
                this.f71685b.setGravity(19);
                this.f71686c.setGravity(19);
            } else if (integer4 == 1) {
                this.f71685b.setGravity(21);
                this.f71686c.setGravity(21);
            }
            obtainStyledAttributes.recycle();
        }
        setOnClickListener(this);
        this.f71685b.setCallback(new a());
        this.f71687d.setOnClickListener(this);
        this.f71687d.setOnTouchListener(new u1(this));
    }

    public final void d(Context context) {
        FrameLayout.inflate(context, R$layout.top_scroll_view, this);
        this.f71685b = (TopScrollItemView) findViewById(R$id.top_scroll_item_view1);
        this.f71686c = (TopScrollItemView) findViewById(R$id.top_scroll_item_view2);
        this.f71687d = (ImageView) findViewById(R$id.index_notice_more);
        this.f71688e = (ImageView) findViewById(R$id.left_icon_iv);
        this.f71689f = findViewById(R$id.cover_view);
    }

    public void f(List<TopScrollData> list, boolean z11) {
        d.b("TopScrollView-->setDatas-->" + list + " reset:" + z11);
        j(list, z11, false);
    }

    public void g() {
        this.f71697n = true;
        Handler handler = this.f71690g;
        if (handler != null) {
            handler.removeMessages(1);
            this.f71690g.sendEmptyMessageDelayed(1, 5000);
        }
    }

    public void h() {
        this.f71697n = false;
        Handler handler = this.f71690g;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
    }

    public void handleMessage(Message message) {
        List<TopScrollData> list;
        if (message.what == 1) {
            int i11 = this.f71694k + 1;
            this.f71694k = i11;
            List<TopScrollData> list2 = this.f71695l;
            if (list2 == null || i11 >= list2.size()) {
                this.f71694k = 0;
            }
            i();
            if (this.f71697n && (list = this.f71695l) != null && list.size() > 1) {
                this.f71690g.sendEmptyMessageDelayed(1, 5000);
            }
        }
    }

    public final void i() {
        TopScrollData b11 = b(this.f71694k);
        b bVar = this.f71691h;
        if (bVar != null) {
            bVar.a(b11);
        }
        List<TopScrollData> list = this.f71695l;
        if (list == null || list.size() <= 1) {
            this.f71685b.h();
            this.f71686c.h();
            this.f71685b.setText(b11);
            return;
        }
        if (this.f71693j) {
            this.f71685b.c(b11);
            this.f71686c.i();
        } else {
            this.f71686c.c(b11);
            this.f71685b.i();
        }
        this.f71693j = !this.f71693j;
    }

    public void j(List<TopScrollData> list, boolean z11, boolean z12) {
        List<TopScrollData> list2;
        if (!(z11 || (list2 = this.f71695l) == null || list == null || list2.size() == list.size())) {
            z11 = true;
            z12 = true;
        }
        this.f71695l = list;
        if (z11) {
            this.f71696m = false;
            this.f71685b.h();
            this.f71686c.h();
        }
        if (!this.f71696m) {
            this.f71696m = true;
            this.f71694k = 0;
            this.f71693j = true;
            i();
        } else {
            TopScrollData b11 = b(this.f71694k);
            List<TopScrollData> list3 = this.f71695l;
            if (list3 == null || list3.size() <= 1) {
                this.f71685b.h();
                this.f71686c.h();
                this.f71685b.setText(b11);
            } else if (this.f71693j) {
                this.f71686c.setText(b11);
            } else {
                this.f71685b.setText(b11);
            }
        }
        if (z12) {
            g();
        }
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        b bVar;
        if (view.getId() != R$id.index_notice_more || (bVar = this.f71691h) == null) {
            if (this.f71691h != null) {
                TopScrollData b11 = b(this.f71694k);
                if (b11 == null) {
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    return;
                }
                this.f71691h.c(b11);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        bVar.b();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        this.f71692i = getHeight();
    }

    public void setCallback(b bVar) {
        this.f71691h = bVar;
    }

    public void setDatas(List<TopScrollData> list) {
        f(list, false);
    }

    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        TopScrollItemView topScrollItemView = this.f71685b;
        if (topScrollItemView != null) {
            topScrollItemView.setEllipsize(truncateAt);
        }
        TopScrollItemView topScrollItemView2 = this.f71686c;
        if (topScrollItemView2 != null) {
            topScrollItemView2.setEllipsize(truncateAt);
        }
    }

    public void setLeftIcon(int i11) {
        ImageView imageView = this.f71688e;
        if (imageView != null) {
            imageView.setImageResource(i11);
        }
    }

    public void setTextSize(int i11) {
        TopScrollItemView topScrollItemView = this.f71685b;
        if (topScrollItemView != null) {
            topScrollItemView.setTextSize(i11);
        }
        TopScrollItemView topScrollItemView2 = this.f71686c;
        if (topScrollItemView2 != null) {
            topScrollItemView2.setTextSize(i11);
        }
    }

    public TopScrollView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f71693j = true;
        c(context, attributeSet);
    }
}
