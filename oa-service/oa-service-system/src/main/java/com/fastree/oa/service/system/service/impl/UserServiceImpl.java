package com.fastree.oa.service.system.service.impl;

import com.fastree.oa.service.system.entity.UserEntity;
import com.fastree.oa.service.system.mapper.UserMapper;
import com.fastree.oa.service.system.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Alex Jiang
 * @since 2020-12-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

}
