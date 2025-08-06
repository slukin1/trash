package okhttp3.internal.http2;

import com.adjust.sdk.Constants;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.huobi.points.entity.PointsPack;
import com.huobi.vulcan.model.VulcanInfo;
import com.jumio.sdk.reject.JumioRejectReason;
import com.tencent.android.tpush.common.MessageKey;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;

public final class Hpack {
    public static final Hpack INSTANCE;
    private static final Map<ByteString, Integer> NAME_TO_FIRST_INDEX;
    private static final int PREFIX_4_BITS = 15;
    private static final int PREFIX_5_BITS = 31;
    private static final int PREFIX_6_BITS = 63;
    private static final int PREFIX_7_BITS = 127;
    private static final int SETTINGS_HEADER_TABLE_SIZE = 4096;
    private static final int SETTINGS_HEADER_TABLE_SIZE_LIMIT = 16384;
    private static final Header[] STATIC_HEADER_TABLE;

    static {
        Hpack hpack = new Hpack();
        INSTANCE = hpack;
        ByteString byteString = Header.TARGET_METHOD;
        ByteString byteString2 = Header.TARGET_PATH;
        ByteString byteString3 = Header.TARGET_SCHEME;
        ByteString byteString4 = Header.RESPONSE_STATUS;
        STATIC_HEADER_TABLE = new Header[]{new Header(Header.TARGET_AUTHORITY, ""), new Header(byteString, "GET"), new Header(byteString, "POST"), new Header(byteString2, "/"), new Header(byteString2, "/index.html"), new Header(byteString3, "http"), new Header(byteString3, (String) Constants.SCHEME), new Header(byteString4, (String) JumioRejectReason.NOT_READABLE), new Header(byteString4, "204"), new Header(byteString4, (String) JumioRejectReason.MISSING_BACK), new Header(byteString4, "304"), new Header(byteString4, "400"), new Header(byteString4, "404"), new Header(byteString4, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header((String) PointsPack.PURCHASABLE_TYPE_UNKNOWN_ALLOW, ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header("cookie", ""), new Header((String) MessageKey.MSG_DATE, ""), new Header("etag", ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header((String) VulcanInfo.HOST, ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header("location", ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header((String) HBBaseWebActivity.REFRESH_TAG, ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "")};
        NAME_TO_FIRST_INDEX = hpack.nameToFirstIndex();
    }

    private Hpack() {
    }

    private final Map<ByteString, Integer> nameToFirstIndex() {
        Header[] headerArr = STATIC_HEADER_TABLE;
        LinkedHashMap linkedHashMap = new LinkedHashMap(headerArr.length);
        int length = headerArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            Header[] headerArr2 = STATIC_HEADER_TABLE;
            if (!linkedHashMap.containsKey(headerArr2[i11].name)) {
                linkedHashMap.put(headerArr2[i11].name, Integer.valueOf(i11));
            }
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public final ByteString checkLowercase(ByteString byteString) throws IOException {
        int size = byteString.size();
        int i11 = 0;
        while (i11 < size) {
            byte b11 = byteString.getByte(i11);
            if (!(65 <= b11 && b11 < 91)) {
                i11++;
            } else {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString.utf8());
            }
        }
        return byteString;
    }

    public final Map<ByteString, Integer> getNAME_TO_FIRST_INDEX() {
        return NAME_TO_FIRST_INDEX;
    }

    public final Header[] getSTATIC_HEADER_TABLE() {
        return STATIC_HEADER_TABLE;
    }

    public static final class Reader {
        public Header[] dynamicTable;
        public int dynamicTableByteCount;
        public int headerCount;
        private final List<Header> headerList;
        private final int headerTableSizeSetting;
        private int maxDynamicTableByteCount;
        private int nextHeaderIndex;
        private final BufferedSource source;

        public Reader(Source source2, int i11) {
            this(source2, i11, 0, 4, (r) null);
        }

        public Reader(Source source2, int i11, int i12) {
            this.headerTableSizeSetting = i11;
            this.maxDynamicTableByteCount = i12;
            this.headerList = new ArrayList();
            this.source = Okio.buffer(source2);
            Header[] headerArr = new Header[8];
            this.dynamicTable = headerArr;
            this.nextHeaderIndex = headerArr.length - 1;
        }

        private final void adjustDynamicTableByteCount() {
            int i11 = this.maxDynamicTableByteCount;
            int i12 = this.dynamicTableByteCount;
            if (i11 >= i12) {
                return;
            }
            if (i11 == 0) {
                clearDynamicTable();
            } else {
                evictToRecoverBytes(i12 - i11);
            }
        }

        private final void clearDynamicTable() {
            ArraysKt___ArraysJvmKt.p(this.dynamicTable, (Object) null, 0, 0, 6, (Object) null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private final int dynamicTableIndex(int i11) {
            return this.nextHeaderIndex + 1 + i11;
        }

        private final int evictToRecoverBytes(int i11) {
            int i12;
            int i13 = 0;
            if (i11 > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i12 = this.nextHeaderIndex;
                    if (length < i12 || i11 <= 0) {
                        Header[] headerArr = this.dynamicTable;
                        System.arraycopy(headerArr, i12 + 1, headerArr, i12 + 1 + i13, this.headerCount);
                        this.nextHeaderIndex += i13;
                    } else {
                        int i14 = this.dynamicTable[length].hpackSize;
                        i11 -= i14;
                        this.dynamicTableByteCount -= i14;
                        this.headerCount--;
                        i13++;
                    }
                }
                Header[] headerArr2 = this.dynamicTable;
                System.arraycopy(headerArr2, i12 + 1, headerArr2, i12 + 1 + i13, this.headerCount);
                this.nextHeaderIndex += i13;
            }
            return i13;
        }

        private final ByteString getName(int i11) throws IOException {
            if (isStaticHeader(i11)) {
                return Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[i11].name;
            }
            int dynamicTableIndex = dynamicTableIndex(i11 - Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length);
            if (dynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (dynamicTableIndex < headerArr.length) {
                    return headerArr[dynamicTableIndex].name;
                }
            }
            throw new IOException("Header index too large " + (i11 + 1));
        }

        private final void insertIntoDynamicTable(int i11, Header header) {
            this.headerList.add(header);
            int i12 = header.hpackSize;
            if (i11 != -1) {
                i12 -= this.dynamicTable[dynamicTableIndex(i11)].hpackSize;
            }
            int i13 = this.maxDynamicTableByteCount;
            if (i12 > i13) {
                clearDynamicTable();
                return;
            }
            int evictToRecoverBytes = evictToRecoverBytes((this.dynamicTableByteCount + i12) - i13);
            if (i11 == -1) {
                int i14 = this.headerCount + 1;
                Header[] headerArr = this.dynamicTable;
                if (i14 > headerArr.length) {
                    Header[] headerArr2 = new Header[(headerArr.length * 2)];
                    System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                    this.nextHeaderIndex = this.dynamicTable.length - 1;
                    this.dynamicTable = headerArr2;
                }
                int i15 = this.nextHeaderIndex;
                this.nextHeaderIndex = i15 - 1;
                this.dynamicTable[i15] = header;
                this.headerCount++;
            } else {
                this.dynamicTable[i11 + dynamicTableIndex(i11) + evictToRecoverBytes] = header;
            }
            this.dynamicTableByteCount += i12;
        }

        private final boolean isStaticHeader(int i11) {
            return i11 >= 0 && i11 <= Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length - 1;
        }

        private final int readByte() throws IOException {
            return Util.and(this.source.readByte(), 255);
        }

        private final void readIndexedHeader(int i11) throws IOException {
            if (isStaticHeader(i11)) {
                this.headerList.add(Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[i11]);
                return;
            }
            int dynamicTableIndex = dynamicTableIndex(i11 - Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length);
            if (dynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (dynamicTableIndex < headerArr.length) {
                    this.headerList.add(headerArr[dynamicTableIndex]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i11 + 1));
        }

        private final void readLiteralHeaderWithIncrementalIndexingIndexedName(int i11) throws IOException {
            insertIntoDynamicTable(-1, new Header(getName(i11), readByteString()));
        }

        private final void readLiteralHeaderWithIncrementalIndexingNewName() throws IOException {
            insertIntoDynamicTable(-1, new Header(Hpack.INSTANCE.checkLowercase(readByteString()), readByteString()));
        }

        private final void readLiteralHeaderWithoutIndexingIndexedName(int i11) throws IOException {
            this.headerList.add(new Header(getName(i11), readByteString()));
        }

        private final void readLiteralHeaderWithoutIndexingNewName() throws IOException {
            this.headerList.add(new Header(Hpack.INSTANCE.checkLowercase(readByteString()), readByteString()));
        }

        public final List<Header> getAndResetHeaderList() {
            List<Header> I0 = CollectionsKt___CollectionsKt.I0(this.headerList);
            this.headerList.clear();
            return I0;
        }

        public final int maxDynamicTableByteCount() {
            return this.maxDynamicTableByteCount;
        }

        public final ByteString readByteString() throws IOException {
            int readByte = readByte();
            boolean z11 = (readByte & 128) == 128;
            long readInt = (long) readInt(readByte, 127);
            if (!z11) {
                return this.source.readByteString(readInt);
            }
            Buffer buffer = new Buffer();
            Huffman.INSTANCE.decode(this.source, readInt, buffer);
            return buffer.readByteString();
        }

        public final void readHeaders() throws IOException {
            while (!this.source.exhausted()) {
                int and = Util.and(this.source.readByte(), 255);
                if (and == 128) {
                    throw new IOException("index == 0");
                } else if ((and & 128) == 128) {
                    readIndexedHeader(readInt(and, 127) - 1);
                } else if (and == 64) {
                    readLiteralHeaderWithIncrementalIndexingNewName();
                } else if ((and & 64) == 64) {
                    readLiteralHeaderWithIncrementalIndexingIndexedName(readInt(and, 63) - 1);
                } else if ((and & 32) == 32) {
                    int readInt = readInt(and, 31);
                    this.maxDynamicTableByteCount = readInt;
                    if (readInt < 0 || readInt > this.headerTableSizeSetting) {
                        throw new IOException("Invalid dynamic table size update " + this.maxDynamicTableByteCount);
                    }
                    adjustDynamicTableByteCount();
                } else if (and == 16 || and == 0) {
                    readLiteralHeaderWithoutIndexingNewName();
                } else {
                    readLiteralHeaderWithoutIndexingIndexedName(readInt(and, 15) - 1);
                }
            }
        }

        public final int readInt(int i11, int i12) throws IOException {
            int i13 = i11 & i12;
            if (i13 < i12) {
                return i13;
            }
            int i14 = 0;
            while (true) {
                int readByte = readByte();
                if ((readByte & 128) == 0) {
                    return i12 + (readByte << i14);
                }
                i12 += (readByte & 127) << i14;
                i14 += 7;
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Reader(Source source2, int i11, int i12, int i13, r rVar) {
            this(source2, i11, (i13 & 4) != 0 ? i11 : i12);
        }
    }

    public static final class Writer {
        public Header[] dynamicTable;
        public int dynamicTableByteCount;
        private boolean emitDynamicTableSizeUpdate;
        public int headerCount;
        public int headerTableSizeSetting;
        public int maxDynamicTableByteCount;
        private int nextHeaderIndex;
        private final Buffer out;
        private int smallestHeaderTableSizeSetting;
        private final boolean useCompression;

        public Writer(int i11, Buffer buffer) {
            this(i11, false, buffer, 2, (r) null);
        }

        public Writer(int i11, boolean z11, Buffer buffer) {
            this.headerTableSizeSetting = i11;
            this.useCompression = z11;
            this.out = buffer;
            this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
            this.maxDynamicTableByteCount = i11;
            Header[] headerArr = new Header[8];
            this.dynamicTable = headerArr;
            this.nextHeaderIndex = headerArr.length - 1;
        }

        public Writer(Buffer buffer) {
            this(0, false, buffer, 3, (r) null);
        }

        private final void adjustDynamicTableByteCount() {
            int i11 = this.maxDynamicTableByteCount;
            int i12 = this.dynamicTableByteCount;
            if (i11 >= i12) {
                return;
            }
            if (i11 == 0) {
                clearDynamicTable();
            } else {
                evictToRecoverBytes(i12 - i11);
            }
        }

        private final void clearDynamicTable() {
            ArraysKt___ArraysJvmKt.p(this.dynamicTable, (Object) null, 0, 0, 6, (Object) null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private final int evictToRecoverBytes(int i11) {
            int i12;
            int i13 = 0;
            if (i11 > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i12 = this.nextHeaderIndex;
                    if (length < i12 || i11 <= 0) {
                        Header[] headerArr = this.dynamicTable;
                        System.arraycopy(headerArr, i12 + 1, headerArr, i12 + 1 + i13, this.headerCount);
                        Header[] headerArr2 = this.dynamicTable;
                        int i14 = this.nextHeaderIndex;
                        Arrays.fill(headerArr2, i14 + 1, i14 + 1 + i13, (Object) null);
                        this.nextHeaderIndex += i13;
                    } else {
                        i11 -= this.dynamicTable[length].hpackSize;
                        this.dynamicTableByteCount -= this.dynamicTable[length].hpackSize;
                        this.headerCount--;
                        i13++;
                    }
                }
                Header[] headerArr3 = this.dynamicTable;
                System.arraycopy(headerArr3, i12 + 1, headerArr3, i12 + 1 + i13, this.headerCount);
                Header[] headerArr22 = this.dynamicTable;
                int i142 = this.nextHeaderIndex;
                Arrays.fill(headerArr22, i142 + 1, i142 + 1 + i13, (Object) null);
                this.nextHeaderIndex += i13;
            }
            return i13;
        }

        private final void insertIntoDynamicTable(Header header) {
            int i11 = header.hpackSize;
            int i12 = this.maxDynamicTableByteCount;
            if (i11 > i12) {
                clearDynamicTable();
                return;
            }
            evictToRecoverBytes((this.dynamicTableByteCount + i11) - i12);
            int i13 = this.headerCount + 1;
            Header[] headerArr = this.dynamicTable;
            if (i13 > headerArr.length) {
                Header[] headerArr2 = new Header[(headerArr.length * 2)];
                System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.dynamicTable = headerArr2;
            }
            int i14 = this.nextHeaderIndex;
            this.nextHeaderIndex = i14 - 1;
            this.dynamicTable[i14] = header;
            this.headerCount++;
            this.dynamicTableByteCount += i11;
        }

        public final void resizeHeaderTable(int i11) {
            this.headerTableSizeSetting = i11;
            int min = Math.min(i11, 16384);
            int i12 = this.maxDynamicTableByteCount;
            if (i12 != min) {
                if (min < i12) {
                    this.smallestHeaderTableSizeSetting = Math.min(this.smallestHeaderTableSizeSetting, min);
                }
                this.emitDynamicTableSizeUpdate = true;
                this.maxDynamicTableByteCount = min;
                adjustDynamicTableByteCount();
            }
        }

        public final void writeByteString(ByteString byteString) throws IOException {
            if (this.useCompression) {
                Huffman huffman = Huffman.INSTANCE;
                if (huffman.encodedLength(byteString) < byteString.size()) {
                    Buffer buffer = new Buffer();
                    huffman.encode(byteString, buffer);
                    ByteString readByteString = buffer.readByteString();
                    writeInt(readByteString.size(), 127, 128);
                    this.out.write(readByteString);
                    return;
                }
            }
            writeInt(byteString.size(), 127, 0);
            this.out.write(byteString);
        }

        public final void writeHeaders(List<Header> list) throws IOException {
            int i11;
            int i12;
            if (this.emitDynamicTableSizeUpdate) {
                int i13 = this.smallestHeaderTableSizeSetting;
                if (i13 < this.maxDynamicTableByteCount) {
                    writeInt(i13, 31, 32);
                }
                this.emitDynamicTableSizeUpdate = false;
                this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
                writeInt(this.maxDynamicTableByteCount, 31, 32);
            }
            int size = list.size();
            for (int i14 = 0; i14 < size; i14++) {
                Header header = list.get(i14);
                ByteString asciiLowercase = header.name.toAsciiLowercase();
                ByteString byteString = header.value;
                Hpack hpack = Hpack.INSTANCE;
                Integer num = hpack.getNAME_TO_FIRST_INDEX().get(asciiLowercase);
                if (num != null) {
                    i11 = num.intValue() + 1;
                    if (2 <= i11 && i11 < 8) {
                        if (x.b(hpack.getSTATIC_HEADER_TABLE()[i11 - 1].value, byteString)) {
                            i12 = i11;
                        } else if (x.b(hpack.getSTATIC_HEADER_TABLE()[i11].value, byteString)) {
                            int i15 = i11;
                            i11++;
                            i12 = i15;
                        }
                    }
                    i12 = i11;
                    i11 = -1;
                } else {
                    i12 = -1;
                    i11 = -1;
                }
                if (i11 == -1) {
                    int i16 = this.nextHeaderIndex + 1;
                    int length = this.dynamicTable.length;
                    while (true) {
                        if (i16 >= length) {
                            break;
                        }
                        if (x.b(this.dynamicTable[i16].name, asciiLowercase)) {
                            if (x.b(this.dynamicTable[i16].value, byteString)) {
                                i11 = Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length + (i16 - this.nextHeaderIndex);
                                break;
                            } else if (i12 == -1) {
                                i12 = (i16 - this.nextHeaderIndex) + Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length;
                            }
                        }
                        i16++;
                    }
                }
                if (i11 != -1) {
                    writeInt(i11, 127, 128);
                } else if (i12 == -1) {
                    this.out.writeByte(64);
                    writeByteString(asciiLowercase);
                    writeByteString(byteString);
                    insertIntoDynamicTable(header);
                } else if (!asciiLowercase.startsWith(Header.PSEUDO_PREFIX) || x.b(Header.TARGET_AUTHORITY, asciiLowercase)) {
                    writeInt(i12, 63, 64);
                    writeByteString(byteString);
                    insertIntoDynamicTable(header);
                } else {
                    writeInt(i12, 15, 0);
                    writeByteString(byteString);
                }
            }
        }

        public final void writeInt(int i11, int i12, int i13) {
            if (i11 < i12) {
                this.out.writeByte(i11 | i13);
                return;
            }
            this.out.writeByte(i13 | i12);
            int i14 = i11 - i12;
            while (i14 >= 128) {
                this.out.writeByte(128 | (i14 & 127));
                i14 >>>= 7;
            }
            this.out.writeByte(i14);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Writer(int i11, boolean z11, Buffer buffer, int i12, r rVar) {
            this((i12 & 1) != 0 ? 4096 : i11, (i12 & 2) != 0 ? true : z11, buffer);
        }
    }
}
