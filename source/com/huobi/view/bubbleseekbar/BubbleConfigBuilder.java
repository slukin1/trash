package com.huobi.view.bubbleseekbar;

import com.hbg.lib.common.utils.PixelUtils;

public class BubbleConfigBuilder {
    public boolean alwaysShowBubble;
    public long alwaysShowBubbleDelay;
    public long animDuration;
    public boolean autoAdjustSectionMark;
    public int bubbleColor;
    public int bubbleTextColor;
    public int bubbleTextSize;
    public boolean floatType;
    public boolean hideBubble;
    private BubbleSeekBar mBubbleSeekBar;
    public float max;
    public float min;
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

    public BubbleConfigBuilder(BubbleSeekBar bubbleSeekBar) {
        this.mBubbleSeekBar = bubbleSeekBar;
    }

    public BubbleConfigBuilder alwaysShowBubble() {
        this.alwaysShowBubble = true;
        return this;
    }

    public BubbleConfigBuilder alwaysShowBubbleDelay(long j11) {
        this.alwaysShowBubbleDelay = j11;
        return this;
    }

    public BubbleConfigBuilder animDuration(long j11) {
        this.animDuration = j11;
        return this;
    }

    public BubbleConfigBuilder autoAdjustSectionMark() {
        this.autoAdjustSectionMark = true;
        return this;
    }

    public BubbleConfigBuilder bubbleColor(int i11) {
        this.bubbleColor = i11;
        return this;
    }

    public BubbleConfigBuilder bubbleTextColor(int i11) {
        this.bubbleTextColor = i11;
        return this;
    }

    public BubbleConfigBuilder bubbleTextSize(int i11) {
        this.bubbleTextSize = PixelUtils.j((float) i11);
        return this;
    }

    public void build() {
        this.mBubbleSeekBar.config(this);
    }

    public BubbleConfigBuilder floatType() {
        this.floatType = true;
        return this;
    }

    public long getAlwaysShowBubbleDelay() {
        return this.alwaysShowBubbleDelay;
    }

    public long getAnimDuration() {
        return this.animDuration;
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

    public float getMax() {
        return this.max;
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

    public BubbleConfigBuilder hideBubble() {
        this.hideBubble = true;
        return this;
    }

    public boolean isAlwaysShowBubble() {
        return this.alwaysShowBubble;
    }

    public boolean isAutoAdjustSectionMark() {
        return this.autoAdjustSectionMark;
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

    public BubbleConfigBuilder max(float f11) {
        this.max = f11;
        return this;
    }

    public BubbleConfigBuilder min(float f11) {
        this.min = f11;
        this.progress = f11;
        return this;
    }

    public BubbleConfigBuilder progress(float f11) {
        this.progress = f11;
        return this;
    }

    public BubbleConfigBuilder rtl(boolean z11) {
        this.rtl = z11;
        return this;
    }

    public BubbleConfigBuilder secondTrackColor(int i11) {
        this.secondTrackColor = i11;
        this.thumbColor = i11;
        this.thumbTextColor = i11;
        this.bubbleColor = i11;
        return this;
    }

    public BubbleConfigBuilder secondTrackSize(int i11) {
        this.secondTrackSize = PixelUtils.a((float) i11);
        return this;
    }

    public BubbleConfigBuilder sectionCount(int i11) {
        this.sectionCount = i11;
        return this;
    }

    public BubbleConfigBuilder sectionTextColor(int i11) {
        this.sectionTextColor = i11;
        return this;
    }

    public BubbleConfigBuilder sectionTextInterval(int i11) {
        this.sectionTextInterval = i11;
        return this;
    }

    public BubbleConfigBuilder sectionTextPosition(int i11) {
        this.sectionTextPosition = i11;
        return this;
    }

    public BubbleConfigBuilder sectionTextSize(int i11) {
        this.sectionTextSize = PixelUtils.j((float) i11);
        return this;
    }

    public BubbleConfigBuilder seekBySection() {
        this.seekBySection = true;
        return this;
    }

    public BubbleConfigBuilder seekStepSection() {
        this.seekStepSection = true;
        return this;
    }

    public BubbleConfigBuilder showProgressInFloat() {
        this.showProgressInFloat = true;
        return this;
    }

    public BubbleConfigBuilder showSectionMark() {
        this.showSectionMark = true;
        return this;
    }

    public BubbleConfigBuilder showSectionText() {
        this.showSectionText = true;
        return this;
    }

    public BubbleConfigBuilder showThumbText() {
        this.showThumbText = true;
        return this;
    }

    public BubbleConfigBuilder thumbColor(int i11) {
        this.thumbColor = i11;
        return this;
    }

    public BubbleConfigBuilder thumbRadius(int i11) {
        this.thumbRadius = PixelUtils.a((float) i11);
        return this;
    }

    public BubbleConfigBuilder thumbRadiusOnDragging(int i11) {
        this.thumbRadiusOnDragging = PixelUtils.a((float) i11);
        return this;
    }

    public BubbleConfigBuilder thumbTextColor(int i11) {
        this.thumbTextColor = i11;
        return this;
    }

    public BubbleConfigBuilder thumbTextSize(int i11) {
        this.thumbTextSize = PixelUtils.j((float) i11);
        return this;
    }

    public BubbleConfigBuilder touchToSeek() {
        this.touchToSeek = true;
        return this;
    }

    public BubbleConfigBuilder trackColor(int i11) {
        this.trackColor = i11;
        this.sectionTextColor = i11;
        return this;
    }

    public BubbleConfigBuilder trackSize(int i11) {
        this.trackSize = PixelUtils.a((float) i11);
        return this;
    }
}
