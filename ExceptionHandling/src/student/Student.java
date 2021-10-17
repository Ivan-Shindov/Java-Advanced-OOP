package student;

public class Student {
    private String name;
    private String email;

    public Student(String name,String email) {
        setName(name);
        setEmail(email);
    }

    public void setName(String name) {
        if (!isValidData(name)) {
            throw new InvalidPersonNameException();
        }
        this.name = name;
    }

    public void setEmail(String email) {
        if (!isValidData(name)) {
            throw new InvalidPersonNameException();
        }
        this.email = email;
    }


    private boolean isValidData(String data) {
        for (int i = 0; i < data.length(); i++) {
            char current = data.charAt(i);
            if (!Character.isLetter(current)) {
                return false;
            }
        }
        return true;
    }
}
