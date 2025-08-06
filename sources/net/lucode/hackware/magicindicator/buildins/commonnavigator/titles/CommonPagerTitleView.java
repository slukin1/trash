package net.lucode.hackware.magicindicator.buildins.commonnavigator.titles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class CommonPagerTitleView extends FrameLayout implements q10.a {

    /* renamed from: b  reason: collision with root package name */
    public b f58523b;

    /* renamed from: c  reason: collision with root package name */
    public a f58524c;

    public interface a {
        int getContentBottom();

        int getContentLeft();

        int getContentRight();

        int getContentTop();
    }

    public interface b {
        void onDeselected(int i11, int i12);

        void onEnter(int i11, int i12, float f11, boolean z11);

        void onLeave(int i11, int i12, float f11, boolean z11);

        void onSelected(int i11, int i12);
    }

    public CommonPagerTitleView(Context context) {
        super(context);
    }

    public void a(View view, FrameLayout.LayoutParams layoutParams) {
        removeAllViews();
        if (view != null) {
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            addView(view, layoutParams);
        }
    }

    public int getContentBottom() {
        a aVar = this.f58524c;
        if (aVar != null) {
            return aVar.getContentBottom();
        }
        return getBottom();
    }

    public int getContentLeft() {
        a aVar = this.f58524c;
        if (aVar != null) {
            return aVar.getContentLeft();
        }
        return getLeft();
    }

    public a getContentPositionDataProvider() {
        return this.f58524c;
    }

    public int getContentRight() {
        a aVar = this.f58524c;
        if (aVar != null) {
            return aVar.getContentRight();
        }
        return getRight();
    }

    public int getContentTop() {
        a aVar = this.f58524c;
        if (aVar != null) {
            return aVar.getContentTop();
        }
        return getTop();
    }

    public b getOnPagerTitleChangeListener() {
        return this.f58523b;
    }

    public void onDeselected(int i11, int i12) {
        b bVar = this.f58523b;
        if (bVar != null) {
            bVar.onDeselected(i11, i12);
        }
    }

    public void onEnter(int i11, int i12, float f11, boolean z11) {
        b bVar = this.f58523b;
        if (bVar != null) {
            bVar.onEnter(i11, i12, f11, z11);
        }
    }

    public void onLeave(int i11, int i12, float f11, boolean z11) {
        b bVar = this.f58523b;
        if (bVar != null) {
            bVar.onLeave(i11, i12, f11, z11);
        }
    }

    public void onSelected(int i11, int i12) {
        b bVar = this.f58523b;
        if (bVar != null) {
            bVar.onSelected(i11, i12);
        }
    }

    public void setContentPositionDataProvider(a aVar) {
        this.f58524c = aVar;
    }

    public void setContentView(View view) {
        a(view, (FrameLayout.LayoutParams) null);
    }

    public void setOnPagerTitleChangeListener(b bVar) {
        this.f58523b = bVar;
    }

    public void setContentView(int i11) {
        a(LayoutInflater.from(getContext()).inflate(i11, (ViewGroup) null), (FrameLayout.LayoutParams) null);
    }
}
