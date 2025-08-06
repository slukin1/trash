package zendesk.core;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

public class CoreModule {
    private final ActionHandlerRegistry actionHandlerRegistry;
    private final ApplicationConfiguration applicationConfiguration;
    private final Context applicationContext;
    private final AuthenticationProvider authenticationProvider;
    private final BlipsProvider blipsProvider;
    private final ScheduledExecutorService executor;
    private final MachineIdStorage machineIdStorage;
    private final MemoryCache memoryCache;
    private final NetworkInfoProvider networkInfoProvider;
    private final PushRegistrationProvider pushRegistrationProvider;
    private final RestServiceProvider restServiceProvider;
    private final SessionStorage sessionStorage;
    private final SettingsProvider settingsProvider;

    public CoreModule(SettingsProvider settingsProvider2, RestServiceProvider restServiceProvider2, BlipsProvider blipsProvider2, SessionStorage sessionStorage2, NetworkInfoProvider networkInfoProvider2, Context context, ActionHandlerRegistry actionHandlerRegistry2, MemoryCache memoryCache2, ScheduledExecutorService scheduledExecutorService, AuthenticationProvider authenticationProvider2, ApplicationConfiguration applicationConfiguration2, PushRegistrationProvider pushRegistrationProvider2, MachineIdStorage machineIdStorage2) {
        this.settingsProvider = settingsProvider2;
        this.restServiceProvider = restServiceProvider2;
        this.blipsProvider = blipsProvider2;
        this.sessionStorage = sessionStorage2;
        this.networkInfoProvider = networkInfoProvider2;
        this.applicationContext = context;
        this.actionHandlerRegistry = actionHandlerRegistry2;
        this.memoryCache = memoryCache2;
        this.executor = scheduledExecutorService;
        this.authenticationProvider = authenticationProvider2;
        this.applicationConfiguration = applicationConfiguration2;
        this.pushRegistrationProvider = pushRegistrationProvider2;
        this.machineIdStorage = machineIdStorage2;
    }

    public ActionHandlerRegistry actionHandlerRegistry() {
        return this.actionHandlerRegistry;
    }

    public ApplicationConfiguration getApplicationConfiguration() {
        return this.applicationConfiguration;
    }

    public Context getApplicationContext() {
        return this.applicationContext;
    }

    public AuthenticationProvider getAuthenticationProvider() {
        return this.authenticationProvider;
    }

    public BlipsProvider getBlipsProvider() {
        return this.blipsProvider;
    }

    public Executor getExecutor() {
        return this.executor;
    }

    public ExecutorService getExecutorService() {
        return this.executor;
    }

    public MachineIdStorage getMachineIdStorage() {
        return this.machineIdStorage;
    }

    public MemoryCache getMemoryCache() {
        return this.memoryCache;
    }

    public NetworkInfoProvider getNetworkInfoProvider() {
        return this.networkInfoProvider;
    }

    public PushRegistrationProvider getPushRegistrationProvider() {
        return this.pushRegistrationProvider;
    }

    public RestServiceProvider getRestServiceProvider() {
        return this.restServiceProvider;
    }

    public ScheduledExecutorService getScheduledExecutorService() {
        return this.executor;
    }

    public SessionStorage getSessionStorage() {
        return this.sessionStorage;
    }

    public SettingsProvider getSettingsProvider() {
        return this.settingsProvider;
    }
}
