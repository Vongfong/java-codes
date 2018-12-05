package dragon;

import java.util.ArrayList;
import java.util.List;
public class TestCollection {
    public static void main(String[] args) {
        List<String> strList = new ArrayList<String>();
        List<String> strList2 = new ArrayList<String>();
        for(int i = 0; i < 10; i ++) {
            strList.add("aaa>>" + i);
            strList2.add("aaa>>" + (10 - i*2));
        }
        strList.add(null);
        strList.add(null);
        strList2.add(null);
         
        //求出交集
        strList.retainAll(strList2);
        System.out.println("交集大小：" + strList.size());
         
        for(int i = 0; i < strList.size(); i++) {
            System.out.println(strList.get(i));
        }       
    }
}