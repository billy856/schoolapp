package com.shpc.schoolapp.controller;

import com.shpc.schoolapp.model.*;
import com.shpc.schoolapp.repository.*;
import com.shpc.schoolapp.util.DateUtil;
import com.shpc.schoolapp.util.Md5Util;
import com.shpc.schoolapp.util.StatusReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class MainController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    XinwenRepository xinwenRepository;
    @Autowired
    XinwenlistRepository xinwenlistRepository;
    @Autowired
    CuleRepository culeRepository;
    @Autowired
    CommentRepository commentRepository;

    Map<String,Object> map=new HashMap<String,Object>();

    @RequestMapping("/")
    public String index(){
        return "123456";
    }


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestParam(value = "usertel", required = true) String usertel,
                        @RequestParam(value = "userpassword", required = true) String userpassword) throws Exception{
        try{
            User user =userRepository.findByUsertelAndUserpassword(usertel, Md5Util.getMd5(userpassword));
            if (user == null){
                return StatusReport.buildResult(405,null,null);
            }else {
                map.put("User",user);
                user.setUserlastlogin(DateUtil.getUserDate());
                userRepository.save(user);
                return StatusReport.buildResult(200,map,null);
            }
        }catch (Exception e){
            return StatusReport.buildStringResult(400,null,e.getMessage());
        }finally {
            map.clear();
        }

    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(@RequestParam(value = "usertel", required = true) String usertel,
                           @RequestParam(value = "userpassword", required = true) String userpassword,
                           @RequestParam(value = "username", required = true) String username,
                           @RequestParam(value = "userid", required = true) String userid,
                           @RequestParam(value = "usersex", required = true) String usersex) throws Exception{
        try{
            List<User> users =userRepository.findByUsertelOrUserid(usertel,userid);
            if (users.size() != 0){
                return StatusReport.buildStringResult(400,null,"The userid or usertel are existed");
            }else{
                User user = new User();
                user.setUserid(userid);
                user.setUsername(username);
                user.setUserpassword(Md5Util.getMd5(userpassword));
                user.setUsertel(usertel);
                user.setUserlevel("2");
                user.setUsersex(usersex);
                user.setUserlastlogin(DateUtil.getUserDate());
                userRepository.save(user);
                return  StatusReport.buildStringResult(200,"Register success",null);
            }

        }catch (Exception e){
            return StatusReport.buildStringResult(400,null,e.getMessage());
        }
    }

    @RequestMapping(value = "/listNews",method = RequestMethod.GET)
    public String listNews() throws Exception{
        try{
            List<Xinwenlist> xinwens = xinwenlistRepository.findAll();
            map.put("xinwens",xinwens);
            return StatusReport.buildResult(200,map,null);
        }catch (Exception e){
            return StatusReport.buildStringResult(400,null,e.getMessage());
        }finally {
            map.clear();
        }

    }

    @RequestMapping(value = "/getDetail/{newid}",method = RequestMethod.GET)
    public String getDetail(@PathVariable String newid)throws Exception{
        try{
            Xinwen xinwenDetail = xinwenRepository.findByNewid(newid);
            User user = userRepository.findByUserid(xinwenDetail.getNewauthorid());
            xinwenDetail.setNewauthorid(user.getUsername());
            map.put("xinwen", xinwenDetail);
            return StatusReport.buildResult(200,map,null);
        }catch (Exception e){
            return  StatusReport.buildStringResult(400,null,e.getMessage());
        }finally {
            map.clear();
        }
    }

    @RequestMapping(value = "/getCule/{userid}/{culeclass}",method = RequestMethod.GET)
    public String getCule(@PathVariable String userid,@PathVariable String culeclass) throws Exception{
        try{
            List<Cule> cules = culeRepository.findByCuleuseridAndCuleclass(userid,culeclass);
            map.put("Cules",cules);
            return StatusReport.buildResult(200,map,null);
        }catch (Exception e){
            return  StatusReport.buildStringResult(400,null,e.getMessage());
        }finally {
            map.clear();
        }
    }

    @RequestMapping(value = "/getCommentlist/{newid}",method = RequestMethod.GET)
    public String getCommentlist(@PathVariable String newid) throws Exception{
        try{
            List<Comment> comments = commentRepository.findByNewid(newid);
            map.put("Comments",comments);
            return StatusReport.buildResult(200,map,null);
        }catch (Exception e){
            return  StatusReport.buildStringResult(400,null,e.getMessage());
        }finally {
            map.clear();
        }
    }

    @RequestMapping(value = "/saveComment",method = RequestMethod.POST)
    public String saveComment(@RequestParam(value = "commentdetail",required = true) String commentdetail,
                              @RequestParam(value = "newid",required = true) String newid,
                              @RequestParam(value = "userid",required = true) String userid,
                              @RequestParam(value = "username",required = true) String username
    ) throws Exception{
        try{
            Comment comment = new Comment();
            comment.setCommentid(DateUtil.getClueDateID());
            comment.setNewid(newid);
            comment.setCommentdate(DateUtil.getCluseDate());
            comment.setCommentdetail(commentdetail);
            comment.setUserid(userid);
            comment.setUsername(username);
            commentRepository.save(comment);
            return  StatusReport.buildStringResult(200,"Add success",null);
        }catch (Exception e){
            return  StatusReport.buildStringResult(400,null,e.getMessage());
        }finally {
            map.clear();
        }
    }
    @RequestMapping(value = "/getCuledetail/{culeid}",method = RequestMethod.GET)
    public String getCuleDetail(@PathVariable String culeid) throws Exception{
        try{
            Cule cule = culeRepository.findByCuleid(culeid);
            map.put("Cule",cule);
            return StatusReport.buildResult(200,map,null);
        }catch (Exception e){
            return  StatusReport.buildStringResult(400,null,e.getMessage());
        }finally {
            map.clear();
        }
    }
    @RequestMapping(value = "/addCule",method = RequestMethod.POST )
    public String addCule(@RequestParam(value = "culetittle", required = true) String culetittle,
                          @RequestParam(value = "culedetail", required = true) String culedetail,
                          @RequestParam(value = "culeclass", required = true) String culeclass,
                          @RequestParam(value = "culeuserid", required = true) String culeuserid,
                          @RequestParam(value = "file",required = false) MultipartFile file
    ) throws Exception{
        try{

            String culeid = DateUtil.getClueDateID();
            Cule cule = new Cule();
            if (null == file){
                cule.setCuleimages("0");
            }else {
                if (file.isEmpty()!=true){
                    String filename = "/var/www/html/"+culeid+".jpg";
                    File savefile = new File(filename);
                    file.transferTo(savefile);
                    cule.setCuleimages("1");
                }else{
                    cule.setCuleimages("0");
                }
            }
            cule.setCuleclass(culeclass);
            cule.setCuledate(DateUtil.getCluseDate());
            cule.setCuleid(culeid);
            cule.setCuledetail(culedetail);
            cule.setCuletittle(culetittle);
            cule.setCulestatus("待处理");
            cule.setCuleuserid(culeuserid);
            culeRepository.save(cule);
            return  StatusReport.buildStringResult(200,"Add success",null);
        }catch (Exception e){
            return  StatusReport.buildStringResult(400,null,e.getMessage());
        }finally {
            map.clear();
        }
    }

//    @RequestMapping
}
