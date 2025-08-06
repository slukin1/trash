package com.huobi.view;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import com.hbg.lib.widgets.R$drawable;
import com.hbg.lib.widgets.R$font;
import com.hbg.lib.widgets.R$id;
import com.huobi.view.TitleLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.i;
import java.util.ArrayList;
import java.util.List;

public class NewTitleLayout extends TitleLayout {
    private boolean animShowing;

    public NewTitleLayout(Context context) {
        super(context);
        initView(context);
    }

    private void initView(Context context) {
        this.titleViews = new ArrayList();
        setOrientation(0);
        this.context = context;
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
                i.b().g(new x0(this), 300);
                if (z11) {
                    fArr = new float[]{0.0f, 180.0f};
                } else {
                    fArr = new float[]{180.0f, 0.0f};
                }
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(childAt2, "rotation", fArr);
                ofFloat.setDuration(200);
                ofFloat.setRepeatCount(0);
                ofFloat.start();
            }
        }
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

    public int getSelectedIndex() {
        return this.selectedIndex;
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
                ((ConstraintLayout) childAt).addView(imageView, layoutParams);
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
            TitleLayout.OnTitleListener onTitleListener = this.titleListener;
            if (onTitleListener != null) {
                onTitleListener.onTitleChange(indexOfChild);
            }
        } else if (indexOfChild != this.selectedIndex || !view.isSelected()) {
            if (this.opened) {
                this.opened = false;
                scaleImage(false);
                TitleLayout.OnTitleListener onTitleListener2 = this.titleListener;
                if (onTitleListener2 != null) {
                    onTitleListener2.onTitleStatueChange(this.selectedIndex, this.opened);
                }
            }
            if (!this.animShowing) {
                this.animShowing = true;
                setIndex(indexOfChild);
            }
            TitleLayout.OnTitleListener onTitleListener3 = this.titleListener;
            if (onTitleListener3 != null) {
                onTitleListener3.onTitleChange(indexOfChild);
            }
        } else {
            boolean z11 = !this.opened;
            this.opened = z11;
            scaleImage(z11);
            TitleLayout.OnTitleListener onTitleListener4 = this.titleListener;
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
        Drawable drawable;
        TextView textView;
        i.b().g(new w0(this), 300);
        if (i11 == 0) {
            setBackgroundResource(R$drawable.shape_trade_buy_bg);
        } else {
            setBackgroundResource(R$drawable.shape_trade_sell_bg);
        }
        int i12 = this.selectedIndex;
        if (i11 != i12) {
            long j11 = 200;
            if (!(i12 == -1 || (textView = this.titleViews.get(i12)) == null)) {
                ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.selectedTextSize, this.normalTextSize});
                ofFloat.setDuration(this.isShowAnim ? 200 : 0);
                ofFloat.setRepeatCount(0);
                ofFloat.addUpdateListener(new v0(textView));
                ofFloat.start();
                if (Build.VERSION.SDK_INT >= 21) {
                    ofFloat = ObjectAnimator.ofArgb(textView, "textColor", new int[]{this.selectedColor, this.normalColor});
                }
                ofFloat.setDuration(this.isShowAnim ? 200 : 0);
                ofFloat.setRepeatCount(0);
                ofFloat.start();
                ofFloat.start();
                textView.setBackground((Drawable) null);
            }
            TextView textView2 = this.titleViews.get(i11);
            if (textView2 != null) {
                ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{this.normalTextSize, this.selectedTextSize});
                ofFloat2.setDuration(this.isShowAnim ? 200 : 0);
                ofFloat2.setRepeatCount(0);
                ofFloat2.addUpdateListener(new u0(textView2));
                ofFloat2.start();
                this.selectedIndex = i11;
                if (Build.VERSION.SDK_INT >= 21) {
                    ofFloat2 = ObjectAnimator.ofArgb(textView2, "textColor", new int[]{this.normalColor, this.selectedColor});
                }
                if (!this.isShowAnim) {
                    j11 = 0;
                }
                ofFloat2.setDuration(j11);
                ofFloat2.setRepeatCount(0);
                ofFloat2.start();
                if (i11 == 0) {
                    drawable = getResources().getDrawable(R$drawable.shape_trade_buy_tv_bg);
                } else {
                    drawable = getResources().getDrawable(R$drawable.shape_trade_sell_tv_bg);
                }
                textView2.setBackground(drawable);
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

    public void setTitleListener(TitleLayout.OnTitleListener onTitleListener) {
        this.titleListener = onTitleListener;
    }

    public void setTitles(List<?> list, int i11) {
        if (list != null) {
            int size = list.size();
            for (int i12 = 0; i12 < size; i12++) {
                ConstraintLayout constraintLayout = new ConstraintLayout(this.context);
                String obj = list.get(i12).toString();
                TextView textView = new TextView(this.context);
                textView.setTextSize(0, this.normalTextSize);
                textView.setTypeface(ResourcesCompat.h(this.context, R$font.roboto_medium));
                textView.setTextColor(this.normalColor);
                textView.setIncludeFontPadding(false);
                textView.setText(obj);
                textView.setPadding(this.itemPaddingLeft, 0, this.itemPaddingRight, 0);
                textView.setGravity(17);
                textView.setId(R$id.text_view_title_layout);
                this.titleViews.add(textView);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                if (i12 != 0) {
                    layoutParams.leftMargin = this.itemSpace;
                }
                layoutParams.gravity = 17;
                addView(constraintLayout, layoutParams);
                constraintLayout.setOnClickListener(this);
                constraintLayout.addView(textView, new ConstraintLayout.LayoutParams(-2, -1));
            }
            setIndex(i11);
        }
    }

    public void setUnableSelectedIndex(int i11) {
        this.unableSelectedIndex.add(Integer.valueOf(i11));
    }

    public NewTitleLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }

    public NewTitleLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        initView(context);
    }

    public NewTitleLayout(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        initView(context);
    }
}
