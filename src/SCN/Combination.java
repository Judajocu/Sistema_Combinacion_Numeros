package SCN;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Combination
{
    public void getSubsets(List<Integer> superSet, int k, int idx, Set<Integer> current, List<Set<Integer>> solution) {
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

    public  List<Set<Integer>> getSubsets(List<Integer> superSet, int k) {
        List<Set<Integer>> res = new ArrayList<>();
        getSubsets(superSet, k, 0, new HashSet<Integer>(), res);
        return res;
    }


    public List<Integer> StringArr2Int(String Numbers)
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

    public int String2Int(String Number)
    {
        int num = Integer.parseInt(Number);
        return num;
    }

    public void Result2txt(String result, String FileName) throws IOException {
        BufferedWriter outputWriter = null;
        String HomeFolder = System.getProperty("user.home")+ "/Desktop";
        File txtField = new File(HomeFolder,FileName+".txt");
        outputWriter = new BufferedWriter(new FileWriter(txtField));
        outputWriter.write(result);
        outputWriter.newLine();
        outputWriter.flush();
        outputWriter.close();
    }

    public void Result2csv(List<Set<Integer>> result, String FileName) throws IOException {
        String textResult = "";
        for (Set<Integer> s : result){

            for (Integer i : s) {
                textResult= textResult.concat(i+", ");
            }
            textResult=textResult.substring(0,textResult.length()-1).concat("\n");
        }
        BufferedWriter outputWriter = null;
        String HomeFolder = System.getProperty("user.home")+ "/Desktop";
        File txtField = new File(HomeFolder,FileName+".csv");
        outputWriter = new BufferedWriter(new FileWriter(txtField));
        outputWriter.write(textResult);
        outputWriter.newLine();
        outputWriter.flush();
        outputWriter.close();
    }

   /* public static void main(String[] args) {
        *//*String arr = "1 2 3 4 5";
        List<Integer> dat = new ArrayList<>();
        List<Set<Integer>> result = new ArrayList<>();
        String r = "3";
        int size = String2Int(r);
        dat = StringArr2Int(arr);
        result = getSubsets(dat,size);
        System.out.print(result);*//*
    }*/

}
