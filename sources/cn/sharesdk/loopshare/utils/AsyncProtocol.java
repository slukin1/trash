package cn.sharesdk.loopshare.utils;

import android.os.Handler;
import android.os.Message;
import cn.sharesdk.loopshare.beans.ConfigData;
import cn.sharesdk.loopshare.beans.SceneData;
import com.mob.tools.RxMob;
import com.mob.tools.utils.UIHandler;

public class AsyncProtocol {

    public interface DataListener<T> {
        void onReceiveData(T t11);
    }

    public interface OnGetConfigListener {
        void onConfig(int i11, ConfigData configData);
    }

    public interface OnGetSceneListner {
        void onScene(int i11, SceneData sceneData);
    }

    public static abstract class a<T> implements DataListener<T> {

        /* renamed from: a  reason: collision with root package name */
        private volatile boolean f13681a;

        public boolean a() {
            if (this.f13681a) {
                return false;
            }
            this.f13681a = true;
            return true;
        }

        public boolean b() {
            return this.f13681a;
        }

        public void onReceiveData(T t11) {
            this.f13681a = false;
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f13682a = 3;

        /* renamed from: b  reason: collision with root package name */
        public int f13683b;

        /* renamed from: c  reason: collision with root package name */
        public int f13684c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public String f13685d;

        public b(String str, int i11, int i12) {
            this.f13685d = str;
            this.f13683b = i11;
            this.f13684c = i12;
        }

        /* access modifiers changed from: private */
        public void b() {
            if (this.f13682a > 0) {
                UIHandler.sendEmptyMessageDelayed(1000, 30000, new Handler.Callback() {
                    public boolean handleMessage(Message message) {
                        b.this.a();
                        return false;
                    }
                });
            }
        }

        public void a() {
            int i11 = this.f13682a;
            if (i11 > 0) {
                this.f13682a = i11 - 1;
                RxMob.Subscribable create = RxMob.create(new AsyncProtocol$UploadTask$1(this));
                create.subscribeOn(RxMob.Thread.NEW_THREAD);
                create.observeOn(RxMob.Thread.IMMEDIATE);
                create.subscribe(new AsyncProtocol$UploadTask$2(this));
            }
        }
    }

    public static ConfigData a() {
        return e.b();
    }

    public static void b() {
        a(0, (DataListener<SceneData>) null);
    }

    public static void a(String str, int i11, int i12) {
        new b(str, i11, i12).a();
    }

    public static void a(final int i11, final DataListener<SceneData> dataListener) {
        RxMob.Subscribable create = RxMob.create(new RxMob.QuickSubscribe<SceneData>() {
            public void doNext(RxMob.Subscriber<SceneData> subscriber) {
                subscriber.onNext(e.a(i11));
            }
        });
        create.subscribeOn(RxMob.Thread.NEW_THREAD);
        create.observeOn(RxMob.Thread.IMMEDIATE);
        create.subscribe(new RxMob.Subscriber<SceneData>() {
            public void onNext(SceneData sceneData) {
                DataListener dataListener = dataListener;
                if (dataListener != null) {
                    dataListener.onReceiveData(sceneData);
                }
            }
        });
    }
}
