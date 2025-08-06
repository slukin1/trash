package com.huobi.asset.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.hbg.module.asset.R$color;
import com.hbg.module.asset.R$dimen;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.view.TitleLayout;
import hh.f;
import i6.n;
import java.util.ArrayList;

public class AssetTabLayout extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public b f42475b;

    /* renamed from: c  reason: collision with root package name */
    public TitleLayout f42476c;

    /* renamed from: d  reason: collision with root package name */
    public HorizontalScrollView f42477d;

    public class a implements TitleLayout.OnTitleListener {
        public a() {
        }

        public void onTitleChange(int i11) {
            if (AssetTabLayout.this.f42475b != null) {
                AssetTabLayout.this.f42475b.onTabChanged(i11);
            }
        }

        public void onTitleStatueChange(int i11, boolean z11) {
        }
    }

    public interface b {
        void onTabChanged(int i11);
    }

    public AssetTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context);
    }

    public void b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(getResources().getString(R$string.n_balance_overview_account));
        for (f.a<?> c11 : f.h().f()) {
            arrayList.add(c11.c(getContext()));
        }
        this.f42476c.setTitles(arrayList, 0);
    }

    public final void c(Context context) {
        LayoutInflater.from(context).inflate(R$layout.layout_asset_tab, this);
        this.f42477d = (HorizontalScrollView) findViewById(R$id.title_horizontal_scroll);
        TitleLayout titleLayout = (TitleLayout) findViewById(R$id.title_layout);
        this.f42476c = titleLayout;
        Resources resources = getResources();
        int i11 = R$dimen.dimen_18;
        titleLayout.setSelectedTextSize((float) resources.getDimensionPixelSize(i11));
        this.f42476c.setNormalTextSize((float) getResources().getDimensionPixelSize(i11));
        this.f42476c.setNormalColor(ContextCompat.getColor(getContext(), R$color.baseColorSecondaryText));
        this.f42476c.setSelectedColor(ContextCompat.getColor(getContext(), R$color.baseColorPrimaryText));
        this.f42476c.setItemSpace(getResources().getDimensionPixelOffset(R$dimen.dimen_0));
        TitleLayout titleLayout2 = this.f42476c;
        Resources resources2 = getResources();
        int i12 = R$dimen.dimen_10;
        titleLayout2.setItemPaddingLeft(resources2.getDimensionPixelOffset(i12));
        this.f42476c.setItemPaddingRight(getResources().getDimensionPixelOffset(i12));
        this.f42476c.setTitleListener(new a());
    }

    public void d() {
        int[] iArr = new int[2];
        TextView currentTextView = this.f42476c.getCurrentTextView();
        currentTextView.getLocationOnScreen(iArr);
        int g11 = n.g(getContext());
        int width = currentTextView.getWidth();
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R$dimen.dimen_15);
        if (iArr[0] + width > g11) {
            this.f42477d.smoothScrollBy((iArr[0] - g11) + width + dimensionPixelOffset, 0);
        } else if (iArr[0] < 0) {
            this.f42477d.smoothScrollBy(iArr[0] - dimensionPixelOffset, 0);
        }
    }

    public TitleLayout getTitleLayout() {
        return this.f42476c;
    }

    public void setOnTabChangedListener(b bVar) {
        this.f42475b = bVar;
    }

    public AssetTabLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        c(context);
    }
}
