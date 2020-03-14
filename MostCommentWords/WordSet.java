package MostCommentWords;


// package MostCommentWords;


import java.util.*;


public class WordSet<K extends Comparable<K>, V> implements Counter<K, V> {

    //    Counter<String, String> words = new WordSet<>();
    private HashMap<K, LinkedList<Object>> wordCounts;

    public WordSet() {
        wordCounts = new HashMap<K,LinkedList<Object>>();
    }

    public String get(K word) {
        //Enter code here
        int count = getCount(word);
        StringBuilder result = new StringBuilder();

        result.append("total count: ").append(count-1); //add the "total" number into the String

//        for(Object v : wordCounts.get(word)){
//            result.append(wordCounts).append(",");
//        }

        for(int  i=1; i<wordCounts.get(word).size(); i++){
            result.append(wordCounts.get(word).get(i)).append(",");
        }
//        //remove the last ,
        //result.deleteCharAt(result.length() - 1);
        return result.toString();
    }



    public int getCount(K word) {
        //Enter code here
        LinkedList<Object> vals = wordCounts.get(word);

        return vals.size();
    }

    public Set<K> keySet() {
        //Enter code here
        return wordCounts.keySet();
    }

    //Enter code here
    //check different scenario://
    // (1) there is no this keyword, then create an empty LinkedList, and add this keyword into this list
    // (2) there is a keyWord, but there is not value(word) in this bucket
    public void put(K keyWord, V word) {
        //Enter code here

        if(!wordCounts.containsKey(keyWord)){
            LinkedList<Object> wordList = new LinkedList<Object>();

            wordList.add(1);
            wordList.add(word);
            wordCounts.put(keyWord, wordList);
        }
        else{
            int a = (int)wordCounts.get(keyWord).getFirst();
            if(!wordCounts.get(keyWord).contains(word)){
                wordCounts.get(keyWord).add(word);
            }
            wordCounts.get(keyWord).set(0, a+1);
        }

    }
}



