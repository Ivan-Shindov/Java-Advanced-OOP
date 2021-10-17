package Telephony;

import Telephony.interfaces.Browsable;
import Telephony.interfaces.Callable;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers,List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }


    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("^[^\\d]+$");
        for (String url : this.urls) {
            Matcher matcher = pattern.matcher(url);
            if (matcher.find()) {
                sb.
                        append(String.format("Browsing: %s!%n",url));
            } else {
                sb.
                        append("Invalid URL!").append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("^[\\d]+$");
        for (String number : this.numbers) {
            Matcher matcher = pattern.matcher(number);
            if (matcher.find()) {
                sb.
                        append(String.format("Calling... %s%n",number));
            } else {
                sb
                        .append("Invalid number!").append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }
}
