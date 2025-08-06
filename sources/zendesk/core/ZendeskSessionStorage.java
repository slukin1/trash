package zendesk.core;

import com.zendesk.logger.Logger;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mz.a;
import okhttp3.Cache;

class ZendeskSessionStorage implements SessionStorage {
    private static final String LOG_TAG = "SessionStorage";
    private final BaseStorage additionalSdkStorage;
    private final IdentityStorage identityStorage;
    private final BaseStorage mediaCache;
    private final List<File> registeredFolders;
    private final Cache responseCache;
    private final File zendeskCacheDir;
    private final File zendeskDataDir;

    public ZendeskSessionStorage(IdentityStorage identityStorage2, BaseStorage baseStorage, Cache cache, BaseStorage baseStorage2, File file, File file2, File file3) {
        this.identityStorage = identityStorage2;
        this.additionalSdkStorage = baseStorage;
        this.responseCache = cache;
        this.zendeskCacheDir = file;
        this.zendeskDataDir = file2;
        this.mediaCache = baseStorage2;
        this.registeredFolders = new ArrayList(Arrays.asList(new File[]{file, file2, file3}));
    }

    private static void clearDirectory(File file) {
        if (file != null && file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && file.isDirectory() && a.j(listFiles)) {
                for (File clearDirectory : listFiles) {
                    clearDirectory(clearDirectory);
                }
            }
            file.delete();
        }
    }

    private File createDirIfNotExists(File file) {
        if (file.exists()) {
            Logger.b(LOG_TAG, "Created dir %s, success: %s", file.getAbsolutePath(), Boolean.valueOf(file.mkdirs()));
        }
        return file;
    }

    public void clear() {
        this.identityStorage.clear();
        this.additionalSdkStorage.clear();
        this.mediaCache.clear();
        try {
            this.responseCache.evictAll();
        } catch (IOException unused) {
        }
        for (File clearDirectory : this.registeredFolders) {
            clearDirectory(clearDirectory);
        }
    }

    public BaseStorage getAdditionalSdkStorage() {
        return this.additionalSdkStorage;
    }

    public File getZendeskCacheDir() {
        return createDirIfNotExists(this.zendeskCacheDir);
    }

    public File getZendeskDataDir() {
        return createDirIfNotExists(this.zendeskDataDir);
    }
}
