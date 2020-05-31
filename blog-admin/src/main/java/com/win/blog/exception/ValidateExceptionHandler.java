package com.win.blog.exception;

import com.win.blog.model.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class ValidateExceptionHandler {

  /**
   * 接口参数检验错误处理
   * @param exception
   * @param request
   * @param response
   * @return
   */
  @ExceptionHandler({ConstraintViolationException.class})
  public ResponseVo validateException(ConstraintViolationException exception, HttpServletRequest request, HttpServletResponse response) {
    log.error("", exception);
    Map<String, Object> msg = new HashMap<>();
    exception.getConstraintViolations().forEach(constraintViolation -> {
      String template = constraintViolation.getMessageTemplate();
      String path = constraintViolation.getPropertyPath().toString();
      msg.put(path, template);
    });
    response.setStatus(HttpStatus.BAD_REQUEST.value());
    return ResponseVo.error(msg);
  }

  /**
   * dto参数检验错误处理
   * @param exception
   * @param request
   * @param response
   * @return
   */
  @ExceptionHandler({BindException.class})
  public ResponseVo bindException(BindException exception, HttpServletRequest request, HttpServletResponse response) {
    BindingResult bindingResult = exception.getBindingResult();
    List<ObjectError> errors = bindingResult.getAllErrors();
    Map<String, Object> msg = new HashMap<>();
    errors.forEach(error -> {
      if (error instanceof FieldError) {
        FieldError fieldError = (FieldError) error;
        msg.put(fieldError.getField(), fieldError.getDefaultMessage());
      } else {
        msg.put(error.getObjectName(), error.getDefaultMessage());
      }
    });
    response.setStatus(HttpStatus.BAD_REQUEST.value());
    return ResponseVo.error(msg);
  }
}
