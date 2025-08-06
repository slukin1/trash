package okhttp3;

import a10.b;
import e10.a;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import kotlin.Pair;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.r;
import kotlin.l;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;

public final class Headers implements Iterable<Pair<? extends String, ? extends String>>, a {
    public static final Companion Companion = new Companion((r) null);
    private final String[] namesAndValues;

    public static final class Builder {
        private final List<String> namesAndValues = new ArrayList(20);

        public final Builder add(String str) {
            int f02 = StringsKt__StringsKt.f0(str, ':', 0, false, 6, (Object) null);
            if (f02 != -1) {
                add(StringsKt__StringsKt.i1(str.substring(0, f02)).toString(), str.substring(f02 + 1));
                return this;
            }
            throw new IllegalArgumentException(("Unexpected header: " + str).toString());
        }

        public final Builder addAll(Headers headers) {
            int size = headers.size();
            for (int i11 = 0; i11 < size; i11++) {
                addLenient$okhttp(headers.name(i11), headers.value(i11));
            }
            return this;
        }

        public final Builder addLenient$okhttp(String str) {
            int f02 = StringsKt__StringsKt.f0(str, ':', 1, false, 4, (Object) null);
            if (f02 != -1) {
                addLenient$okhttp(str.substring(0, f02), str.substring(f02 + 1));
            } else if (str.charAt(0) == ':') {
                addLenient$okhttp("", str.substring(1));
            } else {
                addLenient$okhttp("", str);
            }
            return this;
        }

        public final Builder addUnsafeNonAscii(String str, String str2) {
            Headers.Companion.checkName(str);
            addLenient$okhttp(str, str2);
            return this;
        }

        public final Headers build() {
            return new Headers((String[]) this.namesAndValues.toArray(new String[0]), (r) null);
        }

        public final String get(String str) {
            int size = this.namesAndValues.size() - 2;
            int c11 = b.c(size, 0, -2);
            if (c11 > size) {
                return null;
            }
            while (!StringsKt__StringsJVMKt.w(str, this.namesAndValues.get(size), true)) {
                if (size == c11) {
                    return null;
                }
                size -= 2;
            }
            return this.namesAndValues.get(size + 1);
        }

        public final List<String> getNamesAndValues$okhttp() {
            return this.namesAndValues;
        }

        public final Builder removeAll(String str) {
            int i11 = 0;
            while (i11 < this.namesAndValues.size()) {
                if (StringsKt__StringsJVMKt.w(str, this.namesAndValues.get(i11), true)) {
                    this.namesAndValues.remove(i11);
                    this.namesAndValues.remove(i11);
                    i11 -= 2;
                }
                i11 += 2;
            }
            return this;
        }

        public final Builder set(String str, Date date) {
            set(str, DatesKt.toHttpDateString(date));
            return this;
        }

        public final Builder set(String str, Instant instant) {
            return set(str, new Date(instant.toEpochMilli()));
        }

        public final Builder set(String str, String str2) {
            Companion companion = Headers.Companion;
            companion.checkName(str);
            companion.checkValue(str2, str);
            removeAll(str);
            addLenient$okhttp(str, str2);
            return this;
        }

        public final Builder add(String str, String str2) {
            Companion companion = Headers.Companion;
            companion.checkName(str);
            companion.checkValue(str2, str);
            addLenient$okhttp(str, str2);
            return this;
        }

        public final Builder addLenient$okhttp(String str, String str2) {
            this.namesAndValues.add(str);
            this.namesAndValues.add(StringsKt__StringsKt.i1(str2).toString());
            return this;
        }

        public final Builder add(String str, Date date) {
            add(str, DatesKt.toHttpDateString(date));
            return this;
        }

        public final Builder add(String str, Instant instant) {
            add(str, new Date(instant.toEpochMilli()));
            return this;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        /* access modifiers changed from: private */
        public final void checkName(String str) {
            if (str.length() > 0) {
                int length = str.length();
                int i11 = 0;
                while (i11 < length) {
                    char charAt = str.charAt(i11);
                    if ('!' <= charAt && charAt < 127) {
                        i11++;
                    } else {
                        throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i11), str).toString());
                    }
                }
                return;
            }
            throw new IllegalArgumentException("name is empty".toString());
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x006f A[LOOP:0: B:1:0x0006->B:20:0x006f, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0024 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void checkValue(java.lang.String r7, java.lang.String r8) {
            /*
                r6 = this;
                int r0 = r7.length()
                r1 = 0
                r2 = r1
            L_0x0006:
                if (r2 >= r0) goto L_0x0072
                char r3 = r7.charAt(r2)
                r4 = 9
                r5 = 1
                if (r3 == r4) goto L_0x0021
                r4 = 32
                if (r4 > r3) goto L_0x001b
                r4 = 127(0x7f, float:1.78E-43)
                if (r3 >= r4) goto L_0x001b
                r4 = r5
                goto L_0x001c
            L_0x001b:
                r4 = r1
            L_0x001c:
                if (r4 == 0) goto L_0x001f
                goto L_0x0021
            L_0x001f:
                r4 = r1
                goto L_0x0022
            L_0x0021:
                r4 = r5
            L_0x0022:
                if (r4 != 0) goto L_0x006f
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r4 = 3
                java.lang.Object[] r4 = new java.lang.Object[r4]
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                r4[r1] = r3
                java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
                r4[r5] = r1
                r1 = 2
                r4[r1] = r8
                java.lang.String r1 = "Unexpected char %#04x at %d in %s value"
                java.lang.String r1 = okhttp3.internal.Util.format(r1, r4)
                r0.append(r1)
                boolean r8 = okhttp3.internal.Util.isSensitiveHeader(r8)
                if (r8 == 0) goto L_0x004d
                java.lang.String r7 = ""
                goto L_0x005e
            L_0x004d:
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>()
                java.lang.String r1 = ": "
                r8.append(r1)
                r8.append(r7)
                java.lang.String r7 = r8.toString()
            L_0x005e:
                r0.append(r7)
                java.lang.String r7 = r0.toString()
                java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
                java.lang.String r7 = r7.toString()
                r8.<init>(r7)
                throw r8
            L_0x006f:
                int r2 = r2 + 1
                goto L_0x0006
            L_0x0072:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.Headers.Companion.checkValue(java.lang.String, java.lang.String):void");
        }

        /* access modifiers changed from: private */
        public final String get(String[] strArr, String str) {
            int length = strArr.length - 2;
            int c11 = b.c(length, 0, -2);
            if (c11 > length) {
                return null;
            }
            while (!StringsKt__StringsJVMKt.w(str, strArr[length], true)) {
                if (length == c11) {
                    return null;
                }
                length -= 2;
            }
            return strArr[length + 1];
        }

        /* renamed from: -deprecated_of  reason: not valid java name */
        public final Headers m3135deprecated_of(String... strArr) {
            return of((String[]) Arrays.copyOf(strArr, strArr.length));
        }

        public final Headers of(String... strArr) {
            int i11 = 0;
            if (strArr.length % 2 == 0) {
                String[] strArr2 = (String[]) strArr.clone();
                int length = strArr2.length;
                int i12 = 0;
                while (i12 < length) {
                    if (strArr2[i12] != null) {
                        strArr2[i12] = StringsKt__StringsKt.i1(strArr2[i12]).toString();
                        i12++;
                    } else {
                        throw new IllegalArgumentException("Headers cannot be null".toString());
                    }
                }
                int c11 = b.c(0, strArr2.length - 1, 2);
                if (c11 >= 0) {
                    while (true) {
                        String str = strArr2[i11];
                        String str2 = strArr2[i11 + 1];
                        checkName(str);
                        checkValue(str2, str);
                        if (i11 == c11) {
                            break;
                        }
                        i11 += 2;
                    }
                }
                return new Headers(strArr2, (r) null);
            }
            throw new IllegalArgumentException("Expected alternating header names and values".toString());
        }

        /* renamed from: -deprecated_of  reason: not valid java name */
        public final Headers m3134deprecated_of(Map<String, String> map) {
            return of(map);
        }

        public final Headers of(Map<String, String> map) {
            String[] strArr = new String[(map.size() * 2)];
            int i11 = 0;
            for (Map.Entry next : map.entrySet()) {
                String obj = StringsKt__StringsKt.i1((String) next.getKey()).toString();
                String obj2 = StringsKt__StringsKt.i1((String) next.getValue()).toString();
                checkName(obj);
                checkValue(obj2, obj);
                strArr[i11] = obj;
                strArr[i11 + 1] = obj2;
                i11 += 2;
            }
            return new Headers(strArr, (r) null);
        }
    }

    private Headers(String[] strArr) {
        this.namesAndValues = strArr;
    }

    public /* synthetic */ Headers(String[] strArr, r rVar) {
        this(strArr);
    }

    public static final Headers of(Map<String, String> map) {
        return Companion.of(map);
    }

    public static final Headers of(String... strArr) {
        return Companion.of(strArr);
    }

    /* renamed from: -deprecated_size  reason: not valid java name */
    public final int m3133deprecated_size() {
        return size();
    }

    public final long byteCount() {
        String[] strArr = this.namesAndValues;
        long length = (long) (strArr.length * 2);
        int length2 = strArr.length;
        for (int i11 = 0; i11 < length2; i11++) {
            length += (long) this.namesAndValues[i11].length();
        }
        return length;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Headers) && Arrays.equals(this.namesAndValues, ((Headers) obj).namesAndValues);
    }

    public final String get(String str) {
        return Companion.get(this.namesAndValues, str);
    }

    public final Date getDate(String str) {
        String str2 = get(str);
        if (str2 != null) {
            return DatesKt.toHttpDateOrNull(str2);
        }
        return null;
    }

    public final Instant getInstant(String str) {
        Date date = getDate(str);
        if (date != null) {
            return date.toInstant();
        }
        return null;
    }

    public int hashCode() {
        return Arrays.hashCode(this.namesAndValues);
    }

    public Iterator<Pair<String, String>> iterator() {
        int size = size();
        Pair[] pairArr = new Pair[size];
        for (int i11 = 0; i11 < size; i11++) {
            pairArr[i11] = l.a(name(i11), value(i11));
        }
        return h.a(pairArr);
    }

    public final String name(int i11) {
        return this.namesAndValues[i11 * 2];
    }

    public final Set<String> names() {
        TreeSet treeSet = new TreeSet(StringsKt__StringsJVMKt.y(d0.f56774a));
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            treeSet.add(name(i11));
        }
        return Collections.unmodifiableSet(treeSet);
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        boolean unused = CollectionsKt__MutableCollectionsKt.B(builder.getNamesAndValues$okhttp(), this.namesAndValues);
        return builder;
    }

    public final int size() {
        return this.namesAndValues.length / 2;
    }

    public final Map<String, List<String>> toMultimap() {
        TreeMap treeMap = new TreeMap(StringsKt__StringsJVMKt.y(d0.f56774a));
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            String lowerCase = name(i11).toLowerCase(Locale.US);
            List list = (List) treeMap.get(lowerCase);
            if (list == null) {
                list = new ArrayList(2);
                treeMap.put(lowerCase, list);
            }
            list.add(value(i11));
        }
        return treeMap;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            String name = name(i11);
            String value = value(i11);
            sb2.append(name);
            sb2.append(com.sumsub.sns.internal.fingerprint.infoproviders.l.f34627b);
            if (Util.isSensitiveHeader(name)) {
                value = "██";
            }
            sb2.append(value);
            sb2.append("\n");
        }
        return sb2.toString();
    }

    public final String value(int i11) {
        return this.namesAndValues[(i11 * 2) + 1];
    }

    public final List<String> values(String str) {
        int size = size();
        ArrayList arrayList = null;
        for (int i11 = 0; i11 < size; i11++) {
            if (StringsKt__StringsJVMKt.w(str, name(i11), true)) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(value(i11));
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return CollectionsKt__CollectionsKt.k();
    }
}
