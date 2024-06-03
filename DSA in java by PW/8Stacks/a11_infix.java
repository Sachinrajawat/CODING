import java.util.Stack;

public class a11_infix {
    public static void main(String[] args) {
        String str = "9-(5+3)*4/6";
        Stack<Integer> val = new Stack<>();
        Stack<Character> opr = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int ascii = (int) ch;
            // '0' -> 48 and '9' -> 57
            if (ascii >= 48 && ascii <= 57)
                val.push(ascii - 48);
            else if (opr.size() == 0 || ch == '(' || opr.peek() == '(') {
                opr.push(ch);
            }
            else if (ch == ')') {
                while (opr.peek() != '(') {
                    int v2 = val.pop();
                    int v1 = val.pop();
                    if (opr.peek() == '-')
                        val.push(v1 - v2);
                    if (opr.peek() == '+')
                        val.push(v1 + v2);
                    if (opr.peek() == '*')
                        val.push(v1 * v2);
                    if (opr.peek() == '/')
                        val.push(v1 / v2);
                    opr.pop();
                }
                opr.pop(); // '(' hata diya
            } 
            else {
                if (ch == '+' || ch == '-') {
                    // work
                    int v2 = val.pop();
                    int v1 = val.pop();
                    if (opr.peek() == '-')
                        val.push(v1 - v2);
                    if (opr.peek() == '+')
                        val.push(v1 + v2);
                    if (opr.peek() == '*')
                        val.push(v1 * v2);
                    if (opr.peek() == '/')
                        val.push(v1 / v2);
                    opr.pop();
                    opr.push(ch);
                }
                if (ch == '*' || ch == '/') {
                    if (opr.peek() == '*' || opr.peek() == '/') {
                        // work
                        int v2 = val.pop();
                        int v1 = val.pop();
                        if (opr.peek() == '*')
                            val.push(v1 * v2);
                        if (opr.peek() == '/')
                            val.push(v1 / v2);
                        opr.pop();
                        opr.push(ch);
                    } else
                        opr.push(ch);
                }
            }

        }
        while (val.size() > 1) {
            int v2 = val.pop();
            int v1 = val.pop();
            if (opr.peek() == '-')
                val.push(v1 - v2);
            if (opr.peek() == '+')
                val.push(v1 + v2);
            if (opr.peek() == '*')
                val.push(v1 * v2);
            if (opr.peek() == '/')
                val.push(v1 / v2);
            opr.pop();
        }
        System.out.println(val.peek());
    }
}
