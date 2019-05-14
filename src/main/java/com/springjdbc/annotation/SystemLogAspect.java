package com.springjdbc.annotation;

import com.springjdbc.pojo.User;
import com.springjdbc.pojo.UserLog;
import com.springjdbc.service.UserLogService;
import com.springjdbc.util.IpAdrressUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Component
public class SystemLogAspect {

    @Autowired
    private UserLogService userLogService;

    private static final Logger logger = LoggerFactory.getLogger(SystemLogAspect.class);

    @Pointcut("@annotation(com.springjdbc.annotation.SystemControllerLog)")
    public void controllerAspect(){
    }

    @After("controllerAspect()")
    public void doAfter(JoinPoint joinPoint){

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        //读取session中的用户
        User user = (User) session.getAttribute("user");
        System.out.println(user);
        String ip = IpAdrressUtil.getIpAdrress(request);

        try {
            //*========控制台输出=========*//
            System.out.println("==============后置通知开始==============");
            System.out.println("请求方法" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName()));
            System.out.println("方法描述：" + getControllerMethodDescription(joinPoint));
            System.out.println("请求人："+user.getUsername());
            System.out.println("请求ip："+ip);
            System.out.println(new Date());
            //*========数据库日志=========*//
            Date date = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            UserLog userLog = new UserLog(getControllerMethodDescription(joinPoint), user.getUsername(), ip,df.format(new Date() ));
            System.out.println(df.format(new Date()));
            System.out.println(new Date());
            int row = userLogService.insert(userLog);


        }catch (Exception e){
            //记录本地异常日志
            logger.error("==前置通知异常==");
            logger.error("异常信息：{}",e.getMessage());
        }
    }



    /**
     * @author changyaofang
     * @Description  获取注解中对方法的描述信息 用于Controller层注解
     * @date 2018年9月3日 上午12:01
     */
    public static String getControllerMethodDescription(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();//目标方法名
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method:methods) {
            if (method.getName().equals(methodName)){
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length==arguments.length){
                    description = method.getAnnotation(SystemControllerLog.class).description();
                    break;
                }
            }
        }
        return description;
    }



}
