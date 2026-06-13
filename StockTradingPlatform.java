import java.util.*;

class Stock {
    String name;
    double price;

    Stock(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

public class StockTradingPlatform {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Stock> marketStocks = new ArrayList<>();
        ArrayList<Stock> portfolio = new ArrayList<>();

        marketStocks.add(new Stock("TCS", 3500));
        marketStocks.add(new Stock("Infosys", 1500));
        marketStocks.add(new Stock("Reliance", 2800));

        double balance = 10000;

        int choice;

        do {

            System.out.println("\n===== STOCK TRADING PLATFORM =====");
            System.out.println("1. View Stocks");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch(choice) {

                case 1:
                    System.out.println("\nAvailable Stocks:");

                    for(int i=0;i<marketStocks.size();i++) {
                        System.out.println(
                            (i+1)+". "+
                            marketStocks.get(i).name+
                            " ₹"+marketStocks.get(i).price
                        );
                    }
                    break;

                case 2:

                    System.out.println("\nSelect Stock:");

                    for(int i=0;i<marketStocks.size();i++) {
                        System.out.println(
                            (i+1)+". "+
                            marketStocks.get(i).name+
                            " ₹"+marketStocks.get(i).price
                        );
                    }

                    int buyChoice = sc.nextInt();

                    Stock selected =
                        marketStocks.get(buyChoice-1);

                    if(balance >= selected.price) {

                        portfolio.add(selected);

                        balance -= selected.price;

                        System.out.println(
                            "Purchased " + selected.name
                        );

                    } else {

                        System.out.println(
                            "Insufficient Balance"
                        );
                    }

                    break;

                case 3:

                    if(portfolio.size()==0) {

                        System.out.println(
                            "No stocks available to sell"
                        );

                    } else {

                        System.out.println(
                            "\nYour Portfolio:"
                        );

                        for(int i=0;i<portfolio.size();i++) {

                            System.out.println(
                                (i+1)+". "+
                                portfolio.get(i).name
                            );
                        }

                        int sellChoice = sc.nextInt();

                        Stock sold =
                            portfolio.remove(sellChoice-1);

                        balance += sold.price;

                        System.out.println(
                            sold.name+" Sold Successfully"
                        );
                    }

                    break;

                case 4:

                    System.out.println(
                        "\nPortfolio:"
                    );

                    for(Stock s : portfolio) {

                        System.out.println(
                            s.name+
                            " ₹"+
                            s.price
                        );
                    }

                    System.out.println(
                        "Balance: ₹"+balance
                    );

                    break;

                case 5:

                    System.out.println(
                        "Thank You!"
                    );

                    break;

                default:
                    System.out.println(
                        "Invalid Choice"
                    );
            }

        } while(choice != 5);

        sc.close();
    }
}