package SCN;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static SCN.Combination.String2Int;
import static SCN.Combination.StringArr2Int;
import static SCN.Combination.getSubsets;

public class Main {

    public static void main(String[] args) {
        String arr = "1 2 3 4 5";
        List<Integer> dat = new ArrayList<>();
        List<Set<Integer>> result = new ArrayList<>();
        String r = "3";
        int size = String2Int(r);
        dat = StringArr2Int(arr);
        result = getSubsets(dat,size);
        System.out.print(result);
    }
}
