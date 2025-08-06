package com.tencent.thumbplayer.tcmedia.tplayer;

import android.text.TextUtils;
import com.tencent.thumbplayer.tcmedia.api.ITPPlayer;
import com.tencent.thumbplayer.tcmedia.api.ITPPlayerListener;
import com.tencent.thumbplayer.tcmedia.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.tcmedia.api.TPPlayerDetailInfo;
import com.tencent.thumbplayer.tcmedia.api.TPPostProcessFrameBuffer;
import com.tencent.thumbplayer.tcmedia.api.TPRemoteSdpInfo;
import com.tencent.thumbplayer.tcmedia.api.TPSubtitleData;
import com.tencent.thumbplayer.tcmedia.api.TPSubtitleFrameBuffer;
import com.tencent.thumbplayer.tcmedia.api.TPVideoFrameBuffer;
import com.tencent.thumbplayer.tcmedia.utils.TPLogUtil;

public class c implements ITPPlayerListener.IOnAudioFrameOutputListener, ITPPlayerListener.IOnAudioProcessFrameOutputListener, ITPPlayerListener.IOnCompletionListener, ITPPlayerListener.IOnDemuxerListener, ITPPlayerListener.IOnDetailInfoListener, ITPPlayerListener.IOnErrorListener, ITPPlayerListener.IOnInfoListener, ITPPlayerListener.IOnPreparedListener, ITPPlayerListener.IOnSeekCompleteListener, ITPPlayerListener.IOnStateChangeListener, ITPPlayerListener.IOnStopAsyncCompleteListener, ITPPlayerListener.IOnSubtitleDataListener, ITPPlayerListener.IOnSubtitleFrameOutListener, ITPPlayerListener.IOnVideoFrameOutListener, ITPPlayerListener.IOnVideoProcessFrameOutputListener, ITPPlayerListener.IOnVideoSizeChangedListener {

    /* renamed from: a  reason: collision with root package name */
    private ITPPlayerListener.IOnPreparedListener f49598a;

    /* renamed from: b  reason: collision with root package name */
    private ITPPlayerListener.IOnCompletionListener f49599b;

    /* renamed from: c  reason: collision with root package name */
    private ITPPlayerListener.IOnInfoListener f49600c;

    /* renamed from: d  reason: collision with root package name */
    private ITPPlayerListener.IOnErrorListener f49601d;

    /* renamed from: e  reason: collision with root package name */
    private ITPPlayerListener.IOnSeekCompleteListener f49602e;

    /* renamed from: f  reason: collision with root package name */
    private ITPPlayerListener.IOnVideoSizeChangedListener f49603f;

    /* renamed from: g  reason: collision with root package name */
    private ITPPlayerListener.IOnSubtitleDataListener f49604g;

    /* renamed from: h  reason: collision with root package name */
    private ITPPlayerListener.IOnSubtitleFrameOutListener f49605h;

    /* renamed from: i  reason: collision with root package name */
    private ITPPlayerListener.IOnVideoFrameOutListener f49606i;

    /* renamed from: j  reason: collision with root package name */
    private ITPPlayerListener.IOnAudioFrameOutputListener f49607j;

    /* renamed from: k  reason: collision with root package name */
    private ITPPlayerListener.IOnVideoProcessFrameOutputListener f49608k;

    /* renamed from: l  reason: collision with root package name */
    private ITPPlayerListener.IOnAudioProcessFrameOutputListener f49609l;

    /* renamed from: m  reason: collision with root package name */
    private ITPPlayerListener.IOnStateChangeListener f49610m;

    /* renamed from: n  reason: collision with root package name */
    private ITPPlayerListener.IOnStopAsyncCompleteListener f49611n;

    /* renamed from: o  reason: collision with root package name */
    private ITPPlayerListener.IOnDetailInfoListener f49612o;

    /* renamed from: p  reason: collision with root package name */
    private ITPPlayerListener.IOnDemuxerListener f49613p;

    /* renamed from: q  reason: collision with root package name */
    private a f49614q;

    /* renamed from: r  reason: collision with root package name */
    private String f49615r = "TPPlayerListenerS";

    public static class a implements ITPPlayerListener.IOnAudioFrameOutputListener, ITPPlayerListener.IOnAudioProcessFrameOutputListener, ITPPlayerListener.IOnCompletionListener, ITPPlayerListener.IOnDemuxerListener, ITPPlayerListener.IOnDetailInfoListener, ITPPlayerListener.IOnErrorListener, ITPPlayerListener.IOnInfoListener, ITPPlayerListener.IOnPreparedListener, ITPPlayerListener.IOnSeekCompleteListener, ITPPlayerListener.IOnStateChangeListener, ITPPlayerListener.IOnStopAsyncCompleteListener, ITPPlayerListener.IOnSubtitleDataListener, ITPPlayerListener.IOnSubtitleFrameOutListener, ITPPlayerListener.IOnVideoFrameOutListener, ITPPlayerListener.IOnVideoProcessFrameOutputListener, ITPPlayerListener.IOnVideoSizeChangedListener {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public String f49616a;

        public a(String str) {
            this.f49616a = str;
        }

        public void onAudioFrameOut(ITPPlayer iTPPlayer, TPAudioFrameBuffer tPAudioFrameBuffer) {
            TPLogUtil.i(this.f49616a, " empty player listener , notify , onAudioFrameOut");
        }

        public TPPostProcessFrameBuffer onAudioProcessFrameOut(ITPPlayer iTPPlayer, TPPostProcessFrameBuffer tPPostProcessFrameBuffer) {
            TPLogUtil.i(this.f49616a, " empty player listener , notify , onPostProcessFrameOut");
            return null;
        }

        public void onCompletion(ITPPlayer iTPPlayer) {
            TPLogUtil.i(this.f49616a, " empty player listener , notify , onCompletion");
        }

        public void onDetailInfo(ITPPlayer iTPPlayer, TPPlayerDetailInfo tPPlayerDetailInfo) {
            TPLogUtil.i(this.f49616a, " empty player listener , notify , onDetailInfo");
        }

        public void onError(ITPPlayer iTPPlayer, int i11, int i12, long j11, long j12) {
            TPLogUtil.i(this.f49616a, " empty player listener , notify , onError");
        }

        public void onInfo(ITPPlayer iTPPlayer, int i11, long j11, long j12, Object obj) {
            TPLogUtil.i(this.f49616a, " empty player listener , notify , onInfo");
        }

        public void onPrepared(ITPPlayer iTPPlayer) {
            TPLogUtil.i(this.f49616a, " empty player listener , notify , onPrepared");
        }

        public TPRemoteSdpInfo onSdpExchange(ITPPlayer iTPPlayer, String str, int i11) {
            TPLogUtil.i(this.f49616a, " empty player listener , notify , onSdpExchange");
            return null;
        }

        public void onSeekComplete(ITPPlayer iTPPlayer) {
            TPLogUtil.i(this.f49616a, " empty player listener , notify , onSeekComplete");
        }

        public void onStateChange(int i11, int i12) {
            TPLogUtil.i(this.f49616a, " empty player listener , notify , onStateChange");
        }

        public void onStopAsyncComplete(ITPPlayer iTPPlayer) {
            TPLogUtil.i(this.f49616a, " empty player listener , notify , onStopAsyncComplete");
        }

        public void onSubtitleData(ITPPlayer iTPPlayer, TPSubtitleData tPSubtitleData) {
            TPLogUtil.i(this.f49616a, " empty player listener , notify , onSubtitleData");
        }

        public void onSubtitleFrameOut(ITPPlayer iTPPlayer, TPSubtitleFrameBuffer tPSubtitleFrameBuffer) {
            TPLogUtil.i(this.f49616a, " empty player listener , notify , onSubtitleFrameOut");
        }

        public void onVideoFrameOut(ITPPlayer iTPPlayer, TPVideoFrameBuffer tPVideoFrameBuffer) {
            TPLogUtil.i(this.f49616a, " empty player listener , notify , onVideoFrameOut");
        }

        public TPPostProcessFrameBuffer onVideoProcessFrameOut(ITPPlayer iTPPlayer, TPPostProcessFrameBuffer tPPostProcessFrameBuffer) {
            TPLogUtil.i(this.f49616a, " empty player listener , notify , onPostProcessFrameOut");
            return null;
        }

        public void onVideoSizeChanged(ITPPlayer iTPPlayer, long j11, long j12) {
            TPLogUtil.i(this.f49616a, " empty player listener , notify , onVideoSizeChanged");
        }
    }

    public c(String str) {
        a(str);
        a aVar = new a(this.f49615r);
        this.f49614q = aVar;
        this.f49598a = aVar;
        this.f49599b = aVar;
        this.f49600c = aVar;
        this.f49601d = aVar;
        this.f49602e = aVar;
        this.f49603f = aVar;
        this.f49604g = aVar;
        this.f49605h = aVar;
        this.f49606i = aVar;
        this.f49607j = aVar;
        this.f49608k = aVar;
        this.f49609l = aVar;
        this.f49610m = aVar;
        this.f49611n = aVar;
        this.f49612o = aVar;
        this.f49613p = aVar;
    }

    public void a() {
        a aVar = this.f49614q;
        this.f49598a = aVar;
        this.f49599b = aVar;
        this.f49600c = aVar;
        this.f49601d = aVar;
        this.f49602e = aVar;
        this.f49603f = aVar;
        this.f49604g = aVar;
        this.f49606i = aVar;
        this.f49607j = aVar;
        this.f49610m = aVar;
        this.f49611n = aVar;
        this.f49612o = aVar;
        this.f49613p = aVar;
    }

    public void a(ITPPlayerListener.IOnAudioFrameOutputListener iOnAudioFrameOutputListener) {
        if (iOnAudioFrameOutputListener == null) {
            iOnAudioFrameOutputListener = this.f49614q;
        }
        this.f49607j = iOnAudioFrameOutputListener;
    }

    public void a(ITPPlayerListener.IOnAudioProcessFrameOutputListener iOnAudioProcessFrameOutputListener) {
        if (iOnAudioProcessFrameOutputListener == null) {
            iOnAudioProcessFrameOutputListener = this.f49614q;
        }
        this.f49609l = iOnAudioProcessFrameOutputListener;
    }

    public void a(ITPPlayerListener.IOnCompletionListener iOnCompletionListener) {
        if (iOnCompletionListener == null) {
            iOnCompletionListener = this.f49614q;
        }
        this.f49599b = iOnCompletionListener;
    }

    public void a(ITPPlayerListener.IOnDemuxerListener iOnDemuxerListener) {
        if (iOnDemuxerListener == null) {
            iOnDemuxerListener = this.f49614q;
        }
        this.f49613p = iOnDemuxerListener;
    }

    public void a(ITPPlayerListener.IOnDetailInfoListener iOnDetailInfoListener) {
        if (iOnDetailInfoListener == null) {
            iOnDetailInfoListener = this.f49614q;
        }
        this.f49612o = iOnDetailInfoListener;
    }

    public void a(ITPPlayerListener.IOnErrorListener iOnErrorListener) {
        if (iOnErrorListener == null) {
            iOnErrorListener = this.f49614q;
        }
        this.f49601d = iOnErrorListener;
    }

    public void a(ITPPlayerListener.IOnInfoListener iOnInfoListener) {
        if (iOnInfoListener == null) {
            iOnInfoListener = this.f49614q;
        }
        this.f49600c = iOnInfoListener;
    }

    public void a(ITPPlayerListener.IOnPreparedListener iOnPreparedListener) {
        if (iOnPreparedListener == null) {
            iOnPreparedListener = this.f49614q;
        }
        this.f49598a = iOnPreparedListener;
    }

    public void a(ITPPlayerListener.IOnSeekCompleteListener iOnSeekCompleteListener) {
        if (iOnSeekCompleteListener == null) {
            iOnSeekCompleteListener = this.f49614q;
        }
        this.f49602e = iOnSeekCompleteListener;
    }

    public void a(ITPPlayerListener.IOnStateChangeListener iOnStateChangeListener) {
        if (iOnStateChangeListener == null) {
            iOnStateChangeListener = this.f49614q;
        }
        this.f49610m = iOnStateChangeListener;
    }

    public void a(ITPPlayerListener.IOnStopAsyncCompleteListener iOnStopAsyncCompleteListener) {
        if (iOnStopAsyncCompleteListener == null) {
            iOnStopAsyncCompleteListener = this.f49614q;
        }
        this.f49611n = iOnStopAsyncCompleteListener;
    }

    public void a(ITPPlayerListener.IOnSubtitleDataListener iOnSubtitleDataListener) {
        if (iOnSubtitleDataListener == null) {
            iOnSubtitleDataListener = this.f49614q;
        }
        this.f49604g = iOnSubtitleDataListener;
    }

    public void a(ITPPlayerListener.IOnSubtitleFrameOutListener iOnSubtitleFrameOutListener) {
        if (iOnSubtitleFrameOutListener == null) {
            iOnSubtitleFrameOutListener = this.f49614q;
        }
        this.f49605h = iOnSubtitleFrameOutListener;
    }

    public void a(ITPPlayerListener.IOnVideoFrameOutListener iOnVideoFrameOutListener) {
        if (iOnVideoFrameOutListener == null) {
            iOnVideoFrameOutListener = this.f49614q;
        }
        this.f49606i = iOnVideoFrameOutListener;
    }

    public void a(ITPPlayerListener.IOnVideoProcessFrameOutputListener iOnVideoProcessFrameOutputListener) {
        if (iOnVideoProcessFrameOutputListener == null) {
            iOnVideoProcessFrameOutputListener = this.f49614q;
        }
        this.f49608k = iOnVideoProcessFrameOutputListener;
    }

    public void a(ITPPlayerListener.IOnVideoSizeChangedListener iOnVideoSizeChangedListener) {
        if (iOnVideoSizeChangedListener == null) {
            iOnVideoSizeChangedListener = this.f49614q;
        }
        this.f49603f = iOnVideoSizeChangedListener;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f49615r = "TPPlayerListenerS";
        } else {
            this.f49615r = str;
        }
        a aVar = this.f49614q;
        if (aVar != null) {
            String unused = aVar.f49616a = str;
        }
    }

    public void onAudioFrameOut(ITPPlayer iTPPlayer, TPAudioFrameBuffer tPAudioFrameBuffer) {
        this.f49607j.onAudioFrameOut(iTPPlayer, tPAudioFrameBuffer);
    }

    public TPPostProcessFrameBuffer onAudioProcessFrameOut(ITPPlayer iTPPlayer, TPPostProcessFrameBuffer tPPostProcessFrameBuffer) {
        return this.f49609l.onAudioProcessFrameOut(iTPPlayer, tPPostProcessFrameBuffer);
    }

    public void onCompletion(ITPPlayer iTPPlayer) {
        this.f49599b.onCompletion(iTPPlayer);
    }

    public void onDetailInfo(ITPPlayer iTPPlayer, TPPlayerDetailInfo tPPlayerDetailInfo) {
        this.f49612o.onDetailInfo(iTPPlayer, tPPlayerDetailInfo);
    }

    public void onError(ITPPlayer iTPPlayer, int i11, int i12, long j11, long j12) {
        this.f49601d.onError(iTPPlayer, i11, i12, j11, j12);
    }

    public void onInfo(ITPPlayer iTPPlayer, int i11, long j11, long j12, Object obj) {
        this.f49600c.onInfo(iTPPlayer, i11, j11, j12, obj);
    }

    public void onPrepared(ITPPlayer iTPPlayer) {
        this.f49598a.onPrepared(iTPPlayer);
    }

    public TPRemoteSdpInfo onSdpExchange(ITPPlayer iTPPlayer, String str, int i11) {
        return this.f49613p.onSdpExchange(iTPPlayer, str, i11);
    }

    public void onSeekComplete(ITPPlayer iTPPlayer) {
        this.f49602e.onSeekComplete(iTPPlayer);
    }

    public void onStateChange(int i11, int i12) {
        this.f49610m.onStateChange(i11, i12);
    }

    public void onStopAsyncComplete(ITPPlayer iTPPlayer) {
        this.f49611n.onStopAsyncComplete(iTPPlayer);
    }

    public void onSubtitleData(ITPPlayer iTPPlayer, TPSubtitleData tPSubtitleData) {
        this.f49604g.onSubtitleData(iTPPlayer, tPSubtitleData);
    }

    public void onSubtitleFrameOut(ITPPlayer iTPPlayer, TPSubtitleFrameBuffer tPSubtitleFrameBuffer) {
        this.f49605h.onSubtitleFrameOut(iTPPlayer, tPSubtitleFrameBuffer);
    }

    public void onVideoFrameOut(ITPPlayer iTPPlayer, TPVideoFrameBuffer tPVideoFrameBuffer) {
        this.f49606i.onVideoFrameOut(iTPPlayer, tPVideoFrameBuffer);
    }

    public TPPostProcessFrameBuffer onVideoProcessFrameOut(ITPPlayer iTPPlayer, TPPostProcessFrameBuffer tPPostProcessFrameBuffer) {
        return this.f49608k.onVideoProcessFrameOut(iTPPlayer, tPPostProcessFrameBuffer);
    }

    public void onVideoSizeChanged(ITPPlayer iTPPlayer, long j11, long j12) {
        this.f49603f.onVideoSizeChanged(iTPPlayer, j11, j12);
    }
}
