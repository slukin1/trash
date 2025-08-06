package com.tencent.thumbplayer.tcmedia.core.player;

import android.content.Context;
import android.os.Build;
import android.view.Surface;
import com.tencent.thumbplayer.tcmedia.core.common.TPAudioPassThroughPluginDetector;
import com.tencent.thumbplayer.tcmedia.core.common.TPGeneralError;
import com.tencent.thumbplayer.tcmedia.core.common.TPHeadsetPluginDetector;
import com.tencent.thumbplayer.tcmedia.core.common.TPMediaTrackDashFormat;
import com.tencent.thumbplayer.tcmedia.core.common.TPMediaTrackInfo;
import com.tencent.thumbplayer.tcmedia.core.common.TPNativeLibraryLoader;
import com.tencent.thumbplayer.tcmedia.core.common.TPNativeLog;
import com.tencent.thumbplayer.tcmedia.core.common.TPScreenRefreshRateDetector;
import com.tencent.thumbplayer.tcmedia.core.common.TPSystemInfo;
import com.tencent.thumbplayer.tcmedia.core.demuxer.ITPNativeDemuxerCallback;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

public class TPNativePlayer {
    private Context mContext = null;
    private long mNativeContext;
    private int m_playerID = -1;

    public TPNativePlayer(Context context) {
        this.mContext = context.getApplicationContext();
        TPNativeLibraryLoader.loadLibIfNeeded(context);
        try {
            this.m_playerID = _createPlayer();
            TPHeadsetPluginDetector.init(this.mContext);
            TPAudioPassThroughPluginDetector.init(this.mContext);
            if (Build.VERSION.SDK_INT >= 17) {
                TPScreenRefreshRateDetector.init(this.mContext);
            }
            TPSystemInfo.initAudioBestSettings(this.mContext);
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, "Failed to create native player:" + th2.getMessage());
            throw new UnsupportedOperationException("Failed to create native player");
        }
    }

    private native int _addAudioTrackSource(String str, String str2);

    private native int _addAudioTrackSourceWithHttpHeader(String str, String str2, Object[] objArr);

    private native int _addInitConfigQueueInt(int i11, int i12);

    private native int _addInitConfigQueueString(int i11, String str);

    private native int _addSubtitleTrackSource(String str, String str2);

    private native int _addSubtitleTrackSourceWithHttpHeader(String str, String str2, Object[] objArr);

    private native int _applyInitConfig();

    private native int _createPlayer();

    private native int _deselectTrackAsync(int i11, long j11);

    private native long _getBufferedDurationMs();

    private native long _getBufferedSize();

    private native int _getContainerType(int i11);

    private native long _getCurrentPositionMs();

    private native long _getDemuxerOffsetInFile();

    private native long _getDurationMs();

    private native TPDynamicStatisticParams _getDynamicStatisticParams(boolean z11);

    private native TPGeneralPlayFlowParams _getGeneralPlayFlowParams();

    private static native Object _getPlayerCoreParams(int i11);

    private native int _getPlayerID();

    private native int _getProgramCount();

    private native TPNativePlayerProgramInfo _getProgramInfo(int i11);

    private native long _getPropertyLong(int i11);

    private native String _getPropertyString(int i11);

    private native int _getTrackCount();

    private native TPMediaTrackDashFormat _getTrackDashFormat(int i11);

    private native TPNativePlayerHlsTag _getTrackHlsTag(int i11);

    private native boolean _getTrackIsExclusive(int i11);

    private native boolean _getTrackIsInternal(int i11);

    private native boolean _getTrackIsSelected(int i11);

    private native String _getTrackName(int i11);

    private native int _getTrackType(int i11);

    private native int _getVideoHeight();

    private native int _getVideoWidth();

    private native int _pause();

    private native int _prepare();

    private native int _prepareAsync();

    private native int _release();

    private native int _reset();

    private native int _resetInitConfig();

    private native int _resume();

    private native int _seekToAsync(int i11, int i12, long j11);

    private native int _selectProgramAsync(int i11, long j11);

    private native int _selectTrackAsync(int i11, long j11);

    private native int _setAudioFrameCallback(Object obj);

    private native int _setAudioMute(boolean z11);

    private native int _setAudioNormalizeVolumeParams(String str);

    private native int _setAudioVolume(float f11);

    private native int _setDataSource(String str);

    private native int _setDataSourceFd(int i11, long j11, long j12);

    private native int _setDataSourceWithHttpHeader(String str, Object[] objArr);

    private native int _setDemuxerCallback(Object obj);

    private native int _setEventRecordCallback(Object obj);

    private native int _setInitConfigBool(int i11, boolean z11);

    private native int _setInitConfigFloat(int i11, float f11);

    private native int _setInitConfigInt(int i11, int i12);

    private native int _setInitConfigLong(int i11, long j11);

    private native int _setInitConfigObject(int i11, Object obj);

    private native int _setInitConfigString(int i11, String str);

    private native int _setLoopback(boolean z11, long j11, long j12);

    private native int _setMessageCallback(Object obj);

    private native int _setOptionLong(int i11, long j11, long j12);

    private native int _setOptionObject(int i11, Object obj);

    private native int _setPlaybackRate(float f11);

    private native int _setPostProcessFrameCallback(Object obj);

    private native int _setSubtitleFrameCallback(Object obj);

    private native int _setVideoFrameCallback(Object obj);

    private native int _setVideoSurface(Surface surface);

    private native int _setVideoSurfaceWithType(Surface surface, int i11);

    private native int _start();

    private native int _stop();

    private native int _switchDefinitionAsync(String str, int i11, long j11);

    private native int _switchDefinitionAsyncWithHttpHeader(String str, Object[] objArr, int i11, long j11);

    public int addAudioTrackSource(String str, String str2) {
        try {
            return _addAudioTrackSource(str, str2);
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return TPGeneralError.FAILED;
        }
    }

    public int addAudioTrackSource(String str, String str2, Map<String, String> map) {
        try {
            return _addAudioTrackSourceWithHttpHeader(str, str2, TPNativePlayerUtils.tpMapStringToStringArray(map));
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return TPGeneralError.FAILED;
        }
    }

    public int addSubtitleTrackSource(String str, String str2) {
        try {
            return _addSubtitleTrackSource(str, str2);
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return TPGeneralError.FAILED;
        }
    }

    public int addSubtitleTrackSource(String str, String str2, Map<String, String> map) {
        try {
            return _addSubtitleTrackSourceWithHttpHeader(str, str2, TPNativePlayerUtils.tpMapStringToStringArray(map));
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return TPGeneralError.FAILED;
        }
    }

    public int deselectTrackAsync(int i11, long j11) {
        try {
            return _deselectTrackAsync(i11, j11);
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return TPGeneralError.FAILED;
        }
    }

    public long getBufferedDurationMs() {
        try {
            return _getBufferedDurationMs();
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return 0;
        }
    }

    public long getBufferedSize() {
        try {
            return _getBufferedSize();
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return 0;
        }
    }

    public long getCurrentPositionMs() {
        try {
            return _getCurrentPositionMs();
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return 0;
        }
    }

    public long getDemuxerOffsetInFile() {
        try {
            return _getDemuxerOffsetInFile();
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return -1;
        }
    }

    public long getDurationMs() {
        try {
            return _getDurationMs();
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return 0;
        }
    }

    public TPDynamicStatisticParams getDynamicStatisticParams(boolean z11) {
        try {
            return _getDynamicStatisticParams(z11);
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return null;
        }
    }

    public TPGeneralPlayFlowParams getGeneralPlayFlowParams() {
        try {
            return _getGeneralPlayFlowParams();
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return null;
        }
    }

    public Object getPlayerCoreParams(int i11) {
        return null;
    }

    public int getPlayerID() {
        try {
            return _getPlayerID();
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return 0;
        }
    }

    public int getProgramCount() {
        try {
            return _getProgramCount();
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return TPGeneralError.FAILED;
        }
    }

    public TPNativePlayerProgramInfo[] getProgramInfo() {
        try {
            int _getProgramCount = _getProgramCount();
            TPNativePlayerProgramInfo[] tPNativePlayerProgramInfoArr = new TPNativePlayerProgramInfo[_getProgramCount];
            for (int i11 = 0; i11 < _getProgramCount; i11++) {
                tPNativePlayerProgramInfoArr[i11] = _getProgramInfo(i11);
            }
            return tPNativePlayerProgramInfoArr;
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return null;
        }
    }

    public long getPropertyLong(int i11) {
        try {
            return _getPropertyLong(i11);
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return 0;
        }
    }

    public String getPropertyString(int i11) {
        try {
            return _getPropertyString(i11);
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return "";
        }
    }

    public TPMediaTrackInfo[] getTrackInfo() {
        try {
            int _getTrackCount = _getTrackCount();
            if (_getTrackCount <= 0) {
                return null;
            }
            TPMediaTrackInfo[] tPMediaTrackInfoArr = new TPMediaTrackInfo[_getTrackCount];
            for (int i11 = 0; i11 < _getTrackCount; i11++) {
                tPMediaTrackInfoArr[i11] = new TPMediaTrackInfo();
                tPMediaTrackInfoArr[i11].trackType = _getTrackType(i11);
                tPMediaTrackInfoArr[i11].contianerType = _getContainerType(i11);
                tPMediaTrackInfoArr[i11].trackName = _getTrackName(i11);
                tPMediaTrackInfoArr[i11].isSelected = _getTrackIsSelected(i11);
                tPMediaTrackInfoArr[i11].isExclusive = _getTrackIsExclusive(i11);
                tPMediaTrackInfoArr[i11].isInternal = _getTrackIsInternal(i11);
                if (tPMediaTrackInfoArr[i11].contianerType == 1) {
                    TPNativePlayerHlsTag _getTrackHlsTag = _getTrackHlsTag(i11);
                    tPMediaTrackInfoArr[i11].hlsTag.name = _getTrackHlsTag.name;
                    tPMediaTrackInfoArr[i11].hlsTag.language = _getTrackHlsTag.language;
                    tPMediaTrackInfoArr[i11].hlsTag.groupId = _getTrackHlsTag.groupId;
                    tPMediaTrackInfoArr[i11].hlsTag.resolution = _getTrackHlsTag.resolution;
                    tPMediaTrackInfoArr[i11].hlsTag.codecs = _getTrackHlsTag.codecs;
                    tPMediaTrackInfoArr[i11].hlsTag.framerate = _getTrackHlsTag.framerate;
                    tPMediaTrackInfoArr[i11].hlsTag.bandwidth = _getTrackHlsTag.bandwidth;
                } else if (tPMediaTrackInfoArr[i11].contianerType == 2) {
                    tPMediaTrackInfoArr[i11].dashFormat = _getTrackDashFormat(i11);
                }
            }
            return tPMediaTrackInfoArr;
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return null;
        }
    }

    public int getVideoHeight() {
        try {
            return _getVideoHeight();
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return 0;
        }
    }

    public int getVideoWidth() {
        try {
            return _getVideoWidth();
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return 0;
        }
    }

    public int pause() {
        try {
            return _pause();
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return TPGeneralError.FAILED;
        }
    }

    public int prepare() {
        try {
            return _prepare();
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return TPGeneralError.FAILED;
        }
    }

    public int prepareAsync() {
        try {
            return _prepareAsync();
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return TPGeneralError.FAILED;
        }
    }

    public void release() {
        try {
            _release();
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
        }
    }

    public void reset() {
        try {
            _reset();
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
        }
    }

    public int seekToAsync(int i11, int i12, long j11) {
        try {
            return _seekToAsync(i11, i12, j11);
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return TPGeneralError.FAILED;
        }
    }

    public int selectProgramAsync(int i11, long j11) {
        try {
            return _selectProgramAsync(i11, j11);
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return TPGeneralError.FAILED;
        }
    }

    public int selectTrackAsync(int i11, long j11) {
        try {
            return _selectTrackAsync(i11, j11);
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return TPGeneralError.FAILED;
        }
    }

    public int setAudioFrameCallback(ITPNativePlayerAudioFrameCallback iTPNativePlayerAudioFrameCallback) {
        try {
            return _setAudioFrameCallback(iTPNativePlayerAudioFrameCallback);
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return TPGeneralError.FAILED;
        }
    }

    public int setAudioMute(boolean z11) {
        try {
            return _setAudioMute(z11);
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return TPGeneralError.FAILED;
        }
    }

    public int setAudioNormalizeVolumeParams(String str) {
        try {
            return _setAudioNormalizeVolumeParams(str);
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return TPGeneralError.FAILED;
        }
    }

    public int setAudioVolume(float f11) {
        try {
            return _setAudioVolume(f11);
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return TPGeneralError.FAILED;
        }
    }

    public int setDataSource(int i11, long j11, long j12) {
        try {
            return _setDataSourceFd(i11, j11, j12);
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return TPGeneralError.FAILED;
        }
    }

    public int setDataSource(String str) {
        try {
            return _setDataSource(str);
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return TPGeneralError.FAILED;
        }
    }

    public int setDataSource(String str, Map<String, String> map) {
        try {
            return _setDataSourceWithHttpHeader(str, TPNativePlayerUtils.tpMapStringToStringArray(map));
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return TPGeneralError.FAILED;
        }
    }

    public int setDemuxerCallback(ITPNativeDemuxerCallback iTPNativeDemuxerCallback) {
        try {
            return _setDemuxerCallback(iTPNativeDemuxerCallback);
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return TPGeneralError.FAILED;
        }
    }

    public int setEventRecordCallback(ITPNativePlayerEventRecordCallback iTPNativePlayerEventRecordCallback) {
        try {
            return _setEventRecordCallback(iTPNativePlayerEventRecordCallback);
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return TPGeneralError.FAILED;
        }
    }

    public void setInitConfig(TPNativePlayerInitConfig tPNativePlayerInitConfig) {
        try {
            _resetInitConfig();
            HashMap<Integer, Integer> intMap = tPNativePlayerInitConfig.getIntMap();
            HashMap<Integer, Long> longMap = tPNativePlayerInitConfig.getLongMap();
            HashMap<Integer, Float> floatMap = tPNativePlayerInitConfig.getFloatMap();
            HashMap<Integer, Boolean> boolMap = tPNativePlayerInitConfig.getBoolMap();
            HashMap<Integer, Vector<Integer>> queueIntMap = tPNativePlayerInitConfig.getQueueIntMap();
            HashMap<Integer, Object> objectMap = tPNativePlayerInitConfig.getObjectMap();
            HashMap<Integer, String> stringMap = tPNativePlayerInitConfig.getStringMap();
            for (Map.Entry next : intMap.entrySet()) {
                _setInitConfigInt(((Integer) next.getKey()).intValue(), ((Integer) next.getValue()).intValue());
            }
            for (Map.Entry next2 : longMap.entrySet()) {
                _setInitConfigLong(((Integer) next2.getKey()).intValue(), ((Long) next2.getValue()).longValue());
            }
            for (Map.Entry next3 : floatMap.entrySet()) {
                _setInitConfigFloat(((Integer) next3.getKey()).intValue(), ((Float) next3.getValue()).floatValue());
            }
            for (Map.Entry next4 : boolMap.entrySet()) {
                _setInitConfigBool(((Integer) next4.getKey()).intValue(), ((Boolean) next4.getValue()).booleanValue());
            }
            for (Map.Entry next5 : objectMap.entrySet()) {
                _setInitConfigObject(((Integer) next5.getKey()).intValue(), next5.getValue());
            }
            for (Map.Entry next6 : queueIntMap.entrySet()) {
                Vector vector = (Vector) next6.getValue();
                if (vector != null) {
                    Iterator it2 = vector.iterator();
                    while (it2.hasNext()) {
                        _addInitConfigQueueInt(((Integer) next6.getKey()).intValue(), ((Integer) it2.next()).intValue());
                    }
                }
            }
            for (Map.Entry next7 : stringMap.entrySet()) {
                Object value = next7.getValue();
                _setInitConfigString(((Integer) next7.getKey()).intValue(), value != null ? (String) value : null);
            }
            for (Map.Entry next8 : tPNativePlayerInitConfig.getQueueStringMap().entrySet()) {
                Vector vector2 = (Vector) next8.getValue();
                if (vector2 != null) {
                    Iterator it3 = vector2.iterator();
                    while (it3.hasNext()) {
                        _addInitConfigQueueString(((Integer) next8.getKey()).intValue(), (String) it3.next());
                    }
                }
            }
            _applyInitConfig();
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
        }
    }

    public int setLoopback(boolean z11, long j11, long j12) {
        try {
            return _setLoopback(z11, j11, j12);
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return TPGeneralError.FAILED;
        }
    }

    public int setMessageCallback(ITPNativePlayerMessageCallback iTPNativePlayerMessageCallback) {
        try {
            return _setMessageCallback(iTPNativePlayerMessageCallback);
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return TPGeneralError.FAILED;
        }
    }

    public int setOptionLong(int i11, long j11, long j12) {
        try {
            return _setOptionLong(i11, j11, j12);
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return TPGeneralError.FAILED;
        }
    }

    public int setOptionObject(int i11, Object obj) {
        try {
            return _setOptionObject(i11, obj);
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return TPGeneralError.FAILED;
        }
    }

    public int setPlaybackRate(float f11) {
        try {
            return _setPlaybackRate(f11);
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return TPGeneralError.FAILED;
        }
    }

    public int setPostProcessFrameCallback(ITPNativePlayerPostProcessFrameCallback iTPNativePlayerPostProcessFrameCallback) {
        try {
            return _setPostProcessFrameCallback(iTPNativePlayerPostProcessFrameCallback);
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return TPGeneralError.FAILED;
        }
    }

    public int setSubtitleFrameCallback(ITPNativePlayerSubtitleFrameCallback iTPNativePlayerSubtitleFrameCallback) {
        try {
            return _setSubtitleFrameCallback(iTPNativePlayerSubtitleFrameCallback);
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return TPGeneralError.FAILED;
        }
    }

    public int setVideoFrameCallback(ITPNativePlayerVideoFrameCallback iTPNativePlayerVideoFrameCallback) {
        try {
            return _setVideoFrameCallback(iTPNativePlayerVideoFrameCallback);
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return TPGeneralError.FAILED;
        }
    }

    public int setVideoSurface(Surface surface) {
        try {
            return _setVideoSurface(surface);
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return TPGeneralError.FAILED;
        }
    }

    public int setVideoSurfaceWithType(Surface surface, int i11) {
        try {
            return _setVideoSurfaceWithType(surface, i11);
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return TPGeneralError.FAILED;
        }
    }

    public int start() {
        try {
            return _start();
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return TPGeneralError.FAILED;
        }
    }

    public int stop() {
        try {
            return _stop();
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return TPGeneralError.FAILED;
        }
    }

    public int switchDefinitionAsync(String str, int i11, long j11) {
        try {
            return _switchDefinitionAsync(str, i11, j11);
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return TPGeneralError.FAILED;
        }
    }

    @Deprecated
    public int switchDefinitionAsync(String str, long j11) {
        return switchDefinitionAsync(str, 0, j11);
    }

    public int switchDefinitionAsync(String str, Map<String, String> map, int i11, long j11) {
        try {
            return _switchDefinitionAsyncWithHttpHeader(str, TPNativePlayerUtils.tpMapStringToStringArray(map), i11, j11);
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return TPGeneralError.FAILED;
        }
    }
}
