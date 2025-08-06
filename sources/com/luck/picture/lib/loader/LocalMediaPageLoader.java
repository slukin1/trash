package com.luck.picture.lib.loader;

import android.content.Context;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.entity.LocalMediaFolder;
import com.luck.picture.lib.entity.MediaData;
import com.luck.picture.lib.interfaces.OnQueryAlbumListener;
import com.luck.picture.lib.interfaces.OnQueryAllAlbumListener;
import com.luck.picture.lib.interfaces.OnQueryDataResultListener;
import com.luck.picture.lib.interfaces.OnQueryFilterListener;
import com.luck.picture.lib.thread.PictureThreadUtils;
import com.luck.picture.lib.utils.MediaUtils;
import com.luck.picture.lib.utils.PictureFileUtils;
import com.luck.picture.lib.utils.SdkVersionUtils;
import com.luck.picture.lib.utils.SortUtils;
import com.luck.picture.lib.utils.ValueOf;
import java.util.ArrayList;
import java.util.List;

public final class LocalMediaPageLoader extends IBridgeMediaLoader {
    public LocalMediaPageLoader(Context context, SelectorConfig selectorConfig) {
        super(context, selectorConfig);
    }

    /* access modifiers changed from: private */
    public static String getFirstCoverMimeType(Cursor cursor) {
        return cursor.getString(cursor.getColumnIndexOrThrow("mime_type"));
    }

    /* access modifiers changed from: private */
    public static String getFirstUri(Cursor cursor) {
        return MediaUtils.getRealPathUri(cursor.getLong(cursor.getColumnIndexOrThrow("_id")), cursor.getString(cursor.getColumnIndexOrThrow("mime_type")));
    }

    /* access modifiers changed from: private */
    public static String getFirstUrl(Cursor cursor) {
        return cursor.getString(cursor.getColumnIndexOrThrow("_data"));
    }

    /* access modifiers changed from: private */
    public String getPageSelection(long j11) {
        String durationCondition = getDurationCondition();
        String fileSizeCondition = getFileSizeCondition();
        String queryMimeCondition = getQueryMimeCondition();
        int i11 = getConfig().chooseMode;
        if (i11 == 0) {
            return getPageSelectionArgsForAllMediaCondition(j11, queryMimeCondition, durationCondition, fileSizeCondition);
        }
        if (i11 == 1) {
            return getPageSelectionArgsForImageMediaCondition(j11, queryMimeCondition, fileSizeCondition);
        }
        if (i11 == 2) {
            return getPageSelectionArgsForVideoMediaCondition(j11, queryMimeCondition, durationCondition, fileSizeCondition);
        }
        if (i11 != 3) {
            return null;
        }
        return getPageSelectionArgsForAudioMediaCondition(j11, queryMimeCondition, durationCondition, fileSizeCondition);
    }

    /* access modifiers changed from: private */
    public String[] getPageSelectionArgs(long j11) {
        int i11 = getConfig().chooseMode;
        if (i11 != 0) {
            if (i11 == 1) {
                return getSelectionArgsForPageSingleMediaType(1, j11);
            }
            if (i11 == 2) {
                return getSelectionArgsForPageSingleMediaType(3, j11);
            }
            if (i11 != 3) {
                return null;
            }
            return getSelectionArgsForPageSingleMediaType(2, j11);
        } else if (j11 == -1) {
            return new String[]{String.valueOf(1), String.valueOf(3)};
        } else {
            return new String[]{String.valueOf(1), String.valueOf(3), ValueOf.toString(Long.valueOf(j11))};
        }
    }

    private static String getPageSelectionArgsForAllMediaCondition(long j11, String str, String str2, String str3) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(");
        sb2.append(MessengerShareContentUtility.MEDIA_TYPE);
        sb2.append("=?");
        sb2.append(str);
        sb2.append(" OR ");
        sb2.append(MessengerShareContentUtility.MEDIA_TYPE);
        sb2.append("=? AND ");
        sb2.append(str2);
        sb2.append(") AND ");
        if (j11 == -1) {
            sb2.append(str3);
            return sb2.toString();
        }
        sb2.append(IBridgeMediaLoader.COLUMN_BUCKET_ID);
        sb2.append("=? AND ");
        sb2.append(str3);
        return sb2.toString();
    }

    private static String getPageSelectionArgsForAudioMediaCondition(long j11, String str, String str2, String str3) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(");
        sb2.append(MessengerShareContentUtility.MEDIA_TYPE);
        sb2.append("=?");
        sb2.append(str);
        sb2.append(" AND ");
        sb2.append(str2);
        sb2.append(") AND ");
        if (j11 == -1) {
            sb2.append(str3);
            return sb2.toString();
        }
        sb2.append(IBridgeMediaLoader.COLUMN_BUCKET_ID);
        sb2.append("=? AND ");
        sb2.append(str3);
        return sb2.toString();
    }

    private static String getPageSelectionArgsForImageMediaCondition(long j11, String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(");
        sb2.append(MessengerShareContentUtility.MEDIA_TYPE);
        sb2.append("=?");
        if (j11 == -1) {
            sb2.append(str);
            sb2.append(") AND ");
            sb2.append(str2);
            return sb2.toString();
        }
        sb2.append(str);
        sb2.append(") AND ");
        sb2.append(IBridgeMediaLoader.COLUMN_BUCKET_ID);
        sb2.append("=? AND ");
        sb2.append(str2);
        return sb2.toString();
    }

    private static String getPageSelectionArgsForVideoMediaCondition(long j11, String str, String str2, String str3) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(");
        sb2.append(MessengerShareContentUtility.MEDIA_TYPE);
        sb2.append("=?");
        sb2.append(str);
        sb2.append(" AND ");
        sb2.append(str2);
        sb2.append(") AND ");
        if (j11 == -1) {
            sb2.append(str3);
            return sb2.toString();
        }
        sb2.append(IBridgeMediaLoader.COLUMN_BUCKET_ID);
        sb2.append("=? AND ");
        sb2.append(str3);
        return sb2.toString();
    }

    private String getSelectionArgsForAllMediaCondition(String str, String str2, String str3) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(");
        sb2.append(MessengerShareContentUtility.MEDIA_TYPE);
        sb2.append("=?");
        sb2.append(str3);
        sb2.append(" OR ");
        sb2.append(MessengerShareContentUtility.MEDIA_TYPE);
        sb2.append("=? AND ");
        sb2.append(str);
        sb2.append(") AND ");
        sb2.append(str2);
        if (isWithAllQuery()) {
            return sb2.toString();
        }
        sb2.append(")");
        sb2.append(IBridgeMediaLoader.GROUP_BY_BUCKET_Id);
        return sb2.toString();
    }

    private String getSelectionArgsForAudioMediaCondition(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        if (isWithAllQuery()) {
            sb2.append(MessengerShareContentUtility.MEDIA_TYPE);
            sb2.append("=?");
            sb2.append(str2);
            sb2.append(" AND ");
            sb2.append(str);
            return sb2.toString();
        }
        sb2.append("(");
        sb2.append(MessengerShareContentUtility.MEDIA_TYPE);
        sb2.append("=?");
        sb2.append(str2);
        sb2.append(") AND ");
        sb2.append(str);
        sb2.append(")");
        sb2.append(IBridgeMediaLoader.GROUP_BY_BUCKET_Id);
        return sb2.toString();
    }

    private String getSelectionArgsForImageMediaCondition(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        if (isWithAllQuery()) {
            sb2.append(MessengerShareContentUtility.MEDIA_TYPE);
            sb2.append("=?");
            sb2.append(str2);
            sb2.append(" AND ");
            sb2.append(str);
            return sb2.toString();
        }
        sb2.append("(");
        sb2.append(MessengerShareContentUtility.MEDIA_TYPE);
        sb2.append("=?");
        sb2.append(str2);
        sb2.append(") AND ");
        sb2.append(str);
        sb2.append(")");
        sb2.append(IBridgeMediaLoader.GROUP_BY_BUCKET_Id);
        return sb2.toString();
    }

    private static String[] getSelectionArgsForPageSingleMediaType(int i11, long j11) {
        if (j11 == -1) {
            return new String[]{String.valueOf(i11)};
        }
        return new String[]{String.valueOf(i11), ValueOf.toString(Long.valueOf(j11))};
    }

    private String getSelectionArgsForVideoMediaCondition(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        if (isWithAllQuery()) {
            sb2.append(MessengerShareContentUtility.MEDIA_TYPE);
            sb2.append("=?");
            sb2.append(str2);
            sb2.append(" AND ");
            sb2.append(str);
            return sb2.toString();
        }
        sb2.append("(");
        sb2.append(MessengerShareContentUtility.MEDIA_TYPE);
        sb2.append("=?");
        sb2.append(str2);
        sb2.append(") AND ");
        sb2.append(str);
        sb2.append(")");
        sb2.append(IBridgeMediaLoader.GROUP_BY_BUCKET_Id);
        return sb2.toString();
    }

    /* access modifiers changed from: private */
    public boolean isWithAllQuery() {
        if (SdkVersionUtils.isQ()) {
            return true;
        }
        return getConfig().isPageSyncAsCount;
    }

    /* access modifiers changed from: private */
    public void synchronousFirstCover(List<LocalMediaFolder> list) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            LocalMediaFolder localMediaFolder = list.get(i11);
            if (localMediaFolder != null) {
                String albumFirstCover = getAlbumFirstCover(localMediaFolder.getBucketId());
                if (!TextUtils.isEmpty(albumFirstCover)) {
                    localMediaFolder.setFirstImagePath(albumFirstCover);
                }
            }
        }
    }

    public String getAlbumFirstCover(long j11) {
        Cursor cursor;
        Cursor cursor2;
        String str;
        Cursor cursor3 = null;
        try {
            if (SdkVersionUtils.isR()) {
                cursor2 = getContext().getContentResolver().query(IBridgeMediaLoader.QUERY_URI, new String[]{"_id", "mime_type", "_data"}, MediaUtils.createQueryArgsBundle(getPageSelection(j11), getPageSelectionArgs(j11), 1, 0, getSortOrder()), (CancellationSignal) null);
            } else {
                cursor2 = getContext().getContentResolver().query(IBridgeMediaLoader.QUERY_URI, new String[]{"_id", "mime_type", "_data"}, getPageSelection(j11), getPageSelectionArgs(j11), getSortOrder() + " limit 1 offset 0");
            }
            if (cursor2 != null) {
                try {
                    if (cursor2.getCount() > 0) {
                        if (cursor2.moveToFirst()) {
                            long j12 = cursor2.getLong(cursor2.getColumnIndexOrThrow("_id"));
                            String string = cursor2.getString(cursor2.getColumnIndexOrThrow("mime_type"));
                            if (SdkVersionUtils.isQ()) {
                                str = MediaUtils.getRealPathUri(j12, string);
                            } else {
                                str = cursor2.getString(cursor2.getColumnIndexOrThrow("_data"));
                            }
                            if (!cursor2.isClosed()) {
                                cursor2.close();
                            }
                            return str;
                        }
                        if (!cursor2.isClosed()) {
                            cursor2.close();
                        }
                        return null;
                    }
                } catch (Exception e11) {
                    Exception exc = e11;
                    cursor = cursor2;
                    e = exc;
                    try {
                        e.printStackTrace();
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor3 = cursor;
                        cursor3.close();
                        throw th;
                    }
                } catch (Throwable th3) {
                    cursor3 = cursor2;
                    th = th3;
                    if (cursor3 != null && !cursor3.isClosed()) {
                        cursor3.close();
                    }
                    throw th;
                }
            }
            if (cursor2 != null && !cursor2.isClosed()) {
                cursor2.close();
            }
        } catch (Exception e12) {
            e = e12;
            cursor = null;
            e.printStackTrace();
            cursor.close();
            return null;
        } catch (Throwable th4) {
            th = th4;
            cursor3.close();
            throw th;
        }
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
            /* JADX WARNING: Code restructure failed: missing block: B:100:0x0306, code lost:
                r2.close();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:92:0x02f1, code lost:
                if (r2.isClosed() != false) goto L_0x0309;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:99:0x0304, code lost:
                if (r2.isClosed() == false) goto L_0x0306;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.util.List<com.luck.picture.lib.entity.LocalMediaFolder> doInBackground() {
                /*
                    r18 = this;
                    r1 = r18
                    com.luck.picture.lib.loader.LocalMediaPageLoader r0 = com.luck.picture.lib.loader.LocalMediaPageLoader.this
                    android.content.Context r0 = r0.getContext()
                    android.content.ContentResolver r2 = r0.getContentResolver()
                    android.net.Uri r3 = com.luck.picture.lib.loader.IBridgeMediaLoader.QUERY_URI
                    com.luck.picture.lib.loader.LocalMediaPageLoader r0 = com.luck.picture.lib.loader.LocalMediaPageLoader.this
                    boolean r0 = r0.isWithAllQuery()
                    if (r0 == 0) goto L_0x0019
                    java.lang.String[] r0 = com.luck.picture.lib.loader.IBridgeMediaLoader.PROJECTION
                    goto L_0x001b
                L_0x0019:
                    java.lang.String[] r0 = com.luck.picture.lib.loader.IBridgeMediaLoader.ALL_PROJECTION
                L_0x001b:
                    r4 = r0
                    com.luck.picture.lib.loader.LocalMediaPageLoader r0 = com.luck.picture.lib.loader.LocalMediaPageLoader.this
                    java.lang.String r5 = r0.getSelection()
                    com.luck.picture.lib.loader.LocalMediaPageLoader r0 = com.luck.picture.lib.loader.LocalMediaPageLoader.this
                    java.lang.String[] r6 = r0.getSelectionArgs()
                    com.luck.picture.lib.loader.LocalMediaPageLoader r0 = com.luck.picture.lib.loader.LocalMediaPageLoader.this
                    java.lang.String r7 = r0.getSortOrder()
                    android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7)
                    if (r2 == 0) goto L_0x02fe
                    int r0 = r2.getCount()     // Catch:{ Exception -> 0x02cf }
                    java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x02cf }
                    r3.<init>()     // Catch:{ Exception -> 0x02cf }
                    if (r0 <= 0) goto L_0x02fe
                    com.luck.picture.lib.loader.LocalMediaPageLoader r0 = com.luck.picture.lib.loader.LocalMediaPageLoader.this     // Catch:{ Exception -> 0x02cf }
                    boolean r0 = r0.isWithAllQuery()     // Catch:{ Exception -> 0x02cf }
                    java.lang.String r4 = "bucket_id"
                    java.lang.String r5 = "mime_type"
                    java.lang.String r6 = "bucket_display_name"
                    if (r0 == 0) goto L_0x0137
                    java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x02cf }
                    r0.<init>()     // Catch:{ Exception -> 0x02cf }
                    java.util.HashSet r8 = new java.util.HashSet     // Catch:{ Exception -> 0x02cf }
                    r8.<init>()     // Catch:{ Exception -> 0x02cf }
                L_0x0057:
                    boolean r9 = r2.moveToNext()     // Catch:{ Exception -> 0x02cf }
                    if (r9 == 0) goto L_0x0111
                    com.luck.picture.lib.loader.LocalMediaPageLoader r9 = com.luck.picture.lib.loader.LocalMediaPageLoader.this     // Catch:{ Exception -> 0x02cf }
                    com.luck.picture.lib.config.SelectorConfig r9 = r9.getConfig()     // Catch:{ Exception -> 0x02cf }
                    boolean r9 = r9.isPageSyncAsCount     // Catch:{ Exception -> 0x02cf }
                    if (r9 == 0) goto L_0x0074
                    com.luck.picture.lib.loader.LocalMediaPageLoader r9 = com.luck.picture.lib.loader.LocalMediaPageLoader.this     // Catch:{ Exception -> 0x02cf }
                    r10 = 1
                    com.luck.picture.lib.entity.LocalMedia r9 = r9.parseLocalMedia(r2, r10)     // Catch:{ Exception -> 0x02cf }
                    if (r9 != 0) goto L_0x0071
                    goto L_0x0057
                L_0x0071:
                    r9.recycle()     // Catch:{ Exception -> 0x02cf }
                L_0x0074:
                    int r9 = r2.getColumnIndexOrThrow(r4)     // Catch:{ Exception -> 0x02cf }
                    long r9 = r2.getLong(r9)     // Catch:{ Exception -> 0x02cf }
                    java.lang.Long r11 = java.lang.Long.valueOf(r9)     // Catch:{ Exception -> 0x02cf }
                    java.lang.Object r11 = r0.get(r11)     // Catch:{ Exception -> 0x02cf }
                    java.lang.Long r11 = (java.lang.Long) r11     // Catch:{ Exception -> 0x02cf }
                    r12 = 1
                    if (r11 != 0) goto L_0x008f
                    java.lang.Long r11 = java.lang.Long.valueOf(r12)     // Catch:{ Exception -> 0x02cf }
                    goto L_0x0098
                L_0x008f:
                    long r14 = r11.longValue()     // Catch:{ Exception -> 0x02cf }
                    long r14 = r14 + r12
                    java.lang.Long r11 = java.lang.Long.valueOf(r14)     // Catch:{ Exception -> 0x02cf }
                L_0x0098:
                    java.lang.Long r12 = java.lang.Long.valueOf(r9)     // Catch:{ Exception -> 0x02cf }
                    r0.put(r12, r11)     // Catch:{ Exception -> 0x02cf }
                    java.lang.Long r11 = java.lang.Long.valueOf(r9)     // Catch:{ Exception -> 0x02cf }
                    boolean r11 = r8.contains(r11)     // Catch:{ Exception -> 0x02cf }
                    if (r11 == 0) goto L_0x00aa
                    goto L_0x0057
                L_0x00aa:
                    com.luck.picture.lib.entity.LocalMediaFolder r11 = new com.luck.picture.lib.entity.LocalMediaFolder     // Catch:{ Exception -> 0x02cf }
                    r11.<init>()     // Catch:{ Exception -> 0x02cf }
                    r11.setBucketId(r9)     // Catch:{ Exception -> 0x02cf }
                    int r12 = r2.getColumnIndexOrThrow(r6)     // Catch:{ Exception -> 0x02cf }
                    java.lang.String r12 = r2.getString(r12)     // Catch:{ Exception -> 0x02cf }
                    int r13 = r2.getColumnIndexOrThrow(r5)     // Catch:{ Exception -> 0x02cf }
                    java.lang.String r13 = r2.getString(r13)     // Catch:{ Exception -> 0x02cf }
                    java.lang.Long r14 = java.lang.Long.valueOf(r9)     // Catch:{ Exception -> 0x02cf }
                    boolean r14 = r0.containsKey(r14)     // Catch:{ Exception -> 0x02cf }
                    if (r14 != 0) goto L_0x00cd
                    goto L_0x0057
                L_0x00cd:
                    java.lang.Long r14 = java.lang.Long.valueOf(r9)     // Catch:{ Exception -> 0x02cf }
                    java.lang.Object r14 = r0.get(r14)     // Catch:{ Exception -> 0x02cf }
                    java.lang.Long r14 = (java.lang.Long) r14     // Catch:{ Exception -> 0x02cf }
                    long r14 = r14.longValue()     // Catch:{ Exception -> 0x02cf }
                    java.lang.String r7 = "_id"
                    int r7 = r2.getColumnIndexOrThrow(r7)     // Catch:{ Exception -> 0x02cf }
                    r16 = r4
                    r17 = r5
                    long r4 = r2.getLong(r7)     // Catch:{ Exception -> 0x02cf }
                    r11.setFolderName(r12)     // Catch:{ Exception -> 0x02cf }
                    java.lang.Long r7 = java.lang.Long.valueOf(r14)     // Catch:{ Exception -> 0x02cf }
                    int r7 = com.luck.picture.lib.utils.ValueOf.toInt(r7)     // Catch:{ Exception -> 0x02cf }
                    r11.setFolderTotalNum(r7)     // Catch:{ Exception -> 0x02cf }
                    java.lang.String r4 = com.luck.picture.lib.utils.MediaUtils.getRealPathUri(r4, r13)     // Catch:{ Exception -> 0x02cf }
                    r11.setFirstImagePath(r4)     // Catch:{ Exception -> 0x02cf }
                    r11.setFirstMimeType(r13)     // Catch:{ Exception -> 0x02cf }
                    r3.add(r11)     // Catch:{ Exception -> 0x02cf }
                    java.lang.Long r4 = java.lang.Long.valueOf(r9)     // Catch:{ Exception -> 0x02cf }
                    r8.add(r4)     // Catch:{ Exception -> 0x02cf }
                    r4 = r16
                    r5 = r17
                    goto L_0x0057
                L_0x0111:
                    java.util.Iterator r4 = r3.iterator()     // Catch:{ Exception -> 0x02cf }
                    r5 = 0
                L_0x0116:
                    boolean r6 = r4.hasNext()     // Catch:{ Exception -> 0x02cf }
                    if (r6 == 0) goto L_0x018e
                    java.lang.Object r6 = r4.next()     // Catch:{ Exception -> 0x02cf }
                    com.luck.picture.lib.entity.LocalMediaFolder r6 = (com.luck.picture.lib.entity.LocalMediaFolder) r6     // Catch:{ Exception -> 0x02cf }
                    long r7 = r6.getBucketId()     // Catch:{ Exception -> 0x02cf }
                    java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ Exception -> 0x02cf }
                    java.lang.Object r7 = r0.get(r7)     // Catch:{ Exception -> 0x02cf }
                    int r7 = com.luck.picture.lib.utils.ValueOf.toInt(r7)     // Catch:{ Exception -> 0x02cf }
                    r6.setFolderTotalNum(r7)     // Catch:{ Exception -> 0x02cf }
                    int r5 = r5 + r7
                    goto L_0x0116
                L_0x0137:
                    r16 = r4
                    r17 = r5
                    r2.moveToFirst()     // Catch:{ Exception -> 0x02cf }
                    r0 = 0
                L_0x013f:
                    java.lang.String r4 = "_data"
                    int r4 = r2.getColumnIndexOrThrow(r4)     // Catch:{ Exception -> 0x02cf }
                    java.lang.String r4 = r2.getString(r4)     // Catch:{ Exception -> 0x02cf }
                    int r5 = r2.getColumnIndexOrThrow(r6)     // Catch:{ Exception -> 0x02cf }
                    java.lang.String r5 = r2.getString(r5)     // Catch:{ Exception -> 0x02cf }
                    r7 = r17
                    int r8 = r2.getColumnIndexOrThrow(r7)     // Catch:{ Exception -> 0x02cf }
                    java.lang.String r8 = r2.getString(r8)     // Catch:{ Exception -> 0x02cf }
                    r9 = r16
                    int r10 = r2.getColumnIndexOrThrow(r9)     // Catch:{ Exception -> 0x02cf }
                    long r10 = r2.getLong(r10)     // Catch:{ Exception -> 0x02cf }
                    java.lang.String r12 = "count"
                    int r12 = r2.getColumnIndexOrThrow(r12)     // Catch:{ Exception -> 0x02cf }
                    int r12 = r2.getInt(r12)     // Catch:{ Exception -> 0x02cf }
                    com.luck.picture.lib.entity.LocalMediaFolder r13 = new com.luck.picture.lib.entity.LocalMediaFolder     // Catch:{ Exception -> 0x02cf }
                    r13.<init>()     // Catch:{ Exception -> 0x02cf }
                    r13.setBucketId(r10)     // Catch:{ Exception -> 0x02cf }
                    r13.setFirstImagePath(r4)     // Catch:{ Exception -> 0x02cf }
                    r13.setFolderName(r5)     // Catch:{ Exception -> 0x02cf }
                    r13.setFirstMimeType(r8)     // Catch:{ Exception -> 0x02cf }
                    r13.setFolderTotalNum(r12)     // Catch:{ Exception -> 0x02cf }
                    r3.add(r13)     // Catch:{ Exception -> 0x02cf }
                    int r0 = r0 + r12
                    boolean r4 = r2.moveToNext()     // Catch:{ Exception -> 0x02cf }
                    if (r4 != 0) goto L_0x02c7
                    r5 = r0
                L_0x018e:
                    com.luck.picture.lib.entity.LocalMediaFolder r0 = new com.luck.picture.lib.entity.LocalMediaFolder     // Catch:{ Exception -> 0x02cf }
                    r0.<init>()     // Catch:{ Exception -> 0x02cf }
                    com.luck.picture.lib.loader.LocalMediaPageLoader r4 = com.luck.picture.lib.loader.LocalMediaPageLoader.this     // Catch:{ Exception -> 0x02cf }
                    android.content.Context r4 = r4.getContext()     // Catch:{ Exception -> 0x02cf }
                    com.luck.picture.lib.loader.LocalMediaPageLoader r6 = com.luck.picture.lib.loader.LocalMediaPageLoader.this     // Catch:{ Exception -> 0x02cf }
                    com.luck.picture.lib.config.SelectorConfig r6 = r6.getConfig()     // Catch:{ Exception -> 0x02cf }
                    java.lang.String r6 = r6.sandboxDir     // Catch:{ Exception -> 0x02cf }
                    com.luck.picture.lib.entity.LocalMediaFolder r4 = com.luck.picture.lib.loader.SandboxFileLoader.loadInAppSandboxFolderFile(r4, r6)     // Catch:{ Exception -> 0x02cf }
                    if (r4 == 0) goto L_0x0229
                    r3.add(r4)     // Catch:{ Exception -> 0x02cf }
                    java.lang.String r6 = r4.getFirstImagePath()     // Catch:{ Exception -> 0x02cf }
                    java.io.File r7 = new java.io.File     // Catch:{ Exception -> 0x02cf }
                    r7.<init>(r6)     // Catch:{ Exception -> 0x02cf }
                    long r6 = r7.lastModified()     // Catch:{ Exception -> 0x02cf }
                    int r8 = r4.getFolderTotalNum()     // Catch:{ Exception -> 0x02cf }
                    int r5 = r5 + r8
                    java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ Exception -> 0x02cf }
                    r8.<init>()     // Catch:{ Exception -> 0x02cf }
                    r0.setData(r8)     // Catch:{ Exception -> 0x02cf }
                    boolean r8 = r2.moveToFirst()     // Catch:{ Exception -> 0x02cf }
                    if (r8 == 0) goto L_0x0248
                    boolean r8 = com.luck.picture.lib.utils.SdkVersionUtils.isQ()     // Catch:{ Exception -> 0x02cf }
                    if (r8 == 0) goto L_0x01d5
                    java.lang.String r8 = com.luck.picture.lib.loader.LocalMediaPageLoader.getFirstUri(r2)     // Catch:{ Exception -> 0x02cf }
                    goto L_0x01d9
                L_0x01d5:
                    java.lang.String r8 = com.luck.picture.lib.loader.LocalMediaPageLoader.getFirstUrl(r2)     // Catch:{ Exception -> 0x02cf }
                L_0x01d9:
                    r0.setFirstImagePath(r8)     // Catch:{ Exception -> 0x02cf }
                    java.lang.String r8 = com.luck.picture.lib.loader.LocalMediaPageLoader.getFirstCoverMimeType(r2)     // Catch:{ Exception -> 0x02cf }
                    r0.setFirstMimeType(r8)     // Catch:{ Exception -> 0x02cf }
                    java.lang.String r8 = r0.getFirstImagePath()     // Catch:{ Exception -> 0x02cf }
                    boolean r8 = com.luck.picture.lib.config.PictureMimeType.isContent(r8)     // Catch:{ Exception -> 0x02cf }
                    if (r8 == 0) goto L_0x0209
                    com.luck.picture.lib.loader.LocalMediaPageLoader r8 = com.luck.picture.lib.loader.LocalMediaPageLoader.this     // Catch:{ Exception -> 0x02cf }
                    android.content.Context r8 = r8.getContext()     // Catch:{ Exception -> 0x02cf }
                    java.lang.String r9 = r0.getFirstImagePath()     // Catch:{ Exception -> 0x02cf }
                    android.net.Uri r9 = android.net.Uri.parse(r9)     // Catch:{ Exception -> 0x02cf }
                    java.lang.String r8 = com.luck.picture.lib.utils.PictureFileUtils.getPath(r8, r9)     // Catch:{ Exception -> 0x02cf }
                    java.io.File r9 = new java.io.File     // Catch:{ Exception -> 0x02cf }
                    r9.<init>(r8)     // Catch:{ Exception -> 0x02cf }
                    long r8 = r9.lastModified()     // Catch:{ Exception -> 0x02cf }
                    goto L_0x0216
                L_0x0209:
                    java.io.File r8 = new java.io.File     // Catch:{ Exception -> 0x02cf }
                    java.lang.String r9 = r0.getFirstImagePath()     // Catch:{ Exception -> 0x02cf }
                    r8.<init>(r9)     // Catch:{ Exception -> 0x02cf }
                    long r8 = r8.lastModified()     // Catch:{ Exception -> 0x02cf }
                L_0x0216:
                    int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                    if (r6 <= 0) goto L_0x0248
                    java.lang.String r6 = r4.getFirstImagePath()     // Catch:{ Exception -> 0x02cf }
                    r0.setFirstImagePath(r6)     // Catch:{ Exception -> 0x02cf }
                    java.lang.String r4 = r4.getFirstMimeType()     // Catch:{ Exception -> 0x02cf }
                    r0.setFirstMimeType(r4)     // Catch:{ Exception -> 0x02cf }
                    goto L_0x0248
                L_0x0229:
                    boolean r4 = r2.moveToFirst()     // Catch:{ Exception -> 0x02cf }
                    if (r4 == 0) goto L_0x0248
                    boolean r4 = com.luck.picture.lib.utils.SdkVersionUtils.isQ()     // Catch:{ Exception -> 0x02cf }
                    if (r4 == 0) goto L_0x023a
                    java.lang.String r4 = com.luck.picture.lib.loader.LocalMediaPageLoader.getFirstUri(r2)     // Catch:{ Exception -> 0x02cf }
                    goto L_0x023e
                L_0x023a:
                    java.lang.String r4 = com.luck.picture.lib.loader.LocalMediaPageLoader.getFirstUrl(r2)     // Catch:{ Exception -> 0x02cf }
                L_0x023e:
                    r0.setFirstImagePath(r4)     // Catch:{ Exception -> 0x02cf }
                    java.lang.String r4 = com.luck.picture.lib.loader.LocalMediaPageLoader.getFirstCoverMimeType(r2)     // Catch:{ Exception -> 0x02cf }
                    r0.setFirstMimeType(r4)     // Catch:{ Exception -> 0x02cf }
                L_0x0248:
                    if (r5 != 0) goto L_0x0254
                    boolean r0 = r2.isClosed()
                    if (r0 != 0) goto L_0x0253
                    r2.close()
                L_0x0253:
                    return r3
                L_0x0254:
                    com.luck.picture.lib.utils.SortUtils.sortFolder(r3)     // Catch:{ Exception -> 0x02cf }
                    r0.setFolderTotalNum(r5)     // Catch:{ Exception -> 0x02cf }
                    r4 = -1
                    r0.setBucketId(r4)     // Catch:{ Exception -> 0x02cf }
                    com.luck.picture.lib.loader.LocalMediaPageLoader r4 = com.luck.picture.lib.loader.LocalMediaPageLoader.this     // Catch:{ Exception -> 0x02cf }
                    com.luck.picture.lib.config.SelectorConfig r4 = r4.getConfig()     // Catch:{ Exception -> 0x02cf }
                    java.lang.String r4 = r4.defaultAlbumName     // Catch:{ Exception -> 0x02cf }
                    boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x02cf }
                    if (r4 == 0) goto L_0x0291
                    com.luck.picture.lib.loader.LocalMediaPageLoader r4 = com.luck.picture.lib.loader.LocalMediaPageLoader.this     // Catch:{ Exception -> 0x02cf }
                    com.luck.picture.lib.config.SelectorConfig r4 = r4.getConfig()     // Catch:{ Exception -> 0x02cf }
                    int r4 = r4.chooseMode     // Catch:{ Exception -> 0x02cf }
                    int r5 = com.luck.picture.lib.config.SelectMimeType.ofAudio()     // Catch:{ Exception -> 0x02cf }
                    if (r4 != r5) goto L_0x0288
                    com.luck.picture.lib.loader.LocalMediaPageLoader r4 = com.luck.picture.lib.loader.LocalMediaPageLoader.this     // Catch:{ Exception -> 0x02cf }
                    android.content.Context r4 = r4.getContext()     // Catch:{ Exception -> 0x02cf }
                    int r5 = com.luck.picture.lib.R.string.ps_all_audio     // Catch:{ Exception -> 0x02cf }
                L_0x0283:
                    java.lang.String r4 = r4.getString(r5)     // Catch:{ Exception -> 0x02cf }
                    goto L_0x0299
                L_0x0288:
                    com.luck.picture.lib.loader.LocalMediaPageLoader r4 = com.luck.picture.lib.loader.LocalMediaPageLoader.this     // Catch:{ Exception -> 0x02cf }
                    android.content.Context r4 = r4.getContext()     // Catch:{ Exception -> 0x02cf }
                    int r5 = com.luck.picture.lib.R.string.ps_camera_roll     // Catch:{ Exception -> 0x02cf }
                    goto L_0x0283
                L_0x0291:
                    com.luck.picture.lib.loader.LocalMediaPageLoader r4 = com.luck.picture.lib.loader.LocalMediaPageLoader.this     // Catch:{ Exception -> 0x02cf }
                    com.luck.picture.lib.config.SelectorConfig r4 = r4.getConfig()     // Catch:{ Exception -> 0x02cf }
                    java.lang.String r4 = r4.defaultAlbumName     // Catch:{ Exception -> 0x02cf }
                L_0x0299:
                    r0.setFolderName(r4)     // Catch:{ Exception -> 0x02cf }
                    r4 = 0
                    r3.add(r4, r0)     // Catch:{ Exception -> 0x02cf }
                    com.luck.picture.lib.loader.LocalMediaPageLoader r0 = com.luck.picture.lib.loader.LocalMediaPageLoader.this     // Catch:{ Exception -> 0x02cf }
                    com.luck.picture.lib.config.SelectorConfig r0 = r0.getConfig()     // Catch:{ Exception -> 0x02cf }
                    boolean r0 = r0.isSyncCover     // Catch:{ Exception -> 0x02cf }
                    if (r0 == 0) goto L_0x02bd
                    com.luck.picture.lib.loader.LocalMediaPageLoader r0 = com.luck.picture.lib.loader.LocalMediaPageLoader.this     // Catch:{ Exception -> 0x02cf }
                    com.luck.picture.lib.config.SelectorConfig r0 = r0.getConfig()     // Catch:{ Exception -> 0x02cf }
                    int r0 = r0.chooseMode     // Catch:{ Exception -> 0x02cf }
                    int r4 = com.luck.picture.lib.config.SelectMimeType.ofAll()     // Catch:{ Exception -> 0x02cf }
                    if (r0 != r4) goto L_0x02bd
                    com.luck.picture.lib.loader.LocalMediaPageLoader r0 = com.luck.picture.lib.loader.LocalMediaPageLoader.this     // Catch:{ Exception -> 0x02cf }
                    r0.synchronousFirstCover(r3)     // Catch:{ Exception -> 0x02cf }
                L_0x02bd:
                    boolean r0 = r2.isClosed()
                    if (r0 != 0) goto L_0x02c6
                    r2.close()
                L_0x02c6:
                    return r3
                L_0x02c7:
                    r17 = r7
                    r16 = r9
                    goto L_0x013f
                L_0x02cd:
                    r0 = move-exception
                    goto L_0x02f4
                L_0x02cf:
                    r0 = move-exception
                    r0.printStackTrace()     // Catch:{ all -> 0x02cd }
                    java.lang.String r3 = com.luck.picture.lib.loader.IBridgeMediaLoader.TAG     // Catch:{ all -> 0x02cd }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x02cd }
                    r4.<init>()     // Catch:{ all -> 0x02cd }
                    java.lang.String r5 = "loadAllMedia Data Error: "
                    r4.append(r5)     // Catch:{ all -> 0x02cd }
                    java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x02cd }
                    r4.append(r0)     // Catch:{ all -> 0x02cd }
                    java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x02cd }
                    android.util.Log.i(r3, r0)     // Catch:{ all -> 0x02cd }
                    boolean r0 = r2.isClosed()
                    if (r0 != 0) goto L_0x0309
                    goto L_0x0306
                L_0x02f4:
                    boolean r3 = r2.isClosed()
                    if (r3 != 0) goto L_0x02fd
                    r2.close()
                L_0x02fd:
                    throw r0
                L_0x02fe:
                    if (r2 == 0) goto L_0x0309
                    boolean r0 = r2.isClosed()
                    if (r0 != 0) goto L_0x0309
                L_0x0306:
                    r2.close()
                L_0x0309:
                    java.util.ArrayList r0 = new java.util.ArrayList
                    r0.<init>()
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.loader.LocalMediaPageLoader.AnonymousClass3.doInBackground():java.util.List");
            }

            public void onSuccess(List<LocalMediaFolder> list) {
                PictureThreadUtils.cancel((PictureThreadUtils.Task) this);
                LocalMedia.destroyPool();
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
                return SandboxFileLoader.loadInAppSandboxFolderFile(LocalMediaPageLoader.this.getContext(), LocalMediaPageLoader.this.getConfig().sandboxDir);
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
        final long j12 = j11;
        final int i13 = i12;
        final int i14 = i11;
        final OnQueryDataResultListener<LocalMedia> onQueryDataResultListener2 = onQueryDataResultListener;
        PictureThreadUtils.executeByIo(new PictureThreadUtils.SimpleTask<MediaData>() {
            /* JADX WARNING: type inference failed for: r0v0, types: [android.os.CancellationSignal, android.database.Cursor] */
            public MediaData doInBackground() {
                Cursor cursor;
                ArrayList<LocalMedia> loadInAppSandboxFile;
                String str;
                ? r02 = 0;
                try {
                    boolean z11 = true;
                    if (SdkVersionUtils.isR()) {
                        String access$000 = LocalMediaPageLoader.this.getPageSelection(j12);
                        String[] access$100 = LocalMediaPageLoader.this.getPageSelectionArgs(j12);
                        int i11 = i13;
                        cursor = LocalMediaPageLoader.this.getContext().getContentResolver().query(IBridgeMediaLoader.QUERY_URI, IBridgeMediaLoader.PROJECTION, MediaUtils.createQueryArgsBundle(access$000, access$100, i11, (i14 - 1) * i11, LocalMediaPageLoader.this.getSortOrder()), r02);
                    } else {
                        if (i14 == -1) {
                            str = LocalMediaPageLoader.this.getSortOrder();
                        } else {
                            str = LocalMediaPageLoader.this.getSortOrder() + " limit " + i13 + " offset " + ((i14 - 1) * i13);
                        }
                        cursor = LocalMediaPageLoader.this.getContext().getContentResolver().query(IBridgeMediaLoader.QUERY_URI, IBridgeMediaLoader.PROJECTION, LocalMediaPageLoader.this.getPageSelection(j12), LocalMediaPageLoader.this.getPageSelectionArgs(j12), str);
                    }
                    if (cursor != null) {
                        ArrayList arrayList = new ArrayList();
                        if (cursor.getCount() > 0) {
                            cursor.moveToFirst();
                            do {
                                LocalMedia parseLocalMedia = LocalMediaPageLoader.this.parseLocalMedia(cursor, false);
                                if (parseLocalMedia != null) {
                                    arrayList.add(parseLocalMedia);
                                }
                            } while (cursor.moveToNext());
                        }
                        if (j12 == -1 && i14 == 1 && (loadInAppSandboxFile = SandboxFileLoader.loadInAppSandboxFile(LocalMediaPageLoader.this.getContext(), LocalMediaPageLoader.this.getConfig().sandboxDir)) != null) {
                            arrayList.addAll(loadInAppSandboxFile);
                            SortUtils.sortLocalMediaAddedTime(arrayList);
                        }
                        if (cursor.getCount() <= 0) {
                            z11 = false;
                        }
                        MediaData mediaData = new MediaData(z11, arrayList);
                        if (!cursor.isClosed()) {
                            cursor.close();
                        }
                        return mediaData;
                    }
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    return new MediaData();
                } catch (Exception e11) {
                    e11.printStackTrace();
                    Log.i(IBridgeMediaLoader.TAG, "loadMedia Page Data Error: " + e11.getMessage());
                    MediaData mediaData2 = new MediaData();
                    if (r02 != 0 && !r02.isClosed()) {
                        r02.close();
                    }
                    return mediaData2;
                } catch (Throwable th2) {
                    if (r02 != 0 && !r02.isClosed()) {
                        r02.close();
                    }
                    throw th2;
                }
            }

            public void onSuccess(MediaData mediaData) {
                PictureThreadUtils.cancel((PictureThreadUtils.Task) this);
                OnQueryDataResultListener onQueryDataResultListener = onQueryDataResultListener2;
                if (onQueryDataResultListener != null) {
                    ArrayList<LocalMedia> arrayList = mediaData.data;
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    onQueryDataResultListener.onComplete(arrayList, mediaData.isHasNextMore);
                }
            }
        });
    }

    public LocalMedia parseLocalMedia(Cursor cursor, boolean z11) {
        String str;
        int i11;
        long j11;
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
        long j12 = cursor2.getLong(columnIndexOrThrow);
        String string = cursor2.getString(columnIndexOrThrow3);
        String string2 = cursor2.getString(columnIndexOrThrow2);
        String realPathUri = SdkVersionUtils.isQ() ? MediaUtils.getRealPathUri(j12, string) : string2;
        if (TextUtils.isEmpty(string)) {
            string = PictureMimeType.ofJPEG();
        }
        if (getConfig().isFilterInvalidFile) {
            if (PictureMimeType.isHasImage(string)) {
                if (!TextUtils.isEmpty(string2) && !PictureFileUtils.isImageFileExists(string2)) {
                    return null;
                }
            } else if (!PictureFileUtils.isFileExists(string2)) {
                return null;
            }
        }
        if (string.endsWith(SelectMimeType.SYSTEM_IMAGE)) {
            string = MediaUtils.getMimeTypeFromMediaUrl(string2);
            str = realPathUri;
            if (!getConfig().isGif && PictureMimeType.isHasGif(string)) {
                return null;
            }
        } else {
            str = realPathUri;
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
        int i15 = i12;
        if (i14 == 90 || i14 == 270) {
            i11 = cursor2.getInt(columnIndexOrThrow5);
            i13 = cursor2.getInt(columnIndexOrThrow4);
        } else {
            i11 = i15;
        }
        long j13 = cursor2.getLong(columnIndexOrThrow6);
        long j14 = cursor2.getLong(columnIndexOrThrow7);
        String string3 = cursor2.getString(columnIndexOrThrow8);
        String string4 = cursor2.getString(columnIndexOrThrow9);
        long j15 = cursor2.getLong(columnIndexOrThrow10);
        String str2 = string3;
        long j16 = cursor2.getLong(columnIndexOrThrow11);
        if (TextUtils.isEmpty(string4)) {
            string4 = PictureMimeType.getUrlToFileName(string2);
        }
        if (getConfig().isFilterSizeDuration && j14 > 0 && j14 < 1024) {
            return null;
        }
        if (PictureMimeType.isHasVideo(string) || PictureMimeType.isHasAudio(string)) {
            if (getConfig().filterVideoMinSecond > 0) {
                j11 = j16;
                if (j13 < ((long) getConfig().filterVideoMinSecond)) {
                    return null;
                }
            } else {
                j11 = j16;
            }
            if (getConfig().filterVideoMaxSecond > 0 && j13 > ((long) getConfig().filterVideoMaxSecond)) {
                return null;
            }
            if (getConfig().isFilterSizeDuration && j13 <= 0) {
                return null;
            }
        } else {
            j11 = j16;
        }
        LocalMedia obtain = z11 ? LocalMedia.obtain() : LocalMedia.create();
        obtain.setId(j12);
        obtain.setBucketId(j15);
        obtain.setPath(str);
        obtain.setRealPath(string2);
        obtain.setFileName(string4);
        obtain.setParentFolderName(str2);
        obtain.setDuration(j13);
        obtain.setChooseModel(getConfig().chooseMode);
        obtain.setMimeType(string);
        obtain.setWidth(i11);
        obtain.setHeight(i13);
        obtain.setSize(j14);
        obtain.setDateAddedTime(j11);
        OnQueryFilterListener onQueryFilterListener = this.mConfig.onQueryFilterListener;
        if (onQueryFilterListener == null || !onQueryFilterListener.onFilter(obtain)) {
            return obtain;
        }
        return null;
    }
}
