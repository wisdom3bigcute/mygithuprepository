package cn.itcast.bos.web.action.base;

import cn.itcast.bos.domain.base.Standard;
import cn.itcast.bos.service.base.StandardService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/12/23.
 */
@Controller
@Namespace("/")
@ParentPackage("json-default")
//@Transactional
@Scope("prototype")
public class StandardAction extends ActionSupport implements ModelDriven<Standard> {

    private Standard standard = new Standard();
    @Autowired
    public StandardService standardService;
    @Override
    public Standard getModel() {
        return standard;
    }
    @Action(value = "standard_save",results ={@Result(name = "success",type = "redirect",
    location = "./pages/base/standard.html")})
    public String save(){
        System.out.println("asdfggn");
        standardService.save(standard);
        return  SUCCESS;
    }}


