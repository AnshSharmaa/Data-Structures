import java.util.Scanner;

class Stack {
    int n;
    char[] stack;
    int top = -1;
    Stack(int capacity){
        this.n = capacity;
        this.stack = new char[n];
    }
    void Push(char data){
        if (top==n-1){
            System.out.println("Overflow!");
        }
        else {
            this.stack[++top]=data;
        }
    }
    char Pop() throws Exception {
        char data;
        if (this.top==-1){
            throw new Exception("Underflow");
        }
        else {
            data = this.stack[top];
            this.stack[top--] = 0;
            return data;
        }
    }
    char Peek() {
        return this.stack[this.top];
    }
    boolean isEmpty() {
        if (top==-1) {
            return true;
        } else {
            return false;
        }
    }
}
public class Fix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expr = "(a+b)/c*d-(e+f)^g-h";
        System.out.println(intopre(expr));
    }

    static int precedence(char ch) 
    { 
        switch (ch) 
        { 
        case '+': 
        case '-': 
            return 1; 
        case '*': 
        case '/': 
            return 2; 
        case '^': 
            return 3; 
        } 
        return -1; 
    }
    static String intopre(String expr){
        String rev1=reverse(expr);
        return reverse(intopost(rev1));
    }

    static String reverse(String str) {
        String result = new String("");
        for (int i=str.length()-1;i>=0;i--){
            result += str.charAt(i);
        }
        return result;
    }

    static String intopost(String expr) {
        String result = new String("");
        Stack stack = new Stack(expr.length());
        for (int i=0;i<expr.length();i++){
            char c = expr.charAt(i);
            if (Character.isLetterOrDigit(c)){
                result+=c;
            } else if (c=='('){
                stack.Push(c);
            } else if (c==')'){
                while (!stack.isEmpty() && stack.Peek() != '(') {
                    try {
                        result += stack.Pop();
                    } catch (Exception e) {
                        break;
                    }
                }
                if (!stack.isEmpty() && stack.Peek() != '(')
                    return "Invalid Expression";
                else{
                    try {
                        stack.Pop();
                    } catch (Exception e) {
                        break;
                    }
                }
            } else {
                while (!stack.isEmpty() && precedence(c)<=precedence(stack.Peek())){
                    if(stack.Peek() == '(') 
                        return "Invalid Expression";
                    try {
                        result += stack.Pop();
                    } catch (Exception e) {
                        break;
                    }
                }
                stack.Push(c);
            }
        }
        while (!stack.isEmpty()) {
            if (stack.Peek()=='(')
                return "Invalid Expression";
            try {
                result += stack.Pop();
            } catch (Exception e) {
                break;
            }
        }
        return result;
    }

}