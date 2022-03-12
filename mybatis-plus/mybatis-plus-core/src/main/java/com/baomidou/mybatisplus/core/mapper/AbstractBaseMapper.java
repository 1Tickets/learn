package com.baomidou.mybatisplus.core.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author Harris
 * @version 1.0
 * @ClassName: mybatis-plus-root
 * @Description: 抽象mapper
 * @date 2022/3/3 20:14
 */
public abstract class AbstractBaseMapper<T> implements BaseMapper<T> {

    @Override
    public int updateById(Object entity) {
        throw new UnsupportedOperationException("不支持的方法");
    }

    @Override
    public int update(Object entity, Wrapper updateWrapper) {
        throw new UnsupportedOperationException("不支持的方法");
    }

}
