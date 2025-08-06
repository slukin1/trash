package kotlin.text;

import java.util.Map;
import kotlin.i;
import kotlin.jvm.internal.r;

public enum CharDirectionality {
    UNDEFINED(-1),
    LEFT_TO_RIGHT(0),
    RIGHT_TO_LEFT(1),
    RIGHT_TO_LEFT_ARABIC(2),
    EUROPEAN_NUMBER(3),
    EUROPEAN_NUMBER_SEPARATOR(4),
    EUROPEAN_NUMBER_TERMINATOR(5),
    ARABIC_NUMBER(6),
    COMMON_NUMBER_SEPARATOR(7),
    NONSPACING_MARK(8),
    BOUNDARY_NEUTRAL(9),
    PARAGRAPH_SEPARATOR(10),
    SEGMENT_SEPARATOR(11),
    WHITESPACE(12),
    OTHER_NEUTRALS(13),
    LEFT_TO_RIGHT_EMBEDDING(14),
    LEFT_TO_RIGHT_OVERRIDE(15),
    RIGHT_TO_LEFT_EMBEDDING(16),
    RIGHT_TO_LEFT_OVERRIDE(17),
    POP_DIRECTIONAL_FORMAT(18);
    
    public static final a Companion = null;
    /* access modifiers changed from: private */
    public static final i<Map<Integer, CharDirectionality>> directionalityMap$delegate = null;
    private final int value;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new a((r) null);
        directionalityMap$delegate = LazyKt__LazyJVMKt.a(CharDirectionality$Companion$directionalityMap$2.INSTANCE);
    }

    private CharDirectionality(int i11) {
        this.value = i11;
    }

    public final int getValue() {
        return this.value;
    }
}
