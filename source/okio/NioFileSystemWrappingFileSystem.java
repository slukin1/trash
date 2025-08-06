package okio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.nio.channels.FileChannel;
import java.nio.file.CopyOption;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.Reflection;
import okio.Path;

public final class NioFileSystemWrappingFileSystem extends NioSystemFileSystem {
    private final FileSystem nioFileSystem;

    public NioFileSystemWrappingFileSystem(FileSystem fileSystem) {
        this.nioFileSystem = fileSystem;
    }

    private final Path resolve(Path path) {
        return this.nioFileSystem.getPath(path.toString(), new String[0]);
    }

    public Sink appendingSink(Path path, boolean z11) {
        List c11 = CollectionsKt__CollectionsJVMKt.c();
        c11.add(StandardOpenOption.APPEND);
        if (!z11) {
            c11.add(StandardOpenOption.CREATE);
        }
        List a11 = CollectionsKt__CollectionsJVMKt.a(c11);
        Path resolve = resolve(path);
        StandardOpenOption[] standardOpenOptionArr = (StandardOpenOption[]) a11.toArray(new StandardOpenOption[0]);
        OpenOption[] openOptionArr = (OpenOption[]) Arrays.copyOf(standardOpenOptionArr, standardOpenOptionArr.length);
        return Okio.sink(Files.newOutputStream(resolve, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)));
    }

    public void atomicMove(Path path, Path path2) {
        try {
            Files.move(resolve(path), resolve(path2), (CopyOption[]) Arrays.copyOf(new CopyOption[]{StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING}, 2));
        } catch (NoSuchFileException e11) {
            throw new FileNotFoundException(e11.getMessage());
        } catch (UnsupportedOperationException unused) {
            throw new IOException("atomic move not supported");
        }
    }

    public Path canonicalize(Path path) {
        try {
            return Path.Companion.get$default(Path.Companion, resolve(path).toRealPath(new LinkOption[0]), false, 1, (Object) null);
        } catch (NoSuchFileException unused) {
            throw new FileNotFoundException("no such file: " + path);
        }
    }

    public void createDirectory(Path path, boolean z11) {
        FileMetadata metadataOrNull = metadataOrNull(path);
        boolean z12 = true;
        if (metadataOrNull == null || !metadataOrNull.isDirectory()) {
            z12 = false;
        }
        if (!z12 || !z11) {
            try {
                Files.createDirectory(resolve(path), (FileAttribute[]) Arrays.copyOf(new FileAttribute[0], 0));
            } catch (IOException e11) {
                if (!z12) {
                    throw new IOException("failed to create directory: " + path, e11);
                }
            }
        } else {
            throw new IOException(path + " already exists.");
        }
    }

    public void createSymlink(Path path, Path path2) {
        Files.createSymbolicLink(resolve(path), resolve(path2), (FileAttribute[]) Arrays.copyOf(new FileAttribute[0], 0));
    }

    public void delete(Path path, boolean z11) {
        if (!Thread.interrupted()) {
            java.nio.file.Path resolve = resolve(path);
            try {
                Files.delete(resolve);
            } catch (NoSuchFileException unused) {
                if (z11) {
                    throw new FileNotFoundException("no such file: " + path);
                }
            } catch (IOException unused2) {
                if (Files.exists(resolve, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0))) {
                    throw new IOException("failed to delete " + path);
                }
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
        return metadataOrNull(resolve(path));
    }

    public FileHandle openReadOnly(Path path) {
        try {
            return new NioFileSystemFileHandle(false, FileChannel.open(resolve(path), new OpenOption[]{StandardOpenOption.READ}));
        } catch (NoSuchFileException unused) {
            throw new FileNotFoundException("no such file: " + path);
        }
    }

    public FileHandle openReadWrite(Path path, boolean z11, boolean z12) {
        if (!z11 || !z12) {
            List c11 = CollectionsKt__CollectionsJVMKt.c();
            c11.add(StandardOpenOption.READ);
            c11.add(StandardOpenOption.WRITE);
            if (z11) {
                c11.add(StandardOpenOption.CREATE_NEW);
            } else if (!z12) {
                c11.add(StandardOpenOption.CREATE);
            }
            List a11 = CollectionsKt__CollectionsJVMKt.a(c11);
            try {
                java.nio.file.Path resolve = resolve(path);
                StandardOpenOption[] standardOpenOptionArr = (StandardOpenOption[]) a11.toArray(new StandardOpenOption[0]);
                return new NioFileSystemFileHandle(true, FileChannel.open(resolve, (OpenOption[]) Arrays.copyOf(standardOpenOptionArr, standardOpenOptionArr.length)));
            } catch (NoSuchFileException unused) {
                throw new FileNotFoundException("no such file: " + path);
            }
        } else {
            throw new IllegalArgumentException("Cannot require mustCreate and mustExist at the same time.".toString());
        }
    }

    public Sink sink(Path path, boolean z11) {
        List c11 = CollectionsKt__CollectionsJVMKt.c();
        if (z11) {
            c11.add(StandardOpenOption.CREATE_NEW);
        }
        List a11 = CollectionsKt__CollectionsJVMKt.a(c11);
        try {
            java.nio.file.Path resolve = resolve(path);
            StandardOpenOption[] standardOpenOptionArr = (StandardOpenOption[]) a11.toArray(new StandardOpenOption[0]);
            OpenOption[] openOptionArr = (OpenOption[]) Arrays.copyOf(standardOpenOptionArr, standardOpenOptionArr.length);
            return Okio.sink(Files.newOutputStream(resolve, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)));
        } catch (NoSuchFileException unused) {
            throw new FileNotFoundException("no such file: " + path);
        }
    }

    public Source source(Path path) {
        try {
            return Okio.source(Files.newInputStream(resolve(path), (OpenOption[]) Arrays.copyOf(new OpenOption[0], 0)));
        } catch (NoSuchFileException unused) {
            throw new FileNotFoundException("no such file: " + path);
        }
    }

    public String toString() {
        return Reflection.b(this.nioFileSystem.getClass()).f();
    }

    private final List<Path> list(Path path, boolean z11) {
        java.nio.file.Path resolve = resolve(path);
        try {
            List<java.nio.file.Path> p11 = PathsKt__PathUtilsKt.p(resolve, (String) null, 1, (Object) null);
            ArrayList arrayList = new ArrayList();
            for (java.nio.file.Path path2 : p11) {
                arrayList.add(Path.Companion.get$default(Path.Companion, path2, false, 1, (Object) null));
            }
            CollectionsKt__MutableCollectionsJVMKt.y(arrayList);
            return arrayList;
        } catch (Exception unused) {
            if (!z11) {
                return null;
            }
            if (!Files.exists(resolve, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0))) {
                throw new FileNotFoundException("no such file: " + path);
            }
            throw new IOException("failed to list " + path);
        }
    }
}
