import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Semen on 24-Jan-17.
 */
public class Runner {
    public static void main(String[] args) {

        List<String> list = readListOfStrings(new File("input.txt"));
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (s.equals("рт3в3")) {
                String year = list.get(i - 5).replaceAll("\t", "");
                System.out.println("\n\n\n" + list.get(i - 5));
                System.out.println("@Override\n" +
                        "    public String[] get" + year + "answers(int variant) {\n" +
                        "        String s = \"-1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1\"; //40\n" +
                        "        switch (variant) {");
            }
            if (s.contains(" ")) {
                boolean b = false;
                int a = s.indexOf(" ");

                StringBuilder sb = new StringBuilder();
                String c = s.substring(a + 1, s.indexOf(" ", a + 1));
                String bPart = s.substring(s.indexOf(c)+c.length()+1, s.length());
                if (c.length() > 20) {
                    b = true;
                    for (char charact : s.substring(a + 1, s.indexOf(" ", a + 1)).toCharArray()) {
                        sb.append(charact);
                        sb.append(" ");
                    }
                }
                if (!b) {
                    System.out.println("case " + (++index) + ": return \"" + s.substring(s.indexOf(" ") + 1) + "\".split(\" \");");
                } else {
                    System.out.println("case " + (++index) + ": return \"" + sb.toString().substring(0, sb.toString().length() - 1) + " " + bPart + "\".split(\" \");");
                }
            }
            if (index == 10) {
                index = 0;
                System.out.println("}\nreturn s.split(\" \");\n" +
                        "    }");
            }
        }






        /*
        String a = "414232343244413321412231212423432433321331234423";
        String b = "43124334214213214241234313232323432324";
        String c = "22341242334242333414143142124131123412";
        String d = "33232131422324221323232132342423211334";
        String e = "14423322311412244233123422343324243442";
        String f = "32434233234241331131323132132312344234";
        String g = "42432124342143222134324231312213121341";
        String h = "32421223213243321413423443234434134411";
        String j = "23412411431443241312142332143122421223";
        String k = "42144341342231243434321243422113342231";
        List<String> list = new ArrayList<>();
        list.add(a);list.add(b);list.add(c);list.add(d);list.add(e);list.add(f);list.add(g);list.add(h);list.add(j);list.add(k);
        for (String s:list) {
            StringBuilder sb = new StringBuilder();
            for (char charact : s.toCharArray()) {
                sb.append(charact);
                sb.append(" ");
            }
            System.out.println(sb.toString());
        }
        System.out.println("4 1 4 2 3 2 3 4 3 2 4 4 4 1 3 3 2 1 4 1 2 2 3 1 2 1 2 4 2 3 4 3 2 4 3 3 3 2 1 3 3 1 2 3 4 4 2 3 AMBITIOUS AIMLESS DETERMINATION PUBLICITY TOWHICH ? PART USED IT EITHER MAKES ISIT".split(" ").length);
    */
    }

    public static List<String> readListOfStrings(File file) {
        BufferedReader br = null;
        List<String> listOfStrings = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader(file));
            String tempString = br.readLine();
            while (tempString != null) {
                listOfStrings.add(tempString);
                tempString = br.readLine();
            }
        } catch (IOException ex) {
            System.out.println("Reading from file successfully failed. IOException");
            ex.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException | NullPointerException ex) {
                System.out.println("Stream didn't closed or not exists. Reading from file failed. ");
            }
        }
        return listOfStrings;
    }
}
