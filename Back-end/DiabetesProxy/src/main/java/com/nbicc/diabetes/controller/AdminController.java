package com.nbicc.diabetes.controller;

import com.alibaba.fastjson.JSONObject;
import com.nbicc.diabetes.service.AdminService;
import com.nbicc.diabetes.service.StudentService;
import com.nbicc.diabetes.service.TrainingService;
import com.nbicc.diabetes.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static com.nbicc.diabetes.utils.ParamKey.*;

/**
 * Created by zhuolin on 2017/9/26.
 */
@CrossOrigin
@Controller
@RequestMapping("/admin")
public class AdminController {

    private static Logger log = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AdminService adminService;

    @Autowired
    private TrainingService trainingService;

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public R adminLogin(@RequestBody JSONObject body){
        String userName = body.getString(USER_NAME);
        String userPsw = body.getString(USER_PSW);
        if(adminService.login(userName,userPsw)){
            return R.ok();
        }else{
            return R.error();
        }
    }

    @RequestMapping(value = "/agent/add",method = RequestMethod.POST)
    @ResponseBody
    public R addAgent(@RequestBody JSONObject body){
        String agentName = body.getString(AGENT_NAME);
        String agentPsw = body.getString(AGENT_PSW);
        if(adminService.addAgent(agentName,agentPsw)){
            return R.ok();
        }else{
            return R.error();
        }
    }

    @RequestMapping(value = "/agent/edit",method = RequestMethod.POST)
    @ResponseBody
    public R editAgent(@RequestBody JSONObject body){
        String agentId = body.getString(AGENT_ID);
        String agentPsw = body.getString(AGENT_PSW);
        Integer isActive = body.getInteger(IS_ACTIVE);
        if(adminService.editAgent(agentId,agentPsw,isActive)){
            return R.ok();
        }else{
            return R.error();
        }
    }

    @RequestMapping(value = "/agent/delete",method = RequestMethod.POST)
    @ResponseBody
    public R deleteAgent(@RequestBody JSONObject body){
        String agentId = body.getString(AGENT_ID);
        if(adminService.deleteAgent(agentId)){
            return R.ok();
        }else{
            return R.error();
        }
    }

    @RequestMapping(value = "/agent/all",method = RequestMethod.GET)
    @ResponseBody
    public R getAllAgent(){
        return R.ok(adminService.getAllAgent());

    }

    @RequestMapping(value = "/training/add",method = RequestMethod.POST)
    @ResponseBody
    public R addTraining(@RequestBody JSONObject body){
        String trainingName = body.getString(TRAINING_NAME);
        String startTime = body.getString(START_TIME);
        String endTime = body.getString(END_TIME);
        String agentId = body.getString(AGENT_ID);
        trainingService.addTraining(trainingName,startTime,endTime,agentId);
        return R.ok();
    }

    @RequestMapping(value = "/training/all",method = RequestMethod.GET)
    @ResponseBody
    public R getAllTraining(){
        return R.ok(trainingService.getAllTraining());
    }

    @RequestMapping(value = "/training/edit",method = RequestMethod.POST)
    @ResponseBody
    public R editTraining(@RequestBody JSONObject body){
        String trainingId = body.getString(TRAINING_ID);
        String trainingName = body.getString(TRAINING_NAME);
        String startTime = body.getString(START_TIME);
        String endTime = body.getString(END_TIME);
        String agentId = body.getString(AGENT_ID);
        if(trainingService.editTraining(trainingId,trainingName,startTime,endTime,agentId)){
            return R.ok();
        }else{
            return R.error();
        }
    }

    @RequestMapping(value = "/training/delete",method = RequestMethod.POST)
    @ResponseBody
    public R deleteTraining(@RequestBody JSONObject body){
        String trainingId = body.getString(TRAINING_ID);
        if(trainingService.deleteTraining(trainingId)){
            return R.ok();
        }else{
            return R.error();
        }
    }

    @RequestMapping(value = "/advice/add",method = RequestMethod.POST)
    @ResponseBody
    public R addAdvice(@RequestBody JSONObject body){
        String studentId = body.getString(STUDENT_ID);
        String trackingDate = body.getString(TRACKING_DATE);
        Integer trackingType = body.getInteger(TRACKING_TYPE);
        String dietRecommend = body.getString(DIET_RECOMMEND);
        String sportRecommend = body.getString(SPORT_RECOMMEND);
        String insulinRecommend = body.getString(INSULIN_DOSAGE_RECOMMEND);
        if(adminService.addAdvice(studentId,trackingDate,trackingType,dietRecommend,sportRecommend,insulinRecommend)){
            return R.ok();
        }else{
            return R.error();
        }
    }

    @RequestMapping(value = "/advice/edit",method = RequestMethod.POST)
    @ResponseBody
    public R editAdvice(@RequestBody JSONObject body){
        String trackingId = body.getString(TRACKING_ID);
        String trackingDate = body.getString(TRACKING_DATE);
        Integer trackingType = body.getInteger(TRACKING_TYPE);
        String dietRecommend = body.getString(DIET_RECOMMEND);
        String sportRecommend = body.getString(SPORT_RECOMMEND);
        String insulinRecommend = body.getString(INSULIN_DOSAGE_RECOMMEND);
        if(adminService.editAdvice(trackingId,trackingDate,trackingType,dietRecommend,sportRecommend,insulinRecommend)){
            return R.ok();
        }else{
            return R.error();
        }
    }

    @RequestMapping(value = "/{training_id}/students",method = RequestMethod.GET)
    @ResponseBody
    public R getStudentsByTrainingId(@PathVariable("training_id") String trainingId){
        return R.ok(studentService.getStudentsInfoByTrainingId(trainingId));
    }
}
