package okhttp3.internal.cache;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlin.text.Regex;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
import okio.BufferedSink;
import okio.Okio;
import okio.Sink;
import okio.Source;

public final class DiskLruCache implements Closeable, Flushable {
    public static final long ANY_SEQUENCE_NUMBER = -1;
    public static final String CLEAN = "CLEAN";
    public static final Companion Companion = new Companion((r) null);
    public static final String DIRTY = "DIRTY";
    public static final String JOURNAL_FILE = "journal";
    public static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    public static final String JOURNAL_FILE_TEMP = "journal.tmp";
    public static final Regex LEGAL_KEY_PATTERN = new Regex("[a-z0-9_-]{1,120}");
    public static final String MAGIC = "libcore.io.DiskLruCache";
    public static final String READ = "READ";
    public static final String REMOVE = "REMOVE";
    public static final String VERSION_1 = "1";
    private final int appVersion;
    /* access modifiers changed from: private */
    public boolean civilizedFileSystem;
    private final TaskQueue cleanupQueue;
    private final DiskLruCache$cleanupTask$1 cleanupTask;
    private boolean closed;
    private final File directory;
    private final FileSystem fileSystem;
    /* access modifiers changed from: private */
    public boolean hasJournalErrors;
    /* access modifiers changed from: private */
    public boolean initialized;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    /* access modifiers changed from: private */
    public BufferedSink journalWriter;
    private final LinkedHashMap<String, Entry> lruEntries = new LinkedHashMap<>(0, 0.75f, true);
    private long maxSize;
    /* access modifiers changed from: private */
    public boolean mostRecentRebuildFailed;
    /* access modifiers changed from: private */
    public boolean mostRecentTrimFailed;
    private long nextSequenceNumber;
    /* access modifiers changed from: private */
    public int redundantOpCount;
    private long size;
    private final int valueCount;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }
    }

    public final class Editor {
        private boolean done;
        private final Entry entry;
        private final boolean[] written;

        public Editor(Entry entry2) {
            this.entry = entry2;
            this.written = entry2.getReadable$okhttp() ? null : new boolean[DiskLruCache.this.getValueCount$okhttp()];
        }

        public final void abort() throws IOException {
            DiskLruCache diskLruCache = DiskLruCache.this;
            synchronized (diskLruCache) {
                if (!this.done) {
                    if (x.b(this.entry.getCurrentEditor$okhttp(), this)) {
                        diskLruCache.completeEdit$okhttp(this, false);
                    }
                    this.done = true;
                    Unit unit = Unit.f56620a;
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
        }

        public final void commit() throws IOException {
            DiskLruCache diskLruCache = DiskLruCache.this;
            synchronized (diskLruCache) {
                if (!this.done) {
                    if (x.b(this.entry.getCurrentEditor$okhttp(), this)) {
                        diskLruCache.completeEdit$okhttp(this, true);
                    }
                    this.done = true;
                    Unit unit = Unit.f56620a;
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
        }

        public final void detach$okhttp() {
            if (!x.b(this.entry.getCurrentEditor$okhttp(), this)) {
                return;
            }
            if (DiskLruCache.this.civilizedFileSystem) {
                DiskLruCache.this.completeEdit$okhttp(this, false);
            } else {
                this.entry.setZombie$okhttp(true);
            }
        }

        public final Entry getEntry$okhttp() {
            return this.entry;
        }

        public final boolean[] getWritten$okhttp() {
            return this.written;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(4:21|22|23|24) */
        /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
            r4 = okio.Okio.blackhole();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x004c, code lost:
            return r4;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0047 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final okio.Sink newSink(int r4) {
            /*
                r3 = this;
                okhttp3.internal.cache.DiskLruCache r0 = okhttp3.internal.cache.DiskLruCache.this
                monitor-enter(r0)
                boolean r1 = r3.done     // Catch:{ all -> 0x0059 }
                r2 = 1
                r1 = r1 ^ r2
                if (r1 == 0) goto L_0x004d
                okhttp3.internal.cache.DiskLruCache$Entry r1 = r3.entry     // Catch:{ all -> 0x0059 }
                okhttp3.internal.cache.DiskLruCache$Editor r1 = r1.getCurrentEditor$okhttp()     // Catch:{ all -> 0x0059 }
                boolean r1 = kotlin.jvm.internal.x.b(r1, r3)     // Catch:{ all -> 0x0059 }
                if (r1 != 0) goto L_0x001b
                okio.Sink r4 = okio.Okio.blackhole()     // Catch:{ all -> 0x0059 }
                monitor-exit(r0)
                return r4
            L_0x001b:
                okhttp3.internal.cache.DiskLruCache$Entry r1 = r3.entry     // Catch:{ all -> 0x0059 }
                boolean r1 = r1.getReadable$okhttp()     // Catch:{ all -> 0x0059 }
                if (r1 != 0) goto L_0x0027
                boolean[] r1 = r3.written     // Catch:{ all -> 0x0059 }
                r1[r4] = r2     // Catch:{ all -> 0x0059 }
            L_0x0027:
                okhttp3.internal.cache.DiskLruCache$Entry r1 = r3.entry     // Catch:{ all -> 0x0059 }
                java.util.List r1 = r1.getDirtyFiles$okhttp()     // Catch:{ all -> 0x0059 }
                java.lang.Object r4 = r1.get(r4)     // Catch:{ all -> 0x0059 }
                java.io.File r4 = (java.io.File) r4     // Catch:{ all -> 0x0059 }
                okhttp3.internal.io.FileSystem r1 = r0.getFileSystem$okhttp()     // Catch:{ FileNotFoundException -> 0x0047 }
                okio.Sink r4 = r1.sink(r4)     // Catch:{ FileNotFoundException -> 0x0047 }
                okhttp3.internal.cache.FaultHidingSink r1 = new okhttp3.internal.cache.FaultHidingSink     // Catch:{ all -> 0x0059 }
                okhttp3.internal.cache.DiskLruCache$Editor$newSink$1$1 r2 = new okhttp3.internal.cache.DiskLruCache$Editor$newSink$1$1     // Catch:{ all -> 0x0059 }
                r2.<init>(r0, r3)     // Catch:{ all -> 0x0059 }
                r1.<init>(r4, r2)     // Catch:{ all -> 0x0059 }
                monitor-exit(r0)
                return r1
            L_0x0047:
                okio.Sink r4 = okio.Okio.blackhole()     // Catch:{ all -> 0x0059 }
                monitor-exit(r0)
                return r4
            L_0x004d:
                java.lang.String r4 = "Check failed."
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0059 }
                java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0059 }
                r1.<init>(r4)     // Catch:{ all -> 0x0059 }
                throw r1     // Catch:{ all -> 0x0059 }
            L_0x0059:
                r4 = move-exception
                monitor-exit(r0)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.Editor.newSink(int):okio.Sink");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x003e, code lost:
            return null;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final okio.Source newSource(int r5) {
            /*
                r4 = this;
                okhttp3.internal.cache.DiskLruCache r0 = okhttp3.internal.cache.DiskLruCache.this
                monitor-enter(r0)
                boolean r1 = r4.done     // Catch:{ all -> 0x004b }
                r1 = r1 ^ 1
                if (r1 == 0) goto L_0x003f
                okhttp3.internal.cache.DiskLruCache$Entry r1 = r4.entry     // Catch:{ all -> 0x004b }
                boolean r1 = r1.getReadable$okhttp()     // Catch:{ all -> 0x004b }
                r2 = 0
                if (r1 == 0) goto L_0x003d
                okhttp3.internal.cache.DiskLruCache$Entry r1 = r4.entry     // Catch:{ all -> 0x004b }
                okhttp3.internal.cache.DiskLruCache$Editor r1 = r1.getCurrentEditor$okhttp()     // Catch:{ all -> 0x004b }
                boolean r1 = kotlin.jvm.internal.x.b(r1, r4)     // Catch:{ all -> 0x004b }
                if (r1 == 0) goto L_0x003d
                okhttp3.internal.cache.DiskLruCache$Entry r1 = r4.entry     // Catch:{ all -> 0x004b }
                boolean r1 = r1.getZombie$okhttp()     // Catch:{ all -> 0x004b }
                if (r1 == 0) goto L_0x0027
                goto L_0x003d
            L_0x0027:
                okhttp3.internal.io.FileSystem r1 = r0.getFileSystem$okhttp()     // Catch:{ FileNotFoundException -> 0x003b }
                okhttp3.internal.cache.DiskLruCache$Entry r3 = r4.entry     // Catch:{ FileNotFoundException -> 0x003b }
                java.util.List r3 = r3.getCleanFiles$okhttp()     // Catch:{ FileNotFoundException -> 0x003b }
                java.lang.Object r5 = r3.get(r5)     // Catch:{ FileNotFoundException -> 0x003b }
                java.io.File r5 = (java.io.File) r5     // Catch:{ FileNotFoundException -> 0x003b }
                okio.Source r2 = r1.source(r5)     // Catch:{ FileNotFoundException -> 0x003b }
            L_0x003b:
                monitor-exit(r0)
                return r2
            L_0x003d:
                monitor-exit(r0)
                return r2
            L_0x003f:
                java.lang.String r5 = "Check failed."
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x004b }
                java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x004b }
                r1.<init>(r5)     // Catch:{ all -> 0x004b }
                throw r1     // Catch:{ all -> 0x004b }
            L_0x004b:
                r5 = move-exception
                monitor-exit(r0)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.Editor.newSource(int):okio.Source");
        }
    }

    public final class Entry {
        private final List<File> cleanFiles = new ArrayList();
        private Editor currentEditor;
        private final List<File> dirtyFiles = new ArrayList();
        private final String key;
        private final long[] lengths;
        private int lockingSourceCount;
        private boolean readable;
        private long sequenceNumber;
        private boolean zombie;

        public Entry(String str) {
            this.key = str;
            this.lengths = new long[DiskLruCache.this.getValueCount$okhttp()];
            StringBuilder sb2 = new StringBuilder(str);
            sb2.append('.');
            int length = sb2.length();
            int valueCount$okhttp = DiskLruCache.this.getValueCount$okhttp();
            for (int i11 = 0; i11 < valueCount$okhttp; i11++) {
                sb2.append(i11);
                this.cleanFiles.add(new File(DiskLruCache.this.getDirectory(), sb2.toString()));
                sb2.append(".tmp");
                this.dirtyFiles.add(new File(DiskLruCache.this.getDirectory(), sb2.toString()));
                sb2.setLength(length);
            }
        }

        private final Void invalidLengths(List<String> list) throws IOException {
            throw new IOException("unexpected journal line: " + list);
        }

        private final Source newSource(int i11) {
            Source source = DiskLruCache.this.getFileSystem$okhttp().source(this.cleanFiles.get(i11));
            if (DiskLruCache.this.civilizedFileSystem) {
                return source;
            }
            this.lockingSourceCount++;
            return new DiskLruCache$Entry$newSource$1(source, DiskLruCache.this, this);
        }

        public final List<File> getCleanFiles$okhttp() {
            return this.cleanFiles;
        }

        public final Editor getCurrentEditor$okhttp() {
            return this.currentEditor;
        }

        public final List<File> getDirtyFiles$okhttp() {
            return this.dirtyFiles;
        }

        public final String getKey$okhttp() {
            return this.key;
        }

        public final long[] getLengths$okhttp() {
            return this.lengths;
        }

        public final int getLockingSourceCount$okhttp() {
            return this.lockingSourceCount;
        }

        public final boolean getReadable$okhttp() {
            return this.readable;
        }

        public final long getSequenceNumber$okhttp() {
            return this.sequenceNumber;
        }

        public final boolean getZombie$okhttp() {
            return this.zombie;
        }

        public final void setCurrentEditor$okhttp(Editor editor) {
            this.currentEditor = editor;
        }

        public final void setLengths$okhttp(List<String> list) throws IOException {
            if (list.size() == DiskLruCache.this.getValueCount$okhttp()) {
                try {
                    int size = list.size();
                    for (int i11 = 0; i11 < size; i11++) {
                        this.lengths[i11] = Long.parseLong(list.get(i11));
                    }
                } catch (NumberFormatException unused) {
                    invalidLengths(list);
                    throw new KotlinNothingValueException();
                }
            } else {
                invalidLengths(list);
                throw new KotlinNothingValueException();
            }
        }

        public final void setLockingSourceCount$okhttp(int i11) {
            this.lockingSourceCount = i11;
        }

        public final void setReadable$okhttp(boolean z11) {
            this.readable = z11;
        }

        public final void setSequenceNumber$okhttp(long j11) {
            this.sequenceNumber = j11;
        }

        public final void setZombie$okhttp(boolean z11) {
            this.zombie = z11;
        }

        public final Snapshot snapshot$okhttp() {
            DiskLruCache diskLruCache = DiskLruCache.this;
            if (Util.assertionsEnabled && !Thread.holdsLock(diskLruCache)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + diskLruCache);
            } else if (!this.readable) {
                return null;
            } else {
                if (!DiskLruCache.this.civilizedFileSystem && (this.currentEditor != null || this.zombie)) {
                    return null;
                }
                ArrayList<Source> arrayList = new ArrayList<>();
                long[] jArr = (long[]) this.lengths.clone();
                try {
                    int valueCount$okhttp = DiskLruCache.this.getValueCount$okhttp();
                    for (int i11 = 0; i11 < valueCount$okhttp; i11++) {
                        arrayList.add(newSource(i11));
                    }
                    return new Snapshot(this.key, this.sequenceNumber, arrayList, jArr);
                } catch (FileNotFoundException unused) {
                    for (Source closeQuietly : arrayList) {
                        Util.closeQuietly((Closeable) closeQuietly);
                    }
                    try {
                        DiskLruCache.this.removeEntry$okhttp(this);
                    } catch (IOException unused2) {
                    }
                    return null;
                }
            }
        }

        public final void writeLengths$okhttp(BufferedSink bufferedSink) throws IOException {
            for (long writeDecimalLong : this.lengths) {
                bufferedSink.writeByte(32).writeDecimalLong(writeDecimalLong);
            }
        }
    }

    public final class Snapshot implements Closeable {
        private final String key;
        private final long[] lengths;
        private final long sequenceNumber;
        private final List<Source> sources;

        public Snapshot(String str, long j11, List<? extends Source> list, long[] jArr) {
            this.key = str;
            this.sequenceNumber = j11;
            this.sources = list;
            this.lengths = jArr;
        }

        public void close() {
            for (Source closeQuietly : this.sources) {
                Util.closeQuietly((Closeable) closeQuietly);
            }
        }

        public final Editor edit() throws IOException {
            return DiskLruCache.this.edit(this.key, this.sequenceNumber);
        }

        public final long getLength(int i11) {
            return this.lengths[i11];
        }

        public final Source getSource(int i11) {
            return this.sources.get(i11);
        }

        public final String key() {
            return this.key;
        }
    }

    public DiskLruCache(FileSystem fileSystem2, File file, int i11, int i12, long j11, TaskRunner taskRunner) {
        this.fileSystem = fileSystem2;
        this.directory = file;
        this.appVersion = i11;
        this.valueCount = i12;
        this.maxSize = j11;
        boolean z11 = false;
        this.cleanupQueue = taskRunner.newQueue();
        this.cleanupTask = new DiskLruCache$cleanupTask$1(this, Util.okHttpName + " Cache");
        if (j11 > 0) {
            if (i12 > 0 ? true : z11) {
                this.journalFile = new File(file, JOURNAL_FILE);
                this.journalFileTmp = new File(file, JOURNAL_FILE_TEMP);
                this.journalFileBackup = new File(file, JOURNAL_FILE_BACKUP);
                return;
            }
            throw new IllegalArgumentException("valueCount <= 0".toString());
        }
        throw new IllegalArgumentException("maxSize <= 0".toString());
    }

    private final synchronized void checkNotClosed() {
        if (!(!this.closed)) {
            throw new IllegalStateException("cache is closed".toString());
        }
    }

    public static /* synthetic */ Editor edit$default(DiskLruCache diskLruCache, String str, long j11, int i11, Object obj) throws IOException {
        if ((i11 & 2) != 0) {
            j11 = ANY_SEQUENCE_NUMBER;
        }
        return diskLruCache.edit(str, j11);
    }

    /* access modifiers changed from: private */
    public final boolean journalRebuildRequired() {
        int i11 = this.redundantOpCount;
        return i11 >= 2000 && i11 >= this.lruEntries.size();
    }

    private final BufferedSink newJournalWriter() throws FileNotFoundException {
        return Okio.buffer((Sink) new FaultHidingSink(this.fileSystem.appendingSink(this.journalFile), new DiskLruCache$newJournalWriter$faultHidingSink$1(this)));
    }

    private final void processJournal() throws IOException {
        this.fileSystem.delete(this.journalFileTmp);
        Iterator<Entry> it2 = this.lruEntries.values().iterator();
        while (it2.hasNext()) {
            Entry next = it2.next();
            int i11 = 0;
            if (next.getCurrentEditor$okhttp() == null) {
                int i12 = this.valueCount;
                while (i11 < i12) {
                    this.size += next.getLengths$okhttp()[i11];
                    i11++;
                }
            } else {
                next.setCurrentEditor$okhttp((Editor) null);
                int i13 = this.valueCount;
                while (i11 < i13) {
                    this.fileSystem.delete(next.getCleanFiles$okhttp().get(i11));
                    this.fileSystem.delete(next.getDirtyFiles$okhttp().get(i11));
                    i11++;
                }
                it2.remove();
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:19|20|(1:22)(1:23)|24|25|26) */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r9.redundantOpCount = r7 - r9.lruEntries.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006d, code lost:
        if (r1.exhausted() == false) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006f, code lost:
        rebuildJournal$okhttp();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0073, code lost:
        r9.journalWriter = newJournalWriter();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0079, code lost:
        r0 = kotlin.Unit.f56620a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007b, code lost:
        kotlin.io.b.a(r1, (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007f, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b0, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00b1, code lost:
        kotlin.io.b.a(r1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b4, code lost:
        throw r2;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0060 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:19:0x0060=Splitter:B:19:0x0060, B:27:0x0080=Splitter:B:27:0x0080} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void readJournal() throws java.io.IOException {
        /*
            r9 = this;
            java.lang.String r0 = ", "
            okhttp3.internal.io.FileSystem r1 = r9.fileSystem
            java.io.File r2 = r9.journalFile
            okio.Source r1 = r1.source(r2)
            okio.BufferedSource r1 = okio.Okio.buffer((okio.Source) r1)
            java.lang.String r2 = r1.readUtf8LineStrict()     // Catch:{ all -> 0x00ae }
            java.lang.String r3 = r1.readUtf8LineStrict()     // Catch:{ all -> 0x00ae }
            java.lang.String r4 = r1.readUtf8LineStrict()     // Catch:{ all -> 0x00ae }
            java.lang.String r5 = r1.readUtf8LineStrict()     // Catch:{ all -> 0x00ae }
            java.lang.String r6 = r1.readUtf8LineStrict()     // Catch:{ all -> 0x00ae }
            java.lang.String r7 = MAGIC     // Catch:{ all -> 0x00ae }
            boolean r7 = kotlin.jvm.internal.x.b(r7, r2)     // Catch:{ all -> 0x00ae }
            if (r7 == 0) goto L_0x0080
            java.lang.String r7 = VERSION_1     // Catch:{ all -> 0x00ae }
            boolean r7 = kotlin.jvm.internal.x.b(r7, r3)     // Catch:{ all -> 0x00ae }
            if (r7 == 0) goto L_0x0080
            int r7 = r9.appVersion     // Catch:{ all -> 0x00ae }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x00ae }
            boolean r4 = kotlin.jvm.internal.x.b(r7, r4)     // Catch:{ all -> 0x00ae }
            if (r4 == 0) goto L_0x0080
            int r4 = r9.valueCount     // Catch:{ all -> 0x00ae }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x00ae }
            boolean r4 = kotlin.jvm.internal.x.b(r4, r5)     // Catch:{ all -> 0x00ae }
            if (r4 == 0) goto L_0x0080
            int r4 = r6.length()     // Catch:{ all -> 0x00ae }
            r7 = 0
            if (r4 <= 0) goto L_0x0053
            r4 = 1
            goto L_0x0054
        L_0x0053:
            r4 = r7
        L_0x0054:
            if (r4 != 0) goto L_0x0080
        L_0x0056:
            java.lang.String r0 = r1.readUtf8LineStrict()     // Catch:{ EOFException -> 0x0060 }
            r9.readJournalLine(r0)     // Catch:{ EOFException -> 0x0060 }
            int r7 = r7 + 1
            goto L_0x0056
        L_0x0060:
            java.util.LinkedHashMap<java.lang.String, okhttp3.internal.cache.DiskLruCache$Entry> r0 = r9.lruEntries     // Catch:{ all -> 0x00ae }
            int r0 = r0.size()     // Catch:{ all -> 0x00ae }
            int r7 = r7 - r0
            r9.redundantOpCount = r7     // Catch:{ all -> 0x00ae }
            boolean r0 = r1.exhausted()     // Catch:{ all -> 0x00ae }
            if (r0 != 0) goto L_0x0073
            r9.rebuildJournal$okhttp()     // Catch:{ all -> 0x00ae }
            goto L_0x0079
        L_0x0073:
            okio.BufferedSink r0 = r9.newJournalWriter()     // Catch:{ all -> 0x00ae }
            r9.journalWriter = r0     // Catch:{ all -> 0x00ae }
        L_0x0079:
            kotlin.Unit r0 = kotlin.Unit.f56620a     // Catch:{ all -> 0x00ae }
            r0 = 0
            kotlin.io.b.a(r1, r0)
            return
        L_0x0080:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x00ae }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ae }
            r7.<init>()     // Catch:{ all -> 0x00ae }
            java.lang.String r8 = "unexpected journal header: ["
            r7.append(r8)     // Catch:{ all -> 0x00ae }
            r7.append(r2)     // Catch:{ all -> 0x00ae }
            r7.append(r0)     // Catch:{ all -> 0x00ae }
            r7.append(r3)     // Catch:{ all -> 0x00ae }
            r7.append(r0)     // Catch:{ all -> 0x00ae }
            r7.append(r5)     // Catch:{ all -> 0x00ae }
            r7.append(r0)     // Catch:{ all -> 0x00ae }
            r7.append(r6)     // Catch:{ all -> 0x00ae }
            r0 = 93
            r7.append(r0)     // Catch:{ all -> 0x00ae }
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x00ae }
            r4.<init>(r0)     // Catch:{ all -> 0x00ae }
            throw r4     // Catch:{ all -> 0x00ae }
        L_0x00ae:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x00b0 }
        L_0x00b0:
            r2 = move-exception
            kotlin.io.b.a(r1, r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.readJournal():void");
    }

    private final void readJournalLine(String str) throws IOException {
        String str2;
        int f02 = StringsKt__StringsKt.f0(str, ' ', 0, false, 6, (Object) null);
        if (f02 != -1) {
            int i11 = f02 + 1;
            int f03 = StringsKt__StringsKt.f0(str, ' ', i11, false, 4, (Object) null);
            if (f03 == -1) {
                str2 = str.substring(i11);
                String str3 = REMOVE;
                if (f02 == str3.length() && StringsKt__StringsJVMKt.M(str, str3, false, 2, (Object) null)) {
                    this.lruEntries.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i11, f03);
            }
            Entry entry = this.lruEntries.get(str2);
            if (entry == null) {
                entry = new Entry(str2);
                this.lruEntries.put(str2, entry);
            }
            if (f03 != -1) {
                String str4 = CLEAN;
                if (f02 == str4.length() && StringsKt__StringsJVMKt.M(str, str4, false, 2, (Object) null)) {
                    List K0 = StringsKt__StringsKt.K0(str.substring(f03 + 1), new char[]{' '}, false, 0, 6, (Object) null);
                    entry.setReadable$okhttp(true);
                    entry.setCurrentEditor$okhttp((Editor) null);
                    entry.setLengths$okhttp(K0);
                    return;
                }
            }
            if (f03 == -1) {
                String str5 = DIRTY;
                if (f02 == str5.length() && StringsKt__StringsJVMKt.M(str, str5, false, 2, (Object) null)) {
                    entry.setCurrentEditor$okhttp(new Editor(entry));
                    return;
                }
            }
            if (f03 == -1) {
                String str6 = READ;
                if (f02 == str6.length() && StringsKt__StringsJVMKt.M(str, str6, false, 2, (Object) null)) {
                    return;
                }
            }
            throw new IOException("unexpected journal line: " + str);
        }
        throw new IOException("unexpected journal line: " + str);
    }

    private final boolean removeOldestEntry() {
        for (Entry next : this.lruEntries.values()) {
            if (!next.getZombie$okhttp()) {
                removeEntry$okhttp(next);
                return true;
            }
        }
        return false;
    }

    private final void validateKey(String str) {
        if (!LEGAL_KEY_PATTERN.matches(str)) {
            throw new IllegalArgumentException(("keys must match regex [a-z0-9_-]{1,120}: \"" + str + '\"').toString());
        }
    }

    public synchronized void close() throws IOException {
        Editor currentEditor$okhttp;
        if (this.initialized) {
            if (!this.closed) {
                for (Entry entry : (Entry[]) this.lruEntries.values().toArray(new Entry[0])) {
                    if (!(entry.getCurrentEditor$okhttp() == null || (currentEditor$okhttp = entry.getCurrentEditor$okhttp()) == null)) {
                        currentEditor$okhttp.detach$okhttp();
                    }
                }
                trimToSize();
                this.journalWriter.close();
                this.journalWriter = null;
                this.closed = true;
                return;
            }
        }
        this.closed = true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:0x012a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void completeEdit$okhttp(okhttp3.internal.cache.DiskLruCache.Editor r9, boolean r10) throws java.io.IOException {
        /*
            r8 = this;
            monitor-enter(r8)
            okhttp3.internal.cache.DiskLruCache$Entry r0 = r9.getEntry$okhttp()     // Catch:{ all -> 0x0137 }
            okhttp3.internal.cache.DiskLruCache$Editor r1 = r0.getCurrentEditor$okhttp()     // Catch:{ all -> 0x0137 }
            boolean r1 = kotlin.jvm.internal.x.b(r1, r9)     // Catch:{ all -> 0x0137 }
            if (r1 == 0) goto L_0x012b
            r1 = 0
            if (r10 == 0) goto L_0x0059
            boolean r2 = r0.getReadable$okhttp()     // Catch:{ all -> 0x0137 }
            if (r2 != 0) goto L_0x0059
            int r2 = r8.valueCount     // Catch:{ all -> 0x0137 }
            r3 = r1
        L_0x001b:
            if (r3 >= r2) goto L_0x0059
            boolean[] r4 = r9.getWritten$okhttp()     // Catch:{ all -> 0x0137 }
            boolean r4 = r4[r3]     // Catch:{ all -> 0x0137 }
            if (r4 == 0) goto L_0x003f
            okhttp3.internal.io.FileSystem r4 = r8.fileSystem     // Catch:{ all -> 0x0137 }
            java.util.List r5 = r0.getDirtyFiles$okhttp()     // Catch:{ all -> 0x0137 }
            java.lang.Object r5 = r5.get(r3)     // Catch:{ all -> 0x0137 }
            java.io.File r5 = (java.io.File) r5     // Catch:{ all -> 0x0137 }
            boolean r4 = r4.exists(r5)     // Catch:{ all -> 0x0137 }
            if (r4 != 0) goto L_0x003c
            r9.abort()     // Catch:{ all -> 0x0137 }
            monitor-exit(r8)
            return
        L_0x003c:
            int r3 = r3 + 1
            goto L_0x001b
        L_0x003f:
            r9.abort()     // Catch:{ all -> 0x0137 }
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0137 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0137 }
            r10.<init>()     // Catch:{ all -> 0x0137 }
            java.lang.String r0 = "Newly created entry didn't create value for index "
            r10.append(r0)     // Catch:{ all -> 0x0137 }
            r10.append(r3)     // Catch:{ all -> 0x0137 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0137 }
            r9.<init>(r10)     // Catch:{ all -> 0x0137 }
            throw r9     // Catch:{ all -> 0x0137 }
        L_0x0059:
            int r9 = r8.valueCount     // Catch:{ all -> 0x0137 }
        L_0x005b:
            if (r1 >= r9) goto L_0x00a7
            java.util.List r2 = r0.getDirtyFiles$okhttp()     // Catch:{ all -> 0x0137 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x0137 }
            java.io.File r2 = (java.io.File) r2     // Catch:{ all -> 0x0137 }
            if (r10 == 0) goto L_0x009f
            boolean r3 = r0.getZombie$okhttp()     // Catch:{ all -> 0x0137 }
            if (r3 != 0) goto L_0x009f
            okhttp3.internal.io.FileSystem r3 = r8.fileSystem     // Catch:{ all -> 0x0137 }
            boolean r3 = r3.exists(r2)     // Catch:{ all -> 0x0137 }
            if (r3 == 0) goto L_0x00a4
            java.util.List r3 = r0.getCleanFiles$okhttp()     // Catch:{ all -> 0x0137 }
            java.lang.Object r3 = r3.get(r1)     // Catch:{ all -> 0x0137 }
            java.io.File r3 = (java.io.File) r3     // Catch:{ all -> 0x0137 }
            okhttp3.internal.io.FileSystem r4 = r8.fileSystem     // Catch:{ all -> 0x0137 }
            r4.rename(r2, r3)     // Catch:{ all -> 0x0137 }
            long[] r2 = r0.getLengths$okhttp()     // Catch:{ all -> 0x0137 }
            r4 = r2[r1]     // Catch:{ all -> 0x0137 }
            okhttp3.internal.io.FileSystem r2 = r8.fileSystem     // Catch:{ all -> 0x0137 }
            long r2 = r2.size(r3)     // Catch:{ all -> 0x0137 }
            long[] r6 = r0.getLengths$okhttp()     // Catch:{ all -> 0x0137 }
            r6[r1] = r2     // Catch:{ all -> 0x0137 }
            long r6 = r8.size     // Catch:{ all -> 0x0137 }
            long r6 = r6 - r4
            long r6 = r6 + r2
            r8.size = r6     // Catch:{ all -> 0x0137 }
            goto L_0x00a4
        L_0x009f:
            okhttp3.internal.io.FileSystem r3 = r8.fileSystem     // Catch:{ all -> 0x0137 }
            r3.delete(r2)     // Catch:{ all -> 0x0137 }
        L_0x00a4:
            int r1 = r1 + 1
            goto L_0x005b
        L_0x00a7:
            r9 = 0
            r0.setCurrentEditor$okhttp(r9)     // Catch:{ all -> 0x0137 }
            boolean r9 = r0.getZombie$okhttp()     // Catch:{ all -> 0x0137 }
            if (r9 == 0) goto L_0x00b6
            r8.removeEntry$okhttp(r0)     // Catch:{ all -> 0x0137 }
            monitor-exit(r8)
            return
        L_0x00b6:
            int r9 = r8.redundantOpCount     // Catch:{ all -> 0x0137 }
            r1 = 1
            int r9 = r9 + r1
            r8.redundantOpCount = r9     // Catch:{ all -> 0x0137 }
            okio.BufferedSink r9 = r8.journalWriter     // Catch:{ all -> 0x0137 }
            boolean r2 = r0.getReadable$okhttp()     // Catch:{ all -> 0x0137 }
            r3 = 10
            r4 = 32
            if (r2 != 0) goto L_0x00e8
            if (r10 == 0) goto L_0x00cb
            goto L_0x00e8
        L_0x00cb:
            java.util.LinkedHashMap<java.lang.String, okhttp3.internal.cache.DiskLruCache$Entry> r10 = r8.lruEntries     // Catch:{ all -> 0x0137 }
            java.lang.String r1 = r0.getKey$okhttp()     // Catch:{ all -> 0x0137 }
            r10.remove(r1)     // Catch:{ all -> 0x0137 }
            java.lang.String r10 = REMOVE     // Catch:{ all -> 0x0137 }
            okio.BufferedSink r10 = r9.writeUtf8(r10)     // Catch:{ all -> 0x0137 }
            r10.writeByte(r4)     // Catch:{ all -> 0x0137 }
            java.lang.String r10 = r0.getKey$okhttp()     // Catch:{ all -> 0x0137 }
            r9.writeUtf8(r10)     // Catch:{ all -> 0x0137 }
            r9.writeByte(r3)     // Catch:{ all -> 0x0137 }
            goto L_0x010d
        L_0x00e8:
            r0.setReadable$okhttp(r1)     // Catch:{ all -> 0x0137 }
            java.lang.String r1 = CLEAN     // Catch:{ all -> 0x0137 }
            okio.BufferedSink r1 = r9.writeUtf8(r1)     // Catch:{ all -> 0x0137 }
            r1.writeByte(r4)     // Catch:{ all -> 0x0137 }
            java.lang.String r1 = r0.getKey$okhttp()     // Catch:{ all -> 0x0137 }
            r9.writeUtf8(r1)     // Catch:{ all -> 0x0137 }
            r0.writeLengths$okhttp(r9)     // Catch:{ all -> 0x0137 }
            r9.writeByte(r3)     // Catch:{ all -> 0x0137 }
            if (r10 == 0) goto L_0x010d
            long r1 = r8.nextSequenceNumber     // Catch:{ all -> 0x0137 }
            r3 = 1
            long r3 = r3 + r1
            r8.nextSequenceNumber = r3     // Catch:{ all -> 0x0137 }
            r0.setSequenceNumber$okhttp(r1)     // Catch:{ all -> 0x0137 }
        L_0x010d:
            r9.flush()     // Catch:{ all -> 0x0137 }
            long r9 = r8.size     // Catch:{ all -> 0x0137 }
            long r0 = r8.maxSize     // Catch:{ all -> 0x0137 }
            int r9 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r9 > 0) goto L_0x011e
            boolean r9 = r8.journalRebuildRequired()     // Catch:{ all -> 0x0137 }
            if (r9 == 0) goto L_0x0129
        L_0x011e:
            okhttp3.internal.concurrent.TaskQueue r0 = r8.cleanupQueue     // Catch:{ all -> 0x0137 }
            okhttp3.internal.cache.DiskLruCache$cleanupTask$1 r1 = r8.cleanupTask     // Catch:{ all -> 0x0137 }
            r2 = 0
            r4 = 2
            r5 = 0
            okhttp3.internal.concurrent.TaskQueue.schedule$default(r0, r1, r2, r4, r5)     // Catch:{ all -> 0x0137 }
        L_0x0129:
            monitor-exit(r8)
            return
        L_0x012b:
            java.lang.String r9 = "Check failed."
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0137 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0137 }
            r10.<init>(r9)     // Catch:{ all -> 0x0137 }
            throw r10     // Catch:{ all -> 0x0137 }
        L_0x0137:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.completeEdit$okhttp(okhttp3.internal.cache.DiskLruCache$Editor, boolean):void");
    }

    public final void delete() throws IOException {
        close();
        this.fileSystem.deleteContents(this.directory);
    }

    public final Editor edit(String str) throws IOException {
        return edit$default(this, str, 0, 2, (Object) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized okhttp3.internal.cache.DiskLruCache.Editor edit(java.lang.String r10, long r11) throws java.io.IOException {
        /*
            r9 = this;
            monitor-enter(r9)
            r9.initialize()     // Catch:{ all -> 0x0087 }
            r9.checkNotClosed()     // Catch:{ all -> 0x0087 }
            r9.validateKey(r10)     // Catch:{ all -> 0x0087 }
            java.util.LinkedHashMap<java.lang.String, okhttp3.internal.cache.DiskLruCache$Entry> r0 = r9.lruEntries     // Catch:{ all -> 0x0087 }
            java.lang.Object r0 = r0.get(r10)     // Catch:{ all -> 0x0087 }
            okhttp3.internal.cache.DiskLruCache$Entry r0 = (okhttp3.internal.cache.DiskLruCache.Entry) r0     // Catch:{ all -> 0x0087 }
            long r1 = ANY_SEQUENCE_NUMBER     // Catch:{ all -> 0x0087 }
            int r1 = (r11 > r1 ? 1 : (r11 == r1 ? 0 : -1))
            r2 = 0
            if (r1 == 0) goto L_0x0025
            if (r0 == 0) goto L_0x0023
            long r3 = r0.getSequenceNumber$okhttp()     // Catch:{ all -> 0x0087 }
            int r11 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r11 == 0) goto L_0x0025
        L_0x0023:
            monitor-exit(r9)
            return r2
        L_0x0025:
            if (r0 == 0) goto L_0x002c
            okhttp3.internal.cache.DiskLruCache$Editor r11 = r0.getCurrentEditor$okhttp()     // Catch:{ all -> 0x0087 }
            goto L_0x002d
        L_0x002c:
            r11 = r2
        L_0x002d:
            if (r11 == 0) goto L_0x0031
            monitor-exit(r9)
            return r2
        L_0x0031:
            if (r0 == 0) goto L_0x003b
            int r11 = r0.getLockingSourceCount$okhttp()     // Catch:{ all -> 0x0087 }
            if (r11 == 0) goto L_0x003b
            monitor-exit(r9)
            return r2
        L_0x003b:
            boolean r11 = r9.mostRecentTrimFailed     // Catch:{ all -> 0x0087 }
            if (r11 != 0) goto L_0x007a
            boolean r11 = r9.mostRecentRebuildFailed     // Catch:{ all -> 0x0087 }
            if (r11 == 0) goto L_0x0044
            goto L_0x007a
        L_0x0044:
            okio.BufferedSink r11 = r9.journalWriter     // Catch:{ all -> 0x0087 }
            java.lang.String r12 = DIRTY     // Catch:{ all -> 0x0087 }
            okio.BufferedSink r12 = r11.writeUtf8(r12)     // Catch:{ all -> 0x0087 }
            r1 = 32
            okio.BufferedSink r12 = r12.writeByte(r1)     // Catch:{ all -> 0x0087 }
            okio.BufferedSink r12 = r12.writeUtf8(r10)     // Catch:{ all -> 0x0087 }
            r1 = 10
            r12.writeByte(r1)     // Catch:{ all -> 0x0087 }
            r11.flush()     // Catch:{ all -> 0x0087 }
            boolean r11 = r9.hasJournalErrors     // Catch:{ all -> 0x0087 }
            if (r11 == 0) goto L_0x0064
            monitor-exit(r9)
            return r2
        L_0x0064:
            if (r0 != 0) goto L_0x0070
            okhttp3.internal.cache.DiskLruCache$Entry r0 = new okhttp3.internal.cache.DiskLruCache$Entry     // Catch:{ all -> 0x0087 }
            r0.<init>(r10)     // Catch:{ all -> 0x0087 }
            java.util.LinkedHashMap<java.lang.String, okhttp3.internal.cache.DiskLruCache$Entry> r11 = r9.lruEntries     // Catch:{ all -> 0x0087 }
            r11.put(r10, r0)     // Catch:{ all -> 0x0087 }
        L_0x0070:
            okhttp3.internal.cache.DiskLruCache$Editor r10 = new okhttp3.internal.cache.DiskLruCache$Editor     // Catch:{ all -> 0x0087 }
            r10.<init>(r0)     // Catch:{ all -> 0x0087 }
            r0.setCurrentEditor$okhttp(r10)     // Catch:{ all -> 0x0087 }
            monitor-exit(r9)
            return r10
        L_0x007a:
            okhttp3.internal.concurrent.TaskQueue r3 = r9.cleanupQueue     // Catch:{ all -> 0x0087 }
            okhttp3.internal.cache.DiskLruCache$cleanupTask$1 r4 = r9.cleanupTask     // Catch:{ all -> 0x0087 }
            r5 = 0
            r7 = 2
            r8 = 0
            okhttp3.internal.concurrent.TaskQueue.schedule$default(r3, r4, r5, r7, r8)     // Catch:{ all -> 0x0087 }
            monitor-exit(r9)
            return r2
        L_0x0087:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.edit(java.lang.String, long):okhttp3.internal.cache.DiskLruCache$Editor");
    }

    public final synchronized void evictAll() throws IOException {
        initialize();
        for (Entry removeEntry$okhttp : (Entry[]) this.lruEntries.values().toArray(new Entry[0])) {
            removeEntry$okhttp(removeEntry$okhttp);
        }
        this.mostRecentTrimFailed = false;
    }

    public synchronized void flush() throws IOException {
        if (this.initialized) {
            checkNotClosed();
            trimToSize();
            this.journalWriter.flush();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004e, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized okhttp3.internal.cache.DiskLruCache.Snapshot get(java.lang.String r8) throws java.io.IOException {
        /*
            r7 = this;
            monitor-enter(r7)
            r7.initialize()     // Catch:{ all -> 0x004f }
            r7.checkNotClosed()     // Catch:{ all -> 0x004f }
            r7.validateKey(r8)     // Catch:{ all -> 0x004f }
            java.util.LinkedHashMap<java.lang.String, okhttp3.internal.cache.DiskLruCache$Entry> r0 = r7.lruEntries     // Catch:{ all -> 0x004f }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ all -> 0x004f }
            okhttp3.internal.cache.DiskLruCache$Entry r0 = (okhttp3.internal.cache.DiskLruCache.Entry) r0     // Catch:{ all -> 0x004f }
            r1 = 0
            if (r0 != 0) goto L_0x0017
            monitor-exit(r7)
            return r1
        L_0x0017:
            okhttp3.internal.cache.DiskLruCache$Snapshot r0 = r0.snapshot$okhttp()     // Catch:{ all -> 0x004f }
            if (r0 != 0) goto L_0x001f
            monitor-exit(r7)
            return r1
        L_0x001f:
            int r1 = r7.redundantOpCount     // Catch:{ all -> 0x004f }
            int r1 = r1 + 1
            r7.redundantOpCount = r1     // Catch:{ all -> 0x004f }
            okio.BufferedSink r1 = r7.journalWriter     // Catch:{ all -> 0x004f }
            java.lang.String r2 = READ     // Catch:{ all -> 0x004f }
            okio.BufferedSink r1 = r1.writeUtf8(r2)     // Catch:{ all -> 0x004f }
            r2 = 32
            okio.BufferedSink r1 = r1.writeByte(r2)     // Catch:{ all -> 0x004f }
            okio.BufferedSink r8 = r1.writeUtf8(r8)     // Catch:{ all -> 0x004f }
            r1 = 10
            r8.writeByte(r1)     // Catch:{ all -> 0x004f }
            boolean r8 = r7.journalRebuildRequired()     // Catch:{ all -> 0x004f }
            if (r8 == 0) goto L_0x004d
            okhttp3.internal.concurrent.TaskQueue r1 = r7.cleanupQueue     // Catch:{ all -> 0x004f }
            okhttp3.internal.cache.DiskLruCache$cleanupTask$1 r2 = r7.cleanupTask     // Catch:{ all -> 0x004f }
            r3 = 0
            r5 = 2
            r6 = 0
            okhttp3.internal.concurrent.TaskQueue.schedule$default(r1, r2, r3, r5, r6)     // Catch:{ all -> 0x004f }
        L_0x004d:
            monitor-exit(r7)
            return r0
        L_0x004f:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.get(java.lang.String):okhttp3.internal.cache.DiskLruCache$Snapshot");
    }

    public final boolean getClosed$okhttp() {
        return this.closed;
    }

    public final File getDirectory() {
        return this.directory;
    }

    public final FileSystem getFileSystem$okhttp() {
        return this.fileSystem;
    }

    public final LinkedHashMap<String, Entry> getLruEntries$okhttp() {
        return this.lruEntries;
    }

    public final synchronized long getMaxSize() {
        return this.maxSize;
    }

    public final int getValueCount$okhttp() {
        return this.valueCount;
    }

    public final synchronized void initialize() throws IOException {
        if (Util.assertionsEnabled) {
            if (!Thread.holdsLock(this)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
            }
        }
        if (!this.initialized) {
            if (this.fileSystem.exists(this.journalFileBackup)) {
                if (this.fileSystem.exists(this.journalFile)) {
                    this.fileSystem.delete(this.journalFileBackup);
                } else {
                    this.fileSystem.rename(this.journalFileBackup, this.journalFile);
                }
            }
            this.civilizedFileSystem = Util.isCivilized(this.fileSystem, this.journalFileBackup);
            if (this.fileSystem.exists(this.journalFile)) {
                try {
                    readJournal();
                    processJournal();
                    this.initialized = true;
                    return;
                } catch (IOException e11) {
                    Platform platform = Platform.Companion.get();
                    platform.log("DiskLruCache " + this.directory + " is corrupt: " + e11.getMessage() + ", removing", 5, e11);
                    delete();
                    this.closed = false;
                } catch (Throwable th2) {
                    this.closed = false;
                    throw th2;
                }
            }
            rebuildJournal$okhttp();
            this.initialized = true;
        }
    }

    public final synchronized boolean isClosed() {
        return this.closed;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00c0, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        kotlin.io.b.a(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00c4, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void rebuildJournal$okhttp() throws java.io.IOException {
        /*
            r7 = this;
            monitor-enter(r7)
            okio.BufferedSink r0 = r7.journalWriter     // Catch:{ all -> 0x00c5 }
            if (r0 == 0) goto L_0x0008
            r0.close()     // Catch:{ all -> 0x00c5 }
        L_0x0008:
            okhttp3.internal.io.FileSystem r0 = r7.fileSystem     // Catch:{ all -> 0x00c5 }
            java.io.File r1 = r7.journalFileTmp     // Catch:{ all -> 0x00c5 }
            okio.Sink r0 = r0.sink(r1)     // Catch:{ all -> 0x00c5 }
            okio.BufferedSink r0 = okio.Okio.buffer((okio.Sink) r0)     // Catch:{ all -> 0x00c5 }
            r1 = 0
            java.lang.String r2 = MAGIC     // Catch:{ all -> 0x00be }
            okio.BufferedSink r2 = r0.writeUtf8(r2)     // Catch:{ all -> 0x00be }
            r3 = 10
            r2.writeByte(r3)     // Catch:{ all -> 0x00be }
            java.lang.String r2 = VERSION_1     // Catch:{ all -> 0x00be }
            okio.BufferedSink r2 = r0.writeUtf8(r2)     // Catch:{ all -> 0x00be }
            r2.writeByte(r3)     // Catch:{ all -> 0x00be }
            int r2 = r7.appVersion     // Catch:{ all -> 0x00be }
            long r4 = (long) r2     // Catch:{ all -> 0x00be }
            okio.BufferedSink r2 = r0.writeDecimalLong(r4)     // Catch:{ all -> 0x00be }
            r2.writeByte(r3)     // Catch:{ all -> 0x00be }
            int r2 = r7.valueCount     // Catch:{ all -> 0x00be }
            long r4 = (long) r2     // Catch:{ all -> 0x00be }
            okio.BufferedSink r2 = r0.writeDecimalLong(r4)     // Catch:{ all -> 0x00be }
            r2.writeByte(r3)     // Catch:{ all -> 0x00be }
            r0.writeByte(r3)     // Catch:{ all -> 0x00be }
            java.util.LinkedHashMap<java.lang.String, okhttp3.internal.cache.DiskLruCache$Entry> r2 = r7.lruEntries     // Catch:{ all -> 0x00be }
            java.util.Collection r2 = r2.values()     // Catch:{ all -> 0x00be }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x00be }
        L_0x004a:
            boolean r4 = r2.hasNext()     // Catch:{ all -> 0x00be }
            if (r4 == 0) goto L_0x0089
            java.lang.Object r4 = r2.next()     // Catch:{ all -> 0x00be }
            okhttp3.internal.cache.DiskLruCache$Entry r4 = (okhttp3.internal.cache.DiskLruCache.Entry) r4     // Catch:{ all -> 0x00be }
            okhttp3.internal.cache.DiskLruCache$Editor r5 = r4.getCurrentEditor$okhttp()     // Catch:{ all -> 0x00be }
            r6 = 32
            if (r5 == 0) goto L_0x0072
            java.lang.String r5 = DIRTY     // Catch:{ all -> 0x00be }
            okio.BufferedSink r5 = r0.writeUtf8(r5)     // Catch:{ all -> 0x00be }
            r5.writeByte(r6)     // Catch:{ all -> 0x00be }
            java.lang.String r4 = r4.getKey$okhttp()     // Catch:{ all -> 0x00be }
            r0.writeUtf8(r4)     // Catch:{ all -> 0x00be }
            r0.writeByte(r3)     // Catch:{ all -> 0x00be }
            goto L_0x004a
        L_0x0072:
            java.lang.String r5 = CLEAN     // Catch:{ all -> 0x00be }
            okio.BufferedSink r5 = r0.writeUtf8(r5)     // Catch:{ all -> 0x00be }
            r5.writeByte(r6)     // Catch:{ all -> 0x00be }
            java.lang.String r5 = r4.getKey$okhttp()     // Catch:{ all -> 0x00be }
            r0.writeUtf8(r5)     // Catch:{ all -> 0x00be }
            r4.writeLengths$okhttp(r0)     // Catch:{ all -> 0x00be }
            r0.writeByte(r3)     // Catch:{ all -> 0x00be }
            goto L_0x004a
        L_0x0089:
            kotlin.Unit r2 = kotlin.Unit.f56620a     // Catch:{ all -> 0x00be }
            kotlin.io.b.a(r0, r1)     // Catch:{ all -> 0x00c5 }
            okhttp3.internal.io.FileSystem r0 = r7.fileSystem     // Catch:{ all -> 0x00c5 }
            java.io.File r1 = r7.journalFile     // Catch:{ all -> 0x00c5 }
            boolean r0 = r0.exists(r1)     // Catch:{ all -> 0x00c5 }
            if (r0 == 0) goto L_0x00a1
            okhttp3.internal.io.FileSystem r0 = r7.fileSystem     // Catch:{ all -> 0x00c5 }
            java.io.File r1 = r7.journalFile     // Catch:{ all -> 0x00c5 }
            java.io.File r2 = r7.journalFileBackup     // Catch:{ all -> 0x00c5 }
            r0.rename(r1, r2)     // Catch:{ all -> 0x00c5 }
        L_0x00a1:
            okhttp3.internal.io.FileSystem r0 = r7.fileSystem     // Catch:{ all -> 0x00c5 }
            java.io.File r1 = r7.journalFileTmp     // Catch:{ all -> 0x00c5 }
            java.io.File r2 = r7.journalFile     // Catch:{ all -> 0x00c5 }
            r0.rename(r1, r2)     // Catch:{ all -> 0x00c5 }
            okhttp3.internal.io.FileSystem r0 = r7.fileSystem     // Catch:{ all -> 0x00c5 }
            java.io.File r1 = r7.journalFileBackup     // Catch:{ all -> 0x00c5 }
            r0.delete(r1)     // Catch:{ all -> 0x00c5 }
            okio.BufferedSink r0 = r7.newJournalWriter()     // Catch:{ all -> 0x00c5 }
            r7.journalWriter = r0     // Catch:{ all -> 0x00c5 }
            r0 = 0
            r7.hasJournalErrors = r0     // Catch:{ all -> 0x00c5 }
            r7.mostRecentRebuildFailed = r0     // Catch:{ all -> 0x00c5 }
            monitor-exit(r7)
            return
        L_0x00be:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x00c0 }
        L_0x00c0:
            r2 = move-exception
            kotlin.io.b.a(r0, r1)     // Catch:{ all -> 0x00c5 }
            throw r2     // Catch:{ all -> 0x00c5 }
        L_0x00c5:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.rebuildJournal$okhttp():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0028, code lost:
        return r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean remove(java.lang.String r6) throws java.io.IOException {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.initialize()     // Catch:{ all -> 0x0029 }
            r5.checkNotClosed()     // Catch:{ all -> 0x0029 }
            r5.validateKey(r6)     // Catch:{ all -> 0x0029 }
            java.util.LinkedHashMap<java.lang.String, okhttp3.internal.cache.DiskLruCache$Entry> r0 = r5.lruEntries     // Catch:{ all -> 0x0029 }
            java.lang.Object r6 = r0.get(r6)     // Catch:{ all -> 0x0029 }
            okhttp3.internal.cache.DiskLruCache$Entry r6 = (okhttp3.internal.cache.DiskLruCache.Entry) r6     // Catch:{ all -> 0x0029 }
            r0 = 0
            if (r6 != 0) goto L_0x0017
            monitor-exit(r5)
            return r0
        L_0x0017:
            boolean r6 = r5.removeEntry$okhttp(r6)     // Catch:{ all -> 0x0029 }
            if (r6 == 0) goto L_0x0027
            long r1 = r5.size     // Catch:{ all -> 0x0029 }
            long r3 = r5.maxSize     // Catch:{ all -> 0x0029 }
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x0027
            r5.mostRecentTrimFailed = r0     // Catch:{ all -> 0x0029 }
        L_0x0027:
            monitor-exit(r5)
            return r6
        L_0x0029:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.remove(java.lang.String):boolean");
    }

    public final boolean removeEntry$okhttp(Entry entry) throws IOException {
        BufferedSink bufferedSink;
        if (!this.civilizedFileSystem) {
            if (entry.getLockingSourceCount$okhttp() > 0 && (bufferedSink = this.journalWriter) != null) {
                bufferedSink.writeUtf8(DIRTY);
                bufferedSink.writeByte(32);
                bufferedSink.writeUtf8(entry.getKey$okhttp());
                bufferedSink.writeByte(10);
                bufferedSink.flush();
            }
            if (entry.getLockingSourceCount$okhttp() > 0 || entry.getCurrentEditor$okhttp() != null) {
                entry.setZombie$okhttp(true);
                return true;
            }
        }
        Editor currentEditor$okhttp = entry.getCurrentEditor$okhttp();
        if (currentEditor$okhttp != null) {
            currentEditor$okhttp.detach$okhttp();
        }
        int i11 = this.valueCount;
        for (int i12 = 0; i12 < i11; i12++) {
            this.fileSystem.delete(entry.getCleanFiles$okhttp().get(i12));
            this.size -= entry.getLengths$okhttp()[i12];
            entry.getLengths$okhttp()[i12] = 0;
        }
        this.redundantOpCount++;
        BufferedSink bufferedSink2 = this.journalWriter;
        if (bufferedSink2 != null) {
            bufferedSink2.writeUtf8(REMOVE);
            bufferedSink2.writeByte(32);
            bufferedSink2.writeUtf8(entry.getKey$okhttp());
            bufferedSink2.writeByte(10);
        }
        this.lruEntries.remove(entry.getKey$okhttp());
        if (journalRebuildRequired()) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0, 2, (Object) null);
        }
        return true;
    }

    public final void setClosed$okhttp(boolean z11) {
        this.closed = z11;
    }

    public final synchronized void setMaxSize(long j11) {
        this.maxSize = j11;
        if (this.initialized) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0, 2, (Object) null);
        }
    }

    public final synchronized long size() throws IOException {
        initialize();
        return this.size;
    }

    public final synchronized Iterator<Snapshot> snapshots() throws IOException {
        initialize();
        return new DiskLruCache$snapshots$1(this);
    }

    public final void trimToSize() throws IOException {
        while (this.size > this.maxSize) {
            if (!removeOldestEntry()) {
                return;
            }
        }
        this.mostRecentTrimFailed = false;
    }
}
