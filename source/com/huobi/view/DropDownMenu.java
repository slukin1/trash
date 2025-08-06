package com.huobi.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.huobi.R$styleable;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.List;
import pro.huobi.R;

public class DropDownMenu extends LinearLayout {
    private FrameLayout containerView;
    private int current_tab_position;
    private int dividerColor;
    private int maskColor;
    private View maskView;
    private int menuBackgroundColor;
    private int menuSelectedIcon;
    private int menuTextSize;
    private int menuUnselectedIcon;
    private FrameLayout popupMenuViews;
    private int textSelectedColor;
    private int textUnselectedColor;

    public DropDownMenu(Context context) {
        super(context);
        this.current_tab_position = -1;
        this.dividerColor = -3355444;
        this.textSelectedColor = -7795579;
        this.textUnselectedColor = -15658735;
        this.maskColor = -2004318072;
        this.menuTextSize = 14;
    }

    public void closeMenu() {
        if (this.popupMenuViews.getVisibility() == 0) {
            this.popupMenuViews.setVisibility(8);
            this.popupMenuViews.setAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.dd_menu_out));
            this.maskView.setVisibility(8);
            this.maskView.setAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.dd_mask_out));
            this.current_tab_position = -1;
        }
    }

    public void setDropDownMenu(List<View> list, View view) {
        View view2 = new View(getContext());
        this.maskView = view2;
        view2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.maskView.setBackgroundColor(this.maskColor);
        this.maskView.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                DropDownMenu.this.closeMenu();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.containerView.addView(this.maskView, 0);
        this.maskView.setVisibility(8);
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.popupMenuViews = frameLayout;
        frameLayout.setVisibility(8);
        this.containerView.addView(this.popupMenuViews, 1);
        this.popupMenuViews.removeAllViews();
        for (int i11 = 0; i11 < list.size(); i11++) {
            list.get(i11).setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            ViewGroup viewGroup = (ViewGroup) list.get(i11).getParent();
            if (viewGroup != null) {
                viewGroup.removeAllViews();
            }
            this.popupMenuViews.addView(list.get(i11), i11);
        }
    }

    public void switchMenu(View view) {
        this.popupMenuViews.setVisibility(0);
        this.popupMenuViews.setAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.dd_menu_in));
        this.maskView.setVisibility(0);
        this.maskView.setAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.dd_mask_in));
        this.popupMenuViews.getChildAt(0).setVisibility(0);
    }

    public DropDownMenu(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DropDownMenu(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.current_tab_position = -1;
        this.dividerColor = -3355444;
        this.textSelectedColor = -7795579;
        this.textUnselectedColor = -15658735;
        this.maskColor = -2004318072;
        this.menuTextSize = 14;
        setOrientation(1);
        this.menuBackgroundColor = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.DropDownMenu);
        obtainStyledAttributes.getColor(8, -3355444);
        this.dividerColor = obtainStyledAttributes.getColor(0, this.dividerColor);
        this.textSelectedColor = obtainStyledAttributes.getColor(6, this.textSelectedColor);
        this.textUnselectedColor = obtainStyledAttributes.getColor(7, this.textUnselectedColor);
        this.menuBackgroundColor = obtainStyledAttributes.getColor(2, this.menuBackgroundColor);
        this.maskColor = obtainStyledAttributes.getColor(1, this.maskColor);
        this.menuTextSize = obtainStyledAttributes.getDimensionPixelSize(4, this.menuTextSize);
        this.menuSelectedIcon = obtainStyledAttributes.getResourceId(3, this.menuSelectedIcon);
        this.menuUnselectedIcon = obtainStyledAttributes.getResourceId(5, this.menuUnselectedIcon);
        obtainStyledAttributes.recycle();
        FrameLayout frameLayout = new FrameLayout(context);
        this.containerView = frameLayout;
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.containerView, 0);
    }
}
