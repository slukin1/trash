package com.huobi.view;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.hbg.lib.common.utils.PixelUtils;
import com.huobi.view.rollviewpager.hintview.AnimHintView;
import com.huobi.view.rollviewpager.hintview.HintView;

public class VerticalHintPagerView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private static final float MARGIN_BOTTOM = 5.0f;
    public PagerAdapter mAdapter;
    private int mCurrentPosition;
    public View mHintView;
    public ViewPager mViewPager;

    public interface IVerticalHintView extends HintView {
        void initView(int i11, int i12, int i13);
    }

    public class JPagerObserver extends DataSetObserver {
        private JPagerObserver() {
        }

        public void onChanged() {
            VerticalHintPagerView.this.onDataSetChanged();
        }

        public void onInvalidated() {
            VerticalHintPagerView.this.onDataSetChanged();
        }
    }

    public VerticalHintPagerView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void initHint(HintView hintView) {
        View view = this.mHintView;
        if (view != null) {
            removeView(view);
        }
        if (hintView == null) {
            this.mHintView = null;
            return;
        }
        this.mHintView = (View) hintView;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, PixelUtils.a(MARGIN_BOTTOM));
        this.mHintView.setLayoutParams(layoutParams);
        addView(this.mHintView);
        onDataSetChanged();
    }

    private void initView() {
        ViewPager viewPager = this.mViewPager;
        if (viewPager != null) {
            removeView(viewPager);
        }
        setOrientation(1);
        this.mViewPager = new ViewPager(getContext());
        this.mViewPager.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        addView(this.mViewPager);
        initHint(new AnimHintView(getContext()));
    }

    private void setCurrent(int i11) {
        this.mCurrentPosition = i11;
        View view = this.mHintView;
        if (view != null) {
            ((HintView) view).setCurrent(i11);
        }
    }

    public ViewPager getViewPager() {
        return this.mViewPager;
    }

    public void onDataSetChanged() {
        View view = this.mHintView;
        if (view != null) {
            IVerticalHintView iVerticalHintView = (IVerticalHintView) view;
            PagerAdapter pagerAdapter = this.mAdapter;
            iVerticalHintView.initView(pagerAdapter == null ? 0 : pagerAdapter.getCount(), 1, this.mCurrentPosition);
        }
        setCurrent(this.mCurrentPosition);
    }

    public void onPageScrollStateChanged(int i11) {
    }

    public void onPageScrolled(int i11, float f11, int i12) {
    }

    public void onPageSelected(int i11) {
        setCurrent(i11);
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        this.mViewPager.setAdapter(pagerAdapter);
        this.mViewPager.addOnPageChangeListener(this);
        this.mAdapter = pagerAdapter;
        onDataSetChanged();
        pagerAdapter.registerDataSetObserver(new JPagerObserver());
    }

    public void setHintView(IVerticalHintView iVerticalHintView) {
        initHint(iVerticalHintView);
    }

    public VerticalHintPagerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VerticalHintPagerView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        initView();
    }
}
