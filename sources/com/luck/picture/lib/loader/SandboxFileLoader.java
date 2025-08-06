package com.luck.picture.lib.loader;

import android.content.Context;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.entity.LocalMediaFolder;
import com.luck.picture.lib.utils.SortUtils;
import java.util.ArrayList;

public final class SandboxFileLoader {
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0155, code lost:
        if (r2 < ((long) r5)) goto L_0x0157;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0161, code lost:
        if (r2 > ((long) r5)) goto L_0x0157;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0168, code lost:
        if (r2 == 0) goto L_0x0157;
     */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x014a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList<com.luck.picture.lib.entity.LocalMedia> loadInAppSandboxFile(android.content.Context r24, java.lang.String r25) {
        /*
            r1 = r24
            boolean r0 = android.text.TextUtils.isEmpty(r25)
            r2 = 0
            if (r0 == 0) goto L_0x000a
            return r2
        L_0x000a:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.io.File r4 = new java.io.File
            r0 = r25
            r4.<init>(r0)
            boolean r0 = r4.exists()
            if (r0 == 0) goto L_0x01cd
            com.luck.picture.lib.loader.SandboxFileLoader$1 r0 = new com.luck.picture.lib.loader.SandboxFileLoader$1
            r0.<init>()
            java.io.File[] r5 = r4.listFiles(r0)
            if (r5 != 0) goto L_0x0028
            return r3
        L_0x0028:
            com.luck.picture.lib.config.SelectorProviders r0 = com.luck.picture.lib.config.SelectorProviders.getInstance()
            com.luck.picture.lib.config.SelectorConfig r6 = r0.getSelectorConfig()
            java.lang.String r0 = "MD5"
            java.security.MessageDigest r0 = java.security.MessageDigest.getInstance(r0)     // Catch:{ NoSuchAlgorithmException -> 0x0037 }
            goto L_0x003c
        L_0x0037:
            r0 = move-exception
            r0.printStackTrace()
            r0 = r2
        L_0x003c:
            int r7 = r5.length
            r8 = 0
        L_0x003e:
            if (r8 >= r7) goto L_0x01cd
            r9 = r5[r8]
            java.lang.String r10 = r9.getAbsolutePath()
            java.lang.String r10 = com.luck.picture.lib.utils.MediaUtils.getMimeTypeFromMediaUrl(r10)
            int r11 = r6.chooseMode
            int r12 = com.luck.picture.lib.config.SelectMimeType.ofImage()
            if (r11 != r12) goto L_0x0063
            boolean r11 = com.luck.picture.lib.config.PictureMimeType.isHasImage(r10)
            if (r11 != 0) goto L_0x0081
        L_0x0058:
            r16 = r0
            r1 = r3
            r17 = r5
            r25 = r7
            r18 = r8
            goto L_0x01bf
        L_0x0063:
            int r11 = r6.chooseMode
            int r12 = com.luck.picture.lib.config.SelectMimeType.ofVideo()
            if (r11 != r12) goto L_0x0072
            boolean r11 = com.luck.picture.lib.config.PictureMimeType.isHasVideo(r10)
            if (r11 != 0) goto L_0x0081
            goto L_0x0058
        L_0x0072:
            int r11 = r6.chooseMode
            int r12 = com.luck.picture.lib.config.SelectMimeType.ofAudio()
            if (r11 != r12) goto L_0x0081
            boolean r11 = com.luck.picture.lib.config.PictureMimeType.isHasAudio(r10)
            if (r11 != 0) goto L_0x0081
            goto L_0x0058
        L_0x0081:
            java.util.List<java.lang.String> r11 = r6.queryOnlyList
            if (r11 == 0) goto L_0x0094
            int r11 = r11.size()
            if (r11 <= 0) goto L_0x0094
            java.util.List<java.lang.String> r11 = r6.queryOnlyList
            boolean r11 = r11.contains(r10)
            if (r11 != 0) goto L_0x0094
            goto L_0x0058
        L_0x0094:
            boolean r11 = r6.isGif
            if (r11 != 0) goto L_0x009f
            boolean r11 = com.luck.picture.lib.config.PictureMimeType.isHasGif(r10)
            if (r11 == 0) goto L_0x009f
            goto L_0x0058
        L_0x009f:
            java.lang.String r11 = r9.getAbsolutePath()
            long r12 = r9.length()
            r14 = 0
            int r16 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r16 > 0) goto L_0x00ae
            goto L_0x0058
        L_0x00ae:
            r16 = 1000(0x3e8, double:4.94E-321)
            if (r0 == 0) goto L_0x00c8
            byte[] r2 = r11.getBytes()
            r0.update(r2)
            java.math.BigInteger r2 = new java.math.BigInteger
            byte[] r14 = r0.digest()
            r15 = 1
            r2.<init>(r15, r14)
            long r14 = r2.longValue()
            goto L_0x00ce
        L_0x00c8:
            long r14 = r9.lastModified()
            long r14 = r14 / r16
        L_0x00ce:
            java.lang.String r2 = r4.getName()
            int r2 = r2.hashCode()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r25 = r7
            r18 = r8
            long r7 = com.luck.picture.lib.utils.ValueOf.toLong(r2)
            long r19 = r9.lastModified()
            r21 = r3
            long r2 = r19 / r16
            boolean r16 = com.luck.picture.lib.config.PictureMimeType.isHasVideo(r10)
            if (r16 == 0) goto L_0x010b
            com.luck.picture.lib.entity.MediaExtraInfo r16 = com.luck.picture.lib.utils.MediaUtils.getVideoSize(r1, r11)
            int r17 = r16.getWidth()
            int r19 = r16.getHeight()
            long r22 = r16.getDuration()
        L_0x0100:
            r16 = r0
            r0 = r17
            r1 = r19
            r19 = r2
            r2 = r22
            goto L_0x0138
        L_0x010b:
            boolean r16 = com.luck.picture.lib.config.PictureMimeType.isHasAudio(r10)
            if (r16 == 0) goto L_0x0122
            com.luck.picture.lib.entity.MediaExtraInfo r16 = com.luck.picture.lib.utils.MediaUtils.getAudioSize(r1, r11)
            int r17 = r16.getWidth()
            int r19 = r16.getHeight()
            long r22 = r16.getDuration()
            goto L_0x0100
        L_0x0122:
            com.luck.picture.lib.entity.MediaExtraInfo r16 = com.luck.picture.lib.utils.MediaUtils.getImageSize(r1, r11)
            int r17 = r16.getWidth()
            int r19 = r16.getHeight()
            r16 = r0
            r0 = r17
            r1 = r19
            r19 = r2
            r2 = 0
        L_0x0138:
            boolean r17 = com.luck.picture.lib.config.PictureMimeType.isHasVideo(r10)
            if (r17 != 0) goto L_0x014a
            boolean r17 = com.luck.picture.lib.config.PictureMimeType.isHasAudio(r10)
            if (r17 == 0) goto L_0x0145
            goto L_0x014a
        L_0x0145:
            r17 = r5
            r22 = r7
            goto L_0x016b
        L_0x014a:
            r17 = r5
            int r5 = r6.filterVideoMinSecond
            r22 = r7
            if (r5 <= 0) goto L_0x015a
            long r7 = (long) r5
            int r5 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r5 >= 0) goto L_0x015a
        L_0x0157:
            r1 = r21
            goto L_0x01bf
        L_0x015a:
            int r5 = r6.filterVideoMaxSecond
            if (r5 <= 0) goto L_0x0164
            long r7 = (long) r5
            int r5 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r5 <= 0) goto L_0x0164
            goto L_0x016a
        L_0x0164:
            r7 = 0
            int r5 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r5 != 0) goto L_0x016b
        L_0x016a:
            goto L_0x0157
        L_0x016b:
            com.luck.picture.lib.entity.LocalMedia r5 = com.luck.picture.lib.entity.LocalMedia.create()
            r5.setId(r14)
            r5.setPath(r11)
            r5.setRealPath(r11)
            java.lang.String r7 = r9.getName()
            r5.setFileName(r7)
            java.lang.String r7 = r4.getName()
            r5.setParentFolderName(r7)
            r5.setDuration(r2)
            int r2 = r6.chooseMode
            r5.setChooseModel(r2)
            r5.setMimeType(r10)
            r5.setWidth(r0)
            r5.setHeight(r1)
            r5.setSize(r12)
            r0 = r22
            r5.setBucketId(r0)
            r0 = r19
            r5.setDateAddedTime(r0)
            com.luck.picture.lib.interfaces.OnQueryFilterListener r0 = r6.onQueryFilterListener
            if (r0 == 0) goto L_0x01af
            boolean r0 = r0.onFilter(r5)
            if (r0 == 0) goto L_0x01af
            goto L_0x0157
        L_0x01af:
            boolean r0 = com.luck.picture.lib.utils.SdkVersionUtils.isQ()
            if (r0 == 0) goto L_0x01b6
            goto L_0x01b7
        L_0x01b6:
            r11 = 0
        L_0x01b7:
            r5.setSandboxPath(r11)
            r1 = r21
            r1.add(r5)
        L_0x01bf:
            int r8 = r18 + 1
            r7 = r25
            r3 = r1
            r0 = r16
            r5 = r17
            r2 = 0
            r1 = r24
            goto L_0x003e
        L_0x01cd:
            r1 = r3
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.loader.SandboxFileLoader.loadInAppSandboxFile(android.content.Context, java.lang.String):java.util.ArrayList");
    }

    public static LocalMediaFolder loadInAppSandboxFolderFile(Context context, String str) {
        ArrayList<LocalMedia> loadInAppSandboxFile = loadInAppSandboxFile(context, str);
        if (loadInAppSandboxFile == null || loadInAppSandboxFile.size() <= 0) {
            return null;
        }
        SortUtils.sortLocalMediaAddedTime(loadInAppSandboxFile);
        LocalMedia localMedia = loadInAppSandboxFile.get(0);
        LocalMediaFolder localMediaFolder = new LocalMediaFolder();
        localMediaFolder.setFolderName(localMedia.getParentFolderName());
        localMediaFolder.setFirstImagePath(localMedia.getPath());
        localMediaFolder.setFirstMimeType(localMedia.getMimeType());
        localMediaFolder.setBucketId(localMedia.getBucketId());
        localMediaFolder.setFolderTotalNum(loadInAppSandboxFile.size());
        localMediaFolder.setData(loadInAppSandboxFile);
        return localMediaFolder;
    }
}
