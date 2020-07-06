package com.boss.ioc.service.impl;

import com.boss.ioc.service.ISysService;

public class SysServiceImpl implements ISysService {

    public long getSysToken() {
        return System.currentTimeMillis();
    }
}
