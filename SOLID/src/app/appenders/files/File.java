package app.appenders.files;

public interface File {

    int getSize();

    void write(String message);
}
