package com.dc.sec_kill.service;

import com.dc.sec_kill.entity.Seckill;
import com.dc.sec_kill.entity.User;


public interface UserService {
    User list();

    Seckill getbyid();
}
