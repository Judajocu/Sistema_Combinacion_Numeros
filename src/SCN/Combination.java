package SCN;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jxl.Workbook;

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
        File txtField = new File(HomeFolder,FileName);
        outputWriter = new BufferedWriter(new FileWriter(txtField));
        outputWriter.write(result);
        outputWriter.newLine();
        outputWriter.flush();
        outputWriter.close();
    }

    public void Result2xsl(String result, String FileName) {
        String fileName = "test";
        File archivo = new File(fileName + ".xls");
        if (!archivo.exists()) {
            CrearExcel(archivo);
        }
        try {
            Workbook wb = Workbook.getWorkbook(archivo);
            WritableWorkbook copy = Workbook.createWorkbook(new File(fileName + ".xls"), wb);
            WritableSheet hoja = copy.getSheet(0);
            hoja.addCell(numero);
            copy.write();
            copy.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
//            JOptionPane.showMessageDialog(null, "Se ha generado el reporte en la siguiente ruta:" + Ruta, "Reporte generado!", JOptionPane.INFORMATION_MESSAGE,informacion);
    }

    private void CrearExcel(File archivo) {
        try {
            WritableWorkbook workbook = Workbook.createWorkbook(archivo);
            workbook.createSheet("Hojad de Datos", 0);
            WritableSheet hoja = workbook.getSheet(0);
            Label col1 = new Label(0, 0, "Numero");
            Label col2 = new Label(1, 0, "Fecha");
            Label col3 = new Label(2, 0, "Lote");
            Label col4 = new Label(3, 0, "Lugar");
            Label col5 = new Label(4, 0, "Tipo");
            Label col6 = new Label(5, 0, "Grado");
            Label col7 = new Label(6, 0, "Bultos");
            Label col8 = new Label(7, 0, "Libras");
            Label col9 = new Label(8, 0, "Piso");
            Label col10 = new Label(9, 0, "UbicaciÃ³n");
            Label col11 = new Label(10, 0, "Hombres");
            Label col12 = new Label(11, 0, "Mujeres");
            Label col13 = new Label(12, 0, "Elaborado por");
            Label col14 = new Label(13, 0, "Supervisor");

            hoja.addCell(col1);
            hoja.addCell(col2);
            hoja.addCell(col3);
            hoja.addCell(col4);
            hoja.addCell(col5);
            hoja.addCell(col6);
            hoja.addCell(col7);
            hoja.addCell(col8);
            hoja.addCell(col9);
            hoja.addCell(col10);
            hoja.addCell(col11);
            hoja.addCell(col12);
            hoja.addCell(col13);
            hoja.addCell(col14);

            workbook.write();
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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

