package com.tencent.qcloud.tuikit.timcommon.component;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuikit.timcommon.R;
import com.tencent.qcloud.tuikit.timcommon.component.interfaces.ITitleBarLayout;

public class TitleBarLayout extends LinearLayout implements ITitleBarLayout {
    private boolean isCustomer = false;
    private TextView mCenterTitle;
    private LinearLayout mExtralGroup;
    private ImageView mExtralIcon;
    private LinearLayout mLeftGroup;
    private ImageView mLeftIcon;
    private TextView mLeftTitle;
    private TextView mPageTitleExtra;
    private LinearLayout mRightGroup;
    private ImageView mRightIcon;
    private TextView mRightTitle;
    private RelativeLayout mTitleLayout;
    private UnreadCountTextView unreadCountTextView;

    /* renamed from: com.tencent.qcloud.tuikit.timcommon.component.TitleBarLayout$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$com$tencent$qcloud$tuikit$timcommon$component$interfaces$ITitleBarLayout$Position;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.tencent.qcloud.tuikit.timcommon.component.interfaces.ITitleBarLayout$Position[] r0 = com.tencent.qcloud.tuikit.timcommon.component.interfaces.ITitleBarLayout.Position.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$tencent$qcloud$tuikit$timcommon$component$interfaces$ITitleBarLayout$Position = r0
                com.tencent.qcloud.tuikit.timcommon.component.interfaces.ITitleBarLayout$Position r1 = com.tencent.qcloud.tuikit.timcommon.component.interfaces.ITitleBarLayout.Position.LEFT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$tencent$qcloud$tuikit$timcommon$component$interfaces$ITitleBarLayout$Position     // Catch:{ NoSuchFieldError -> 0x001d }
                com.tencent.qcloud.tuikit.timcommon.component.interfaces.ITitleBarLayout$Position r1 = com.tencent.qcloud.tuikit.timcommon.component.interfaces.ITitleBarLayout.Position.RIGHT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$tencent$qcloud$tuikit$timcommon$component$interfaces$ITitleBarLayout$Position     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.tencent.qcloud.tuikit.timcommon.component.interfaces.ITitleBarLayout$Position r1 = com.tencent.qcloud.tuikit.timcommon.component.interfaces.ITitleBarLayout.Position.MIDDLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$tencent$qcloud$tuikit$timcommon$component$interfaces$ITitleBarLayout$Position     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.tencent.qcloud.tuikit.timcommon.component.interfaces.ITitleBarLayout$Position r1 = com.tencent.qcloud.tuikit.timcommon.component.interfaces.ITitleBarLayout.Position.EXTRAL     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuikit.timcommon.component.TitleBarLayout.AnonymousClass2.<clinit>():void");
        }
    }

    public TitleBarLayout(Context context) {
        super(context);
        init(context, (AttributeSet) null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        String str;
        boolean z11 = false;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TitleBarLayout);
            str = obtainStyledAttributes.getString(R.styleable.TitleBarLayout_title_bar_middle_title);
            z11 = obtainStyledAttributes.getBoolean(R.styleable.TitleBarLayout_title_bar_can_return, false);
            obtainStyledAttributes.recycle();
        } else {
            str = null;
        }
        LinearLayout.inflate(getContext(), R.layout.title_bar_layout, this);
        this.mTitleLayout = (RelativeLayout) findViewById(R.id.page_title_layout);
        this.mLeftGroup = (LinearLayout) findViewById(R.id.page_title_left_group);
        this.mExtralGroup = (LinearLayout) findViewById(R.id.page_title_extral_group);
        this.mRightGroup = (LinearLayout) findViewById(R.id.page_title_right_group);
        this.mLeftTitle = (TextView) findViewById(R.id.page_title_left_text);
        this.mRightTitle = (TextView) findViewById(R.id.page_title_right_text);
        this.mCenterTitle = (TextView) findViewById(R.id.page_title);
        this.mPageTitleExtra = (TextView) findViewById(R.id.page_title_extra);
        this.mLeftIcon = (ImageView) findViewById(R.id.page_title_left_icon);
        this.mExtralIcon = (ImageView) findViewById(R.id.page_title_extral_icon);
        this.mRightIcon = (ImageView) findViewById(R.id.page_title_right_icon);
        this.unreadCountTextView = (UnreadCountTextView) findViewById(R.id.new_message_total_unread);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mTitleLayout.getLayoutParams();
        layoutParams.height = ScreenUtil.getPxByDp(50.0f);
        this.mTitleLayout.setLayoutParams(layoutParams);
        setBackgroundResource(TUIThemeManager.getAttrResId(getContext(), R.attr.core_title_bar_bg));
        int dip2px = ScreenUtil.dip2px(20.0f);
        int dip2px2 = ScreenUtil.dip2px(16.0f);
        ViewGroup.LayoutParams layoutParams2 = this.mLeftIcon.getLayoutParams();
        layoutParams2.width = dip2px2;
        layoutParams2.height = dip2px2;
        this.mLeftIcon.setLayoutParams(layoutParams2);
        ViewGroup.LayoutParams layoutParams3 = this.mRightIcon.getLayoutParams();
        layoutParams3.width = dip2px;
        layoutParams3.height = dip2px;
        this.mRightIcon.setLayoutParams(layoutParams3);
        if (z11) {
            setLeftReturnListener(context);
        }
        if (!TextUtils.isEmpty(str)) {
            this.mCenterTitle.setText(str);
        }
    }

    public TextView getExtraTitle() {
        return this.mPageTitleExtra;
    }

    public LinearLayout getExtralGroup() {
        return this.mExtralGroup;
    }

    public LinearLayout getLeftGroup() {
        return this.mLeftGroup;
    }

    public ImageView getLeftIcon() {
        return this.mLeftIcon;
    }

    public TextView getLeftTitle() {
        return this.mLeftTitle;
    }

    public TextView getMiddleTitle() {
        return this.mCenterTitle;
    }

    public LinearLayout getRightGroup() {
        return this.mRightGroup;
    }

    public ImageView getRightIcon() {
        return this.mRightIcon;
    }

    public TextView getRightTitle() {
        return this.mRightTitle;
    }

    public RelativeLayout getTitleLayout() {
        return this.mTitleLayout;
    }

    public UnreadCountTextView getUnreadCountTextView() {
        return this.unreadCountTextView;
    }

    public void setCustomer(String str) {
        this.isCustomer = true;
        this.mCenterTitle.setText(str);
    }

    public void setExtralIcon(int i11) {
        this.mExtralIcon.setBackgroundResource(i11);
    }

    public void setLeftIcon(int i11) {
        this.mLeftIcon.setBackgroundResource(i11);
    }

    public void setLeftReturnListener(final Context context) {
        this.mLeftGroup.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                if (context instanceof Activity) {
                    ((InputMethodManager) TitleBarLayout.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(TitleBarLayout.this.getWindowToken(), 0);
                    ((Activity) context).finish();
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
    }

    public void setOnExtralClickListener(View.OnClickListener onClickListener) {
        this.mExtralGroup.setOnClickListener(onClickListener);
    }

    public void setOnLeftClickListener(View.OnClickListener onClickListener) {
        this.mLeftGroup.setOnClickListener(onClickListener);
    }

    public void setOnRightClickListener(View.OnClickListener onClickListener) {
        this.mRightGroup.setOnClickListener(onClickListener);
    }

    public void setRightIcon(int i11) {
        this.mRightIcon.setBackgroundResource(i11);
    }

    public void setTitle(String str, ITitleBarLayout.Position position) {
        if (!this.isCustomer) {
            int i11 = AnonymousClass2.$SwitchMap$com$tencent$qcloud$tuikit$timcommon$component$interfaces$ITitleBarLayout$Position[position.ordinal()];
            if (i11 == 1) {
                this.mLeftTitle.setText(str);
            } else if (i11 == 2) {
                this.mRightTitle.setText(str);
            } else if (i11 == 3) {
                this.mCenterTitle.setText(str);
            } else if (i11 == 4) {
                this.mPageTitleExtra.setText(str);
            }
        }
    }

    public TitleBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public TitleBarLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(context, attributeSet);
    }
}
