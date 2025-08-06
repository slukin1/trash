package com.tencent.thumbplayer.tcmedia.api;

public class ITPPlayerListener {

    public interface IOnAudioFrameOutputListener {
        void onAudioFrameOut(ITPPlayer iTPPlayer, TPAudioFrameBuffer tPAudioFrameBuffer);
    }

    public interface IOnAudioProcessFrameOutputListener {
        TPPostProcessFrameBuffer onAudioProcessFrameOut(ITPPlayer iTPPlayer, TPPostProcessFrameBuffer tPPostProcessFrameBuffer);
    }

    public interface IOnCompletionListener {
        void onCompletion(ITPPlayer iTPPlayer);
    }

    public interface IOnDemuxerListener {
        TPRemoteSdpInfo onSdpExchange(ITPPlayer iTPPlayer, String str, int i11);
    }

    public interface IOnDetailInfoListener {
        void onDetailInfo(ITPPlayer iTPPlayer, TPPlayerDetailInfo tPPlayerDetailInfo);
    }

    public interface IOnErrorListener {
        void onError(ITPPlayer iTPPlayer, int i11, int i12, long j11, long j12);
    }

    public interface IOnInfoListener {
        void onInfo(ITPPlayer iTPPlayer, int i11, long j11, long j12, Object obj);
    }

    public interface IOnPreparedListener {
        void onPrepared(ITPPlayer iTPPlayer);
    }

    public interface IOnSeekCompleteListener {
        void onSeekComplete(ITPPlayer iTPPlayer);
    }

    public interface IOnStateChangeListener {
        void onStateChange(int i11, int i12);
    }

    public interface IOnStopAsyncCompleteListener {
        void onStopAsyncComplete(ITPPlayer iTPPlayer);
    }

    public interface IOnSubtitleDataListener {
        void onSubtitleData(ITPPlayer iTPPlayer, TPSubtitleData tPSubtitleData);
    }

    public interface IOnSubtitleFrameOutListener {
        void onSubtitleFrameOut(ITPPlayer iTPPlayer, TPSubtitleFrameBuffer tPSubtitleFrameBuffer);
    }

    public interface IOnVideoFrameOutListener {
        void onVideoFrameOut(ITPPlayer iTPPlayer, TPVideoFrameBuffer tPVideoFrameBuffer);
    }

    public interface IOnVideoProcessFrameOutputListener {
        TPPostProcessFrameBuffer onVideoProcessFrameOut(ITPPlayer iTPPlayer, TPPostProcessFrameBuffer tPPostProcessFrameBuffer);
    }

    public interface IOnVideoSizeChangedListener {
        void onVideoSizeChanged(ITPPlayer iTPPlayer, long j11, long j12);
    }
}
