package androidx.camera.core.processing;

public interface ShaderProvider {
    public static final ShaderProvider DEFAULT = new ShaderProvider() {
        public /* synthetic */ String createFragmentShader(String str, String str2) {
            return r.a(this, str, str2);
        }
    };

    String createFragmentShader(String str, String str2);
}
