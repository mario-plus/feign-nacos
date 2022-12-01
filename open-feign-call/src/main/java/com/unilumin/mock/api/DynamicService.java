package com.unilumin.mock.api;

import com.unilumin.mock.annocations.RemoteParams;
import com.unilumin.mock.annocations.DynamicProxied;

@DynamicProxied
public interface DynamicService {

    @RemoteParams(url = "127.0.0.1:6001", path = "/doWork")
    String remoteCall(String args);

}
