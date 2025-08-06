package androidx.test.espresso.action;

final class TranslatedCoordinatesProvider implements CoordinatesProvider {

    /* renamed from: b  reason: collision with root package name */
    public final CoordinatesProvider f11102b;

    /* renamed from: c  reason: collision with root package name */
    public final float f11103c;

    /* renamed from: d  reason: collision with root package name */
    public final float f11104d;

    public TranslatedCoordinatesProvider(CoordinatesProvider coordinatesProvider, float f11, float f12) {
        this.f11102b = coordinatesProvider;
        this.f11103c = f11;
        this.f11104d = f12;
    }
}
