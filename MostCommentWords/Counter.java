package MostCommentWords;

import java.util.Set;

interface Counter<K extends Comparable<K>, V> {
    int getCount(K word);
    Set<K> keySet();
    void put(K keyWord, V word);
    String get(K word);
}