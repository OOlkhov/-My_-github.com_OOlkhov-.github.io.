import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public void execute (HomeBudget homeBudget) {
        boolean run = true;
        while (run) {
            System.out.println("Make your choice: 1 - enter new expense; 2 - print list of expenses; 3 - save budget; 4 - load budget; 5 - remove expense; 6 - change expense; 7 - exit.");
            Scanner sc = new Scanner(System.in);
            try {
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Go ahead!");
                        homeBudget.enterExpense();
                        break;
                    case 2:
                        homeBudget.printExpenseList();
                        break;
                    case 3:
                        homeBudget.saveFile();
                        break;
                    case 4:
                        homeBudget.loadFile();
                        System.out.println("Budget loaded.");
                        break;
                    case 5:
                        homeBudget.removeExpense();
                        break;
                    case 6:
                        homeBudget.changeExpense();
                        break;
                    case 7:
                        System.out.println("Thank you for playing.");
                        run = false;
                }
            } catch (InputMismatchException ime) {
                System.out.println("You were asked to enter an integer 1, 2, 3 or 4.");
            }

        }
    }
}