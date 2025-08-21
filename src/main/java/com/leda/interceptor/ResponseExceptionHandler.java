
package com.leda.interceptor;

import com.leda.exception.BadRequestException;
import com.leda.exception.BusinessException;
import com.leda.exception.base.BaseException;
import com.leda.utils.AjaxResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.nio.file.AccessDeniedException;

@ControllerAdvice(basePackages = "com.leda.controller")
public class ResponseExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(ResponseExceptionHandler.class);

    public ResponseExceptionHandler() {
    }


    @ExceptionHandler({BusinessException.class})
    public ResponseEntity<AjaxResult> handleOperatorException(BusinessException ex) {
        log.warn("handleOperatorException:{}", ex.getMessage());
        return ResponseEntity.ok().body(AjaxResult.ok(HttpStatus.INTERNAL_SERVER_ERROR.value(),ex.getMessage()));
    }

    @ExceptionHandler({BaseException.class, BadRequestException.class})
    public ResponseEntity<AjaxResult> handleManagedException(BaseException ex) {
        log.error("handleManagedException", ex);
        AjaxResult ajaxResult = AjaxResult.ok(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return ResponseEntity.badRequest().body(ajaxResult);
    }

    @ExceptionHandler({AccessDeniedException.class})
    public ResponseEntity<AjaxResult> handleAccessDeniedException(AccessDeniedException ex) {
        log.error("handleManagedException", ex);
        AjaxResult ajaxResult = AjaxResult.ok(HttpStatus.UNAUTHORIZED.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ajaxResult);

    }


    @ExceptionHandler({Throwable.class})
    public ResponseEntity<AjaxResult> handleManagedException(Throwable ex) {
        log.error("handleManagedException", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(AjaxResult.ok(ex));
    }

}
