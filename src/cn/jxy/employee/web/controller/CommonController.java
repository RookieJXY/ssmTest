package cn.jxy.employee.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {
	
	/**
	 * 首页
	 * @return
	 */
	@RequestMapping("/")
	public String login(){
		return "/common/login";
	}
	
	/**
	 * 主页
	 * @return
	 */
	@RequestMapping("/index")
    public String index() {
        return "/common/index";
    }
	
	/**
	 * 中间实体页
	 * @return
	 */
	@RequestMapping("/dashboard")
    public String dashboard() {
        return "/common/dashboard";
    }
	
	/**
     * 404页
     * @return
	 */
    @RequestMapping("/404")
    public String error404() {
        return "/common/404";
    }

    /**
     * 401页
     * @return
	 */
    @RequestMapping("/401")
    public String error401() {
        return "/common/401";
    }

    /**
     * 500页
     * @return
	 */
    @RequestMapping("/500")
    public String error500() {
        return "/common/500";
    }
}