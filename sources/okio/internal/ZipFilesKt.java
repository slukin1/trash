package okio.internal;

import com.tencent.android.tpush.common.Constants;
import com.tencent.thumbplayer.tcmedia.api.TPOptionalID;
import d10.p;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.r;
import kotlin.l;
import okhttp3.internal.ws.WebSocketProtocol;
import okio.BufferedSource;
import okio.FileMetadata;
import okio.FileSystem;
import okio.Path;
import okio.ZipFileSystem;

public final class ZipFilesKt {
    private static final int BIT_FLAG_ENCRYPTED = 1;
    private static final int BIT_FLAG_UNSUPPORTED_MASK = 1;
    private static final int CENTRAL_FILE_HEADER_SIGNATURE = 33639248;
    public static final int COMPRESSION_METHOD_DEFLATED = 8;
    public static final int COMPRESSION_METHOD_STORED = 0;
    private static final int END_OF_CENTRAL_DIRECTORY_SIGNATURE = 101010256;
    private static final int HEADER_ID_EXTENDED_TIMESTAMP = 21589;
    private static final int HEADER_ID_ZIP64_EXTENDED_INFO = 1;
    private static final int LOCAL_FILE_HEADER_SIGNATURE = 67324752;
    private static final long MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE = 4294967295L;
    private static final int ZIP64_EOCD_RECORD_SIGNATURE = 101075792;
    private static final int ZIP64_LOCATOR_SIGNATURE = 117853008;

    private static final Map<Path, ZipEntry> buildIndex(List<ZipEntry> list) {
        Path path = Path.Companion.get$default(Path.Companion, "/", false, 1, (Object) null);
        Map<Path, ZipEntry> m11 = MapsKt__MapsKt.m(l.a(path, new ZipEntry(path, true, (String) null, 0, 0, 0, 0, (Long) null, 0, TPOptionalID.OPTION_ID_GLOBAL_BOOL_ENABLE_SUGGESTED_BITRATE_CALLBACK, (r) null)));
        for (ZipEntry zipEntry : CollectionsKt___CollectionsKt.z0(list, new ZipFilesKt$buildIndex$$inlined$sortedBy$1())) {
            if (m11.put(zipEntry.getCanonicalPath(), zipEntry) == null) {
                while (true) {
                    Path parent = zipEntry.getCanonicalPath().parent();
                    if (parent == null) {
                        break;
                    }
                    ZipEntry zipEntry2 = m11.get(parent);
                    if (zipEntry2 != null) {
                        zipEntry2.getChildren().add(zipEntry.getCanonicalPath());
                        break;
                    }
                    ZipEntry zipEntry3 = r4;
                    ZipEntry zipEntry4 = new ZipEntry(parent, true, (String) null, 0, 0, 0, 0, (Long) null, 0, TPOptionalID.OPTION_ID_GLOBAL_BOOL_ENABLE_SUGGESTED_BITRATE_CALLBACK, (r) null);
                    ZipEntry zipEntry5 = zipEntry3;
                    m11.put(parent, zipEntry5);
                    zipEntry5.getChildren().add(zipEntry.getCanonicalPath());
                    zipEntry = zipEntry5;
                }
            }
        }
        return m11;
    }

    private static final Long dosDateTimeToEpochMillis(int i11, int i12) {
        if (i12 == -1) {
            return null;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(14, 0);
        GregorianCalendar gregorianCalendar2 = gregorianCalendar;
        gregorianCalendar2.set(((i11 >> 9) & 127) + 1980, ((i11 >> 5) & 15) - 1, i11 & 31, (i12 >> 11) & 31, (i12 >> 5) & 63, (i12 & 31) << 1);
        return Long.valueOf(gregorianCalendar.getTime().getTime());
    }

    private static final String getHex(int i11) {
        return "0x" + Integer.toString(i11, CharsKt__CharJVMKt.a(16));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r9.close();
        r3 = r3 - ((long) 20);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0047, code lost:
        if (r3 <= 0) goto L_0x00cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0049, code lost:
        r3 = okio.Okio.buffer(r2.source(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0058, code lost:
        if (r3.readIntLe() != ZIP64_LOCATOR_SIGNATURE) goto L_0x00be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005a, code lost:
        r4 = r3.readIntLe();
        r11 = r3.readLongLe();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0067, code lost:
        if (r3.readIntLe() != 1) goto L_0x00b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0069, code lost:
        if (r4 != 0) goto L_0x00b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006b, code lost:
        r4 = okio.Okio.buffer(r2.source(r11));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r9 = r4.readIntLe();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007a, code lost:
        if (r9 != ZIP64_EOCD_RECORD_SIGNATURE) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007c, code lost:
        r7 = readZip64EocdRecord(r4, r7);
        r9 = kotlin.Unit.f56620a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        kotlin.io.b.a(r4, (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00ac, code lost:
        throw new java.io.IOException("bad zip: expected " + getHex(ZIP64_EOCD_RECORD_SIGNATURE) + " but was " + getHex(r9));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ad, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00b0, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b1, code lost:
        r5 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        kotlin.io.b.a(r4, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00b5, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00bd, code lost:
        throw new java.io.IOException("unsupported zip: spanned");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00be, code lost:
        r4 = kotlin.Unit.f56620a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        kotlin.io.b.a(r3, (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00c4, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00c5, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00c7, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00c8, code lost:
        r4 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        kotlin.io.b.a(r3, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00cc, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00cd, code lost:
        r3 = new java.util.ArrayList();
        r4 = okio.Okio.buffer(r2.source(r7.getCentralDirectoryOffset()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        r11 = r7.getEntryCount();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00e4, code lost:
        if (r5 >= r11) goto L_0x0113;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00e6, code lost:
        r9 = readEntry(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00f4, code lost:
        if (r9.getOffset() >= r7.getCentralDirectoryOffset()) goto L_0x010b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0102, code lost:
        if (r19.invoke(r9).booleanValue() == false) goto L_0x0107;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0104, code lost:
        r3.add(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0107, code lost:
        r5 = r5 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0112, code lost:
        throw new java.io.IOException("bad zip: local file header offset >= central directory offset");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0113, code lost:
        r5 = kotlin.Unit.f56620a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
        kotlin.io.b.a(r4, (java.lang.Throwable) null);
        r4 = new okio.ZipFileSystem(r0, r1, buildIndex(r3), r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0121, code lost:
        kotlin.io.b.a(r2, (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0124, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0125, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0126, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0128, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0129, code lost:
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:?, code lost:
        kotlin.io.b.a(r4, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x012d, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0030, code lost:
        r7 = readEocdRecord(r9);
        r8 = r9.readUtf8((long) r7.getCommentByteCount());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final okio.ZipFileSystem openZip(okio.Path r17, okio.FileSystem r18, d10.l<? super okio.internal.ZipEntry, java.lang.Boolean> r19) throws java.io.IOException {
        /*
            r0 = r17
            r1 = r18
            okio.FileHandle r2 = r1.openReadOnly(r0)
            long r3 = r2.size()     // Catch:{ all -> 0x0164 }
            r5 = 22
            long r5 = (long) r5     // Catch:{ all -> 0x0164 }
            long r3 = r3 - r5
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 < 0) goto L_0x0149
            r7 = 65536(0x10000, double:3.2379E-319)
            long r7 = r3 - r7
            long r7 = java.lang.Math.max(r7, r5)     // Catch:{ all -> 0x0164 }
        L_0x001f:
            okio.Source r9 = r2.source(r3)     // Catch:{ all -> 0x0164 }
            okio.BufferedSource r9 = okio.Okio.buffer((okio.Source) r9)     // Catch:{ all -> 0x0164 }
            int r10 = r9.readIntLe()     // Catch:{ all -> 0x0144 }
            r11 = 101010256(0x6054b50, float:2.506985E-35)
            if (r10 != r11) goto L_0x012e
            okio.internal.EocdRecord r7 = readEocdRecord(r9)     // Catch:{ all -> 0x0144 }
            int r8 = r7.getCommentByteCount()     // Catch:{ all -> 0x0144 }
            long r10 = (long) r8     // Catch:{ all -> 0x0144 }
            java.lang.String r8 = r9.readUtf8(r10)     // Catch:{ all -> 0x0144 }
            r9.close()     // Catch:{ all -> 0x0164 }
            r9 = 20
            long r9 = (long) r9     // Catch:{ all -> 0x0164 }
            long r3 = r3 - r9
            int r9 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            r10 = 0
            if (r9 <= 0) goto L_0x00cd
            okio.Source r3 = r2.source(r3)     // Catch:{ all -> 0x0164 }
            okio.BufferedSource r3 = okio.Okio.buffer((okio.Source) r3)     // Catch:{ all -> 0x0164 }
            int r4 = r3.readIntLe()     // Catch:{ all -> 0x00c4 }
            r9 = 117853008(0x7064b50, float:1.0103172E-34)
            if (r4 != r9) goto L_0x00be
            int r4 = r3.readIntLe()     // Catch:{ all -> 0x00c4 }
            long r11 = r3.readLongLe()     // Catch:{ all -> 0x00c4 }
            int r9 = r3.readIntLe()     // Catch:{ all -> 0x00c4 }
            r13 = 1
            if (r9 != r13) goto L_0x00b6
            if (r4 != 0) goto L_0x00b6
            okio.Source r4 = r2.source(r11)     // Catch:{ all -> 0x00c4 }
            okio.BufferedSource r4 = okio.Okio.buffer((okio.Source) r4)     // Catch:{ all -> 0x00c4 }
            int r9 = r4.readIntLe()     // Catch:{ all -> 0x00ad }
            r11 = 101075792(0x6064b50, float:2.525793E-35)
            if (r9 != r11) goto L_0x0086
            okio.internal.EocdRecord r7 = readZip64EocdRecord(r4, r7)     // Catch:{ all -> 0x00ad }
            kotlin.Unit r9 = kotlin.Unit.f56620a     // Catch:{ all -> 0x00ad }
            kotlin.io.b.a(r4, r10)     // Catch:{ all -> 0x00c4 }
            goto L_0x00be
        L_0x0086:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x00ad }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ad }
            r1.<init>()     // Catch:{ all -> 0x00ad }
            java.lang.String r5 = "bad zip: expected "
            r1.append(r5)     // Catch:{ all -> 0x00ad }
            java.lang.String r5 = getHex(r11)     // Catch:{ all -> 0x00ad }
            r1.append(r5)     // Catch:{ all -> 0x00ad }
            java.lang.String r5 = " but was "
            r1.append(r5)     // Catch:{ all -> 0x00ad }
            java.lang.String r5 = getHex(r9)     // Catch:{ all -> 0x00ad }
            r1.append(r5)     // Catch:{ all -> 0x00ad }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00ad }
            r0.<init>(r1)     // Catch:{ all -> 0x00ad }
            throw r0     // Catch:{ all -> 0x00ad }
        L_0x00ad:
            r0 = move-exception
            r1 = r0
            throw r1     // Catch:{ all -> 0x00b0 }
        L_0x00b0:
            r0 = move-exception
            r5 = r0
            kotlin.io.b.a(r4, r1)     // Catch:{ all -> 0x00c4 }
            throw r5     // Catch:{ all -> 0x00c4 }
        L_0x00b6:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x00c4 }
            java.lang.String r1 = "unsupported zip: spanned"
            r0.<init>(r1)     // Catch:{ all -> 0x00c4 }
            throw r0     // Catch:{ all -> 0x00c4 }
        L_0x00be:
            kotlin.Unit r4 = kotlin.Unit.f56620a     // Catch:{ all -> 0x00c4 }
            kotlin.io.b.a(r3, r10)     // Catch:{ all -> 0x0164 }
            goto L_0x00cd
        L_0x00c4:
            r0 = move-exception
            r1 = r0
            throw r1     // Catch:{ all -> 0x00c7 }
        L_0x00c7:
            r0 = move-exception
            r4 = r0
            kotlin.io.b.a(r3, r1)     // Catch:{ all -> 0x0164 }
            throw r4     // Catch:{ all -> 0x0164 }
        L_0x00cd:
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x0164 }
            r3.<init>()     // Catch:{ all -> 0x0164 }
            long r11 = r7.getCentralDirectoryOffset()     // Catch:{ all -> 0x0164 }
            okio.Source r4 = r2.source(r11)     // Catch:{ all -> 0x0164 }
            okio.BufferedSource r4 = okio.Okio.buffer((okio.Source) r4)     // Catch:{ all -> 0x0164 }
            long r11 = r7.getEntryCount()     // Catch:{ all -> 0x0125 }
        L_0x00e2:
            int r9 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r9 >= 0) goto L_0x0113
            okio.internal.ZipEntry r9 = readEntry(r4)     // Catch:{ all -> 0x0125 }
            long r13 = r9.getOffset()     // Catch:{ all -> 0x0125 }
            long r15 = r7.getCentralDirectoryOffset()     // Catch:{ all -> 0x0125 }
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 >= 0) goto L_0x010b
            r13 = r19
            java.lang.Object r14 = r13.invoke(r9)     // Catch:{ all -> 0x0125 }
            java.lang.Boolean r14 = (java.lang.Boolean) r14     // Catch:{ all -> 0x0125 }
            boolean r14 = r14.booleanValue()     // Catch:{ all -> 0x0125 }
            if (r14 == 0) goto L_0x0107
            r3.add(r9)     // Catch:{ all -> 0x0125 }
        L_0x0107:
            r14 = 1
            long r5 = r5 + r14
            goto L_0x00e2
        L_0x010b:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0125 }
            java.lang.String r1 = "bad zip: local file header offset >= central directory offset"
            r0.<init>(r1)     // Catch:{ all -> 0x0125 }
            throw r0     // Catch:{ all -> 0x0125 }
        L_0x0113:
            kotlin.Unit r5 = kotlin.Unit.f56620a     // Catch:{ all -> 0x0125 }
            kotlin.io.b.a(r4, r10)     // Catch:{ all -> 0x0164 }
            java.util.Map r3 = buildIndex(r3)     // Catch:{ all -> 0x0164 }
            okio.ZipFileSystem r4 = new okio.ZipFileSystem     // Catch:{ all -> 0x0164 }
            r4.<init>(r0, r1, r3, r8)     // Catch:{ all -> 0x0164 }
            kotlin.io.b.a(r2, r10)
            return r4
        L_0x0125:
            r0 = move-exception
            r1 = r0
            throw r1     // Catch:{ all -> 0x0128 }
        L_0x0128:
            r0 = move-exception
            r3 = r0
            kotlin.io.b.a(r4, r1)     // Catch:{ all -> 0x0164 }
            throw r3     // Catch:{ all -> 0x0164 }
        L_0x012e:
            r13 = r19
            r9.close()     // Catch:{ all -> 0x0164 }
            r9 = -1
            long r3 = r3 + r9
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 < 0) goto L_0x013c
            goto L_0x001f
        L_0x013c:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0164 }
            java.lang.String r1 = "not a zip: end of central directory signature not found"
            r0.<init>(r1)     // Catch:{ all -> 0x0164 }
            throw r0     // Catch:{ all -> 0x0164 }
        L_0x0144:
            r0 = move-exception
            r9.close()     // Catch:{ all -> 0x0164 }
            throw r0     // Catch:{ all -> 0x0164 }
        L_0x0149:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0164 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0164 }
            r1.<init>()     // Catch:{ all -> 0x0164 }
            java.lang.String r3 = "not a zip: size="
            r1.append(r3)     // Catch:{ all -> 0x0164 }
            long r3 = r2.size()     // Catch:{ all -> 0x0164 }
            r1.append(r3)     // Catch:{ all -> 0x0164 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0164 }
            r0.<init>(r1)     // Catch:{ all -> 0x0164 }
            throw r0     // Catch:{ all -> 0x0164 }
        L_0x0164:
            r0 = move-exception
            r1 = r0
            throw r1     // Catch:{ all -> 0x0167 }
        L_0x0167:
            r0 = move-exception
            r3 = r0
            kotlin.io.b.a(r2, r1)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.ZipFilesKt.openZip(okio.Path, okio.FileSystem, d10.l):okio.ZipFileSystem");
    }

    public static /* synthetic */ ZipFileSystem openZip$default(Path path, FileSystem fileSystem, d10.l lVar, int i11, Object obj) throws IOException {
        if ((i11 & 4) != 0) {
            lVar = ZipFilesKt$openZip$1.INSTANCE;
        }
        return openZip(path, fileSystem, lVar);
    }

    public static final ZipEntry readEntry(BufferedSource bufferedSource) throws IOException {
        Ref$LongRef ref$LongRef;
        long j11;
        BufferedSource bufferedSource2 = bufferedSource;
        int readIntLe = bufferedSource.readIntLe();
        if (readIntLe == CENTRAL_FILE_HEADER_SIGNATURE) {
            bufferedSource2.skip(4);
            short readShortLe = bufferedSource.readShortLe() & Constants.PROTOCOL_NONE;
            if ((readShortLe & 1) == 0) {
                short readShortLe2 = bufferedSource.readShortLe() & Constants.PROTOCOL_NONE;
                Long dosDateTimeToEpochMillis = dosDateTimeToEpochMillis(bufferedSource.readShortLe() & Constants.PROTOCOL_NONE, bufferedSource.readShortLe() & Constants.PROTOCOL_NONE);
                long readIntLe2 = ((long) bufferedSource.readIntLe()) & 4294967295L;
                Ref$LongRef ref$LongRef2 = new Ref$LongRef();
                ref$LongRef2.element = ((long) bufferedSource.readIntLe()) & 4294967295L;
                Ref$LongRef ref$LongRef3 = new Ref$LongRef();
                ref$LongRef3.element = ((long) bufferedSource.readIntLe()) & 4294967295L;
                short readShortLe3 = bufferedSource.readShortLe() & Constants.PROTOCOL_NONE;
                short readShortLe4 = bufferedSource.readShortLe() & Constants.PROTOCOL_NONE;
                short readShortLe5 = bufferedSource.readShortLe() & Constants.PROTOCOL_NONE;
                bufferedSource2.skip(8);
                Ref$LongRef ref$LongRef4 = new Ref$LongRef();
                ref$LongRef4.element = ((long) bufferedSource.readIntLe()) & 4294967295L;
                String readUtf8 = bufferedSource2.readUtf8((long) readShortLe3);
                if (!StringsKt__StringsKt.Q(readUtf8, 0, false, 2, (Object) null)) {
                    if (ref$LongRef3.element == 4294967295L) {
                        j11 = ((long) 8) + 0;
                        ref$LongRef = ref$LongRef4;
                    } else {
                        ref$LongRef = ref$LongRef4;
                        j11 = 0;
                    }
                    if (ref$LongRef2.element == 4294967295L) {
                        j11 += (long) 8;
                    }
                    String str = readUtf8;
                    Ref$LongRef ref$LongRef5 = ref$LongRef;
                    if (ref$LongRef5.element == 4294967295L) {
                        j11 += (long) 8;
                    }
                    long j12 = j11;
                    Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
                    Long l11 = dosDateTimeToEpochMillis;
                    ZipFilesKt$readEntry$1 zipFilesKt$readEntry$1 = r0;
                    short s11 = readShortLe2;
                    Ref$BooleanRef ref$BooleanRef2 = ref$BooleanRef;
                    long j13 = readIntLe2;
                    String str2 = str;
                    Ref$LongRef ref$LongRef6 = ref$LongRef5;
                    Ref$LongRef ref$LongRef7 = ref$LongRef3;
                    short s12 = readShortLe5;
                    ZipFilesKt$readEntry$1 zipFilesKt$readEntry$12 = new ZipFilesKt$readEntry$1(ref$BooleanRef, j12, ref$LongRef3, bufferedSource, ref$LongRef2, ref$LongRef6);
                    readExtra(bufferedSource2, readShortLe4, zipFilesKt$readEntry$1);
                    if (j12 <= 0 || ref$BooleanRef2.element) {
                        return new ZipEntry(Path.Companion.get$default(Path.Companion, "/", false, 1, (Object) null).resolve(str2), StringsKt__StringsJVMKt.v(str2, "/", false, 2, (Object) null), bufferedSource2.readUtf8((long) s12), j13, ref$LongRef2.element, ref$LongRef7.element, s11, l11, ref$LongRef6.element);
                    }
                    throw new IOException("bad zip: zip64 extra required but absent");
                }
                throw new IOException("bad zip: filename contains 0x00");
            }
            throw new IOException("unsupported zip: general purpose bit flag=" + getHex(readShortLe));
        }
        throw new IOException("bad zip: expected " + getHex(CENTRAL_FILE_HEADER_SIGNATURE) + " but was " + getHex(readIntLe));
    }

    private static final EocdRecord readEocdRecord(BufferedSource bufferedSource) throws IOException {
        short readShortLe = bufferedSource.readShortLe() & Constants.PROTOCOL_NONE;
        short readShortLe2 = bufferedSource.readShortLe() & Constants.PROTOCOL_NONE;
        long readShortLe3 = (long) (bufferedSource.readShortLe() & Constants.PROTOCOL_NONE);
        if (readShortLe3 == ((long) (bufferedSource.readShortLe() & Constants.PROTOCOL_NONE)) && readShortLe == 0 && readShortLe2 == 0) {
            bufferedSource.skip(4);
            return new EocdRecord(readShortLe3, 4294967295L & ((long) bufferedSource.readIntLe()), bufferedSource.readShortLe() & Constants.PROTOCOL_NONE);
        }
        throw new IOException("unsupported zip: spanned");
    }

    private static final void readExtra(BufferedSource bufferedSource, int i11, p<? super Integer, ? super Long, Unit> pVar) {
        long j11 = (long) i11;
        while (j11 != 0) {
            if (j11 >= 4) {
                short readShortLe = bufferedSource.readShortLe() & Constants.PROTOCOL_NONE;
                long readShortLe2 = ((long) bufferedSource.readShortLe()) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
                long j12 = j11 - ((long) 4);
                if (j12 >= readShortLe2) {
                    bufferedSource.require(readShortLe2);
                    long size = bufferedSource.getBuffer().size();
                    pVar.invoke(Integer.valueOf(readShortLe), Long.valueOf(readShortLe2));
                    long size2 = (bufferedSource.getBuffer().size() + readShortLe2) - size;
                    int i12 = (size2 > 0 ? 1 : (size2 == 0 ? 0 : -1));
                    if (i12 >= 0) {
                        if (i12 > 0) {
                            bufferedSource.getBuffer().skip(size2);
                        }
                        j11 = j12 - readShortLe2;
                    } else {
                        throw new IOException("unsupported zip: too many bytes processed for " + readShortLe);
                    }
                } else {
                    throw new IOException("bad zip: truncated value in extra field");
                }
            } else {
                throw new IOException("bad zip: truncated header in extra field");
            }
        }
    }

    public static final FileMetadata readLocalHeader(BufferedSource bufferedSource, FileMetadata fileMetadata) {
        return readOrSkipLocalHeader(bufferedSource, fileMetadata);
    }

    private static final FileMetadata readOrSkipLocalHeader(BufferedSource bufferedSource, FileMetadata fileMetadata) {
        BufferedSource bufferedSource2 = bufferedSource;
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = fileMetadata != null ? fileMetadata.getLastModifiedAtMillis() : null;
        Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
        int readIntLe = bufferedSource.readIntLe();
        if (readIntLe == LOCAL_FILE_HEADER_SIGNATURE) {
            bufferedSource2.skip(2);
            short readShortLe = bufferedSource.readShortLe() & Constants.PROTOCOL_NONE;
            if ((readShortLe & 1) == 0) {
                bufferedSource2.skip(18);
                long readShortLe2 = ((long) bufferedSource.readShortLe()) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
                short readShortLe3 = bufferedSource.readShortLe() & Constants.PROTOCOL_NONE;
                bufferedSource2.skip(readShortLe2);
                if (fileMetadata == null) {
                    bufferedSource2.skip((long) readShortLe3);
                    return null;
                }
                readExtra(bufferedSource2, readShortLe3, new ZipFilesKt$readOrSkipLocalHeader$1(bufferedSource2, ref$ObjectRef, ref$ObjectRef2, ref$ObjectRef3));
                return new FileMetadata(fileMetadata.isRegularFile(), fileMetadata.isDirectory(), (Path) null, fileMetadata.getSize(), (Long) ref$ObjectRef3.element, (Long) ref$ObjectRef.element, (Long) ref$ObjectRef2.element, (Map) null, 128, (r) null);
            }
            throw new IOException("unsupported zip: general purpose bit flag=" + getHex(readShortLe));
        }
        throw new IOException("bad zip: expected " + getHex(LOCAL_FILE_HEADER_SIGNATURE) + " but was " + getHex(readIntLe));
    }

    private static final EocdRecord readZip64EocdRecord(BufferedSource bufferedSource, EocdRecord eocdRecord) throws IOException {
        bufferedSource.skip(12);
        int readIntLe = bufferedSource.readIntLe();
        int readIntLe2 = bufferedSource.readIntLe();
        long readLongLe = bufferedSource.readLongLe();
        if (readLongLe == bufferedSource.readLongLe() && readIntLe == 0 && readIntLe2 == 0) {
            bufferedSource.skip(8);
            return new EocdRecord(readLongLe, bufferedSource.readLongLe(), eocdRecord.getCommentByteCount());
        }
        throw new IOException("unsupported zip: spanned");
    }

    public static final void skipLocalHeader(BufferedSource bufferedSource) {
        readOrSkipLocalHeader(bufferedSource, (FileMetadata) null);
    }
}
