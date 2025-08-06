package okio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;
import kotlin.collections.a;
import kotlin.jvm.internal.r;

public final class Options extends a<ByteString> implements RandomAccess {
    public static final Companion Companion = new Companion((r) null);
    private final ByteString[] byteStrings;
    private final int[] trie;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        private final void buildTrieRecursive(long j11, Buffer buffer, int i11, List<? extends ByteString> list, int i12, int i13, List<Integer> list2) {
            int i14;
            int i15;
            int i16;
            int i17;
            Buffer buffer2;
            Buffer buffer3 = buffer;
            int i18 = i11;
            List<? extends ByteString> list3 = list;
            int i19 = i12;
            int i21 = i13;
            List<Integer> list4 = list2;
            if (i19 < i21) {
                int i22 = i19;
                while (i22 < i21) {
                    if (((ByteString) list3.get(i22)).size() >= i18) {
                        i22++;
                    } else {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                }
                ByteString byteString = (ByteString) list.get(i12);
                ByteString byteString2 = (ByteString) list3.get(i21 - 1);
                int i23 = -1;
                if (i18 == byteString.size()) {
                    int intValue = list4.get(i19).intValue();
                    int i24 = i19 + 1;
                    i14 = i24;
                    i15 = intValue;
                    byteString = (ByteString) list3.get(i24);
                } else {
                    i14 = i19;
                    i15 = -1;
                }
                if (byteString.getByte(i18) != byteString2.getByte(i18)) {
                    int i25 = 1;
                    for (int i26 = i14 + 1; i26 < i21; i26++) {
                        if (((ByteString) list3.get(i26 - 1)).getByte(i18) != ((ByteString) list3.get(i26)).getByte(i18)) {
                            i25++;
                        }
                    }
                    long intCount = j11 + getIntCount(buffer3) + ((long) 2) + ((long) (i25 * 2));
                    buffer3.writeInt(i25);
                    buffer3.writeInt(i15);
                    for (int i27 = i14; i27 < i21; i27++) {
                        byte b11 = ((ByteString) list3.get(i27)).getByte(i18);
                        if (i27 == i14 || b11 != ((ByteString) list3.get(i27 - 1)).getByte(i18)) {
                            buffer3.writeInt((int) b11 & 255);
                        }
                    }
                    Buffer buffer4 = new Buffer();
                    while (i14 < i21) {
                        byte b12 = ((ByteString) list3.get(i14)).getByte(i18);
                        int i28 = i14 + 1;
                        int i29 = i28;
                        while (true) {
                            if (i29 >= i21) {
                                i16 = i21;
                                break;
                            } else if (b12 != ((ByteString) list3.get(i29)).getByte(i18)) {
                                i16 = i29;
                                break;
                            } else {
                                i29++;
                            }
                        }
                        if (i28 == i16 && i18 + 1 == ((ByteString) list3.get(i14)).size()) {
                            buffer3.writeInt(list4.get(i14).intValue());
                            i17 = i16;
                            buffer2 = buffer4;
                        } else {
                            buffer3.writeInt(((int) (intCount + getIntCount(buffer4))) * i23);
                            i17 = i16;
                            buffer2 = buffer4;
                            buildTrieRecursive(intCount, buffer4, i18 + 1, list, i14, i16, list2);
                        }
                        buffer4 = buffer2;
                        i14 = i17;
                        i23 = -1;
                    }
                    buffer3.writeAll(buffer4);
                    return;
                }
                int min = Math.min(byteString.size(), byteString2.size());
                int i30 = i18;
                int i31 = 0;
                while (i30 < min && byteString.getByte(i30) == byteString2.getByte(i30)) {
                    i31++;
                    i30++;
                }
                long intCount2 = j11 + getIntCount(buffer3) + ((long) 2) + ((long) i31) + 1;
                buffer3.writeInt(-i31);
                buffer3.writeInt(i15);
                int i32 = i18 + i31;
                while (i18 < i32) {
                    buffer3.writeInt((int) byteString.getByte(i18) & 255);
                    i18++;
                }
                if (i14 + 1 == i21) {
                    if (i32 == ((ByteString) list3.get(i14)).size()) {
                        buffer3.writeInt(list4.get(i14).intValue());
                        return;
                    }
                    throw new IllegalStateException("Check failed.".toString());
                }
                Buffer buffer5 = new Buffer();
                buffer3.writeInt(((int) (getIntCount(buffer5) + intCount2)) * -1);
                buildTrieRecursive(intCount2, buffer5, i32, list, i14, i13, list2);
                buffer3.writeAll(buffer5);
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        public static /* synthetic */ void buildTrieRecursive$default(Companion companion, long j11, Buffer buffer, int i11, List list, int i12, int i13, List list2, int i14, Object obj) {
            companion.buildTrieRecursive((i14 & 1) != 0 ? 0 : j11, buffer, (i14 & 4) != 0 ? 0 : i11, list, (i14 & 16) != 0 ? 0 : i12, (i14 & 32) != 0 ? list.size() : i13, list2);
        }

        private final long getIntCount(Buffer buffer) {
            return buffer.size() / ((long) 4);
        }

        public final Options of(ByteString... byteStringArr) {
            ByteString[] byteStringArr2 = byteStringArr;
            int i11 = 0;
            if (byteStringArr2.length == 0) {
                return new Options(new ByteString[0], new int[]{0, -1}, (r) null);
            }
            List E0 = ArraysKt___ArraysKt.E0(byteStringArr);
            CollectionsKt__MutableCollectionsJVMKt.y(E0);
            ArrayList arrayList = new ArrayList(byteStringArr2.length);
            for (ByteString byteString : byteStringArr2) {
                arrayList.add(-1);
            }
            Integer[] numArr = (Integer[]) arrayList.toArray(new Integer[0]);
            List p11 = CollectionsKt__CollectionsKt.p(Arrays.copyOf(numArr, numArr.length));
            int length = byteStringArr2.length;
            int i12 = 0;
            int i13 = 0;
            while (i12 < length) {
                p11.set(CollectionsKt__CollectionsKt.j(E0, byteStringArr2[i12], 0, 0, 6, (Object) null), Integer.valueOf(i13));
                i12++;
                i13++;
            }
            if (((ByteString) E0.get(0)).size() > 0) {
                int i14 = 0;
                while (i14 < E0.size()) {
                    ByteString byteString2 = (ByteString) E0.get(i14);
                    int i15 = i14 + 1;
                    int i16 = i15;
                    while (i16 < E0.size()) {
                        ByteString byteString3 = (ByteString) E0.get(i16);
                        if (!byteString3.startsWith(byteString2)) {
                            continue;
                            break;
                        }
                        if (!(byteString3.size() != byteString2.size())) {
                            throw new IllegalArgumentException(("duplicate option: " + byteString3).toString());
                        } else if (((Number) p11.get(i16)).intValue() > ((Number) p11.get(i14)).intValue()) {
                            E0.remove(i16);
                            p11.remove(i16);
                        } else {
                            i16++;
                        }
                    }
                    i14 = i15;
                }
                Buffer buffer = new Buffer();
                buildTrieRecursive$default(this, 0, buffer, 0, E0, 0, 0, p11, 53, (Object) null);
                int[] iArr = new int[((int) getIntCount(buffer))];
                while (!buffer.exhausted()) {
                    iArr[i11] = buffer.readInt();
                    i11++;
                }
                return new Options((ByteString[]) Arrays.copyOf(byteStringArr2, byteStringArr2.length), iArr, (r) null);
            }
            throw new IllegalArgumentException("the empty byte string is not a supported option".toString());
        }
    }

    private Options(ByteString[] byteStringArr, int[] iArr) {
        this.byteStrings = byteStringArr;
        this.trie = iArr;
    }

    public /* synthetic */ Options(ByteString[] byteStringArr, int[] iArr, r rVar) {
        this(byteStringArr, iArr);
    }

    public static final Options of(ByteString... byteStringArr) {
        return Companion.of(byteStringArr);
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof ByteString)) {
            return false;
        }
        return contains((ByteString) obj);
    }

    public final ByteString[] getByteStrings$okio() {
        return this.byteStrings;
    }

    public int getSize() {
        return this.byteStrings.length;
    }

    public final int[] getTrie$okio() {
        return this.trie;
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (!(obj instanceof ByteString)) {
            return -1;
        }
        return indexOf((ByteString) obj);
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (!(obj instanceof ByteString)) {
            return -1;
        }
        return lastIndexOf((ByteString) obj);
    }

    public /* bridge */ boolean contains(ByteString byteString) {
        return super.contains(byteString);
    }

    public ByteString get(int i11) {
        return this.byteStrings[i11];
    }

    public /* bridge */ int indexOf(ByteString byteString) {
        return super.indexOf(byteString);
    }

    public /* bridge */ int lastIndexOf(ByteString byteString) {
        return super.lastIndexOf(byteString);
    }
}
