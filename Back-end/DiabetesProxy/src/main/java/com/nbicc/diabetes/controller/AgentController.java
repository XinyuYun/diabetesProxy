package com.nbicc.diabetes.controller;

import com.alibaba.fastjson.JSONObject;
import com.nbicc.diabetes.model.AgentInfo;
import com.nbicc.diabetes.service.AgentService;
import com.nbicc.diabetes.service.StudentService;
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
@RequestMapping("/agent")
public class AgentController {

    private static Logger log = LoggerFactory.getLogger(AgentController.class);

    @Autowired
    private AgentService agentService;

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public R login(@RequestBody JSONObject body){
        String userName = body.getString(USER_NAME);
        String userPsw = body.getString(USER_PSW);
        AgentInfo agent = agentService.login(userName,userPsw);
        if(agent == null){
            return R.error();
        }
        JSONObject data = new JSONObject();
        data.put(AGENT_ID,agent.getId());
        return R.ok(data);
    }

    @RequestMapping(value = "/{agent_id}/training/all",method = RequestMethod.GET)
    @ResponseBody
    public R getAllTraining(@PathVariable("agent_id") String agentId){
        return R.ok(agentService.getAllTrainingByAgentId(agentId));
    }

    @RequestMapping(value = "/student/add",method = RequestMethod.POST)
    @ResponseBody
    public R addStudent(@RequestBody JSONObject body){
        String trainingId = body.getString(TRAINING_ID);
        String studentName =body.getString(STUDENT_NAME);
        Integer studentAge = body.getInteger(STUDENT_AGE);
        String studentSex = body.getString(STUDENT_SEX);
        String contactInfo = body.getString(CONTACT_INFO);
        String diabetesYear = body.getString(DIABETES_YEAR);
        String insulinYear = body.getString(INSULIN_YEAR);
        String insulinType = body.getString(INSULIN_TYPE);
        String insulinDosage = body.getString(INSULIN_DOSAGE);
        studentService.addStudent(trainingId,studentName,studentAge,studentSex,contactInfo,diabetesYear,insulinYear,insulinType,insulinDosage);
        return R.ok();
    }

    @RequestMapping(value = "/student/edit",method = RequestMethod.POST)
    @ResponseBody
    public R editStudent(@RequestBody JSONObject body){
        String studentId = body.getString(STUDENT_ID);
        String studentName =body.getString(STUDENT_NAME);
        Integer studentAge = body.getInteger(STUDENT_AGE);
        String studentSex = body.getString(STUDENT_SEX);
        String contactInfo = body.getString(CONTACT_INFO);
        String diabetesYear = body.getString(DIABETES_YEAR);
        String insulinYear = body.getString(INSULIN_YEAR);
        String insulinType = body.getString(INSULIN_TYPE);
        String insulinDosage = body.getString(INSULIN_DOSAGE);
        if(studentService.editStudent(studentId,studentName,studentAge,studentSex,contactInfo,diabetesYear,insulinYear,insulinType,insulinDosage)){
            return R.ok();
        }else{
            return R.error();
        }
    }

    @RequestMapping(value = "/student/delete",method = RequestMethod.POST)
    @ResponseBody
    public R deleteStudent(@RequestBody JSONObject body){
        String studentId = body.getString(STUDENT_ID);
        if(studentService.deleteStudent(studentId)){
            return R.ok();
        }else{
            return R.error();
        }
    }

    @RequestMapping(value = "/{training_id}/students",method = RequestMethod.GET)
    @ResponseBody
    public R getStudentsByTrainingId(@PathVariable("training_id") String trainingId,@RequestParam("tracking_date") String trackingDate,@RequestParam("tracking_type") String trackingType){
        return R.ok(studentService.getStudentsInfoByTrainingId(trainingId,trackingDate, trackingType));
    }

    @RequestMapping(value = "/bloodsugar/edit",method = RequestMethod.POST)
    @ResponseBody
    public R editSugar(@RequestBody JSONObject body){
        String trackingId = body.getString(TRACKING_ID);
        String bloodSugar = body.getString(BLOOD_SUGAR);
        if(studentService.editBloodSugar(trackingId,bloodSugar)){
            return R.ok();
        }else{
            return R.error();
        }
    }
}
