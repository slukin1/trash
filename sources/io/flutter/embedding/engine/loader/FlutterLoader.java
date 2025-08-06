package io.flutter.embedding.engine.loader;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.WindowManager;
import io.flutter.FlutterInjector;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.util.HandlerCompat;
import io.flutter.util.PathUtils;
import io.flutter.util.TraceSection;
import io.flutter.view.VsyncWaiter;
import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class FlutterLoader {
    public static final String AOT_SHARED_LIBRARY_NAME = "aot-shared-library-name";
    public static final String AOT_VMSERVICE_SHARED_LIBRARY_NAME = "aot-vmservice-shared-library-name";
    public static final String AUTOMATICALLY_REGISTER_PLUGINS_KEY = "automatically-register-plugins";
    private static final String DEFAULT_KERNEL_BLOB = "kernel_blob.bin";
    private static final String DEFAULT_LIBRARY = "libflutter.so";
    private static final String ENABLE_IMPELLER_META_DATA_KEY = "io.flutter.embedding.android.EnableImpeller";
    private static final String ENABLE_SKPARAGRAPH_META_DATA_KEY = "io.flutter.embedding.android.EnableSkParagraph";
    public static final String FLUTTER_ASSETS_DIR_KEY = "flutter-assets-dir";
    public static final String ISOLATE_SNAPSHOT_DATA_KEY = "isolate-snapshot-data";
    private static final String LEAK_VM_META_DATA_KEY = "io.flutter.embedding.android.LeakVM";
    private static final String OLD_GEN_HEAP_SIZE_META_DATA_KEY = "io.flutter.embedding.android.OldGenHeapSize";
    public static final String SNAPSHOT_ASSET_PATH_KEY = "snapshot-asset-path";
    private static final String TAG = "FlutterLoader";
    private static final String VMSERVICE_SNAPSHOT_LIBRARY = "libvmservice_snapshot.so";
    public static final String VM_SNAPSHOT_DATA_KEY = "vm-snapshot-data";
    private static FlutterLoader instance;
    /* access modifiers changed from: private */
    public ExecutorService executorService;
    private FlutterApplicationInfo flutterApplicationInfo;
    /* access modifiers changed from: private */
    public FlutterJNI flutterJNI;
    public Future<InitResult> initResultFuture;
    private long initStartTimestampMillis;
    private boolean initialized;
    private Settings settings;

    public static class InitResult {
        public final String appStoragePath;
        public final String dataDirPath;
        public final String engineCachesPath;

        private InitResult(String str, String str2, String str3) {
            this.appStoragePath = str;
            this.engineCachesPath = str2;
            this.dataDirPath = str3;
        }
    }

    public static class Settings {
        private String logTag;

        public String getLogTag() {
            return this.logTag;
        }

        public void setLogTag(String str) {
            this.logTag = str;
        }
    }

    public FlutterLoader() {
        this(FlutterInjector.instance().getFlutterJNIFactory().provideFlutterJNI());
    }

    private String fullAssetPathFrom(String str) {
        return this.flutterApplicationInfo.flutterAssetsDir + File.separator + str;
    }

    /* access modifiers changed from: private */
    public ResourceExtractor initResources(Context context) {
        return null;
    }

    private static boolean isLeakVM(Bundle bundle) {
        if (bundle == null) {
            return true;
        }
        return bundle.getBoolean(LEAK_VM_META_DATA_KEY, true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$ensureInitializationCompleteAsync$0(Context context, String[] strArr, Handler handler, Runnable runnable) {
        ensureInitializationComplete(context.getApplicationContext(), strArr);
        handler.post(runnable);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$ensureInitializationCompleteAsync$1(Context context, String[] strArr, Handler handler, Runnable runnable) {
        try {
            InitResult initResult = this.initResultFuture.get();
            HandlerCompat.createAsyncHandler(Looper.getMainLooper()).post(new b(this, context, strArr, handler, runnable));
        } catch (Exception e11) {
            Log.e(TAG, "Flutter initialization failed.", e11);
            throw new RuntimeException(e11);
        }
    }

    public boolean automaticallyRegisterPlugins() {
        return this.flutterApplicationInfo.automaticallyRegisterPlugins;
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0190 A[Catch:{ Exception -> 0x01cd, all -> 0x01cb }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0193 A[Catch:{ Exception -> 0x01cd, all -> 0x01cb }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void ensureInitializationComplete(android.content.Context r10, java.lang.String[] r11) {
        /*
            r9 = this;
            java.lang.String r0 = "--aot-shared-library-name="
            boolean r1 = r9.initialized
            if (r1 == 0) goto L_0x0007
            return
        L_0x0007:
            android.os.Looper r1 = android.os.Looper.myLooper()
            android.os.Looper r2 = android.os.Looper.getMainLooper()
            if (r1 != r2) goto L_0x01e7
            io.flutter.embedding.engine.loader.FlutterLoader$Settings r1 = r9.settings
            if (r1 == 0) goto L_0x01df
            java.lang.String r1 = "FlutterLoader#ensureInitializationComplete"
            io.flutter.util.TraceSection.begin(r1)
            java.util.concurrent.Future<io.flutter.embedding.engine.loader.FlutterLoader$InitResult> r1 = r9.initResultFuture     // Catch:{ Exception -> 0x01cd }
            java.lang.Object r1 = r1.get()     // Catch:{ Exception -> 0x01cd }
            io.flutter.embedding.engine.loader.FlutterLoader$InitResult r1 = (io.flutter.embedding.engine.loader.FlutterLoader.InitResult) r1     // Catch:{ Exception -> 0x01cd }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception -> 0x01cd }
            r2.<init>()     // Catch:{ Exception -> 0x01cd }
            java.lang.String r3 = "--icu-symbol-prefix=_binary_icudtl_dat"
            r2.add(r3)     // Catch:{ Exception -> 0x01cd }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01cd }
            r3.<init>()     // Catch:{ Exception -> 0x01cd }
            java.lang.String r4 = "--icu-native-lib-path="
            r3.append(r4)     // Catch:{ Exception -> 0x01cd }
            io.flutter.embedding.engine.loader.FlutterApplicationInfo r4 = r9.flutterApplicationInfo     // Catch:{ Exception -> 0x01cd }
            java.lang.String r4 = r4.nativeLibraryDir     // Catch:{ Exception -> 0x01cd }
            r3.append(r4)     // Catch:{ Exception -> 0x01cd }
            java.lang.String r4 = java.io.File.separator     // Catch:{ Exception -> 0x01cd }
            r3.append(r4)     // Catch:{ Exception -> 0x01cd }
            java.lang.String r5 = "libflutter.so"
            r3.append(r5)     // Catch:{ Exception -> 0x01cd }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x01cd }
            r2.add(r3)     // Catch:{ Exception -> 0x01cd }
            if (r11 == 0) goto L_0x0053
            java.util.Collections.addAll(r2, r11)     // Catch:{ Exception -> 0x01cd }
        L_0x0053:
            r3 = 0
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01cd }
            r11.<init>()     // Catch:{ Exception -> 0x01cd }
            r11.append(r0)     // Catch:{ Exception -> 0x01cd }
            io.flutter.embedding.engine.loader.FlutterApplicationInfo r5 = r9.flutterApplicationInfo     // Catch:{ Exception -> 0x01cd }
            java.lang.String r5 = r5.aotSharedLibraryName     // Catch:{ Exception -> 0x01cd }
            r11.append(r5)     // Catch:{ Exception -> 0x01cd }
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x01cd }
            r2.add(r11)     // Catch:{ Exception -> 0x01cd }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01cd }
            r11.<init>()     // Catch:{ Exception -> 0x01cd }
            r11.append(r0)     // Catch:{ Exception -> 0x01cd }
            io.flutter.embedding.engine.loader.FlutterApplicationInfo r0 = r9.flutterApplicationInfo     // Catch:{ Exception -> 0x01cd }
            java.lang.String r0 = r0.nativeLibraryDir     // Catch:{ Exception -> 0x01cd }
            r11.append(r0)     // Catch:{ Exception -> 0x01cd }
            r11.append(r4)     // Catch:{ Exception -> 0x01cd }
            io.flutter.embedding.engine.loader.FlutterApplicationInfo r0 = r9.flutterApplicationInfo     // Catch:{ Exception -> 0x01cd }
            java.lang.String r0 = r0.aotSharedLibraryName     // Catch:{ Exception -> 0x01cd }
            r11.append(r0)     // Catch:{ Exception -> 0x01cd }
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x01cd }
            r2.add(r11)     // Catch:{ Exception -> 0x01cd }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01cd }
            r11.<init>()     // Catch:{ Exception -> 0x01cd }
            java.lang.String r0 = "--cache-dir-path="
            r11.append(r0)     // Catch:{ Exception -> 0x01cd }
            java.lang.String r0 = r1.engineCachesPath     // Catch:{ Exception -> 0x01cd }
            r11.append(r0)     // Catch:{ Exception -> 0x01cd }
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x01cd }
            r2.add(r11)     // Catch:{ Exception -> 0x01cd }
            io.flutter.embedding.engine.loader.FlutterApplicationInfo r11 = r9.flutterApplicationInfo     // Catch:{ Exception -> 0x01cd }
            java.lang.String r11 = r11.domainNetworkPolicy     // Catch:{ Exception -> 0x01cd }
            if (r11 == 0) goto L_0x00be
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01cd }
            r11.<init>()     // Catch:{ Exception -> 0x01cd }
            java.lang.String r0 = "--domain-network-policy="
            r11.append(r0)     // Catch:{ Exception -> 0x01cd }
            io.flutter.embedding.engine.loader.FlutterApplicationInfo r0 = r9.flutterApplicationInfo     // Catch:{ Exception -> 0x01cd }
            java.lang.String r0 = r0.domainNetworkPolicy     // Catch:{ Exception -> 0x01cd }
            r11.append(r0)     // Catch:{ Exception -> 0x01cd }
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x01cd }
            r2.add(r11)     // Catch:{ Exception -> 0x01cd }
        L_0x00be:
            io.flutter.embedding.engine.loader.FlutterLoader$Settings r11 = r9.settings     // Catch:{ Exception -> 0x01cd }
            java.lang.String r11 = r11.getLogTag()     // Catch:{ Exception -> 0x01cd }
            if (r11 == 0) goto L_0x00e0
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01cd }
            r11.<init>()     // Catch:{ Exception -> 0x01cd }
            java.lang.String r0 = "--log-tag="
            r11.append(r0)     // Catch:{ Exception -> 0x01cd }
            io.flutter.embedding.engine.loader.FlutterLoader$Settings r0 = r9.settings     // Catch:{ Exception -> 0x01cd }
            java.lang.String r0 = r0.getLogTag()     // Catch:{ Exception -> 0x01cd }
            r11.append(r0)     // Catch:{ Exception -> 0x01cd }
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x01cd }
            r2.add(r11)     // Catch:{ Exception -> 0x01cd }
        L_0x00e0:
            android.content.pm.PackageManager r11 = r10.getPackageManager()     // Catch:{ Exception -> 0x01cd }
            java.lang.String r0 = r10.getPackageName()     // Catch:{ Exception -> 0x01cd }
            r4 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r11 = r11.getApplicationInfo(r0, r4)     // Catch:{ Exception -> 0x01cd }
            android.os.Bundle r11 = r11.metaData     // Catch:{ Exception -> 0x01cd }
            r0 = 0
            if (r11 == 0) goto L_0x00fa
            java.lang.String r4 = "io.flutter.embedding.android.OldGenHeapSize"
            int r4 = r11.getInt(r4)     // Catch:{ Exception -> 0x01cd }
            goto L_0x00fb
        L_0x00fa:
            r4 = r0
        L_0x00fb:
            if (r4 != 0) goto L_0x011a
            java.lang.String r4 = "activity"
            java.lang.Object r4 = r10.getSystemService(r4)     // Catch:{ Exception -> 0x01cd }
            android.app.ActivityManager r4 = (android.app.ActivityManager) r4     // Catch:{ Exception -> 0x01cd }
            android.app.ActivityManager$MemoryInfo r5 = new android.app.ActivityManager$MemoryInfo     // Catch:{ Exception -> 0x01cd }
            r5.<init>()     // Catch:{ Exception -> 0x01cd }
            r4.getMemoryInfo(r5)     // Catch:{ Exception -> 0x01cd }
            long r4 = r5.totalMem     // Catch:{ Exception -> 0x01cd }
            double r4 = (double) r4     // Catch:{ Exception -> 0x01cd }
            r6 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r4 = r4 / r6
            r6 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r4 = r4 / r6
            int r4 = (int) r4     // Catch:{ Exception -> 0x01cd }
        L_0x011a:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01cd }
            r5.<init>()     // Catch:{ Exception -> 0x01cd }
            java.lang.String r6 = "--old-gen-heap-size="
            r5.append(r6)     // Catch:{ Exception -> 0x01cd }
            r5.append(r4)     // Catch:{ Exception -> 0x01cd }
            java.lang.String r4 = r5.toString()     // Catch:{ Exception -> 0x01cd }
            r2.add(r4)     // Catch:{ Exception -> 0x01cd }
            android.content.res.Resources r4 = r10.getResources()     // Catch:{ Exception -> 0x01cd }
            android.util.DisplayMetrics r4 = r4.getDisplayMetrics()     // Catch:{ Exception -> 0x01cd }
            int r5 = r4.widthPixels     // Catch:{ Exception -> 0x01cd }
            int r4 = r4.heightPixels     // Catch:{ Exception -> 0x01cd }
            int r5 = r5 * r4
            int r5 = r5 * 12
            int r5 = r5 * 4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01cd }
            r4.<init>()     // Catch:{ Exception -> 0x01cd }
            java.lang.String r6 = "--resource-cache-max-bytes-threshold="
            r4.append(r6)     // Catch:{ Exception -> 0x01cd }
            r4.append(r5)     // Catch:{ Exception -> 0x01cd }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x01cd }
            r2.add(r4)     // Catch:{ Exception -> 0x01cd }
            java.lang.String r4 = "--prefetched-default-font-manager"
            r2.add(r4)     // Catch:{ Exception -> 0x01cd }
            r8 = 1
            if (r11 == 0) goto L_0x0166
            java.lang.String r4 = "io.flutter.embedding.android.EnableSkParagraph"
            boolean r4 = r11.getBoolean(r4, r8)     // Catch:{ Exception -> 0x01cd }
            if (r4 == 0) goto L_0x0164
            goto L_0x0166
        L_0x0164:
            r4 = r0
            goto L_0x0167
        L_0x0166:
            r4 = r8
        L_0x0167:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01cd }
            r5.<init>()     // Catch:{ Exception -> 0x01cd }
            java.lang.String r6 = "--enable-skparagraph="
            r5.append(r6)     // Catch:{ Exception -> 0x01cd }
            r5.append(r4)     // Catch:{ Exception -> 0x01cd }
            java.lang.String r4 = r5.toString()     // Catch:{ Exception -> 0x01cd }
            r2.add(r4)     // Catch:{ Exception -> 0x01cd }
            if (r11 == 0) goto L_0x018a
            java.lang.String r4 = "io.flutter.embedding.android.EnableImpeller"
            boolean r4 = r11.getBoolean(r4, r0)     // Catch:{ Exception -> 0x01cd }
            if (r4 == 0) goto L_0x018a
            java.lang.String r4 = "--enable-impeller"
            r2.add(r4)     // Catch:{ Exception -> 0x01cd }
        L_0x018a:
            boolean r11 = isLeakVM(r11)     // Catch:{ Exception -> 0x01cd }
            if (r11 == 0) goto L_0x0193
            java.lang.String r11 = "true"
            goto L_0x0195
        L_0x0193:
            java.lang.String r11 = "false"
        L_0x0195:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01cd }
            r4.<init>()     // Catch:{ Exception -> 0x01cd }
            java.lang.String r5 = "--leak-vm="
            r4.append(r5)     // Catch:{ Exception -> 0x01cd }
            r4.append(r11)     // Catch:{ Exception -> 0x01cd }
            java.lang.String r11 = r4.toString()     // Catch:{ Exception -> 0x01cd }
            r2.add(r11)     // Catch:{ Exception -> 0x01cd }
            long r4 = android.os.SystemClock.uptimeMillis()     // Catch:{ Exception -> 0x01cd }
            long r6 = r9.initStartTimestampMillis     // Catch:{ Exception -> 0x01cd }
            long r6 = r4 - r6
            io.flutter.embedding.engine.FlutterJNI r11 = r9.flutterJNI     // Catch:{ Exception -> 0x01cd }
            java.lang.String[] r0 = new java.lang.String[r0]     // Catch:{ Exception -> 0x01cd }
            java.lang.Object[] r0 = r2.toArray(r0)     // Catch:{ Exception -> 0x01cd }
            r2 = r0
            java.lang.String[] r2 = (java.lang.String[]) r2     // Catch:{ Exception -> 0x01cd }
            java.lang.String r4 = r1.appStoragePath     // Catch:{ Exception -> 0x01cd }
            java.lang.String r5 = r1.engineCachesPath     // Catch:{ Exception -> 0x01cd }
            r0 = r11
            r1 = r10
            r0.init(r1, r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x01cd }
            r9.initialized = r8     // Catch:{ Exception -> 0x01cd }
            io.flutter.util.TraceSection.end()
            return
        L_0x01cb:
            r10 = move-exception
            goto L_0x01db
        L_0x01cd:
            r10 = move-exception
            java.lang.String r11 = "FlutterLoader"
            java.lang.String r0 = "Flutter initialization failed."
            io.flutter.Log.e(r11, r0, r10)     // Catch:{ all -> 0x01cb }
            java.lang.RuntimeException r11 = new java.lang.RuntimeException     // Catch:{ all -> 0x01cb }
            r11.<init>(r10)     // Catch:{ all -> 0x01cb }
            throw r11     // Catch:{ all -> 0x01cb }
        L_0x01db:
            io.flutter.util.TraceSection.end()
            throw r10
        L_0x01df:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "ensureInitializationComplete must be called after startInitialization"
            r10.<init>(r11)
            throw r10
        L_0x01e7:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "ensureInitializationComplete must be called on the main thread"
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.engine.loader.FlutterLoader.ensureInitializationComplete(android.content.Context, java.lang.String[]):void");
    }

    public void ensureInitializationCompleteAsync(Context context, String[] strArr, Handler handler, Runnable runnable) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("ensureInitializationComplete must be called on the main thread");
        } else if (this.settings == null) {
            throw new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
        } else if (this.initialized) {
            handler.post(runnable);
        } else {
            this.executorService.execute(new a(this, context, strArr, handler, runnable));
        }
    }

    public String findAppBundlePath() {
        return this.flutterApplicationInfo.flutterAssetsDir;
    }

    public String getLookupKeyForAsset(String str) {
        return fullAssetPathFrom(str);
    }

    public boolean initialized() {
        return this.initialized;
    }

    public void startInitialization(Context context) {
        startInitialization(context, new Settings());
    }

    public FlutterLoader(FlutterJNI flutterJNI2) {
        this(flutterJNI2, FlutterInjector.instance().executorService());
    }

    public String getLookupKeyForAsset(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("packages");
        String str3 = File.separator;
        sb2.append(str3);
        sb2.append(str2);
        sb2.append(str3);
        sb2.append(str);
        return getLookupKeyForAsset(sb2.toString());
    }

    public void startInitialization(Context context, Settings settings2) {
        VsyncWaiter vsyncWaiter;
        if (this.settings == null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                TraceSection.begin("FlutterLoader#startInitialization");
                try {
                    final Context applicationContext = context.getApplicationContext();
                    this.settings = settings2;
                    this.initStartTimestampMillis = SystemClock.uptimeMillis();
                    this.flutterApplicationInfo = ApplicationInfoLoader.load(applicationContext);
                    if (Build.VERSION.SDK_INT >= 17) {
                        vsyncWaiter = VsyncWaiter.getInstance((DisplayManager) applicationContext.getSystemService("display"), this.flutterJNI);
                    } else {
                        vsyncWaiter = VsyncWaiter.getInstance(((WindowManager) applicationContext.getSystemService("window")).getDefaultDisplay().getRefreshRate(), this.flutterJNI);
                    }
                    vsyncWaiter.init();
                    this.initResultFuture = this.executorService.submit(new Callable<InitResult>() {
                        /* access modifiers changed from: private */
                        public /* synthetic */ void lambda$call$0() {
                            FlutterLoader.this.flutterJNI.prefetchDefaultFontManager();
                        }

                        public InitResult call() {
                            TraceSection.begin("FlutterLoader initTask");
                            try {
                                ResourceExtractor access$000 = FlutterLoader.this.initResources(applicationContext);
                                FlutterLoader.this.flutterJNI.loadLibrary();
                                FlutterLoader.this.flutterJNI.updateRefreshRate();
                                FlutterLoader.this.executorService.execute(new c(this));
                                if (access$000 != null) {
                                    access$000.waitForCompletion();
                                }
                                return new InitResult(PathUtils.getFilesDir(applicationContext), PathUtils.getCacheDirectory(applicationContext), PathUtils.getDataDirectory(applicationContext));
                            } finally {
                                TraceSection.end();
                            }
                        }
                    });
                } finally {
                    TraceSection.end();
                }
            } else {
                throw new IllegalStateException("startInitialization must be called on the main thread");
            }
        }
    }

    public FlutterLoader(FlutterJNI flutterJNI2, ExecutorService executorService2) {
        this.initialized = false;
        this.flutterJNI = flutterJNI2;
        this.executorService = executorService2;
    }
}
