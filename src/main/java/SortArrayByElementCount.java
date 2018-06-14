import com.google.common.base.Joiner;
import com.google.common.primitives.Ints;

import java.util.*;
import java.util.stream.Collectors;

public class SortArrayByElementCount {

    public static int[] sortArrayByElementCount(int[] array) {
        if(array.length == 0){
            throw new ArraySortException("Provided array is empty");
        }
        Arrays.sort(array);
        Map<Integer, Integer> map = getValueCountMap(array);
        Map<Integer, Integer> sortedMap = sortMapByValue(map);
        return convertMapToArray(sortedMap,array);
    }

    //преобразования map в массив с учетом количества повторений каждого элемента
    private static int[] convertMapToArray(Map<Integer, Integer> sortedMap, int[] arrayToReturn) {
        int countElements = 0;
        for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                arrayToReturn[countElements] = entry.getKey();
                countElements++;
            }
        }
        return arrayToReturn;
    }

    //map key - значение, value - количество повторов
    private static Map<Integer, Integer> getValueCountMap(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i] == array[j]) {
                    count++;
                }
            }
            if (!map.containsKey(array[i])) {
                map.put(array[i], count);
            }
            count = 0;
        }
        return map;
    }

    //сортировка map по значению
    private static Map<Integer, Integer> sortMapByValue(Map<Integer, Integer> map) {
        return map.entrySet().stream().sorted(Map.Entry.comparingByValue())
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (e1, e2) -> e1, LinkedHashMap::new));
    }

    public static String arrayToString(int[] array){
        return "["+Joiner.on(", ").join(Ints.asList(sortArrayByElementCount(array)))+"]";
    }

    public static Boolean areArraysEqual(int[] a1, int[] a2){
        if(a1.length!=a2.length){
            return false;
        }
        for (int i = 0; i <a1.length ; i++) {
            if(a1[i]!=a2[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] array = {7, 4, 3, 6, 3, 7, 1, 7, 7, 0, 0, 8, 8, 0, 0, 0};
        int[] correctArray = {1, 4,  3, 3,6, 8, 8, 7, 7, 7, 7, 0, 0, 0, 0,0};
        int[] arrayForCheck = SortArrayByElementCount.sortArrayByElementCount(array);


        System.out.println(areArraysEqual(correctArray,arrayForCheck));
        System.out.println(arrayToString(array));
        System.out.println(arrayToString(correctArray));
        System.out.println(arrayToString(arrayForCheck));
    }

}





