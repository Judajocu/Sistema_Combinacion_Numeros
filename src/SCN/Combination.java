package SCN;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Combination
{
    private static void getSubsets(List<Integer> superSet, int k, int idx, Set<Integer> current, List<Set<Integer>> solution) {
        //successful stop clause
        if (current.size() == k) {
            solution.add(new HashSet<>(current));
            return;
        }
        //unseccessful stop clause
        if (idx == superSet.size()) return;
        Integer x = superSet.get(idx);
        current.add(x);
        //"guess" x is in the subset
        getSubsets(superSet, k, idx+1, current, solution);
        current.remove(x);
        //"guess" x is not in the subset
        getSubsets(superSet, k, idx+1, current, solution);
    }

    public static List<Set<Integer>> getSubsets(List<Integer> superSet, int k) {
        List<Set<Integer>> res = new ArrayList<>();
        getSubsets(superSet, k, 0, new HashSet<Integer>(), res);
        return res;
    }


    static List<Integer> StringArr2Int(String Numbers)
    {
        String[] integerStrings = Numbers.split(" ");
        List<Integer> Converted = new ArrayList<>();
        for (int i = 0; i < integerStrings.length; i++)
        {
            int num = Integer.parseInt(integerStrings[i]);
            Converted.add(num);
        }
        return Converted;
    }

    static int String2Int(String Number)
    {
        int num = Integer.parseInt(Number);
        return num;
    }

    static void Result2txt(List<Set<Integer>> result, String FileName) throws IOException {
        BufferedWriter outputWriter = null;
        outputWriter = new BufferedWriter(new FileWriter(FileName));
        outputWriter.write(result.toString());
        outputWriter.newLine();
        outputWriter.flush();
        outputWriter.close();
    }

        /*Driver function to check for above function*/
        public static void main (String[] args) {
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
