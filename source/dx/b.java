package dx;

import android.view.View;
import androidx.core.view.h0;
import androidx.core.view.o0;
import com.lauzy.freedom.lbehaviorlib.anim.AbsBehaviorAnim;

public class b extends AbsBehaviorAnim {

    /* renamed from: c  reason: collision with root package name */
    public View f28881c;

    public class a implements o0 {
        public a() {
        }

        public void a(View view) {
        }

        public void b(View view) {
        }

        public void c(View view) {
            view.setVisibility(0);
        }
    }

    /* renamed from: dx.b$b  reason: collision with other inner class name */
    public class C0249b implements o0 {
        public C0249b() {
        }

        public void a(View view) {
        }

        public void b(View view) {
            view.setVisibility(4);
        }

        public void c(View view) {
        }
    }

    public b(View view) {
        this.f28881c = view;
    }

    public void hide() {
        h0.e(this.f28881c).f(0.0f).g(0.0f).h((long) c()).i(d()).j(new C0249b()).n();
    }

    public void show() {
        h0.e(this.f28881c).f(1.0f).g(1.0f).h((long) c()).i(d()).j(new a()).n();
    }
}
