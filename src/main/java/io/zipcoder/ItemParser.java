package io.zipcoder;

import io.zipcoder.utils.Item;
import io.zipcoder.utils.ItemParseException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemParser {
    Item newItem;
    String name;
    double price;
    String type;
    String expiration;

    public List<Item> parseItemList(String valueToParse) {
        String[] arr = valueToParse.split("##");
        List<Item> items = new ArrayList<>();

        for (int i = 0; i <arr.length; i++) {

            try {
                items.add(parseSingleItem(arr[i]));
            } catch (ItemParseException e) {
//
            }
        }return items;

//            if(!arrayList.get(i).equals(" ")){
//            newItem = new Item(arrayList.get(i),Double.parseDouble(arrayList.get(i+1)),
//                    arrayList.get(i+2),arrayList.get(i+3));}


        }









    public ArrayList<String> toArrayList (String string){
        String[] split = string.toLowerCase().split("[(:@*%,^#;)]");
        String [] remove ={"name","price","expiration","type"};
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(split));
        arrayList.removeAll(Arrays.asList(remove));
        return arrayList;
    }


    public Item parseSingleItem(String singleItem) throws ItemParseException {

        ArrayList<String> arrayList = toArrayList(singleItem);

        System.out.println(Arrays.asList(arrayList.toArray()));
        {
            try {
                newItem = new Item(arrayList.get(0),
                        Double.valueOf(arrayList.get(1)),
                        arrayList.get(2), arrayList.get(3));
            } catch (IndexOutOfBoundsException e) {
                throw new ItemParseException();
            }
            return newItem;
        }
    }
//        System.out.println(arrayList.size());
//
//
//        System.out.println(Arrays.asList(split));
//        for (int i = 0; i <split.length ; i++) {
//            if(split[i].equals("name")){
//                arrayList.add(split[i]);
//            }
//
//        }


//        StringBuilder replaced = new StringBuilder();
//        for(String s : split){
//            replaced.append(s.replace("name","")
//                    .replace("type","")
//                    .replace("price","")
//                    .replace("expiration",""))
//                    .append(" ");
////            replaced.append(",");
//        }
//        String toString = replaced.toString();
//
//
//        System.out.println(replaced);
//
//        String[] newArray = toString.split(" ");
//        System.out.println("newArray "+ Arrays.asList(newArray));



//        String name = "name\\s";
//        Pattern pattern = Pattern.compile(name, Pattern.CASE_INSENSITIVE);
//        Matcher matcher = pattern.matcher(replaced.toString());
//
//        StringBuffer replaced1 = new StringBuffer();
//        if (matcher.find()) {
//            matcher.appendReplacement(replaced1, " ");
//            newItem = new Item(newArray[0], 0.0, null, null);
//        }
//        System.out.println(replaced1);


    public static void main(String[] args) {

    }

    public String replace(String singleItem) {
//        String[] split = singleItem.toLowerCase().split("[(:@*%#;)]");
//        StringBuffer replaced = new StringBuffer();
//        for(String s : split){
//        replaced.append(s);
//        replaced.append(" ");
//        }

        StringBuffer replaced = new StringBuffer();
        String name = "([a-zA-Z]+)[:@%#;)]+";

        Pattern pattern = Pattern.compile(name, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(singleItem);
//        replaced.toString().matches(name);

        if (matcher.find()) {
            matcher.appendReplacement(replaced, " ");
            replaced.append(matcher.group(1));
        }

        System.out.println("this" +replaced.toString());
        matcher.appendTail(replaced);
        return replaced.toString();
    }

}
