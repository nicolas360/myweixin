import com.zhuc.myweixin.utils.DefinedPropertyConfigurer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by ZHUC on 2015/6/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/applicationContext.xml" })
public class SpringTest {

    @Test
    public void test(){
        String s = DefinedPropertyConfigurer.getContextProperty("BIND_URL");
        System.out.println(s);
    }
}
