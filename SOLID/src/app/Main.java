package app;

import app.appenders.Appender;
import app.appenders.console.ConsoleAppender;

import app.appenders.files.FileAppender;

import app.enums.ReportLevel;
import app.layouts.Layout;
import app.layouts.SimpleLayout;
import app.layouts.XmlLayout;
import app.loggers.Logger;
import app.loggers.MessageLogger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(buff.readLine());

        List<Appender> appenderList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = buff.readLine().split("\\s+");
            Appender appender = createAppender(tokens);

            if (tokens.length == 3) {
                appender.setReportLevel(ReportLevel.valueOf(tokens[2].toUpperCase()));
            } else {
                appender.setReportLevel(ReportLevel.INFO);
            }
            appenderList.add(createAppender(tokens));
        }

        String line = buff.readLine();

        Logger logger = new MessageLogger(appenderList.toArray(new Appender[n]));

        while (!line.equals("End")) {
            String[] tokens = line.split("\\|");
            

            line = buff.readLine();
        }

    }

    public static Appender createAppender(String[] tokens) {
        switch (tokens[0]) {
            case "ConsoleAppender":
                return new ConsoleAppender(createLayout(tokens[1]));
            case "FileAppender":
                return new FileAppender(createLayout(tokens[1]));
            default:
                throw new IllegalArgumentException("Invalid Appender");
        }
    }

    public static Layout createLayout(String layaout) {
        switch (layaout) {
            case "SimpleLayout":
                return new SimpleLayout();
            case "XmlLayout":
                return new XmlLayout();
            default:
                throw new IllegalArgumentException("Invalid Layout");
        }
    }
}