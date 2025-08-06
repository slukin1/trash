package okio;

import com.sumsub.sns.internal.fingerprint.infoproviders.q;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.r;
import okio.Path;

public class JvmSystemFileSystem extends FileSystem {
    private final void requireCreate(Path path) {
        if (exists(path)) {
            throw new IOException(path + " already exists.");
        }
    }

    private final void requireExist(Path path) {
        if (!exists(path)) {
            throw new IOException(path + " doesn't exist.");
        }
    }

    public Sink appendingSink(Path path, boolean z11) {
        if (z11) {
            requireExist(path);
        }
        return Okio.sink(path.toFile(), true);
    }

    public void atomicMove(Path path, Path path2) {
        if (!path.toFile().renameTo(path2.toFile())) {
            throw new IOException("failed to move " + path + " to " + path2);
        }
    }

    public Path canonicalize(Path path) {
        File canonicalFile = path.toFile().getCanonicalFile();
        if (canonicalFile.exists()) {
            return Path.Companion.get$default(Path.Companion, canonicalFile, false, 1, (Object) null);
        }
        throw new FileNotFoundException("no such file");
    }

    public void createDirectory(Path path, boolean z11) {
        if (!path.toFile().mkdir()) {
            FileMetadata metadataOrNull = metadataOrNull(path);
            boolean z12 = true;
            if (metadataOrNull == null || !metadataOrNull.isDirectory()) {
                z12 = false;
            }
            if (!z12) {
                throw new IOException("failed to create directory: " + path);
            } else if (z11) {
                throw new IOException(path + " already exists.");
            }
        }
    }

    public void createSymlink(Path path, Path path2) {
        throw new IOException(q.f34641a);
    }

    public void delete(Path path, boolean z11) {
        if (!Thread.interrupted()) {
            File file = path.toFile();
            if (file.delete()) {
                return;
            }
            if (file.exists()) {
                throw new IOException("failed to delete " + path);
            } else if (z11) {
                throw new FileNotFoundException("no such file: " + path);
            }
        } else {
            throw new InterruptedIOException("interrupted");
        }
    }

    public List<Path> list(Path path) {
        return list(path, true);
    }

    public List<Path> listOrNull(Path path) {
        return list(path, false);
    }

    public FileMetadata metadataOrNull(Path path) {
        File file = path.toFile();
        boolean isFile = file.isFile();
        boolean isDirectory = file.isDirectory();
        long lastModified = file.lastModified();
        long length = file.length();
        if (!isFile && !isDirectory && lastModified == 0 && length == 0 && !file.exists()) {
            return null;
        }
        return new FileMetadata(isFile, isDirectory, (Path) null, Long.valueOf(length), (Long) null, Long.valueOf(lastModified), (Long) null, (Map) null, 128, (r) null);
    }

    public FileHandle openReadOnly(Path path) {
        return new JvmFileHandle(false, new RandomAccessFile(path.toFile(), "r"));
    }

    public FileHandle openReadWrite(Path path, boolean z11, boolean z12) {
        if (!z11 || !z12) {
            if (z11) {
                requireCreate(path);
            }
            if (z12) {
                requireExist(path);
            }
            return new JvmFileHandle(true, new RandomAccessFile(path.toFile(), "rw"));
        }
        throw new IllegalArgumentException("Cannot require mustCreate and mustExist at the same time.".toString());
    }

    public Sink sink(Path path, boolean z11) {
        if (z11) {
            requireCreate(path);
        }
        return Okio__JvmOkioKt.sink$default(path.toFile(), false, 1, (Object) null);
    }

    public Source source(Path path) {
        return Okio.source(path.toFile());
    }

    public String toString() {
        return "JvmSystemFileSystem";
    }

    private final List<Path> list(Path path, boolean z11) {
        File file = path.toFile();
        String[] list = file.list();
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (String resolve : list) {
                arrayList.add(path.resolve(resolve));
            }
            CollectionsKt__MutableCollectionsJVMKt.y(arrayList);
            return arrayList;
        } else if (!z11) {
            return null;
        } else {
            if (!file.exists()) {
                throw new FileNotFoundException("no such file: " + path);
            }
            throw new IOException("failed to list " + path);
        }
    }
}
