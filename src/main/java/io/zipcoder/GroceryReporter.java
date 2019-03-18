package io.zipcoder;

import io.zipcoder.utils.FileReader;
import io.zipcoder.utils.Item;
import io.zipcoder.utils.ItemParseException;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GroceryReporter {
    private final String originalFileText;

    public GroceryReporter(String jerksonFileName) {
        this.originalFileText = FileReader.readFile(jerksonFileName);
    }


    @Override
    public String toString() {
        String r ="";
            ItemParser itemParser = new ItemParser();
            List<Item> items = itemParser.parseItemList(this.originalFileText);

            for (Item i : items) {
                r += "Name: " + i.getName()+"\n"+
                        "Price: " + i.getPrice();
            }return r;
//


    }
}
