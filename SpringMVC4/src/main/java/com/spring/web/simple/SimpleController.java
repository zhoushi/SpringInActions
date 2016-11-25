package com.spring.web.simple;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2016/11/25.
 */
@Controller
public class SimpleController {


    @RequestMapping(value = "/simple",method = RequestMethod.GET)
    public @ResponseBody String simple(){
        return "hello world!";
    }

    /**
     * post   使用postman可以调到，如果使用浏览器不通过动作请求则出现405错误，
     * @return
     */
    @RequestMapping(value = "/postRequest",method = RequestMethod.POST)
    public @ResponseBody String simplePost(){
        return "post request";
    }
}
