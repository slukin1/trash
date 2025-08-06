package androidx.lifecycle;

import android.app.Application;

public class a extends ViewModel {
    private final Application application;

    public a(Application application2) {
        this.application = application2;
    }

    public <T extends Application> T getApplication() {
        return this.application;
    }
}
