package t;

import androidx.camera.camera2.interop.CaptureRequestOptions;
import androidx.camera.core.impl.Config;

public final /* synthetic */ class h implements Config.OptionMatcher {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CaptureRequestOptions.Builder f29285a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Config f29286b;

    public /* synthetic */ h(CaptureRequestOptions.Builder builder, Config config) {
        this.f29285a = builder;
        this.f29286b = config;
    }

    public final boolean onOptionMatched(Config.Option option) {
        return this.f29285a.getMutableConfig().insertOption(option, this.f29286b.getOptionPriority(option), this.f29286b.retrieveOption(option));
    }
}
