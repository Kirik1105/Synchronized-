public class Main {

    public static void main(String[] args) {
        Main e2 = new Main();
        System.out.println("Старт main потока");
        long a = System.currentTimeMillis();
        new Thread(() -> e2.method1(a)).start();
        new Thread(() -> e2.method2(a)).start();
    }

    public void method1(long a) {
        final int SIZE = 10000000;
        final int HALF = SIZE / 2;
        float[] arr = new float[SIZE];
        for (int i = 0; i < SIZE; i++)
            arr[i] = 1;
        System.out.println("Метод 1 запущен");
        System.out.println("Запуск одинарного массива");
        for (int i = 0; i < SIZE; i++)
            arr[i] = (int) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));

        System.out.println(System.currentTimeMillis() - a);

        System.out.println("Завершение одинарного массива");
        System.out.println("Метод 1 завершил свою работу");
    }

    public void method2(long a) {
        final int SIZE = 10000000;
        final int HALF = SIZE / 2;
        float[] arr = new float[SIZE];
        for (int i = 0; i < SIZE; i++)
            arr[i] = 1;
        System.out.println("Метод 2 запущен");
        System.out.println("Запуск двойного массива");
        float[] a1 = new float[HALF];
        float[] a2 = new float[HALF];
        System.arraycopy(arr, 0, a1, 0, HALF);
        System.arraycopy(arr, 0, a2, 0, HALF);

        for (int i = 0; i < HALF; i++) {
            a1[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));

        }
        for (int i = 0; i < HALF; i++) {
            a2[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.arraycopy(a1, 0, arr, 0, HALF);
        System.arraycopy(a2, 0, arr, HALF, HALF);


        System.out.println(System.currentTimeMillis() - a);

        System.out.println("Завершение двойного массива");
        System.out.println("Метод 2 завершил свою работу");
    }
}
