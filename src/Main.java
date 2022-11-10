import java.util.Scanner;

class Array<T> {
    T[] array;
    int size;

    Array(int size){
        this.size = size;
        array = (T[])new Object[size];
    }

    public void set(int i, T value){
        array[i] = value;
    }

    public T get(int i){
        T value = array[i];
        return value;
    }

    public Integer getSize() {
        return size;
    }
}

public class Main {

    static void arrayCrRecurs(Array<Integer> a, int i){
        int min = -20;
        int max = 20;
        if (i < a.getSize()){
            a.set(i, (int) (Math.random() * (max - min)) + min);
            arrayCrRecurs(a, i + 1);
        }
    }

    static void printRecurs(Array<Integer> a, int i){
        if (i < a.getSize()){
            System.out.printf("%d\t", a.get(i));
            printRecurs(a, i + 1);
        } else {
            System.out.println();
        }
    }

    static void taskRecurs(Array<Integer> a, int i){
        if(i < a.getSize()){
            for (int j = 1; j < a.getSize() - i; j++) {
                if(a.get(j - 1) < a.get(j)){
                    int temp = a.get(j - 1);
                    a.set(j - 1, a.get(j));
                    a.set(j, temp);
                }
            }
            taskRecurs(a, i + 1);
        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Введіть кількість елементів: ");int size = scan.nextInt();

        Array<Integer> arr = new Array<>(size);
        arrayCrRecurs(arr, 0);
        printRecurs(arr, 0);
        taskRecurs(arr, 0);
        printRecurs(arr, 0);
    }
}