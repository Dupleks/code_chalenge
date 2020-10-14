import java.util.Scanner;

public class DayTwo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст");
        String text = scanner.nextLine();
        System.out.println("Введите максимальную длинну текста");
        int maxLength = scanner.nextInt();

        countStringLength(text, maxLength);
    }

    public static void countStringLength(String text, int maxLength) {
        System.out.println("Количество символов в тексте: " + text.length());
        System.out.println("Количество символов в тексте без учета пробелов: " + text.replace(" ", "").length());
        if (text.length() % 2 == 0) {
            System.out.println("Количество символов в тексте четное");
        } else {
            System.out.println("Количество символов в тексте нечетное");
        }
        if (text.length() > maxLength) {
            System.out.println("Длина текста превышает длину " + maxLength + " символов");
        }
    }
}

