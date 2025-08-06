package com.tencent.thumbplayer.tcmedia.adapter.a;

import com.tencent.thumbplayer.tcmedia.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.tcmedia.api.TPCommonEnum;
import com.tencent.thumbplayer.tcmedia.api.TPDrmInfo;
import com.tencent.thumbplayer.tcmedia.api.TPPlayerDetailInfo;
import com.tencent.thumbplayer.tcmedia.api.TPPostProcessFrameBuffer;
import com.tencent.thumbplayer.tcmedia.api.TPRemoteSdpInfo;
import com.tencent.thumbplayer.tcmedia.api.TPSubtitleData;
import com.tencent.thumbplayer.tcmedia.api.TPSubtitleFrameBuffer;
import com.tencent.thumbplayer.tcmedia.api.TPVideoFrameBuffer;

public class c {

    public interface a {
        void a(TPAudioFrameBuffer tPAudioFrameBuffer);
    }

    public interface b {
        TPPostProcessFrameBuffer b(TPPostProcessFrameBuffer tPPostProcessFrameBuffer);
    }

    /* renamed from: com.tencent.thumbplayer.tcmedia.adapter.a.c$c  reason: collision with other inner class name */
    public interface C0614c {
        void b();
    }

    public interface d {
        TPRemoteSdpInfo a(String str, int i11);

        void d();
    }

    public interface e {
        void a(TPPlayerDetailInfo tPPlayerDetailInfo);
    }

    public interface f {
        void a(@TPCommonEnum.TPErrorType int i11, int i12, long j11, long j12);
    }

    public interface g {
        void a(TPDrmInfo tPDrmInfo);
    }

    public interface h {
        void a(int i11, long j11, long j12, Object obj);
    }

    public interface i {
        void a();
    }

    public interface j {
        void c();
    }

    public interface k {
        void b(int i11, int i12);
    }

    public interface l {
        void a(TPSubtitleData tPSubtitleData);
    }

    public interface m {
        void a(TPSubtitleFrameBuffer tPSubtitleFrameBuffer);
    }

    public interface n {
        void a(TPVideoFrameBuffer tPVideoFrameBuffer);
    }

    public interface o {
        TPPostProcessFrameBuffer a(TPPostProcessFrameBuffer tPPostProcessFrameBuffer);
    }

    public interface p {
        void a(long j11, long j12);
    }
}
