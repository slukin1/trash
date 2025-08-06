package androidx.camera.core.internal;

import androidx.camera.core.UseCase;

public final /* synthetic */ class f {
    public static UseCase.EventCallback a(UseCaseEventConfig useCaseEventConfig) {
        return (UseCase.EventCallback) useCaseEventConfig.retrieveOption(UseCaseEventConfig.OPTION_USE_CASE_EVENT_CALLBACK);
    }

    public static UseCase.EventCallback b(UseCaseEventConfig useCaseEventConfig, UseCase.EventCallback eventCallback) {
        return (UseCase.EventCallback) useCaseEventConfig.retrieveOption(UseCaseEventConfig.OPTION_USE_CASE_EVENT_CALLBACK, eventCallback);
    }
}
