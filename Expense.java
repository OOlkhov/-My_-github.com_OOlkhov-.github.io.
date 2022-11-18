public class Expense {
    private String expense;
    private int price;

    public Expense (String e, int p) {
        expense = e;
        price = p;
    }

    public String getExpense() {
        return expense;
    }

    public void setExpense(String description){
        expense = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price){
        this.price = price;
    }

    @Override
    public String toString() {
        return expense + " = " + price;
    }
}
