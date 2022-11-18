import java.io.*;
import java.util.*;

public class HomeBudget {
    private int income = 5000;
    private int savings = 0;



    private ArrayList<Expense> expenseList = new ArrayList<Expense>();

    public void addExpense (Expense expense) {
        expenseList.add(expense);
    }

    public void printExpenseList(){
        int count = 1;
        for(Expense exp:expenseList) {
            System.out.println(count + " " + exp);
            count++;
        }
    }

    public void enterExpense()  {
        System.out.println("Enter expense, press enter. Then you'll be asked to enter amount of money needed");
        Scanner sc = new Scanner(System.in);
        String expense = sc.nextLine();
        System.out.println("Now enter price");
        int price = sc.nextInt();
        Expense e = new Expense(expense, price);
        addExpense(e);
        System.out.println("Expense added");
    }

    public void saveFile() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter budget descritpion (name)");
            String fileName = sc.nextLine();
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false));
            for(Expense exp:expenseList) {
                writer.write(exp.getExpense() + " = " + exp.getPrice() + "\n");
            }
            writer.close();
            System.out.println("Budget " + fileName + " saved");
        } catch (IOException ioex) {
            System.out.println("couldn't write the expenseList out");
            ioex.printStackTrace();
        }
    }

    public void loadFile() {

        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter budget to load");
            String fileName = sc.nextLine();
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = null;
            while((line = reader.readLine()) != null) {
                makeExpense(line);
            }
            reader.close();
        } catch (Exception ex) {
            System.out.println("couldn't read the expense file");
            ex.printStackTrace();
        }
    }

    public void makeExpense(String lineToParse) {
        String[] result = lineToParse.split(" = ");
        Expense expense = new Expense(result[0], Integer.parseInt(result[1]));
        expenseList.add(expense);
        System.out.println("made an expense");
    }

    public void removeExpense(){
        System.out.println("Enter position of expense to remove");
        Scanner sc = new Scanner(System.in);
        int position = sc.nextInt();
        expenseList.remove(position-1);
        System.out.println("Position " + position + " removed");
    }

    public void changeExpense() {
        System.out.println("Enter position of expense to change");
        Scanner sc = new Scanner(System.in);
        int position = sc.nextInt();
        System.out.println("What would you like to change: 1 - expense description; 2 - expense price");
        try {
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("enter new description");
                    String description = sc.nextLine();
                    expenseList.get(position - 1).setExpense(description);
                    System.out.println("Description changed");
                case 2:
                    System.out.println("enter new price");
                    int price = sc.nextInt();
                    expenseList.get(position - 1).setPrice(price);
                    System.out.println("price changed");

            }
        }catch (InputMismatchException ime) {
            System.out.println("You were asked to enter an integer 1, 2, 3 or 4.");
        }
    }




}
