package androidx.constraintlayout.core.state;

import java.util.ArrayList;
import java.util.HashMap;

public class State {

    /* renamed from: f  reason: collision with root package name */
    public static final Integer f7039f = 0;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<Object, Object> f7040a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<Object, Object> f7041b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, ArrayList<String>> f7042c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public final ConstraintReference f7043d;

    /* renamed from: e  reason: collision with root package name */
    public int f7044e;

    public enum Chain {
        SPREAD,
        SPREAD_INSIDE,
        PACKED
    }

    public enum Constraint {
        LEFT_TO_LEFT,
        LEFT_TO_RIGHT,
        RIGHT_TO_LEFT,
        RIGHT_TO_RIGHT,
        START_TO_START,
        START_TO_END,
        END_TO_START,
        END_TO_END,
        TOP_TO_TOP,
        TOP_TO_BOTTOM,
        BOTTOM_TO_TOP,
        BOTTOM_TO_BOTTOM,
        BASELINE_TO_BASELINE,
        CENTER_HORIZONTALLY,
        CENTER_VERTICALLY,
        CIRCULAR_CONSTRAINT
    }

    public enum Direction {
        LEFT,
        RIGHT,
        START,
        END,
        TOP,
        BOTTOM
    }

    public enum Helper {
        HORIZONTAL_CHAIN,
        VERTICAL_CHAIN,
        ALIGN_HORIZONTALLY,
        ALIGN_VERTICALLY,
        BARRIER,
        LAYER,
        FLOW
    }

    public State() {
        ConstraintReference constraintReference = new ConstraintReference(this);
        this.f7043d = constraintReference;
        this.f7044e = 0;
        this.f7040a.put(f7039f, constraintReference);
    }
}
