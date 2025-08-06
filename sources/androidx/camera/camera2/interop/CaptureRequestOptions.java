package androidx.camera.camera2.interop;

import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.core.ExtendableBuilder;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.ReadableConfig;
import androidx.camera.core.impl.g0;
import java.util.Set;
import t.h;

public class CaptureRequestOptions implements ReadableConfig {

    /* renamed from: a  reason: collision with root package name */
    public final Config f5483a;

    public static final class Builder implements ExtendableBuilder<CaptureRequestOptions> {

        /* renamed from: a  reason: collision with root package name */
        public final MutableOptionsBundle f5484a = MutableOptionsBundle.create();

        public static Builder c(Config config) {
            Builder builder = new Builder();
            config.findOptions("camera2.captureRequest.option.", new h(builder, config));
            return builder;
        }

        /* renamed from: b */
        public CaptureRequestOptions build() {
            return new CaptureRequestOptions(OptionsBundle.from(this.f5484a));
        }

        public <ValueT> Builder e(CaptureRequest.Key<ValueT> key, ValueT valuet) {
            this.f5484a.insertOption(Camera2ImplConfig.a(key), valuet);
            return this;
        }

        public MutableConfig getMutableConfig() {
            return this.f5484a;
        }
    }

    public CaptureRequestOptions(Config config) {
        this.f5483a = config;
    }

    public /* synthetic */ boolean containsOption(Config.Option option) {
        return g0.a(this, option);
    }

    public /* synthetic */ void findOptions(String str, Config.OptionMatcher optionMatcher) {
        g0.b(this, str, optionMatcher);
    }

    public Config getConfig() {
        return this.f5483a;
    }

    public /* synthetic */ Config.OptionPriority getOptionPriority(Config.Option option) {
        return g0.c(this, option);
    }

    public /* synthetic */ Set getPriorities(Config.Option option) {
        return g0.d(this, option);
    }

    public /* synthetic */ Set listOptions() {
        return g0.e(this);
    }

    public /* synthetic */ Object retrieveOption(Config.Option option) {
        return g0.f(this, option);
    }

    public /* synthetic */ Object retrieveOption(Config.Option option, Object obj) {
        return g0.g(this, option, obj);
    }

    public /* synthetic */ Object retrieveOptionWithPriority(Config.Option option, Config.OptionPriority optionPriority) {
        return g0.h(this, option, optionPriority);
    }
}
