package com.google.android.exoplayer2.upstream.cache;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer2.database.DatabaseIOException;
import com.google.android.exoplayer2.database.DatabaseProvider;
import com.google.android.exoplayer2.database.VersionTable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.AtomicFile;
import com.google.android.exoplayer2.util.ReusableBufferedOutputStream;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import com.sumsub.sns.prooface.network.b;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

class CachedContentIndex {
    public static final String FILE_NAME_ATOMIC = "cached_content_index.exi";
    private static final int INCREMENTAL_METADATA_READ_LENGTH = 10485760;
    private final SparseArray<String> idToKey;
    private final HashMap<String, CachedContent> keyToContent;
    private final SparseBooleanArray newIds;
    private Storage previousStorage;
    private final SparseBooleanArray removedIds;
    private Storage storage;

    public static final class DatabaseStorage implements Storage {
        private static final String[] COLUMNS = {"id", "key", "metadata"};
        private static final String COLUMN_ID = "id";
        private static final int COLUMN_INDEX_ID = 0;
        private static final int COLUMN_INDEX_KEY = 1;
        private static final int COLUMN_INDEX_METADATA = 2;
        private static final String COLUMN_KEY = "key";
        private static final String COLUMN_METADATA = "metadata";
        private static final String TABLE_PREFIX = "ExoPlayerCacheIndex";
        private static final String TABLE_SCHEMA = "(id INTEGER PRIMARY KEY NOT NULL,key TEXT NOT NULL,metadata BLOB NOT NULL)";
        private static final int TABLE_VERSION = 1;
        private static final String WHERE_ID_EQUALS = "id = ?";
        private final DatabaseProvider databaseProvider;
        private String hexUid;
        private final SparseArray<CachedContent> pendingUpdates = new SparseArray<>();
        private String tableName;

        public DatabaseStorage(DatabaseProvider databaseProvider2) {
            this.databaseProvider = databaseProvider2;
        }

        private void addOrUpdateRow(SQLiteDatabase sQLiteDatabase, CachedContent cachedContent) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            CachedContentIndex.writeContentMetadata(cachedContent.getMetadata(), new DataOutputStream(byteArrayOutputStream));
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", Integer.valueOf(cachedContent.f66077id));
            contentValues.put("key", cachedContent.key);
            contentValues.put("metadata", byteArray);
            sQLiteDatabase.replaceOrThrow((String) Assertions.checkNotNull(this.tableName), (String) null, contentValues);
        }

        public static void delete(DatabaseProvider databaseProvider2, long j11) throws DatabaseIOException {
            delete(databaseProvider2, Long.toHexString(j11));
        }

        private void deleteRow(SQLiteDatabase sQLiteDatabase, int i11) {
            sQLiteDatabase.delete((String) Assertions.checkNotNull(this.tableName), WHERE_ID_EQUALS, new String[]{Integer.toString(i11)});
        }

        private static void dropTable(SQLiteDatabase sQLiteDatabase, String str) {
            String valueOf = String.valueOf(str);
            sQLiteDatabase.execSQL(valueOf.length() != 0 ? "DROP TABLE IF EXISTS ".concat(valueOf) : new String("DROP TABLE IF EXISTS "));
        }

        private Cursor getCursor() {
            return this.databaseProvider.getReadableDatabase().query((String) Assertions.checkNotNull(this.tableName), COLUMNS, (String) null, (String[]) null, (String) null, (String) null, (String) null);
        }

        private static String getTableName(String str) {
            String valueOf = String.valueOf(str);
            return valueOf.length() != 0 ? TABLE_PREFIX.concat(valueOf) : new String(TABLE_PREFIX);
        }

        private void initializeTable(SQLiteDatabase sQLiteDatabase) throws DatabaseIOException {
            VersionTable.setVersion(sQLiteDatabase, 1, (String) Assertions.checkNotNull(this.hexUid), 1);
            dropTable(sQLiteDatabase, (String) Assertions.checkNotNull(this.tableName));
            String str = this.tableName;
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 88);
            sb2.append("CREATE TABLE ");
            sb2.append(str);
            sb2.append(" ");
            sb2.append(TABLE_SCHEMA);
            sQLiteDatabase.execSQL(sb2.toString());
        }

        public boolean exists() throws DatabaseIOException {
            if (VersionTable.getVersion(this.databaseProvider.getReadableDatabase(), 1, (String) Assertions.checkNotNull(this.hexUid)) != -1) {
                return true;
            }
            return false;
        }

        public void initialize(long j11) {
            String hexString = Long.toHexString(j11);
            this.hexUid = hexString;
            this.tableName = getTableName(hexString);
        }

        public void load(HashMap<String, CachedContent> hashMap, SparseArray<String> sparseArray) throws IOException {
            Cursor cursor;
            SQLiteDatabase writableDatabase;
            Assertions.checkState(this.pendingUpdates.size() == 0);
            try {
                if (VersionTable.getVersion(this.databaseProvider.getReadableDatabase(), 1, (String) Assertions.checkNotNull(this.hexUid)) != 1) {
                    writableDatabase = this.databaseProvider.getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    initializeTable(writableDatabase);
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                }
                cursor = getCursor();
                while (cursor.moveToNext()) {
                    CachedContent cachedContent = new CachedContent(cursor.getInt(0), cursor.getString(1), CachedContentIndex.readContentMetadata(new DataInputStream(new ByteArrayInputStream(cursor.getBlob(2)))));
                    hashMap.put(cachedContent.key, cachedContent);
                    sparseArray.put(cachedContent.f66077id, cachedContent.key);
                }
                cursor.close();
                return;
            } catch (SQLiteException e11) {
                hashMap.clear();
                sparseArray.clear();
                throw new DatabaseIOException(e11);
            } catch (Throwable th2) {
                writableDatabase.endTransaction();
                throw th2;
            }
            throw th;
        }

        public void onRemove(CachedContent cachedContent, boolean z11) {
            if (z11) {
                this.pendingUpdates.delete(cachedContent.f66077id);
            } else {
                this.pendingUpdates.put(cachedContent.f66077id, (Object) null);
            }
        }

        public void onUpdate(CachedContent cachedContent) {
            this.pendingUpdates.put(cachedContent.f66077id, cachedContent);
        }

        public void storeFully(HashMap<String, CachedContent> hashMap) throws IOException {
            SQLiteDatabase writableDatabase;
            try {
                writableDatabase = this.databaseProvider.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                initializeTable(writableDatabase);
                for (CachedContent addOrUpdateRow : hashMap.values()) {
                    addOrUpdateRow(writableDatabase, addOrUpdateRow);
                }
                writableDatabase.setTransactionSuccessful();
                this.pendingUpdates.clear();
                writableDatabase.endTransaction();
            } catch (SQLException e11) {
                throw new DatabaseIOException(e11);
            } catch (Throwable th2) {
                writableDatabase.endTransaction();
                throw th2;
            }
        }

        public void storeIncremental(HashMap<String, CachedContent> hashMap) throws IOException {
            SQLiteDatabase writableDatabase;
            if (this.pendingUpdates.size() != 0) {
                try {
                    writableDatabase = this.databaseProvider.getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    for (int i11 = 0; i11 < this.pendingUpdates.size(); i11++) {
                        CachedContent valueAt = this.pendingUpdates.valueAt(i11);
                        if (valueAt == null) {
                            deleteRow(writableDatabase, this.pendingUpdates.keyAt(i11));
                        } else {
                            addOrUpdateRow(writableDatabase, valueAt);
                        }
                    }
                    writableDatabase.setTransactionSuccessful();
                    this.pendingUpdates.clear();
                    writableDatabase.endTransaction();
                } catch (SQLException e11) {
                    throw new DatabaseIOException(e11);
                } catch (Throwable th2) {
                    writableDatabase.endTransaction();
                    throw th2;
                }
            }
        }

        public void delete() throws DatabaseIOException {
            delete(this.databaseProvider, (String) Assertions.checkNotNull(this.hexUid));
        }

        private static void delete(DatabaseProvider databaseProvider2, String str) throws DatabaseIOException {
            SQLiteDatabase writableDatabase;
            try {
                String tableName2 = getTableName(str);
                writableDatabase = databaseProvider2.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                VersionTable.removeVersion(writableDatabase, 1, str);
                dropTable(writableDatabase, tableName2);
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
            } catch (SQLException e11) {
                throw new DatabaseIOException(e11);
            } catch (Throwable th2) {
                writableDatabase.endTransaction();
                throw th2;
            }
        }
    }

    public static class LegacyStorage implements Storage {
        private static final int FLAG_ENCRYPTED_INDEX = 1;
        private static final int VERSION = 2;
        private static final int VERSION_METADATA_INTRODUCED = 2;
        private final AtomicFile atomicFile;
        private ReusableBufferedOutputStream bufferedOutputStream;
        private boolean changed;
        private final Cipher cipher;
        private final boolean encrypt;
        private final SecureRandom random;
        private final SecretKeySpec secretKeySpec;

        public LegacyStorage(File file, byte[] bArr, boolean z11) {
            SecretKeySpec secretKeySpec2;
            Cipher cipher2;
            boolean z12 = false;
            Assertions.checkState(bArr != null || !z11);
            SecureRandom secureRandom = null;
            if (bArr != null) {
                Assertions.checkArgument(bArr.length == 16 ? true : z12);
                try {
                    cipher2 = CachedContentIndex.getCipher();
                    secretKeySpec2 = new SecretKeySpec(bArr, b.f40261d);
                } catch (NoSuchAlgorithmException | NoSuchPaddingException e11) {
                    throw new IllegalStateException(e11);
                }
            } else {
                Assertions.checkArgument(!z11);
                cipher2 = null;
                secretKeySpec2 = null;
            }
            this.encrypt = z11;
            this.cipher = cipher2;
            this.secretKeySpec = secretKeySpec2;
            this.random = z11 ? new SecureRandom() : secureRandom;
            this.atomicFile = new AtomicFile(file);
        }

        private int hashCachedContent(CachedContent cachedContent, int i11) {
            int i12;
            int i13;
            int hashCode = (cachedContent.f66077id * 31) + cachedContent.key.hashCode();
            if (i11 < 2) {
                long a11 = c.a(cachedContent.getMetadata());
                i13 = hashCode * 31;
                i12 = (int) (a11 ^ (a11 >>> 32));
            } else {
                i13 = hashCode * 31;
                i12 = cachedContent.getMetadata().hashCode();
            }
            return i13 + i12;
        }

        private CachedContent readCachedContent(int i11, DataInputStream dataInputStream) throws IOException {
            DefaultContentMetadata defaultContentMetadata;
            int readInt = dataInputStream.readInt();
            String readUTF = dataInputStream.readUTF();
            if (i11 < 2) {
                long readLong = dataInputStream.readLong();
                ContentMetadataMutations contentMetadataMutations = new ContentMetadataMutations();
                ContentMetadataMutations.setContentLength(contentMetadataMutations, readLong);
                defaultContentMetadata = DefaultContentMetadata.EMPTY.copyWithMutationsApplied(contentMetadataMutations);
            } else {
                defaultContentMetadata = CachedContentIndex.readContentMetadata(dataInputStream);
            }
            return new CachedContent(readInt, readUTF, defaultContentMetadata);
        }

        /* JADX WARNING: Removed duplicated region for block: B:55:0x00b3  */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x00b9  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean readFile(java.util.HashMap<java.lang.String, com.google.android.exoplayer2.upstream.cache.CachedContent> r11, android.util.SparseArray<java.lang.String> r12) {
            /*
                r10 = this;
                com.google.android.exoplayer2.util.AtomicFile r0 = r10.atomicFile
                boolean r0 = r0.exists()
                r1 = 1
                if (r0 != 0) goto L_0x000a
                return r1
            L_0x000a:
                r0 = 0
                r2 = 0
                java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00b7, all -> 0x00b0 }
                com.google.android.exoplayer2.util.AtomicFile r4 = r10.atomicFile     // Catch:{ IOException -> 0x00b7, all -> 0x00b0 }
                java.io.InputStream r4 = r4.openRead()     // Catch:{ IOException -> 0x00b7, all -> 0x00b0 }
                r3.<init>(r4)     // Catch:{ IOException -> 0x00b7, all -> 0x00b0 }
                java.io.DataInputStream r4 = new java.io.DataInputStream     // Catch:{ IOException -> 0x00b7, all -> 0x00b0 }
                r4.<init>(r3)     // Catch:{ IOException -> 0x00b7, all -> 0x00b0 }
                int r0 = r4.readInt()     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                if (r0 < 0) goto L_0x00a7
                r5 = 2
                if (r0 <= r5) goto L_0x0027
                goto L_0x00a7
            L_0x0027:
                int r6 = r4.readInt()     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r6 = r6 & r1
                if (r6 == 0) goto L_0x0066
                javax.crypto.Cipher r6 = r10.cipher     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                if (r6 != 0) goto L_0x0036
                com.google.android.exoplayer2.util.Util.closeQuietly((java.io.Closeable) r4)
                return r2
            L_0x0036:
                r6 = 16
                byte[] r6 = new byte[r6]     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r4.readFully(r6)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                javax.crypto.spec.IvParameterSpec r7 = new javax.crypto.spec.IvParameterSpec     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r7.<init>(r6)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                javax.crypto.Cipher r6 = r10.cipher     // Catch:{ InvalidKeyException -> 0x005f, InvalidAlgorithmParameterException -> 0x005d }
                javax.crypto.spec.SecretKeySpec r8 = r10.secretKeySpec     // Catch:{ InvalidKeyException -> 0x005f, InvalidAlgorithmParameterException -> 0x005d }
                java.lang.Object r8 = com.google.android.exoplayer2.util.Util.castNonNull(r8)     // Catch:{ InvalidKeyException -> 0x005f, InvalidAlgorithmParameterException -> 0x005d }
                java.security.Key r8 = (java.security.Key) r8     // Catch:{ InvalidKeyException -> 0x005f, InvalidAlgorithmParameterException -> 0x005d }
                r6.init(r5, r8, r7)     // Catch:{ InvalidKeyException -> 0x005f, InvalidAlgorithmParameterException -> 0x005d }
                java.io.DataInputStream r5 = new java.io.DataInputStream     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                javax.crypto.CipherInputStream r6 = new javax.crypto.CipherInputStream     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                javax.crypto.Cipher r7 = r10.cipher     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r6.<init>(r3, r7)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r5.<init>(r6)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r4 = r5
                goto L_0x006c
            L_0x005d:
                r11 = move-exception
                goto L_0x0060
            L_0x005f:
                r11 = move-exception
            L_0x0060:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r12.<init>(r11)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                throw r12     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
            L_0x0066:
                boolean r3 = r10.encrypt     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                if (r3 == 0) goto L_0x006c
                r10.changed = r1     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
            L_0x006c:
                int r3 = r4.readInt()     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r5 = r2
                r6 = r5
            L_0x0072:
                if (r5 >= r3) goto L_0x008c
                com.google.android.exoplayer2.upstream.cache.CachedContent r7 = r10.readCachedContent(r0, r4)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                java.lang.String r8 = r7.key     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r11.put(r8, r7)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                int r8 = r7.f66077id     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                java.lang.String r9 = r7.key     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r12.put(r8, r9)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                int r7 = r10.hashCachedContent(r7, r0)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                int r6 = r6 + r7
                int r5 = r5 + 1
                goto L_0x0072
            L_0x008c:
                int r11 = r4.readInt()     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                int r12 = r4.read()     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r0 = -1
                if (r12 != r0) goto L_0x0099
                r12 = r1
                goto L_0x009a
            L_0x0099:
                r12 = r2
            L_0x009a:
                if (r11 != r6) goto L_0x00a3
                if (r12 != 0) goto L_0x009f
                goto L_0x00a3
            L_0x009f:
                com.google.android.exoplayer2.util.Util.closeQuietly((java.io.Closeable) r4)
                return r1
            L_0x00a3:
                com.google.android.exoplayer2.util.Util.closeQuietly((java.io.Closeable) r4)
                return r2
            L_0x00a7:
                com.google.android.exoplayer2.util.Util.closeQuietly((java.io.Closeable) r4)
                return r2
            L_0x00ab:
                r11 = move-exception
                r0 = r4
                goto L_0x00b1
            L_0x00ae:
                r0 = r4
                goto L_0x00b7
            L_0x00b0:
                r11 = move-exception
            L_0x00b1:
                if (r0 == 0) goto L_0x00b6
                com.google.android.exoplayer2.util.Util.closeQuietly((java.io.Closeable) r0)
            L_0x00b6:
                throw r11
            L_0x00b7:
                if (r0 == 0) goto L_0x00bc
                com.google.android.exoplayer2.util.Util.closeQuietly((java.io.Closeable) r0)
            L_0x00bc:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.cache.CachedContentIndex.LegacyStorage.readFile(java.util.HashMap, android.util.SparseArray):boolean");
        }

        private void writeCachedContent(CachedContent cachedContent, DataOutputStream dataOutputStream) throws IOException {
            dataOutputStream.writeInt(cachedContent.f66077id);
            dataOutputStream.writeUTF(cachedContent.key);
            CachedContentIndex.writeContentMetadata(cachedContent.getMetadata(), dataOutputStream);
        }

        private void writeFile(HashMap<String, CachedContent> hashMap) throws IOException {
            DataOutputStream dataOutputStream = null;
            try {
                OutputStream startWrite = this.atomicFile.startWrite();
                ReusableBufferedOutputStream reusableBufferedOutputStream = this.bufferedOutputStream;
                if (reusableBufferedOutputStream == null) {
                    this.bufferedOutputStream = new ReusableBufferedOutputStream(startWrite);
                } else {
                    reusableBufferedOutputStream.reset(startWrite);
                }
                ReusableBufferedOutputStream reusableBufferedOutputStream2 = this.bufferedOutputStream;
                DataOutputStream dataOutputStream2 = new DataOutputStream(reusableBufferedOutputStream2);
                try {
                    dataOutputStream2.writeInt(2);
                    int i11 = 0;
                    dataOutputStream2.writeInt(this.encrypt ? 1 : 0);
                    if (this.encrypt) {
                        byte[] bArr = new byte[16];
                        ((SecureRandom) Util.castNonNull(this.random)).nextBytes(bArr);
                        dataOutputStream2.write(bArr);
                        ((Cipher) Util.castNonNull(this.cipher)).init(1, (Key) Util.castNonNull(this.secretKeySpec), new IvParameterSpec(bArr));
                        dataOutputStream2.flush();
                        dataOutputStream2 = new DataOutputStream(new CipherOutputStream(reusableBufferedOutputStream2, this.cipher));
                    }
                    dataOutputStream2.writeInt(hashMap.size());
                    for (CachedContent next : hashMap.values()) {
                        writeCachedContent(next, dataOutputStream2);
                        i11 += hashCachedContent(next, 2);
                    }
                    dataOutputStream2.writeInt(i11);
                    this.atomicFile.endWrite(dataOutputStream2);
                    Util.closeQuietly((Closeable) null);
                } catch (InvalidKeyException e11) {
                    e = e11;
                    throw new IllegalStateException(e);
                } catch (InvalidAlgorithmParameterException e12) {
                    e = e12;
                    throw new IllegalStateException(e);
                } catch (Throwable th2) {
                    th = th2;
                    dataOutputStream = dataOutputStream2;
                    Util.closeQuietly((Closeable) dataOutputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                Util.closeQuietly((Closeable) dataOutputStream);
                throw th;
            }
        }

        public void delete() {
            this.atomicFile.delete();
        }

        public boolean exists() {
            return this.atomicFile.exists();
        }

        public void initialize(long j11) {
        }

        public void load(HashMap<String, CachedContent> hashMap, SparseArray<String> sparseArray) {
            Assertions.checkState(!this.changed);
            if (!readFile(hashMap, sparseArray)) {
                hashMap.clear();
                sparseArray.clear();
                this.atomicFile.delete();
            }
        }

        public void onRemove(CachedContent cachedContent, boolean z11) {
            this.changed = true;
        }

        public void onUpdate(CachedContent cachedContent) {
            this.changed = true;
        }

        public void storeFully(HashMap<String, CachedContent> hashMap) throws IOException {
            writeFile(hashMap);
            this.changed = false;
        }

        public void storeIncremental(HashMap<String, CachedContent> hashMap) throws IOException {
            if (this.changed) {
                storeFully(hashMap);
            }
        }
    }

    public interface Storage {
        void delete() throws IOException;

        boolean exists() throws IOException;

        void initialize(long j11);

        void load(HashMap<String, CachedContent> hashMap, SparseArray<String> sparseArray) throws IOException;

        void onRemove(CachedContent cachedContent, boolean z11);

        void onUpdate(CachedContent cachedContent);

        void storeFully(HashMap<String, CachedContent> hashMap) throws IOException;

        void storeIncremental(HashMap<String, CachedContent> hashMap) throws IOException;
    }

    public CachedContentIndex(DatabaseProvider databaseProvider) {
        this(databaseProvider, (File) null, (byte[]) null, false, false);
    }

    private CachedContent addNew(String str) {
        int newId = getNewId(this.idToKey);
        CachedContent cachedContent = new CachedContent(newId, str);
        this.keyToContent.put(str, cachedContent);
        this.idToKey.put(newId, str);
        this.newIds.put(newId, true);
        this.storage.onUpdate(cachedContent);
        return cachedContent;
    }

    public static void delete(DatabaseProvider databaseProvider, long j11) throws DatabaseIOException {
        DatabaseStorage.delete(databaseProvider, j11);
    }

    /* access modifiers changed from: private */
    @SuppressLint({"GetInstance"})
    public static Cipher getCipher() throws NoSuchPaddingException, NoSuchAlgorithmException {
        if (Util.SDK_INT == 18) {
            try {
                return Cipher.getInstance("AES/CBC/PKCS5PADDING", BouncyCastleProvider.PROVIDER_NAME);
            } catch (Throwable unused) {
            }
        }
        return Cipher.getInstance("AES/CBC/PKCS5PADDING");
    }

    public static int getNewId(SparseArray<String> sparseArray) {
        int i11;
        int size = sparseArray.size();
        int i12 = 0;
        if (size == 0) {
            i11 = 0;
        } else {
            i11 = sparseArray.keyAt(size - 1) + 1;
        }
        if (i11 >= 0) {
            return i11;
        }
        while (i12 < size && i12 == sparseArray.keyAt(i12)) {
            i12++;
        }
        return i12;
    }

    public static boolean isIndexFile(String str) {
        return str.startsWith(FILE_NAME_ATOMIC);
    }

    /* access modifiers changed from: private */
    public static DefaultContentMetadata readContentMetadata(DataInputStream dataInputStream) throws IOException {
        int readInt = dataInputStream.readInt();
        HashMap hashMap = new HashMap();
        int i11 = 0;
        while (i11 < readInt) {
            String readUTF = dataInputStream.readUTF();
            int readInt2 = dataInputStream.readInt();
            if (readInt2 >= 0) {
                int min = Math.min(readInt2, INCREMENTAL_METADATA_READ_LENGTH);
                byte[] bArr = Util.EMPTY_BYTE_ARRAY;
                int i12 = 0;
                while (i12 != readInt2) {
                    int i13 = i12 + min;
                    bArr = Arrays.copyOf(bArr, i13);
                    dataInputStream.readFully(bArr, i12, min);
                    min = Math.min(readInt2 - i13, INCREMENTAL_METADATA_READ_LENGTH);
                    i12 = i13;
                }
                hashMap.put(readUTF, bArr);
                i11++;
            } else {
                StringBuilder sb2 = new StringBuilder(31);
                sb2.append("Invalid value size: ");
                sb2.append(readInt2);
                throw new IOException(sb2.toString());
            }
        }
        return new DefaultContentMetadata(hashMap);
    }

    /* access modifiers changed from: private */
    public static void writeContentMetadata(DefaultContentMetadata defaultContentMetadata, DataOutputStream dataOutputStream) throws IOException {
        Set<Map.Entry<String, byte[]>> entrySet = defaultContentMetadata.entrySet();
        dataOutputStream.writeInt(entrySet.size());
        for (Map.Entry next : entrySet) {
            dataOutputStream.writeUTF((String) next.getKey());
            byte[] bArr = (byte[]) next.getValue();
            dataOutputStream.writeInt(bArr.length);
            dataOutputStream.write(bArr);
        }
    }

    public void applyContentMetadataMutations(String str, ContentMetadataMutations contentMetadataMutations) {
        CachedContent orAdd = getOrAdd(str);
        if (orAdd.applyMetadataMutations(contentMetadataMutations)) {
            this.storage.onUpdate(orAdd);
        }
    }

    public int assignIdForKey(String str) {
        return getOrAdd(str).f66077id;
    }

    public CachedContent get(String str) {
        return this.keyToContent.get(str);
    }

    public Collection<CachedContent> getAll() {
        return Collections.unmodifiableCollection(this.keyToContent.values());
    }

    public ContentMetadata getContentMetadata(String str) {
        CachedContent cachedContent = get(str);
        return cachedContent != null ? cachedContent.getMetadata() : DefaultContentMetadata.EMPTY;
    }

    public String getKeyForId(int i11) {
        return this.idToKey.get(i11);
    }

    public Set<String> getKeys() {
        return this.keyToContent.keySet();
    }

    public CachedContent getOrAdd(String str) {
        CachedContent cachedContent = this.keyToContent.get(str);
        return cachedContent == null ? addNew(str) : cachedContent;
    }

    public void initialize(long j11) throws IOException {
        Storage storage2;
        this.storage.initialize(j11);
        Storage storage3 = this.previousStorage;
        if (storage3 != null) {
            storage3.initialize(j11);
        }
        if (this.storage.exists() || (storage2 = this.previousStorage) == null || !storage2.exists()) {
            this.storage.load(this.keyToContent, this.idToKey);
        } else {
            this.previousStorage.load(this.keyToContent, this.idToKey);
            this.storage.storeFully(this.keyToContent);
        }
        Storage storage4 = this.previousStorage;
        if (storage4 != null) {
            storage4.delete();
            this.previousStorage = null;
        }
    }

    public void maybeRemove(String str) {
        CachedContent cachedContent = this.keyToContent.get(str);
        if (cachedContent != null && cachedContent.isEmpty() && cachedContent.isFullyUnlocked()) {
            this.keyToContent.remove(str);
            int i11 = cachedContent.f66077id;
            boolean z11 = this.newIds.get(i11);
            this.storage.onRemove(cachedContent, z11);
            if (z11) {
                this.idToKey.remove(i11);
                this.newIds.delete(i11);
                return;
            }
            this.idToKey.put(i11, (Object) null);
            this.removedIds.put(i11, true);
        }
    }

    public void removeEmpty() {
        UnmodifiableIterator<String> it2 = ImmutableSet.copyOf(this.keyToContent.keySet()).iterator();
        while (it2.hasNext()) {
            maybeRemove(it2.next());
        }
    }

    public void store() throws IOException {
        this.storage.storeIncremental(this.keyToContent);
        int size = this.removedIds.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.idToKey.remove(this.removedIds.keyAt(i11));
        }
        this.removedIds.clear();
        this.newIds.clear();
    }

    public CachedContentIndex(DatabaseProvider databaseProvider, File file, byte[] bArr, boolean z11, boolean z12) {
        Assertions.checkState((databaseProvider == null && file == null) ? false : true);
        this.keyToContent = new HashMap<>();
        this.idToKey = new SparseArray<>();
        this.removedIds = new SparseBooleanArray();
        this.newIds = new SparseBooleanArray();
        LegacyStorage legacyStorage = null;
        DatabaseStorage databaseStorage = databaseProvider != null ? new DatabaseStorage(databaseProvider) : null;
        legacyStorage = file != null ? new LegacyStorage(new File(file, FILE_NAME_ATOMIC), bArr, z11) : legacyStorage;
        if (databaseStorage == null || (legacyStorage != null && z12)) {
            this.storage = (Storage) Util.castNonNull(legacyStorage);
            this.previousStorage = databaseStorage;
            return;
        }
        this.storage = databaseStorage;
        this.previousStorage = legacyStorage;
    }
}
