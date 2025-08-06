package okio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.g;

public abstract class ForwardingFileSystem extends FileSystem {
    private final FileSystem delegate;

    public ForwardingFileSystem(FileSystem fileSystem) {
        this.delegate = fileSystem;
    }

    public Sink appendingSink(Path path, boolean z11) throws IOException {
        return this.delegate.appendingSink(onPathParameter(path, "appendingSink", "file"), z11);
    }

    public void atomicMove(Path path, Path path2) throws IOException {
        this.delegate.atomicMove(onPathParameter(path, "atomicMove", "source"), onPathParameter(path2, "atomicMove", "target"));
    }

    public Path canonicalize(Path path) throws IOException {
        return onPathResult(this.delegate.canonicalize(onPathParameter(path, "canonicalize", "path")), "canonicalize");
    }

    public void createDirectory(Path path, boolean z11) throws IOException {
        this.delegate.createDirectory(onPathParameter(path, "createDirectory", "dir"), z11);
    }

    public void createSymlink(Path path, Path path2) throws IOException {
        this.delegate.createSymlink(onPathParameter(path, "createSymlink", "source"), onPathParameter(path2, "createSymlink", "target"));
    }

    public final FileSystem delegate() {
        return this.delegate;
    }

    public void delete(Path path, boolean z11) throws IOException {
        this.delegate.delete(onPathParameter(path, "delete", "path"), z11);
    }

    public List<Path> list(Path path) throws IOException {
        List<Path> list = this.delegate.list(onPathParameter(path, "list", "dir"));
        ArrayList arrayList = new ArrayList();
        for (Path onPathResult : list) {
            arrayList.add(onPathResult(onPathResult, "list"));
        }
        CollectionsKt__MutableCollectionsJVMKt.y(arrayList);
        return arrayList;
    }

    public List<Path> listOrNull(Path path) {
        List<Path> listOrNull = this.delegate.listOrNull(onPathParameter(path, "listOrNull", "dir"));
        if (listOrNull == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Path onPathResult : listOrNull) {
            arrayList.add(onPathResult(onPathResult, "listOrNull"));
        }
        CollectionsKt__MutableCollectionsJVMKt.y(arrayList);
        return arrayList;
    }

    public g<Path> listRecursively(Path path, boolean z11) {
        return SequencesKt___SequencesKt.s(this.delegate.listRecursively(onPathParameter(path, "listRecursively", "dir"), z11), new ForwardingFileSystem$listRecursively$1(this));
    }

    public FileMetadata metadataOrNull(Path path) throws IOException {
        FileMetadata metadataOrNull = this.delegate.metadataOrNull(onPathParameter(path, "metadataOrNull", "path"));
        if (metadataOrNull == null) {
            return null;
        }
        if (metadataOrNull.getSymlinkTarget() == null) {
            return metadataOrNull;
        }
        return FileMetadata.copy$default(metadataOrNull, false, false, onPathResult(metadataOrNull.getSymlinkTarget(), "metadataOrNull"), (Long) null, (Long) null, (Long) null, (Long) null, (Map) null, 251, (Object) null);
    }

    public Path onPathParameter(Path path, String str, String str2) {
        return path;
    }

    public Path onPathResult(Path path, String str) {
        return path;
    }

    public FileHandle openReadOnly(Path path) throws IOException {
        return this.delegate.openReadOnly(onPathParameter(path, "openReadOnly", "file"));
    }

    public FileHandle openReadWrite(Path path, boolean z11, boolean z12) throws IOException {
        return this.delegate.openReadWrite(onPathParameter(path, "openReadWrite", "file"), z11, z12);
    }

    public Sink sink(Path path, boolean z11) throws IOException {
        return this.delegate.sink(onPathParameter(path, "sink", "file"), z11);
    }

    public Source source(Path path) throws IOException {
        return this.delegate.source(onPathParameter(path, "source", "file"));
    }

    public String toString() {
        return Reflection.b(getClass()).f() + '(' + this.delegate + ')';
    }
}
