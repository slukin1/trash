package com.huobi.view.seekbar;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.hbg.lib.widgets.R$color;
import i6.m;
import java.math.BigDecimal;

public class MultiConfigBuilder {
    public boolean alwaysShowBubble;
    public long alwaysShowBubbleDelay;
    public long animDuration;
    public boolean autoAdjustSectionMark;
    private String balance;
    public int bubbleColor;
    public int bubbleTextColor;
    public int bubbleTextSize;
    public int circleColor;
    public float danger;
    public int dangerColor;
    public boolean floatType;
    public boolean hideBubble;
    private boolean isBuy;
    private boolean isDark;
    private MultiColorSeekBar mMultiColorSeekBar;
    public float max;
    private String maxBalance;
    public float min;
    public int outercircleColor;
    public int precision;
    public float progress;
    public boolean rtl;
    public int secondTrackColor;
    public int secondTrackSize;
    public int sectionCount;
    public int sectionTextColor;
    public int sectionTextInterval;
    public int sectionTextPosition;
    public int sectionTextSize;
    public boolean seekBySection;
    public boolean seekStepSection;
    public boolean showProgressInFloat;
    public boolean showSectionMark;
    public boolean showSectionText;
    public boolean showThumbText;
    public int thumbColor;
    public int thumbRadius;
    public int thumbRadiusOnDragging;
    public int thumbTextColor;
    public int thumbTextSize;
    public boolean touchToSeek;
    public int trackColor;
    public int trackSize;

    public MultiConfigBuilder(MultiColorSeekBar multiColorSeekBar) {
        this.mMultiColorSeekBar = multiColorSeekBar;
    }

    public MultiConfigBuilder alwaysShowBubble() {
        this.alwaysShowBubble = true;
        return this;
    }

    public MultiConfigBuilder alwaysShowBubbleDelay(long j11) {
        this.alwaysShowBubbleDelay = j11;
        return this;
    }

    public MultiConfigBuilder animDuration(long j11) {
        this.animDuration = j11;
        return this;
    }

    public MultiConfigBuilder autoAdjustSectionMark() {
        this.autoAdjustSectionMark = true;
        return this;
    }

    public MultiConfigBuilder bubbleColor(int i11) {
        this.bubbleColor = i11;
        return this;
    }

    public MultiConfigBuilder bubbleTextColor(int i11) {
        this.bubbleTextColor = i11;
        return this;
    }

    public MultiConfigBuilder bubbleTextSize(int i11) {
        this.bubbleTextSize = MultiColorUtils.sp2px(i11);
        return this;
    }

    public void build() {
        this.mMultiColorSeekBar.config(this);
    }

    public MultiConfigBuilder colorConfig(Context context, boolean z11, boolean z12) {
        this.isDark = z11;
        this.isBuy = z12;
        trackColor(ContextCompat.getColor(context, R$color.baseColorPrimarySeparator));
        int i11 = R$color.seek_bar_track_color;
        secondTrackColor(ContextCompat.getColor(context, i11));
        setDangerColor(ContextCompat.getColor(context, R$color.seek_bar_danger_color));
        bubbleColor(ContextCompat.getColor(context, i11));
        bubbleTextColor(ContextCompat.getColor(context, R$color.seek_bar_bubble_text_color));
        sectionTextColor(ContextCompat.getColor(context, R$color.baseColorSecondaryTextNew));
        setCircleColor(ContextCompat.getColor(context, i11));
        this.outercircleColor = ContextCompat.getColor(context, R$color.baseColorContentBackground);
        return this;
    }

    public MultiConfigBuilder data(String str, String str2) {
        if (TextUtils.isEmpty(str) || "--".equals(str)) {
            str = IdManager.DEFAULT_VERSION_NAME;
        }
        if (TextUtils.isEmpty(str2) || "--".equals(str2)) {
            str2 = IdManager.DEFAULT_VERSION_NAME;
        }
        this.balance = str;
        this.maxBalance = str2;
        if (TextUtils.isEmpty(str2) || m.e0(new BigDecimal(str2), new BigDecimal(IdManager.DEFAULT_VERSION_NAME))) {
            setDanger(100.1f);
        } else {
            setDanger(new BigDecimal(str).multiply(m.f68179a).divide(new BigDecimal(str2), 8, 5).floatValue());
        }
        return this;
    }

    public MultiConfigBuilder floatType() {
        this.floatType = true;
        return this;
    }

    public long getAlwaysShowBubbleDelay() {
        return this.alwaysShowBubbleDelay;
    }

    public long getAnimDuration() {
        return this.animDuration;
    }

    public String getBalance() {
        return this.balance;
    }

    public int getBubbleColor() {
        return this.bubbleColor;
    }

    public int getBubbleTextColor() {
        return this.bubbleTextColor;
    }

    public int getBubbleTextSize() {
        return this.bubbleTextSize;
    }

    public int getCircleColor() {
        return this.circleColor;
    }

    public float getDanger() {
        return this.danger;
    }

    public int getDangerColor() {
        return this.dangerColor;
    }

    public float getMax() {
        return this.max;
    }

    public String getMaxBalance() {
        return this.maxBalance;
    }

    public float getMin() {
        return this.min;
    }

    public float getProgress() {
        return this.progress;
    }

    public int getSecondTrackColor() {
        return this.secondTrackColor;
    }

    public int getSecondTrackSize() {
        return this.secondTrackSize;
    }

    public int getSectionCount() {
        return this.sectionCount;
    }

    public int getSectionTextColor() {
        return this.sectionTextColor;
    }

    public int getSectionTextInterval() {
        return this.sectionTextInterval;
    }

    public int getSectionTextPosition() {
        return this.sectionTextPosition;
    }

    public int getSectionTextSize() {
        return this.sectionTextSize;
    }

    public int getThumbColor() {
        return this.thumbColor;
    }

    public int getThumbRadius() {
        return this.thumbRadius;
    }

    public int getThumbRadiusOnDragging() {
        return this.thumbRadiusOnDragging;
    }

    public int getThumbTextColor() {
        return this.thumbTextColor;
    }

    public int getThumbTextSize() {
        return this.thumbTextSize;
    }

    public int getTrackColor() {
        return this.trackColor;
    }

    public int getTrackSize() {
        return this.trackSize;
    }

    public MultiConfigBuilder hideBubble() {
        this.hideBubble = true;
        return this;
    }

    public boolean isAlwaysShowBubble() {
        return this.alwaysShowBubble;
    }

    public boolean isAutoAdjustSectionMark() {
        return this.autoAdjustSectionMark;
    }

    public boolean isBuy() {
        return this.isBuy;
    }

    public boolean isDark() {
        return this.isDark;
    }

    public boolean isFloatType() {
        return this.floatType;
    }

    public boolean isHideBubble() {
        return this.hideBubble;
    }

    public boolean isRtl() {
        return this.rtl;
    }

    public boolean isSeekBySection() {
        return this.seekBySection;
    }

    public boolean isSeekStepSection() {
        return this.seekStepSection;
    }

    public boolean isShowProgressInFloat() {
        return this.showProgressInFloat;
    }

    public boolean isShowSectionMark() {
        return this.showSectionMark;
    }

    public boolean isShowSectionText() {
        return this.showSectionText;
    }

    public boolean isShowThumbText() {
        return this.showThumbText;
    }

    public boolean isTouchToSeek() {
        return this.touchToSeek;
    }

    public MultiConfigBuilder max(float f11) {
        this.max = f11;
        return this;
    }

    public MultiConfigBuilder min(float f11) {
        this.min = f11;
        this.progress = f11;
        return this;
    }

    public MultiConfigBuilder outerCircleColor(int i11) {
        this.outercircleColor = i11;
        return this;
    }

    public MultiConfigBuilder precision(int i11) {
        this.precision = i11;
        return this;
    }

    public MultiConfigBuilder progress(float f11) {
        this.progress = f11;
        return this;
    }

    public MultiConfigBuilder rtl(boolean z11) {
        this.rtl = z11;
        return this;
    }

    public MultiConfigBuilder secondTrackColor(int i11) {
        this.secondTrackColor = i11;
        this.thumbColor = i11;
        this.thumbTextColor = i11;
        this.bubbleColor = i11;
        return this;
    }

    public MultiConfigBuilder secondTrackSize(int i11) {
        this.secondTrackSize = MultiColorUtils.dp2px(i11);
        return this;
    }

    public MultiConfigBuilder sectionCount(int i11) {
        this.sectionCount = i11;
        return this;
    }

    public MultiConfigBuilder sectionTextColor(int i11) {
        this.sectionTextColor = i11;
        return this;
    }

    public MultiConfigBuilder sectionTextInterval(int i11) {
        this.sectionTextInterval = i11;
        return this;
    }

    public MultiConfigBuilder sectionTextPosition(int i11) {
        this.sectionTextPosition = i11;
        return this;
    }

    public MultiConfigBuilder sectionTextSize(int i11) {
        this.sectionTextSize = MultiColorUtils.sp2px(i11);
        return this;
    }

    public MultiConfigBuilder seekBySection() {
        this.seekBySection = true;
        return this;
    }

    public MultiConfigBuilder seekStepSection() {
        this.seekStepSection = true;
        return this;
    }

    public MultiConfigBuilder setCircleColor(int i11) {
        this.circleColor = i11;
        return this;
    }

    public MultiConfigBuilder setDanger(float f11) {
        if (f11 == 100.0f) {
            f11 = 100.1f;
        }
        this.danger = f11;
        return this;
    }

    public MultiConfigBuilder setDangerColor(int i11) {
        this.dangerColor = i11;
        return this;
    }

    public MultiConfigBuilder showProgressInFloat() {
        this.showProgressInFloat = true;
        return this;
    }

    public MultiConfigBuilder showSectionMark() {
        this.showSectionMark = true;
        return this;
    }

    public MultiConfigBuilder showSectionText() {
        this.showSectionText = true;
        return this;
    }

    public MultiConfigBuilder showThumbText() {
        this.showThumbText = true;
        return this;
    }

    public MultiConfigBuilder thumbColor(int i11) {
        this.thumbColor = i11;
        return this;
    }

    public MultiConfigBuilder thumbRadius(int i11) {
        this.thumbRadius = MultiColorUtils.dp2px(i11);
        return this;
    }

    public MultiConfigBuilder thumbRadiusOnDragging(int i11) {
        this.thumbRadiusOnDragging = MultiColorUtils.dp2px(i11);
        return this;
    }

    public MultiConfigBuilder thumbTextColor(int i11) {
        this.thumbTextColor = i11;
        return this;
    }

    public MultiConfigBuilder thumbTextSize(int i11) {
        this.thumbTextSize = MultiColorUtils.sp2px(i11);
        return this;
    }

    public MultiConfigBuilder touchToSeek() {
        this.touchToSeek = true;
        return this;
    }

    public MultiConfigBuilder trackColor(int i11) {
        this.trackColor = i11;
        this.sectionTextColor = i11;
        return this;
    }

    public MultiConfigBuilder trackSize(int i11) {
        this.trackSize = MultiColorUtils.dp2px(i11);
        return this;
    }
}
