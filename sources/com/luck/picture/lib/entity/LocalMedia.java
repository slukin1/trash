package com.luck.picture.lib.entity;

import android.content.Context;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.obj.pool.ObjectPools;
import com.luck.picture.lib.utils.MediaUtils;
import com.luck.picture.lib.utils.PictureFileUtils;
import java.io.File;

public class LocalMedia implements Parcelable {
    public static final Parcelable.Creator<LocalMedia> CREATOR = new Parcelable.Creator<LocalMedia>() {
        public LocalMedia createFromParcel(Parcel parcel) {
            return new LocalMedia(parcel);
        }

        public LocalMedia[] newArray(int i11) {
            return new LocalMedia[i11];
        }
    };
    private static ObjectPools.SynchronizedPool<LocalMedia> sPool;
    private long bucketId = -1;
    private int chooseModel;
    private LocalMedia compareLocalMedia;
    private String compressPath;
    private boolean compressed;
    private int cropImageHeight;
    private int cropImageWidth;
    private int cropOffsetX;
    private int cropOffsetY;
    private float cropResultAspectRatio;
    private String customData;
    private String cutPath;
    private long dateAddedTime;
    private long duration;
    private String fileName;
    private int height;

    /* renamed from: id  reason: collision with root package name */
    private long f26825id;
    private boolean isCameraSource;
    private boolean isChecked;
    private boolean isCut;
    private boolean isEditorImage;
    private boolean isGalleryEnabledMask;
    private boolean isMaxSelectEnabledMask;
    private boolean isOriginal;
    private String mimeType;
    private int num;
    private String originalPath;
    private String parentFolderName;
    private String path;
    public int position;
    private String realPath;
    private String sandboxPath;
    private long size;
    private String videoThumbnailPath;
    private String watermarkPath;
    private int width;

    public LocalMedia() {
    }

    public static LocalMedia create() {
        return new LocalMedia();
    }

    public static void destroyPool() {
        ObjectPools.SynchronizedPool<LocalMedia> synchronizedPool = sPool;
        if (synchronizedPool != null) {
            synchronizedPool.destroy();
            sPool = null;
        }
    }

    public static LocalMedia generateHttpAsLocalMedia(String str) {
        LocalMedia create = create();
        create.setPath(str);
        create.setMimeType(MediaUtils.getMimeTypeFromMediaHttpUrl(str));
        return create;
    }

    public static LocalMedia generateLocalMedia(Context context, String str) {
        LocalMedia create = create();
        File file = PictureMimeType.isContent(str) ? new File(PictureFileUtils.getPath(context, Uri.parse(str))) : new File(str);
        create.setPath(str);
        create.setRealPath(file.getAbsolutePath());
        create.setFileName(file.getName());
        create.setParentFolderName(MediaUtils.generateCameraFolderName(file.getAbsolutePath()));
        create.setMimeType(MediaUtils.getMimeTypeFromMediaUrl(file.getAbsolutePath()));
        create.setSize(file.length());
        create.setDateAddedTime(file.lastModified() / 1000);
        String absolutePath = file.getAbsolutePath();
        long j11 = 0;
        if (absolutePath.contains("Android/data/") || absolutePath.contains("data/user/")) {
            create.setId(System.currentTimeMillis());
            File parentFile = file.getParentFile();
            if (parentFile != null) {
                j11 = (long) parentFile.getName().hashCode();
            }
            create.setBucketId(j11);
        } else {
            Long[] pathMediaBucketId = MediaUtils.getPathMediaBucketId(context, create.getRealPath());
            create.setId(pathMediaBucketId[0].longValue() == 0 ? System.currentTimeMillis() : pathMediaBucketId[0].longValue());
            create.setBucketId(pathMediaBucketId[1].longValue());
        }
        if (PictureMimeType.isHasVideo(create.getMimeType())) {
            MediaExtraInfo videoSize = MediaUtils.getVideoSize(context, str);
            create.setWidth(videoSize.getWidth());
            create.setHeight(videoSize.getHeight());
            create.setDuration(videoSize.getDuration());
        } else if (PictureMimeType.isHasAudio(create.getMimeType())) {
            create.setDuration(MediaUtils.getAudioSize(context, str).getDuration());
        } else {
            MediaExtraInfo imageSize = MediaUtils.getImageSize(context, str);
            create.setWidth(imageSize.getWidth());
            create.setHeight(imageSize.getHeight());
        }
        return create;
    }

    public static LocalMedia obtain() {
        if (sPool == null) {
            sPool = new ObjectPools.SynchronizedPool<>();
        }
        LocalMedia acquire = sPool.acquire();
        return acquire == null ? create() : acquire;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z11 = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalMedia)) {
            return false;
        }
        LocalMedia localMedia = (LocalMedia) obj;
        if (!TextUtils.equals(getPath(), localMedia.getPath()) && !TextUtils.equals(getRealPath(), localMedia.getRealPath()) && getId() != localMedia.getId()) {
            z11 = false;
        }
        if (!z11) {
            localMedia = null;
        }
        this.compareLocalMedia = localMedia;
        return z11;
    }

    public String getAvailablePath() {
        String path2 = getPath();
        if (isCut()) {
            path2 = getCutPath();
        }
        if (isCompressed()) {
            path2 = getCompressPath();
        }
        if (isToSandboxPath()) {
            path2 = getSandboxPath();
        }
        if (isOriginal()) {
            path2 = getOriginalPath();
        }
        return isWatermarkPath() ? getWatermarkPath() : path2;
    }

    public long getBucketId() {
        return this.bucketId;
    }

    public int getChooseModel() {
        return this.chooseModel;
    }

    public LocalMedia getCompareLocalMedia() {
        return this.compareLocalMedia;
    }

    public String getCompressPath() {
        return this.compressPath;
    }

    public int getCropImageHeight() {
        return this.cropImageHeight;
    }

    public int getCropImageWidth() {
        return this.cropImageWidth;
    }

    public int getCropOffsetX() {
        return this.cropOffsetX;
    }

    public int getCropOffsetY() {
        return this.cropOffsetY;
    }

    public float getCropResultAspectRatio() {
        return this.cropResultAspectRatio;
    }

    public String getCustomData() {
        return this.customData;
    }

    public String getCutPath() {
        return this.cutPath;
    }

    public long getDateAddedTime() {
        return this.dateAddedTime;
    }

    public long getDuration() {
        return this.duration;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int getHeight() {
        return this.height;
    }

    public long getId() {
        return this.f26825id;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public int getNum() {
        return this.num;
    }

    public String getOriginalPath() {
        return this.originalPath;
    }

    public String getParentFolderName() {
        return this.parentFolderName;
    }

    public String getPath() {
        return this.path;
    }

    public int getPosition() {
        return this.position;
    }

    public String getRealPath() {
        return this.realPath;
    }

    public String getSandboxPath() {
        return this.sandboxPath;
    }

    public long getSize() {
        return this.size;
    }

    public String getVideoThumbnailPath() {
        return this.videoThumbnailPath;
    }

    public String getWatermarkPath() {
        return this.watermarkPath;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isCameraSource() {
        return this.isCameraSource;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public boolean isCompressed() {
        return this.compressed && !TextUtils.isEmpty(getCompressPath());
    }

    public boolean isCut() {
        return this.isCut && !TextUtils.isEmpty(getCutPath());
    }

    public boolean isEditorImage() {
        return this.isEditorImage && !TextUtils.isEmpty(getCutPath());
    }

    public boolean isGalleryEnabledMask() {
        return this.isGalleryEnabledMask;
    }

    public boolean isMaxSelectEnabledMask() {
        return this.isMaxSelectEnabledMask;
    }

    public boolean isOriginal() {
        return this.isOriginal && !TextUtils.isEmpty(getOriginalPath());
    }

    public boolean isToSandboxPath() {
        return !TextUtils.isEmpty(getSandboxPath());
    }

    public boolean isWatermarkPath() {
        return !TextUtils.isEmpty(getWatermarkPath());
    }

    public void recycle() {
        ObjectPools.SynchronizedPool<LocalMedia> synchronizedPool = sPool;
        if (synchronizedPool != null) {
            synchronizedPool.release(this);
        }
    }

    public void setBucketId(long j11) {
        this.bucketId = j11;
    }

    public void setCameraSource(boolean z11) {
        this.isCameraSource = z11;
    }

    public void setChecked(boolean z11) {
        this.isChecked = z11;
    }

    public void setChooseModel(int i11) {
        this.chooseModel = i11;
    }

    public void setCompressPath(String str) {
        this.compressPath = str;
    }

    public void setCompressed(boolean z11) {
        this.compressed = z11;
    }

    public void setCropImageHeight(int i11) {
        this.cropImageHeight = i11;
    }

    public void setCropImageWidth(int i11) {
        this.cropImageWidth = i11;
    }

    public void setCropOffsetX(int i11) {
        this.cropOffsetX = i11;
    }

    public void setCropOffsetY(int i11) {
        this.cropOffsetY = i11;
    }

    public void setCropResultAspectRatio(float f11) {
        this.cropResultAspectRatio = f11;
    }

    public void setCustomData(String str) {
        this.customData = str;
    }

    public void setCut(boolean z11) {
        this.isCut = z11;
    }

    public void setCutPath(String str) {
        this.cutPath = str;
    }

    public void setDateAddedTime(long j11) {
        this.dateAddedTime = j11;
    }

    public void setDuration(long j11) {
        this.duration = j11;
    }

    public void setEditorImage(boolean z11) {
        this.isEditorImage = z11;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setGalleryEnabledMask(boolean z11) {
        this.isGalleryEnabledMask = z11;
    }

    public void setHeight(int i11) {
        this.height = i11;
    }

    public void setId(long j11) {
        this.f26825id = j11;
    }

    public void setMaxSelectEnabledMask(boolean z11) {
        this.isMaxSelectEnabledMask = z11;
    }

    public void setMimeType(String str) {
        this.mimeType = str;
    }

    public void setNum(int i11) {
        this.num = i11;
    }

    public void setOriginal(boolean z11) {
        this.isOriginal = z11;
    }

    public void setOriginalPath(String str) {
        this.originalPath = str;
    }

    public void setParentFolderName(String str) {
        this.parentFolderName = str;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setPosition(int i11) {
        this.position = i11;
    }

    public void setRealPath(String str) {
        this.realPath = str;
    }

    public void setSandboxPath(String str) {
        this.sandboxPath = str;
    }

    public void setSize(long j11) {
        this.size = j11;
    }

    public void setVideoThumbnailPath(String str) {
        this.videoThumbnailPath = str;
    }

    public void setWatermarkPath(String str) {
        this.watermarkPath = str;
    }

    public void setWidth(int i11) {
        this.width = i11;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeLong(this.f26825id);
        parcel.writeString(this.path);
        parcel.writeString(this.realPath);
        parcel.writeString(this.originalPath);
        parcel.writeString(this.compressPath);
        parcel.writeString(this.cutPath);
        parcel.writeString(this.watermarkPath);
        parcel.writeString(this.videoThumbnailPath);
        parcel.writeString(this.sandboxPath);
        parcel.writeLong(this.duration);
        parcel.writeByte(this.isChecked ? (byte) 1 : 0);
        parcel.writeByte(this.isCut ? (byte) 1 : 0);
        parcel.writeInt(this.position);
        parcel.writeInt(this.num);
        parcel.writeString(this.mimeType);
        parcel.writeInt(this.chooseModel);
        parcel.writeByte(this.isCameraSource ? (byte) 1 : 0);
        parcel.writeByte(this.compressed ? (byte) 1 : 0);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeInt(this.cropImageWidth);
        parcel.writeInt(this.cropImageHeight);
        parcel.writeInt(this.cropOffsetX);
        parcel.writeInt(this.cropOffsetY);
        parcel.writeFloat(this.cropResultAspectRatio);
        parcel.writeLong(this.size);
        parcel.writeByte(this.isOriginal ? (byte) 1 : 0);
        parcel.writeString(this.fileName);
        parcel.writeString(this.parentFolderName);
        parcel.writeLong(this.bucketId);
        parcel.writeLong(this.dateAddedTime);
        parcel.writeString(this.customData);
        parcel.writeByte(this.isMaxSelectEnabledMask ? (byte) 1 : 0);
        parcel.writeByte(this.isGalleryEnabledMask ? (byte) 1 : 0);
        parcel.writeByte(this.isEditorImage ? (byte) 1 : 0);
    }

    public LocalMedia(Parcel parcel) {
        this.f26825id = parcel.readLong();
        this.path = parcel.readString();
        this.realPath = parcel.readString();
        this.originalPath = parcel.readString();
        this.compressPath = parcel.readString();
        this.cutPath = parcel.readString();
        this.watermarkPath = parcel.readString();
        this.videoThumbnailPath = parcel.readString();
        this.sandboxPath = parcel.readString();
        this.duration = parcel.readLong();
        boolean z11 = true;
        this.isChecked = parcel.readByte() != 0;
        this.isCut = parcel.readByte() != 0;
        this.position = parcel.readInt();
        this.num = parcel.readInt();
        this.mimeType = parcel.readString();
        this.chooseModel = parcel.readInt();
        this.isCameraSource = parcel.readByte() != 0;
        this.compressed = parcel.readByte() != 0;
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.cropImageWidth = parcel.readInt();
        this.cropImageHeight = parcel.readInt();
        this.cropOffsetX = parcel.readInt();
        this.cropOffsetY = parcel.readInt();
        this.cropResultAspectRatio = parcel.readFloat();
        this.size = parcel.readLong();
        this.isOriginal = parcel.readByte() != 0;
        this.fileName = parcel.readString();
        this.parentFolderName = parcel.readString();
        this.bucketId = parcel.readLong();
        this.dateAddedTime = parcel.readLong();
        this.customData = parcel.readString();
        this.isMaxSelectEnabledMask = parcel.readByte() != 0;
        this.isGalleryEnabledMask = parcel.readByte() != 0;
        this.isEditorImage = parcel.readByte() == 0 ? false : z11;
    }

    public static LocalMedia generateHttpAsLocalMedia(String str, String str2) {
        LocalMedia create = create();
        create.setPath(str);
        create.setMimeType(str2);
        return create;
    }

    @Deprecated
    public static LocalMedia generateLocalMedia(String str, String str2) {
        LocalMedia create = create();
        create.setPath(str);
        create.setMimeType(str2);
        return create;
    }
}
