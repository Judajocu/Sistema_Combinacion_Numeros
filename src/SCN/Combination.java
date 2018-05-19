package SCN;

public class Combination
{
    static int[] Combine(int Nun2Combine, int[] Combined, int ArrSize)
    {
        int[] binary = new int[(int) Math.pow(2, ArrSize)];
        for (int i = 0; i < Math.pow(2, ArrSize); i++) {
            int b = 1;
            binary[i] = 0;
            int num = i, count = 0;
            while (num > 0) {
                if (num % 2 == 1)
                    count++;
                binary[i] += (num % 2) * b;
                num /= 2;
                b = b * 10;
            }
            if (count == Nun2Combine) {
                System.out.print("{ ");
                for (int j = 0; j < ArrSize; j++) {
                    if (binary[i] % 10 == 1)
                        System.out.print(Combined[j] + " ");
                    binary[i] /= 10;
                }
                System.out.println("}");
            }
        }
        return Combined;
    }


    static int[] StringArr2Int(String Numbers)
    {
        String[] integerStrings = Numbers.split(" ");
        int[] integers = new int[integerStrings.length];
        for (int i = 0; i < integers.length; i++)
        {
            integers[i] = Integer.parseInt(integerStrings[i]);
        }
        return integers;
    }

    static int String2Int(String Number)
    {
        int num = Integer.parseInt(Number);
        return num;
    }

        /*Driver function to check for above function*/
        public static void main (String[] args) {
            String arr = "1 2 3 4 5";
            String r = "3";
            int size = String2Int(r);
            int dat[] = StringArr2Int(arr);
            int result[] = Combine(size,  dat , dat.length);
        }


}
