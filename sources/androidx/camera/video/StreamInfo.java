package androidx.camera.video;

import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.ConstantObservable;
import androidx.camera.core.impl.Observable;
import com.google.auto.value.AutoValue;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@AutoValue
public abstract class StreamInfo {

    /* renamed from: a  reason: collision with root package name */
    public static final StreamInfo f5853a = d(0, StreamState.INACTIVE);

    /* renamed from: b  reason: collision with root package name */
    public static final Set<Integer> f5854b = Collections.unmodifiableSet(new HashSet(Arrays.asList(new Integer[]{0, -1})));

    /* renamed from: c  reason: collision with root package name */
    public static final Observable<StreamInfo> f5855c = ConstantObservable.withValue(d(0, StreamState.ACTIVE));

    public enum StreamState {
        ACTIVE,
        INACTIVE
    }

    public static StreamInfo d(int i11, StreamState streamState) {
        return new m(i11, streamState, (SurfaceRequest.TransformationInfo) null);
    }

    public static StreamInfo e(int i11, StreamState streamState, SurfaceRequest.TransformationInfo transformationInfo) {
        return new m(i11, streamState, transformationInfo);
    }

    public abstract int a();

    public abstract SurfaceRequest.TransformationInfo b();

    public abstract StreamState c();
}
