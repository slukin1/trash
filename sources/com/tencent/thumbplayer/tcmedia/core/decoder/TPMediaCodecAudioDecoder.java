package com.tencent.thumbplayer.tcmedia.core.decoder;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Build;
import android.view.Surface;
import com.tencent.thumbplayer.tcmedia.core.common.TPCodecUtils;
import com.tencent.thumbplayer.tcmedia.core.common.TPNativeLog;
import com.tencent.thumbplayer.tcmedia.g.b;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class TPMediaCodecAudioDecoder extends TPBaseMediaCodecDecoder {
    private static final String TAG = "TPMediaCodecAudioDecoder";
    private int mAudioFormat = 0;
    private int mChannelCount = 0;
    private byte[] mCsd0Data = null;
    private boolean mEnableAudioPassThrough = false;
    private boolean mIsAdts = false;
    private ArrayList<String> mMimeCandidates = new ArrayList<>();
    private int mSampleRate = 0;

    public TPMediaCodecAudioDecoder(int i11) {
        super(i11);
    }

    public void configCodec(b bVar, String str) {
        TPNativeLog.printLog(2, TAG, "configCodec: ");
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat(str, this.mSampleRate, this.mChannelCount);
        byte[] bArr = this.mCsd0Data;
        if (bArr != null) {
            createAudioFormat.setByteBuffer("csd-0", ByteBuffer.wrap(bArr));
        }
        if (this.mIsAdts) {
            TPNativeLog.printLog(2, TAG, "configCodec: set is adts");
            createAudioFormat.setInteger("is-adts", 1);
        }
        bVar.a(createAudioFormat, (Surface) null, this.mMediaCrypto, 0);
    }

    public String getCodecName(String str, boolean z11) {
        return TPCodecUtils.getDecoderName(str, z11);
    }

    public String getLogTag() {
        return TAG;
    }

    public ArrayList<String> getMimeCandidates() {
        return this.mMimeCandidates;
    }

    public boolean initDecoder(String str, int i11, int i12, int i13, int i14) {
        TPNativeLog.printLog(2, TAG, "initDecoder, mimeType:" + str + " sampleRate:" + i11 + " channelCount:" + i12 + " drmType:" + i13 + " audioFormat:" + i14);
        this.mSampleRate = i11;
        this.mChannelCount = i12;
        this.mDrmType = i13;
        this.mAudioFormat = i14;
        this.mMimeCandidates.clear();
        this.mMimeCandidates.add(str);
        return true;
    }

    public boolean initDecoder(String str, int i11, int i12, int i13, Surface surface, int i14, int i15, int i16) {
        return false;
    }

    public void processMediaCodecException(Exception exc) {
    }

    public void processOutputBuffer(b bVar, int i11, MediaCodec.BufferInfo bufferInfo, TPFrameInfo tPFrameInfo) {
        tPFrameInfo.sampleRate = this.mSampleRate;
        tPFrameInfo.channelCount = this.mChannelCount;
        tPFrameInfo.format = this.mAudioFormat;
        ByteBuffer a11 = Build.VERSION.SDK_INT >= 21 ? bVar.a(i11) : bVar.k()[i11];
        byte[] bArr = null;
        if (a11 != null) {
            int i12 = bufferInfo.size;
            byte[] bArr2 = new byte[i12];
            a11.get(bArr2, bufferInfo.offset, i12);
            bArr = bArr2;
        }
        tPFrameInfo.data = bArr;
        if (bufferInfo.flags == 4 && bufferInfo.size <= 0) {
            TPNativeLog.printLog(2, TAG, "processOutputBuffer: bufferInfo.flags is BUFFER_FLAG_END_OF_STREAM, return EOS!");
            tPFrameInfo.errCode = 2;
        }
        bVar.a(i11, false);
    }

    public void processOutputConfigData(b bVar, int i11, MediaCodec.BufferInfo bufferInfo, TPFrameInfo tPFrameInfo) {
        bVar.a(i11, false);
        tPFrameInfo.errCode = 1;
    }

    public void processOutputFormatChanged(MediaFormat mediaFormat) {
        int i11;
        int i12;
        try {
            if (mediaFormat.containsKey("sample-rate")) {
                this.mSampleRate = mediaFormat.getInteger("sample-rate");
            }
            if (mediaFormat.containsKey("channel-count")) {
                this.mChannelCount = mediaFormat.getInteger("channel-count");
            }
            if (Build.VERSION.SDK_INT < 24 || !mediaFormat.containsKey("pcm-encoding")) {
                i11 = 2;
                TPNativeLog.printLog(2, TAG, "processOutputFormatChanged, mEnableAudioPassThrough:" + this.mEnableAudioPassThrough + ", mSampleRate: " + this.mSampleRate + ", mChannelCount: " + this.mChannelCount + " mAudioFormat: " + this.mAudioFormat + " pcmFormat:" + i11);
            }
            i11 = mediaFormat.getInteger("pcm-encoding");
            try {
                TPNativeLog.printLog(2, TAG, "processOutputFormatChanged: MediaFormat.KEY_PCM_ENCODING: ".concat(String.valueOf(i11)));
            } catch (Exception e11) {
                Exception exc = e11;
                i12 = i11;
                e = exc;
            }
            TPNativeLog.printLog(2, TAG, "processOutputFormatChanged, mEnableAudioPassThrough:" + this.mEnableAudioPassThrough + ", mSampleRate: " + this.mSampleRate + ", mChannelCount: " + this.mChannelCount + " mAudioFormat: " + this.mAudioFormat + " pcmFormat:" + i11);
        } catch (Exception e12) {
            e = e12;
            i12 = 2;
            TPNativeLog.printLog(4, TAG, "processOutputFormatChanged got one exception: " + getStackTrace(e));
            i11 = i12;
            TPNativeLog.printLog(2, TAG, "processOutputFormatChanged, mEnableAudioPassThrough:" + this.mEnableAudioPassThrough + ", mSampleRate: " + this.mSampleRate + ", mChannelCount: " + this.mChannelCount + " mAudioFormat: " + this.mAudioFormat + " pcmFormat:" + i11);
        }
    }

    public int setOperateRate(float f11) {
        return super.setOperateRate(f11);
    }

    public boolean setParamBool(int i11, boolean z11) {
        if (i11 == 2) {
            this.mIsAdts = z11;
            return true;
        } else if (i11 != 3) {
            return super.setParamBool(i11, z11);
        } else {
            this.mEnableAudioPassThrough = z11;
            String logTag = getLogTag();
            TPNativeLog.printLog(2, logTag, "setParamBool mEnableAudioPassThrough:" + this.mEnableAudioPassThrough);
            return true;
        }
    }

    public boolean setParamBytes(int i11, byte[] bArr) {
        if (i11 == 200) {
            this.mCsd0Data = bArr;
        }
        return super.setParamBytes(i11, bArr);
    }

    public boolean setParamObject(int i11, Object obj) {
        return super.setParamObject(i11, obj);
    }
}
