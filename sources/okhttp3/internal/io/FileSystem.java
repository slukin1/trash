package okhttp3.internal.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import okio.Okio;
import okio.Sink;
import okio.Source;

public interface FileSystem {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final FileSystem SYSTEM = new Companion.SystemFileSystem();

    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();

        public static final class SystemFileSystem implements FileSystem {
            public Sink appendingSink(File file) throws FileNotFoundException {
                try {
                    return Okio.appendingSink(file);
                } catch (FileNotFoundException unused) {
                    file.getParentFile().mkdirs();
                    return Okio.appendingSink(file);
                }
            }

            public void delete(File file) throws IOException {
                if (!file.delete() && file.exists()) {
                    throw new IOException("failed to delete " + file);
                }
            }

            public void deleteContents(File file) throws IOException {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    int i11 = 0;
                    int length = listFiles.length;
                    while (i11 < length) {
                        File file2 = listFiles[i11];
                        if (file2.isDirectory()) {
                            deleteContents(file2);
                        }
                        if (file2.delete()) {
                            i11++;
                        } else {
                            throw new IOException("failed to delete " + file2);
                        }
                    }
                    return;
                }
                throw new IOException("not a readable directory: " + file);
            }

            public boolean exists(File file) {
                return file.exists();
            }

            public void rename(File file, File file2) throws IOException {
                delete(file2);
                if (!file.renameTo(file2)) {
                    throw new IOException("failed to rename " + file + " to " + file2);
                }
            }

            public Sink sink(File file) throws FileNotFoundException {
                try {
                    return Okio__JvmOkioKt.sink$default(file, false, 1, (Object) null);
                } catch (FileNotFoundException unused) {
                    file.getParentFile().mkdirs();
                    return Okio__JvmOkioKt.sink$default(file, false, 1, (Object) null);
                }
            }

            public long size(File file) {
                return file.length();
            }

            public Source source(File file) throws FileNotFoundException {
                return Okio.source(file);
            }

            public String toString() {
                return "FileSystem.SYSTEM";
            }
        }

        private Companion() {
        }
    }

    Sink appendingSink(File file) throws FileNotFoundException;

    void delete(File file) throws IOException;

    void deleteContents(File file) throws IOException;

    boolean exists(File file);

    void rename(File file, File file2) throws IOException;

    Sink sink(File file) throws FileNotFoundException;

    long size(File file);

    Source source(File file) throws FileNotFoundException;
}
