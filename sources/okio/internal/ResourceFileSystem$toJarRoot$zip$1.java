package okio.internal;

import d10.l;
import kotlin.jvm.internal.Lambda;

public final class ResourceFileSystem$toJarRoot$zip$1 extends Lambda implements l<ZipEntry, Boolean> {
    public static final ResourceFileSystem$toJarRoot$zip$1 INSTANCE = new ResourceFileSystem$toJarRoot$zip$1();

    public ResourceFileSystem$toJarRoot$zip$1() {
        super(1);
    }

    public final Boolean invoke(ZipEntry zipEntry) {
        return Boolean.valueOf(ResourceFileSystem.Companion.keepPath(zipEntry.getCanonicalPath()));
    }
}
