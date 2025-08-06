package com.huobi.view.wheelpicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.hbg.lib.common.utils.PixelUtils;
import com.huobi.view.roundimg.RoundedDrawable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WheelView extends ListView implements AbsListView.OnScrollListener, View.OnTouchListener {
    public static final int DELAY = 500;
    public static final int ITEM_HEIGHT = 40;
    public static final int ITEM_MARGIN = 5;
    public static final int ITEM_OFF_SET = 2;
    public static final int ITEM_PADDING_LEFT_RIGHT = 10;
    public static final int ITEM_PADDING_TOP_BOTTOM = 5;
    public static final int ITEM_TAG_IMAGE = 100;
    public static final int ITEM_TAG_TEXT = 101;
    public static final int LINE_ALPHA = 220;
    public static final int LINE_COLOR = -8139290;
    public static final float LINE_THICK = 1.0f;
    private static final int MATCH_PARENT = -1;
    public static final int SMOOTH_SCROLL_DURATION = 50;
    public static final float TEXT_ALPHA = 0.8f;
    public static final int TEXT_COLOR_FOCUS = -16611122;
    public static final int TEXT_COLOR_NORMAL = -4473925;
    public static final int TEXT_SIZE = 16;
    private static final int WRAP_CONTENT = -2;
    private WheelAdapter adapter = new WheelAdapter();
    private int currentPosition = -1;
    private boolean isUserScroll = false;
    private int itemHeightPixels = 0;
    private LineConfig lineConfig = null;
    private OnWheelListener onWheelListener;
    private int textColorFocus = TEXT_COLOR_FOCUS;
    private int textColorNormal = TEXT_COLOR_NORMAL;
    private int textSize = 16;
    private int typeDimension = 2;

    public static class HoloWheelDrawable extends WheelDrawable {
        private Paint bgPaint;
        private int itemHeight;
        private Paint paint;
        private float ratio;
        private int wheelSize;

        public HoloWheelDrawable(LineConfig lineConfig) {
            super(lineConfig);
            this.wheelSize = lineConfig.getWheelSize();
            this.itemHeight = lineConfig.getItemHeight();
            this.ratio = lineConfig.getRatio();
            init(lineConfig);
        }

        private void init(LineConfig lineConfig) {
            Paint paint2 = new Paint(1);
            this.bgPaint = paint2;
            paint2.setColor(0);
            Paint paint3 = new Paint(1);
            this.paint = paint3;
            paint3.setStrokeWidth(lineConfig.getThick());
            this.paint.setColor(lineConfig.getColor());
            this.paint.setAlpha(lineConfig.getAlpha());
        }

        public void draw(Canvas canvas) {
            canvas.drawRect(0.0f, 0.0f, (float) this.width, (float) this.height, this.bgPaint);
            int i11 = this.itemHeight;
            if (i11 != 0) {
                int i12 = this.width;
                float f11 = this.ratio;
                int i13 = this.wheelSize;
                Canvas canvas2 = canvas;
                canvas2.drawLine(((float) i12) * f11, (float) ((i13 / 2) * i11), ((float) i12) * (1.0f - f11), (float) (i11 * (i13 / 2)), this.paint);
                int i14 = this.width;
                float f12 = this.ratio;
                int i15 = this.itemHeight;
                int i16 = this.wheelSize;
                Canvas canvas3 = canvas;
                canvas3.drawLine(((float) i14) * f12, (float) (((i16 / 2) + 1) * i15), ((float) i14) * (1.0f - f12), (float) (i15 * ((i16 / 2) + 1)), this.paint);
            }
        }
    }

    public interface OnWheelListener {
        void onSelected(boolean z11, int i11, String str);
    }

    @Deprecated
    public interface OnWheelViewListener extends OnWheelListener {
    }

    public static class ShadowWheelDrawable extends WheelDrawable {
        private static final int[] SHADOWS_COLORS = {-6710887, 11184810, 11184810};
        private Paint bgPaint;
        private GradientDrawable bottomShadow;
        private Paint dividerPaint;
        private int itemHeight;
        private Paint paint;
        private GradientDrawable topShadow;
        private int wheelSize;

        public ShadowWheelDrawable(LineConfig lineConfig) {
            super(lineConfig);
            GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
            int[] iArr = SHADOWS_COLORS;
            this.topShadow = new GradientDrawable(orientation, iArr);
            this.bottomShadow = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, iArr);
            this.wheelSize = lineConfig.getWheelSize();
            this.itemHeight = lineConfig.getItemHeight();
            init();
        }

        private void init() {
            Paint paint2 = new Paint(1);
            this.bgPaint = paint2;
            paint2.setColor(0);
            Paint paint3 = new Paint(1);
            this.paint = paint3;
            paint3.setColor(-254816305);
            Paint paint4 = new Paint(1);
            this.dividerPaint = paint4;
            paint4.setColor(-4868683);
            this.dividerPaint.setStrokeWidth(2.0f);
        }

        public void draw(Canvas canvas) {
            canvas.drawRect(0.0f, 0.0f, (float) this.width, (float) this.height, this.bgPaint);
            int i11 = this.itemHeight;
            if (i11 != 0) {
                int i12 = this.wheelSize;
                canvas.drawRect(0.0f, (float) ((i12 / 2) * i11), (float) this.width, (float) (i11 * ((i12 / 2) + 1)), this.paint);
                int i13 = this.itemHeight;
                int i14 = this.wheelSize;
                canvas.drawLine(0.0f, (float) ((i14 / 2) * i13), (float) this.width, (float) (i13 * (i14 / 2)), this.dividerPaint);
                int i15 = this.itemHeight;
                int i16 = this.wheelSize;
                canvas.drawLine(0.0f, (float) (((i16 / 2) + 1) * i15), (float) this.width, (float) (i15 * ((i16 / 2) + 1)), this.dividerPaint);
                this.topShadow.setBounds(0, 0, this.width, this.itemHeight);
                this.topShadow.draw(canvas);
                GradientDrawable gradientDrawable = this.bottomShadow;
                int i17 = this.height;
                gradientDrawable.setBounds(0, i17 - this.itemHeight, this.width, i17);
                this.bottomShadow.draw(canvas);
            }
        }
    }

    public static class WheelAdapter extends BaseAdapter {
        private List<String> data;
        private boolean isLoop;
        private int wheelSize;

        public static class ViewHolder {
            public ItemView itemView;

            private ViewHolder() {
            }
        }

        private WheelAdapter() {
            this.data = new ArrayList();
            this.isLoop = false;
            this.wheelSize = 5;
        }

        public boolean areAllItemsEnabled() {
            return false;
        }

        public final int getCount() {
            if (this.isLoop) {
                return Integer.MAX_VALUE;
            }
            if (this.data.size() > 0) {
                return (this.data.size() + this.wheelSize) - 1;
            }
            return 0;
        }

        public List<String> getData() {
            return this.data;
        }

        public final long getItemId(int i11) {
            if (!this.isLoop) {
                return (long) i11;
            }
            if (this.data.size() > 0) {
                i11 %= this.data.size();
            }
            return (long) i11;
        }

        public final int getRealCount() {
            return this.data.size();
        }

        public final View getView(int i11, View view, ViewGroup viewGroup) {
            int i12;
            ViewHolder viewHolder;
            ItemView itemView;
            if (this.isLoop) {
                i12 = i11 % this.data.size();
            } else {
                int i13 = this.wheelSize;
                if (i11 >= i13 / 2 && i11 < (i13 / 2) + this.data.size()) {
                    i12 = i11 - (this.wheelSize / 2);
                } else {
                    i12 = -1;
                }
            }
            if (view == null) {
                viewHolder = new ViewHolder();
                ItemView itemView2 = new ItemView(viewGroup.getContext());
                viewHolder.itemView = itemView2;
                itemView2.setTag(viewHolder);
                itemView = itemView2;
            } else {
                itemView = view;
                viewHolder = (ViewHolder) view.getTag();
            }
            if (!this.isLoop) {
                viewHolder.itemView.setVisibility(i12 == -1 ? 4 : 0);
            }
            if (i12 == -1) {
                i12 = 0;
            }
            viewHolder.itemView.setText(this.data.get(i12));
            return itemView;
        }

        public int getWheelSize() {
            return this.wheelSize;
        }

        public boolean isEnabled(int i11) {
            return false;
        }

        public boolean isLoop() {
            return this.isLoop;
        }

        @Deprecated
        public final void notifyDataSetChanged() {
            super.notifyDataSetChanged();
        }

        @Deprecated
        public final void notifyDataSetInvalidated() {
            super.notifyDataSetInvalidated();
        }

        public final WheelAdapter setData(List<String> list) {
            this.data.clear();
            if (list != null) {
                this.data.addAll(list);
            }
            super.notifyDataSetChanged();
            return this;
        }

        public final WheelAdapter setLoop(boolean z11) {
            if (z11 != this.isLoop) {
                this.isLoop = z11;
                super.notifyDataSetChanged();
            }
            return this;
        }

        public final WheelAdapter setWheelSize(int i11) {
            if ((i11 & 1) != 0) {
                this.wheelSize = i11;
                super.notifyDataSetChanged();
                return this;
            }
            throw new IllegalArgumentException("wheel size must be an odd number.");
        }

        public final String getItem(int i11) {
            if (!this.isLoop) {
                return this.data.get(i11);
            }
            if (this.data.size() <= 0) {
                return null;
            }
            List<String> list = this.data;
            return list.get(i11 % list.size());
        }
    }

    public static class WheelDrawable extends Drawable {
        private Paint bgPaint;
        public int height;
        public int width;

        public WheelDrawable(LineConfig lineConfig) {
            this.width = lineConfig.getWidth();
            this.height = lineConfig.getHeight();
            init();
        }

        private void init() {
            Paint paint = new Paint(1);
            this.bgPaint = paint;
            paint.setColor(0);
        }

        public void draw(Canvas canvas) {
            canvas.drawRect(0.0f, 0.0f, (float) this.width, (float) this.height, this.bgPaint);
        }

        public int getOpacity() {
            return 0;
        }

        public void setAlpha(int i11) {
        }

        public void setColorFilter(ColorFilter colorFilter) {
        }
    }

    public WheelView(Context context) {
        super(context);
        initView();
    }

    private void _setItems(List<String> list) {
        if (list == null || list.size() == 0) {
            throw new IllegalArgumentException("data are empty");
        }
        this.isUserScroll = false;
        this.currentPosition = -1;
        this.adapter.setData(list);
    }

    private void changeBackground() {
        int wheelSize = this.adapter.getWheelSize();
        if (this.lineConfig == null) {
            this.lineConfig = new LineConfig();
        }
        this.lineConfig.setWidth(getWidth());
        this.lineConfig.setHeight(this.itemHeightPixels * wheelSize);
        this.lineConfig.setWheelSize(wheelSize);
        this.lineConfig.setItemHeight(this.itemHeightPixels);
        Drawable holoWheelDrawable = new HoloWheelDrawable(this.lineConfig);
        if (this.lineConfig.isShadowVisible()) {
            ShadowWheelDrawable shadowWheelDrawable = new ShadowWheelDrawable(this.lineConfig);
            if (this.lineConfig.isVisible()) {
                holoWheelDrawable = new LayerDrawable(new Drawable[]{shadowWheelDrawable, holoWheelDrawable});
            } else {
                holoWheelDrawable = shadowWheelDrawable;
            }
        } else if (!this.lineConfig.isVisible()) {
            holoWheelDrawable = new WheelDrawable(this.lineConfig);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            super.setBackground(holoWheelDrawable);
        } else {
            super.setBackgroundDrawable(holoWheelDrawable);
        }
    }

    private int getRealPosition(int i11) {
        int realCount = this.adapter.getRealCount();
        if (realCount == 0) {
            return 0;
        }
        return this.adapter.isLoop() ? (i11 + ((1073741823 / realCount) * realCount)) - (this.adapter.getWheelSize() / 2) : i11;
    }

    private void initView() {
        setVerticalScrollBarEnabled(false);
        setScrollingCacheEnabled(false);
        setCacheColorHint(0);
        setFadingEdgeLength(0);
        setOverScrollMode(2);
        setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        setDividerHeight(0);
        setOnScrollListener(this);
        setOnTouchListener(this);
        if (Build.VERSION.SDK_INT >= 21) {
            setNestedScrollingEnabled(true);
        }
        if (!isInEditMode()) {
            getViewTreeObserver().addOnGlobalLayoutListener(this);
        }
        super.setAdapter(this.adapter);
    }

    private int obtainSmoothDistance(float f11) {
        if (Math.abs(f11) <= 2.0f) {
            return (int) f11;
        }
        if (Math.abs(f11) < 12.0f) {
            return f11 > 0.0f ? 2 : -2;
        }
        return (int) (f11 / 6.0f);
    }

    private void onSelectedCallback() {
        int selectedIndex = getSelectedIndex();
        String selectedItem = getSelectedItem();
        OnWheelListener onWheelListener2 = this.onWheelListener;
        if (onWheelListener2 != null) {
            onWheelListener2.onSelected(this.isUserScroll, selectedIndex, selectedItem);
        }
    }

    /* access modifiers changed from: private */
    public void refreshCurrentPosition() {
        if (getChildAt(0) != null && this.itemHeightPixels != 0) {
            int firstVisiblePosition = getFirstVisiblePosition();
            if (!this.adapter.isLoop() || firstVisiblePosition != 0) {
                int i11 = Math.abs(getChildAt(0).getY()) <= ((float) (this.itemHeightPixels / 2)) ? firstVisiblePosition : firstVisiblePosition + 1;
                int wheelSize = (this.adapter.getWheelSize() - 1) / 2;
                int i12 = i11 + wheelSize;
                refreshVisibleItems(firstVisiblePosition, i12, wheelSize);
                if (this.adapter.isLoop()) {
                    i11 = i12 % this.adapter.getRealCount();
                }
                if (i11 != this.currentPosition) {
                    this.currentPosition = i11;
                    onSelectedCallback();
                }
            }
        }
    }

    private void refreshTextView(int i11, int i12, View view, TextView textView) {
        if (i12 == i11) {
            setTextView(view, textView, this.textColorFocus, (float) this.textSize, 1.0f);
            return;
        }
        View view2 = view;
        TextView textView2 = textView;
        setTextView(view2, textView2, this.textColorNormal, (float) this.textSize, (float) Math.pow(0.800000011920929d, (double) Math.abs(i11 - i12)));
    }

    private void refreshVisibleItems(int i11, int i12, int i13) {
        for (int i14 = i12 - i13; i14 <= i12 + i13; i14++) {
            View childAt = getChildAt(i14 - i11);
            if (childAt != null) {
                refreshTextView(i14, i12, childAt, (TextView) childAt.findViewWithTag(101));
            }
        }
    }

    private void setTextView(View view, TextView textView, int i11, float f11, float f12) {
        textView.setTextColor(i11);
        textView.setTextSize(this.typeDimension, f11);
        view.setAlpha(f12);
    }

    public int getCurrentPosition() {
        int i11 = this.currentPosition;
        if (i11 == -1) {
            return 0;
        }
        return i11;
    }

    public int getSelectedIndex() {
        return getCurrentPosition();
    }

    public void onGlobalLayout() {
        if (Build.VERSION.SDK_INT >= 16) {
            getViewTreeObserver().removeOnGlobalLayoutListener(this);
        } else {
            getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
        if (getChildCount() > 0 && this.itemHeightPixels == 0) {
            int height = getChildAt(0).getHeight();
            this.itemHeightPixels = height;
            if (height != 0) {
                int wheelSize = this.adapter.getWheelSize();
                getLayoutParams().height = this.itemHeightPixels * wheelSize;
                int i11 = wheelSize / 2;
                refreshVisibleItems(getFirstVisiblePosition(), getCurrentPosition() + i11, i11);
                changeBackground();
            }
        }
    }

    public void onMeasure(int i11, int i12) {
        if (getLayoutParams().width == -2) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(0, 0), i12);
        } else {
            super.onMeasure(i11, i12);
        }
    }

    public void onScroll(AbsListView absListView, int i11, int i12, int i13) {
        if (i12 != 0) {
            refreshCurrentPosition();
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i11) {
        View childAt;
        if (i11 == 0 && (childAt = getChildAt(0)) != null) {
            float y11 = childAt.getY();
            if (((int) y11) != 0 && this.itemHeightPixels != 0) {
                float abs = Math.abs(y11);
                int i12 = this.itemHeightPixels;
                if (abs < ((float) (i12 / 2))) {
                    smoothScrollBy(obtainSmoothDistance(y11), 50);
                } else {
                    smoothScrollBy(obtainSmoothDistance(((float) i12) + y11), 50);
                }
            }
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.isUserScroll = true;
        motionEvent.getAction();
        return false;
    }

    public void setCycleDisable(boolean z11) {
        this.adapter.setLoop(!z11);
    }

    public void setItems(List<String> list) {
        _setItems(list);
        setSelectedIndex(0);
    }

    public void setLineConfig(LineConfig lineConfig2) {
        this.lineConfig = lineConfig2;
    }

    public void setOffset(int i11) {
        if (i11 < 1 || i11 > 3) {
            throw new IllegalArgumentException("Offset must between 1 and 3");
        }
        this.adapter.setWheelSize((i11 * 2) + 1);
    }

    public void setOnWheelListener(OnWheelListener onWheelListener2) {
        this.onWheelListener = onWheelListener2;
    }

    public void setSelectedIndex(int i11) {
        setSelection(i11);
    }

    public void setSelectedItem(String str) {
        setSelection(this.adapter.getData().indexOf(str));
    }

    public void setSelection(int i11) {
        setVisibility(4);
        final int realPosition = getRealPosition(i11);
        postDelayed(new Runnable() {
            public void run() {
                WheelView.this.setVisibility(0);
                WheelView.super.setSelection(realPosition);
                WheelView.this.refreshCurrentPosition();
            }
        }, 500);
    }

    public void setTextColor(int i11, int i12) {
        this.textColorNormal = i11;
        this.textColorFocus = i12;
    }

    public void setTextSize(int i11, int i12) {
        this.textSize = i11;
        this.typeDimension = i12;
    }

    public static class ItemView extends LinearLayout {
        private ImageView imageView;
        private TextView textView;

        public ItemView(Context context) {
            super(context);
            init(context);
        }

        private void init(Context context) {
            setOrientation(0);
            int a11 = PixelUtils.a(5.0f);
            int a12 = PixelUtils.a(10.0f);
            setPadding(a12, a11, a12, a11);
            setGravity(17);
            setLayoutParams(new AbsListView.LayoutParams(-1, PixelUtils.a(40.0f)));
            ImageView imageView2 = new ImageView(getContext());
            this.imageView = imageView2;
            imageView2.setTag(100);
            this.imageView.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = PixelUtils.a(5.0f);
            addView(this.imageView, layoutParams);
            TextView textView2 = new TextView(getContext());
            this.textView = textView2;
            textView2.setTag(101);
            this.textView.setEllipsize(TextUtils.TruncateAt.END);
            this.textView.setSingleLine(true);
            this.textView.setIncludeFontPadding(false);
            this.textView.setGravity(17);
            this.textView.setTextColor(RoundedDrawable.DEFAULT_BORDER_COLOR);
            addView(this.textView, new LinearLayout.LayoutParams(-1, -2));
        }

        public void setImage(int i11) {
            this.imageView.setVisibility(0);
            this.imageView.setImageResource(i11);
        }

        public void setText(CharSequence charSequence) {
            this.textView.setText(charSequence);
        }

        public ItemView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            init(context);
        }

        public ItemView(Context context, AttributeSet attributeSet, int i11) {
            super(context, attributeSet, i11);
            init(context);
        }
    }

    public String getSelectedItem() {
        return this.adapter.getItem(getCurrentPosition());
    }

    @Deprecated
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter == null || !(listAdapter instanceof WheelAdapter)) {
            throw new IllegalArgumentException("please invoke setItems");
        }
        WheelAdapter wheelAdapter = (WheelAdapter) listAdapter;
        this.adapter = wheelAdapter;
        super.setAdapter(wheelAdapter);
    }

    public void setItems(String[] strArr) {
        setItems((List<String>) Arrays.asList(strArr));
    }

    public void setTextColor(int i11) {
        this.textColorFocus = i11;
    }

    public void setTextSize(int i11) {
        this.textSize = i11;
    }

    public void setItems(List<String> list, int i11) {
        _setItems(list);
        setSelectedIndex(i11);
    }

    public void setItems(List<String> list, String str) {
        _setItems(list);
        setSelectedItem(str);
    }

    public void setItems(String[] strArr, int i11) {
        setItems((List<String>) Arrays.asList(strArr), i11);
    }

    public void setItems(String[] strArr, String str) {
        setItems((List<String>) Arrays.asList(strArr), str);
    }

    public static class LineConfig {
        private int alpha = 220;
        private int color = WheelView.LINE_COLOR;
        private int height = 0;
        private int itemHeight = 0;
        private float ratio = 0.16666667f;
        private boolean shadowVisible = false;
        private float thick = 1.0f;
        private boolean visible = true;
        private int wheelSize = 0;
        private int width = 0;

        public LineConfig() {
        }

        public int getAlpha() {
            return this.alpha;
        }

        public int getColor() {
            return this.color;
        }

        public int getHeight() {
            return this.height;
        }

        public int getItemHeight() {
            return this.itemHeight;
        }

        public float getRatio() {
            return this.ratio;
        }

        public float getThick() {
            return this.thick;
        }

        public int getWheelSize() {
            return this.wheelSize;
        }

        public int getWidth() {
            return this.width;
        }

        public boolean isShadowVisible() {
            return this.shadowVisible;
        }

        public boolean isVisible() {
            return this.visible;
        }

        public void setAlpha(int i11) {
            this.alpha = i11;
        }

        public void setColor(int i11) {
            this.color = i11;
        }

        public void setHeight(int i11) {
            this.height = i11;
        }

        public void setItemHeight(int i11) {
            this.itemHeight = i11;
        }

        public void setRatio(float f11) {
            this.ratio = f11;
        }

        public void setShadowVisible(boolean z11) {
            this.shadowVisible = z11;
        }

        public void setThick(float f11) {
            this.thick = f11;
        }

        public void setVisible(boolean z11) {
            this.visible = z11;
        }

        public void setWheelSize(int i11) {
            this.wheelSize = i11;
        }

        public void setWidth(int i11) {
            this.width = i11;
        }

        public String toString() {
            return "visible=" + this.visible + "color=" + this.color + ", alpha=" + this.alpha + ", thick=" + this.thick + ", width=" + this.width;
        }

        public LineConfig(float f11) {
            this.ratio = f11;
        }
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public WheelView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        initView();
    }
}
