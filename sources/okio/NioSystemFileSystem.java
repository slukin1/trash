package okio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileTime;
import java.util.Map;
import kotlin.jvm.internal.r;
import okio.Path;

public class NioSystemFileSystem extends JvmSystemFileSystem {
    private final Long zeroToNull(FileTime fileTime) {
        Long valueOf = Long.valueOf(fileTime.toMillis());
        if (valueOf.longValue() != 0) {
            return valueOf;
        }
        return null;
    }

    public void atomicMove(Path path, Path path2) {
        try {
            Files.move(path.toNioPath(), path2.toNioPath(), new CopyOption[]{StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING});
        } catch (NoSuchFileException e11) {
            throw new FileNotFoundException(e11.getMessage());
        } catch (UnsupportedOperationException unused) {
            throw new IOException("atomic move not supported");
        }
    }

    public void createSymlink(Path path, Path path2) {
        Files.createSymbolicLink(path.toNioPath(), path2.toNioPath(), new FileAttribute[0]);
    }

    public FileMetadata metadataOrNull(Path path) {
        return metadataOrNull(path.toNioPath());
    }

    public String toString() {
        return "NioSystemFileSystem";
    }

    public final FileMetadata metadataOrNull(Path path) {
        Long l11 = null;
        try {
            BasicFileAttributes readAttributes = Files.readAttributes(path, BasicFileAttributes.class, new LinkOption[]{LinkOption.NOFOLLOW_LINKS});
            Path readSymbolicLink = readAttributes.isSymbolicLink() ? Files.readSymbolicLink(path) : null;
            boolean isRegularFile = readAttributes.isRegularFile();
            boolean isDirectory = readAttributes.isDirectory();
            Path path2 = readSymbolicLink != null ? Path.Companion.get$default(Path.Companion, readSymbolicLink, false, 1, (Object) null) : null;
            Long valueOf = Long.valueOf(readAttributes.size());
            FileTime creationTime = readAttributes.creationTime();
            Long zeroToNull = creationTime != null ? zeroToNull(creationTime) : null;
            FileTime lastModifiedTime = readAttributes.lastModifiedTime();
            Long zeroToNull2 = lastModifiedTime != null ? zeroToNull(lastModifiedTime) : null;
            FileTime lastAccessTime = readAttributes.lastAccessTime();
            if (lastAccessTime != null) {
                l11 = zeroToNull(lastAccessTime);
            }
            return new FileMetadata(isRegularFile, isDirectory, path2, valueOf, zeroToNull, zeroToNull2, l11, (Map) null, 128, (r) null);
        } catch (FileSystemException | NoSuchFileException unused) {
            return null;
        }
    }
}
