package zendesk.core;

interface BlipsCoreProvider {
    void coreInitialized();

    void corePushDisabled(Long l11);

    void corePushEnabled();
}
