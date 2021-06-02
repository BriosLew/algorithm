import org.jetbrains.annotations.Contract;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class demo01 {
    public static void main(String[] args) {
/*
        while (true){
            Scanner scanner = new Scanner(System.in);
            int anInt = scanner.nextInt();
            if(getZ(anInt)){
                System.out.println("是质数");
            }
            else{
                System.out.println("不是质数");
            }
        }
*/

/*        try {
            int num = 0;
            fun(num);
        } catch (StackOverflowError s) {
            s.getMessage();
        }*/

        /*        System.out.println(factorial(3));*/

/*        double perimeter = getPerimeter(3);
        System.out.println(perimeter);*/

/*        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入用户名:");
            String username = scanner.next();
            System.out.println("请输入密码:");
            String password = scanner.next();
            RespBean result = login(username, password);
            if (result.getCode() == 200) {
                System.out.println("登录成功！");
                break;
            } else {
                System.out.println("登录失败！请重新输入");
            }
        }*/

        Integer[] array = new Integer[]{9,3,4,5,6,5,13,27,31,4,2,43,35,21,5};
        String[] strs = new String[]{"123","345","234","123","haha","哈哈","哈哈","haha"};
/*        array = mergeSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }*/
/*        for (int i : quickSort(array, 0, array.length)) {
            System.out.println(i);
        }*/
/*        for (int i : popSort(array)) {
            System.out.println(i);
        }*/

/*        for (int i : selectSort(array)) {
            System.out.println(i);
        }*/

        Object[] objects = dislodgeRepeat(array);
        for (Object object : objects) {
            System.out.println(object);
        }
        System.out.println("-----------------------");
        for (Object o : dislodgeRepeat(strs)) {
            System.out.println(o);
        }
    }

    @Contract(pure = true)
    private static Boolean getZ(int num) {
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static double getPerimeter(float radio) {
        return 2 * Math.PI * radio;
    }

    private static void fun(int num) {
        System.out.println("fun()" + num);
        fun(++num);
    }

    private static int factorial(int num) {
        if (num == 1) {
            return 1;
        }
        return num * factorial(--num);
    }

    final static String LOGIN_USERNAME = "admin";
    final static String LOGIN_PASSWORD = "admin";

    /**
     * 用户登录模拟
     * @param username
     * @param password
     * @return
     */
    private static RespBean login(String username, String password) {
        RespBean respBean = new RespBean();
        if (!LOGIN_USERNAME.equals(username) || !LOGIN_PASSWORD.equals(password)) {
            return respBean.error(500, "用户名或密码错误");
        } else {
            return respBean.success(200, "登录成功");
        }
    }

    /**
     * 归并排序
     * @param array
     * @return
     */
    private static int[] mergeSort(int[] array) {
        if(array.length <2)
            return array;
        int leftLength = array.length/2;
        int rightLength = array.length - leftLength;
        int[] left = new int[leftLength];
        int[] right = new int[rightLength];
        for (int i = 0; i < left.length; i++) {
            left[i] = array[i];
        }
        for (int i = leftLength; i < array.length; i++) {
            right[i-leftLength] = array[i];
        }
        return merge(mergeSort(left),mergeSort(right));
    }

    private static int[] merge(int[] left,int[] right){
        int[] temp = new int[left.length+right.length];
        int i = 0;

        while (left.length>0&&right.length>0){
            if(left[0]>right[0]){
                temp[i++] = right[0];
                right = Arrays.copyOfRange(right,1,right.length);
            }
            else{
                temp[i++] = left[0];
                left = Arrays.copyOfRange(left,1,left.length);
            }
        }

        while (left.length > 0){
            temp[i++] = left[0];
            left = Arrays.copyOfRange(left,1,left.length);
        }

        while (right.length > 0){
            temp[i++] = right[0];
            right = Arrays.copyOfRange(right,1,right.length);
        }
        return temp;
    }


    private static void swap(int[] array,int i,int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 快速排序
     * @param array
     * @param left
     * @param right
     * @return
     */
    private static int[] quickSort(int[] array,int left,int right){
        if(left < right){
            int parInt = partInt(array,left,right);
            quickSort(array,0,parInt - 1);
            quickSort(array,parInt + 1,right);
        }
        return array;
    }

    private static int partInt(int[] array,int left,int right){
        int pivot = array[left];
        int index = left+1;
        for(int i = index;i<right;i++){
            if(pivot>array[i]){
                swap(array,i,index);
                index++;
            }
        }
        swap(array,left,index-1);
        return index-1;
    }


    /**
     * 冒泡排序
     * @param array
     * @return
     */
    private static int[] popSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length-i-1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
        return array;
    }

    /**
     * 选择排序
     * @param array
     * @return
     */
    private static int[] selectSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int index = i;
            for (int j = i; j < array.length; j++) {
                if(min > array[j]){
                    index = j;
                    min = array[j];
                }
            }
            swap(array,i,index);
        }
        return array;
    }


    /**
     * 去重算法
     * @param o
     * @return
     */
    private static Object[] dislodgeRepeat(Object[] o){
        Object[] temp = new Object[o.length];
        int index = 0;
        for (int i = 0; i < o.length; i++) {
            int times = 0;
            for (int j = i+1; j < o.length; j++) {
                if(o[i].equals(o[j])){
                    times++;
                }
            }
            if(times<=0){
                temp[index++]=o[i];
            }
        }
        int nullCount=0;
        for (int i = 0; i < temp.length; i++) {
            if(temp[i]==null){
                nullCount++;
            }
        }
        Object[] result = new Object[temp.length-nullCount];
        result = Arrays.copyOfRange(temp, 0, result.length);
        return result;
    }
}
