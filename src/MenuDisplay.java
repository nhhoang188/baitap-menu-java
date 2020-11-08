import java.util.Scanner;

public class MenuDisplay {
    public static void main(String[] args) {
        int n = checkN();
        NisPrime(n);
        listNprime(n);
        int[] arr = inputArrays(n);
        listPrimeofArray(arr);
        CheckNofArray(arr);
        SortArray(arr);
        SortArray(addXtoArray(arr));
        DeleteNofArray(arr);
    }

    public static int[] addXtoArray(int[] arr) {
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        int[] arrnew = new int[arr.length + 1];
        for (int i = 0; i < arrnew.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arrnew[i] = arr[j];
            }
        }
        return arrnew;
    }

    public static void SortArray(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("Sap Xep Mang Tang Dan: ");
        for (int i : arr) {
            System.out.print(i + ",");
        }
    }

    public static void DeleteNofArray(int[] arr) {
        int n = arr.length;
        boolean exit = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n) {
                System.arraycopy(arr, i + 1, arr, i, arr.length - 1 - i);
                arr[arr.length - 1] = 0;
                exit = false;
            }
        }
        if (exit) {
            System.out.println("\nGia Tri " + n + "Khong co trong mang.");
        } else {
            System.out.println("Mang sau khi da xoa " + n + " ra la:");
            for (int i : arr) {
                System.out.print(i + ",");
            }
        }
    }

    public static void CheckNofArray(int[] arr) {
        int n = arr.length;
        boolean exit = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n) {
                System.out.println("\n" + arr[i] + " Co Ton Tai Trong Mang Va Nam o Vi Tri Thu " + i);
                exit = true;
                break;
            }
        }
        if (!exit) {
            System.out.println("\n" + n + " khong co trong mang ");
        }
    }

    public static void listPrimeofArray(int[] arr) {
        System.out.print("\nCac So Nguyen To Trong Mang La : ");
        for (int j : arr) {
            if (isPrime(j)) {
                System.out.print(j + ",");
            }
        }
    }

    public static int[] inputArrays(int n) {
        int[] arr = new int[n];
        int count = 0;
        while (count < n) {
            Scanner input = new Scanner(System.in);
            System.out.println("Nhap Phan Tu Thu " + count + " Cua Mang: ");
            arr[count] = input.nextInt();
            count++;
        }
        System.out.print("Mang gom " + n + " Phan Tu La: ");
        for (int a : arr) {
            System.out.print(a + ",");
        }
        return arr;
    }

    public static void listNprime(int n) {
        int count = 0, number = 2;
        int[] arr = new int[n];
        while (count < n) {
            if (isPrime(number)) {
                arr[count] = number;
                count++;
            }
            number++;
        }
        System.out.print(n + " So Nguyen To Dau Tien La: ");
        for (int a : arr) {
            System.out.print(a + ",");
        }
        System.out.println();

    }

    public static int checkN() {
        do {
            Scanner input = new Scanner(System.in);
            System.out.print("Nhap So N le, N > 0 : ");
            int n = input.nextInt();
            if (inputN(n)) {
                return n;
            } else {
                System.out.print("N Khong Thoa Man Moi Ban ");
            }
        } while (true);

    }

    public static void NisPrime(int n) {
        if (isPrime(n)) {
            System.out.println("So " + n + " La SNT");
        } else {
            System.out.println("So " + n + " Khong La SNT");
        }
    }

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        } else {
            int i = 2;
            boolean check = true;
            while (i <= Math.sqrt(number)) {
                if (number % i == 0) {
                    check = false;
                    break;
                }
                i++;
            }
            return check;
        }
    }

    public static boolean inputN(int n) {
        boolean b = true;
        if (n % 2 == 1) {
            return b;
        } else {
            return false;
        }
    }
}
