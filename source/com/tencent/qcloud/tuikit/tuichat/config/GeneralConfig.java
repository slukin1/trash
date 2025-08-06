package com.tencent.qcloud.tuikit.tuichat.config;

public class GeneralConfig {
    public static final int DEFAULT_AUDIO_RECORD_MAX_TIME = 60;
    public static final int DEFAULT_VIDEO_RECORD_MAX_TIME = 15;
    private int audioRecordMaxTime = 60;
    private boolean enableFloatWindowForCall = true;
    private boolean enableMultiDeviceForCall = false;
    private boolean enableVideoCall = true;
    private boolean enableVoiceCall = true;
    private boolean enableWelcomeCustomMessage = true;
    private boolean excludedFromLastMessage;
    private boolean excludedFromUnreadCount;
    private boolean isAndroidPrivateRing;
    private boolean isEnableMessageTyping = true;
    private boolean quoteEnable = true;
    private boolean reactEnable = true;
    private boolean replyEnable = true;
    private boolean showRead = false;
    private int timeIntervalForMessageRecall = 120;
    private boolean useSystemCamera = false;
    private int videoRecordMaxTime = 15;

    public int getAudioRecordMaxTime() {
        return this.audioRecordMaxTime;
    }

    public int getTimeIntervalForMessageRecall() {
        return this.timeIntervalForMessageRecall;
    }

    public int getVideoRecordMaxTime() {
        return this.videoRecordMaxTime;
    }

    public boolean isAndroidPrivateRing() {
        return this.isAndroidPrivateRing;
    }

    public boolean isEnableFloatWindowForCall() {
        return this.enableFloatWindowForCall;
    }

    public boolean isEnableMessageTyping() {
        return this.isEnableMessageTyping;
    }

    public boolean isEnableMultiDeviceForCall() {
        return this.enableMultiDeviceForCall;
    }

    public boolean isEnableVideoCall() {
        return this.enableVideoCall;
    }

    public boolean isEnableVoiceCall() {
        return this.enableVoiceCall;
    }

    public boolean isEnableWelcomeCustomMessage() {
        return this.enableWelcomeCustomMessage;
    }

    public boolean isExcludedFromLastMessage() {
        return this.excludedFromLastMessage;
    }

    public boolean isExcludedFromUnreadCount() {
        return this.excludedFromUnreadCount;
    }

    public boolean isQuoteEnable() {
        return this.quoteEnable;
    }

    public boolean isReactEnable() {
        return this.reactEnable;
    }

    public boolean isReplyEnable() {
        return this.replyEnable;
    }

    public boolean isShowRead() {
        return this.showRead;
    }

    public void setAndroidPrivateRing(boolean z11) {
        this.isAndroidPrivateRing = z11;
    }

    public GeneralConfig setAudioRecordMaxTime(int i11) {
        this.audioRecordMaxTime = i11;
        return this;
    }

    public void setEnableFloatWindowForCall(boolean z11) {
        this.enableFloatWindowForCall = z11;
    }

    public void setEnableMessageTyping(boolean z11) {
        this.isEnableMessageTyping = z11;
    }

    public void setEnableMultiDeviceForCall(boolean z11) {
        this.enableMultiDeviceForCall = z11;
    }

    public void setEnableVideoCall(boolean z11) {
        this.enableVideoCall = z11;
    }

    public void setEnableVoiceCall(boolean z11) {
        this.enableVoiceCall = z11;
    }

    public void setEnableWelcomeCustomMessage(boolean z11) {
        this.enableWelcomeCustomMessage = z11;
    }

    public void setExcludedFromLastMessage(boolean z11) {
        this.excludedFromLastMessage = z11;
    }

    public void setExcludedFromUnreadCount(boolean z11) {
        this.excludedFromUnreadCount = z11;
    }

    public void setQuoteEnable(boolean z11) {
        this.quoteEnable = z11;
    }

    public void setReactEnable(boolean z11) {
        this.reactEnable = z11;
    }

    public void setReplyEnable(boolean z11) {
        this.replyEnable = z11;
    }

    public void setShowRead(boolean z11) {
        this.showRead = z11;
    }

    public void setTimeIntervalForMessageRecall(int i11) {
        this.timeIntervalForMessageRecall = i11;
    }

    public GeneralConfig setVideoRecordMaxTime(int i11) {
        this.videoRecordMaxTime = i11;
        return this;
    }
}
