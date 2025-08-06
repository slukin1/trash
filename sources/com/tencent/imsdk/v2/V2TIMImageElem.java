package com.tencent.imsdk.v2;

import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.message.DownloadParam;
import com.tencent.imsdk.message.DownloadProgressInfo;
import com.tencent.imsdk.message.ImageElement;
import com.tencent.imsdk.message.MessageCenter;
import com.tencent.imsdk.v2.V2TIMElem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class V2TIMImageElem extends V2TIMElem {
    public static final int V2TIM_IMAGE_TYPE_LARGE = 2;
    public static final int V2TIM_IMAGE_TYPE_ORIGIN = 0;
    public static final int V2TIM_IMAGE_TYPE_THUMB = 1;
    private ImageElement timImageElem;

    public class V2TIMImage implements Serializable {
        private int height;
        private int size;
        private int type;
        private String url;
        private String uuid;
        private int width;

        public V2TIMImage() {
        }

        public void downloadImage(String str, final V2TIMDownloadCallback v2TIMDownloadCallback) {
            DownloadParam downloadParam = new DownloadParam();
            downloadParam.setDownloadUrl(this.url);
            downloadParam.setFileSavePath(str);
            MessageCenter.getInstance().downloadMessageElement(downloadParam, new IMCallback<DownloadProgressInfo>(new V2TIMValueCallback<DownloadProgressInfo>() {
                public void onError(int i11, String str) {
                    V2TIMDownloadCallback v2TIMDownloadCallback = v2TIMDownloadCallback;
                    if (v2TIMDownloadCallback != null) {
                        v2TIMDownloadCallback.onError(i11, str);
                    }
                }

                public void onSuccess(DownloadProgressInfo downloadProgressInfo) {
                    V2TIMElem.V2ProgressInfo v2ProgressInfo = new V2TIMElem.V2ProgressInfo(downloadProgressInfo.getCurrentSize(), downloadProgressInfo.getTotalSize());
                    V2TIMDownloadCallback v2TIMDownloadCallback = v2TIMDownloadCallback;
                    if (v2TIMDownloadCallback != null) {
                        v2TIMDownloadCallback.onProgress(v2ProgressInfo);
                    }
                }
            }) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(DownloadProgressInfo downloadProgressInfo) {
                    super.success(downloadProgressInfo);
                }
            }, new IMCallback(new V2TIMCallback() {
                public void onError(int i11, String str) {
                    V2TIMDownloadCallback v2TIMDownloadCallback = v2TIMDownloadCallback;
                    if (v2TIMDownloadCallback != null) {
                        v2TIMDownloadCallback.onError(i11, str);
                    }
                }

                public void onSuccess() {
                    V2TIMDownloadCallback v2TIMDownloadCallback = v2TIMDownloadCallback;
                    if (v2TIMDownloadCallback != null) {
                        v2TIMDownloadCallback.onSuccess();
                    }
                }
            }) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        }

        public int getHeight() {
            return this.height;
        }

        public int getSize() {
            return this.size;
        }

        public int getType() {
            return this.type;
        }

        public String getUUID() {
            return this.uuid;
        }

        public String getUrl() {
            return this.url;
        }

        public int getWidth() {
            return this.width;
        }

        public void setHeight(int i11) {
            this.height = i11;
        }

        public void setSize(int i11) {
            this.size = i11;
        }

        public void setType(int i11) {
            this.type = i11;
        }

        public void setUUID(String str) {
            this.uuid = str;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public void setWidth(int i11) {
            this.width = i11;
        }
    }

    public List<V2TIMImage> getImageList() {
        if (getElement() == null) {
            return null;
        }
        this.timImageElem = (ImageElement) getElement();
        ArrayList arrayList = new ArrayList();
        V2TIMImage v2TIMImage = new V2TIMImage();
        v2TIMImage.setUUID(this.timImageElem.getOriginImageUUID());
        v2TIMImage.setType(0);
        v2TIMImage.setSize(this.timImageElem.getOriginImageFileSize());
        v2TIMImage.setWidth(this.timImageElem.getOriginImageWidth());
        v2TIMImage.setHeight(this.timImageElem.getOriginImageHeight());
        v2TIMImage.setUrl(this.timImageElem.getOriginImageUrl());
        arrayList.add(v2TIMImage);
        V2TIMImage v2TIMImage2 = new V2TIMImage();
        v2TIMImage2.setUUID(this.timImageElem.getLargeImageUUID());
        v2TIMImage2.setType(2);
        v2TIMImage2.setSize(this.timImageElem.getLargeImageFileSize());
        v2TIMImage2.setWidth(this.timImageElem.getLargeImageWidth());
        v2TIMImage2.setHeight(this.timImageElem.getLargeImageHeight());
        v2TIMImage2.setUrl(this.timImageElem.getLargeImageUrl());
        arrayList.add(v2TIMImage2);
        V2TIMImage v2TIMImage3 = new V2TIMImage();
        v2TIMImage3.setUUID(this.timImageElem.getThumbImageUUID());
        v2TIMImage3.setType(1);
        v2TIMImage3.setSize(this.timImageElem.getThumbImageFileSize());
        v2TIMImage3.setWidth(this.timImageElem.getThumbImageWidth());
        v2TIMImage3.setHeight(this.timImageElem.getThumbImageHeight());
        v2TIMImage3.setUrl(this.timImageElem.getThumbImageUrl());
        arrayList.add(v2TIMImage3);
        return arrayList;
    }

    public String getPath() {
        if (getElement() == null) {
            return null;
        }
        ImageElement imageElement = (ImageElement) getElement();
        this.timImageElem = imageElement;
        return imageElement.getOriginImageFilePath();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("V2TIMImageElem--->");
        sb2.append(", localPath=");
        sb2.append(getPath());
        for (V2TIMImage next : getImageList()) {
            sb2.append(", type:");
            sb2.append(next.getType());
            sb2.append(", uuid:");
            sb2.append(next.getUUID());
            sb2.append(", height:");
            sb2.append(next.getHeight());
            sb2.append(", width:");
            sb2.append(next.getWidth());
            sb2.append(", size:");
            sb2.append(next.getSize());
            sb2.append(", url:" + next.getUrl());
        }
        return sb2.toString();
    }
}
