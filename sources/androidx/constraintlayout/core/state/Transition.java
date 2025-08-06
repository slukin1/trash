package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.b;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import java.util.HashMap;

public class Transition {

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, WidgetState> f7045a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<Integer, HashMap<String, Object>> f7046b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public int f7047c = -1;

    public static class WidgetState {

        /* renamed from: a  reason: collision with root package name */
        public WidgetFrame f7048a = new WidgetFrame();

        /* renamed from: b  reason: collision with root package name */
        public WidgetFrame f7049b = new WidgetFrame();

        /* renamed from: c  reason: collision with root package name */
        public WidgetFrame f7050c = new WidgetFrame();

        /* renamed from: d  reason: collision with root package name */
        public b f7051d;

        /* renamed from: e  reason: collision with root package name */
        public MotionWidget f7052e = new MotionWidget(this.f7048a);

        /* renamed from: f  reason: collision with root package name */
        public MotionWidget f7053f = new MotionWidget(this.f7049b);

        /* renamed from: g  reason: collision with root package name */
        public MotionWidget f7054g = new MotionWidget(this.f7050c);

        /* renamed from: h  reason: collision with root package name */
        public KeyCache f7055h = new KeyCache();

        /* renamed from: i  reason: collision with root package name */
        public int f7056i = -1;

        /* renamed from: j  reason: collision with root package name */
        public int f7057j = -1;

        public WidgetState() {
            b bVar = new b(this.f7052e);
            this.f7051d = bVar;
            bVar.c(this.f7052e);
            this.f7051d.b(this.f7053f);
        }
    }
}
