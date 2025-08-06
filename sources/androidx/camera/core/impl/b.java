package androidx.camera.core.impl;

public final /* synthetic */ class b {
    public static SessionProcessor a(CameraConfig cameraConfig) {
        return (SessionProcessor) cameraConfig.retrieveOption(CameraConfig.OPTION_SESSION_PROCESSOR);
    }

    public static SessionProcessor b(CameraConfig cameraConfig, SessionProcessor sessionProcessor) {
        return (SessionProcessor) cameraConfig.retrieveOption(CameraConfig.OPTION_SESSION_PROCESSOR, sessionProcessor);
    }

    public static int c(CameraConfig cameraConfig) {
        return ((Integer) cameraConfig.retrieveOption(CameraConfig.OPTION_USE_CASE_COMBINATION_REQUIRED_RULE, 0)).intValue();
    }

    public static UseCaseConfigFactory d(CameraConfig cameraConfig) {
        return (UseCaseConfigFactory) cameraConfig.retrieveOption(CameraConfig.OPTION_USECASE_CONFIG_FACTORY, UseCaseConfigFactory.EMPTY_INSTANCE);
    }
}
