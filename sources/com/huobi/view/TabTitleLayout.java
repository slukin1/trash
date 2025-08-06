package com.huobi.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.ViewPager;
import com.hbg.lib.widgets.CommonTextListIndicator;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import io.a;
import java.util.List;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import pro.huobi.R;
import q10.b;
import q10.c;

public class TabTitleLayout extends ConstraintLayout {
    private OnBackClickCallback mBackCallback;
    private ViewGroup mCenterLayout;
    private CommonTextListIndicator mIndicator;
    private ImageView mIvBack;
    private EasyRecyclerView<a> mRecyclerMenu;
    /* access modifiers changed from: private */
    public OnTabChangeCallback mTabCallback;
    /* access modifiers changed from: private */
    public ViewPager mViewPager;

    public interface OnBackClickCallback {
        void onBackClick(View view);
    }

    public interface OnTabChangeCallback {
        void onTabChanged(int i11);
    }

    public TabTitleLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    private void initCallback() {
        this.mIvBack.setOnClickListener(new n1(this));
    }

    private void initTitle(ViewPager viewPager, final List<String> list) {
        ViewPager viewPager2;
        this.mViewPager = viewPager;
        if (!(list == null || list.isEmpty() || viewPager == null)) {
            CommonNavigator commonNavigator = new CommonNavigator(getContext());
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.dimen_5);
            commonNavigator.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            commonNavigator.setAdapter(new CommonNavigatorAdapter() {
                /* access modifiers changed from: private */
                @SensorsDataInstrumented
                public /* synthetic */ void lambda$getTitleView$0(int i11, View view) {
                    if (TabTitleLayout.this.mViewPager != null) {
                        TabTitleLayout.this.mViewPager.setCurrentItem(i11);
                    }
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }

                public int getCount() {
                    return list.size();
                }

                public b getIndicator(Context context) {
                    return null;
                }

                public c getTitleView(Context context, int i11) {
                    int a11;
                    int a12;
                    if (list.size() == 1) {
                        a11 = UIUtil.a(context, 16.0d);
                        a12 = UIUtil.a(context, 16.0d);
                    } else if (list.size() == 2) {
                        if (i11 == 0) {
                            a11 = UIUtil.a(context, 16.0d);
                            a12 = UIUtil.a(context, 10.0d);
                        } else {
                            a11 = UIUtil.a(context, 10.0d);
                            a12 = UIUtil.a(context, 16.0d);
                        }
                    } else if (i11 == 0) {
                        a11 = UIUtil.a(context, 16.0d);
                        a12 = UIUtil.a(context, 10.0d);
                    } else if (i11 == list.size() - 1) {
                        a11 = UIUtil.a(context, 10.0d);
                        a12 = UIUtil.a(context, 10.0d);
                    } else {
                        a11 = UIUtil.a(context, 10.0d);
                        a12 = UIUtil.a(context, 16.0d);
                    }
                    PagerScaleTitleIndicatorView pagerScaleTitleIndicatorView = new PagerScaleTitleIndicatorView(context, 16.0f, a11, 0, a12, 3, 1.125f);
                    pagerScaleTitleIndicatorView.setText((String) list.get(i11));
                    pagerScaleTitleIndicatorView.setNormalColor(ContextCompat.getColor(context, R.color.baseColorSecondaryTextNew));
                    pagerScaleTitleIndicatorView.setSelectedColor(ContextCompat.getColor(context, R.color.baseColorPrimaryText));
                    pagerScaleTitleIndicatorView.getPaint().setTypeface(ResourcesCompat.h(context, R.font.roboto_medium));
                    pagerScaleTitleIndicatorView.setOnClickListener(new p1(this, i11));
                    return pagerScaleTitleIndicatorView;
                }
            });
            this.mIndicator.setNavigator(commonNavigator);
            ViewPagerHelper.a(this.mIndicator, this.mViewPager);
        }
        if (!(this.mIndicator == null || (viewPager2 = this.mViewPager) == null)) {
            viewPager2.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                public void onPageScrollStateChanged(int i11) {
                }

                public void onPageScrolled(int i11, float f11, int i12) {
                }

                public void onPageSelected(int i11) {
                    TabTitleLayout.this.lambda$initTitle$1();
                    if (TabTitleLayout.this.mTabCallback != null) {
                        TabTitleLayout.this.mTabCallback.onTabChanged(i11);
                    }
                }
            });
        }
        post(new o1(this));
    }

    private void initView() {
        r rVar = new r((View) this);
        this.mIvBack = (ImageView) rVar.b(R.id.iv_common_back);
        this.mCenterLayout = (ViewGroup) rVar.b(R.id.clyt_common_center);
        this.mRecyclerMenu = (EasyRecyclerView) rVar.b(R.id.erv_common_action_menu);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.mRecyclerMenu.setLayoutManager(linearLayoutManager);
        this.mIndicator = (CommonTextListIndicator) rVar.b(R.id.view_common_center_indicator);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initCallback$0(View view) {
        OnBackClickCallback onBackClickCallback = this.mBackCallback;
        if (onBackClickCallback != null) {
            onBackClickCallback.onBackClick(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private void moveCenterIndicator() {
        int width = ((getWidth() / 2) - (this.mIndicator.getWidth() / 2)) - this.mCenterLayout.getLeft();
        if (width < 0) {
            width = 0;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mIndicator.getLayoutParams();
        layoutParams.setMarginStart(width);
        this.mIndicator.setLayoutParams(layoutParams);
    }

    private void moveLeftIndicator() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mIndicator.getLayoutParams();
        layoutParams.setMarginStart(0);
        this.mIndicator.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    /* renamed from: updateTitleTab */
    public void lambda$initTitle$1() {
        if (getWidth() != 0 && getHeight() != 0) {
            if ((getWidth() / 2) - this.mRecyclerMenu.getWidth() > this.mIndicator.getWidth() / 2) {
                moveCenterIndicator();
            } else {
                moveLeftIndicator();
            }
        }
    }

    public void initTitleMenu(ViewPager viewPager, List<String> list, List<a> list2) {
        updateMenu(list2);
        initTitle(viewPager, list);
    }

    public void setOnBackClickCallback(OnBackClickCallback onBackClickCallback) {
        this.mBackCallback = onBackClickCallback;
    }

    public void setOnTabChangeCallback(OnTabChangeCallback onTabChangeCallback) {
        this.mTabCallback = onTabChangeCallback;
    }

    public void updateMenu(List<a> list) {
        this.mRecyclerMenu.setData(list);
        this.mRecyclerMenu.c();
    }

    public TabTitleLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabTitleLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        LayoutInflater.from(context).inflate(R.layout.layout_common_tab_title, this, true);
        initView();
        initCallback();
    }
}
