package net.lucode.hackware.magicindicator.buildins.commonnavigator.titles;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import q10.a;

public class SimplePagerTitleView extends TextView implements a {

    /* renamed from: b  reason: collision with root package name */
    public int f58525b;

    /* renamed from: c  reason: collision with root package name */
    public int f58526c;

    public SimplePagerTitleView(Context context) {
        super(context, (AttributeSet) null);
        a(context);
    }

    public final void a(Context context) {
        setGravity(17);
        int a11 = UIUtil.a(context, 10.0d);
        setPadding(a11, 0, a11, 0);
        setSingleLine();
        setEllipsize(TextUtils.TruncateAt.END);
    }

    public int getContentBottom() {
        Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
        return (int) (((float) (getHeight() / 2)) + ((fontMetrics.bottom - fontMetrics.top) / 2.0f));
    }

    public int getContentLeft() {
        Rect rect = new Rect();
        getPaint().getTextBounds(getText().toString(), 0, getText().length(), rect);
        return (getLeft() + (getWidth() / 2)) - (rect.width() / 2);
    }

    public int getContentRight() {
        Rect rect = new Rect();
        getPaint().getTextBounds(getText().toString(), 0, getText().length(), rect);
        return getLeft() + (getWidth() / 2) + (rect.width() / 2);
    }

    public int getContentTop() {
        Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
        return (int) (((float) (getHeight() / 2)) - ((fontMetrics.bottom - fontMetrics.top) / 2.0f));
    }

    public int getNormalColor() {
        return this.f58526c;
    }

    public int getSelectedColor() {
        return this.f58525b;
    }

    public void onDeselected(int i11, int i12) {
        setTextColor(this.f58526c);
    }

    public void onEnter(int i11, int i12, float f11, boolean z11) {
    }

    public void onLeave(int i11, int i12, float f11, boolean z11) {
    }

    public void onSelected(int i11, int i12) {
        setTextColor(this.f58525b);
    }

    public void setNormalColor(int i11) {
        this.f58526c = i11;
    }

    public void setSelectedColor(int i11) {
        this.f58525b = i11;
    }
}
