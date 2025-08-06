package com.huochat.community.widget.expandable;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.huobi.view.roundimg.RoundedDrawable;
import com.huochat.community.R;
import com.huochat.community.util.DisplayTool;
import com.huochat.community.util.UrlParamTool;
import com.huochat.community.widget.expandable.FormatData;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpandableTextView extends AppCompatTextView {
    private static final int DEF_MAX_LINE = 4;
    private static final StatusType DEF_STATUS_TYPE = StatusType.STATUS_EXPAND;
    private static final String IMAGE_TARGET = "图";
    public static final String REGEXP_MENTION = "#\\S*?#";
    public static final String SELF_REGEX = "\\[([^\\[]*)\\]\\(([^\\(]*)\\)";
    private static final String SPACE = " ";
    private static final String TARGET = "图网页链接";
    private static final String TEXT_TARGET = "网页链接";
    private final CommentTextViewTouchListener commentTextViewTouchListener;
    private int currentLines;
    /* access modifiers changed from: private */
    public OnExpandOrContractClickListener expandOrContractClickListener;
    /* access modifiers changed from: private */
    public boolean hasInit;
    private boolean isTitleBold;
    /* access modifiers changed from: private */
    public OnLinkClickListener linkClickListener;
    public boolean linkHit;
    private int mArrowHeight;
    private int mArrowWidth;
    /* access modifiers changed from: private */
    public CharSequence mContent;
    private int mContentMaxLimitLines;
    /* access modifiers changed from: private */
    public Context mContext;
    private Drawable mContractArrowDrawable;
    private int mContractArrowIconRes;
    private OnExpandableContractChangedListener mContractChangedListener;
    /* access modifiers changed from: private */
    public String mContractString;
    /* access modifiers changed from: private */
    public int mContractTextColor;
    private int mDefExpandableTextWidth;
    private int mDiffLines;
    private DynamicLayout mDynamicLayout;
    private String mEndExpandContent;
    private int mEndExpandTextColor;
    private Drawable mExpandArrowDrawable;
    private int mExpandArrowIconRes;
    /* access modifiers changed from: private */
    public String mExpandString;
    /* access modifiers changed from: private */
    public int mExpandTextColor;
    private ExpandableLabelSpan mExpandableLabelSpan;
    private FormatData mFormatData;
    private boolean mIsNeedPrefixLabelShow;
    private int mLineCount;
    private Drawable mLinkDrawable;
    /* access modifiers changed from: private */
    public int mLinkTextColor;
    /* access modifiers changed from: private */
    public int mMentionTextColor;
    /* access modifiers changed from: private */
    public ExpandableStatusFix mModel;
    private boolean mNeedAlwaysShowRight;
    private boolean mNeedAnimation;
    private boolean mNeedContract;
    private boolean mNeedConvertUrl;
    private boolean mNeedExpend;
    private boolean mNeedLink;
    private boolean mNeedLinkRes;
    private boolean mNeedMention;
    private boolean mNeedPartContentMention;
    private boolean mNeedSelf;
    private boolean mNeedShowPrefixMarkIcon;
    private boolean mNeedShowRightArrowIcon;
    private boolean mNeedTitle;
    private TextPaint mPaint;
    private int mPrefixLabelBgColor;
    private Drawable mPrefixLabelIconDrawable;
    private int mPrefixLabelIconHeight;
    private int mPrefixLabelIconRes;
    private int mPrefixLabelIconWidth;
    private int mPrefixLabelRadius;
    private String mPrefixLabelText;
    private int mPrefixLabelTextColor;
    private int mPrefixLabelTextMaxLength;
    private float mPrefixLabelTextSize;
    private Drawable mPrefixMarkDrawable;
    private int mPrefixMarkHeight;
    private int mPrefixMarkRes;
    private int mPrefixMarkWidth;
    /* access modifiers changed from: private */
    public int mSelfTextColor;
    private CharSequence mTitle;
    private int mTitleTextColor;
    private int mTitleTextSize;
    private String mTopicText;
    /* access modifiers changed from: private */
    public int mWidth;
    /* access modifiers changed from: private */
    public StatusType mcurStatus;
    /* access modifiers changed from: private */
    public boolean needRealExpandOrContract;
    private OnGetLineCountListener onGetLineCountListener;
    public ViewTreeObserver.OnPreDrawListener onPreDrawListener;
    private List<FormatData.PositionData> partContentMention;
    private int retryTime;

    /* renamed from: com.huochat.community.widget.expandable.ExpandableTextView$7  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass7 {
        public static final /* synthetic */ int[] $SwitchMap$com$huochat$community$widget$expandable$LinkType;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.huochat.community.widget.expandable.LinkType[] r0 = com.huochat.community.widget.expandable.LinkType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$huochat$community$widget$expandable$LinkType = r0
                com.huochat.community.widget.expandable.LinkType r1 = com.huochat.community.widget.expandable.LinkType.PREFIX_MARK     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$huochat$community$widget$expandable$LinkType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huochat.community.widget.expandable.LinkType r1 = com.huochat.community.widget.expandable.LinkType.PREFIX_LABEL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$huochat$community$widget$expandable$LinkType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.huochat.community.widget.expandable.LinkType r1 = com.huochat.community.widget.expandable.LinkType.TITLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$huochat$community$widget$expandable$LinkType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.huochat.community.widget.expandable.LinkType r1 = com.huochat.community.widget.expandable.LinkType.LINK_TYPE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$huochat$community$widget$expandable$LinkType     // Catch:{ NoSuchFieldError -> 0x003e }
                com.huochat.community.widget.expandable.LinkType r1 = com.huochat.community.widget.expandable.LinkType.MENTION_TYPE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$huochat$community$widget$expandable$LinkType     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.huochat.community.widget.expandable.LinkType r1 = com.huochat.community.widget.expandable.LinkType.SELF     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huochat.community.widget.expandable.ExpandableTextView.AnonymousClass7.<clinit>():void");
        }
    }

    public interface OnExpandOrContractClickListener {
        void onClick(StatusType statusType);
    }

    public interface OnGetLineCountListener {
        void onGetLineCount(int i11, boolean z11);
    }

    public interface OnLinkClickListener {
        void onLinkClickListener(LinkType linkType, String str, String str2);
    }

    public static class SelfImageSpan extends ImageSpan {
        private final Drawable drawable;

        public SelfImageSpan(Drawable drawable2, int i11) {
            super(drawable2, i11);
            this.drawable = drawable2;
        }

        public void draw(Canvas canvas, CharSequence charSequence, int i11, int i12, float f11, int i13, int i14, int i15, Paint paint) {
            Drawable drawable2 = getDrawable();
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            canvas.save();
            canvas.translate(f11, (float) (((((fontMetricsInt.descent + i14) + i14) + fontMetricsInt.ascent) / 2) - (drawable2.getBounds().bottom / 2)));
            drawable2.draw(canvas);
            canvas.restore();
        }

        public Drawable getDrawable() {
            return this.drawable;
        }
    }

    public ExpandableTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    public void action() {
        action((StatusType) null);
    }

    private void addMention(SpannableStringBuilder spannableStringBuilder, final FormatData.PositionData positionData, int i11) {
        try {
            spannableStringBuilder.setSpan(new ClickableSpan() {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    if (ExpandableTextView.this.linkClickListener != null) {
                        ExpandableTextView.this.linkClickListener.onLinkClickListener(LinkType.MENTION_TYPE, positionData.getUrl(), (String) null);
                    }
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }

                public void updateDrawState(TextPaint textPaint) {
                    textPaint.setColor(ExpandableTextView.this.mMentionTextColor);
                    textPaint.setUnderlineText(false);
                }
            }, positionData.getStart(), i11, 17);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    private void addSelf(SpannableStringBuilder spannableStringBuilder, final FormatData.PositionData positionData, int i11) {
        spannableStringBuilder.setSpan(new ClickableSpan() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                if (ExpandableTextView.this.linkClickListener != null) {
                    ExpandableTextView.this.linkClickListener.onLinkClickListener(LinkType.SELF, positionData.getSelfAim(), positionData.getSelfContent());
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }

            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(ExpandableTextView.this.mSelfTextColor);
                textPaint.setUnderlineText(false);
            }
        }, positionData.getStart(), i11, 17);
    }

    private void addTitle(SpannableStringBuilder spannableStringBuilder, FormatData.PositionData positionData, int i11) {
        if (this.isTitleBold) {
            spannableStringBuilder.setSpan(new StyleSpan(1), positionData.getStart(), i11, 17);
        }
        spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mTitleTextColor), positionData.getStart(), i11, 17);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(this.mTitleTextSize, false), positionData.getStart(), i11, 17);
    }

    private void addUrl(SpannableStringBuilder spannableStringBuilder, final FormatData.PositionData positionData, int i11) {
        spannableStringBuilder.setSpan(new ClickableSpan() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                if (ExpandableTextView.this.linkClickListener != null) {
                    ExpandableTextView.this.linkClickListener.onLinkClickListener(LinkType.LINK_TYPE, positionData.getUrl(), (String) null);
                } else {
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setFlags(268435456);
                    intent.setData(Uri.parse(positionData.getUrl()));
                    ExpandableTextView.this.mContext.startActivity(intent);
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }

            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(ExpandableTextView.this.mLinkTextColor);
                textPaint.setUnderlineText(false);
            }
        }, positionData.getStart() + 1, i11, 17);
    }

    private Spannable convertLinkSpan(CharSequence charSequence) {
        Spannable spannable;
        if (charSequence instanceof Spannable) {
            spannable = (Spannable) charSequence;
        } else {
            spannable = new SpannableString(charSequence);
        }
        List<UrlParamTool.UrlResult> applyFilter = UrlParamTool.applyFilter(charSequence.toString());
        if (applyFilter != null && applyFilter.size() > 0) {
            for (UrlParamTool.UrlResult next : applyFilter) {
                spannable.setSpan(new TextLinkSpan(next.url), next.start, next.end, 33);
            }
        }
        return spannable;
    }

    /* access modifiers changed from: private */
    public void correctWidthByDefault(String str) {
        if (this.mWidth <= 0) {
            this.mWidth = this.mDefExpandableTextWidth;
        }
    }

    private SpannableStringBuilder dealLink(FormatData formatData, boolean z11, String str) {
        int i11;
        String str2;
        float f11;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mcurStatus.equals(StatusType.STATUS_CONTRACT)) {
            int i12 = this.mContentMaxLimitLines;
            int i13 = this.mDiffLines;
            this.currentLines = (i12 - i13) + (this.mLineCount - i12) + i13;
        } else if (this.mNeedContract) {
            this.currentLines = this.mContentMaxLimitLines - this.mDiffLines;
        }
        if (z11) {
            float measureText = this.mPaint.measureText(SPACE);
            if (!this.mNeedShowRightArrowIcon || measureText <= 0.0f) {
                str2 = "";
                f11 = 0.0f;
            } else {
                StringBuilder sb2 = new StringBuilder("");
                int i14 = this.mArrowWidth;
                int i15 = ((float) i14) < measureText ? 2 : ((int) ((((float) i14) + measureText) / measureText)) + 1;
                f11 = 0.0f;
                for (int i16 = 0; i16 < i15; i16++) {
                    sb2.append(SPACE);
                    f11 += measureText;
                }
                str2 = sb2.toString();
            }
            int i17 = this.currentLines;
            if (i17 < this.mLineCount) {
                int i18 = i17 - 1;
                int lineEnd = this.mDynamicLayout.getLineEnd(i18);
                int lineStart = this.mDynamicLayout.getLineStart(i18);
                float lineWidth = this.mDynamicLayout.getLineWidth(i18);
                String hideEndContent = getHideEndContent();
                String str3 = hideEndContent;
                int i19 = i18;
                String str4 = str2;
                String substring = formatData.getFormatedContent().substring(0, getFitPosition(hideEndContent + str2, lineEnd, lineStart, lineWidth, this.mPaint.measureText(hideEndContent) + f11, 0.0f));
                if (substring.endsWith("\n")) {
                    substring = substring.substring(0, substring.length() - 1);
                }
                spannableStringBuilder.append(substring);
                if (this.mNeedAlwaysShowRight) {
                    float f12 = 0.0f;
                    for (int i21 = 0; i21 < i19; i21++) {
                        f12 += this.mDynamicLayout.getLineWidth(i21);
                    }
                    float measureText2 = ((f12 / ((float) i19)) - lineWidth) - this.mPaint.measureText(str3);
                    if (measureText2 > 0.0f) {
                        int i22 = 0;
                        while (((float) i22) * measureText < measureText2) {
                            i22++;
                        }
                        int i23 = i22 - 1;
                        for (int i24 = 0; i24 < i23; i24++) {
                            spannableStringBuilder.append(SPACE);
                        }
                    }
                }
                SpannableString spannableString = new SpannableString(str3);
                spannableString.setSpan(new ForegroundColorSpan(this.mExpandTextColor), spannableString.length() - this.mExpandString.length(), spannableString.length(), 17);
                spannableStringBuilder.append(spannableString);
                int length = TextUtils.isEmpty(this.mEndExpandContent) ? 0 : this.mEndExpandContent.length() + 2;
                spannableStringBuilder.setSpan(new ClickableSpan() {
                    @SensorsDataInstrumented
                    public void onClick(View view) {
                        if (ExpandableTextView.this.expandOrContractClickListener != null) {
                            ExpandableTextView.this.expandOrContractClickListener.onClick(StatusType.STATUS_EXPAND);
                        }
                        if (TextUtils.isEmpty(ExpandableTextView.this.mExpandString)) {
                            SensorsDataAutoTrackHelper.trackViewOnClick(view);
                            return;
                        }
                        if (ExpandableTextView.this.needRealExpandOrContract) {
                            if (ExpandableTextView.this.mModel != null) {
                                ExpandableTextView.this.mModel.setStatus(StatusType.STATUS_CONTRACT);
                                ExpandableTextView expandableTextView = ExpandableTextView.this;
                                expandableTextView.action(expandableTextView.mModel.getStatus());
                            } else {
                                StatusType unused = ExpandableTextView.this.mcurStatus = StatusType.STATUS_CONTRACT;
                                ExpandableTextView.this.action();
                            }
                        }
                        SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    }

                    public void updateDrawState(TextPaint textPaint) {
                        super.updateDrawState(textPaint);
                        if (!TextUtils.isEmpty(ExpandableTextView.this.mExpandString)) {
                            textPaint.setColor(ExpandableTextView.this.mExpandTextColor);
                            textPaint.setUnderlineText(false);
                        }
                    }
                }, (spannableStringBuilder.length() - this.mExpandString.length()) - length, spannableStringBuilder.length(), 17);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mExpandTextColor), (spannableStringBuilder.length() - this.mExpandString.length()) - length, spannableStringBuilder.length(), 17);
                if (this.mNeedShowRightArrowIcon) {
                    String str5 = str4;
                    spannableStringBuilder.append(str5);
                    spannableStringBuilder.setSpan(new SelfImageSpan(this.mExpandArrowDrawable, 1), (spannableStringBuilder.length() - str5.length()) + 1, spannableStringBuilder.length(), 18);
                }
                OnExpandableContractChangedListener onExpandableContractChangedListener = this.mContractChangedListener;
                if (onExpandableContractChangedListener != null) {
                    onExpandableContractChangedListener.onContractChanged(true, StatusType.STATUS_EXPAND);
                }
            } else {
                String str6 = str2;
                spannableStringBuilder.append(formatData.getFormatedContent());
                if (this.mNeedContract) {
                    String expandEndContent = getExpandEndContent();
                    if (this.mNeedAlwaysShowRight) {
                        int lineCount = this.mDynamicLayout.getLineCount() - 1;
                        float lineWidth2 = this.mDynamicLayout.getLineWidth(lineCount);
                        float f13 = 0.0f;
                        for (int i25 = 0; i25 < lineCount; i25++) {
                            f13 += this.mDynamicLayout.getLineWidth(i25);
                        }
                        float measureText3 = (((f13 / ((float) lineCount)) - lineWidth2) - this.mPaint.measureText(expandEndContent)) - f11;
                        if (measureText3 > 0.0f) {
                            int i26 = 0;
                            while (((float) i26) * measureText < measureText3) {
                                i26++;
                            }
                            int i27 = i26 - 1;
                            for (int i28 = 0; i28 < i27; i28++) {
                                spannableStringBuilder.append(SPACE);
                            }
                        }
                    }
                    SpannableString spannableString2 = new SpannableString(expandEndContent);
                    spannableString2.setSpan(new ForegroundColorSpan(this.mContractTextColor), spannableString2.length() - this.mContractString.length(), spannableString2.length(), 17);
                    spannableStringBuilder.append(spannableString2);
                    int length2 = TextUtils.isEmpty(this.mEndExpandContent) ? 0 : this.mEndExpandContent.length() + 2;
                    spannableStringBuilder.setSpan(new ClickableSpan() {
                        @SensorsDataInstrumented
                        public void onClick(View view) {
                            if (ExpandableTextView.this.expandOrContractClickListener != null) {
                                ExpandableTextView.this.expandOrContractClickListener.onClick(StatusType.STATUS_CONTRACT);
                            }
                            if (TextUtils.isEmpty(ExpandableTextView.this.mContractString)) {
                                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                                return;
                            }
                            if (ExpandableTextView.this.mModel != null) {
                                ExpandableTextView.this.mModel.setStatus(StatusType.STATUS_EXPAND);
                                ExpandableTextView expandableTextView = ExpandableTextView.this;
                                expandableTextView.action(expandableTextView.mModel.getStatus());
                            } else {
                                StatusType unused = ExpandableTextView.this.mcurStatus = StatusType.STATUS_EXPAND;
                                ExpandableTextView.this.action();
                            }
                            SensorsDataAutoTrackHelper.trackViewOnClick(view);
                        }

                        public void updateDrawState(TextPaint textPaint) {
                            super.updateDrawState(textPaint);
                            if (!TextUtils.isEmpty(ExpandableTextView.this.mContractString)) {
                                textPaint.setColor(ExpandableTextView.this.mContractTextColor);
                                textPaint.setUnderlineText(false);
                            }
                        }
                    }, (spannableStringBuilder.length() - this.mContractString.length()) - length2, spannableStringBuilder.length(), 17);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContractTextColor), (spannableStringBuilder.length() - this.mContractString.length()) - length2, spannableStringBuilder.length(), 17);
                    if (this.mNeedShowRightArrowIcon) {
                        spannableStringBuilder.append(str6);
                        spannableStringBuilder.setSpan(new SelfImageSpan(this.mContractArrowDrawable, 1), (spannableStringBuilder.length() - str6.length()) + 1, spannableStringBuilder.length(), 18);
                    }
                    OnExpandableContractChangedListener onExpandableContractChangedListener2 = this.mContractChangedListener;
                    if (onExpandableContractChangedListener2 != null) {
                        onExpandableContractChangedListener2.onContractChanged(true, StatusType.STATUS_CONTRACT);
                    }
                } else {
                    if (!TextUtils.isEmpty(this.mEndExpandContent)) {
                        spannableStringBuilder.append(this.mEndExpandContent);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mEndExpandTextColor), spannableStringBuilder.length() - this.mEndExpandContent.length(), spannableStringBuilder.length(), 17);
                    }
                    OnExpandableContractChangedListener onExpandableContractChangedListener3 = this.mContractChangedListener;
                    if (onExpandableContractChangedListener3 != null) {
                        onExpandableContractChangedListener3.onContractChanged(false, StatusType.STATUS_CONTRACT);
                    }
                }
            }
        } else {
            spannableStringBuilder.append(formatData.getFormatedContent());
            if (!TextUtils.isEmpty(this.mEndExpandContent)) {
                spannableStringBuilder.append(this.mEndExpandContent);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mEndExpandTextColor), spannableStringBuilder.length() - this.mEndExpandContent.length(), spannableStringBuilder.length(), 17);
            }
            OnExpandableContractChangedListener onExpandableContractChangedListener4 = this.mContractChangedListener;
            if (onExpandableContractChangedListener4 != null) {
                onExpandableContractChangedListener4.onContractChanged(false, StatusType.STATUS_EXPAND);
            }
        }
        for (FormatData.PositionData next : formatData.getPositionDatas()) {
            if (spannableStringBuilder.length() >= next.getEnd()) {
                switch (AnonymousClass7.$SwitchMap$com$huochat$community$widget$expandable$LinkType[next.getType().ordinal()]) {
                    case 1:
                        spannableStringBuilder.setSpan(new SelfImageSpan(this.mPrefixMarkDrawable, 1), next.getStart(), next.getEnd() - 1, 18);
                        continue;
                    case 2:
                        spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) this.mPrefixLabelTextSize), next.getStart(), next.getEnd(), 33);
                        spannableStringBuilder.setSpan(getExpandableLabelSpan(), next.getStart(), next.getEnd(), 33);
                        break;
                    case 3:
                        if (this.mNeedExpend && z11) {
                            int length3 = spannableStringBuilder.length() - getHideEndContent().length();
                            if (next.getStart() < length3) {
                                int end = next.getEnd();
                                if (this.currentLines >= this.mLineCount || length3 >= next.getEnd()) {
                                    length3 = end;
                                }
                                addTitle(spannableStringBuilder, next, length3);
                                break;
                            }
                        } else {
                            addTitle(spannableStringBuilder, next, next.getEnd());
                            break;
                        }
                        break;
                    case 4:
                        if (this.mNeedExpend && z11) {
                            int length4 = spannableStringBuilder.length() - getHideEndContent().length();
                            if (next.getStart() < length4) {
                                spannableStringBuilder.setSpan(new SelfImageSpan(this.mLinkDrawable, 1), next.getStart(), next.getStart() + 1, 18);
                                int end2 = next.getEnd();
                                if (this.currentLines < this.mLineCount && length4 > next.getStart() + 1 && length4 < next.getEnd()) {
                                    end2 = length4;
                                }
                                if (next.getStart() + 1 < length4) {
                                    addUrl(spannableStringBuilder, next, end2);
                                    break;
                                }
                            }
                        } else {
                            spannableStringBuilder.setSpan(new SelfImageSpan(this.mLinkDrawable, 1), next.getStart(), next.getStart() + 1, 18);
                            addUrl(spannableStringBuilder, next, next.getEnd());
                            break;
                        }
                        break;
                    case 5:
                        if (this.mNeedExpend && z11) {
                            int length5 = spannableStringBuilder.length() - getHideEndContent().length();
                            if (next.getStart() < length5) {
                                int end3 = next.getEnd();
                                if (this.currentLines >= this.mLineCount || length5 >= next.getEnd()) {
                                    length5 = end3;
                                }
                                addMention(spannableStringBuilder, next, length5);
                                break;
                            }
                        } else {
                            addMention(spannableStringBuilder, next, next.getEnd());
                            break;
                        }
                        break;
                    case 6:
                        if (this.mNeedExpend && z11) {
                            int length6 = spannableStringBuilder.length() - getHideEndContent().length();
                            if (next.getStart() < length6) {
                                int end4 = next.getEnd();
                                if (this.currentLines >= this.mLineCount || length6 >= next.getEnd()) {
                                    length6 = end4;
                                }
                                addSelf(spannableStringBuilder, next, length6);
                                break;
                            }
                        } else {
                            addSelf(spannableStringBuilder, next, next.getEnd());
                            break;
                        }
                        break;
                }
            } else if (next.getType().equals(LinkType.MENTION_TYPE)) {
                if (!this.mNeedExpend || !z11) {
                    i11 = spannableStringBuilder.length();
                } else {
                    i11 = spannableStringBuilder.length() - getHideEndContent().length();
                }
                if (next.getStart() < i11) {
                    int end5 = next.getEnd();
                    if (i11 >= next.getEnd()) {
                        i11 = end5;
                    }
                    addMention(spannableStringBuilder, next, i11);
                }
            }
        }
        setHighlightColor(0);
        return spannableStringBuilder;
    }

    private void doSetContent(CharSequence charSequence, String str) {
        this.currentLines = this.mContentMaxLimitLines - this.mDiffLines;
        if (TextUtils.isEmpty(charSequence)) {
            setText("");
        } else if (this.mWidth <= 0) {
            post(new c(this, charSequence, str));
        } else {
            setText(getRealContent(charSequence, str));
            this.retryTime = 0;
        }
    }

    @SuppressLint({"RestrictedApi"})
    private FormatData formatData(CharSequence charSequence) {
        int i11;
        int i12;
        CharSequence charSequence2;
        int i13;
        int i14;
        List<FormatData.PositionData> list;
        String str;
        FormatData formatData = new FormatData();
        ArrayList arrayList = new ArrayList();
        StringBuilder sb2 = new StringBuilder();
        HashMap hashMap = new HashMap();
        StringBuilder sb3 = new StringBuilder();
        if (this.mNeedShowPrefixMarkIcon) {
            StringBuilder sb4 = new StringBuilder();
            String spaceStr = getSpaceStr(getSpaceCount((float) this.mPrefixMarkWidth));
            sb4.append(spaceStr);
            i11 = spaceStr.length();
            arrayList.add(new FormatData.PositionData(0, i11, sb4.toString(), LinkType.PREFIX_MARK));
            sb2.append(sb4);
            sb3.append(sb4);
            i12 = i11;
        } else {
            i12 = 0;
            i11 = 0;
        }
        if (this.mIsNeedPrefixLabelShow) {
            StringBuilder sb5 = new StringBuilder();
            if (!TextUtils.isEmpty(this.mPrefixLabelText)) {
                int length = this.mPrefixLabelText.length();
                int i15 = this.mPrefixLabelTextMaxLength;
                if (length > i15) {
                    this.mPrefixLabelText = this.mPrefixLabelText.substring(0, i15);
                }
                String str2 = this.mPrefixLabelText + SPACE;
                this.mPrefixLabelText = str2;
                int length2 = str2.length() + i11;
                arrayList.add(new FormatData.PositionData(i11, length2 - 1, this.mPrefixLabelText, LinkType.PREFIX_LABEL));
                sb2.append(this.mPrefixLabelText);
                sb5.append(this.mPrefixLabelText);
                i11 = length2;
            }
            sb3.append(sb5);
            charSequence2 = charSequence;
            i12 = i11;
        } else {
            charSequence2 = charSequence;
        }
        sb3.append(charSequence2);
        if (this.mNeedTitle) {
            if (TextUtils.isEmpty(this.mTitle)) {
                str = "";
            } else {
                str = this.mTitle.toString();
            }
            i13 = str.length() + i12;
            arrayList.add(new FormatData.PositionData(i12, i13, str, LinkType.TITLE));
            sb2.append(str);
            i11 = i13;
        } else {
            i13 = 0;
        }
        Matcher matcher = Pattern.compile(SELF_REGEX, 2).matcher(sb3);
        if (this.mNeedSelf) {
            ArrayList arrayList2 = new ArrayList();
            while (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end();
                sb2.append(sb3.toString().substring(i13, start));
                String group = matcher.group();
                if (!TextUtils.isEmpty(group)) {
                    String substring = group.substring(group.indexOf("[") + 1, group.indexOf("]"));
                    String substring2 = group.substring(group.indexOf("(") + 1, group.indexOf(")"));
                    String uuid = UUIDUtils.getUuid(substring.length());
                    arrayList2.add(new FormatData.PositionData(sb2.length() + 1, sb2.length() + 2 + substring.length(), substring, substring2, LinkType.SELF));
                    hashMap.put(uuid, substring);
                    sb2.append(SPACE + uuid + SPACE);
                    i13 = end;
                }
                i11 = end;
            }
            arrayList.addAll(arrayList2);
        }
        sb2.append(sb3.toString().substring(i11));
        String sb6 = sb2.toString();
        StringBuilder sb7 = new StringBuilder();
        sb7.append(sb6.toString().substring(0));
        if (!TextUtils.isEmpty(this.mTopicText)) {
            arrayList.add(new FormatData.PositionData(i12, this.mTopicText.length() + i12 + 1, "", LinkType.MENTION_TYPE));
        }
        if (this.mNeedMention) {
            Matcher matcher2 = Pattern.compile(REGEXP_MENTION, 2).matcher(sb7.toString());
            ArrayList arrayList3 = new ArrayList();
            while (matcher2.find()) {
                arrayList3.add(new FormatData.PositionData(matcher2.start(), matcher2.end(), matcher2.group(), LinkType.MENTION_TYPE));
            }
            i14 = 0;
            arrayList.addAll(0, arrayList3);
        } else {
            i14 = 0;
        }
        if (this.mNeedPartContentMention && (list = this.partContentMention) != null && list.size() > 0) {
            arrayList.addAll(i14, this.partContentMention);
        }
        if (!hashMap.isEmpty()) {
            String sb8 = sb7.toString();
            for (Map.Entry entry : hashMap.entrySet()) {
                sb8 = sb8.replaceAll((String) entry.getKey(), (String) entry.getValue());
            }
            sb7 = new StringBuilder(sb8);
        }
        formatData.setFormatedContent(sb7.toString());
        formatData.setPositionDatas(arrayList);
        return formatData;
    }

    private String getExpandEndContent() {
        if (TextUtils.isEmpty(this.mEndExpandContent)) {
            return String.format(Locale.getDefault(), "  %s", new Object[]{this.mContractString});
        }
        return String.format(Locale.getDefault(), "  %s  %s", new Object[]{this.mEndExpandContent, this.mContractString});
    }

    private ExpandableLabelSpan getExpandableLabelSpan() {
        ExpandableLabelSpan expandableLabelSpan = this.mExpandableLabelSpan;
        if (expandableLabelSpan != null) {
            return expandableLabelSpan;
        }
        return new ExpandableLabelSpan(this.mContext, this.mPrefixLabelIconRes, this.mPrefixLabelIconWidth, this.mPrefixLabelIconHeight, this.mPrefixLabelTextColor, this.mPrefixLabelBgColor, this.mPrefixLabelRadius);
    }

    private int getFitPosition(String str, int i11, int i12, float f11, float f12, float f13) {
        int i13 = (int) (((f11 - (f12 + f13)) * ((float) (i11 - i12))) / f11);
        if (i13 <= str.length()) {
            return i11;
        }
        int i14 = i13 + i12;
        if (this.mPaint.measureText(this.mFormatData.getFormatedContent().substring(i12, i14)) <= f11 - f12) {
            return i14;
        }
        return getFitPosition(str, i11, i12, f11, f12, f13 + this.mPaint.measureText(SPACE));
    }

    private int getFitSpaceCount(float f11, float f12) {
        int i11 = 0;
        while ((((float) i11) * this.mPaint.measureText(SPACE)) + f12 < f11) {
            i11++;
        }
        return i11 - 1;
    }

    private String getHideEndContent() {
        String str = "  %s";
        if (TextUtils.isEmpty(this.mEndExpandContent)) {
            if (TextUtils.isEmpty(this.mExpandString)) {
                return this.mNeedAlwaysShowRight ? "" : "...";
            }
            Locale locale = Locale.getDefault();
            if (!this.mNeedAlwaysShowRight) {
                str = "...  %s";
            }
            return String.format(locale, str, new Object[]{this.mExpandString});
        } else if (TextUtils.isEmpty(this.mExpandString)) {
            Locale locale2 = Locale.getDefault();
            if (!this.mNeedAlwaysShowRight) {
                str = "...  %s";
            }
            return String.format(locale2, str, new Object[]{this.mEndExpandContent});
        } else {
            return String.format(Locale.getDefault(), this.mNeedAlwaysShowRight ? "  %s  %s" : "...  %s  %s", new Object[]{this.mEndExpandContent, this.mExpandString});
        }
    }

    private SpannableStringBuilder getRealContent(CharSequence charSequence, String str) {
        CharSequence charSequence2;
        this.retryTime = 0;
        if (TextUtils.isEmpty(this.mTitle)) {
            charSequence2 = charSequence;
        } else {
            charSequence2 = this.mTitle.toString() + charSequence.toString();
        }
        FormatData formatData = formatData(charSequence2);
        this.mFormatData = formatData;
        if (TextUtils.isEmpty(formatData.getFormatedContent())) {
            this.mFormatData.setFormatedContent(charSequence.toString());
            this.mFormatData.setPositionDatas(new ArrayList());
        }
        DynamicLayout dynamicLayout = new DynamicLayout(this.mFormatData.getFormatedContent(), this.mPaint, this.mWidth, Layout.Alignment.ALIGN_NORMAL, 1.2f, 0.0f, true);
        this.mDynamicLayout = dynamicLayout;
        int lineCount = dynamicLayout.getLineCount();
        this.mLineCount = lineCount;
        OnGetLineCountListener onGetLineCountListener2 = this.onGetLineCountListener;
        if (onGetLineCountListener2 != null) {
            onGetLineCountListener2.onGetLineCount(lineCount, lineCount > this.mContentMaxLimitLines);
        }
        if (!this.mNeedExpend || this.mLineCount <= this.mContentMaxLimitLines) {
            return dealLink(this.mFormatData, false, str);
        }
        return dealLink(this.mFormatData, true, str);
    }

    private int getSpaceCount(float f11) {
        float measureText = this.mPaint.measureText(SPACE);
        return f11 % measureText == 0.0f ? (int) (f11 / measureText) : ((int) (f11 / measureText)) + 1;
    }

    private String getSpaceStr(int i11) {
        if (i11 <= 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            int i12 = i11 - 1;
            if (i11 <= 0) {
                return sb2.toString();
            }
            sb2.append(SPACE);
            i11 = i12;
        }
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private void init(Context context, AttributeSet attributeSet, int i11) {
        Resources resources = context.getResources();
        int i12 = R.color.baseColorMajorTheme100;
        this.mMentionTextColor = resources.getColor(i12);
        this.mLinkTextColor = context.getResources().getColor(i12);
        this.mSelfTextColor = context.getResources().getColor(i12);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ExpandableTextView, i11, 0);
            this.mContentMaxLimitLines = obtainStyledAttributes.getInt(R.styleable.ExpandableTextView_ep_max_line, 4);
            int i13 = obtainStyledAttributes.getInt(R.styleable.ExpandableTextView_ep_max_line_diff, 0);
            this.mDiffLines = i13;
            this.currentLines = this.mContentMaxLimitLines - i13;
            this.mNeedExpend = obtainStyledAttributes.getBoolean(R.styleable.ExpandableTextView_ep_need_expand, this.mNeedExpend);
            this.mExpandString = obtainStyledAttributes.getString(R.styleable.ExpandableTextView_ep_expand_text);
            this.mExpandTextColor = obtainStyledAttributes.getColor(R.styleable.ExpandableTextView_ep_expand_color, this.mExpandTextColor);
            if (TextUtils.isEmpty(this.mExpandString)) {
                this.mExpandString = "";
            }
            this.mNeedContract = obtainStyledAttributes.getBoolean(R.styleable.ExpandableTextView_ep_need_contract, this.mNeedContract);
            this.mContractString = obtainStyledAttributes.getString(R.styleable.ExpandableTextView_ep_contract_text);
            this.mContractTextColor = obtainStyledAttributes.getColor(R.styleable.ExpandableTextView_ep_contract_color, this.mContractTextColor);
            this.mEndExpandContent = obtainStyledAttributes.getString(R.styleable.ExpandableTextView_ep_end_text);
            this.mEndExpandTextColor = obtainStyledAttributes.getColor(R.styleable.ExpandableTextView_ep_end_color, this.mEndExpandTextColor);
            this.mNeedTitle = obtainStyledAttributes.getBoolean(R.styleable.ExpandableTextView_ep_need_title, this.mNeedTitle);
            this.mTitleTextColor = obtainStyledAttributes.getColor(R.styleable.ExpandableTextView_ep_title_color, this.mTitleTextColor);
            this.mTitleTextSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandableTextView_ep_title_size, DisplayTool.dp2px(16.0f));
            this.mNeedSelf = obtainStyledAttributes.getBoolean(R.styleable.ExpandableTextView_ep_need_self, this.mNeedSelf);
            this.mSelfTextColor = obtainStyledAttributes.getColor(R.styleable.ExpandableTextView_ep_self_color, this.mSelfTextColor);
            this.mNeedMention = obtainStyledAttributes.getBoolean(R.styleable.ExpandableTextView_ep_need_mention, this.mNeedMention);
            this.mMentionTextColor = obtainStyledAttributes.getColor(R.styleable.ExpandableTextView_ep_mention_color, getResources().getColor(i12));
            this.mNeedLink = obtainStyledAttributes.getBoolean(R.styleable.ExpandableTextView_ep_need_link, this.mNeedLink);
            this.mNeedLinkRes = obtainStyledAttributes.getBoolean(R.styleable.ExpandableTextView_ep_need_link_res, this.mNeedLinkRes);
            this.mLinkTextColor = obtainStyledAttributes.getColor(R.styleable.ExpandableTextView_ep_link_color, this.mLinkTextColor);
            this.mLinkDrawable = getResources().getDrawable(obtainStyledAttributes.getResourceId(R.styleable.ExpandableTextView_ep_link_res, R.drawable.ic_expandable_link));
            this.mNeedAnimation = obtainStyledAttributes.getBoolean(R.styleable.ExpandableTextView_ep_need_animation, this.mNeedAnimation);
            this.mNeedAlwaysShowRight = obtainStyledAttributes.getBoolean(R.styleable.ExpandableTextView_ep_need_always_showright, this.mNeedAlwaysShowRight);
            this.mNeedConvertUrl = obtainStyledAttributes.getBoolean(R.styleable.ExpandableTextView_ep_need_convert_url, this.mNeedConvertUrl);
            this.mNeedShowRightArrowIcon = obtainStyledAttributes.getBoolean(R.styleable.ExpandableTextView_ep_need_show_arrow_icon, this.mNeedShowRightArrowIcon);
            this.mArrowWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandableTextView_ep_arrow_icon_width, this.mArrowWidth);
            this.mArrowHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandableTextView_ep_arrow_icon_height, this.mArrowHeight);
            int resourceId = obtainStyledAttributes.getResourceId(R.styleable.ExpandableTextView_ep_expand_arrow_res, this.mExpandArrowIconRes);
            this.mExpandArrowIconRes = resourceId;
            if (resourceId != 0) {
                Drawable drawable = getResources().getDrawable(this.mExpandArrowIconRes);
                this.mExpandArrowDrawable = drawable;
                drawable.setBounds(0, 0, this.mArrowWidth, this.mArrowHeight);
            }
            int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.ExpandableTextView_ep_contract_arrow_res, this.mContractArrowIconRes);
            this.mContractArrowIconRes = resourceId2;
            if (resourceId2 != 0) {
                Drawable drawable2 = getResources().getDrawable(this.mContractArrowIconRes);
                this.mContractArrowDrawable = drawable2;
                drawable2.setBounds(0, 0, this.mArrowWidth, this.mArrowHeight);
            }
            this.mNeedShowPrefixMarkIcon = obtainStyledAttributes.getBoolean(R.styleable.ExpandableTextView_ep_need_prefix_mark_icon, this.mNeedShowPrefixMarkIcon);
            this.mPrefixMarkWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandableTextView_ep_prefix_mark_icon_width, this.mPrefixMarkWidth);
            this.mPrefixMarkHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandableTextView_ep_prefix_mark_icon_height, this.mPrefixMarkHeight);
            int resourceId3 = obtainStyledAttributes.getResourceId(R.styleable.ExpandableTextView_ep_prefix_mark_icon_res, this.mPrefixMarkRes);
            this.mPrefixMarkRes = resourceId3;
            if (resourceId3 != 0) {
                Drawable drawable3 = getResources().getDrawable(this.mPrefixMarkRes);
                this.mPrefixMarkDrawable = drawable3;
                drawable3.setBounds(0, 0, this.mPrefixMarkWidth, this.mPrefixMarkHeight);
            }
            obtainStyledAttributes.recycle();
        } else {
            this.mLinkDrawable = context.getResources().getDrawable(R.drawable.ic_expandable_link);
        }
        this.mContext = context;
        TextPaint paint = getPaint();
        this.mPaint = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        if (this.mNeedLinkRes) {
            this.mLinkDrawable.setBounds(0, 0, 30, 30);
        } else {
            this.mLinkDrawable.setBounds(0, 0, 0, 0);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$action$2(boolean z11, StatusType statusType, ValueAnimator valueAnimator) {
        Float f11 = (Float) valueAnimator.getAnimatedValue();
        if (z11) {
            int i11 = this.mContentMaxLimitLines;
            int i12 = this.mDiffLines;
            this.currentLines = (i11 - i12) + ((int) (((float) ((this.mLineCount - i11) + i12)) * f11.floatValue()));
        } else if (this.mNeedContract) {
            int i13 = this.mContentMaxLimitLines;
            int i14 = this.mDiffLines;
            this.currentLines = (i13 - i14) + ((int) (((float) ((this.mLineCount - i13) + i14)) * (1.0f - f11.floatValue())));
        }
        CharSequence charSequence = this.mContent;
        setText(getRealContent(charSequence, "action_" + statusType));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$doSetContent$1(CharSequence charSequence, String str) {
        this.mWidth = (getWidth() - getPaddingLeft()) - getPaddingRight();
        correctWidthByDefault("doSetContent");
        if (this.mWidth > 0) {
            setText(getRealContent(charSequence, str));
            this.retryTime = 0;
        } else if (this.retryTime > 2) {
            setText(getRealContent(charSequence, str));
            this.retryTime = 0;
        } else {
            setContent(charSequence, false);
            this.retryTime++;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setContent$0(CharSequence charSequence) {
        if (this.mWidth <= 0) {
            this.mWidth = (getWidth() - getPaddingLeft()) - getPaddingRight();
        }
        correctWidthByDefault("setContent");
        doSetContent(charSequence, "setContent");
    }

    private List<String> matchLinkStringArrays(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<UrlParamTool.UrlResult> applyFilter = UrlParamTool.applyFilter(charSequence.toString());
        if (applyFilter != null && !applyFilter.isEmpty()) {
            for (UrlParamTool.UrlResult urlResult : applyFilter) {
                arrayList.add(urlResult.url);
            }
        }
        return arrayList;
    }

    public void bind(ExpandableStatusFix expandableStatusFix) {
        this.mModel = expandableStatusFix;
    }

    public String getContractString() {
        return this.mContractString;
    }

    public int getContractTextColor() {
        return this.mContractTextColor;
    }

    public int getEndExpandTextColor() {
        return this.mEndExpandTextColor;
    }

    public OnExpandOrContractClickListener getExpandOrContractClickListener() {
        return this.expandOrContractClickListener;
    }

    public String getExpandString() {
        return this.mExpandString;
    }

    public int getExpandTextColor() {
        return this.mExpandTextColor;
    }

    public int getExpandableLineCount() {
        return this.mLineCount;
    }

    public int getExpandableLinkTextColor() {
        return this.mLinkTextColor;
    }

    public OnLinkClickListener getLinkClickListener() {
        return this.linkClickListener;
    }

    public Drawable getLinkDrawable() {
        return this.mLinkDrawable;
    }

    public OnGetLineCountListener getOnGetLineCountListener() {
        return this.onGetLineCountListener;
    }

    public int getSelfTextColor() {
        return this.mSelfTextColor;
    }

    public StatusType getStatusType() {
        return this.mcurStatus;
    }

    public void initDefTextLines(CharSequence charSequence, CharSequence charSequence2, int i11) {
        CharSequence charSequence3;
        if (TextUtils.isEmpty(charSequence)) {
            charSequence3 = charSequence2;
        } else {
            charSequence3 = charSequence.toString() + charSequence2.toString();
        }
        if (i11 > 0 && !TextUtils.isEmpty(charSequence3)) {
            FormatData formatData = formatData(charSequence3);
            if (TextUtils.isEmpty(formatData.getFormatedContent())) {
                formatData.setFormatedContent(charSequence2.toString());
                formatData.setPositionDatas(new ArrayList());
            }
            int lineCount = new DynamicLayout(formatData.getFormatedContent(), this.mPaint, i11, Layout.Alignment.ALIGN_NORMAL, 1.2f, 0.0f, true).getLineCount();
            int i12 = this.mContentMaxLimitLines;
            if (i12 <= 0 || lineCount < i12) {
                setMinLines(lineCount);
            } else {
                setMinLines(i12);
            }
        }
    }

    public boolean isNeedAlwaysShowRight() {
        return this.mNeedAlwaysShowRight;
    }

    public boolean isNeedAnimation() {
        return this.mNeedAnimation;
    }

    public boolean isNeedContract() {
        return this.mNeedContract;
    }

    public boolean isNeedExpend() {
        return this.mNeedExpend;
    }

    public boolean isNeedLink() {
        return this.mNeedLink;
    }

    public boolean isNeedSelf() {
        return this.mNeedSelf;
    }

    public boolean isNeedTitle() {
        return this.mNeedTitle;
    }

    public boolean ismNeedMention() {
        return this.mNeedMention;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnPreDrawListener(this.onPreDrawListener);
    }

    public void reSetMaxLines(int i11) {
        this.mContentMaxLimitLines = i11;
    }

    public ExpandableTextView setArrowIconWH(int i11, int i12) {
        this.mArrowWidth = i11;
        this.mArrowHeight = i12;
        Drawable drawable = this.mExpandArrowDrawable;
        if (drawable != null) {
            drawable.setBounds(0, 0, i11, i12);
        }
        Drawable drawable2 = this.mContractArrowDrawable;
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, i11, i12);
        }
        return this;
    }

    public void setContent(CharSequence charSequence, StatusType statusType) {
        this.mTopicText = "";
        List<FormatData.PositionData> list = this.partContentMention;
        if (list != null) {
            list.clear();
        }
        if (statusType != null) {
            this.mcurStatus = statusType;
        } else {
            this.mcurStatus = DEF_STATUS_TYPE;
        }
        this.mContent = charSequence;
        this.retryTime = 0;
        setContent(charSequence, false);
    }

    public void setContentWithHeadTopic(CharSequence charSequence, String str, StatusType statusType) {
        if (statusType != null) {
            this.mcurStatus = statusType;
        } else {
            this.mcurStatus = DEF_STATUS_TYPE;
        }
        List<FormatData.PositionData> list = this.partContentMention;
        if (list != null) {
            list.clear();
        }
        this.mTopicText = str;
        if (!TextUtils.isEmpty(str)) {
            this.mContent = "#" + str + SPACE + charSequence;
        } else {
            this.mContent = charSequence;
        }
        this.retryTime = 0;
        setContent(this.mContent, false);
    }

    public ExpandableTextView setContractArrowIconRes(int i11) {
        this.mContractArrowIconRes = i11;
        if (i11 != 0) {
            this.mContractArrowDrawable = getResources().getDrawable(this.mContractArrowIconRes);
        }
        Drawable drawable = this.mContractArrowDrawable;
        if (drawable != null) {
            drawable.setBounds(0, 0, this.mArrowWidth, this.mArrowHeight);
        }
        return this;
    }

    public ExpandableTextView setContractString(String str) {
        this.mContractString = str;
        return this;
    }

    public void setContractTextColor(int i11) {
        this.mContractTextColor = i11;
    }

    public void setCurrStatus(StatusType statusType) {
        this.mcurStatus = statusType;
        action((StatusType) null);
    }

    public ExpandableTextView setEndExpandTextColor(int i11) {
        this.mEndExpandTextColor = i11;
        return this;
    }

    public void setEndExpendContent(String str) {
        this.mEndExpandContent = str;
    }

    public ExpandableTextView setExpandArrowIconRes(int i11) {
        this.mExpandArrowIconRes = i11;
        if (i11 != 0) {
            this.mExpandArrowDrawable = getResources().getDrawable(this.mExpandArrowIconRes);
        }
        Drawable drawable = this.mExpandArrowDrawable;
        if (drawable != null) {
            drawable.setBounds(0, 0, this.mArrowWidth, this.mArrowHeight);
        }
        return this;
    }

    public void setExpandOrContractClickListener(OnExpandOrContractClickListener onExpandOrContractClickListener) {
        this.expandOrContractClickListener = onExpandOrContractClickListener;
    }

    public ExpandableTextView setExpandString(String str) {
        this.mExpandString = str;
        return this;
    }

    public void setExpandTextColor(int i11) {
        this.mExpandTextColor = i11;
    }

    public void setExpandableDefaultWidth(int i11) {
        this.mDefExpandableTextWidth = i11;
    }

    public ExpandableTextView setExpandableLabelSpan(ExpandableLabelSpan expandableLabelSpan) {
        this.mExpandableLabelSpan = expandableLabelSpan;
        return this;
    }

    public void setExpandableLineCount(int i11) {
        this.mLineCount = i11;
    }

    public void setExpandableLinkTextColor(int i11) {
        this.mLinkTextColor = i11;
    }

    public void setExpandableTextViewWidth(int i11) {
        this.mWidth = i11;
    }

    public void setLinkClickListener(OnLinkClickListener onLinkClickListener) {
        this.linkClickListener = onLinkClickListener;
    }

    public void setLinkDrawable(Drawable drawable) {
        this.mLinkDrawable = drawable;
    }

    public ExpandableTextView setNeedAlwaysShowRight(boolean z11) {
        this.mNeedAlwaysShowRight = z11;
        return this;
    }

    public void setNeedAnimation(boolean z11) {
        this.mNeedAnimation = z11;
    }

    public void setNeedContract(boolean z11) {
        this.mNeedContract = z11;
    }

    public void setNeedExpend(boolean z11) {
        this.mNeedExpend = z11;
    }

    public ExpandableTextView setNeedLink(boolean z11) {
        this.mNeedLink = z11;
        return this;
    }

    public void setNeedMention(boolean z11) {
        this.mNeedMention = z11;
    }

    public ExpandableTextView setNeedSelf(boolean z11) {
        this.mNeedSelf = z11;
        return this;
    }

    public ExpandableTextView setNeedShowPrefixMarkIcon(boolean z11) {
        this.mNeedShowPrefixMarkIcon = z11;
        return this;
    }

    public ExpandableTextView setNeedShowRightArrowIcon(boolean z11) {
        this.mNeedShowRightArrowIcon = z11;
        return this;
    }

    public ExpandableTextView setNeedTitle(boolean z11) {
        this.mNeedTitle = z11;
        return this;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.commentTextViewTouchListener.setOnClickListener(onClickListener);
    }

    public void setOnExpandableContractChangedListener(OnExpandableContractChangedListener onExpandableContractChangedListener) {
        this.mContractChangedListener = onExpandableContractChangedListener;
    }

    public void setOnGetLineCountListener(OnGetLineCountListener onGetLineCountListener2) {
        this.onGetLineCountListener = onGetLineCountListener2;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        super.setOnLongClickListener(onLongClickListener);
        this.commentTextViewTouchListener.setOnLongClickListener(onLongClickListener);
    }

    public ExpandableTextView setPrefixLabelArgs(boolean z11, String str, float f11, int i11, int i12, int i13, int i14, int i15, int i16) {
        this.mIsNeedPrefixLabelShow = z11;
        this.mPrefixLabelText = str;
        this.mPrefixLabelTextSize = f11;
        this.mPrefixLabelTextColor = i11;
        this.mPrefixLabelIconRes = i12;
        this.mPrefixLabelIconWidth = i13;
        this.mPrefixLabelIconHeight = i14;
        this.mPrefixLabelBgColor = i15;
        this.mPrefixLabelRadius = i16;
        if (i12 != 0) {
            Drawable drawable = getResources().getDrawable(this.mPrefixLabelIconRes);
            this.mPrefixLabelIconDrawable = drawable;
            drawable.setBounds(0, 0, this.mPrefixLabelIconWidth, this.mPrefixLabelIconHeight);
        }
        return this;
    }

    public ExpandableTextView setPrefixMarkDrawable(Drawable drawable) {
        return setPrefixMarkDrawable(drawable, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
    }

    public ExpandableTextView setPrefixMarkRes(int i11) {
        return setPrefixMarkRes(i11, this.mPrefixMarkWidth, this.mPrefixMarkHeight);
    }

    public ExpandableTextView setSelfTextColor(int i11) {
        this.mSelfTextColor = i11;
        return this;
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        Spannable spannable;
        if (!this.mNeedLink || TextUtils.isEmpty(charSequence)) {
            super.setText(charSequence, bufferType);
            return;
        }
        if (charSequence instanceof Spannable) {
            spannable = (Spannable) charSequence;
        } else {
            spannable = new SpannableString(charSequence);
        }
        List<UrlParamTool.UrlResult> applyFilter = UrlParamTool.applyFilter(charSequence.toString());
        if (applyFilter != null && !applyFilter.isEmpty()) {
            for (UrlParamTool.UrlResult next : applyFilter) {
                TextLinkSpan textLinkSpan = new TextLinkSpan(next.url);
                textLinkSpan.setLinkColor(this.mLinkTextColor);
                spannable.setSpan(textLinkSpan, next.start, next.end, 33);
            }
        }
        super.setText(spannable, bufferType);
        setMovementMethod(new LocalLinkMovementMethod(matchLinkStringArrays(this.mContent)));
    }

    public ExpandableTextView setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        return this;
    }

    public ExpandableTextView setTitleBold(boolean z11) {
        this.isTitleBold = z11;
        return this;
    }

    public ExpandableTextView setTitleSize(int i11) {
        this.mTitleTextSize = i11;
        return this;
    }

    public ExpandableTextView setTitleTextColor(int i11) {
        this.mTitleTextColor = i11;
        return this;
    }

    public void showFull() {
        setText(getRealContent(this.mContent, "showFull"));
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    /* access modifiers changed from: private */
    public void action(StatusType statusType) {
        int i11 = this.currentLines;
        int i12 = this.mLineCount;
        boolean z11 = i11 < i12;
        if (this.mNeedAnimation) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            ofFloat.addUpdateListener(new a(this, z11, statusType));
            ofFloat.setDuration(100);
            ofFloat.start();
            return;
        }
        if (z11) {
            int i13 = this.mContentMaxLimitLines;
            int i14 = this.mDiffLines;
            this.currentLines = (i13 - i14) + (i12 - i13) + i14;
        } else if (this.mNeedContract) {
            this.currentLines = this.mContentMaxLimitLines - this.mDiffLines;
        }
        CharSequence charSequence = this.mContent;
        setText(getRealContent(charSequence, "action_" + statusType));
    }

    public void setExpandOrContractClickListener(OnExpandOrContractClickListener onExpandOrContractClickListener, boolean z11) {
        this.expandOrContractClickListener = onExpandOrContractClickListener;
        this.needRealExpandOrContract = z11;
    }

    public ExpandableTextView setPrefixMarkRes(int i11, int i12, int i13) {
        this.mPrefixMarkRes = i11;
        this.mPrefixMarkWidth = i12;
        this.mPrefixMarkHeight = i13;
        if (i11 != 0) {
            Drawable drawable = getResources().getDrawable(i11);
            this.mPrefixMarkDrawable = drawable;
            drawable.setBounds(0, 0, i12, i13);
        }
        return this;
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.retryTime = 0;
        this.mcurStatus = DEF_STATUS_TYPE;
        this.mContentMaxLimitLines = 4;
        this.mDefExpandableTextWidth = 0;
        this.mLinkDrawable = null;
        this.needRealExpandOrContract = true;
        this.mNeedContract = true;
        this.mNeedExpend = true;
        this.mNeedConvertUrl = false;
        this.mNeedMention = false;
        this.mNeedPartContentMention = true;
        this.mNeedLink = true;
        this.mNeedLinkRes = false;
        this.mNeedSelf = false;
        this.mNeedTitle = false;
        this.mNeedAlwaysShowRight = false;
        this.mNeedAnimation = true;
        this.mTitle = "";
        this.mExpandTextColor = Color.parseColor("#FFBE00");
        this.mContractTextColor = Color.parseColor("#FFBE00");
        this.mTitleTextColor = Color.parseColor("#1A1A1A");
        this.mEndExpandTextColor = Color.parseColor("#999999");
        this.hasInit = false;
        this.isTitleBold = false;
        this.mNeedShowRightArrowIcon = false;
        this.mExpandArrowDrawable = null;
        this.mContractArrowDrawable = null;
        this.mExpandArrowIconRes = 0;
        this.mContractArrowIconRes = 0;
        this.mArrowWidth = 0;
        this.mArrowHeight = 0;
        this.mNeedShowPrefixMarkIcon = false;
        this.mPrefixMarkDrawable = null;
        this.mPrefixMarkRes = 0;
        this.mPrefixMarkWidth = 0;
        this.mPrefixMarkHeight = 0;
        this.mDiffLines = 0;
        this.onPreDrawListener = new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                if (ExpandableTextView.this.hasInit) {
                    return true;
                }
                boolean unused = ExpandableTextView.this.hasInit = true;
                ExpandableTextView.this.getViewTreeObserver().removeOnPreDrawListener(this);
                if (ExpandableTextView.this.mWidth <= 0) {
                    ExpandableTextView expandableTextView = ExpandableTextView.this;
                    int unused2 = expandableTextView.mWidth = expandableTextView.getWidth() + ExpandableTextView.this.getPaddingLeft() + ExpandableTextView.this.getPaddingRight();
                }
                ExpandableTextView.this.correctWidthByDefault("ViewTreeObserver");
                ExpandableTextView expandableTextView2 = ExpandableTextView.this;
                expandableTextView2.setContent(expandableTextView2.mContent == null ? "" : ExpandableTextView.this.mContent, false);
                return true;
            }
        };
        this.mIsNeedPrefixLabelShow = false;
        this.mPrefixLabelText = "";
        this.mPrefixLabelTextMaxLength = 12;
        this.mPrefixLabelTextSize = (float) DisplayTool.dp2px(10.0f);
        this.mPrefixLabelTextColor = RoundedDrawable.DEFAULT_BORDER_COLOR;
        this.mPrefixLabelIconRes = 0;
        this.mPrefixLabelIconDrawable = null;
        this.mPrefixLabelIconWidth = 0;
        this.mPrefixLabelIconHeight = 0;
        this.mPrefixLabelBgColor = 0;
        this.mPrefixLabelRadius = 0;
        init(context, attributeSet, i11);
        CommentTextViewTouchListener commentTextViewTouchListener2 = new CommentTextViewTouchListener();
        this.commentTextViewTouchListener = commentTextViewTouchListener2;
        setOnTouchListener(commentTextViewTouchListener2);
        getViewTreeObserver().addOnPreDrawListener(this.onPreDrawListener);
    }

    public ExpandableTextView setPrefixMarkDrawable(Drawable drawable, int i11, int i12) {
        this.mPrefixMarkRes = 0;
        this.mPrefixMarkDrawable = drawable;
        this.mPrefixMarkWidth = i11;
        this.mPrefixMarkHeight = i12;
        if (drawable != null) {
            drawable.setBounds(0, 0, i11, i12);
        }
        return this;
    }

    public void setContent(List<CommunityFeedInfo.PartContent> list) {
        this.mContent = "";
        this.mTopicText = "";
        if (list == null || list.size() <= 0) {
            List<FormatData.PositionData> list2 = this.partContentMention;
            if (list2 != null) {
                list2.clear();
            }
            setText(this.mContent);
            return;
        }
        this.mcurStatus = DEF_STATUS_TYPE;
        StringBuilder sb2 = new StringBuilder();
        this.partContentMention = new ArrayList();
        int length = this.mNeedShowPrefixMarkIcon ? getSpaceStr(getSpaceCount((float) this.mPrefixMarkWidth)).length() : 0;
        for (CommunityFeedInfo.PartContent next : list) {
            if (!TextUtils.isEmpty(next.getText())) {
                int length2 = next.getText().length() + length;
                sb2.append(next.getText());
                if (!TextUtils.isEmpty(next.getUrl())) {
                    this.partContentMention.add(new FormatData.PositionData(length, length2, next.getUrl(), LinkType.MENTION_TYPE));
                }
                length = length2;
            }
        }
        String sb3 = sb2.toString();
        this.mContent = sb3;
        this.retryTime = 0;
        setContent((CharSequence) sb3, false);
    }

    /* access modifiers changed from: private */
    public void setContent(CharSequence charSequence, boolean z11) {
        this.mContent = charSequence;
        if (TextUtils.isEmpty(charSequence)) {
            setText("");
        } else if (z11) {
            post(new b(this, charSequence));
        } else {
            doSetContent(charSequence, "setContent");
        }
    }
}
