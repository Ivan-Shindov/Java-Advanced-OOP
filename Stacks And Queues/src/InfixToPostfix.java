import java.util.*;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StackImpl stack = new StackImpl();
        String result = stack.infixToPostfix(scanner.nextLine());
        System.out.println(result);
    }
}

class StackImpl {

    public String infixToPostfix(String s) {
        Stack<String> st = new Stack<>();
        StringBuilder postfix = new StringBuilder();
        String[] ch = s.split("\\s+");


        for (String c : ch) {
            if (!c.equals("+") && !c.equals("-") && !c.equals("*") &&
                    !c.equals("/") && !c.equals("(") && !c.equals(")")) {
                postfix.append(c).append(" ");
            } else if (c.equals("(")) {
                st.push(c);
            } else if (c.equals(")")) {
                while (!st.isEmpty()) {
                    String t = st.pop();
                    if (!t.equals("(")) {
                        postfix.append(t).append(" ");
                    } else {
                        break;
                    }
                }
            } else if (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")) {
                if (st.isEmpty()) {
                    st.push(c);
                } else {
                    while (!st.isEmpty()) {
                        String t = st.pop();
                        if (t.equals("(")) {
                            st.push(t);
                            break;
                        } else if (t.equals("+") || t.equals("-") ||
                                t.equals("*") || t.equals("/")) {
                            if (getPriority(t) < getPriority(c)) {
                                st.push(t);
                                break;
                            } else {
                                postfix.append(t).append(" ");
                            }
                        }
                    }
                    st.push(c);
                }
            }
        }
        while (!st.isEmpty()) {
            postfix.append(st.pop()).append(" ");
        }
        return postfix.toString();
    }

    public int getPriority(String c) {
        if (c.equals("+") || c.equals("-")) {
            return 1;
        } else {
            return 2;
        }
    }

}
