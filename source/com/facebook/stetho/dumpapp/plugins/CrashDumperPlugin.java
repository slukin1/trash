package com.facebook.stetho.dumpapp.plugins;

import android.os.Process;
import com.facebook.stetho.common.ExceptionUtil;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.dumpapp.ArgsHelper;
import com.facebook.stetho.dumpapp.DumpException;
import com.facebook.stetho.dumpapp.DumpUsageException;
import com.facebook.stetho.dumpapp.DumperContext;
import com.facebook.stetho.dumpapp.DumperPlugin;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;

public class CrashDumperPlugin implements DumperPlugin {
    private static final String NAME = "crash";
    private static final String OPTION_EXIT_DEFAULT = "0";
    private static final String OPTION_KILL_DEFAULT = "9";
    private static final String OPTION_THROW_DEFAULT = "java.lang.Error";

    public static class ThrowRunnable implements Runnable {
        private final Throwable mThrowable;

        public ThrowRunnable(Throwable th2) {
            this.mThrowable = th2;
        }

        public void run() {
            ExceptionUtil.sneakyThrow(this.mThrowable);
        }
    }

    private void doKill(DumperContext dumperContext, Iterator<String> it2) throws DumpException {
        Process start;
        String nextOptionalArg = ArgsHelper.nextOptionalArg(it2, "9");
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(new String[0]);
            start = processBuilder.command(new String[]{"/system/bin/kill", Constants.ACCEPT_TIME_SEPARATOR_SERVER + nextOptionalArg, String.valueOf(Process.myPid())}).redirectErrorStream(true).start();
            Util.copy(start.getInputStream(), dumperContext.getStdout(), new byte[1024]);
            start.destroy();
        } catch (IOException e11) {
            throw new DumpException("Failed to invoke kill: " + e11);
        } catch (Throwable th2) {
            start.destroy();
            throw th2;
        }
    }

    private void doSystemExit(Iterator<String> it2) {
        System.exit(Integer.parseInt(ArgsHelper.nextOptionalArg(it2, "0")));
    }

    private void doUncaughtException(Iterator<String> it2) throws DumpException {
        Throwable th2;
        try {
            Class<?> cls = Class.forName(ArgsHelper.nextOptionalArg(it2, OPTION_THROW_DEFAULT));
            Constructor<? extends Object> tryGetDeclaredConstructor = tryGetDeclaredConstructor(cls, String.class);
            if (tryGetDeclaredConstructor != null) {
                th2 = (Throwable) tryGetDeclaredConstructor.newInstance(new Object[]{"Uncaught exception triggered by Stetho"});
            } else {
                th2 = (Throwable) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            }
            Thread thread = new Thread(new ThrowRunnable(th2));
            thread.start();
            Util.joinUninterruptibly(thread);
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException e11) {
            throw new DumpException("Invalid supplied Throwable class: " + e11);
        } catch (InvocationTargetException e12) {
            throw ExceptionUtil.propagate(e12.getCause());
        }
    }

    private void doUsage(PrintStream printStream) {
        printStream.println("Usage: dumpapp crash " + "<command> [command-options]");
        printStream.println("Usage: dumpapp crash " + "throw");
        printStream.println("       dumpapp crash " + "kill");
        printStream.println("       dumpapp crash " + "exit");
        printStream.println();
        printStream.println("dumpapp crash throw: Throw an uncaught exception (simulates a program crash)");
        printStream.println("    <Throwable>: Throwable class to use (default: java.lang.Error)");
        printStream.println();
        printStream.println("dumpapp crash kill: Send a signal to this process (simulates the low memory killer)");
        printStream.println("    <SIGNAL>: Either signal name or number to send (default: 9)");
        printStream.println("              See `adb shell kill -l` for more information");
        printStream.println();
        printStream.println("dumpapp crash exit: Invoke System.exit (simulates an abnormal Android exit strategy)");
        printStream.println("    <code>: Exit code (default: 0)");
    }

    private static <T> Constructor<? extends T> tryGetDeclaredConstructor(Class<T> cls, Class<?>... clsArr) {
        try {
            return cls.getDeclaredConstructor(clsArr);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public void dump(DumperContext dumperContext) throws DumpException {
        Iterator<String> it2 = dumperContext.getArgsAsList().iterator();
        String nextOptionalArg = ArgsHelper.nextOptionalArg(it2, (String) null);
        if ("throw".equals(nextOptionalArg)) {
            doUncaughtException(it2);
        } else if ("kill".equals(nextOptionalArg)) {
            doKill(dumperContext, it2);
        } else if ("exit".equals(nextOptionalArg)) {
            doSystemExit(it2);
        } else {
            doUsage(dumperContext.getStdout());
            if (nextOptionalArg != null) {
                throw new DumpUsageException("Unsupported command: " + nextOptionalArg);
            }
        }
    }

    public String getName() {
        return "crash";
    }
}
