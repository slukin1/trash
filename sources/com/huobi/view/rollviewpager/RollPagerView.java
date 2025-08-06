package com.huobi.view.rollviewpager;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.widgets.R$styleable;
import com.huobi.view.rollviewpager.adapter.LoopPagerAdapter;
import com.huobi.view.rollviewpager.hintview.ColorPointHintView;
import com.huobi.view.rollviewpager.hintview.HintView;
import com.huobi.view.roundimg.RoundedDrawable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Timer;
import java.util.TimerTask;

public class RollPagerView extends RelativeLayout implements ViewPager.OnPageChangeListener {
    private static final int ANIMATION_DURATION = 500;
    private static final int CURRENT_START_ITEM_SIZE = 30;
    private int alpha;
    private int color;
    /* access modifiers changed from: private */
    public int delay;
    private int gravity;
    /* access modifiers changed from: private */
    public PagerAdapter mAdapter;
    private GestureDetector mGestureDetector;
    /* access modifiers changed from: private */
    public TimeTaskHandler mHandler;
    /* access modifiers changed from: private */
    public View mHintView;
    /* access modifiers changed from: private */
    public HintViewDelegate mHintViewDelegate;
    /* access modifiers changed from: private */
    public OnItemClickListener mOnItemClickListener;
    /* access modifiers changed from: private */
    public long mRecentTouchTime;
    /* access modifiers changed from: private */
    public ExtendViewPager mViewPager;
    private int paddingBottom;
    private int paddingLeft;
    private int paddingRight;
    private int paddingTop;
    private int pageNum;
    private boolean scrollable;
    private Timer timer;

    public interface HintViewDelegate {
        void initView(int i11, int i12, HintView hintView);

        void setCurrentPosition(int i11, HintView hintView);
    }

    public class JPagerObserver extends DataSetObserver {
        private JPagerObserver() {
        }

        public void onChanged() {
            RollPagerView.this.dataSetChanged();
        }

        public void onInvalidated() {
            RollPagerView.this.dataSetChanged();
        }
    }

    public static final class TimeTaskHandler extends Handler {
        private WeakReference<RollPagerView> mRollPagerViewWeakReference;

        public TimeTaskHandler(RollPagerView rollPagerView) {
            this.mRollPagerViewWeakReference = new WeakReference<>(rollPagerView);
        }

        public void handleMessage(Message message) {
            RollPagerView rollPagerView = (RollPagerView) this.mRollPagerViewWeakReference.get();
            int currentItem = rollPagerView.getViewPager().getCurrentItem() + 1;
            if (currentItem >= rollPagerView.mAdapter.getCount()) {
                currentItem = 0;
            }
            rollPagerView.getViewPager().setCurrentItem(currentItem);
            rollPagerView.mHintViewDelegate.setCurrentPosition(currentItem, (HintView) rollPagerView.mHintView);
            if (rollPagerView.mAdapter.getCount() <= 1) {
                rollPagerView.stopPlay();
            }
        }
    }

    public static class WeakTimerTask extends TimerTask {
        private WeakReference<RollPagerView> mRollPagerViewWeakReference;

        public WeakTimerTask(RollPagerView rollPagerView) {
            this.mRollPagerViewWeakReference = new WeakReference<>(rollPagerView);
        }

        public void run() {
            RollPagerView rollPagerView = (RollPagerView) this.mRollPagerViewWeakReference.get();
            if (rollPagerView == null) {
                cancel();
            } else if (rollPagerView.isShown() && System.currentTimeMillis() - rollPagerView.mRecentTouchTime > ((long) rollPagerView.delay)) {
                rollPagerView.mHandler.sendEmptyMessage(0);
            }
        }
    }

    public RollPagerView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    public void dataSetChanged() {
        if (this.mHintView != null) {
            this.mHintViewDelegate.initView(this.mAdapter.getCount(), this.gravity, (HintView) this.mHintView);
            this.mHintViewDelegate.setCurrentPosition(this.mViewPager.getCurrentItem(), (HintView) this.mHintView);
        }
        startPlay();
    }

    private void initHint(HintView hintView) {
    }

    private void initView(AttributeSet attributeSet) {
        ExtendViewPager extendViewPager = this.mViewPager;
        if (extendViewPager != null) {
            removeView(extendViewPager);
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.RollViewPager);
        this.gravity = obtainStyledAttributes.getInteger(R$styleable.RollViewPager_rollviewpager_hint_gravity, 1);
        this.delay = obtainStyledAttributes.getInt(R$styleable.RollViewPager_rollviewpager_play_delay, 0);
        this.color = obtainStyledAttributes.getColor(R$styleable.RollViewPager_rollviewpager_hint_color, RoundedDrawable.DEFAULT_BORDER_COLOR);
        this.alpha = obtainStyledAttributes.getInt(R$styleable.RollViewPager_rollviewpager_hint_alpha, 0);
        this.pageNum = obtainStyledAttributes.getInt(R$styleable.RollViewPager_rollviewpager_page_num, 1);
        this.paddingLeft = (int) obtainStyledAttributes.getDimension(R$styleable.RollViewPager_rollviewpager_hint_paddingLeft, 0.0f);
        this.paddingRight = (int) obtainStyledAttributes.getDimension(R$styleable.RollViewPager_rollviewpager_hint_paddingRight, 0.0f);
        this.paddingTop = (int) obtainStyledAttributes.getDimension(R$styleable.RollViewPager_rollviewpager_hint_paddingTop, 0.0f);
        this.paddingBottom = (int) obtainStyledAttributes.getDimension(R$styleable.RollViewPager_rollviewpager_hint_paddingBottom, (float) PixelUtils.a(4.0f));
        ExtendViewPager extendViewPager2 = new ExtendViewPager(getContext());
        this.mViewPager = extendViewPager2;
        extendViewPager2.setOffscreenPageLimit(this.pageNum);
        this.mViewPager.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(this.mViewPager, new RelativeLayout.LayoutParams(-1, -1));
        obtainStyledAttributes.recycle();
        initHint(new ColorPointHintView(getContext(), Color.parseColor("#E3AC42"), Color.parseColor("#88ffffff")));
        this.mGestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                if (RollPagerView.this.mOnItemClickListener != null) {
                    if (RollPagerView.this.mAdapter instanceof LoopPagerAdapter) {
                        RollPagerView.this.mOnItemClickListener.onItemClick(RollPagerView.this.mViewPager.getCurrentItem() % ((LoopPagerAdapter) RollPagerView.this.mAdapter).getRealCount());
                    } else {
                        RollPagerView.this.mOnItemClickListener.onItemClick(RollPagerView.this.mViewPager.getCurrentItem());
                    }
                }
                return super.onSingleTapUp(motionEvent);
            }
        });
    }

    private void loadHintView() {
        addView(this.mHintView);
        this.mHintView.setPadding(this.paddingLeft, this.paddingTop, this.paddingRight, this.paddingBottom);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.mHintView.setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.color);
        gradientDrawable.setAlpha(this.alpha);
        this.mHintView.setBackgroundDrawable(gradientDrawable);
        HintViewDelegate hintViewDelegate = this.mHintViewDelegate;
        PagerAdapter pagerAdapter = this.mAdapter;
        hintViewDelegate.initView(pagerAdapter == null ? 0 : pagerAdapter.getCount(), this.gravity, (HintView) this.mHintView);
    }

    private void startPlay() {
        PagerAdapter pagerAdapter;
        if (this.delay > 0 && (pagerAdapter = this.mAdapter) != null && pagerAdapter.getCount() > 1) {
            Timer timer2 = this.timer;
            if (timer2 != null) {
                timer2.cancel();
            }
            Timer timer3 = new Timer();
            this.timer = timer3;
            WeakTimerTask weakTimerTask = new WeakTimerTask(this);
            int i11 = this.delay;
            timer3.schedule(weakTimerTask, (long) i11, (long) i11);
        }
    }

    /* access modifiers changed from: private */
    public void stopPlay() {
        Timer timer2 = this.timer;
        if (timer2 != null) {
            timer2.cancel();
            this.timer = null;
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            this.mRecentTouchTime = System.currentTimeMillis();
            this.mGestureDetector.onTouchEvent(motionEvent);
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception e11) {
            e11.printStackTrace();
            return super.dispatchTouchEvent(motionEvent);
        }
    }

    public ViewPager getViewPager() {
        return this.mViewPager;
    }

    public boolean isPlaying() {
        return this.timer != null;
    }

    public void onPageScrollStateChanged(int i11) {
    }

    public void onPageScrolled(int i11, float f11, int i12) {
    }

    public void onPageSelected(int i11) {
        this.mHintViewDelegate.setCurrentPosition(i11, (HintView) this.mHintView);
    }

    public void pagerToStartMove() {
        int realCount;
        PagerAdapter adapter = getViewPager().getAdapter();
        int i11 = 0;
        if ((adapter instanceof LoopPagerAdapter) && (realCount = ((LoopPagerAdapter) adapter).getRealCount()) > 0) {
            if (adapter.getCount() == Integer.MAX_VALUE) {
                i11 = 30;
            }
            int i12 = i11 % realCount;
            if (i12 != 0) {
                i11 -= i12;
            }
        }
        this.mViewPager.setCurrentItem(i11);
    }

    public void pause() {
        stopPlay();
    }

    public void resume() {
        startPlay();
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        pagerAdapter.registerDataSetObserver(new JPagerObserver());
        this.mViewPager.setAdapter(pagerAdapter);
        this.mViewPager.addOnPageChangeListener(this);
        this.mAdapter = pagerAdapter;
        dataSetChanged();
    }

    public void setAnimationDuration(final int i11) {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            declaredField.set(this.mViewPager, new Scroller(getContext(), new DecelerateInterpolator()) {
                public void startScroll(int i11, int i12, int i13, int i14, int i15) {
                    int i16;
                    if (System.currentTimeMillis() - RollPagerView.this.mRecentTouchTime > ((long) RollPagerView.this.delay)) {
                        i16 = i11;
                    } else {
                        i16 = i15 / 2;
                    }
                    super.startScroll(i11, i12, i13, i14, i16);
                }

                public void startScroll(int i11, int i12, int i13, int i14) {
                    super.startScroll(i11, i12, i13, i14, i11);
                }
            });
        } catch (NoSuchFieldException e11) {
            e11.printStackTrace();
        } catch (IllegalArgumentException e12) {
            e12.printStackTrace();
        } catch (IllegalAccessException e13) {
            e13.printStackTrace();
        }
    }

    public void setHintAlpha(int i11) {
        this.alpha = i11;
        initHint((HintView) this.mHintView);
    }

    public void setHintPadding(int i11, int i12, int i13, int i14) {
        this.paddingLeft = i11;
        this.paddingTop = i12;
        this.paddingRight = i13;
        this.paddingBottom = i14;
        this.mHintView.setPadding(i11, i12, i13, i14);
    }

    public void setHintView(HintView hintView) {
        View view = this.mHintView;
        if (view != null) {
            removeView(view);
        }
        this.mHintView = (View) hintView;
        if (hintView != null && (hintView instanceof View)) {
            initHint(hintView);
        }
    }

    public void setHintViewDelegate(HintViewDelegate hintViewDelegate) {
        this.mHintViewDelegate = hintViewDelegate;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public void setPlayDelay(int i11) {
        this.delay = i11;
        startPlay();
    }

    public void setScrollable(boolean z11) {
        if (!z11) {
            pause();
        }
        this.mViewPager.setScanScroll(z11);
    }

    public RollPagerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RollPagerView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.scrollable = true;
        this.mHintViewDelegate = new HintViewDelegate() {
            public void initView(int i11, int i12, HintView hintView) {
                if (hintView != null) {
                    hintView.initView(i11, i12);
                }
            }

            public void setCurrentPosition(int i11, HintView hintView) {
                if (hintView != null) {
                    hintView.setCurrent(i11);
                }
            }
        };
        this.mHandler = new TimeTaskHandler(this);
        initView(attributeSet);
        setAnimationDuration(500);
    }
}
