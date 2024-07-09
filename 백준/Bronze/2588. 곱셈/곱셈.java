import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 받기
        int a = scanner.nextInt();
        String b = scanner.next();

        // b의 각 자리 숫자에 대해 거꾸로 곱셈 수행 및 출력
        for (int i = b.length() - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(b.charAt(i));
            System.out.println(a * digit);
        }

        // a와 b 전체 숫자 곱셈 결과 출력
        System.out.println(a * Integer.parseInt(b));

        scanner.close();
    }
}
