package com.huobi.view.title;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.hbg.lib.widgets.R$color;
import com.hbg.lib.widgets.R$dimen;
import com.hbg.lib.widgets.R$id;
import com.hbg.lib.widgets.R$layout;
import com.huobi.view.TitleLayout;
import i6.n;
import java.util.List;

public class HbTabTitleBar extends HbBaseTitleBar {
    /* access modifiers changed from: private */
    public OnTabChangedListener onTabChangedListener;
    private HorizontalScrollView scrollView;
    private View shadow;
    private View tabContent;
    private int tabContentWidth;
    private TitleLayout titleLayout;

    public interface OnTabChangedListener {
        void onTabChanged(int i11);
    }

    public HbTabTitleBar(Context context) {
        super(context);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0() {
        int width = this.tabContent.getWidth();
        this.tabContentWidth = width;
        this.titleLayout.setMinimumWidth(width);
    }

    public View getTitleContent() {
        View inflate = View.inflate(this.context, R$layout.layout_tab_bar, (ViewGroup) null);
        this.tabContent = inflate;
        return inflate;
    }

    public TitleLayout getTitleLayout() {
        return this.titleLayout;
    }

    public void init(Context context, AttributeSet attributeSet, int i11, int i12) {
        super.init(context, attributeSet, i11, i12);
        this.scrollView = (HorizontalScrollView) findViewById(R$id.title_horizontal_scroll);
        this.shadow = findViewById(R$id.shadow);
        TitleLayout titleLayout2 = (TitleLayout) findViewById(R$id.tb_title_layout);
        this.titleLayout = titleLayout2;
        Resources resources = getResources();
        int i13 = R$dimen.dimen_18;
        titleLayout2.setSelectedTextSize((float) resources.getDimensionPixelSize(i13));
        this.titleLayout.setNormalTextSize((float) getResources().getDimensionPixelSize(i13));
        this.titleLayout.setNormalColor(ContextCompat.getColor(getContext(), R$color.baseColorSecondaryText));
        this.titleLayout.setSelectedColor(ContextCompat.getColor(getContext(), R$color.baseColorPrimaryText));
        this.titleLayout.setItemSpace(getResources().getDimensionPixelOffset(R$dimen.dimen_5));
        TitleLayout titleLayout3 = this.titleLayout;
        Resources resources2 = getResources();
        int i14 = R$dimen.dimen_10;
        titleLayout3.setItemPaddingLeft(resources2.getDimensionPixelOffset(i14));
        this.titleLayout.setItemPaddingRight(getResources().getDimensionPixelOffset(i14));
        this.tabContent.post(new c(this));
        this.titleLayout.setGravity(17);
        this.titleLayout.setTitleListener(new TitleLayout.OnTitleListener() {
            public void onTitleChange(int i11) {
                if (HbTabTitleBar.this.onTabChangedListener != null) {
                    HbTabTitleBar.this.onTabChangedListener.onTabChanged(i11);
                }
            }

            public void onTitleStatueChange(int i11, boolean z11) {
            }
        });
    }

    public void scrollToFitPos() {
        int[] iArr = new int[2];
        TextView currentTextView = this.titleLayout.getCurrentTextView();
        currentTextView.getLocationOnScreen(iArr);
        int g11 = n.g(getContext());
        int width = currentTextView.getWidth();
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R$dimen.dimen_15);
        if (iArr[0] + width > g11) {
            this.scrollView.smoothScrollBy((iArr[0] - g11) + width + dimensionPixelOffset, 0);
        } else if (iArr[0] < 0) {
            this.scrollView.smoothScrollBy(iArr[0] - dimensionPixelOffset, 0);
        }
    }

    public void setOnTabChangedListener(OnTabChangedListener onTabChangedListener2) {
        this.onTabChangedListener = onTabChangedListener2;
    }

    public void setTitles(List<String> list) {
        this.titleLayout.setTitles((List<?>) list, 0, 17);
    }

    public HbTabTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setTitles(int i11, List<String> list) {
        this.titleLayout.setTitles((List<?>) list, i11, 17);
    }

    public HbTabTitleBar(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }

    public HbTabTitleBar(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
    }
}
