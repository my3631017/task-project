package com.getService;

import com.exception.MyException;
import com.service.EmptyService;
import com.service.PttDaoService;
import com.service.UserDaoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Random;

public class ServiceFactory {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private UserDaoService userDaoService1;
    @Autowired
    private PttDaoService pttDaoService1;
    @Autowired
    private UserDaoService userDaoService2;
    @Autowired
    private PttDaoService pttDaoService2;
    @Autowired
    private EmptyService emptyService1;
    @Autowired
    private EmptyService emptyService2;
    private Logger logger = Logger.getLogger(ServiceFactory.class.getName());

    public UserDaoService getUserDaoService1() {
        Random random = new Random();
        //从现有的service中随机选一台
        int id = random.nextInt(2) + 1;//结果为1或者2
        switch (id) {
            case 1: {
                try {
                    //测试service1挂没挂，没挂就返回，挂了就catch异常返回service2
                    emptyService1.test();
                    return userDaoService1;
                } catch (Exception e) {
                   /* 这里不管service2挂没挂，直接返回；
                    在控制器里进行try，如果控制器catch到异常，证明1和2都挂了*/
                    return userDaoService2;
                }
            }
            case 2: {
                try {
                    emptyService2.test();
                    return userDaoService2;
                } catch (Exception e) {
                    return userDaoService1;
                }
            }
            default:
                return null;
        }
    }

    //从缓存中查询指定的id是否可以使用
    private boolean getServiceStateById(int id) {
        //缓存中没有记录错误，代表可用。如有记录，代表挂了。
        if (redisTemplate.opsForValue().get("service" + id) == null) {
            return true;
        } else {
            logger.info("service" + id + "挂了");
            return false;
        }
    }

    private UserDaoService getUserDaoServiceById(int id) {
        if (getServiceStateById(id)) {
            //如果可用，返回该id对应的service
            if (id == 1) {
                return userDaoService1;
            } else {
                return userDaoService2;
            }
        }
        return null;
    }

    private PttDaoService getPttDaoServiceById(int id) {
        if (getServiceStateById(id)) {
            //如果可用，返回该id对应的service
            if (id == 1) {
                return pttDaoService1;
            } else {
                return pttDaoService2;
            }
        }
        return null;
    }

    public UserDaoService getUserDaoService() throws MyException {
        Random random = new Random();
        //从现有的service中随机选一台
        int id = random.nextInt(2) + 1;//结果为1或者2
        //从记事本获取该id对应的service的状态
        if (getUserDaoServiceById(id) != null) {
            logger.info("service" + id + "被调用");
            return getUserDaoServiceById(id);
        }
        //另一台service的id
        id = 3 - id;
        if (getUserDaoServiceById(id) != null) {
            logger.info("service" + id + "被调用");
            return getUserDaoServiceById(id);
        }
        logger.info("所有服务都挂了！");
        throw new MyException("所有服务都挂了！");
    }

    public PttDaoService getPttDaoService() throws MyException {
        Random random = new Random();
        //从现有的service中随机选一台
        int id = random.nextInt(2) + 1;//结果为1或者2
        //从记事本获取该id对应的service的状态
        if (getPttDaoServiceById(id) != null) {
            logger.info("service" + id + "被调用");
            return getPttDaoServiceById(id);
        }
        //另一台服务器的id
        id = 3 - id;
        if (getPttDaoServiceById(id) != null) {
            logger.info("service" + id + "被调用");
            return getPttDaoServiceById(id);
        }
        logger.info("所有服务都挂了！");
        throw new MyException("所有服务都挂了！");
    }

    public EmptyService getEmptyService1() {
        return emptyService1;
    }

    public EmptyService getEmptyService2() {
        return emptyService2;
    }
}