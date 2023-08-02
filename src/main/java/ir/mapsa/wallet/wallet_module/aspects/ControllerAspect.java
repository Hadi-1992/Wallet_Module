package ir.mapsa.wallet.wallet_module.aspects;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.mapsa.wallet.wallet_module.repositories.LogRepository;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.io.StringWriter;

@Component
@Aspect
@Slf4j
public class ControllerAspect {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    LogRepository logRepository;

    @Around("within(ir.mapsa.wallet.wallet_module.controllers.AbstractController+ )")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        LogModel logModel = new LogModel();
        logModel.setMethodName(joinPoint.getSignature().getName());
        logModel.setRequest(joinPoint.getArgs());

        Object value;
        try {
            value = joinPoint.proceed();
            if (value != null) {
                logModel.setResponse(value);
            }
            logRepository.save(logModel);
            log.info("Success req " + objectMapper.writeValueAsString(logModel));
        } catch (Throwable e) {
            StringWriter writer = new StringWriter();
            PrintWriter printWriter = new PrintWriter(writer);
            e.printStackTrace(printWriter);
            writer.close();
            printWriter.close();
            logModel.setErrorTrace(writer.toString());
            logRepository.save(logModel);
            log.error("Failure req " + objectMapper.writeValueAsString(logModel));
            throw e;

        }
        return value;
    }
}
