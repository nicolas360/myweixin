package com.zhuc.myweixin.controller;

import com.github.sd4324530.fastweixin.handle.MessageHandle;
import com.github.sd4324530.fastweixin.message.BaseMsg;
import com.github.sd4324530.fastweixin.message.TextMsg;
import com.github.sd4324530.fastweixin.message.req.TextReqMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ZHUC on 2015/5/19.
 */
public class MyTextMessageHandle implements MessageHandle<TextReqMsg> {

    private static final Logger logger = LoggerFactory.getLogger(MyTextMessageHandle.class);
    @Override
    public BaseMsg handle(TextReqMsg textReqMsg) {
        logger.debug("handle");
        TextMsg msg = new TextMsg();
        msg.add("handle: "+textReqMsg.getContent());
        return msg;
    }

    @Override
    public boolean beforeHandle(TextReqMsg textReqMsg) {
        logger.debug("beforeHandle");
        return true;
    }
}
