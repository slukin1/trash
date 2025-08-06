package com.tencent.android.tpns.mqtt.persist;

import com.tencent.android.tpns.mqtt.MqttClientPersistence;
import com.tencent.android.tpns.mqtt.MqttPersistable;
import com.tencent.android.tpns.mqtt.MqttPersistenceException;
import com.tencent.android.tpns.mqtt.internal.FileLock;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

public class MqttDefaultFilePersistence implements MqttClientPersistence {
    private static FilenameFilter FILENAME_FILTER = null;
    private static final String LOCK_FILENAME = ".lck";
    private static final String MESSAGE_BACKUP_FILE_EXTENSION = ".bup";
    private static final String MESSAGE_FILE_EXTENSION = ".msg";
    private File clientDir;
    private File dataDir;
    private FileLock fileLock;

    public MqttDefaultFilePersistence() {
        this(System.getProperty("user.dir"));
    }

    private void checkIsOpen() throws MqttPersistenceException {
        if (this.clientDir == null) {
            throw new MqttPersistenceException();
        }
    }

    private static FilenameFilter getFilenameFilter() {
        if (FILENAME_FILTER == null) {
            FILENAME_FILTER = new PersistanceFileNameFilter(MESSAGE_FILE_EXTENSION);
        }
        return FILENAME_FILTER;
    }

    private File[] getFiles() throws MqttPersistenceException {
        checkIsOpen();
        File[] listFiles = this.clientDir.listFiles(getFilenameFilter());
        if (listFiles != null) {
            return listFiles;
        }
        throw new MqttPersistenceException();
    }

    private boolean isSafeChar(char c11) {
        return Character.isJavaIdentifierPart(c11) || c11 == '-';
    }

    private void restoreBackups(File file) throws MqttPersistenceException {
        File[] listFiles = file.listFiles(new PersistanceFileFilter(MESSAGE_BACKUP_FILE_EXTENSION));
        if (listFiles != null) {
            for (int i11 = 0; i11 < listFiles.length; i11++) {
                File file2 = new File(file, listFiles[i11].getName().substring(0, listFiles[i11].getName().length() - 4));
                if (!listFiles[i11].renameTo(file2)) {
                    file2.delete();
                    listFiles[i11].renameTo(file2);
                }
            }
            return;
        }
        throw new MqttPersistenceException();
    }

    public void clear() throws MqttPersistenceException {
        checkIsOpen();
        File[] files = getFiles();
        for (File delete : files) {
            delete.delete();
        }
        this.clientDir.delete();
    }

    public void close() throws MqttPersistenceException {
        synchronized (this) {
            FileLock fileLock2 = this.fileLock;
            if (fileLock2 != null) {
                fileLock2.release();
            }
            if (getFiles().length == 0) {
                this.clientDir.delete();
            }
            this.clientDir = null;
        }
    }

    public boolean containsKey(String str) throws MqttPersistenceException {
        checkIsOpen();
        File file = this.clientDir;
        return new File(file, str + MESSAGE_FILE_EXTENSION).exists();
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0047 A[SYNTHETIC, Splitter:B:13:0x0047] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.tencent.android.tpns.mqtt.MqttPersistable get(java.lang.String r12) throws com.tencent.android.tpns.mqtt.MqttPersistenceException {
        /*
            r11 = this;
            r11.checkIsOpen()
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ IOException -> 0x0044 }
            java.io.File r2 = r11.clientDir     // Catch:{ IOException -> 0x0044 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0044 }
            r3.<init>()     // Catch:{ IOException -> 0x0044 }
            r3.append(r12)     // Catch:{ IOException -> 0x0044 }
            java.lang.String r4 = ".msg"
            r3.append(r4)     // Catch:{ IOException -> 0x0044 }
            java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x0044 }
            r1.<init>(r2, r3)     // Catch:{ IOException -> 0x0044 }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0044 }
            r2.<init>(r1)     // Catch:{ IOException -> 0x0044 }
            int r7 = r2.available()     // Catch:{ IOException -> 0x0041 }
            byte[] r5 = new byte[r7]     // Catch:{ IOException -> 0x0041 }
            r0 = 0
        L_0x0028:
            if (r0 >= r7) goto L_0x0032
            int r1 = r7 - r0
            int r1 = r2.read(r5, r0, r1)     // Catch:{ IOException -> 0x0041 }
            int r0 = r0 + r1
            goto L_0x0028
        L_0x0032:
            r2.close()     // Catch:{ IOException -> 0x0041 }
            com.tencent.android.tpns.mqtt.internal.MqttPersistentData r0 = new com.tencent.android.tpns.mqtt.internal.MqttPersistentData     // Catch:{ IOException -> 0x0041 }
            r6 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r3 = r0
            r4 = r12
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ IOException -> 0x0041 }
            return r0
        L_0x0041:
            r12 = move-exception
            r0 = r2
            goto L_0x0045
        L_0x0044:
            r12 = move-exception
        L_0x0045:
            if (r0 == 0) goto L_0x004a
            r0.close()     // Catch:{ IOException -> 0x004a }
        L_0x004a:
            com.tencent.android.tpns.mqtt.MqttPersistenceException r0 = new com.tencent.android.tpns.mqtt.MqttPersistenceException
            r0.<init>((java.lang.Throwable) r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpns.mqtt.persist.MqttDefaultFilePersistence.get(java.lang.String):com.tencent.android.tpns.mqtt.MqttPersistable");
    }

    public Enumeration keys() throws MqttPersistenceException {
        checkIsOpen();
        File[] files = getFiles();
        Vector vector = new Vector(files.length);
        for (File name : files) {
            String name2 = name.getName();
            vector.addElement(name2.substring(0, name2.length() - 4));
        }
        return vector.elements();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:29|30|(2:32|(1:34))|35|36|37|38|39) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0096 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void open(java.lang.String r6, java.lang.String r7) throws com.tencent.android.tpns.mqtt.MqttPersistenceException {
        /*
            r5 = this;
            java.io.File r0 = r5.dataDir
            boolean r0 = r0.exists()
            if (r0 == 0) goto L_0x0017
            java.io.File r0 = r5.dataDir
            boolean r0 = r0.isDirectory()
            if (r0 == 0) goto L_0x0011
            goto L_0x0017
        L_0x0011:
            com.tencent.android.tpns.mqtt.MqttPersistenceException r6 = new com.tencent.android.tpns.mqtt.MqttPersistenceException
            r6.<init>()
            throw r6
        L_0x0017:
            java.io.File r0 = r5.dataDir
            boolean r0 = r0.exists()
            if (r0 != 0) goto L_0x002e
            java.io.File r0 = r5.dataDir
            boolean r0 = r0.mkdirs()
            if (r0 == 0) goto L_0x0028
            goto L_0x002e
        L_0x0028:
            com.tencent.android.tpns.mqtt.MqttPersistenceException r6 = new com.tencent.android.tpns.mqtt.MqttPersistenceException
            r6.<init>()
            throw r6
        L_0x002e:
            java.io.File r0 = r5.dataDir
            boolean r0 = r0.canWrite()
            if (r0 == 0) goto L_0x00a0
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            r1 = 0
            r2 = r1
        L_0x003d:
            int r3 = r6.length()
            if (r2 >= r3) goto L_0x0053
            char r3 = r6.charAt(r2)
            boolean r4 = r5.isSafeChar(r3)
            if (r4 == 0) goto L_0x0050
            r0.append(r3)
        L_0x0050:
            int r2 = r2 + 1
            goto L_0x003d
        L_0x0053:
            java.lang.String r6 = "-"
            r0.append(r6)
        L_0x0058:
            int r6 = r7.length()
            if (r1 >= r6) goto L_0x006e
            char r6 = r7.charAt(r1)
            boolean r2 = r5.isSafeChar(r6)
            if (r2 == 0) goto L_0x006b
            r0.append(r6)
        L_0x006b:
            int r1 = r1 + 1
            goto L_0x0058
        L_0x006e:
            monitor-enter(r5)
            java.io.File r6 = r5.clientDir     // Catch:{ all -> 0x009d }
            if (r6 != 0) goto L_0x008b
            java.lang.String r6 = r0.toString()     // Catch:{ all -> 0x009d }
            java.io.File r7 = new java.io.File     // Catch:{ all -> 0x009d }
            java.io.File r0 = r5.dataDir     // Catch:{ all -> 0x009d }
            r7.<init>(r0, r6)     // Catch:{ all -> 0x009d }
            r5.clientDir = r7     // Catch:{ all -> 0x009d }
            boolean r6 = r7.exists()     // Catch:{ all -> 0x009d }
            if (r6 != 0) goto L_0x008b
            java.io.File r6 = r5.clientDir     // Catch:{ all -> 0x009d }
            r6.mkdir()     // Catch:{ all -> 0x009d }
        L_0x008b:
            com.tencent.android.tpns.mqtt.internal.FileLock r6 = new com.tencent.android.tpns.mqtt.internal.FileLock     // Catch:{ all -> 0x0096 }
            java.io.File r7 = r5.clientDir     // Catch:{ all -> 0x0096 }
            java.lang.String r0 = ".lck"
            r6.<init>(r7, r0)     // Catch:{ all -> 0x0096 }
            r5.fileLock = r6     // Catch:{ all -> 0x0096 }
        L_0x0096:
            java.io.File r6 = r5.clientDir     // Catch:{ all -> 0x009d }
            r5.restoreBackups(r6)     // Catch:{ all -> 0x009d }
            monitor-exit(r5)     // Catch:{ all -> 0x009d }
            return
        L_0x009d:
            r6 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x009d }
            throw r6
        L_0x00a0:
            com.tencent.android.tpns.mqtt.MqttPersistenceException r6 = new com.tencent.android.tpns.mqtt.MqttPersistenceException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpns.mqtt.persist.MqttDefaultFilePersistence.open(java.lang.String, java.lang.String):void");
    }

    public void put(String str, MqttPersistable mqttPersistable) throws MqttPersistenceException {
        checkIsOpen();
        File file = this.clientDir;
        File file2 = new File(file, str + MESSAGE_FILE_EXTENSION);
        File file3 = this.clientDir;
        File file4 = new File(file3, str + MESSAGE_FILE_EXTENSION + MESSAGE_BACKUP_FILE_EXTENSION);
        if (file2.exists() && !file2.renameTo(file4)) {
            file4.delete();
            file2.renameTo(file4);
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            fileOutputStream.write(mqttPersistable.getHeaderBytes(), mqttPersistable.getHeaderOffset(), mqttPersistable.getHeaderLength());
            if (mqttPersistable.getPayloadBytes() != null) {
                fileOutputStream.write(mqttPersistable.getPayloadBytes(), mqttPersistable.getPayloadOffset(), mqttPersistable.getPayloadLength());
            }
            fileOutputStream.getFD().sync();
            fileOutputStream.close();
            if (file4.exists()) {
                file4.delete();
            }
            if (file4.exists() && !file4.renameTo(file2)) {
                file2.delete();
                file4.renameTo(file2);
            }
        } catch (IOException e11) {
            throw new MqttPersistenceException((Throwable) e11);
        } catch (Throwable th2) {
            if (file4.exists() && !file4.renameTo(file2)) {
                file2.delete();
                file4.renameTo(file2);
            }
            throw th2;
        }
    }

    public void remove(String str) throws MqttPersistenceException {
        checkIsOpen();
        File file = this.clientDir;
        File file2 = new File(file, str + MESSAGE_FILE_EXTENSION);
        if (file2.exists()) {
            file2.delete();
        }
    }

    public MqttDefaultFilePersistence(String str) {
        this.clientDir = null;
        this.fileLock = null;
        this.dataDir = new File(str);
    }
}
