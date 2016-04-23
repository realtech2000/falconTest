package hu.pairg.falconTest.api.controller;

import hu.pairg.falconTest.api.controller.exception.BadFormatException;
import hu.pairg.falconTest.api.dto.Envelope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by pairg on 2016.04.23..
 */
@ControllerAdvice(basePackageClasses = ChatApiController.class)
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BadFormatException.class)
    @ResponseBody
    public ResponseEntity<Envelope<Boolean>> handleException(HttpServletRequest request, BadFormatException ex) {
        Envelope<Boolean> body = new Envelope<>(ex.getMessage());
        return new ResponseEntity<>(body, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body,
                                                             HttpHeaders headers, HttpStatus status, WebRequest request) {
        if(!(body instanceof Envelope<?>))
            body = new Envelope<Boolean>(status.getReasonPhrase());
        return super.handleExceptionInternal(ex, body, headers, status, request);
    }

}
