package com.huobi.tradenew.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageButton;
import com.huobi.R$styleable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CircleClickImageButton extends AppCompatImageButton implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public Handler f83056b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f83057c;

    /* renamed from: d  reason: collision with root package name */
    public b f83058d;

    /* renamed from: e  reason: collision with root package name */
    public ScheduledExecutorService f83059e;

    /* renamed from: f  reason: collision with root package name */
    public int f83060f;

    public class a extends Handler {
        public a() {
        }

        public void handleMessage(Message message) {
            if (CircleClickImageButton.this.f83058d != null && CircleClickImageButton.this.getId() == message.what) {
                CircleClickImageButton.this.f83058d.a(CircleClickImageButton.this.f83057c);
            }
        }
    }

    public interface b {
        void a(boolean z11);
    }

    public CircleClickImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(int i11) {
        Message obtainMessage = this.f83056b.obtainMessage();
        obtainMessage.what = i11;
        this.f83056b.sendMessage(obtainMessage);
    }

    public final void e(int i11) {
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.f83059e = newSingleThreadScheduledExecutor;
        newSingleThreadScheduledExecutor.scheduleAtFixedRate(new a(this, i11), 0, 250, TimeUnit.MILLISECONDS);
    }

    public final void f() {
        ScheduledExecutorService scheduledExecutorService = this.f83059e;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
            this.f83059e = null;
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        float width = ((float) view.getWidth()) / 2.0f;
        float height = ((float) view.getHeight()) / 2.0f;
        float x11 = motionEvent.getX();
        float y11 = motionEvent.getY();
        if (action == 0) {
            this.f83057c = true;
            e(view.getId());
        } else if (action == 1) {
            f();
        } else if (action == 2) {
            float f11 = width - x11;
            float f12 = height - y11;
            if (Math.sqrt((double) Math.abs((f11 * f11) + (f12 * f12))) <= ((double) this.f83060f)) {
                this.f83057c = true;
            } else {
                this.f83057c = false;
            }
        }
        return true;
    }

    public void setOnCircleClickListener(b bVar) {
        this.f83058d = bVar;
    }

    public CircleClickImageButton(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f83056b = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CircleClickImageButton);
        this.f83060f = obtainStyledAttributes.getDimensionPixelSize(0, 60);
        obtainStyledAttributes.recycle();
        setOnTouchListener(this);
    }
}
