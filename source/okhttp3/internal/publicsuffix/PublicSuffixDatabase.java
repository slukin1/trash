package okhttp3.internal.publicsuffix;

import com.amazonaws.services.s3.model.InstructionFileId;
import d10.l;
import java.net.IDN;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import net.sf.scuba.smartcards.ISO7816;
import okhttp3.internal.Util;

public final class PublicSuffixDatabase {
    public static final Companion Companion = new Companion((r) null);
    private static final char EXCEPTION_MARKER = '!';
    private static final List<String> PREVAILING_RULE = CollectionsKt__CollectionsJVMKt.e("*");
    public static final String PUBLIC_SUFFIX_RESOURCE = "publicsuffixes.gz";
    private static final byte[] WILDCARD_LABEL = {ISO7816.INS_PSO};
    /* access modifiers changed from: private */
    public static final PublicSuffixDatabase instance = new PublicSuffixDatabase();
    private final AtomicBoolean listRead = new AtomicBoolean(false);
    private byte[] publicSuffixExceptionListBytes;
    private byte[] publicSuffixListBytes;
    private final CountDownLatch readCompleteLatch = new CountDownLatch(1);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        /* access modifiers changed from: private */
        public final String binarySearch(byte[] bArr, byte[][] bArr2, int i11) {
            int i12;
            boolean z11;
            int i13;
            int and;
            byte[] bArr3 = bArr;
            byte[][] bArr4 = bArr2;
            int length = bArr3.length;
            int i14 = 0;
            while (i14 < length) {
                int i15 = (i14 + length) / 2;
                while (i15 > -1 && bArr3[i15] != 10) {
                    i15--;
                }
                int i16 = i15 + 1;
                int i17 = 1;
                while (true) {
                    i12 = i16 + i17;
                    if (bArr3[i12] == 10) {
                        break;
                    }
                    i17++;
                }
                int i18 = i12 - i16;
                int i19 = i11;
                boolean z12 = false;
                int i21 = 0;
                int i22 = 0;
                while (true) {
                    if (z12) {
                        i13 = 46;
                        z11 = false;
                    } else {
                        z11 = z12;
                        i13 = Util.and(bArr4[i19][i21], 255);
                    }
                    and = i13 - Util.and(bArr3[i16 + i22], 255);
                    if (and != 0) {
                        break;
                    }
                    i22++;
                    i21++;
                    if (i22 == i18) {
                        break;
                    } else if (bArr4[i19].length != i21) {
                        z12 = z11;
                    } else if (i19 == bArr4.length - 1) {
                        break;
                    } else {
                        i19++;
                        i21 = -1;
                        z12 = true;
                    }
                }
                if (and >= 0) {
                    if (and <= 0) {
                        int i23 = i18 - i22;
                        int length2 = bArr4[i19].length - i21;
                        int length3 = bArr4.length;
                        for (int i24 = i19 + 1; i24 < length3; i24++) {
                            length2 += bArr4[i24].length;
                        }
                        if (length2 >= i23) {
                            if (length2 <= i23) {
                                return new String(bArr3, i16, i18, StandardCharsets.UTF_8);
                            }
                        }
                    }
                    i14 = i12 + 1;
                }
                length = i16 - 1;
            }
            return null;
        }

        public final PublicSuffixDatabase get() {
            return PublicSuffixDatabase.instance;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00ba  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<java.lang.String> findMatchingRule(java.util.List<java.lang.String> r15) {
        /*
            r14 = this;
            java.util.concurrent.atomic.AtomicBoolean r0 = r14.listRead
            boolean r0 = r0.get()
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0016
            java.util.concurrent.atomic.AtomicBoolean r0 = r14.listRead
            boolean r0 = r0.compareAndSet(r1, r2)
            if (r0 == 0) goto L_0x0016
            r14.readTheListUninterruptibly()
            goto L_0x0023
        L_0x0016:
            java.util.concurrent.CountDownLatch r0 = r14.readCompleteLatch     // Catch:{ InterruptedException -> 0x001c }
            r0.await()     // Catch:{ InterruptedException -> 0x001c }
            goto L_0x0023
        L_0x001c:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x0023:
            byte[] r0 = r14.publicSuffixListBytes
            if (r0 == 0) goto L_0x0029
            r0 = r2
            goto L_0x002a
        L_0x0029:
            r0 = r1
        L_0x002a:
            if (r0 == 0) goto L_0x00f9
            int r0 = r15.size()
            byte[][] r3 = new byte[r0][]
            r4 = r1
        L_0x0033:
            if (r4 >= r0) goto L_0x0046
            java.lang.Object r5 = r15.get(r4)
            java.lang.String r5 = (java.lang.String) r5
            java.nio.charset.Charset r6 = java.nio.charset.StandardCharsets.UTF_8
            byte[] r5 = r5.getBytes(r6)
            r3[r4] = r5
            int r4 = r4 + 1
            goto L_0x0033
        L_0x0046:
            r15 = r1
        L_0x0047:
            r4 = 0
            if (r15 >= r0) goto L_0x005b
            okhttp3.internal.publicsuffix.PublicSuffixDatabase$Companion r5 = Companion
            byte[] r6 = r14.publicSuffixListBytes
            if (r6 != 0) goto L_0x0051
            r6 = r4
        L_0x0051:
            java.lang.String r5 = r5.binarySearch(r6, r3, r15)
            if (r5 == 0) goto L_0x0058
            goto L_0x005c
        L_0x0058:
            int r15 = r15 + 1
            goto L_0x0047
        L_0x005b:
            r5 = r4
        L_0x005c:
            if (r0 <= r2) goto L_0x007f
            java.lang.Object r15 = r3.clone()
            byte[][] r15 = (byte[][]) r15
            int r6 = r15.length
            int r6 = r6 - r2
            r7 = r1
        L_0x0067:
            if (r7 >= r6) goto L_0x007f
            byte[] r8 = WILDCARD_LABEL
            r15[r7] = r8
            okhttp3.internal.publicsuffix.PublicSuffixDatabase$Companion r8 = Companion
            byte[] r9 = r14.publicSuffixListBytes
            if (r9 != 0) goto L_0x0074
            r9 = r4
        L_0x0074:
            java.lang.String r8 = r8.binarySearch(r9, r15, r7)
            if (r8 == 0) goto L_0x007c
            r15 = r8
            goto L_0x0080
        L_0x007c:
            int r7 = r7 + 1
            goto L_0x0067
        L_0x007f:
            r15 = r4
        L_0x0080:
            if (r15 == 0) goto L_0x0098
            int r0 = r0 - r2
            r6 = r1
        L_0x0084:
            if (r6 >= r0) goto L_0x0098
            okhttp3.internal.publicsuffix.PublicSuffixDatabase$Companion r7 = Companion
            byte[] r8 = r14.publicSuffixExceptionListBytes
            if (r8 != 0) goto L_0x008d
            r8 = r4
        L_0x008d:
            java.lang.String r7 = r7.binarySearch(r8, r3, r6)
            if (r7 == 0) goto L_0x0095
            r4 = r7
            goto L_0x0098
        L_0x0095:
            int r6 = r6 + 1
            goto L_0x0084
        L_0x0098:
            r0 = 46
            if (r4 == 0) goto L_0x00ba
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            r3 = 33
            r15.append(r3)
            r15.append(r4)
            java.lang.String r5 = r15.toString()
            char[] r6 = new char[r2]
            r6[r1] = r0
            r7 = 0
            r8 = 0
            r9 = 6
            r10 = 0
            java.util.List r15 = kotlin.text.StringsKt__StringsKt.K0(r5, r6, r7, r8, r9, r10)
            return r15
        L_0x00ba:
            if (r5 != 0) goto L_0x00c1
            if (r15 != 0) goto L_0x00c1
            java.util.List<java.lang.String> r15 = PREVAILING_RULE
            return r15
        L_0x00c1:
            if (r5 == 0) goto L_0x00d3
            char[] r3 = new char[r2]
            r3[r1] = r0
            r6 = 0
            r7 = 0
            r8 = 6
            r9 = 0
            r4 = r5
            r5 = r3
            java.util.List r3 = kotlin.text.StringsKt__StringsKt.K0(r4, r5, r6, r7, r8, r9)
            if (r3 != 0) goto L_0x00d7
        L_0x00d3:
            java.util.List r3 = kotlin.collections.CollectionsKt__CollectionsKt.k()
        L_0x00d7:
            if (r15 == 0) goto L_0x00e8
            char[] r9 = new char[r2]
            r9[r1] = r0
            r10 = 0
            r11 = 0
            r12 = 6
            r13 = 0
            r8 = r15
            java.util.List r15 = kotlin.text.StringsKt__StringsKt.K0(r8, r9, r10, r11, r12, r13)
            if (r15 != 0) goto L_0x00ec
        L_0x00e8:
            java.util.List r15 = kotlin.collections.CollectionsKt__CollectionsKt.k()
        L_0x00ec:
            int r0 = r3.size()
            int r1 = r15.size()
            if (r0 <= r1) goto L_0x00f7
            goto L_0x00f8
        L_0x00f7:
            r3 = r15
        L_0x00f8:
            return r3
        L_0x00f9:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "Unable to load publicsuffixes.gz resource from the classpath."
            java.lang.String r0 = r0.toString()
            r15.<init>(r0)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.publicsuffix.PublicSuffixDatabase.findMatchingRule(java.util.List):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005c, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        kotlin.io.b.a(r2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0060, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void readTheList() throws java.io.IOException {
        /*
            r6 = this;
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch:{ all -> 0x0061 }
            r0.<init>()     // Catch:{ all -> 0x0061 }
            kotlin.jvm.internal.Ref$ObjectRef r1 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch:{ all -> 0x0061 }
            r1.<init>()     // Catch:{ all -> 0x0061 }
            java.lang.Class<okhttp3.internal.publicsuffix.PublicSuffixDatabase> r2 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.class
            java.lang.String r3 = "publicsuffixes.gz"
            java.io.InputStream r2 = r2.getResourceAsStream(r3)     // Catch:{ all -> 0x0061 }
            if (r2 != 0) goto L_0x001a
            java.util.concurrent.CountDownLatch r0 = r6.readCompleteLatch
            r0.countDown()
            return
        L_0x001a:
            okio.GzipSource r3 = new okio.GzipSource     // Catch:{ all -> 0x0061 }
            okio.Source r2 = okio.Okio.source((java.io.InputStream) r2)     // Catch:{ all -> 0x0061 }
            r3.<init>(r2)     // Catch:{ all -> 0x0061 }
            okio.BufferedSource r2 = okio.Okio.buffer((okio.Source) r3)     // Catch:{ all -> 0x0061 }
            r3 = 0
            int r4 = r2.readInt()     // Catch:{ all -> 0x005a }
            long r4 = (long) r4     // Catch:{ all -> 0x005a }
            byte[] r4 = r2.readByteArray(r4)     // Catch:{ all -> 0x005a }
            r0.element = r4     // Catch:{ all -> 0x005a }
            int r4 = r2.readInt()     // Catch:{ all -> 0x005a }
            long r4 = (long) r4     // Catch:{ all -> 0x005a }
            byte[] r4 = r2.readByteArray(r4)     // Catch:{ all -> 0x005a }
            r1.element = r4     // Catch:{ all -> 0x005a }
            kotlin.Unit r4 = kotlin.Unit.f56620a     // Catch:{ all -> 0x005a }
            kotlin.io.b.a(r2, r3)     // Catch:{ all -> 0x0061 }
            monitor-enter(r6)     // Catch:{ all -> 0x0061 }
            T r0 = r0.element     // Catch:{ all -> 0x0057 }
            byte[] r0 = (byte[]) r0     // Catch:{ all -> 0x0057 }
            r6.publicSuffixListBytes = r0     // Catch:{ all -> 0x0057 }
            T r0 = r1.element     // Catch:{ all -> 0x0057 }
            byte[] r0 = (byte[]) r0     // Catch:{ all -> 0x0057 }
            r6.publicSuffixExceptionListBytes = r0     // Catch:{ all -> 0x0057 }
            monitor-exit(r6)     // Catch:{ all -> 0x0061 }
            java.util.concurrent.CountDownLatch r0 = r6.readCompleteLatch
            r0.countDown()
            return
        L_0x0057:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0061 }
            throw r0     // Catch:{ all -> 0x0061 }
        L_0x005a:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x005c }
        L_0x005c:
            r1 = move-exception
            kotlin.io.b.a(r2, r0)     // Catch:{ all -> 0x0061 }
            throw r1     // Catch:{ all -> 0x0061 }
        L_0x0061:
            r0 = move-exception
            java.util.concurrent.CountDownLatch r1 = r6.readCompleteLatch
            r1.countDown()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.publicsuffix.PublicSuffixDatabase.readTheList():void");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0027 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void readTheListUninterruptibly() {
        /*
            r5 = this;
            r0 = 0
        L_0x0001:
            r5.readTheList()     // Catch:{ InterruptedIOException -> 0x0027, IOException -> 0x0010 }
            if (r0 == 0) goto L_0x000d
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x000d:
            return
        L_0x000e:
            r1 = move-exception
            goto L_0x002c
        L_0x0010:
            r1 = move-exception
            okhttp3.internal.platform.Platform$Companion r2 = okhttp3.internal.platform.Platform.Companion     // Catch:{ all -> 0x000e }
            okhttp3.internal.platform.Platform r2 = r2.get()     // Catch:{ all -> 0x000e }
            java.lang.String r3 = "Failed to read public suffix list"
            r4 = 5
            r2.log(r3, r4, r1)     // Catch:{ all -> 0x000e }
            if (r0 == 0) goto L_0x0026
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x0026:
            return
        L_0x0027:
            java.lang.Thread.interrupted()     // Catch:{ all -> 0x000e }
            r0 = 1
            goto L_0x0001
        L_0x002c:
            if (r0 == 0) goto L_0x0035
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x0035:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.publicsuffix.PublicSuffixDatabase.readTheListUninterruptibly():void");
    }

    private final List<String> splitDomain(String str) {
        List<String> K0 = StringsKt__StringsKt.K0(str, new char[]{'.'}, false, 0, 6, (Object) null);
        return x.b(CollectionsKt___CollectionsKt.m0(K0), "") ? CollectionsKt___CollectionsKt.U(K0, 1) : K0;
    }

    public final String getEffectiveTldPlusOne(String str) {
        int i11;
        int i12;
        List<String> splitDomain = splitDomain(IDN.toUnicode(str));
        List<String> findMatchingRule = findMatchingRule(splitDomain);
        if (splitDomain.size() == findMatchingRule.size() && findMatchingRule.get(0).charAt(0) != '!') {
            return null;
        }
        if (findMatchingRule.get(0).charAt(0) == '!') {
            i12 = splitDomain.size();
            i11 = findMatchingRule.size();
        } else {
            i12 = splitDomain.size();
            i11 = findMatchingRule.size() + 1;
        }
        return SequencesKt___SequencesKt.q(SequencesKt___SequencesKt.j(CollectionsKt___CollectionsKt.P(splitDomain(str)), i12 - i11), InstructionFileId.DOT, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (l) null, 62, (Object) null);
    }

    public final void setListBytes(byte[] bArr, byte[] bArr2) {
        this.publicSuffixListBytes = bArr;
        this.publicSuffixExceptionListBytes = bArr2;
        this.listRead.set(true);
        this.readCompleteLatch.countDown();
    }
}
