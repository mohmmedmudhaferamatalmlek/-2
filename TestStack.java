import java.util.Scanner;

public class TestStack {
    public static void main(String[] args) {
        ArrayStack<String>s= new ArrayStack<>(4);
        Scanner in = new Scanner(System.in);
        int choice;
        while (true)
        {
            System.out.println("1 push 2 pop 3 top 4 size 5 is empty -1 exit");
            System.out.println("input your choice: ");
            choice=in.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println("input your element: ");
                    s.push(in.next());
                    System.out.println(s.top()+" was added");
                    break;
                case 2:
                    System.out.println(s.pop()+" was removed ");
                    break;
                case 3:
                    System.out.println(s.top()+" is the top element");
                    break;
                case 4:
                    System.out.println(s.size()+" is the stack size");
                    break;
                case 5:
                    System.out.println("is the stack empty? "+s.isEmpty());
                    break;
                case -1:
                    System.exit(0);
            }
            ArrayStack<String>s2= new ArrayStack<>(s.size());
            while (!s.isEmpty())
            {
                System.out.println(s.top());
                s2.push(s.pop());
            }
            while (!s2.isEmpty())
            {
                s.push(s2.pop());
            }

        }
    }
}
