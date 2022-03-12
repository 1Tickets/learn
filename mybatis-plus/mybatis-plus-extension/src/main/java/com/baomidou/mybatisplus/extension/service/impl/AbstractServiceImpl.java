package com.baomidou.mybatisplus.extension.service.impl;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Objects;

/**
 * @author Harris
 * @version 1.0
 * @ClassName: mybatis-plus-root
 * @Description: 自定义顶层Service
 * @date 2022/3/7 14:11
 */
public class AbstractServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> {

}
