import java.util.ArrayList;
//import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void output(String headline, List<String> list) {
        System.out.println(headline);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + 1 + ". " + list.get(i));
        }
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int numb = 0;
        String input = "null";

        while (!(input.equals("5"))) {
            System.out.println("Выберите опрацию: ");
            System.out.println("1  Добавть покупку");
            System.out.println("2  Вывести список покупок");
            System.out.println("3  Удалить покупку");
            System.out.println("4  Поиск покупки");
            System.out.println("5  Завершить процедуру");
            input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.println("Какую покупку хотите добавить?");
                    String product = scanner.nextLine();
                    list.add(product);
                    numb += 1;
                    System.out.println("Итого в списке покупок: "
                            + numb);
                    break;
                case "2":
                    output("Итого в списке покупок: ", list);
                    break;
                case "3":
                    output("Список покупок: ", list);
                    System.out.println("Какую хотите удалить?" +
                            " Введите номер или название");
                    String toDel = scanner.nextLine();

                    int inpNum = 0;

                    try {
                        inpNum = Integer.parseInt(toDel);
                    } catch (NumberFormatException e) {
                            inpNum = list.indexOf(toDel) + 1;
                    }
                    String st = list.get(inpNum - 1);
                    list.remove(inpNum - 1);
                    numb-=1;
                    System.out.println("Покупка " + st + " удалена");
                    output("Список покупок: ", list);
                    break;

                case "4":
                    System.out.println("Введите текст для поиска:");
                    String search = scanner.nextLine().toLowerCase();
                    System.out.println("Найдено:");
                    boolean yes=false;
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).toLowerCase().contains(search.toLowerCase())) {
                            System.out.println(i + 1 + ". " + list.get(i));
                            yes=true;
                        }
                    }
                    if (!yes) System.out.println("0 совпадений");
                    break;
            }
        }
    }
}
