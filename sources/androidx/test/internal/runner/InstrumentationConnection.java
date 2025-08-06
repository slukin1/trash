package androidx.test.internal.runner;

import android.app.Instrumentation;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import androidx.test.annotation.Beta;
import androidx.test.internal.util.Checks;
import androidx.test.internal.util.LogUtil;
import androidx.test.internal.util.ParcelableIBinder;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.runner.MonitoringInstrumentation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

@Beta
public class InstrumentationConnection {

    /* renamed from: d  reason: collision with root package name */
    public static final InstrumentationConnection f11398d = new InstrumentationConnection(InstrumentationRegistry.a().getTargetContext());

    /* renamed from: e  reason: collision with root package name */
    public static Instrumentation f11399e;

    /* renamed from: f  reason: collision with root package name */
    public static MonitoringInstrumentation.ActivityFinisher f11400f;

    /* renamed from: a  reason: collision with root package name */
    public Context f11401a;

    /* renamed from: b  reason: collision with root package name */
    public IncomingHandler f11402b;

    /* renamed from: c  reason: collision with root package name */
    public final BroadcastReceiver f11403c = new MessengerReceiver();

    public static class IncomingHandler extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public Messenger f11405a = new Messenger(this);

        /* renamed from: b  reason: collision with root package name */
        public Set<Messenger> f11406b = new HashSet();

        /* renamed from: c  reason: collision with root package name */
        public Map<String, Set<Messenger>> f11407c = new HashMap();

        /* renamed from: d  reason: collision with root package name */
        public final Map<UUID, CountDownLatch> f11408d = new HashMap();

        public IncomingHandler(Looper looper) {
            super(looper);
            if (Looper.getMainLooper() == looper || Looper.myLooper() == looper) {
                throw new IllegalStateException("This handler should not be using the main thread looper nor the instrumentation thread looper.");
            }
        }

        public final void f(final UUID uuid, final CountDownLatch countDownLatch) {
            m(new Callable<Void>() {
                /* renamed from: a */
                public Void call() {
                    IncomingHandler.this.f11408d.put(uuid, countDownLatch);
                    return null;
                }
            });
        }

        public final void g(Bundle bundle, boolean z11) {
            LogUtil.d("InstrConnection", "clientsRegistrationFromBundle called", new Object[0]);
            if (bundle == null) {
                Log.w("InstrConnection", "The client bundle is null, ignoring...");
                return;
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList("instr_clients");
            if (stringArrayList == null) {
                Log.w("InstrConnection", "No clients found in the given bundle");
                return;
            }
            Iterator<String> it2 = stringArrayList.iterator();
            while (it2.hasNext()) {
                String next = it2.next();
                Parcelable[] parcelableArray = bundle.getParcelableArray(String.valueOf(next));
                if (parcelableArray != null) {
                    for (Parcelable parcelable : parcelableArray) {
                        if (z11) {
                            l(next, (Messenger) parcelable);
                        } else {
                            p(next, (Messenger) parcelable);
                        }
                    }
                }
            }
        }

        public final void h(final UUID uuid) {
            m(new Callable<Void>() {
                /* renamed from: a */
                public Void call() {
                    IncomingHandler.this.f11408d.remove(uuid);
                    return null;
                }
            });
        }

        public void handleMessage(Message message) {
            int i11 = message.what;
            switch (i11) {
                case 0:
                    LogUtil.d("InstrConnection", "handleMessage(MSG_REMOTE_ADD_CLIENT)", new Object[0]);
                    l(message.getData().getString("instr_client_type"), (Messenger) message.getData().getParcelable("instr_client_msgr"));
                    return;
                case 1:
                    LogUtil.d("InstrConnection", "handleMessage(MSG_REMOTE_REMOVE_CLIENT)", new Object[0]);
                    p(message.getData().getString("instr_client_type"), message.replyTo);
                    return;
                case 2:
                    LogUtil.d("InstrConnection", "handleMessage(MSG_TERMINATE)", new Object[0]);
                    i();
                    return;
                case 3:
                    LogUtil.d("InstrConnection", "handleMessage(MSG_HANDLE_INSTRUMENTATION_FROM_BROADCAST)", new Object[0]);
                    if (this.f11406b.add(message.replyTo)) {
                        o(message.replyTo, 4, (Bundle) null);
                        return;
                    } else {
                        Log.w("InstrConnection", "Broadcast with existing binder was received, ignoring it..");
                        return;
                    }
                case 4:
                    LogUtil.d("InstrConnection", "handleMessage(MSG_ADD_INSTRUMENTATION)", new Object[0]);
                    if (this.f11406b.add(message.replyTo)) {
                        if (!this.f11407c.isEmpty()) {
                            o(message.replyTo, 6, (Bundle) null);
                        }
                        g(message.getData(), true);
                        return;
                    }
                    Log.w("InstrConnection", "Message with existing binder was received, ignoring it..");
                    return;
                case 5:
                    LogUtil.d("InstrConnection", "handleMessage(MSG_REMOVE_INSTRUMENTATION)", new Object[0]);
                    if (!this.f11406b.remove(message.replyTo)) {
                        Log.w("InstrConnection", "Attempting to remove a non-existent binder!");
                        return;
                    }
                    return;
                case 6:
                    LogUtil.d("InstrConnection", "handleMessage(MSG_ADD_CLIENTS_IN_BUNDLE)", new Object[0]);
                    g(message.getData(), true);
                    return;
                case 7:
                    LogUtil.d("InstrConnection", "handleMessage(MSG_REMOVE_CLIENTS_IN_BUNDLE)", new Object[0]);
                    g(message.getData(), false);
                    return;
                case 8:
                    LogUtil.d("InstrConnection", "handleMessage(MSG_REG_CLIENT)", new Object[0]);
                    l(message.getData().getString("instr_client_type"), (Messenger) message.getData().getParcelable("instr_client_msgr"));
                    n(0, message.getData());
                    return;
                case 9:
                    LogUtil.d("InstrConnection", "handleMessage(MSG_UN_REG_CLIENT)", new Object[0]);
                    p(message.getData().getString("instr_client_type"), (Messenger) message.getData().getParcelable("instr_client_msgr"));
                    n(1, message.getData());
                    return;
                case 10:
                    LogUtil.d("InstrConnection", "handleMessage(MSG_REMOTE_CLEANUP_REQUEST)", new Object[0]);
                    if (this.f11406b.isEmpty()) {
                        Message obtainMessage = obtainMessage(12);
                        obtainMessage.setData(message.getData());
                        sendMessage(obtainMessage);
                        return;
                    }
                    n(11, message.getData());
                    return;
                case 11:
                    LogUtil.d("InstrConnection", "handleMessage(MSG_PERFORM_CLEANUP)", new Object[0]);
                    InstrumentationConnection.f11399e.runOnMainSync(InstrumentationConnection.f11400f);
                    o(message.replyTo, 12, message.getData());
                    return;
                case 12:
                    LogUtil.d("InstrConnection", "handleMessage(MSG_PERFORM_CLEANUP_FINISHED)", new Object[0]);
                    k((UUID) message.getData().getSerializable("instr_uuid"));
                    return;
                default:
                    StringBuilder sb2 = new StringBuilder(42);
                    sb2.append("Unknown message code received: ");
                    sb2.append(i11);
                    Log.w("InstrConnection", sb2.toString());
                    super.handleMessage(message);
                    return;
            }
        }

        public final void i() {
            Log.i("InstrConnection", "terminating process");
            n(5, (Bundle) null);
            this.f11406b.clear();
            this.f11407c.clear();
            LogUtil.d("InstrConnection", "quitting looper...", new Object[0]);
            getLooper().quit();
            LogUtil.d("InstrConnection", "finishing instrumentation...", new Object[0]);
            InstrumentationConnection.f11399e.finish(0, (Bundle) null);
            Instrumentation unused = InstrumentationConnection.f11399e = null;
            MonitoringInstrumentation.ActivityFinisher unused2 = InstrumentationConnection.f11400f = null;
        }

        public final void j(Messenger messenger) {
            Message obtainMessage = obtainMessage(5);
            obtainMessage.replyTo = messenger;
            sendMessage(obtainMessage);
        }

        public final void k(UUID uuid) {
            if (uuid == null || !this.f11408d.containsKey(uuid)) {
                String valueOf = String.valueOf(uuid);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 16);
                sb2.append("Latch not found ");
                sb2.append(valueOf);
                Log.w("InstrConnection", sb2.toString());
                return;
            }
            this.f11408d.get(uuid).countDown();
        }

        public final void l(String str, Messenger messenger) {
            LogUtil.d("InstrConnection", "registerClient called with type = [%s] client = [%s]", str, messenger);
            Checks.c(str, "type cannot be null!");
            Checks.c(messenger, "client cannot be null!");
            Set set = this.f11407c.get(str);
            if (set == null) {
                HashSet hashSet = new HashSet();
                hashSet.add(messenger);
                this.f11407c.put(str, hashSet);
                return;
            }
            set.add(messenger);
        }

        public final <T> T m(Callable<T> callable) {
            FutureTask futureTask = new FutureTask(callable);
            post(futureTask);
            try {
                return futureTask.get();
            } catch (InterruptedException e11) {
                throw new IllegalStateException(e11.getCause());
            } catch (ExecutionException e12) {
                throw new IllegalStateException(e12.getCause());
            }
        }

        public final void n(int i11, Bundle bundle) {
            LogUtil.d("InstrConnection", "sendMessageToOtherInstr() called with: what = [%s], data = [%s]", Integer.valueOf(i11), bundle);
            for (Messenger o11 : this.f11406b) {
                o(o11, i11, bundle);
            }
        }

        public final void o(Messenger messenger, int i11, Bundle bundle) {
            StringBuilder sb2 = new StringBuilder(45);
            sb2.append("sendMessageWithReply type: ");
            sb2.append(i11);
            sb2.append(" called");
            LogUtil.d("InstrConnection", sb2.toString(), new Object[0]);
            Message obtainMessage = obtainMessage(i11);
            obtainMessage.replyTo = this.f11405a;
            if (bundle != null) {
                obtainMessage.setData(bundle);
            }
            if (!this.f11407c.isEmpty()) {
                Bundle data = obtainMessage.getData();
                data.putStringArrayList("instr_clients", new ArrayList(this.f11407c.keySet()));
                for (Map.Entry next : this.f11407c.entrySet()) {
                    data.putParcelableArray(String.valueOf(next.getKey()), (Messenger[]) ((Set) next.getValue()).toArray(new Messenger[((Set) next.getValue()).size()]));
                }
                obtainMessage.setData(data);
            }
            try {
                messenger.send(obtainMessage);
            } catch (RemoteException e11) {
                Log.w("InstrConnection", "The remote process is terminated unexpectedly", e11);
                j(messenger);
            }
        }

        public final void p(String str, Messenger messenger) {
            LogUtil.d("InstrConnection", "unregisterClient called with type = [%s] client = [%s]", str, messenger);
            Checks.c(str, "type cannot be null!");
            Checks.c(messenger, "client cannot be null!");
            if (!this.f11407c.containsKey(str)) {
                String valueOf = String.valueOf(str);
                Log.w("InstrConnection", valueOf.length() != 0 ? "There are no registered clients for type: ".concat(valueOf) : new String("There are no registered clients for type: "));
                return;
            }
            Set set = this.f11407c.get(str);
            if (!set.contains(messenger)) {
                StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 78);
                sb2.append("Could not unregister client for type ");
                sb2.append(str);
                sb2.append(" because it doesn't seem to be registered");
                Log.w("InstrConnection", sb2.toString());
                return;
            }
            set.remove(messenger);
            if (set.isEmpty()) {
                this.f11407c.remove(str);
            }
        }
    }

    public class MessengerReceiver extends BroadcastReceiver {
        public MessengerReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            LogUtil.d("InstrConnection", "Broadcast received", new Object[0]);
            Bundle bundleExtra = intent.getBundleExtra("new_instrumentation_binder");
            if (bundleExtra == null) {
                Log.w("InstrConnection", "Broadcast intent doesn't contain any extras, ignoring it..");
                return;
            }
            ParcelableIBinder parcelableIBinder = (ParcelableIBinder) bundleExtra.getParcelable("new_instrumentation_binder");
            if (parcelableIBinder != null) {
                Messenger messenger = new Messenger(parcelableIBinder.getIBinder());
                Message obtainMessage = InstrumentationConnection.this.f11402b.obtainMessage(3);
                obtainMessage.replyTo = messenger;
                InstrumentationConnection.this.f11402b.sendMessage(obtainMessage);
            }
        }
    }

    public InstrumentationConnection(Context context) {
        this.f11401a = (Context) Checks.c(context, "Context can't be null");
    }

    public static InstrumentationConnection e() {
        return f11398d;
    }

    public synchronized void f(Instrumentation instrumentation, MonitoringInstrumentation.ActivityFinisher activityFinisher) {
        LogUtil.d("InstrConnection", ZendeskBlipsProvider.ACTION_CORE_INIT, new Object[0]);
        if (this.f11402b == null) {
            f11399e = instrumentation;
            f11400f = activityFinisher;
            HandlerThread handlerThread = new HandlerThread("InstrumentationConnectionThread");
            handlerThread.start();
            this.f11402b = new IncomingHandler(handlerThread.getLooper());
            Intent intent = new Intent("androidx.test.runner.InstrumentationConnection.event");
            Bundle bundle = new Bundle();
            bundle.putParcelable("new_instrumentation_binder", new ParcelableIBinder(this.f11402b.f11405a.getBinder()));
            intent.putExtra("new_instrumentation_binder", bundle);
            try {
                this.f11401a.sendBroadcast(intent);
                this.f11401a.registerReceiver(this.f11403c, new IntentFilter("androidx.test.runner.InstrumentationConnection.event"));
            } catch (SecurityException unused) {
                Log.i("InstrConnection", "Could not send broadcast or register receiver (isolatedProcess?)");
            }
        }
        return;
    }

    public synchronized void g() {
        IncomingHandler incomingHandler;
        Checks.d(this.f11402b != null, "Instrumentation Connection in not yet initialized");
        UUID randomUUID = UUID.randomUUID();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.f11402b.f(randomUUID, countDownLatch);
        Message obtainMessage = this.f11402b.obtainMessage(10);
        obtainMessage.replyTo = this.f11402b.f11405a;
        Bundle data = obtainMessage.getData();
        data.putSerializable("instr_uuid", randomUUID);
        obtainMessage.setData(data);
        this.f11402b.sendMessage(obtainMessage);
        try {
            if (!countDownLatch.await(2, TimeUnit.SECONDS)) {
                String valueOf = String.valueOf(randomUUID);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 60);
                sb2.append("Timed out while attempting to perform activity clean up for ");
                sb2.append(valueOf);
                Log.w("InstrConnection", sb2.toString());
            }
            incomingHandler = this.f11402b;
        } catch (InterruptedException e11) {
            try {
                String valueOf2 = String.valueOf(randomUUID);
                StringBuilder sb3 = new StringBuilder(valueOf2.length() + 61);
                sb3.append("Interrupted while waiting for response from message with id: ");
                sb3.append(valueOf2);
                Log.e("InstrConnection", sb3.toString(), e11);
                incomingHandler = this.f11402b;
            } catch (Throwable th2) {
                this.f11402b.h(randomUUID);
                throw th2;
            }
        }
        incomingHandler.h(randomUUID);
        return;
    }

    public synchronized void h() {
        LogUtil.d("InstrConnection", "Terminate is called", new Object[0]);
        IncomingHandler incomingHandler = this.f11402b;
        if (incomingHandler != null) {
            Object unused = incomingHandler.m(new Callable<Void>() {
                /* renamed from: a */
                public Void call() {
                    InstrumentationConnection.this.f11402b.i();
                    return null;
                }
            });
            this.f11401a.unregisterReceiver(this.f11403c);
            this.f11402b = null;
        }
    }
}
