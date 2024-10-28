import java.util.*;

public class Task3 {
    public static void main(String[] args) {
        System.out.println("task 3.1");
        System.out.println(isStrangePair("ratio", "orator"));
        System.out.println(isStrangePair("sparkling", "groups"));
        System.out.println(isStrangePair("bush", "hubris"));
        System.out.println(isStrangePair("", ""));

        System.out.println("\ntask 3.2");
        List<List<Object>> products = new ArrayList<>();
        products.add(List.of("Laptop", 124200));
        products.add(List.of("Phone", 51450));
        products.add(List.of("Headphones", 13800));
        //---------------------------------------------
        System.out.println(sale(products, 25));

        System.out.println("\ntask 3.3");
        System.out.println(sucsessShoot(0, 0, 5, 2, 2));
        System.out.println(sucsessShoot(-2, -3, 4, 5, -6));

        System.out.println("\ntask 3.4");
        System.out.println(parityAnalysis(243));
        System.out.println(parityAnalysis(12));
        System.out.println(parityAnalysis(3));

        System.out.println("\ntask 3.5");
        System.out.println(rps("rock", "paper"));
        System.out.println(rps("paper", "rock"));
        System.out.println(rps("paper", "scissors"));
        System.out.println(rps("scissors", "scissors"));
        System.out.println(rps("scissors", "paper"));

        System.out.println("\ntask 3.6");
        System.out.println(bugger(39));
        System.out.println(bugger(999));
        System.out.println(bugger(4));

        System.out.println("\ntask 3.7");
        Object[][] inventory = {
                {"Скакалка", 550, 8},
                {"Шлем", 3750, 4},
                {"Мяч", 2900, 10}
        };
        System.out.println(mostExpensive(inventory));

        System.out.println("\ntask 3.8");
        System.out.println(longestUnique("abcba"));
        System.out.println(longestUnique("bbb"));

        System.out.println("\ntask 3.9");
        System.out.println(isPrefix("automation", "auto-"));
        System.out.println(isSuffix("arachnophobia", "-phobia"));
        System.out.println(isPrefix("retrospect", "sub-"));
        System.out.println(isSuffix("vocation", "-logy"));

        System.out.println("\ntask 3.10");
        System.out.println(doesBrickFit(1, 1, 1, 1, 1));
        System.out.println(doesBrickFit(1, 2, 1, 1, 1));
        System.out.println(doesBrickFit(1, 2, 2, 1, 1));
    }
    // 1
    public static boolean isStrangePair(String str1, String str2) {
        if (!str1.isEmpty() && !str2.isEmpty()) {
            return str1.charAt(0) == str2.charAt(str2.length() - 1) &&
                    str2.charAt(0) == str1.charAt(str1.length() - 1);
        }
        return str1.isEmpty() && str2.isEmpty();
    }

    // 2
    public static String sale(List<List<Object>> products, int discount) {
        List<List<Object>> output= new ArrayList<>();
        for (List<Object> product : products) {
            int price = (int) product.get(1);
            int discountedPrice = (int) Math.round(price * (100 - discount) * 0.01);
            if (discountedPrice < 1) {
                discountedPrice = 1;
            }
            output.add(List.of(product.get(0), discountedPrice));
        }
        return output.toString();
    }
    // 3
    public static boolean sucsessShoot(int x, int y, int r, int m, int n) {
        return Math.pow((m - x), 2) + Math.pow((n - y), 2) <= r * r;
    }
    // 4
    public static boolean parityAnalysis(int number) {
        int sumOfDigits = 0;
        int originalNumber = number;
        while (number > 0) {
            sumOfDigits += number % 10;
            number /= 10;
        }
        return originalNumber % 2 == sumOfDigits % 2;

    }
    // 5
    public static String rps(String player1, String player2) {
        if (player1.equals(player2)) {
            return "Tie";
        } else if ((player1.equals("rock") && player2.equals("scissors")) ||
                (player1.equals("paper") && player2.equals("rock")) ||
                (player1.equals("scissors") && player2.equals("paper"))) {
            return "Player 1 wins";
        } else {
            return "Player 2 wins";
        }
    }
    // 6
    public static int bugger(int number) {
        int count = 0;
        int n;
        while (number >= 10) {
            n = 1;
            while (number > 0) {
                n *= number % 10;
                number /= 10;
            }
            count++;
            number = n;
        }
        return count;
    }

    // 7
    public static String mostExpensive(Object[][] products) {
        int maxPrice = 0;
        String name = "";
        for (Object[] product : products) {
            int price = (int) product[1] * (int) product[2];
            if (price > maxPrice) {
                name = (String) product[0];
                maxPrice = price;
            }
        }
        return String.format("Наиб. общ. стоимость у предмета %s - %d", name, maxPrice);
    }
    // 8
    public static String longestUnique(String str) {
        Set<Character> charSet = new HashSet<>();
        int start = 0, end = 0;
        String longest = "";

        while (end < str.length()) {
            char currentChar = str.charAt(end);
            if (charSet.contains(currentChar)) {
                charSet.remove(str.charAt(start));
                start++;
            } else {
                charSet.add(currentChar);
                if (end - start + 1 > longest.length()) {
                    longest = str.substring(start, end + 1);
                }
                end++;
            }
        }
        return longest;
    }

    // 9
    public static boolean isPrefix(String word, String prefix) {
        return word.startsWith(prefix.substring(0, prefix.length() - 1));
    }

    public static boolean isSuffix(String word, String prefix) {
        return word.endsWith(prefix.substring(1));
    }

    // 10
    public static boolean doesBrickFit(int a, int b, int c, int w, int h) {
        return (a <= w && b <= h) || (a <= h && b <= w) ||
                (b <= w && c <= h) || (b <= h && c <= w) ||
                (a <= w && c <= h) || (a <= h && c <= w);
    }
}
