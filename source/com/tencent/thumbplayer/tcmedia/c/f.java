package com.tencent.thumbplayer.tcmedia.c;

import com.tencent.thumbplayer.tcmedia.api.proxy.ITPPreloadProxy;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.ITPPlayListener;
import com.tencent.thumbplayer.tcmedia.utils.TPLogUtil;
import java.util.Map;

public class f implements ITPPreloadProxy.IPreloadListener, ITPPlayListener {

    /* renamed from: a  reason: collision with root package name */
    private String f49094a;

    public f(String str) {
        this.f49094a = str;
    }

    public long getAdvRemainTime() {
        TPLogUtil.i(this.f49094a, " empty proxy player listener , notify , getAdvRemainTime");
        return 0;
    }

    public String getContentType(int i11, String str) {
        return null;
    }

    public int getCurrentPlayClipNo() {
        TPLogUtil.i(this.f49094a, " empty proxy player listener , notify , getCurrentPlayClipNo");
        return 0;
    }

    public long getCurrentPlayOffset() {
        TPLogUtil.i(this.f49094a, " empty proxy player listener , notify , getCurrentPlayOffset");
        return -1;
    }

    public long getCurrentPosition() {
        TPLogUtil.i(this.f49094a, " empty proxy player listener , notify , getCurrentPosition");
        return 0;
    }

    public String getDataFilePath(int i11, String str) {
        return null;
    }

    public long getDataTotalSize(int i11, String str) {
        return 0;
    }

    public Object getPlayInfo(long j11) {
        TPLogUtil.i(this.f49094a, " empty proxy player listener , notify , getPlayInfo with type : ".concat(String.valueOf(j11)));
        return null;
    }

    public Object getPlayInfo(String str) {
        TPLogUtil.i(this.f49094a, " empty proxy player listener , notify , getPlayInfo with key : ".concat(String.valueOf(str)));
        return null;
    }

    public long getPlayerBufferLength() {
        TPLogUtil.i(this.f49094a, " empty proxy player listener , notify , getPlayerBufferLength");
        return 0;
    }

    public void onDownloadCdnUrlExpired(Map<String, String> map) {
    }

    public void onDownloadCdnUrlInfoUpdate(String str, String str2, String str3, String str4) {
    }

    public void onDownloadCdnUrlUpdate(String str) {
    }

    public void onDownloadError(int i11, int i12, String str) {
    }

    public void onDownloadFinish() {
    }

    public void onDownloadProgressUpdate(int i11, int i12, long j11, long j12, String str) {
        String str2 = this.f49094a;
        TPLogUtil.i(str2, " empty proxy player listener , notify , onPlayProgress, current : " + j11 + ", total : " + j12);
    }

    public void onDownloadProtocolUpdate(String str, String str2) {
    }

    public void onDownloadStatusUpdate(int i11) {
    }

    public Object onPlayCallback(int i11, Object obj, Object obj2, Object obj3, Object obj4) {
        String str = this.f49094a;
        TPLogUtil.i(str, " empty proxy player listener , notify , onPlayCallback, messageType : " + i11 + ",ext1:" + obj + ",ext2:" + obj2 + ",ext3" + obj3 + ",ext4" + obj4);
        return null;
    }

    public void onPrepareDownloadProgressUpdate(int i11, int i12, long j11, long j12) {
    }

    public void onPrepareError() {
        TPLogUtil.i(this.f49094a, " empty proxy player listener , notify , onPrepareError : ");
    }

    public void onPrepareSuccess() {
        TPLogUtil.i(this.f49094a, " empty proxy player listener , notify , onPrepareSuccess : ");
    }

    public int onReadData(int i11, String str, long j11, long j12) {
        return 0;
    }

    public int onStartReadData(int i11, String str, long j11, long j12) {
        return 0;
    }

    public int onStopReadData(int i11, String str, int i12) {
        return 0;
    }
}
