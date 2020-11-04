import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {

    public static void main(String[] args) {

        System.out.println(sort("sssWWWWea"));
//            change("OIH（H2z$");
    }

    private static class SortString implements Comparable<String>{
        public SortString(String local) {
            this.local = local;
        }

        public String getLocal() {
            return local;
        }

        private String local;

        @Override
        public String toString() {
            return local;
        }

        @Override
        public int compareTo(String o) {
            int i = local.length() - o.length();
            if (i > 0){
                return -1;
            }
            if (i < 0){
                return 1;
            }
            return local.compareTo(o);
        }
    }

    private static String sort(String line) {
        //TODO
        String[] split = line.split("");
        List<SortString> sortStrings = new ArrayList<>();
        Map<String,String> map = new HashMap<>();
        for (String s : split) {
            boolean b = map.containsKey(s);
            if (b){
                String s1 = map.get(s);
                s1 = s1 + s;
                map.put(s,s1);
            }else{
                map.put(s,s);
            }
        }
        ArrayList<String> strings = new ArrayList<>(map.values());
        for (String s : strings) {
            sortStrings.add(new SortString(s));
        }
        sortStrings.sort((o1, o2) -> o1.compareTo(o2.getLocal()));
        return sortStrings.toString();
    }

    private static String change(String line) {
        String[] split = line.split("");
        List<String> result = new ArrayList<>();
        String lowRegex=".*[a-z]+.*";
        String upUegex=".*[A-Z]+.*";
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            Matcher m1= Pattern.compile(lowRegex).matcher(s);
            Matcher m2= Pattern.compile(upUegex).matcher(s);

            if (!m1.matches() && !m2.matches()) {
               continue;
            }
            if (m1.matches()){
                result.add(s.toUpperCase());
                continue;
            }
            if (m2.matches()){
                result.add(s.toLowerCase());
                continue;
            }
        }
        return result.toString();
    }
}