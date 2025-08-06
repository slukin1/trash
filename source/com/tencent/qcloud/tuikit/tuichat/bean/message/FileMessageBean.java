package com.tencent.qcloud.tuikit.tuichat.bean.message;

import android.text.TextUtils;
import com.tencent.imsdk.v2.V2TIMDownloadCallback;
import com.tencent.imsdk.v2.V2TIMElem;
import com.tencent.imsdk.v2.V2TIMFileElem;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.FileReplyQuoteBean;
import java.io.File;

public class FileMessageBean extends TUIMessageBean {
    private String dataPath;
    private V2TIMFileElem fileElem;

    public interface FileDownloadCallback {
        void onError(int i11, String str);

        void onProgress(long j11, long j12);

        void onSuccess();
    }

    public void downloadFile(String str, final FileDownloadCallback fileDownloadCallback) {
        V2TIMFileElem v2TIMFileElem = this.fileElem;
        if (v2TIMFileElem != null) {
            v2TIMFileElem.downloadFile(str, new V2TIMDownloadCallback() {
                public void onError(int i11, String str) {
                    FileDownloadCallback fileDownloadCallback = fileDownloadCallback;
                    if (fileDownloadCallback != null) {
                        fileDownloadCallback.onError(i11, str);
                    }
                }

                public void onProgress(V2TIMElem.V2ProgressInfo v2ProgressInfo) {
                    FileDownloadCallback fileDownloadCallback = fileDownloadCallback;
                    if (fileDownloadCallback != null) {
                        fileDownloadCallback.onProgress(v2ProgressInfo.getCurrentSize(), v2ProgressInfo.getTotalSize());
                    }
                }

                public void onSuccess() {
                    FileDownloadCallback fileDownloadCallback = fileDownloadCallback;
                    if (fileDownloadCallback != null) {
                        fileDownloadCallback.onSuccess();
                    }
                }
            });
        }
    }

    public String getDataPath() {
        return this.dataPath;
    }

    public String getFileName() {
        V2TIMFileElem v2TIMFileElem = this.fileElem;
        return v2TIMFileElem != null ? v2TIMFileElem.getFileName() : "";
    }

    public int getFileSize() {
        V2TIMFileElem v2TIMFileElem = this.fileElem;
        if (v2TIMFileElem != null) {
            return v2TIMFileElem.getFileSize();
        }
        return 0;
    }

    public String getPath() {
        V2TIMFileElem v2TIMFileElem = this.fileElem;
        return v2TIMFileElem != null ? v2TIMFileElem.getPath() : "";
    }

    public Class<? extends TUIReplyQuoteBean> getReplyQuoteBeanClass() {
        return FileReplyQuoteBean.class;
    }

    public String getUUID() {
        V2TIMFileElem v2TIMFileElem = this.fileElem;
        return v2TIMFileElem != null ? v2TIMFileElem.getUUID() : "";
    }

    public String onGetDisplayString() {
        return getExtra();
    }

    public void onProcessMessage(V2TIMMessage v2TIMMessage) {
        if (getStatus() != 275) {
            V2TIMFileElem fileElem2 = v2TIMMessage.getFileElem();
            this.fileElem = fileElem2;
            String uuid = fileElem2.getUUID();
            if (TextUtils.isEmpty(uuid)) {
                uuid = System.currentTimeMillis() + this.fileElem.getFileName();
            }
            String str = TUIConfig.getFileDownloadDir() + uuid;
            if (new File(str).exists()) {
                if (isSelf()) {
                    setStatus(2);
                }
                setDownloadStatus(6);
            } else if (!isSelf()) {
                setDownloadStatus(5);
            } else if (TextUtils.isEmpty(this.fileElem.getPath())) {
                setDownloadStatus(5);
            } else if (new File(this.fileElem.getPath()).exists()) {
                setStatus(2);
                setDownloadStatus(6);
                str = this.fileElem.getPath();
            } else {
                setDownloadStatus(5);
            }
            setDataPath(str);
            setExtra(ServiceInitializer.getAppContext().getString(R.string.file_extra));
        }
    }

    public void setDataPath(String str) {
        this.dataPath = str;
    }
}
