package io.flutter.embedding.engine;

import android.content.Context;
import io.flutter.FlutterInjector;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.plugin.platform.PlatformViewsController;
import java.util.ArrayList;
import java.util.List;

public class FlutterEngineGroup {
    public final List<FlutterEngine> activeEngines;

    public static class Options {
        private boolean automaticallyRegisterPlugins = true;
        private Context context;
        private DartExecutor.DartEntrypoint dartEntrypoint;
        private List<String> dartEntrypointArgs;
        private String initialRoute;
        private PlatformViewsController platformViewsController;
        private boolean waitForRestorationData = false;

        public Options(Context context2) {
            this.context = context2;
        }

        public boolean getAutomaticallyRegisterPlugins() {
            return this.automaticallyRegisterPlugins;
        }

        public Context getContext() {
            return this.context;
        }

        public DartExecutor.DartEntrypoint getDartEntrypoint() {
            return this.dartEntrypoint;
        }

        public List<String> getDartEntrypointArgs() {
            return this.dartEntrypointArgs;
        }

        public String getInitialRoute() {
            return this.initialRoute;
        }

        public PlatformViewsController getPlatformViewsController() {
            return this.platformViewsController;
        }

        public boolean getWaitForRestorationData() {
            return this.waitForRestorationData;
        }

        public Options setAutomaticallyRegisterPlugins(boolean z11) {
            this.automaticallyRegisterPlugins = z11;
            return this;
        }

        public Options setDartEntrypoint(DartExecutor.DartEntrypoint dartEntrypoint2) {
            this.dartEntrypoint = dartEntrypoint2;
            return this;
        }

        public Options setDartEntrypointArgs(List<String> list) {
            this.dartEntrypointArgs = list;
            return this;
        }

        public Options setInitialRoute(String str) {
            this.initialRoute = str;
            return this;
        }

        public Options setPlatformViewsController(PlatformViewsController platformViewsController2) {
            this.platformViewsController = platformViewsController2;
            return this;
        }

        public Options setWaitForRestorationData(boolean z11) {
            this.waitForRestorationData = z11;
            return this;
        }
    }

    public FlutterEngineGroup(Context context) {
        this(context, (String[]) null);
    }

    public FlutterEngine createAndRunDefaultEngine(Context context) {
        return createAndRunEngine(context, (DartExecutor.DartEntrypoint) null);
    }

    public FlutterEngine createAndRunEngine(Context context, DartExecutor.DartEntrypoint dartEntrypoint) {
        return createAndRunEngine(context, dartEntrypoint, (String) null);
    }

    public FlutterEngine createEngine(Context context, PlatformViewsController platformViewsController, boolean z11, boolean z12) {
        return new FlutterEngine(context, (FlutterLoader) null, (FlutterJNI) null, platformViewsController, (String[]) null, z11, z12);
    }

    public FlutterEngineGroup(Context context, String[] strArr) {
        this.activeEngines = new ArrayList();
        FlutterLoader flutterLoader = FlutterInjector.instance().flutterLoader();
        if (!flutterLoader.initialized()) {
            flutterLoader.startInitialization(context.getApplicationContext());
            flutterLoader.ensureInitializationComplete(context.getApplicationContext(), strArr);
        }
    }

    public FlutterEngine createAndRunEngine(Context context, DartExecutor.DartEntrypoint dartEntrypoint, String str) {
        return createAndRunEngine(new Options(context).setDartEntrypoint(dartEntrypoint).setInitialRoute(str));
    }

    public FlutterEngine createAndRunEngine(Options options) {
        final FlutterEngine flutterEngine;
        Context context = options.getContext();
        DartExecutor.DartEntrypoint dartEntrypoint = options.getDartEntrypoint();
        String initialRoute = options.getInitialRoute();
        List<String> dartEntrypointArgs = options.getDartEntrypointArgs();
        PlatformViewsController platformViewsController = options.getPlatformViewsController();
        if (platformViewsController == null) {
            platformViewsController = new PlatformViewsController();
        }
        PlatformViewsController platformViewsController2 = platformViewsController;
        boolean automaticallyRegisterPlugins = options.getAutomaticallyRegisterPlugins();
        boolean waitForRestorationData = options.getWaitForRestorationData();
        DartExecutor.DartEntrypoint createDefault = dartEntrypoint == null ? DartExecutor.DartEntrypoint.createDefault() : dartEntrypoint;
        if (this.activeEngines.size() == 0) {
            flutterEngine = createEngine(context, platformViewsController2, automaticallyRegisterPlugins, waitForRestorationData);
            if (initialRoute != null) {
                flutterEngine.getNavigationChannel().setInitialRoute(initialRoute);
            }
            flutterEngine.getDartExecutor().executeDartEntrypoint(createDefault, dartEntrypointArgs);
        } else {
            flutterEngine = this.activeEngines.get(0).spawn(context, createDefault, initialRoute, dartEntrypointArgs, platformViewsController2, automaticallyRegisterPlugins, waitForRestorationData);
        }
        this.activeEngines.add(flutterEngine);
        flutterEngine.addEngineLifecycleListener(new FlutterEngine.EngineLifecycleListener() {
            public void onEngineWillDestroy() {
                FlutterEngineGroup.this.activeEngines.remove(flutterEngine);
            }

            public void onPreEngineRestart() {
            }
        });
        return flutterEngine;
    }
}
