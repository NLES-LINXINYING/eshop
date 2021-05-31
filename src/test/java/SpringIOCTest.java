import com.example.eshop.domain.*;
import com.example.eshop.service.*;
import com.example.eshop.serviceImpl.CategoryServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 * @version 1.0-SNAPSHOT
 * @ClassName SpringIOCTest.java
 * @Description 测试Spring环境配置是否成功
 * @createTime 2021-05-24 09:34:00
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpringIOCTest {

    @Resource
    private ICategoryService categoryService;
    @Resource
    private IAccountService accountService;
    @Resource
    private IProductService productService;
    @Resource
    private IForderService forderService;
    @Resource
    private ISorderService sorderService;

    @Test
    public void testQueryJoinAccount() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");

        for (String item : list) {
            if ("2".equals(item)) {
                list.remove(item);
            }
        }

        System.out.println(list);
    }
}
