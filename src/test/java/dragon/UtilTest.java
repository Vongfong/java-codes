package dragon;

import com.dragon.util.StringUtils;

/**
 * Created by dsy on 2018/2/2
 */
public class UtilTest {

    public static void main(String[] args) {
        String str = StringUtils.replace("2018/2/2", "/", "-");
        System.out.println(str);
    }
}
