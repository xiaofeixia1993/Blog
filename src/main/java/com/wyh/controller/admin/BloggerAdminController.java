package com.wyh.controller.admin;

import com.wyh.entity.Blogger;
import com.wyh.service.BloggerService;
import com.wyh.util.CryptographyUtil;
import com.wyh.util.DateUtil;
import com.wyh.util.ResponseUtil;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * 管理员博主Controller层
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/admin/blogger")
public class BloggerAdminController {

    @Resource
    private BloggerService bloggerService;

    /**
     * 查询博主信息
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/find")
    public String find(HttpServletResponse response)throws Exception{
        Blogger blogger=bloggerService.find();
        JSONObject jsonObject=JSONObject.fromObject(blogger);
        ResponseUtil.write(response, jsonObject);
        return null;
    }

    /**
     * 修改博主信息
     * @param imageFile
     * @param blogger
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/save")
    public String save(@RequestParam("imageFile") MultipartFile imageFile, Blogger blogger, HttpServletRequest request, HttpServletResponse response)throws Exception{
        if(!imageFile.isEmpty()){
            String filePath=request.getServletContext().getRealPath("/");
            String imageName= DateUtil.getCurrentDateStr()+"."+imageFile.getOriginalFilename().split("\\.")[1];
            imageFile.transferTo(new File(filePath+"static/userImages/"+imageName));
            blogger.setImageName(imageName);
        }
        int resultTotal=bloggerService.update(blogger);
        StringBuffer result=new StringBuffer();
        if(resultTotal>0){
            result.append("<script language='javascript'>alert('修改成功！');</script>");
        }else{
            result.append("<script language='javascript'>alert('修改失败！');</script>");
        }
        ResponseUtil.write(response, result);
        return null;
    }

    /**
     * 修改博主密码
     * @param newPassword
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/modifyPassword")
    public String modifyPassword(String newPassword,HttpServletResponse response)throws Exception{
        Blogger blogger=new Blogger();
        blogger.setPassword(CryptographyUtil.md5(newPassword,"wyh"));
        int resultTotal=bloggerService.update(blogger);
        JSONObject result=new JSONObject();
        if(resultTotal>0){
            result.put("success", true);
        }else{
            result.put("success", false);
        }
        ResponseUtil.write(response, result);
        return null;
    }
}
