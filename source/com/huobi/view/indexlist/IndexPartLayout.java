package com.huobi.view.indexlist;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.h0;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.widgets.R$color;
import com.hbg.lib.widgets.R$dimen;
import com.hbg.lib.widgets.R$drawable;
import com.hbg.lib.widgets.R$styleable;
import com.huobi.view.indexlist.database.DataObserver;
import com.huobi.view.indexlist.database.HeaderFooterDataObserver;
import com.huobi.view.indexlist.database.IndexBarDataObserver;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

public class IndexPartLayout extends FrameLayout {
    public static final String INDEX_SIGN = "#";
    public static final int MODE_ALL_LETTERS = 1;
    public static final int MODE_FAST = 0;
    public static final int MODE_NONE = 2;
    private static int PADDING_RIGHT_OVERLAY;
    private Drawable mBarBg;
    private int mBarFocusTextColor;
    private int mBarTextColor;
    private float mBarTextSize;
    private float mBarTextSpace;
    private float mBarWidth;
    /* access modifiers changed from: private */
    public TextView mCenterOverlay;
    public Comparator mComparator;
    private int mCompareMode;
    private Context mContext;
    private DataObserver mDataSetObserver;
    private ExecutorService mExecutorService;
    private Future mFuture;
    private Handler mHandler;
    private HeaderFooterDataObserver<EntityWrapper> mHeaderFooterDataSetObserver;
    /* access modifiers changed from: private */
    public IndexBar mIndexBar;
    private IndexBarDataObserver mIndexBarDataSetObserver;
    /* access modifiers changed from: private */
    public IndexPartAdapter mIndexableAdapter;
    private boolean mIsShowListSticky;
    private View mLastInvisibleRecyclerViewItemView;
    /* access modifiers changed from: private */
    public RecyclerView.LayoutManager mLayoutManager;
    /* access modifiers changed from: private */
    public TextView mMDOverlay;
    /* access modifiers changed from: private */
    public RealAdapter mRealAdapter;
    private RecyclerView mRecy;
    /* access modifiers changed from: private */
    public boolean mShowAllLetter;
    private String mStickyTitle;
    private RecyclerView.ViewHolder mStickyViewHolder;
    private boolean mSticyEnable;
    private Pattern pattern;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CompareMode {
    }

    public IndexPartLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    public Handler getSafeHandler() {
        if (this.mHandler == null) {
            this.mHandler = new Handler(Looper.getMainLooper());
        }
        return this.mHandler;
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mContext = context;
        this.mExecutorService = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(1024), new ThreadFactory() {
            private final AtomicInteger integer = new AtomicInteger();

            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "IndexableLayout-Executor#" + this.integer.getAndIncrement());
            }
        }, new ThreadPoolExecutor.AbortPolicy());
        PADDING_RIGHT_OVERLAY = (int) TypedValue.applyDimension(1, 80.0f, getResources().getDisplayMetrics());
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.IndexableRecyclerView);
            this.mBarTextColor = obtainStyledAttributes.getColor(R$styleable.IndexableRecyclerView_indexBar_textColor, ContextCompat.getColor(context, R$color.default_indexBar_textColor));
            this.mBarTextSize = obtainStyledAttributes.getDimension(R$styleable.IndexableRecyclerView_indexBar_textSize, getResources().getDimension(R$dimen.default_indexBar_textSize));
            this.mBarFocusTextColor = obtainStyledAttributes.getColor(R$styleable.IndexableRecyclerView_indexBar_selectedTextColor, ContextCompat.getColor(context, R$color.default_indexBar_selectedTextColor));
            this.mBarTextSpace = obtainStyledAttributes.getDimension(R$styleable.IndexableRecyclerView_indexBar_textSpace, getResources().getDimension(R$dimen.default_indexBar_textSpace));
            this.mBarBg = obtainStyledAttributes.getDrawable(R$styleable.IndexableRecyclerView_indexBar_background);
            this.mBarWidth = obtainStyledAttributes.getDimension(R$styleable.IndexableRecyclerView_indexBar_layout_width, getResources().getDimension(R$dimen.default_indexBar_layout_width));
            obtainStyledAttributes.recycle();
        }
        Context context2 = this.mContext;
        if (context2 instanceof Activity) {
            ((Activity) context2).getWindow().setSoftInputMode(32);
        }
        RecyclerView recyclerView = new RecyclerView(context);
        this.mRecy = recyclerView;
        recyclerView.setVerticalScrollBarEnabled(false);
        this.mRecy.setOverScrollMode(2);
        addView(this.mRecy, new FrameLayout.LayoutParams(-1, -1));
        IndexBar indexBar = new IndexBar(context);
        this.mIndexBar = indexBar;
        indexBar.setIsShowListSticky(this.mIsShowListSticky);
        this.mIndexBar.init(this.mBarBg, this.mBarTextColor, this.mBarFocusTextColor, this.mBarTextSize, this.mBarTextSpace);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.mBarWidth, -2);
        layoutParams.gravity = 8388629;
        addView(this.mIndexBar, layoutParams);
        this.mRealAdapter = new RealAdapter();
        this.mRecy.setHasFixedSize(true);
        this.mRecy.setAdapter(this.mRealAdapter);
        initListener();
    }

    private void initCenterOverlay() {
        TextView textView = new TextView(this.mContext);
        this.mCenterOverlay = textView;
        textView.setBackgroundResource(R$drawable.index_list_center_txt_overlay);
        this.mCenterOverlay.setTextColor(-1);
        this.mCenterOverlay.setTextSize(40.0f);
        this.mCenterOverlay.setGravity(17);
        int applyDimension = (int) TypedValue.applyDimension(1, 70.0f, getResources().getDisplayMetrics());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(applyDimension, applyDimension);
        layoutParams.gravity = 17;
        this.mCenterOverlay.setLayoutParams(layoutParams);
        this.mCenterOverlay.setVisibility(4);
        addView(this.mCenterOverlay);
    }

    private void initListener() {
        this.mRecy.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
                super.onScrolled(recyclerView, i11, i12);
                IndexPartLayout.this.processScrollListener();
            }
        });
        this.mIndexBar.setOnTouchListener(new View.OnTouchListener() {
            /* JADX WARNING: Code restructure failed: missing block: B:12:0x0031, code lost:
                if (r2 != 3) goto L_0x008b;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public boolean onTouch(android.view.View r5, android.view.MotionEvent r6) {
                /*
                    r4 = this;
                    com.huobi.view.indexlist.IndexPartLayout r5 = com.huobi.view.indexlist.IndexPartLayout.this
                    com.huobi.view.indexlist.IndexBar r5 = r5.mIndexBar
                    float r0 = r6.getY()
                    int r5 = r5.getPositionForPointY(r0)
                    r0 = 1
                    if (r5 >= 0) goto L_0x0012
                    return r0
                L_0x0012:
                    com.huobi.view.indexlist.IndexPartLayout r1 = com.huobi.view.indexlist.IndexPartLayout.this
                    androidx.recyclerview.widget.RecyclerView$LayoutManager r1 = r1.mLayoutManager
                    boolean r1 = r1 instanceof androidx.recyclerview.widget.LinearLayoutManager
                    if (r1 != 0) goto L_0x001d
                    return r0
                L_0x001d:
                    com.huobi.view.indexlist.IndexPartLayout r1 = com.huobi.view.indexlist.IndexPartLayout.this
                    androidx.recyclerview.widget.RecyclerView$LayoutManager r1 = r1.mLayoutManager
                    androidx.recyclerview.widget.LinearLayoutManager r1 = (androidx.recyclerview.widget.LinearLayoutManager) r1
                    int r2 = r6.getAction()
                    if (r2 == 0) goto L_0x0059
                    if (r2 == r0) goto L_0x0034
                    r3 = 2
                    if (r2 == r3) goto L_0x0059
                    r5 = 3
                    if (r2 == r5) goto L_0x0034
                    goto L_0x008b
                L_0x0034:
                    com.huobi.view.indexlist.IndexPartLayout r5 = com.huobi.view.indexlist.IndexPartLayout.this
                    android.widget.TextView r5 = r5.mCenterOverlay
                    r6 = 8
                    if (r5 == 0) goto L_0x0047
                    com.huobi.view.indexlist.IndexPartLayout r5 = com.huobi.view.indexlist.IndexPartLayout.this
                    android.widget.TextView r5 = r5.mCenterOverlay
                    r5.setVisibility(r6)
                L_0x0047:
                    com.huobi.view.indexlist.IndexPartLayout r5 = com.huobi.view.indexlist.IndexPartLayout.this
                    android.widget.TextView r5 = r5.mMDOverlay
                    if (r5 == 0) goto L_0x008b
                    com.huobi.view.indexlist.IndexPartLayout r5 = com.huobi.view.indexlist.IndexPartLayout.this
                    android.widget.TextView r5 = r5.mMDOverlay
                    r5.setVisibility(r6)
                    goto L_0x008b
                L_0x0059:
                    com.huobi.view.indexlist.IndexPartLayout r2 = com.huobi.view.indexlist.IndexPartLayout.this
                    float r6 = r6.getY()
                    r2.showOverlayView(r6, r5)
                    com.huobi.view.indexlist.IndexPartLayout r6 = com.huobi.view.indexlist.IndexPartLayout.this
                    com.huobi.view.indexlist.IndexBar r6 = r6.mIndexBar
                    int r6 = r6.getSelectionPosition()
                    if (r5 == r6) goto L_0x008b
                    com.huobi.view.indexlist.IndexPartLayout r6 = com.huobi.view.indexlist.IndexPartLayout.this
                    com.huobi.view.indexlist.IndexBar r6 = r6.mIndexBar
                    r6.setSelectionPosition(r5)
                    r6 = 0
                    if (r5 != 0) goto L_0x007e
                    r1.scrollToPositionWithOffset(r6, r6)
                    goto L_0x008b
                L_0x007e:
                    com.huobi.view.indexlist.IndexPartLayout r5 = com.huobi.view.indexlist.IndexPartLayout.this
                    com.huobi.view.indexlist.IndexBar r5 = r5.mIndexBar
                    int r5 = r5.getFirstRecyclerViewPositionBySelection()
                    r1.scrollToPositionWithOffset(r5, r6)
                L_0x008b:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.huobi.view.indexlist.IndexPartLayout.AnonymousClass7.onTouch(android.view.View, android.view.MotionEvent):boolean");
            }
        });
    }

    private void initMDOverlay(int i11) {
        AppCompatTextView appCompatTextView = new AppCompatTextView(this.mContext);
        this.mMDOverlay = appCompatTextView;
        appCompatTextView.setBackgroundResource(R$drawable.indexable_bg_md_overlay);
        h0.C0(this.mMDOverlay, ColorStateList.valueOf(i11));
        this.mMDOverlay.setSingleLine();
        this.mMDOverlay.setTextColor(-1);
        this.mMDOverlay.setTextSize(38.0f);
        this.mMDOverlay.setGravity(17);
        int applyDimension = (int) TypedValue.applyDimension(1, 72.0f, getResources().getDisplayMetrics());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(applyDimension, applyDimension);
        layoutParams.rightMargin = (int) TypedValue.applyDimension(1, 33.0f, getResources().getDisplayMetrics());
        layoutParams.gravity = 8388613;
        this.mMDOverlay.setLayoutParams(layoutParams);
        this.mMDOverlay.setVisibility(4);
        addView(this.mMDOverlay);
    }

    private <T extends IndexPartEntity> void initStickyView(final IndexPartAdapter<T> indexPartAdapter) {
        RecyclerView.ViewHolder onCreateTitleViewHolder = indexPartAdapter.onCreateTitleViewHolder(this.mRecy);
        this.mStickyViewHolder = onCreateTitleViewHolder;
        onCreateTitleViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                if (indexPartAdapter.getOnItemTitleClickListener() != null) {
                    int firstRecyclerViewPositionBySelection = IndexPartLayout.this.mIndexBar.getFirstRecyclerViewPositionBySelection();
                    ArrayList items = IndexPartLayout.this.mRealAdapter.getItems();
                    if (items.size() > firstRecyclerViewPositionBySelection && firstRecyclerViewPositionBySelection >= 0) {
                        indexPartAdapter.getOnItemTitleClickListener().onItemClick(view, firstRecyclerViewPositionBySelection, ((EntityWrapper) items.get(firstRecyclerViewPositionBySelection)).getIndexTitle());
                    }
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.mStickyViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                if (indexPartAdapter.getOnItemTitleLongClickListener() == null) {
                    return false;
                }
                int firstRecyclerViewPositionBySelection = IndexPartLayout.this.mIndexBar.getFirstRecyclerViewPositionBySelection();
                ArrayList items = IndexPartLayout.this.mRealAdapter.getItems();
                if (items.size() <= firstRecyclerViewPositionBySelection || firstRecyclerViewPositionBySelection < 0) {
                    return false;
                }
                return indexPartAdapter.getOnItemTitleLongClickListener().onItemLongClick(view, firstRecyclerViewPositionBySelection, ((EntityWrapper) items.get(firstRecyclerViewPositionBySelection)).getIndexTitle());
            }
        });
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            if (getChildAt(i11) == this.mRecy) {
                this.mStickyViewHolder.itemView.setVisibility(4);
                addView(this.mStickyViewHolder.itemView, i11 + 1);
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean isStartWithNumber(String str) {
        if (str == null && str.length() == 0) {
            return false;
        }
        Pattern pattern2 = this.pattern;
        if (!pattern2.matcher(str.charAt(0) + "").matches()) {
            return false;
        }
        return true;
    }

    private void processScroll(LinearLayoutManager linearLayoutManager, ArrayList<EntityWrapper> arrayList, int i11, String str) {
        EntityWrapper entityWrapper = arrayList.get(i11);
        View findViewByPosition = linearLayoutManager.findViewByPosition(i11);
        if (findViewByPosition != null) {
            if (entityWrapper.getItemType() == 2147483646) {
                if (findViewByPosition.getTop() <= this.mStickyViewHolder.itemView.getHeight() && str != null) {
                    this.mStickyViewHolder.itemView.setTranslationY((float) (findViewByPosition.getTop() - this.mStickyViewHolder.itemView.getHeight()));
                }
                if (4 == findViewByPosition.getVisibility()) {
                    findViewByPosition.setVisibility(0);
                }
            } else if (this.mStickyViewHolder.itemView.getTranslationY() != 0.0f) {
                this.mStickyViewHolder.itemView.setTranslationY(0.0f);
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0007, code lost:
        r0 = (androidx.recyclerview.widget.LinearLayoutManager) r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void processScrollListener() {
        /*
            r8 = this;
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r8.mLayoutManager
            boolean r1 = r0 instanceof androidx.recyclerview.widget.LinearLayoutManager
            if (r1 != 0) goto L_0x0007
            return
        L_0x0007:
            androidx.recyclerview.widget.LinearLayoutManager r0 = (androidx.recyclerview.widget.LinearLayoutManager) r0
            int r1 = r0.findFirstVisibleItemPosition()
            r2 = -1
            if (r1 != r2) goto L_0x0011
            return
        L_0x0011:
            com.huobi.view.indexlist.IndexBar r2 = r8.mIndexBar
            r2.setSelection(r1)
            boolean r2 = r8.mSticyEnable
            if (r2 != 0) goto L_0x001b
            return
        L_0x001b:
            com.huobi.view.indexlist.RealAdapter r2 = r8.mRealAdapter
            java.util.ArrayList r2 = r2.getItems()
            androidx.recyclerview.widget.RecyclerView$ViewHolder r3 = r8.mStickyViewHolder
            if (r3 == 0) goto L_0x00a3
            int r3 = r2.size()
            if (r3 <= r1) goto L_0x00a3
            java.lang.Object r3 = r2.get(r1)
            com.huobi.view.indexlist.EntityWrapper r3 = (com.huobi.view.indexlist.EntityWrapper) r3
            java.lang.String r4 = r3.getIndexTitle()
            r5 = 2147483646(0x7ffffffe, float:NaN)
            int r3 = r3.getItemType()
            r6 = 0
            r7 = 4
            if (r5 != r3) goto L_0x005d
            android.view.View r3 = r8.mLastInvisibleRecyclerViewItemView
            if (r3 == 0) goto L_0x0052
            int r3 = r3.getVisibility()
            if (r3 != r7) goto L_0x0052
            android.view.View r3 = r8.mLastInvisibleRecyclerViewItemView
            r5 = 0
            r3.setVisibility(r5)
            r8.mLastInvisibleRecyclerViewItemView = r6
        L_0x0052:
            android.view.View r3 = r0.findViewByPosition(r1)
            r8.mLastInvisibleRecyclerViewItemView = r3
            if (r3 == 0) goto L_0x005d
            r3.setVisibility(r7)
        L_0x005d:
            if (r4 != 0) goto L_0x0073
            androidx.recyclerview.widget.RecyclerView$ViewHolder r3 = r8.mStickyViewHolder
            android.view.View r3 = r3.itemView
            int r3 = r3.getVisibility()
            if (r3 != 0) goto L_0x0073
            r8.mStickyTitle = r6
            androidx.recyclerview.widget.RecyclerView$ViewHolder r3 = r8.mStickyViewHolder
            android.view.View r3 = r3.itemView
            r3.setVisibility(r7)
            goto L_0x0076
        L_0x0073:
            r8.stickyNewViewHolder(r4)
        L_0x0076:
            androidx.recyclerview.widget.RecyclerView$LayoutManager r3 = r8.mLayoutManager
            boolean r5 = r3 instanceof androidx.recyclerview.widget.GridLayoutManager
            if (r5 == 0) goto L_0x0098
            androidx.recyclerview.widget.GridLayoutManager r3 = (androidx.recyclerview.widget.GridLayoutManager) r3
            int r5 = r3.k()
            int r5 = r5 + r1
            int r6 = r2.size()
            if (r5 >= r6) goto L_0x00a3
            int r5 = r1 + 1
        L_0x008b:
            int r6 = r3.k()
            int r6 = r6 + r1
            if (r5 > r6) goto L_0x00a3
            r8.processScroll(r0, r2, r5, r4)
            int r5 = r5 + 1
            goto L_0x008b
        L_0x0098:
            int r1 = r1 + 1
            int r3 = r2.size()
            if (r1 >= r3) goto L_0x00a3
            r8.processScroll(r0, r2, r1, r4)
        L_0x00a3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.view.indexlist.IndexPartLayout.processScrollListener():void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0090  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void showOverlayView(float r5, int r6) {
        /*
            r4 = this;
            com.huobi.view.indexlist.IndexBar r0 = r4.mIndexBar
            java.util.List r0 = r0.getIndexList()
            int r0 = r0.size()
            if (r0 > r6) goto L_0x000d
            return
        L_0x000d:
            android.widget.TextView r0 = r4.mMDOverlay
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x00a2
            int r0 = r0.getVisibility()
            if (r0 == 0) goto L_0x001e
            android.widget.TextView r0 = r4.mMDOverlay
            r0.setVisibility(r2)
        L_0x001e:
            int r0 = PADDING_RIGHT_OVERLAY
            com.huobi.view.indexlist.IndexBar r3 = r4.mIndexBar
            int r3 = r3.getTop()
            int r0 = r0 - r3
            float r0 = (float) r0
            int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            r3 = 0
            if (r0 >= 0) goto L_0x003c
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 < 0) goto L_0x003c
            int r5 = PADDING_RIGHT_OVERLAY
            com.huobi.view.indexlist.IndexBar r0 = r4.mIndexBar
            int r0 = r0.getTop()
            int r5 = r5 - r0
        L_0x003a:
            float r5 = (float) r5
            goto L_0x0067
        L_0x003c:
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0055
            com.huobi.view.indexlist.IndexBar r5 = r4.mIndexBar
            int r5 = r5.getTop()
            int r0 = PADDING_RIGHT_OVERLAY
            if (r5 <= r0) goto L_0x004c
            r5 = r3
            goto L_0x0067
        L_0x004c:
            com.huobi.view.indexlist.IndexBar r5 = r4.mIndexBar
            int r5 = r5.getTop()
            int r0 = r0 - r5
            float r5 = (float) r0
            goto L_0x0067
        L_0x0055:
            com.huobi.view.indexlist.IndexBar r0 = r4.mIndexBar
            int r0 = r0.getHeight()
            float r0 = (float) r0
            int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x0067
            com.huobi.view.indexlist.IndexBar r5 = r4.mIndexBar
            int r5 = r5.getHeight()
            goto L_0x003a
        L_0x0067:
            android.widget.TextView r0 = r4.mMDOverlay
            com.huobi.view.indexlist.IndexBar r3 = r4.mIndexBar
            int r3 = r3.getTop()
            float r3 = (float) r3
            float r3 = r3 + r5
            int r5 = PADDING_RIGHT_OVERLAY
            float r5 = (float) r5
            float r3 = r3 - r5
            r0.setY(r3)
            com.huobi.view.indexlist.IndexBar r5 = r4.mIndexBar
            java.util.List r5 = r5.getIndexList()
            java.lang.Object r5 = r5.get(r6)
            java.lang.String r5 = (java.lang.String) r5
            android.widget.TextView r0 = r4.mMDOverlay
            java.lang.CharSequence r0 = r0.getText()
            boolean r0 = r0.equals(r5)
            if (r0 != 0) goto L_0x00a2
            int r0 = r5.length()
            if (r0 <= r1) goto L_0x009d
            android.widget.TextView r0 = r4.mMDOverlay
            r3 = 1106247680(0x41f00000, float:30.0)
            r0.setTextSize(r3)
        L_0x009d:
            android.widget.TextView r0 = r4.mMDOverlay
            r0.setText(r5)
        L_0x00a2:
            android.widget.TextView r5 = r4.mCenterOverlay
            if (r5 == 0) goto L_0x00db
            int r5 = r5.getVisibility()
            if (r5 == 0) goto L_0x00b1
            android.widget.TextView r5 = r4.mCenterOverlay
            r5.setVisibility(r2)
        L_0x00b1:
            com.huobi.view.indexlist.IndexBar r5 = r4.mIndexBar
            java.util.List r5 = r5.getIndexList()
            java.lang.Object r5 = r5.get(r6)
            java.lang.String r5 = (java.lang.String) r5
            android.widget.TextView r6 = r4.mCenterOverlay
            java.lang.CharSequence r6 = r6.getText()
            boolean r6 = r6.equals(r5)
            if (r6 != 0) goto L_0x00db
            int r6 = r5.length()
            if (r6 <= r1) goto L_0x00d6
            android.widget.TextView r6 = r4.mCenterOverlay
            r0 = 1107296256(0x42000000, float:32.0)
            r6.setTextSize(r0)
        L_0x00d6:
            android.widget.TextView r6 = r4.mCenterOverlay
            r6.setText(r5)
        L_0x00db:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.view.indexlist.IndexPartLayout.showOverlayView(float, int):void");
    }

    private void stickyNewViewHolder(String str) {
        if (str != null && !str.equals(this.mStickyTitle)) {
            if (this.mStickyViewHolder.itemView.getVisibility() != 0) {
                this.mStickyViewHolder.itemView.setVisibility(0);
            }
            this.mStickyTitle = str;
            this.mIndexableAdapter.onBindTitleViewHolder(this.mStickyViewHolder, str);
        }
    }

    public <T> void addFooterAdapter(IndexPartFooterAdapter<T> indexPartFooterAdapter) {
        indexPartFooterAdapter.registerDataSetObserver(this.mHeaderFooterDataSetObserver);
        indexPartFooterAdapter.registerIndexBarDataSetObserver(this.mIndexBarDataSetObserver);
        this.mRealAdapter.addIndexFooterAdapter(indexPartFooterAdapter);
    }

    public <T> void addHeaderAdapter(IndexHeaderAdapter<T> indexHeaderAdapter) {
        indexHeaderAdapter.registerDataSetObserver(this.mHeaderFooterDataSetObserver);
        indexHeaderAdapter.registerIndexBarDataSetObserver(this.mIndexBarDataSetObserver);
        this.mRealAdapter.addIndexHeaderAdapter(indexHeaderAdapter);
    }

    public int getCompareMode() {
        return this.mCompareMode;
    }

    public TextView getOverlayView() {
        TextView textView = this.mMDOverlay;
        return textView != null ? textView : this.mCenterOverlay;
    }

    public RecyclerView getRecyclerView() {
        return this.mRecy;
    }

    public void onDataChanged() {
        Future future = this.mFuture;
        if (future != null) {
            future.cancel(true);
        }
        this.mFuture = this.mExecutorService.submit(new Runnable() {
            public void run() {
                IndexPartLayout indexPartLayout = IndexPartLayout.this;
                final ArrayList transform = indexPartLayout.transform(indexPartLayout.mIndexableAdapter.getItems());
                if (transform != null) {
                    IndexPartLayout.this.getSafeHandler().post(new Runnable() {
                        public void run() {
                            IndexPartLayout.this.mRealAdapter.setDatas(transform);
                            IndexPartLayout.this.mIndexBar.setDatas(IndexPartLayout.this.mShowAllLetter, IndexPartLayout.this.mRealAdapter.getItems());
                            if (IndexPartLayout.this.mIndexableAdapter.getIndexCallback() != null) {
                                IndexPartLayout.this.mIndexableAdapter.getIndexCallback().onFinished(transform);
                            }
                            IndexPartLayout.this.processScrollListener();
                        }
                    });
                }
            }
        });
    }

    public <T> void removeFooterAdapter(IndexPartFooterAdapter<T> indexPartFooterAdapter) {
        try {
            indexPartFooterAdapter.unregisterDataSetObserver(this.mHeaderFooterDataSetObserver);
            indexPartFooterAdapter.unregisterIndexBarDataSetObserver(this.mIndexBarDataSetObserver);
            this.mRealAdapter.removeIndexFooterAdapter(indexPartFooterAdapter);
        } catch (Exception unused) {
        }
    }

    public <T> void removeHeaderAdapter(IndexHeaderAdapter<T> indexHeaderAdapter) {
        try {
            indexHeaderAdapter.unregisterDataSetObserver(this.mHeaderFooterDataSetObserver);
            indexHeaderAdapter.unregisterIndexBarDataSetObserver(this.mIndexBarDataSetObserver);
            this.mRealAdapter.removeIndexHeaderAdapter(indexHeaderAdapter);
        } catch (Exception unused) {
        }
    }

    public <T extends IndexPartEntity> void setAdapter(final IndexPartAdapter<T> indexPartAdapter) {
        Objects.requireNonNull(this.mLayoutManager, "You must set the LayoutManager first");
        this.mIndexableAdapter = indexPartAdapter;
        DataObserver dataObserver = this.mDataSetObserver;
        if (dataObserver != null) {
            indexPartAdapter.unregisterDataSetObserver(dataObserver);
        }
        AnonymousClass3 r02 = new DataObserver() {
            public void onChanged() {
                if (IndexPartLayout.this.mRealAdapter != null) {
                    IndexPartLayout.this.mRealAdapter.notifyDataSetChanged();
                }
            }

            public void onInited() {
                onSetListener(0);
                IndexPartLayout.this.onDataChanged();
            }

            public void onSetListener(int i11) {
                if ((i11 == 1 || i11 == 0) && indexPartAdapter.getOnItemTitleClickListener() != null) {
                    IndexPartLayout.this.mRealAdapter.setOnItemTitleClickListener(indexPartAdapter.getOnItemTitleClickListener());
                }
                if ((i11 == 3 || i11 == 0) && indexPartAdapter.getOnItemTitleLongClickListener() != null) {
                    IndexPartLayout.this.mRealAdapter.setOnItemTitleLongClickListener(indexPartAdapter.getOnItemTitleLongClickListener());
                }
                if ((i11 == 2 || i11 == 0) && indexPartAdapter.getOnItemContentClickListener() != null) {
                    IndexPartLayout.this.mRealAdapter.setOnItemContentClickListener(indexPartAdapter.getOnItemContentClickListener());
                }
                if ((i11 == 4 || i11 == 0) && indexPartAdapter.getOnItemContentLongClickListener() != null) {
                    IndexPartLayout.this.mRealAdapter.setOnItemContentLongClickListener(indexPartAdapter.getOnItemContentLongClickListener());
                }
            }
        };
        this.mDataSetObserver = r02;
        indexPartAdapter.registerDataSetObserver(r02);
        this.mRealAdapter.setIndexAdapter(indexPartAdapter);
        if (this.mSticyEnable) {
            initStickyView(indexPartAdapter);
        }
    }

    public <T extends IndexPartEntity> void setComparator(Comparator<EntityWrapper<T>> comparator) {
        this.mComparator = comparator;
    }

    public void setCompareMode(int i11) {
        this.mCompareMode = i11;
    }

    @Deprecated
    public void setFastCompare(boolean z11) {
        setCompareMode(z11 ^ true ? 1 : 0);
    }

    public void setIndexBarVisibility(boolean z11) {
        this.mIndexBar.setVisibility(z11 ? 0 : 8);
    }

    public void setIsShowListSticky(boolean z11) {
        this.mIsShowListSticky = z11;
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        Objects.requireNonNull(layoutManager, "LayoutManager == null");
        this.mLayoutManager = layoutManager;
        if (layoutManager instanceof GridLayoutManager) {
            final GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.t(new GridLayoutManager.SpanSizeLookup() {
                public int getSpanSize(int i11) {
                    if (IndexPartLayout.this.mRealAdapter.getItemViewType(i11) == 2147483646) {
                        return gridLayoutManager.k();
                    }
                    return IndexPartLayout.this.mRealAdapter.getItemViewType(i11) == Integer.MAX_VALUE ? 1 : 0;
                }
            });
        }
        this.mRecy.setLayoutManager(this.mLayoutManager);
    }

    public void setOverlayStyle_Center() {
        if (this.mCenterOverlay == null) {
            initCenterOverlay();
        }
        this.mMDOverlay = null;
    }

    public void setOverlayStyle_MaterialDesign(int i11) {
        TextView textView = this.mMDOverlay;
        if (textView == null) {
            initMDOverlay(i11);
        } else {
            h0.C0(textView, ColorStateList.valueOf(i11));
        }
        this.mCenterOverlay = null;
    }

    public void setStickyEnable(boolean z11) {
        this.mSticyEnable = z11;
    }

    public void showAllLetter(boolean z11) {
        this.mShowAllLetter = z11;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.util.List} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T extends com.huobi.view.indexlist.IndexPartEntity> java.util.ArrayList<com.huobi.view.indexlist.EntityWrapper<T>> transform(java.util.List<T> r10) {
        /*
            r9 = this;
            java.util.TreeMap r0 = new java.util.TreeMap     // Catch:{ Exception -> 0x00e4 }
            com.huobi.view.indexlist.IndexPartLayout$11 r1 = new com.huobi.view.indexlist.IndexPartLayout$11     // Catch:{ Exception -> 0x00e4 }
            r1.<init>()     // Catch:{ Exception -> 0x00e4 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x00e4 }
            r1 = 0
            r2 = r1
        L_0x000c:
            int r3 = r10.size()     // Catch:{ Exception -> 0x00e4 }
            r4 = 1
            if (r2 >= r3) goto L_0x00a7
            com.huobi.view.indexlist.EntityWrapper r3 = new com.huobi.view.indexlist.EntityWrapper     // Catch:{ Exception -> 0x00e4 }
            r3.<init>()     // Catch:{ Exception -> 0x00e4 }
            java.lang.Object r5 = r10.get(r2)     // Catch:{ Exception -> 0x00e4 }
            com.huobi.view.indexlist.IndexPartEntity r5 = (com.huobi.view.indexlist.IndexPartEntity) r5     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r6 = r5.getFieldIndexBy()     // Catch:{ Exception -> 0x00e4 }
            if (r6 == 0) goto L_0x005a
            int r7 = r6.length()     // Catch:{ Exception -> 0x00e4 }
            if (r7 < r4) goto L_0x005a
            java.util.Locale r4 = java.util.Locale.US     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r4 = r6.toUpperCase(r4)     // Catch:{ Exception -> 0x00e4 }
            char r4 = r4.charAt(r1)     // Catch:{ Exception -> 0x00e4 }
            r6 = 65
            if (r6 > r4) goto L_0x003c
            r6 = 90
            if (r4 <= r6) goto L_0x003e
        L_0x003c:
            r4 = 35
        L_0x003e:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e4 }
            r6.<init>()     // Catch:{ Exception -> 0x00e4 }
            r6.append(r4)     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r4 = ""
            r6.append(r4)     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r4 = r6.toString()     // Catch:{ Exception -> 0x00e4 }
            r3.setIndex(r4)     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r4 = r5.getFieldIndexBy()     // Catch:{ Exception -> 0x00e4 }
            r3.setIndexByField(r4)     // Catch:{ Exception -> 0x00e4 }
            goto L_0x0066
        L_0x005a:
            java.lang.String r4 = "#"
            r3.setIndex(r4)     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r4 = r5.getFieldIndexBy()     // Catch:{ Exception -> 0x00e4 }
            r3.setIndexByField(r4)     // Catch:{ Exception -> 0x00e4 }
        L_0x0066:
            java.lang.String r4 = r3.getIndex()     // Catch:{ Exception -> 0x00e4 }
            r3.setIndexTitle(r4)     // Catch:{ Exception -> 0x00e4 }
            r3.setData(r5)     // Catch:{ Exception -> 0x00e4 }
            r3.setOriginalPosition(r2)     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r4 = r3.getIndex()     // Catch:{ Exception -> 0x00e4 }
            boolean r5 = r0.containsKey(r4)     // Catch:{ Exception -> 0x00e4 }
            if (r5 != 0) goto L_0x0099
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ Exception -> 0x00e4 }
            r5.<init>()     // Catch:{ Exception -> 0x00e4 }
            boolean r6 = r9.mIsShowListSticky     // Catch:{ Exception -> 0x00e4 }
            if (r6 == 0) goto L_0x0095
            com.huobi.view.indexlist.EntityWrapper r6 = new com.huobi.view.indexlist.EntityWrapper     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r7 = r3.getIndex()     // Catch:{ Exception -> 0x00e4 }
            r8 = 2147483646(0x7ffffffe, float:NaN)
            r6.<init>(r7, r8)     // Catch:{ Exception -> 0x00e4 }
            r5.add(r6)     // Catch:{ Exception -> 0x00e4 }
        L_0x0095:
            r0.put(r4, r5)     // Catch:{ Exception -> 0x00e4 }
            goto L_0x00a0
        L_0x0099:
            java.lang.Object r4 = r0.get(r4)     // Catch:{ Exception -> 0x00e4 }
            r5 = r4
            java.util.List r5 = (java.util.List) r5     // Catch:{ Exception -> 0x00e4 }
        L_0x00a0:
            r5.add(r3)     // Catch:{ Exception -> 0x00e4 }
            int r2 = r2 + 1
            goto L_0x000c
        L_0x00a7:
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ Exception -> 0x00e4 }
            r10.<init>()     // Catch:{ Exception -> 0x00e4 }
            java.util.Collection r0 = r0.values()     // Catch:{ Exception -> 0x00e4 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x00e4 }
        L_0x00b4:
            boolean r1 = r0.hasNext()     // Catch:{ Exception -> 0x00e4 }
            if (r1 == 0) goto L_0x00e3
            java.lang.Object r1 = r0.next()     // Catch:{ Exception -> 0x00e4 }
            java.util.List r1 = (java.util.List) r1     // Catch:{ Exception -> 0x00e4 }
            java.util.Comparator r2 = r9.mComparator     // Catch:{ Exception -> 0x00e4 }
            if (r2 == 0) goto L_0x00c8
            java.util.Collections.sort(r1, r2)     // Catch:{ Exception -> 0x00e4 }
            goto L_0x00df
        L_0x00c8:
            int r2 = r9.mCompareMode     // Catch:{ Exception -> 0x00e4 }
            if (r2 != 0) goto L_0x00d5
            com.huobi.view.indexlist.InitialComparator r2 = new com.huobi.view.indexlist.InitialComparator     // Catch:{ Exception -> 0x00e4 }
            r2.<init>()     // Catch:{ Exception -> 0x00e4 }
            java.util.Collections.sort(r1, r2)     // Catch:{ Exception -> 0x00e4 }
            goto L_0x00df
        L_0x00d5:
            if (r2 != r4) goto L_0x00df
            com.huobi.view.indexlist.KeyIndexComparator r2 = new com.huobi.view.indexlist.KeyIndexComparator     // Catch:{ Exception -> 0x00e4 }
            r2.<init>()     // Catch:{ Exception -> 0x00e4 }
            java.util.Collections.sort(r1, r2)     // Catch:{ Exception -> 0x00e4 }
        L_0x00df:
            r10.addAll(r1)     // Catch:{ Exception -> 0x00e4 }
            goto L_0x00b4
        L_0x00e3:
            return r10
        L_0x00e4:
            r10 = move-exception
            r10.printStackTrace()
            r10 = 0
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.view.indexlist.IndexPartLayout.transform(java.util.List):java.util.ArrayList");
    }

    public IndexPartLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IndexPartLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.mShowAllLetter = true;
        this.pattern = Pattern.compile("[0-9]*");
        this.mSticyEnable = true;
        this.mCompareMode = 0;
        this.mIsShowListSticky = true;
        this.mHeaderFooterDataSetObserver = new HeaderFooterDataObserver<EntityWrapper>() {
            public void onChanged() {
                if (IndexPartLayout.this.mRealAdapter != null) {
                    IndexPartLayout.this.mRealAdapter.notifyDataSetChanged();
                }
            }

            public void onAdd(boolean z11, EntityWrapper entityWrapper, EntityWrapper entityWrapper2) {
                if (IndexPartLayout.this.mRealAdapter != null) {
                    IndexPartLayout.this.mRealAdapter.addHeaderFooterData(z11, entityWrapper, entityWrapper2);
                }
            }

            public void onRemove(boolean z11, EntityWrapper entityWrapper) {
                if (IndexPartLayout.this.mRealAdapter != null) {
                    IndexPartLayout.this.mRealAdapter.removeHeaderFooterData(z11, entityWrapper);
                }
            }
        };
        this.mIndexBarDataSetObserver = new IndexBarDataObserver() {
            public void onChanged() {
                IndexPartLayout.this.mIndexBar.setDatas(IndexPartLayout.this.mShowAllLetter, IndexPartLayout.this.mRealAdapter.getItems());
            }
        };
        init(context, attributeSet);
    }
}
