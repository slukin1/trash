package okio.internal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Pair;
import kotlin.i;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlin.l;
import okio.FileHandle;
import okio.FileMetadata;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
import okio.Sink;
import okio.Source;

public final class ResourceFileSystem extends FileSystem {
    /* access modifiers changed from: private */
    public static final Companion Companion = new Companion((r) null);
    /* access modifiers changed from: private */
    public static final Path ROOT = Path.Companion.get$default(Path.Companion, "/", false, 1, (Object) null);
    /* access modifiers changed from: private */
    public final ClassLoader classLoader;
    private final i roots$delegate;
    private final FileSystem systemFileSystem;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        /* access modifiers changed from: private */
        public final boolean keepPath(Path path) {
            return !StringsKt__StringsJVMKt.u(path.name(), ".class", true);
        }

        public final Path getROOT() {
            return ResourceFileSystem.ROOT;
        }

        public final Path removeBase(Path path, Path path2) {
            return getROOT().resolve(StringsKt__StringsJVMKt.F(StringsKt__StringsKt.A0(path.toString(), path2.toString()), '\\', '/', false, 4, (Object) null));
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ResourceFileSystem(ClassLoader classLoader2, boolean z11, FileSystem fileSystem, int i11, r rVar) {
        this(classLoader2, z11, (i11 & 4) != 0 ? FileSystem.SYSTEM : fileSystem);
    }

    private final Path canonicalizeInternal(Path path) {
        return ROOT.resolve(path, true);
    }

    private final List<Pair<FileSystem, Path>> getRoots() {
        return (List) this.roots$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final List<Pair<FileSystem, Path>> toClasspathRoots(ClassLoader classLoader2) {
        ArrayList<T> list = Collections.list(classLoader2.getResources(""));
        ArrayList arrayList = new ArrayList();
        for (T fileRoot : list) {
            Pair<FileSystem, Path> fileRoot2 = toFileRoot(fileRoot);
            if (fileRoot2 != null) {
                arrayList.add(fileRoot2);
            }
        }
        ArrayList<T> list2 = Collections.list(classLoader2.getResources("META-INF/MANIFEST.MF"));
        ArrayList arrayList2 = new ArrayList();
        for (T jarRoot : list2) {
            Pair<FileSystem, Path> jarRoot2 = toJarRoot(jarRoot);
            if (jarRoot2 != null) {
                arrayList2.add(jarRoot2);
            }
        }
        return CollectionsKt___CollectionsKt.q0(arrayList, arrayList2);
    }

    private final Pair<FileSystem, Path> toFileRoot(URL url) {
        if (!x.b(url.getProtocol(), "file")) {
            return null;
        }
        return l.a(this.systemFileSystem, Path.Companion.get$default(Path.Companion, new File(url.toURI()), false, 1, (Object) null));
    }

    private final Pair<FileSystem, Path> toJarRoot(URL url) {
        int m02;
        String url2 = url.toString();
        if (StringsKt__StringsJVMKt.M(url2, "jar:file:", false, 2, (Object) null) && (m02 = StringsKt__StringsKt.m0(url2, TopicOperation.OPERATION_PAIR_DIVIDER, 0, false, 6, (Object) null)) != -1) {
            return l.a(ZipFilesKt.openZip(Path.Companion.get$default(Path.Companion, new File(URI.create(url2.substring(4, m02))), false, 1, (Object) null), this.systemFileSystem, ResourceFileSystem$toJarRoot$zip$1.INSTANCE), ROOT);
        }
        return null;
    }

    private final String toRelativePath(Path path) {
        return canonicalizeInternal(path).relativeTo(ROOT).toString();
    }

    public Sink appendingSink(Path path, boolean z11) {
        throw new IOException(this + " is read-only");
    }

    public void atomicMove(Path path, Path path2) {
        throw new IOException(this + " is read-only");
    }

    public Path canonicalize(Path path) {
        return canonicalizeInternal(path);
    }

    public void createDirectory(Path path, boolean z11) {
        throw new IOException(this + " is read-only");
    }

    public void createSymlink(Path path, Path path2) {
        throw new IOException(this + " is read-only");
    }

    public void delete(Path path, boolean z11) {
        throw new IOException(this + " is read-only");
    }

    public List<Path> list(Path path) {
        String relativePath = toRelativePath(path);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        boolean z11 = false;
        for (Pair next : getRoots()) {
            FileSystem fileSystem = (FileSystem) next.component1();
            Path path2 = (Path) next.component2();
            try {
                List<Path> list = fileSystem.list(path2.resolve(relativePath));
                ArrayList<Path> arrayList = new ArrayList<>();
                for (T next2 : list) {
                    if (Companion.keepPath((Path) next2)) {
                        arrayList.add(next2);
                    }
                }
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.u(arrayList, 10));
                for (Path removeBase : arrayList) {
                    arrayList2.add(Companion.removeBase(removeBase, path2));
                }
                boolean unused = CollectionsKt__MutableCollectionsKt.A(linkedHashSet, arrayList2);
                z11 = true;
            } catch (IOException unused2) {
            }
        }
        if (z11) {
            return CollectionsKt___CollectionsKt.I0(linkedHashSet);
        }
        throw new FileNotFoundException("file not found: " + path);
    }

    public List<Path> listOrNull(Path path) {
        String relativePath = toRelativePath(path);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<Pair<FileSystem, Path>> it2 = getRoots().iterator();
        boolean z11 = false;
        while (true) {
            ArrayList arrayList = null;
            if (!it2.hasNext()) {
                break;
            }
            Pair next = it2.next();
            Path path2 = (Path) next.component2();
            List<Path> listOrNull = ((FileSystem) next.component1()).listOrNull(path2.resolve(relativePath));
            if (listOrNull != null) {
                ArrayList<Path> arrayList2 = new ArrayList<>();
                for (T next2 : listOrNull) {
                    if (Companion.keepPath((Path) next2)) {
                        arrayList2.add(next2);
                    }
                }
                ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.u(arrayList2, 10));
                for (Path removeBase : arrayList2) {
                    arrayList3.add(Companion.removeBase(removeBase, path2));
                }
                arrayList = arrayList3;
            }
            if (arrayList != null) {
                boolean unused = CollectionsKt__MutableCollectionsKt.A(linkedHashSet, arrayList);
                z11 = true;
            }
        }
        if (z11) {
            return CollectionsKt___CollectionsKt.I0(linkedHashSet);
        }
        return null;
    }

    public FileMetadata metadataOrNull(Path path) {
        if (!Companion.keepPath(path)) {
            return null;
        }
        String relativePath = toRelativePath(path);
        for (Pair next : getRoots()) {
            FileMetadata metadataOrNull = ((FileSystem) next.component1()).metadataOrNull(((Path) next.component2()).resolve(relativePath));
            if (metadataOrNull != null) {
                return metadataOrNull;
            }
        }
        return null;
    }

    public FileHandle openReadOnly(Path path) {
        if (Companion.keepPath(path)) {
            String relativePath = toRelativePath(path);
            for (Pair next : getRoots()) {
                try {
                    return ((FileSystem) next.component1()).openReadOnly(((Path) next.component2()).resolve(relativePath));
                } catch (FileNotFoundException unused) {
                }
            }
            throw new FileNotFoundException("file not found: " + path);
        }
        throw new FileNotFoundException("file not found: " + path);
    }

    public FileHandle openReadWrite(Path path, boolean z11, boolean z12) {
        throw new IOException("resources are not writable");
    }

    public Sink sink(Path path, boolean z11) {
        throw new IOException(this + " is read-only");
    }

    public Source source(Path path) {
        Source source;
        if (Companion.keepPath(path)) {
            Path path2 = ROOT;
            InputStream resourceAsStream = this.classLoader.getResourceAsStream(Path.resolve$default(path2, path, false, 2, (Object) null).relativeTo(path2).toString());
            if (resourceAsStream != null && (source = Okio.source(resourceAsStream)) != null) {
                return source;
            }
            throw new FileNotFoundException("file not found: " + path);
        }
        throw new FileNotFoundException("file not found: " + path);
    }

    public ResourceFileSystem(ClassLoader classLoader2, boolean z11, FileSystem fileSystem) {
        this.classLoader = classLoader2;
        this.systemFileSystem = fileSystem;
        this.roots$delegate = LazyKt__LazyJVMKt.a(new ResourceFileSystem$roots$2(this));
        if (z11) {
            getRoots().size();
        }
    }
}
