package com.iproov.sdk.p005class;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Size;
import android.view.Surface;
import com.iproov.sdk.logging.IPLog;
import com.iproov.sdk.utils.Cnew;
import java.io.IOException;
import java.nio.ByteBuffer;

/* renamed from: com.iproov.sdk.class.do  reason: invalid class name and invalid package */
public class Cdo {

    /* renamed from: else  reason: not valid java name */
    private static final String f174else = ("🎞 " + Cdo.class.getSimpleName());

    /* renamed from: case  reason: not valid java name */
    private Cdo f175case;

    /* renamed from: do  reason: not valid java name */
    private MediaCodec f176do;

    /* renamed from: for  reason: not valid java name */
    private boolean f177for;

    /* renamed from: if  reason: not valid java name */
    private long f178if = 0;

    /* renamed from: new  reason: not valid java name */
    private boolean f179new;

    /* renamed from: try  reason: not valid java name */
    private final Cif f180try;

    /* renamed from: com.iproov.sdk.class.do$do  reason: invalid class name */
    public enum Cdo {
        HARDWARE,
        SOFTWARE
    }

    /* renamed from: com.iproov.sdk.class.do$if  reason: invalid class name */
    public interface Cif {
        /* renamed from: do  reason: not valid java name */
        void m267do();

        /* renamed from: do  reason: not valid java name */
        void m268do(Ctry tryR);

        /* renamed from: do  reason: not valid java name */
        void m269do(Exception exc);
    }

    public Cdo(Size size, Cif ifVar, Cnew newR) {
        this.f180try = ifVar;
        m257do("AUTO-DETECTED ENCODER SETTINGS", newR.f204if.getName(), newR.f205new);
        MediaFormat mediaFormat = Cgoto.m280do(size, newR);
        try {
            this.f176do = m248do(newR.f204if, mediaFormat);
            this.f175case = Cdo.HARDWARE;
        } catch (Exception unused) {
            m257do("AUTO-FALLING BACK TO SOFTWARE ENCODER", newR.f203for.getName(), newR.f205new);
            mediaFormat.setInteger("color-format", newR.f205new);
            try {
                this.f176do = m248do(newR.f203for, mediaFormat);
                this.f175case = Cdo.SOFTWARE;
            } catch (Exception e11) {
                m256do(e11, ifVar, new Handler());
            }
        }
    }

    /* renamed from: for  reason: not valid java name */
    private long m259for() {
        long j11 = this.f178if;
        this.f178if = 33333 + j11;
        return j11;
    }

    /* renamed from: try  reason: not valid java name */
    private void m261try() {
        this.f177for = false;
        MediaCodec mediaCodec = this.f176do;
        if (mediaCodec != null) {
            try {
                mediaCodec.stop();
                this.f176do.release();
                this.f176do = null;
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    /* renamed from: case  reason: not valid java name */
    public void m262case() {
        HandlerThread handlerThread = new HandlerThread("EncoderCallback");
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        try {
            this.f176do.start();
            Cnew.m2282do("EncoderPoll", Cnew.Cfor.LOW, (Runnable) new c(this, handler, handlerThread)).start();
        } catch (Exception e11) {
            m256do(e11, this.f180try, handler);
        }
    }

    /* renamed from: do  reason: not valid java name */
    public void m264do(byte[] bArr) throws Cif {
        MediaCodec mediaCodec = this.f176do;
        if (mediaCodec != null) {
            try {
                m251do(mediaCodec.dequeueInputBuffer(-1), bArr);
            } catch (IllegalStateException e11) {
                e11.printStackTrace();
                throw new Cif(e11.getMessage());
            }
        } else {
            throw new Cif("Encoder is null. Cannot encode frame!");
        }
    }

    /* renamed from: if  reason: not valid java name */
    public Cdo m265if() {
        return this.f175case;
    }

    /* renamed from: new  reason: not valid java name */
    public boolean m266new() {
        return this.f177for;
    }

    /* renamed from: if  reason: not valid java name */
    private ByteBuffer m260if(int i11) {
        return this.f176do.getOutputBuffer(i11);
    }

    /* renamed from: do  reason: not valid java name */
    public void m263do() {
        MediaCodec mediaCodec;
        if (!this.f179new && (mediaCodec = this.f176do) != null) {
            this.f179new = true;
            try {
                this.f176do.queueInputBuffer(mediaCodec.dequeueInputBuffer(-1), 0, 0, m259for(), 4);
            } catch (IllegalStateException e11) {
                this.f180try.m269do((Exception) e11);
            }
        }
    }

    /* renamed from: do  reason: not valid java name */
    private void m256do(Exception exc, Cif ifVar, Handler handler) {
        String str = f174else;
        IPLog.e(str, "Encoder error: " + exc.getLocalizedMessage());
        exc.printStackTrace();
        m261try();
        handler.post(new a(ifVar, exc));
    }

    /* renamed from: do  reason: not valid java name */
    private static MediaCodec m248do(MediaCodecInfo mediaCodecInfo, MediaFormat mediaFormat) throws IOException, MediaCodec.CodecException {
        MediaCodec createByCodecName = MediaCodec.createByCodecName(mediaCodecInfo.getName());
        createByCodecName.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
        return createByCodecName;
    }

    /* access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public /* synthetic */ void m252do(Handler handler, HandlerThread handlerThread) {
        try {
            this.f177for = true;
            while (this.f177for) {
                MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                int dequeueOutputBuffer = this.f176do.dequeueOutputBuffer(bufferInfo, -1);
                if (dequeueOutputBuffer >= 0) {
                    m250do(dequeueOutputBuffer, m260if(dequeueOutputBuffer), bufferInfo, this.f180try, handler);
                }
                if ((bufferInfo.flags & 4) != 0) {
                    this.f177for = false;
                }
            }
            m261try();
            handler.post(new d(this, handlerThread));
        } catch (Exception e11) {
            m256do(e11, this.f180try, handler);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public /* synthetic */ void m253do(HandlerThread handlerThread) {
        this.f180try.m267do();
        handlerThread.quit();
    }

    /* renamed from: do  reason: not valid java name */
    private void m250do(int i11, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, Cif ifVar, Handler handler) {
        if (i11 >= 0) {
            byte[] bArr = m258do(byteBuffer, bufferInfo);
            int length = bArr.length;
            int i12 = bufferInfo.flags;
            if (bArr.length > 0) {
                handler.post(new b(ifVar, bArr, bufferInfo));
            }
            this.f176do.releaseOutputBuffer(i11, false);
        }
    }

    /* renamed from: do  reason: not valid java name */
    private static byte[] m258do(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        byteBuffer.position(bufferInfo.offset);
        byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
        byte[] bArr = new byte[bufferInfo.size];
        byteBuffer.get(bArr);
        byteBuffer.position(bufferInfo.offset);
        return bArr;
    }

    /* renamed from: do  reason: not valid java name */
    private void m251do(int i11, byte[] bArr) {
        if (i11 >= 0) {
            ByteBuffer byteBuffer = m249do(i11);
            if (byteBuffer != null) {
                byteBuffer.clear();
                byteBuffer.put(bArr);
            }
            this.f176do.queueInputBuffer(i11, 0, bArr.length, m259for(), 0);
        }
    }

    /* renamed from: do  reason: not valid java name */
    private ByteBuffer m249do(int i11) {
        return this.f176do.getInputBuffer(i11);
    }

    /* renamed from: do  reason: not valid java name */
    private static void m257do(String str, String str2, int i11) {
        Integer.toHexString(i11);
    }
}
