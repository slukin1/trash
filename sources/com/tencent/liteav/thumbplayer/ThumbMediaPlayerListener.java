package com.tencent.liteav.thumbplayer;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.rtmp.TXVodConstants;
import com.tencent.thumbplayer.tcmedia.api.ITPPlayer;
import com.tencent.thumbplayer.tcmedia.api.ITPPlayerListener;
import com.tencent.thumbplayer.tcmedia.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.tcmedia.api.TPPlayerMsg;
import com.tencent.thumbplayer.tcmedia.api.TPPostProcessFrameBuffer;
import com.tencent.thumbplayer.tcmedia.api.TPSubtitleData;
import com.tencent.thumbplayer.tcmedia.api.TPSubtitleFrameBuffer;
import com.tencent.thumbplayer.tcmedia.api.TPVideoFrameBuffer;
import com.xiaomi.mipush.sdk.Constants;

class ThumbMediaPlayerListener implements ITPPlayerListener.IOnAudioFrameOutputListener, ITPPlayerListener.IOnAudioProcessFrameOutputListener, ITPPlayerListener.IOnCompletionListener, ITPPlayerListener.IOnErrorListener, ITPPlayerListener.IOnInfoListener, ITPPlayerListener.IOnPreparedListener, ITPPlayerListener.IOnSeekCompleteListener, ITPPlayerListener.IOnStateChangeListener, ITPPlayerListener.IOnStopAsyncCompleteListener, ITPPlayerListener.IOnSubtitleDataListener, ITPPlayerListener.IOnSubtitleFrameOutListener, ITPPlayerListener.IOnVideoFrameOutListener, ITPPlayerListener.IOnVideoProcessFrameOutputListener, ITPPlayerListener.IOnVideoSizeChangedListener {
    private static final int ERROR_DEMUXER_PREPARE_TIMEOUT = 1104;
    private final String TAG = ThumbMediaPlayerListener.class.getName();
    private final ThumbMediaPlayer mThumbMediaPlayer;

    public ThumbMediaPlayerListener(ThumbMediaPlayer thumbMediaPlayer) {
        this.mThumbMediaPlayer = thumbMediaPlayer;
    }

    private int transferError(int i11, int i12) {
        ThumbMediaPlayer thumbMediaPlayer;
        String propertyString;
        int i13 = TXVodConstants.VOD_PLAY_ERR_GENERAL;
        if (i11 != 1001) {
            if (i11 != 1100) {
                if (i11 != 1200) {
                    if (i11 == 1300) {
                        i13 = TXVodConstants.VOD_PLAY_ERR_RENDER_FAIL;
                    } else if (i11 == 1600) {
                        i13 = TXVodConstants.VOD_PLAY_ERR_PROCESS_VIDEO_FAIL;
                    } else if (i11 == 4000) {
                        i13 = TXVodConstants.VOD_PLAY_ERR_DOWNLOAD_FAIL;
                    } else if (i11 == 1210 || i11 == 1211) {
                        i13 = TXVodConstants.VOD_PLAY_ERR_DECODE_AUDIO_FAIL;
                    } else if (!(i11 == 1220 || i11 == 1221)) {
                        if (i11 == 1230 || i11 == 1231) {
                            i13 = TXVodConstants.VOD_PLAY_ERR_DECODE_SUBTITLE_FAIL;
                        } else if (i11 == 2000) {
                            i13 = TXVodConstants.VOD_PLAY_ERR_SYSTEM_PLAY_FAIL;
                        } else if (i11 != 2001) {
                            switch (i11) {
                                case 1102:
                                    break;
                                case 1103:
                                case 1104:
                                    i13 = TXVodConstants.VOD_PLAY_ERR_DEMUXER_TIMEOUT;
                                    break;
                            }
                        } else {
                            i13 = -2301;
                        }
                    }
                }
                i13 = TXVodConstants.VOD_PLAY_ERR_DECODE_VIDEO_FAIL;
                if (i11 == 1220 && (thumbMediaPlayer = this.mThumbMediaPlayer) != null && (propertyString = thumbMediaPlayer.getTPPPlayer().getPropertyString(0)) != null && (propertyString.toLowerCase().contains("hevc") || propertyString.toLowerCase().contains("h265"))) {
                    i13 = -2304;
                }
            }
            i13 = TXVodConstants.VOD_PLAY_ERR_DEMUXER_FAIL;
            if (i12 >= 11070000 && i12 < 11080000) {
                i13 = TXVodConstants.VOD_PLAY_ERR_DRM;
            }
        } else if (i12 == 11010104) {
            i13 = -2305;
        }
        LiteavLog.i(this.TAG, "[transferError], errorType: " + i11 + " ,errorCode: " + i12 + " ,vodErrorEvent: " + i13);
        return i13;
    }

    private int transferInfo(int i11) {
        if (i11 == 4) {
            return TXVodConstants.VOD_PLAY_EVT_SELECT_TRACK_COMPLETE;
        }
        if (i11 == 104) {
            return 2008;
        }
        if (i11 == 106) {
            ThumbMediaPlayer thumbMediaPlayer = this.mThumbMediaPlayer;
            if (thumbMediaPlayer != null) {
                thumbMediaPlayer.onReceiveFirstVideoRenderEvent();
            }
        } else if (i11 == 503) {
            return TXVodConstants.VOD_PLAY_EVT_VIDEO_SEI;
        } else {
            if (i11 == 1001) {
                LiteavLog.i(this.TAG, "TP_PLAYER_INFO_LONG0_ALL_DOWNLOAD_FINISH");
                ThumbMediaPlayer thumbMediaPlayer2 = this.mThumbMediaPlayer;
                if (thumbMediaPlayer2 != null) {
                    thumbMediaPlayer2.updateTcpSpeed(0);
                }
            } else if (i11 == 1006) {
                return 1006;
            } else {
                if (i11 == 1018) {
                    return 2002;
                }
                if (i11 == 200) {
                    return 2007;
                }
                if (i11 != 201) {
                    return -1;
                }
                return 2014;
            }
        }
        return -1;
    }

    public void attachToPlayer() {
        ITPPlayer tPPPlayer;
        ThumbMediaPlayer thumbMediaPlayer = this.mThumbMediaPlayer;
        if (thumbMediaPlayer != null && (tPPPlayer = thumbMediaPlayer.getTPPPlayer()) != null) {
            tPPPlayer.setOnPreparedListener(this);
            tPPPlayer.setOnCompletionListener(this);
            tPPPlayer.setOnInfoListener(this);
            tPPPlayer.setOnErrorListener(this);
            tPPPlayer.setOnSeekCompleteListener(this);
            tPPPlayer.setOnVideoSizeChangedListener(this);
            tPPPlayer.setOnSubtitleDataListener(this);
            tPPPlayer.setOnSubtitleFrameOutListener(this);
            tPPPlayer.setOnVideoFrameOutListener(this);
            tPPPlayer.setOnAudioFrameOutputListener(this);
            tPPPlayer.setOnVideoProcessFrameOutputListener(this);
            tPPPlayer.setOnAudioProcessFrameOutputListener(this);
            tPPPlayer.setOnPlayerStateChangeListener(this);
            tPPPlayer.setOnStopAsyncCompleteListener(this);
        }
    }

    public void onAudioFrameOut(ITPPlayer iTPPlayer, TPAudioFrameBuffer tPAudioFrameBuffer) {
        LiteavLog.i(this.TAG, "ThumbMediaPlayerListener onAudioFrameOut");
    }

    public TPPostProcessFrameBuffer onAudioProcessFrameOut(ITPPlayer iTPPlayer, TPPostProcessFrameBuffer tPPostProcessFrameBuffer) {
        return tPPostProcessFrameBuffer;
    }

    public void onCompletion(ITPPlayer iTPPlayer) {
        ThumbMediaPlayer thumbMediaPlayer = this.mThumbMediaPlayer;
        if (thumbMediaPlayer != null) {
            thumbMediaPlayer.notifyOnCompletion();
        }
    }

    public void onError(ITPPlayer iTPPlayer, int i11, int i12, long j11, long j12) {
        if (i11 != 1000) {
            String str = this.TAG;
            LiteavLog.w(str, "onError type: " + i11 + " code: " + i12 + " arg1: " + j11 + " arg2: " + j12);
            ThumbMediaPlayer thumbMediaPlayer = this.mThumbMediaPlayer;
            if (thumbMediaPlayer != null) {
                thumbMediaPlayer.notifyOnError(transferError(i11, i12), i12);
            }
        }
    }

    public void onInfo(ITPPlayer iTPPlayer, int i11, long j11, long j12, Object obj) {
        String str;
        String[] split;
        ThumbMediaPlayer thumbMediaPlayer = this.mThumbMediaPlayer;
        if (thumbMediaPlayer != null) {
            int transferInfo = transferInfo(i11);
            int i12 = (int) j11;
            if (obj != null && (obj instanceof TPPlayerMsg.TPCDNURLInfo)) {
                TPPlayerMsg.TPCDNURLInfo tPCDNURLInfo = (TPPlayerMsg.TPCDNURLInfo) obj;
                String str2 = this.TAG;
                LiteavLog.i(str2, "onInfo TPCDNURLInfo:cdnIp:" + tPCDNURLInfo.cdnIp + ":uIp:" + tPCDNURLInfo.uIp + ": url: " + tPCDNURLInfo.url + ":errorStr: " + tPCDNURLInfo.errorStr);
            }
            if (obj != null && (obj instanceof TPPlayerMsg.TPDownLoadProgressInfo)) {
                TPPlayerMsg.TPDownLoadProgressInfo tPDownLoadProgressInfo = (TPPlayerMsg.TPDownLoadProgressInfo) obj;
                thumbMediaPlayer.updateBitrate(tPDownLoadProgressInfo.totalFileSize);
                long j13 = (long) tPDownLoadProgressInfo.downloadSpeedKBps;
                if (j13 < 0 && (str = tPDownLoadProgressInfo.extraInfo) != null && (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null) {
                    int length = split.length;
                    int i13 = 0;
                    while (true) {
                        if (i13 < length) {
                            String str3 = split[i13];
                            if (str3 != null && str3.contains("httpAvgSpeedKB")) {
                                j13 = Long.valueOf(str3.substring(str3.indexOf(":") + 1, str3.length()).trim()).longValue();
                                break;
                            }
                            i13++;
                        } else {
                            break;
                        }
                    }
                }
                thumbMediaPlayer.updateTcpSpeed(j13 * 1024);
            }
            if (obj instanceof TPPlayerMsg.TPVideoCropInfo) {
                TPPlayerMsg.TPVideoCropInfo tPVideoCropInfo = (TPPlayerMsg.TPVideoCropInfo) obj;
                String str4 = this.TAG;
                LiteavLog.i(str4, "onInfo TPVideoCropInfo:cropBottom:" + tPVideoCropInfo.cropBottom + ":cropLeft:" + tPVideoCropInfo.cropLeft + ": cropRight: " + tPVideoCropInfo.cropRight + ":cropTop: " + tPVideoCropInfo.cropTop + ":height:" + tPVideoCropInfo.height + ":width:" + tPVideoCropInfo.width);
            }
            thumbMediaPlayer.notifyOnInfo(transferInfo, i12, (int) j12, obj);
        }
    }

    public void onPrepared(ITPPlayer iTPPlayer) {
        LiteavLog.i(this.TAG, "ThumbMediaPlayerListener onPrepared");
        ThumbMediaPlayer thumbMediaPlayer = this.mThumbMediaPlayer;
        if (thumbMediaPlayer != null) {
            thumbMediaPlayer.notifyOnPrepared();
        }
    }

    public void onSeekComplete(ITPPlayer iTPPlayer) {
        LiteavLog.i(this.TAG, "ThumbMediaPlayerListener onSeekComplete");
        ThumbMediaPlayer thumbMediaPlayer = this.mThumbMediaPlayer;
        if (thumbMediaPlayer != null) {
            thumbMediaPlayer.notifyOnSeekComplete();
        }
    }

    public void onStateChange(int i11, int i12) {
        String str = this.TAG;
        LiteavLog.i(str, "ThumbMediaPlayerListener onStateChange:preState" + i11 + ": curState:" + i12);
    }

    public void onStopAsyncComplete(ITPPlayer iTPPlayer) {
        LiteavLog.i(this.TAG, "ThumbMediaPlayerListener onStopAsyncComplete");
    }

    public void onSubtitleData(ITPPlayer iTPPlayer, TPSubtitleData tPSubtitleData) {
        ThumbMediaPlayer thumbMediaPlayer = this.mThumbMediaPlayer;
        if (thumbMediaPlayer != null && tPSubtitleData != null) {
            thumbMediaPlayer.notifyOnSubtitleData(tPSubtitleData);
        }
    }

    public void onSubtitleFrameOut(ITPPlayer iTPPlayer, TPSubtitleFrameBuffer tPSubtitleFrameBuffer) {
        ThumbMediaPlayer thumbMediaPlayer = this.mThumbMediaPlayer;
        if (thumbMediaPlayer != null) {
            thumbMediaPlayer.notifySubtitleFrameData(tPSubtitleFrameBuffer);
        }
    }

    public void onVideoFrameOut(ITPPlayer iTPPlayer, TPVideoFrameBuffer tPVideoFrameBuffer) {
        LiteavLog.i(this.TAG, "ThumbMediaPlayerListener onVideoFrameOut");
    }

    public TPPostProcessFrameBuffer onVideoProcessFrameOut(ITPPlayer iTPPlayer, TPPostProcessFrameBuffer tPPostProcessFrameBuffer) {
        LiteavLog.i(this.TAG, "ThumbMediaPlayerListener onVideoProcessFrameOut");
        return tPPostProcessFrameBuffer;
    }

    public void onVideoSizeChanged(ITPPlayer iTPPlayer, long j11, long j12) {
        ThumbMediaPlayer thumbMediaPlayer = this.mThumbMediaPlayer;
        if (thumbMediaPlayer != null) {
            String str = this.TAG;
            LiteavLog.i(str, "ThumbMediaPlayerListener on:videoSizeChanged:width:" + j11 + ":height:" + j12);
            thumbMediaPlayer.notifyOnVideoSizeChanged((int) j11, (int) j12, thumbMediaPlayer.getVideoSarNum(), thumbMediaPlayer.getVideoSarDen(), (String) null);
        }
    }
}
