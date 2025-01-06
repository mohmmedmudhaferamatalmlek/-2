import java.util.Stack;

public class lab7Q3 {
    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();

        // تقسيم التعبير إلى أجزاء بناءً على الفراغات
        String[] tokens = expression.split(" ");

        // المرور على كل عنصر في التعبير
        for (String token : tokens) {
            // إذا كان العنصر عبارة عن رقم، يتم دفعه إلى المكدس
            if (isNumeric(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                // إذا كان العنصر عملية، يتم إخراج آخر قيمتين من المكدس
                int operand2 = stack.pop();
                int operand1 = stack.pop();

                // تنفيذ العملية ودفع النتيجة إلى المكدس
                switch (token) {
                    case "+":
                        stack.push(operand1 + operand2);
                        break;
                    case "-":
                        stack.push(operand1 - operand2);
                        break;
                    case "*":
                        stack.push(operand1 * operand2);
                        break;
                    case "/":
                        stack.push(operand1 / operand2);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + token);
                }
            }
        }

        // القيمة النهائية في المكدس هي النتيجة
        return stack.pop();
    }

    // دالة للتحقق مما إذا كانت السلسلة رقمًا
    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        // مثال على تعبير Postfix: "5 2 + 8 3 - * 4 /"
        String expression = "5 2 + 8 3 - * 4 /";
        int result = evaluatePostfix(expression);
        System.out.println("The result of the postfix expression is: " + result);
    }
}
