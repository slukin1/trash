package com.tencent.trtc;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.trtc.TRTCCloudDef;
import java.util.ArrayList;

public abstract class TRTCCloudListener {

    public interface TRTCAudioFrameListener {
        void onCapturedAudioFrame(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame);

        void onLocalProcessedAudioFrame(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame);

        void onMixedAllAudioFrame(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame);

        void onMixedPlayAudioFrame(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame);

        void onRemoteUserAudioFrame(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame, String str);

        void onVoiceEarMonitorAudioFrame(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame);
    }

    public static abstract class TRTCLogListener {
        public abstract void onLog(String str, int i11, String str2);
    }

    public interface TRTCSnapshotListener {
        void onSnapshotComplete(Bitmap bitmap);
    }

    public interface TRTCVideoFrameListener {
        void onGLContextCreated();

        void onGLContextDestory();

        int onProcessVideoFrame(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame, TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame2);
    }

    public interface TRTCVideoRenderListener {
        void onRenderVideoFrame(String str, int i11, TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame);
    }

    @Deprecated
    public void onAudioEffectFinished(int i11, int i12) {
    }

    public void onAudioRouteChanged(int i11, int i12) {
    }

    public void onCameraDidReady() {
    }

    public void onCdnStreamStateChanged(String str, int i11, int i12, String str2, Bundle bundle) {
    }

    public void onConnectOtherRoom(String str, int i11, String str2) {
    }

    public void onConnectionLost() {
    }

    public void onConnectionRecovery() {
    }

    public void onDisConnectOtherRoom(int i11, String str) {
    }

    public void onEnterRoom(long j11) {
    }

    public void onError(int i11, String str, Bundle bundle) {
    }

    public void onExitRoom(int i11) {
    }

    public void onFirstAudioFrame(String str) {
    }

    public void onFirstVideoFrame(String str, int i11, int i12, int i13) {
    }

    public void onLocalRecordBegin(int i11, String str) {
    }

    public void onLocalRecordComplete(int i11, String str) {
    }

    public void onLocalRecordFragment(String str) {
    }

    public void onLocalRecording(long j11, String str) {
    }

    public void onMicDidReady() {
    }

    public void onMissCustomCmdMsg(String str, int i11, int i12, int i13) {
    }

    public void onNetworkQuality(TRTCCloudDef.TRTCQuality tRTCQuality, ArrayList<TRTCCloudDef.TRTCQuality> arrayList) {
    }

    public void onRecvCustomCmdMsg(String str, int i11, int i12, byte[] bArr) {
    }

    public void onRecvSEIMsg(String str, byte[] bArr) {
    }

    public void onRemoteAudioStatusUpdated(String str, int i11, int i12, Bundle bundle) {
    }

    public void onRemoteUserEnterRoom(String str) {
    }

    public void onRemoteUserLeaveRoom(String str, int i11) {
    }

    public void onRemoteVideoStatusUpdated(String str, int i11, int i12, int i13, Bundle bundle) {
    }

    public void onScreenCapturePaused() {
    }

    public void onScreenCaptureResumed() {
    }

    public void onScreenCaptureStarted() {
    }

    public void onScreenCaptureStopped(int i11) {
    }

    public void onSendFirstLocalAudioFrame() {
    }

    public void onSendFirstLocalVideoFrame(int i11) {
    }

    public void onSetMixTranscodingConfig(int i11, String str) {
    }

    public void onSpeedTest(TRTCCloudDef.TRTCSpeedTestResult tRTCSpeedTestResult, int i11, int i12) {
    }

    public void onSpeedTestResult(TRTCCloudDef.TRTCSpeedTestResult tRTCSpeedTestResult) {
    }

    public void onStartPublishCDNStream(int i11, String str) {
    }

    public void onStartPublishMediaStream(String str, int i11, String str2, Bundle bundle) {
    }

    public void onStartPublishing(int i11, String str) {
    }

    public void onStatistics(TRTCStatistics tRTCStatistics) {
    }

    public void onStopPublishCDNStream(int i11, String str) {
    }

    public void onStopPublishMediaStream(String str, int i11, String str2, Bundle bundle) {
    }

    public void onStopPublishing(int i11, String str) {
    }

    public void onSwitchRole(int i11, String str) {
    }

    public void onSwitchRoom(int i11, String str) {
    }

    public void onTryToReconnect() {
    }

    public void onUpdateOtherRoomForwardMode(int i11, String str) {
    }

    public void onUpdatePublishMediaStream(String str, int i11, String str2, Bundle bundle) {
    }

    public void onUserAudioAvailable(String str, boolean z11) {
    }

    @Deprecated
    public void onUserEnter(String str) {
    }

    @Deprecated
    public void onUserExit(String str, int i11) {
    }

    public void onUserSubStreamAvailable(String str, boolean z11) {
    }

    public void onUserVideoAvailable(String str, boolean z11) {
    }

    public void onUserVideoSizeChanged(String str, int i11, int i12, int i13) {
    }

    public void onUserVoiceVolume(ArrayList<TRTCCloudDef.TRTCVolumeInfo> arrayList, int i11) {
    }

    public void onWarning(int i11, String str, Bundle bundle) {
    }
}
