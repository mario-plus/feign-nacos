package com.unilumin.controller;

import com.unilumin.service.WorkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zxz
 * @date 2022年11月30日 17:37
 */
@RestController
public class WorkController {

    @Autowired
    WorkServiceImpl workService;

    @GetMapping("/doWork")
    public String doWork() {
        return workService.work();
    }
    @PostMapping("/meeting")
    public String meeting(){
        return workService.meeting();
    }
}
