package com.unilumin.service;

import com.unilumin.api.WorkService;
import org.springframework.stereotype.Service;

/**
 * @author zxz
 * @date 2022年11月30日 17:36
 */
@Service
public class WorkServiceImpl implements WorkService {
    public String work() {
        return "touch fish";
    }


    public String meeting() {
        return "sleep";
    }
}
