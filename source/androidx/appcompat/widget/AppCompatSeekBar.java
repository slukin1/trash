package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.R$attr;

public class AppCompatSeekBar extends SeekBar {

    /* renamed from: b  reason: collision with root package name */
    public final l f4362b;

    public AppCompatSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.seekBarStyle);
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.f4362b.h();
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.f4362b.i();
    }

    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f4362b.g(canvas);
    }

    public AppCompatSeekBar(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        z.a(this, getContext());
        l lVar = new l(this);
        this.f4362b = lVar;
        lVar.c(attributeSet, i11);
    }
}
