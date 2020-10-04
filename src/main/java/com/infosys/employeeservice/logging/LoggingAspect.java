package com.infosys.employeeservice.logging;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	Logger logger = LogManager.getLogger(this.getClass());
	@AfterThrowing(pointcut="execution(* com.infosys.employeeservice.*Impl.*(..))",throwing="e")
	public void logsFromEmployeeserviceApplication(Exception e) throws Exception
	{
		if(e.getMessage()!=null && e.getMessage().contains("Service")) {
			logger.error(e.getMessage());
		}
		else {
			logger.error(e.getMessage(),e);
		}
	}
	
}
