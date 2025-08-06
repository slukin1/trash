package dagger.android;

public final class DispatchingAndroidInjector<T> implements AndroidInjector<T> {

    public static final class InvalidInjectorBindingException extends RuntimeException {
        public InvalidInjectorBindingException(String str, ClassCastException classCastException) {
            super(str, classCastException);
        }
    }
}
