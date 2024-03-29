package com.example.BackendVolatile.Controller;

import com.example.BackendVolatile.dto.taskDTO.AcceptTaskDTO;
import com.example.BackendVolatile.dto.taskDTO.TaskPublishDTO;
import com.example.BackendVolatile.service.TaskService;
import com.example.BackendVolatile.util.jwtUtil.CustomAnnotation.UserLoginToken;
import com.example.BackendVolatile.vo.taskVO.AcceptTaskVO;
import com.example.BackendVolatile.vo.taskVO.PublishTaskVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
//@CrossOrigin(originPatterns = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping(path = "/api/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @PostMapping(value = "/publishTask")
    @UserLoginToken
    public PublishTaskVO publishTask(@Valid @RequestBody TaskPublishDTO taskPublishDTO){
        System.out.println(taskPublishDTO.getTaskDifficulty());
        System.out.println(taskPublishDTO.getAndroid());
        return taskService.publishTask(taskPublishDTO);
    }

    @PostMapping(value="/acceptTask")
    @UserLoginToken
    public AcceptTaskVO acceptTask(@Valid @RequestBody AcceptTaskDTO acceptTaskDTO){
        return taskService.acceptTask(acceptTaskDTO);
    }



}
