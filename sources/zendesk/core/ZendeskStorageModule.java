package zendesk.core;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import java.io.File;
import java.util.Locale;
import okhttp3.Cache;

class ZendeskStorageModule {
    private static final String BASE_STORAGE_ADDITIONAL_SDK = "base_storage_additional_sdk";
    public static final String BASE_STORAGE_DISK_LRU = "base_storage_disk_lru";
    private static final String BASE_STORAGE_IDENTITY = "base_storage_identity";
    private static final String BASE_STORAGE_LEGACY_IDENTITY = "base_storage_legacy_identity";
    private static final String BASE_STORAGE_LEGACY_PUSH = "base_storage_legacy_push";
    private static final String BASE_STORAGE_SDK = "base_storage_sdk";
    private static final String BASE_STORAGE_SETTINGS = "base_storage_settings";
    private static final String BELVEDERE_DIR = "belvedere_dir";
    private static final String CACHE_DIR = "cache_dir";
    private static final String DATA_DIR = "data_dir";
    public static final String GSON_SERIALIZER = "gson_serializer";
    private static final String LEGACY_IDENTITY_STORAGE_FILE_NAME = "zendesk-token";
    private static final String LEGACY_PUSH_ID_STORAGE_FILE_NAME = "zendesk-push-token";
    private static final int MAX_CACHE_SIZE = 20971520;
    private static final String STORAGE_BELVEDERE_CACHE;
    private static final String STORAGE_NAME_ADDITIONAL_SDK = "additional_sdk";
    private static final String STORAGE_NAME_CORE_SDK = "sdk";
    private static final String STORAGE_NAME_IDENTITY = "identity";
    private static final String STORAGE_NAME_MEDIA_CACHE = "media_cache";
    private static final String STORAGE_NAME_RESPONSE_CACHE = "response_cache";
    private static final String STORAGE_NAME_SETTINGS = "settings";
    private static final String ZENDESK_DIR_NAME = "zendesk";

    static {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("belvedere-data-v2");
        String str = File.separator;
        sb2.append(str);
        sb2.append("user");
        sb2.append(str);
        sb2.append(ZENDESK_DIR_NAME);
        STORAGE_BELVEDERE_CACHE = sb2.toString();
    }

    private static SharedPreferences getSharedPrefs(Context context, String str) {
        return context.getSharedPreferences(str, 0);
    }

    public static BaseStorage provideAdditionalSdkBaseStorage(Context context, Serializer serializer) {
        return new SharedPreferencesStorage(getSharedPrefs(context, storageName(STORAGE_NAME_ADDITIONAL_SDK)), serializer);
    }

    public static AuthenticationProvider provideAuthProvider(IdentityManager identityManager) {
        return new ZendeskAuthenticationProvider(identityManager);
    }

    public static Cache provideCache(File file) {
        return new Cache(new File(file, storageName(STORAGE_NAME_RESPONSE_CACHE)), 20971520);
    }

    public static CoreSettingsStorage provideCoreSettingsStorage(SettingsStorage settingsStorage) {
        return new ZendeskCoreSettingsStorage(settingsStorage);
    }

    public static BaseStorage provideIdentityBaseStorage(Context context, Serializer serializer) {
        return new SharedPreferencesStorage(getSharedPrefs(context, storageName(STORAGE_NAME_IDENTITY)), serializer);
    }

    public static IdentityManager provideIdentityManager(IdentityStorage identityStorage) {
        return new ZendeskIdentityManager(identityStorage);
    }

    public static IdentityStorage provideIdentityStorage(BaseStorage baseStorage) {
        return new ZendeskIdentityStorage(baseStorage);
    }

    public static SharedPreferencesStorage provideLegacyIdentityBaseStorage(Context context, Serializer serializer) {
        return new SharedPreferencesStorage(getSharedPrefs(context, LEGACY_IDENTITY_STORAGE_FILE_NAME), serializer);
    }

    public static LegacyIdentityMigrator provideLegacyIdentityStorage(SharedPreferencesStorage sharedPreferencesStorage, SharedPreferencesStorage sharedPreferencesStorage2, IdentityStorage identityStorage, IdentityManager identityManager, PushDeviceIdStorage pushDeviceIdStorage) {
        return new LegacyIdentityMigrator(sharedPreferencesStorage, sharedPreferencesStorage2, identityStorage, identityManager, pushDeviceIdStorage);
    }

    public static SharedPreferencesStorage provideLegacyPushBaseStorage(Context context, Serializer serializer) {
        return new SharedPreferencesStorage(getSharedPrefs(context, LEGACY_PUSH_ID_STORAGE_FILE_NAME), serializer);
    }

    public static MachineIdStorage provideMachineIdStorage(Context context) {
        return new ZendeskMachineIdStorage(getSharedPrefs(context, storageName("sdk")));
    }

    public static MemoryCache provideMemoryCache() {
        return new ZendeskLruMemoryCache();
    }

    public static PushDeviceIdStorage providePushDeviceIdStorage(BaseStorage baseStorage) {
        return new ZendeskPushDeviceIdStorage(baseStorage);
    }

    public static BaseStorage provideSdkBaseStorage(Context context, Serializer serializer) {
        return new SharedPreferencesStorage(getSharedPrefs(context, storageName("sdk")), serializer);
    }

    public static Storage provideSdkStorage(SettingsStorage settingsStorage, SessionStorage sessionStorage, BaseStorage baseStorage, MemoryCache memoryCache) {
        return new ZendeskStorage(sessionStorage, settingsStorage, baseStorage, memoryCache);
    }

    public static Serializer provideSerializer(Gson gson) {
        return new GsonSerializer(gson);
    }

    public static SessionStorage provideSessionStorage(IdentityStorage identityStorage, BaseStorage baseStorage, BaseStorage baseStorage2, Cache cache, File file, File file2, File file3) {
        return new ZendeskSessionStorage(identityStorage, baseStorage, cache, baseStorage2, file, file2, file3);
    }

    public static BaseStorage provideSettingsBaseStorage(Context context, Serializer serializer) {
        return new SharedPreferencesStorage(getSharedPrefs(context, storageName(STORAGE_NAME_SETTINGS)), serializer);
    }

    public static SettingsStorage provideSettingsStorage(BaseStorage baseStorage) {
        return new ZendeskSettingsStorage(baseStorage);
    }

    public static File providesBelvedereDir(Context context) {
        return new File(context.getCacheDir(), STORAGE_BELVEDERE_CACHE);
    }

    public static File providesCacheDir(Context context) {
        return new File(context.getCacheDir(), ZENDESK_DIR_NAME);
    }

    public static File providesDataDir(Context context) {
        return new File(context.getFilesDir(), ZENDESK_DIR_NAME);
    }

    public static BaseStorage providesDiskLruStorage(File file, Serializer serializer) {
        return new ZendeskDiskLruCache(new File(file, storageName(STORAGE_NAME_MEDIA_CACHE)), serializer, MAX_CACHE_SIZE);
    }

    private static String storageName(String str) {
        return String.format(Locale.US, "zendesk_%s", new Object[]{str});
    }
}
