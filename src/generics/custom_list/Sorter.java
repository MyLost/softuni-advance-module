package generics.custom_list;

public class Sorter {

    public static<T extends Comparable<T>> void sort(CustomList<T> list) {
        for (int i = 0; i < list.size(); i++) {
            T current = list.get(i);
            for (int j = 0; j < list.size(); j++) {
                if(current.compareTo(list.get(j)) < 0) {
                    list.swap(i,j);
                }
            }
        }
    }
}
