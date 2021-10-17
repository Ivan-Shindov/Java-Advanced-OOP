package app.appenders.files;

public class LogFile implements File {
    private StringBuilder messages;

    public LogFile(){
     this.messages = new StringBuilder();
    }

    @Override
    public int getSize() {
        int sum = 0;
        for (char symbol : this.messages.toString().toCharArray()) {
            if (Character.isLetter(symbol)) {
                sum += symbol;
            }
        }
        return sum;
    }

    @Override
    public void write(String message) {
        this.messages.append(message).append(System.lineSeparator());
    }

}
