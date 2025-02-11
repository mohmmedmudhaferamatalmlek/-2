import java.util.Scanner;

public class TestQueue {
    public static void main(String[] args) {
        ArrayQueue<String>q= new ArrayQueue<>(4);
        Scanner in = new Scanner(System.in);
        int choice;
        while (true)
        {
            System.out.println("1 enqueue 2 dequeue 3 first 4 size 5 is empty -1 exit");
            System.out.println("input your choice: ");
            choice=in.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println("input your element: ");
                    q.enqueue(in.next());
                    System.out.println("an element  was added");
                    break;
                case 2:
                    System.out.println(q.dequeue()+" was removed ");
                    break;
                case 3:
                    System.out.println(q.first()+" is the first element");
                    break;
                case 4:
                    System.out.println(q.size()+" is the queue size");
                    break;
                case 5:
                    System.out.println("is the queue empty? "+q.isEmpty());
                    break;
                case -1:
                    System.exit(0);
            }
            for (int i = 0; i <q.size() ; i++) {
                System.out.print(q.first()+"  ");
                q.enqueue(q.dequeue());
            }
            System.out.println();

        }
    }

}
