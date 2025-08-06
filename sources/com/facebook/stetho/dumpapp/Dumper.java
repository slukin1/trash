package com.facebook.stetho.dumpapp;

import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.ParseException;
import s10.a;

public class Dumper {
    private final Map<String, DumperPlugin> mDumperPlugins;
    private final GlobalOptions mGlobalOptions;
    private final a mParser;

    public Dumper(Iterable<DumperPlugin> iterable) {
        this(iterable, new GnuParser());
    }

    private int doDump(InputStream inputStream, PrintStream printStream, PrintStream printStream2, String[] strArr) throws ParseException, DumpException {
        CommandLine a11 = this.mParser.a(this.mGlobalOptions.options, strArr, true);
        if (a11.hasOption(this.mGlobalOptions.optionHelp.getOpt())) {
            dumpUsage(printStream);
            return 0;
        } else if (a11.hasOption(this.mGlobalOptions.optionListPlugins.getOpt())) {
            dumpAvailablePlugins(printStream);
            return 0;
        } else if (!a11.getArgList().isEmpty()) {
            dumpPluginOutput(inputStream, printStream, printStream2, a11);
            return 0;
        } else {
            dumpUsage(printStream2);
            return 1;
        }
    }

    private void dumpAvailablePlugins(PrintStream printStream) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (DumperPlugin name : this.mDumperPlugins.values()) {
            arrayList.add(name.getName());
        }
        Collections.sort(arrayList);
        for (String println : arrayList) {
            printStream.println(println);
        }
    }

    private void dumpPluginOutput(InputStream inputStream, PrintStream printStream, PrintStream printStream2, CommandLine commandLine) throws DumpException {
        ArrayList arrayList = new ArrayList(commandLine.getArgList());
        if (arrayList.size() >= 1) {
            String str = (String) arrayList.remove(0);
            DumperPlugin dumperPlugin = this.mDumperPlugins.get(str);
            if (dumperPlugin != null) {
                dumperPlugin.dump(new DumperContext(inputStream, printStream, printStream2, this.mParser, arrayList));
                return;
            }
            throw new DumpException("No plugin named '" + str + "'");
        }
        throw new DumpException("Expected plugin argument");
    }

    private void dumpUsage(PrintStream printStream) {
        HelpFormatter helpFormatter = new HelpFormatter();
        printStream.println("Usage: dumpapp [options] <plugin> [plugin-options]");
        PrintWriter printWriter = new PrintWriter(printStream);
        try {
            helpFormatter.g(printWriter, helpFormatter.f(), this.mGlobalOptions.options, helpFormatter.d(), helpFormatter.c());
        } finally {
            printWriter.flush();
        }
    }

    private static Map<String, DumperPlugin> generatePluginMap(Iterable<DumperPlugin> iterable) {
        HashMap hashMap = new HashMap();
        for (DumperPlugin next : iterable) {
            hashMap.put(next.getName(), next);
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public int dump(InputStream inputStream, PrintStream printStream, PrintStream printStream2, String[] strArr) {
        try {
            return doDump(inputStream, printStream, printStream2, strArr);
        } catch (ParseException e11) {
            printStream2.println(e11.getMessage());
            dumpUsage(printStream2);
            return 1;
        } catch (DumpException e12) {
            printStream2.println(e12.getMessage());
            return 1;
        } catch (DumpappOutputBrokenException e13) {
            throw e13;
        } catch (RuntimeException e14) {
            e14.printStackTrace(printStream2);
            return 1;
        }
    }

    public Dumper(Iterable<DumperPlugin> iterable, a aVar) {
        this.mDumperPlugins = generatePluginMap(iterable);
        this.mParser = aVar;
        this.mGlobalOptions = new GlobalOptions();
    }
}
