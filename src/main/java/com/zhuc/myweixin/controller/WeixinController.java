package com.zhuc.myweixin.controller;

import com.alibaba.fastjson.JSON;
import com.github.sd4324530.fastweixin.message.BaseMsg;
import com.github.sd4324530.fastweixin.message.TextMsg;
import com.github.sd4324530.fastweixin.message.req.BaseEvent;
import com.github.sd4324530.fastweixin.message.req.ImageReqMsg;
import com.github.sd4324530.fastweixin.message.req.MenuEvent;
import com.github.sd4324530.fastweixin.message.req.TextReqMsg;
import com.github.sd4324530.fastweixin.servlet.WeixinControllerSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by ZHUC on 2015/5/18.
 */
@RestController
@RequestMapping("/interface/receive")
public class WeixinController extends WeixinControllerSupport {

    private static final Logger logger = LoggerFactory.getLogger(WeixinController.class);
    private static final String TOKEN = "anji";
    private static final String BIND_URL = "http://221.130.184.31:10080/myweixin/web/bindPage?openId=";
    private static final String LUDAN_URL = "http://221.130.184.31:10080/myweixin/web/ludanPage?openId=";

    //设置TOKEN，用于绑定微信服务器
    @Override
    protected String getToken() {
        return TOKEN;
    }

    //重写父类方法，处理对应的微信消息
    @Override
    protected BaseMsg handleTextMsg(TextReqMsg msg) {
        String content = msg.getContent();
        logger.debug("用户发送文本内容:{} by {}", new Object[]{content, msg.getFromUserName()});
        return null;
    }

    @Override
    protected BaseMsg handleImageMsg(ImageReqMsg msg) {
        logger.debug(JSON.toJSONString(msg, true));
        return super.handleImageMsg(msg);
    }

    @Override
    protected BaseMsg handleSubscribe(BaseEvent event) {
        logger.debug("{}已关注", new Object[]{event.getFromUserName()});
        TextMsg msg = new TextMsg();
        msg.add("请先绑定账号吧！");
        msg.addLink("立即绑定", BIND_URL + event.getFromUserName());
        return msg;
    }

    @Override
    protected BaseMsg handleUnsubscribe(BaseEvent event) {
        logger.debug("{}取消了关注", new Object[]{event.getFromUserName()});
        return super.handleUnsubscribe(event);
    }

    @Override
    protected BaseMsg handleMenuClickEvent(MenuEvent event) {
        logger.debug(JSON.toJSONString(event, true));
        String key = event.getEventKey();

        BaseMsg msg = null;
        if ("ludan".equals(key)) {
            TextMsg temp = new TextMsg();
            temp.addLink("路单查询", LUDAN_URL + event.getFromUserName());
            msg = temp;

        } else if ("bind".equals(key)){
            TextMsg temp = new TextMsg();
            temp.addLink("立即绑定", BIND_URL + event.getFromUserName());
            msg = temp;
        }


        return msg;
    }



//    /*1.1版本新增，重写父类方法，加入自定义微信消息处理器
//     *不是必须的，上面的方法是统一处理所有的文本消息，如果业务觉复杂，上面的会显得比较乱
//     *这个机制就是为了应对这种情况，每个MessageHandle就是一个业务，只处理指定的那部分消息
//     */
//    @Override
//    protected List<MessageHandle> initMessageHandles() {
//        List<MessageHandle> handles = Lists.newArrayList();
//        handles.add(new MyTextMessageHandle());
//        return handles;
//    }

//    //1.1版本新增，重写父类方法，加入自定义微信事件处理器，同上
//    @Override
//    protected List<EventHandle> initEventHandles() {
//        List<EventHandle> handles = Lists.newArrayList();
//        handles.add(new MyEventHandle());
//        return handles;
//    }

}
