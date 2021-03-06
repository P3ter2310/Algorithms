public class Main {

    public static void merge(int arr[], int l, int m, int r)
    {
        int size1 = m - l + 1;
        int size2 = r - m;

        int L[] = new int[size1];
        int R[] = new int[size2];

        for (int i = 0; i < size1; i++) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < size2; j++) {
            R[j] = arr[m + 1 + j];
        }

        int i = 0, j = 0;
        int k = l;
        while (i < size1 && j < size2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < size1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < size2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void sort(int arr[], int l, int r)
    {
        if (l < r) {
            int m = l + (r - l) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    public static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = {11,3,6,4,23};

        printArray(arr);

        sort(arr,0,arr.length - 1);

        printArray(arr);
    }
}