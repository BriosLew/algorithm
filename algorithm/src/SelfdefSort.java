import org.junit.Test;

import java.util.Arrays;

public class SelfdefSort {
    @Test
    public void test(){
        int[] array = new int[]{58,9,3,4,5,6,5,13,27,31,4,2,43,35,21,5};
        String[] strs = new String[]{"123","345","234","123","haha","哈哈","哈哈","haha"};

/*        for (int i : quickSort(array, 0, array.length-1)) {
            System.out.println(i);
        }*/

/*        for (int i : mergeSort(array)) {
            System.out.println(i);
        }*/

/*        for (int i : popSort(array)) {
            System.out.println(i);
        }*/

/*        for (int i : selectSort(array)) {
            System.out.println(i);
        }*/

        for (Object o : dislodgeRepeat(strs)) {
            System.out.println(o);
        }
    }

    private void swap(int[] array,int i,int j){
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
    private int[] quickSort(int[] array,int left,int right){
        if(left < right){
            int index = demarcationIndex(array, left, right);
            quickSort(array,left,index-1);
            quickSort(array,index+1,right);
        }
        return array;
    }

    /**
     * 获取分界元素索引
     * @param array
     * @param left
     * @param right
     * @return
     */
    private int demarcationIndex(int[] array,int left,int right) {
        int pivot = array[left];
        int index = left + 1;
        for(int i = index; i <= right; i++){
            if (pivot > array[i]) {
                swap(array,index++,i);
            }
        }
        swap(array,left,index-1);
        return index-1;
    }

    int count = 0;

    /**
     * 归并排序
     * @param array
     * @return
     */
    /**
     * 拆分
     * @param array
     * @return
     */
    private int[] mergeSort(int[] array){
        if (array.length <2){
            return array;
        }

        int mid = array.length/2;
        int[] left = Arrays.copyOfRange(array,0,mid);
        int[] right = Arrays.copyOfRange(array,mid,array.length);

/*        System.out.println("---------------------------------");

        for (int i : left) {
            System.out.println(i);
        }

        System.out.println("---------"+(++count)+"-----------");

        for (int i : right) {
            System.out.println(i);
        }

        System.out.println("---------------------------------");*/

        return merge(mergeSort(left),mergeSort(right));
    }

    /**
     * 合并排序
     * @param left
     * @param right
     * @return
     */
    private int[] merge(int[] left,int[] right){
        int[] temp = new int[left.length+right.length];
        int index = 0;
        while (left.length>0&&right.length>0)
        {
            if(left[0]<=right[0]){
                temp[index++]=left[0];
                left = Arrays.copyOfRange(left,1,left.length);
            }else {
                temp[index++]=right[0];
                right = Arrays.copyOfRange(right,1,right.length);
            }
        }

        while (left.length>0){
            temp[index++]=left[0];
            left = Arrays.copyOfRange(left,1,left.length);
        }

        while (right.length>0){
            temp[index++]=right[0];
            right = Arrays.copyOfRange(right,1,right.length);
        }

        return temp;
    }

    /**
     * 冒泡排序
     * @param array
     * @return
     */
    private int[] popSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
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
    private int[] selectSort(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            int min = array[i];
            int index = i;
            for (int j = i; j < array.length; j++) {
                if(min > array[j]){
                    min = array[j];
                    index = j;
                }
            }
            swap(array,index,i);
        }
        return array;
    }

    /**
     * 去重算法
     * @param array
     * @return
     */
    private Object[] dislodgeRepeat(Object[] array){
        Object[] temp = new Object[array.length];
        int index = 0;
        //过滤重复元素
        for (int i = 0; i < array.length; i++) {
            int times = 0;
            for (int j = i; j < array.length; j++) {
                if (array[i].equals(array[j])){
                    times++;
                }
            }
            if (times <= 1){
                temp[index++] = array[i];
            }
        }

        int nullCount = 0;
        for (Object o : temp) {
            if (o==null) {
                nullCount++;
            }
        }
        Object[] result = new Object[temp.length-nullCount];
        result = Arrays.copyOfRange(temp,0,result.length);
        return result;
    }
}
