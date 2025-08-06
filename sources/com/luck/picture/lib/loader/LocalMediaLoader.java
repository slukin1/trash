package com.luck.picture.lib.loader;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.entity.LocalMediaFolder;
import com.luck.picture.lib.interfaces.OnQueryAlbumListener;
import com.luck.picture.lib.interfaces.OnQueryAllAlbumListener;
import com.luck.picture.lib.interfaces.OnQueryDataResultListener;
import com.luck.picture.lib.interfaces.OnQueryFilterListener;
import com.luck.picture.lib.thread.PictureThreadUtils;
import com.luck.picture.lib.utils.MediaUtils;
import com.luck.picture.lib.utils.SdkVersionUtils;
import java.util.List;

public final class LocalMediaLoader extends IBridgeMediaLoader {
    public LocalMediaLoader(Context context, SelectorConfig selectorConfig) {
        super(context, selectorConfig);
    }

    /* access modifiers changed from: private */
    public LocalMediaFolder getImageFolder(String str, String str2, String str3, List<LocalMediaFolder> list) {
        for (LocalMediaFolder next : list) {
            String folderName = next.getFolderName();
            if (!TextUtils.isEmpty(folderName) && TextUtils.equals(folderName, str3)) {
                return next;
            }
        }
        LocalMediaFolder localMediaFolder = new LocalMediaFolder();
        localMediaFolder.setFolderName(str3);
        localMediaFolder.setFirstImagePath(str);
        localMediaFolder.setFirstMimeType(str2);
        list.add(localMediaFolder);
        return localMediaFolder;
    }

    private static String getSelectionArgsForAllMediaCondition(String str, String str2, String str3) {
        return "(media_type=?" + str3 + " OR " + MessengerShareContentUtility.MEDIA_TYPE + "=? AND " + str + ") AND " + str2;
    }

    private static String getSelectionArgsForAudioMediaCondition(String str, String str2) {
        return "media_type=?" + str2 + " AND " + str;
    }

    private static String getSelectionArgsForImageMediaCondition(String str, String str2) {
        return "media_type=?" + str2 + " AND " + str;
    }

    private static String getSelectionArgsForVideoMediaCondition(String str, String str2) {
        return "media_type=?" + str2 + " AND " + str;
    }

    public String getAlbumFirstCover(long j11) {
        return null;
    }

    public String getSelection() {
        String durationCondition = getDurationCondition();
        String fileSizeCondition = getFileSizeCondition();
        String queryMimeCondition = getQueryMimeCondition();
        int i11 = getConfig().chooseMode;
        if (i11 == 0) {
            return getSelectionArgsForAllMediaCondition(durationCondition, fileSizeCondition, queryMimeCondition);
        }
        if (i11 == 1) {
            return getSelectionArgsForImageMediaCondition(fileSizeCondition, queryMimeCondition);
        }
        if (i11 == 2) {
            return getSelectionArgsForVideoMediaCondition(durationCondition, queryMimeCondition);
        }
        if (i11 != 3) {
            return null;
        }
        return getSelectionArgsForAudioMediaCondition(durationCondition, queryMimeCondition);
    }

    public String[] getSelectionArgs() {
        int i11 = getConfig().chooseMode;
        if (i11 == 0) {
            return new String[]{String.valueOf(1), String.valueOf(3)};
        } else if (i11 == 1) {
            return new String[]{String.valueOf(1)};
        } else if (i11 == 2) {
            return new String[]{String.valueOf(3)};
        } else if (i11 != 3) {
            return null;
        } else {
            return new String[]{String.valueOf(2)};
        }
    }

    public String getSortOrder() {
        return TextUtils.isEmpty(getConfig().sortOrder) ? IBridgeMediaLoader.ORDER_BY : getConfig().sortOrder;
    }

    public void loadAllAlbum(final OnQueryAllAlbumListener<LocalMediaFolder> onQueryAllAlbumListener) {
        PictureThreadUtils.executeByIo(new PictureThreadUtils.SimpleTask<List<LocalMediaFolder>>() {
            /* JADX WARNING: Code restructure failed: missing block: B:36:0x014a, code lost:
                if (r1.isClosed() != false) goto L_0x0162;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:43:0x015d, code lost:
                if (r1.isClosed() == false) goto L_0x015f;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:44:0x015f, code lost:
                r1.close();
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.util.List<com.luck.picture.lib.entity.LocalMediaFolder> doInBackground() {
                /*
                    r10 = this;
                    java.util.ArrayList r0 = new java.util.ArrayList
                    r0.<init>()
                    com.luck.picture.lib.loader.LocalMediaLoader r1 = com.luck.picture.lib.loader.LocalMediaLoader.this
                    android.content.Context r1 = r1.getContext()
                    android.content.ContentResolver r2 = r1.getContentResolver()
                    android.net.Uri r3 = com.luck.picture.lib.loader.IBridgeMediaLoader.QUERY_URI
                    java.lang.String[] r4 = com.luck.picture.lib.loader.IBridgeMediaLoader.PROJECTION
                    com.luck.picture.lib.loader.LocalMediaLoader r1 = com.luck.picture.lib.loader.LocalMediaLoader.this
                    java.lang.String r5 = r1.getSelection()
                    com.luck.picture.lib.loader.LocalMediaLoader r1 = com.luck.picture.lib.loader.LocalMediaLoader.this
                    java.lang.String[] r6 = r1.getSelectionArgs()
                    com.luck.picture.lib.loader.LocalMediaLoader r1 = com.luck.picture.lib.loader.LocalMediaLoader.this
                    java.lang.String r7 = r1.getSortOrder()
                    android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7)
                    if (r1 == 0) goto L_0x0157
                    com.luck.picture.lib.entity.LocalMediaFolder r2 = new com.luck.picture.lib.entity.LocalMediaFolder     // Catch:{ Exception -> 0x0142 }
                    r2.<init>()     // Catch:{ Exception -> 0x0142 }
                    java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x0142 }
                    r3.<init>()     // Catch:{ Exception -> 0x0142 }
                    int r4 = r1.getCount()     // Catch:{ Exception -> 0x0142 }
                    if (r4 <= 0) goto L_0x0157
                    r1.moveToFirst()     // Catch:{ Exception -> 0x0142 }
                L_0x003e:
                    com.luck.picture.lib.loader.LocalMediaLoader r4 = com.luck.picture.lib.loader.LocalMediaLoader.this     // Catch:{ Exception -> 0x0142 }
                    r5 = 0
                    com.luck.picture.lib.entity.LocalMedia r4 = r4.parseLocalMedia(r1, r5)     // Catch:{ Exception -> 0x0142 }
                    if (r4 != 0) goto L_0x0048
                    goto L_0x0084
                L_0x0048:
                    com.luck.picture.lib.loader.LocalMediaLoader r6 = com.luck.picture.lib.loader.LocalMediaLoader.this     // Catch:{ Exception -> 0x0142 }
                    java.lang.String r7 = r4.getPath()     // Catch:{ Exception -> 0x0142 }
                    java.lang.String r8 = r4.getMimeType()     // Catch:{ Exception -> 0x0142 }
                    java.lang.String r9 = r4.getParentFolderName()     // Catch:{ Exception -> 0x0142 }
                    com.luck.picture.lib.entity.LocalMediaFolder r6 = r6.getImageFolder(r7, r8, r9, r0)     // Catch:{ Exception -> 0x0142 }
                    long r7 = r4.getBucketId()     // Catch:{ Exception -> 0x0142 }
                    r6.setBucketId(r7)     // Catch:{ Exception -> 0x0142 }
                    java.util.ArrayList r7 = r6.getData()     // Catch:{ Exception -> 0x0142 }
                    r7.add(r4)     // Catch:{ Exception -> 0x0142 }
                    int r7 = r6.getFolderTotalNum()     // Catch:{ Exception -> 0x0142 }
                    int r7 = r7 + 1
                    r6.setFolderTotalNum(r7)     // Catch:{ Exception -> 0x0142 }
                    long r7 = r4.getBucketId()     // Catch:{ Exception -> 0x0142 }
                    r6.setBucketId(r7)     // Catch:{ Exception -> 0x0142 }
                    r3.add(r4)     // Catch:{ Exception -> 0x0142 }
                    int r4 = r2.getFolderTotalNum()     // Catch:{ Exception -> 0x0142 }
                    int r4 = r4 + 1
                    r2.setFolderTotalNum(r4)     // Catch:{ Exception -> 0x0142 }
                L_0x0084:
                    boolean r4 = r1.moveToNext()     // Catch:{ Exception -> 0x0142 }
                    if (r4 != 0) goto L_0x003e
                    com.luck.picture.lib.loader.LocalMediaLoader r4 = com.luck.picture.lib.loader.LocalMediaLoader.this     // Catch:{ Exception -> 0x0142 }
                    android.content.Context r4 = r4.getContext()     // Catch:{ Exception -> 0x0142 }
                    com.luck.picture.lib.loader.LocalMediaLoader r6 = com.luck.picture.lib.loader.LocalMediaLoader.this     // Catch:{ Exception -> 0x0142 }
                    com.luck.picture.lib.config.SelectorConfig r6 = r6.getConfig()     // Catch:{ Exception -> 0x0142 }
                    java.lang.String r6 = r6.sandboxDir     // Catch:{ Exception -> 0x0142 }
                    com.luck.picture.lib.entity.LocalMediaFolder r4 = com.luck.picture.lib.loader.SandboxFileLoader.loadInAppSandboxFolderFile(r4, r6)     // Catch:{ Exception -> 0x0142 }
                    if (r4 == 0) goto L_0x00d4
                    r0.add(r4)     // Catch:{ Exception -> 0x0142 }
                    int r6 = r2.getFolderTotalNum()     // Catch:{ Exception -> 0x0142 }
                    int r7 = r4.getFolderTotalNum()     // Catch:{ Exception -> 0x0142 }
                    int r6 = r6 + r7
                    r2.setFolderTotalNum(r6)     // Catch:{ Exception -> 0x0142 }
                    java.util.ArrayList r6 = r4.getData()     // Catch:{ Exception -> 0x0142 }
                    r2.setData(r6)     // Catch:{ Exception -> 0x0142 }
                    java.util.ArrayList r6 = r4.getData()     // Catch:{ Exception -> 0x0142 }
                    r3.addAll(r5, r6)     // Catch:{ Exception -> 0x0142 }
                    int r4 = r4.getFolderTotalNum()     // Catch:{ Exception -> 0x0142 }
                    r6 = 60
                    if (r6 <= r4) goto L_0x00d4
                    int r4 = r3.size()     // Catch:{ Exception -> 0x0142 }
                    if (r4 <= r6) goto L_0x00d1
                    java.util.List r4 = r3.subList(r5, r6)     // Catch:{ Exception -> 0x0142 }
                    com.luck.picture.lib.utils.SortUtils.sortLocalMediaAddedTime(r4)     // Catch:{ Exception -> 0x0142 }
                    goto L_0x00d4
                L_0x00d1:
                    com.luck.picture.lib.utils.SortUtils.sortLocalMediaAddedTime(r3)     // Catch:{ Exception -> 0x0142 }
                L_0x00d4:
                    int r4 = r3.size()     // Catch:{ Exception -> 0x0142 }
                    if (r4 <= 0) goto L_0x0157
                    com.luck.picture.lib.utils.SortUtils.sortFolder(r0)     // Catch:{ Exception -> 0x0142 }
                    r0.add(r5, r2)     // Catch:{ Exception -> 0x0142 }
                    java.lang.Object r4 = r3.get(r5)     // Catch:{ Exception -> 0x0142 }
                    com.luck.picture.lib.entity.LocalMedia r4 = (com.luck.picture.lib.entity.LocalMedia) r4     // Catch:{ Exception -> 0x0142 }
                    java.lang.String r4 = r4.getPath()     // Catch:{ Exception -> 0x0142 }
                    r2.setFirstImagePath(r4)     // Catch:{ Exception -> 0x0142 }
                    java.lang.Object r4 = r3.get(r5)     // Catch:{ Exception -> 0x0142 }
                    com.luck.picture.lib.entity.LocalMedia r4 = (com.luck.picture.lib.entity.LocalMedia) r4     // Catch:{ Exception -> 0x0142 }
                    java.lang.String r4 = r4.getMimeType()     // Catch:{ Exception -> 0x0142 }
                    r2.setFirstMimeType(r4)     // Catch:{ Exception -> 0x0142 }
                    com.luck.picture.lib.loader.LocalMediaLoader r4 = com.luck.picture.lib.loader.LocalMediaLoader.this     // Catch:{ Exception -> 0x0142 }
                    com.luck.picture.lib.config.SelectorConfig r4 = r4.getConfig()     // Catch:{ Exception -> 0x0142 }
                    java.lang.String r4 = r4.defaultAlbumName     // Catch:{ Exception -> 0x0142 }
                    boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0142 }
                    if (r4 == 0) goto L_0x012c
                    com.luck.picture.lib.loader.LocalMediaLoader r4 = com.luck.picture.lib.loader.LocalMediaLoader.this     // Catch:{ Exception -> 0x0142 }
                    com.luck.picture.lib.config.SelectorConfig r4 = r4.getConfig()     // Catch:{ Exception -> 0x0142 }
                    int r4 = r4.chooseMode     // Catch:{ Exception -> 0x0142 }
                    int r5 = com.luck.picture.lib.config.SelectMimeType.ofAudio()     // Catch:{ Exception -> 0x0142 }
                    if (r4 != r5) goto L_0x0123
                    com.luck.picture.lib.loader.LocalMediaLoader r4 = com.luck.picture.lib.loader.LocalMediaLoader.this     // Catch:{ Exception -> 0x0142 }
                    android.content.Context r4 = r4.getContext()     // Catch:{ Exception -> 0x0142 }
                    int r5 = com.luck.picture.lib.R.string.ps_all_audio     // Catch:{ Exception -> 0x0142 }
                L_0x011e:
                    java.lang.String r4 = r4.getString(r5)     // Catch:{ Exception -> 0x0142 }
                    goto L_0x0134
                L_0x0123:
                    com.luck.picture.lib.loader.LocalMediaLoader r4 = com.luck.picture.lib.loader.LocalMediaLoader.this     // Catch:{ Exception -> 0x0142 }
                    android.content.Context r4 = r4.getContext()     // Catch:{ Exception -> 0x0142 }
                    int r5 = com.luck.picture.lib.R.string.ps_camera_roll     // Catch:{ Exception -> 0x0142 }
                    goto L_0x011e
                L_0x012c:
                    com.luck.picture.lib.loader.LocalMediaLoader r4 = com.luck.picture.lib.loader.LocalMediaLoader.this     // Catch:{ Exception -> 0x0142 }
                    com.luck.picture.lib.config.SelectorConfig r4 = r4.getConfig()     // Catch:{ Exception -> 0x0142 }
                    java.lang.String r4 = r4.defaultAlbumName     // Catch:{ Exception -> 0x0142 }
                L_0x0134:
                    r2.setFolderName(r4)     // Catch:{ Exception -> 0x0142 }
                    r4 = -1
                    r2.setBucketId(r4)     // Catch:{ Exception -> 0x0142 }
                    r2.setData(r3)     // Catch:{ Exception -> 0x0142 }
                    goto L_0x0157
                L_0x0140:
                    r0 = move-exception
                    goto L_0x014d
                L_0x0142:
                    r2 = move-exception
                    r2.printStackTrace()     // Catch:{ all -> 0x0140 }
                    boolean r2 = r1.isClosed()
                    if (r2 != 0) goto L_0x0162
                    goto L_0x015f
                L_0x014d:
                    boolean r2 = r1.isClosed()
                    if (r2 != 0) goto L_0x0156
                    r1.close()
                L_0x0156:
                    throw r0
                L_0x0157:
                    if (r1 == 0) goto L_0x0162
                    boolean r2 = r1.isClosed()
                    if (r2 != 0) goto L_0x0162
                L_0x015f:
                    r1.close()
                L_0x0162:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.loader.LocalMediaLoader.AnonymousClass1.doInBackground():java.util.List");
            }

            public void onSuccess(List<LocalMediaFolder> list) {
                PictureThreadUtils.cancel((PictureThreadUtils.Task) this);
                OnQueryAllAlbumListener onQueryAllAlbumListener = onQueryAllAlbumListener;
                if (onQueryAllAlbumListener != null) {
                    onQueryAllAlbumListener.onComplete(list);
                }
            }
        });
    }

    public void loadOnlyInAppDirAllMedia(final OnQueryAlbumListener<LocalMediaFolder> onQueryAlbumListener) {
        PictureThreadUtils.executeByIo(new PictureThreadUtils.SimpleTask<LocalMediaFolder>() {
            public LocalMediaFolder doInBackground() {
                return SandboxFileLoader.loadInAppSandboxFolderFile(LocalMediaLoader.this.getContext(), LocalMediaLoader.this.getConfig().sandboxDir);
            }

            public void onSuccess(LocalMediaFolder localMediaFolder) {
                PictureThreadUtils.cancel((PictureThreadUtils.Task) this);
                OnQueryAlbumListener onQueryAlbumListener = onQueryAlbumListener;
                if (onQueryAlbumListener != null) {
                    onQueryAlbumListener.onComplete(localMediaFolder);
                }
            }
        });
    }

    public void loadPageMediaData(long j11, int i11, int i12, OnQueryDataResultListener<LocalMedia> onQueryDataResultListener) {
    }

    public LocalMedia parseLocalMedia(Cursor cursor, boolean z11) {
        long j11;
        long j12;
        Cursor cursor2 = cursor;
        String[] strArr = IBridgeMediaLoader.PROJECTION;
        int columnIndexOrThrow = cursor2.getColumnIndexOrThrow(strArr[0]);
        int columnIndexOrThrow2 = cursor2.getColumnIndexOrThrow(strArr[1]);
        int columnIndexOrThrow3 = cursor2.getColumnIndexOrThrow(strArr[2]);
        int columnIndexOrThrow4 = cursor2.getColumnIndexOrThrow(strArr[3]);
        int columnIndexOrThrow5 = cursor2.getColumnIndexOrThrow(strArr[4]);
        int columnIndexOrThrow6 = cursor2.getColumnIndexOrThrow(strArr[5]);
        int columnIndexOrThrow7 = cursor2.getColumnIndexOrThrow(strArr[6]);
        int columnIndexOrThrow8 = cursor2.getColumnIndexOrThrow(strArr[7]);
        int columnIndexOrThrow9 = cursor2.getColumnIndexOrThrow(strArr[8]);
        int columnIndexOrThrow10 = cursor2.getColumnIndexOrThrow(strArr[9]);
        int columnIndexOrThrow11 = cursor2.getColumnIndexOrThrow(strArr[10]);
        int columnIndexOrThrow12 = cursor2.getColumnIndexOrThrow(strArr[11]);
        long j13 = cursor2.getLong(columnIndexOrThrow);
        int i11 = columnIndexOrThrow10;
        long j14 = cursor2.getLong(columnIndexOrThrow11);
        String string = cursor2.getString(columnIndexOrThrow3);
        String string2 = cursor2.getString(columnIndexOrThrow2);
        String realPathUri = SdkVersionUtils.isQ() ? MediaUtils.getRealPathUri(j13, string) : string2;
        if (TextUtils.isEmpty(string)) {
            string = PictureMimeType.ofJPEG();
        }
        if (string.endsWith(SelectMimeType.SYSTEM_IMAGE)) {
            string = MediaUtils.getMimeTypeFromMediaUrl(string2);
            j11 = j14;
            if (!getConfig().isGif && PictureMimeType.isHasGif(string)) {
                return null;
            }
        } else {
            j11 = j14;
        }
        if (string.endsWith(SelectMimeType.SYSTEM_IMAGE)) {
            return null;
        }
        if (!getConfig().isWebp && string.startsWith(PictureMimeType.ofWEBP())) {
            return null;
        }
        if (!getConfig().isBmp && PictureMimeType.isHasBmp(string)) {
            return null;
        }
        int i12 = cursor2.getInt(columnIndexOrThrow4);
        int i13 = cursor2.getInt(columnIndexOrThrow5);
        int i14 = cursor2.getInt(columnIndexOrThrow12);
        if (i14 == 90 || i14 == 270) {
            i12 = cursor2.getInt(columnIndexOrThrow5);
            i13 = cursor2.getInt(columnIndexOrThrow4);
        }
        long j15 = cursor2.getLong(columnIndexOrThrow6);
        long j16 = cursor2.getLong(columnIndexOrThrow7);
        String string3 = cursor2.getString(columnIndexOrThrow8);
        String string4 = cursor2.getString(columnIndexOrThrow9);
        int i15 = i12;
        long j17 = cursor2.getLong(i11);
        if (TextUtils.isEmpty(string4)) {
            string4 = PictureMimeType.getUrlToFileName(string2);
        }
        if (getConfig().isFilterSizeDuration && j16 > 0 && j16 < 1024) {
            return null;
        }
        if (PictureMimeType.isHasVideo(string) || PictureMimeType.isHasAudio(string)) {
            if (getConfig().filterVideoMinSecond > 0) {
                j12 = j16;
                if (j15 < ((long) getConfig().filterVideoMinSecond)) {
                    return null;
                }
            } else {
                j12 = j16;
            }
            if (getConfig().filterVideoMaxSecond > 0 && j15 > ((long) getConfig().filterVideoMaxSecond)) {
                return null;
            }
            if (getConfig().isFilterSizeDuration && j15 <= 0) {
                return null;
            }
        } else {
            j12 = j16;
        }
        LocalMedia create = LocalMedia.create();
        create.setId(j13);
        create.setBucketId(j17);
        create.setPath(realPathUri);
        create.setRealPath(string2);
        create.setFileName(string4);
        create.setParentFolderName(string3);
        create.setDuration(j15);
        create.setChooseModel(getConfig().chooseMode);
        create.setMimeType(string);
        create.setWidth(i15);
        create.setHeight(i13);
        create.setSize(j12);
        create.setDateAddedTime(j11);
        OnQueryFilterListener onQueryFilterListener = this.mConfig.onQueryFilterListener;
        if (onQueryFilterListener == null || !onQueryFilterListener.onFilter(create)) {
            return create;
        }
        return null;
    }
}
