import com.github.sd4324530.fastweixin.api.MenuAPI;
import com.github.sd4324530.fastweixin.api.OauthAPI;
import com.github.sd4324530.fastweixin.api.UserAPI;
import com.github.sd4324530.fastweixin.api.config.ApiConfig;
import com.github.sd4324530.fastweixin.api.entity.Menu;
import com.github.sd4324530.fastweixin.api.entity.MenuButton;
import com.github.sd4324530.fastweixin.api.enums.MenuType;
import com.github.sd4324530.fastweixin.api.enums.ResultType;
import com.github.sd4324530.fastweixin.api.response.GetMenuResponse;
import com.github.sd4324530.fastweixin.api.response.GetUserInfoResponse;
import com.github.sd4324530.fastweixin.api.response.OauthGetTokenResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZHUC on 2015/5/18.
 */
public class WeixinTest {

    private static final Logger logger = LoggerFactory.getLogger(WeixinTest.class);

    public static void main(String[] args) {
        String appid = "wx72a90033a587fc56";
        String secret = "fe0487d478bcfecee2f545e27ae271c8";
        ApiConfig config = new ApiConfig(appid, secret);
        createMenu(config);
//        getUserList(config);
//        uploadMedia(config);
//        downloadMedia(config);
//        getUserInfo(config);
//        getMenu(config);

    }

    public static void getToken(ApiConfig config) {
        OauthAPI oauthAPI = new OauthAPI(config);
        OauthGetTokenResponse response = oauthAPI.getToken("041821d373d6a18679cb0b1d8d5cc1ez");
        logger.debug("response:{}", response.toJsonString());
    }

    /**
     * 获取用户信息
     *
     * @param config API配置
     */
    public static void getUserInfo(ApiConfig config) {
        UserAPI userAPI = new UserAPI(config);
        GetUserInfoResponse userInfo = userAPI.getUserInfo("oyTI6txGWp_WZwwUVNb-zUzNOeD0");
        logger.debug(userInfo.toJsonString());
    }

    /**
     * 创建菜单
     *
     * @param config API配置
     */
    private static void createMenu(ApiConfig config) {
        MenuAPI menuAPI = new MenuAPI(config);

        //先删除之前的菜单
        menuAPI.deleteMenu();

        Menu request = new Menu();
        //准备一级主菜单
        MenuButton main1 = new MenuButton();
        main1.setType(MenuType.CLICK);
        main1.setKey("ludan");
        main1.setName("路单查询");

        //准备一级主菜单
        MenuButton main3 = new MenuButton();
        main3.setType(MenuType.CLICK);
//        main3.setUrl("http://117.135.167.106:14681/daikin");
        main3.setKey("bind");
        main3.setName("绑定账号");

        List<MenuButton> mainList = new ArrayList<MenuButton>();
        mainList.add(main1);
        mainList.add(main3);
        //将主菜单加入请求对象
        request.setButton(mainList);
        logger.debug(request.toJsonString());
        //创建菜单
        ResultType resultType = menuAPI.createMenu(request);
        logger.debug(resultType.toString());
    }

    public static void getMenu(ApiConfig config) {
        MenuAPI api = new MenuAPI(config);
        GetMenuResponse response = api.getMenu();
        logger.debug("菜单:{}", response.toJsonString());
    }
}
