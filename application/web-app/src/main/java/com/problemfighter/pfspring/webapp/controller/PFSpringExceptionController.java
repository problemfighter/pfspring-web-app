package com.problemfighter.pfspring.webapp.controller;

import com.problemfighter.pfspring.restapi.common.ApiProcessorException;
import com.problemfighter.pfspring.restapi.exception.ExceptionProcessor;
import com.problemfighter.pfspring.restapi.exception.HttpToApiException;
import io.swagger.annotations.Api;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@RestController
@Api(tags = "Global Exception Handler")
public class PFSpringExceptionController implements ErrorController {

    @ExceptionHandler(Exception.class)
    public Object handleException(HttpServletRequest request, Exception exception) {
        return ExceptionProcessor.instance().handleException(exception);
    }

    @ExceptionHandler(value = ApiProcessorException.class)
    public Object apiProcessorException(ApiProcessorException exception) {
        return exception.getError();
    }


    @RequestMapping(value = "/error")
    public Object error(HttpServletRequest request, Exception e) {
        return HttpToApiException.handleException(request);
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }


}
