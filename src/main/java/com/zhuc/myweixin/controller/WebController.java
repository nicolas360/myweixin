package com.zhuc.myweixin.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.zhuc.myweixin.utils.DateTools;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;


/**
 * Created by ZHUC on 2015/5/25.
 */
@Controller
@RequestMapping("/web")
public class WebController {

    private static final Logger logger = LoggerFactory.getLogger(WebController.class);

    private Long id = 1l;
    private Long num = 20150523000l;

    /**
     * 绑定页面
     * @param openId
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/bindPage")
    public String bindPage(String openId, ModelMap modelMap){
        String view = null;
        if(DataSource.isExistsInBindMap(openId)){
            view = "bindOk";
        } else {
            view = "bindPage";
        }
        modelMap.put("openId", openId);

        return view;
    }

    /**
     * 绑定
     * @param name
     * @param password
     * @param openId
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/bind")
    public String bind(String name, String password, String openId, ModelMap modelMap){
        String view = null;
        if("1".equals(name) && "1".equals(password)){
            view = "bindOk";
            DataSource.addToBindMap(openId, name);
            logger.debug("你的微信号{}与账号{}绑定成功", new Object[]{openId, name});
        } else {
            view = "bindError";
        }
        modelMap.put("openId", openId);

        return view;
    }

    /**
     * 解除绑定
     * @param openId
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/unbind")
    public String unbind(String openId, ModelMap modelMap){
        modelMap.put("openId", openId);
        DataSource.removeFromBindMap(openId);
        logger.debug("你的微信号{}解绑成功", new Object[]{openId});

        return "redirect:bindPage";
    }

    /**
     * 路单查询页面
     * @param openId
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/ludanPage")
    public String ludanPage(String openId, String start, String end, ModelMap modelMap){
        String view = null;
        if(!DataSource.isExistsInBindMap(openId)){
            view = "bindPage";
        } else {
            view = "ludan";
        }
        modelMap.put("openId", openId);
        if(StringUtils.isBlank(start) && StringUtils.isBlank(end)){
            DateTime s2 = new DateTime();
            DateTime s1 = s2.dayOfMonth().addToCopy(-3);
            start = DateTools.dateFormartDay(s1.toDate());
            end = DateTools.dateFormartDay(s2.toDate());
        }
        modelMap.put("start", start);
        modelMap.put("end", end);

        return view;
    }

    /**
     * 路单查询
     * @param openId
     * @param start
     * @param end
     * @return
     */
    @RequestMapping(value = "/ludan")
    public @ResponseBody
    Map<String, Object> ludan(String openId, String start, String end){
        Map<String, Object> map = Maps.newHashMap();
        List<LudanVo> list = Lists.newArrayList();

        list.add(new LudanVo(1l, "20150523001", "王小钊", "在途"+(id++), "2015-05-23 10：40", "2015-05-31 11：56"));
        list.add(new LudanVo(2l, "20150523002", "王小钊", "在途"+(id++), "2015-05-23 10：40", "2015-05-31 11：56"));
        list.add(new LudanVo(3l, "20150523003", "王小钊", "在途"+(id++), "2015-05-23 10：40", "2015-05-31 11：56"));
        list.add(new LudanVo(4l, "20150523004", "王小钊", "在途"+(id++), "2015-05-23 10：40", "2015-05-31 11：56"));
        list.add(new LudanVo(5l, "20150523005", "王小钊", "在途"+(id++), "2015-05-23 10：40", "2015-05-31 11：56"));
        map.put("list", list);

        return map;
    }

    @RequestMapping(value = "/ludanDetailPage")
    public String ludanDetailPage(Integer id){
        return "ludanDetail";
    }

}
