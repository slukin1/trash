package com.tencent.qcloud.tuikit.tuichat.bean.message;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.imsdk.v2.V2TIMDownloadCallback;
import com.tencent.imsdk.v2.V2TIMElem;
import com.tencent.imsdk.v2.V2TIMImageElem;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIReplyQuoteBean;
import com.tencent.qcloud.tuikit.timcommon.util.ImageUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.ImageReplyQuoteBean;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ImageMessageBean extends TUIMessageBean {
    public static final int IMAGE_TYPE_LARGE = 2;
    public static final int IMAGE_TYPE_ORIGIN = 0;
    public static final int IMAGE_TYPE_THUMB = 1;
    private String dataPath;
    private String dataUri;
    private List<ImageBean> imageBeanList;
    private V2TIMImageElem imageElem;
    private int imgHeight;
    private int imgWidth;

    public static class ImageBean implements Serializable {
        private V2TIMImageElem.V2TIMImage v2TIMImage;

        public interface ImageDownloadCallback {
            void onError(int i11, String str);

            void onProgress(long j11, long j12);

            void onSuccess();
        }

        public void downloadImage(String str, final ImageDownloadCallback imageDownloadCallback) {
            V2TIMImageElem.V2TIMImage v2TIMImage2 = this.v2TIMImage;
            if (v2TIMImage2 != null) {
                v2TIMImage2.downloadImage(str, new V2TIMDownloadCallback() {
                    public void onError(int i11, String str) {
                        ImageDownloadCallback imageDownloadCallback = imageDownloadCallback;
                        if (imageDownloadCallback != null) {
                            imageDownloadCallback.onError(i11, str);
                        }
                    }

                    public void onProgress(V2TIMElem.V2ProgressInfo v2ProgressInfo) {
                        ImageDownloadCallback imageDownloadCallback = imageDownloadCallback;
                        if (imageDownloadCallback != null) {
                            imageDownloadCallback.onProgress(v2ProgressInfo.getCurrentSize(), v2ProgressInfo.getTotalSize());
                        }
                    }

                    public void onSuccess() {
                        ImageDownloadCallback imageDownloadCallback = imageDownloadCallback;
                        if (imageDownloadCallback != null) {
                            imageDownloadCallback.onSuccess();
                        }
                    }
                });
            }
        }

        public int getHeight() {
            V2TIMImageElem.V2TIMImage v2TIMImage2 = this.v2TIMImage;
            if (v2TIMImage2 != null) {
                return v2TIMImage2.getHeight();
            }
            return 0;
        }

        public int getSize() {
            V2TIMImageElem.V2TIMImage v2TIMImage2 = this.v2TIMImage;
            if (v2TIMImage2 != null) {
                return v2TIMImage2.getSize();
            }
            return 0;
        }

        public int getType() {
            V2TIMImageElem.V2TIMImage v2TIMImage2 = this.v2TIMImage;
            if (v2TIMImage2 != null) {
                return v2TIMImage2.getType();
            }
            return 1;
        }

        public String getUUID() {
            V2TIMImageElem.V2TIMImage v2TIMImage2 = this.v2TIMImage;
            return v2TIMImage2 != null ? v2TIMImage2.getUUID() : "";
        }

        public String getUrl() {
            V2TIMImageElem.V2TIMImage v2TIMImage2 = this.v2TIMImage;
            return v2TIMImage2 != null ? v2TIMImage2.getUrl() : "";
        }

        public V2TIMImageElem.V2TIMImage getV2TIMImage() {
            return this.v2TIMImage;
        }

        public int getWidth() {
            V2TIMImageElem.V2TIMImage v2TIMImage2 = this.v2TIMImage;
            if (v2TIMImage2 != null) {
                return v2TIMImage2.getWidth();
            }
            return 0;
        }

        public void setV2TIMImage(V2TIMImageElem.V2TIMImage v2TIMImage2) {
            this.v2TIMImage = v2TIMImage2;
        }
    }

    public String getDataPath() {
        return this.dataPath;
    }

    public Uri getDataUriObj() {
        if (!TextUtils.isEmpty(this.dataUri)) {
            return Uri.parse(this.dataUri);
        }
        return null;
    }

    public List<ImageBean> getImageBeanList() {
        return this.imageBeanList;
    }

    public int getImgHeight() {
        return this.imgHeight;
    }

    public int getImgWidth() {
        return this.imgWidth;
    }

    public String getPath() {
        V2TIMImageElem v2TIMImageElem = this.imageElem;
        return v2TIMImageElem != null ? v2TIMImageElem.getPath() : "";
    }

    public Class<? extends TUIReplyQuoteBean> getReplyQuoteBeanClass() {
        return ImageReplyQuoteBean.class;
    }

    public String onGetDisplayString() {
        return getExtra();
    }

    public void onProcessMessage(V2TIMMessage v2TIMMessage) {
        V2TIMImageElem imageElem2 = v2TIMMessage.getImageElem();
        this.imageElem = imageElem2;
        List<V2TIMImageElem.V2TIMImage> imageList = imageElem2.getImageList();
        if (imageList != null) {
            ArrayList arrayList = new ArrayList();
            for (V2TIMImageElem.V2TIMImage v2TIMImage : imageList) {
                ImageBean imageBean = new ImageBean();
                imageBean.setV2TIMImage(v2TIMImage);
                arrayList.add(imageBean);
            }
            this.imageBeanList = arrayList;
        }
        String path = this.imageElem.getPath();
        if (!isSelf() || TextUtils.isEmpty(path) || !new File(path).exists()) {
            List<V2TIMImageElem.V2TIMImage> imageList2 = this.imageElem.getImageList();
            for (int i11 = 0; i11 < imageList2.size(); i11++) {
                V2TIMImageElem.V2TIMImage v2TIMImage2 = imageList2.get(i11);
                if (v2TIMImage2.getType() == 0) {
                    this.imgWidth = v2TIMImage2.getWidth();
                    this.imgHeight = v2TIMImage2.getHeight();
                }
                if (v2TIMImage2.getType() == 1) {
                    String generateImagePath = ImageUtil.generateImagePath(v2TIMImage2.getUUID(), 1);
                    if (new File(generateImagePath).exists()) {
                        this.dataPath = generateImagePath;
                    }
                }
            }
        } else {
            this.dataPath = path;
            int[] imageSize = ImageUtil.getImageSize(path);
            this.imgWidth = imageSize[0];
            this.imgHeight = imageSize[1];
        }
        setExtra(ServiceInitializer.getAppContext().getString(R.string.picture_extra));
    }

    public void setDataPath(String str) {
        this.dataPath = str;
    }

    public void setDataUri(Uri uri) {
        if (uri != null) {
            this.dataUri = uri.toString();
        }
    }

    public void setImageBeanList(List<ImageBean> list) {
        this.imageBeanList = list;
    }

    public void setImageElem(V2TIMImageElem v2TIMImageElem) {
        this.imageElem = v2TIMImageElem;
    }

    public void setImgHeight(int i11) {
        this.imgHeight = i11;
    }

    public void setImgWidth(int i11) {
        this.imgWidth = i11;
    }
}
