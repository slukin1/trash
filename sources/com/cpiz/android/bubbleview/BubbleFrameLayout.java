package com.cpiz.android.bubbleview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.cpiz.android.bubbleview.BubbleStyle;
import m4.a;

public class BubbleFrameLayout extends FrameLayout implements BubbleStyle, a {

    /* renamed from: b  reason: collision with root package name */
    public final BubbleImpl f64721b;

    public BubbleFrameLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public void a(int i11, int i12, int i13, int i14) {
        super.setPadding(i11, i12, i13, i14);
    }

    public final void b(Context context, AttributeSet attributeSet) {
        this.f64721b.v(this, context, attributeSet);
    }

    public BubbleStyle.ArrowDirection getArrowDirection() {
        return this.f64721b.c();
    }

    public float getArrowHeight() {
        return this.f64721b.d();
    }

    public float getArrowPosDelta() {
        return this.f64721b.e();
    }

    public BubbleStyle.ArrowPosPolicy getArrowPosPolicy() {
        return this.f64721b.f();
    }

    public View getArrowTo() {
        return this.f64721b.g();
    }

    public float getArrowWidth() {
        return this.f64721b.h();
    }

    public int getBorderColor() {
        return this.f64721b.j();
    }

    public float getBorderWidth() {
        return this.f64721b.k();
    }

    public float getCornerBottomLeftRadius() {
        return this.f64721b.l();
    }

    public float getCornerBottomRightRadius() {
        return this.f64721b.m();
    }

    public float getCornerTopLeftRadius() {
        return this.f64721b.n();
    }

    public float getCornerTopRightRadius() {
        return this.f64721b.o();
    }

    public int getFillColor() {
        return this.f64721b.p();
    }

    public float getFillPadding() {
        return this.f64721b.q();
    }

    public int getPaddingBottom() {
        return this.f64721b.r();
    }

    public int getPaddingLeft() {
        return this.f64721b.s();
    }

    public int getPaddingRight() {
        return this.f64721b.t();
    }

    public int getPaddingTop() {
        return this.f64721b.u();
    }

    public int getSuperPaddingBottom() {
        return super.getPaddingBottom();
    }

    public int getSuperPaddingLeft() {
        return super.getPaddingLeft();
    }

    public int getSuperPaddingRight() {
        return super.getPaddingRight();
    }

    public int getSuperPaddingTop() {
        return super.getPaddingTop();
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        this.f64721b.I(i13 - i11, i14 - i12, true);
    }

    public void setArrowCornerRadius(int i11) {
        this.f64721b.x(i11);
    }

    public void setArrowDirection(BubbleStyle.ArrowDirection arrowDirection) {
        this.f64721b.setArrowDirection(arrowDirection);
    }

    public void setArrowHeight(float f11) {
        this.f64721b.y(f11);
    }

    public void setArrowPosDelta(float f11) {
        this.f64721b.setArrowPosDelta(f11);
    }

    public void setArrowPosPolicy(BubbleStyle.ArrowPosPolicy arrowPosPolicy) {
        this.f64721b.setArrowPosPolicy(arrowPosPolicy);
    }

    public void setArrowTo(int i11) {
        this.f64721b.z(i11);
    }

    public void setArrowWidth(float f11) {
        this.f64721b.B(f11);
    }

    public void setBorderColor(int i11) {
        this.f64721b.C(i11);
    }

    public void setBorderWidth(float f11) {
        this.f64721b.setBorderWidth(f11);
    }

    public void setCornerRadius(float f11) {
        this.f64721b.D(f11);
    }

    public void setFillColor(int i11) {
        this.f64721b.F(i11);
    }

    public void setFillPadding(float f11) {
        this.f64721b.G(f11);
    }

    public void setPadding(int i11, int i12, int i13, int i14) {
        BubbleImpl bubbleImpl = this.f64721b;
        if (bubbleImpl == null) {
            Log.w("BubbleView", "mBubbleImpl == null on old Android platform");
            a(i11, i12, i13, i14);
            return;
        }
        bubbleImpl.H(i11, i12, i13, i14);
    }

    public BubbleFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setArrowTo(View view) {
        this.f64721b.setArrowTo(view);
    }

    public BubbleFrameLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f64721b = new BubbleImpl();
        b(context, attributeSet);
    }
}
