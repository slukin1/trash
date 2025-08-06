package com.huobi.view;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.widgets.R$dimen;
import com.hbg.lib.widgets.R$drawable;
import com.hbg.lib.widgets.R$font;
import com.hbg.lib.widgets.R$id;
import com.hbg.lib.widgets.R$layout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.i;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TitleLayout extends LinearLayout implements View.OnClickListener {
    private boolean animShowing;
    public Context context;
    public boolean isShowAnim = true;
    public int itemPaddingLeft = PixelUtils.a(15.0f);
    public int itemPaddingRight = PixelUtils.a(15.0f);
    public int itemSpace = 20;
    public int maxLine = -1;
    public int normalColor;
    public float normalTextSize = ((float) PixelUtils.a(18.0f));
    public boolean opened;
    public int selectedColor;
    public int selectedIndex = -1;
    public float selectedTextSize = ((float) PixelUtils.a(18.0f));
    public OnTitleListener titleListener;
    public List<TextView> titleViews;
    public Set<Integer> unableSelectedIndex = new HashSet();

    public interface ItemCreator {
        View createItemView(int i11);

        int getTextViewId();
    }

    public interface OnTitleListener {
        void onTitleChange(int i11);

        void onTitleStatueChange(int i11, boolean z11);
    }

    public TitleLayout(Context context2) {
        super(context2);
        initView(context2);
    }

    private void configTitles(List<?> list, int i11, int i12, boolean z11) {
        removeAllViewsInLayout();
        if (list != null) {
            int size = list.size();
            for (int i13 = 0; i13 < size; i13++) {
                generateContentLayout(list, i12, z11, i13);
            }
            setIndex(i11);
        }
    }

    private void initView(Context context2) {
        this.titleViews = new ArrayList();
        setOrientation(0);
        this.context = context2;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$scaleImage$3() {
        this.animShowing = false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setIndex$0() {
        this.animShowing = false;
    }

    private void scaleImage(boolean z11) {
        float[] fArr;
        View childAt = getChildAt(this.selectedIndex);
        if (childAt instanceof ConstraintLayout) {
            ConstraintLayout constraintLayout = (ConstraintLayout) childAt;
            View childAt2 = constraintLayout.getChildAt(constraintLayout.getChildCount() - 1);
            if (childAt2 instanceof ImageView) {
                this.animShowing = true;
                i.b().g(new u1(this), 200);
                if (z11) {
                    fArr = new float[]{0.0f, 180.0f};
                } else {
                    fArr = new float[]{180.0f, 360.0f};
                }
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(childAt2, "rotation", fArr);
                ofFloat.setDuration(150);
                ofFloat.setRepeatCount(0);
                ofFloat.start();
            }
        }
    }

    public void dismissIndex(int i11) {
        View childAt = getChildAt(i11);
        if (childAt != null) {
            childAt.setVisibility(8);
        }
    }

    public void displayIndex(int i11) {
        View childAt = getChildAt(i11);
        if (childAt != null) {
            childAt.setVisibility(0);
        }
    }

    public void generateContentLayout(List<?> list, int i11, boolean z11, int i12) {
        LinearLayout.LayoutParams layoutParams;
        ConstraintLayout constraintLayout = new ConstraintLayout(this.context);
        String obj = list.get(i12).toString();
        TextView textView = (TextView) LayoutInflater.from(this.context).inflate(R$layout.text_view_dingpro_medium, (ViewGroup) null);
        textView.setTextSize(0, this.normalTextSize);
        textView.setTextColor(this.normalColor);
        textView.setText(obj);
        textView.setTypeface(ResourcesCompat.h(this.context, R$font.roboto_medium));
        textView.setPadding(this.itemPaddingLeft, 0, this.itemPaddingRight, 0);
        textView.setGravity(i11);
        textView.setId(R$id.text_view_title_layout);
        int i13 = this.maxLine;
        if (i13 != -1) {
            textView.setMaxLines(i13);
        }
        this.titleViews.add(textView);
        if (z11) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -1);
        }
        if (i12 != 0) {
            layoutParams.leftMargin = this.itemSpace;
        }
        layoutParams.gravity = i11;
        addView(constraintLayout, layoutParams);
        constraintLayout.setOnClickListener(this);
        constraintLayout.addView(textView, new ConstraintLayout.LayoutParams(-2, -1));
    }

    public TextView getCurrentTextView() {
        List<TextView> list = this.titleViews;
        if (list == null || list.isEmpty()) {
            return null;
        }
        int i11 = this.selectedIndex;
        if (i11 < 0 || i11 >= this.titleViews.size()) {
            return this.titleViews.get(0);
        }
        return this.titleViews.get(this.selectedIndex);
    }

    public TextView getIndexTextView(int i11) {
        List<TextView> list = this.titleViews;
        if (list == null || list.isEmpty()) {
            return null;
        }
        if (i11 < 0 || i11 >= this.titleViews.size()) {
            return this.titleViews.get(0);
        }
        return this.titleViews.get(i11);
    }

    public int getSelectedIndex() {
        return this.selectedIndex;
    }

    public Set<Integer> getUnSelectIndex() {
        return this.unableSelectedIndex;
    }

    public void indexAddAnimArrow(int i11) {
        if (this.context != null) {
            View childAt = getChildAt(i11);
            if ((childAt instanceof ConstraintLayout) && ((ConstraintLayout) childAt).getChildCount() < 2) {
                ImageView imageView = new ImageView(this.context);
                imageView.setImageResource(R$drawable.tab_icon_arrow_down);
                childAt.setSelected(true);
                ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
                layoutParams.height = -2;
                int i12 = R$id.text_view_title_layout;
                layoutParams.f7942h = i12;
                layoutParams.f7948k = i12;
                layoutParams.f7936e = i12;
                int dimensionPixelOffset = getResources().getDimensionPixelOffset(R$dimen.dimen_5);
                imageView.setPadding(dimensionPixelOffset, 0, dimensionPixelOffset, 0);
                ConstraintLayout constraintLayout = (ConstraintLayout) childAt;
                View childAt2 = constraintLayout.getChildAt(0);
                if (childAt2 != null) {
                    childAt2.setPadding(childAt2.getPaddingLeft(), childAt2.getPaddingTop(), 0, getPaddingBottom());
                }
                constraintLayout.addView(imageView, layoutParams);
            }
        }
    }

    public void indexRemoveAnimArrow(int i11) {
        if (this.context != null) {
            View childAt = getChildAt(i11);
            if (childAt instanceof ConstraintLayout) {
                ConstraintLayout constraintLayout = (ConstraintLayout) childAt;
                childAt.setSelected(false);
                if (constraintLayout.getChildCount() > 1) {
                    constraintLayout.removeViewAt(1);
                }
            }
        }
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        if (this.animShowing) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        int indexOfChild = indexOfChild(view);
        if (this.unableSelectedIndex.contains(Integer.valueOf(indexOfChild))) {
            OnTitleListener onTitleListener = this.titleListener;
            if (onTitleListener != null) {
                onTitleListener.onTitleChange(indexOfChild);
            }
        } else if (indexOfChild != this.selectedIndex || !view.isSelected()) {
            if (this.opened) {
                this.opened = false;
                scaleImage(false);
                OnTitleListener onTitleListener2 = this.titleListener;
                if (onTitleListener2 != null) {
                    onTitleListener2.onTitleStatueChange(this.selectedIndex, this.opened);
                }
            }
            if (!this.animShowing) {
                this.animShowing = true;
                setIndex(indexOfChild);
            }
            OnTitleListener onTitleListener3 = this.titleListener;
            if (onTitleListener3 != null) {
                onTitleListener3.onTitleChange(indexOfChild);
            }
        } else {
            boolean z11 = !this.opened;
            this.opened = z11;
            scaleImage(z11);
            OnTitleListener onTitleListener4 = this.titleListener;
            if (onTitleListener4 != null) {
                onTitleListener4.onTitleStatueChange(this.selectedIndex, this.opened);
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void removeIndex(int i11) {
        removeViewAt(i11);
        this.titleViews.remove(i11);
        this.unableSelectedIndex.remove(Integer.valueOf(i11));
    }

    public void removeUnableSelectedIndex(int i11) {
        this.unableSelectedIndex.remove(Integer.valueOf(i11));
    }

    public void setIndex(int i11) {
        TextView textView;
        TextView textView2;
        i.b().g(new t1(this), 300);
        int i12 = this.selectedIndex;
        if (i11 != i12) {
            long j11 = 200;
            if (!(i12 == -1 || (textView2 = this.titleViews.get(i12)) == null)) {
                ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.selectedTextSize, this.normalTextSize});
                ofFloat.setDuration(this.isShowAnim ? 200 : 0);
                ofFloat.setRepeatCount(0);
                ofFloat.addUpdateListener(new s1(textView2));
                ofFloat.start();
                if (Build.VERSION.SDK_INT >= 21) {
                    ofFloat = ObjectAnimator.ofArgb(textView2, "textColor", new int[]{this.selectedColor, this.normalColor});
                }
                ofFloat.setDuration(this.isShowAnim ? 200 : 0);
                ofFloat.setRepeatCount(0);
                ofFloat.start();
            }
            List<TextView> list = this.titleViews;
            if (list != null && list.size() > 0 && i11 >= 0 && i11 < this.titleViews.size() && (textView = this.titleViews.get(i11)) != null) {
                ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{this.normalTextSize, this.selectedTextSize});
                ofFloat2.setDuration(this.isShowAnim ? 200 : 0);
                ofFloat2.setRepeatCount(0);
                ofFloat2.addUpdateListener(new r1(textView));
                ofFloat2.start();
                this.selectedIndex = i11;
                if (Build.VERSION.SDK_INT >= 21) {
                    ofFloat2 = ObjectAnimator.ofArgb(textView, "textColor", new int[]{this.normalColor, this.selectedColor});
                }
                if (!this.isShowAnim) {
                    j11 = 0;
                }
                ofFloat2.setDuration(j11);
                ofFloat2.setRepeatCount(0);
                ofFloat2.start();
            }
        }
    }

    public void setItemPaddingLeft(int i11) {
        this.itemPaddingLeft = i11;
    }

    public void setItemPaddingRight(int i11) {
        this.itemPaddingRight = i11;
    }

    public void setItemSpace(int i11) {
        this.itemSpace = i11;
    }

    public void setMaxLine(int i11) {
        this.maxLine = i11;
    }

    public void setNormalColor(int i11) {
        this.normalColor = i11;
    }

    public void setNormalTextSize(float f11) {
        this.normalTextSize = f11;
    }

    public void setOpened(boolean z11) {
        if (z11 != this.opened) {
            this.opened = z11;
            scaleImage(z11);
        }
    }

    public void setSelectedColor(int i11) {
        this.selectedColor = i11;
    }

    public void setSelectedText(String str) {
        TextView textView;
        int i11 = this.selectedIndex;
        if (i11 != -1 && (textView = this.titleViews.get(i11)) != null) {
            textView.setText(str);
        }
    }

    public void setSelectedTextSize(float f11) {
        this.selectedTextSize = f11;
    }

    public void setShowAnim(boolean z11) {
        this.isShowAnim = z11;
    }

    public void setTitleListener(OnTitleListener onTitleListener) {
        this.titleListener = onTitleListener;
    }

    public void setTitles(List<?> list, int i11) {
        setTitles(list, i11, 80);
    }

    public void setUnableSelectedIndex(int i11) {
        this.unableSelectedIndex.add(Integer.valueOf(i11));
    }

    public void setTitles(List<?> list, int i11, boolean z11) {
        configTitles(list, i11, 80, z11);
    }

    public void setTitles(List<?> list, int i11, int i12) {
        configTitles(list, i11, i12, false);
    }

    public void setTitles(List<?> list, int i11, ItemCreator itemCreator) {
        removeAllViewsInLayout();
        this.titleViews.clear();
        if (list != null) {
            int size = list.size();
            for (int i12 = 0; i12 < size; i12++) {
                generateContentLayout(list, i12, itemCreator);
            }
            int i13 = this.selectedIndex;
            if (i13 != -1) {
                i11 = i13;
            }
            this.selectedIndex = -1;
            setIndex(i11);
        }
    }

    public TitleLayout(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        initView(context2);
    }

    public TitleLayout(Context context2, AttributeSet attributeSet, int i11) {
        super(context2, attributeSet, i11);
        initView(context2);
    }

    public void generateContentLayout(List<?> list, int i11, ItemCreator itemCreator) {
        String obj = list.get(i11).toString();
        View createItemView = itemCreator.createItemView(i11);
        TextView textView = (TextView) createItemView.findViewById(itemCreator.getTextViewId());
        addView(createItemView, new LinearLayout.LayoutParams(-2, -2));
        createItemView.setOnClickListener(this);
        textView.setTextColor(this.normalColor);
        textView.setText(obj);
        int i12 = this.maxLine;
        if (i12 != -1) {
            textView.setMaxLines(i12);
        }
        this.titleViews.add(textView);
    }

    public void setIndex(String str) {
        List<TextView> list;
        if (str != null && (list = this.titleViews) != null && !list.isEmpty()) {
            for (int i11 = 0; i11 < this.titleViews.size(); i11++) {
                if (str.equals(this.titleViews.get(i11).getText())) {
                    setIndex(i11);
                    return;
                }
            }
        }
    }

    public TitleLayout(Context context2, AttributeSet attributeSet, int i11, int i12) {
        super(context2, attributeSet, i11, i12);
        initView(context2);
    }
}
