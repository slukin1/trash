package androidx.emoji2.text.flatbuffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class FlexBuffersBuilder {

    /* renamed from: a  reason: collision with root package name */
    public final b f9458a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<b> f9459b;

    /* renamed from: c  reason: collision with root package name */
    public final HashMap<String, Integer> f9460c;

    /* renamed from: d  reason: collision with root package name */
    public final HashMap<String, Integer> f9461d;

    /* renamed from: e  reason: collision with root package name */
    public final int f9462e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f9463f;

    /* renamed from: g  reason: collision with root package name */
    public Comparator<b> f9464g;

    public class a implements Comparator<b> {
        public a() {
        }

        /* renamed from: a */
        public int compare(b bVar, b bVar2) {
            byte b11;
            byte b12;
            int i11 = bVar.f9466a;
            int i12 = bVar2.f9466a;
            do {
                b11 = FlexBuffersBuilder.this.f9458a.get(i11);
                b12 = FlexBuffersBuilder.this.f9458a.get(i12);
                if (b11 == 0) {
                    return b11 - b12;
                }
                i11++;
                i12++;
            } while (b11 == b12);
            return b11 - b12;
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f9466a;
    }

    public FlexBuffersBuilder(int i11) {
        this(new ArrayReadWriteBuf(i11), 1);
    }

    public FlexBuffersBuilder() {
        this(256);
    }

    public FlexBuffersBuilder(b bVar, int i11) {
        this.f9459b = new ArrayList<>();
        this.f9460c = new HashMap<>();
        this.f9461d = new HashMap<>();
        this.f9463f = false;
        this.f9464g = new a();
        this.f9458a = bVar;
        this.f9462e = i11;
    }
}
