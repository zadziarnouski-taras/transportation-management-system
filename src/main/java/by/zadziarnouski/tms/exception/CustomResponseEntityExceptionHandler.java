package by.zadziarnouski.tms.exception;

import by.zadziarnouski.tms.util.ConstantStrings;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNullApi;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.LinkedHashMap;
import java.util.Map;

@ResponseBody
@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, String> responseBody = new LinkedHashMap<>();

        responseBody.put(ConstantStrings.ERROR, String.valueOf(ValidationCode.INCORRECT_DATA_ENTRY.getNumber()));
        setMessageField(ex, responseBody);
        setDetailsField(ex, responseBody);

        return handleExceptionInternal(
                ex, responseBody, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        LinkedHashMap<Object, Object> responseBody = new LinkedHashMap<>();

        //вся эта логика в итоге должна лежать в методах setMessageField and etc.
        responseBody.put(ConstantStrings.ERROR,ClientRequestCode.NOT_FOUND.getNumber());
        responseBody.put(ConstantStrings.MESSAGE,"Not found");
        responseBody.put(ConstantStrings.DETAILS,"No handler found for " + ex.getHttpMethod() + " " + ex.getRequestURL());

        return handleExceptionInternal(
                ex, responseBody,headers, status, request);
    }

    private void setDetailsField(MethodArgumentNotValidException ex, Map<String, String> responseBody) {
        StringBuilder details = new StringBuilder();

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            details
                    .append(error.getField())
                    .append(": ")
                    .append(error.getDefaultMessage())
                    .append("; ");
        }

        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            details
                    .append(error.getObjectName())
                    .append(": ")
                    .append(error.getDefaultMessage())
                    .append("; ");
        }

        responseBody.put(ConstantStrings.DETAILS, String.valueOf(details));
    }

    private void setMessageField(MethodArgumentNotValidException ex, Map<String, String> responseBody) {
        String objectName = "";

        //TODO можно как-то улучшить код?
        switch (ex.getBindingResult().getObjectName()) {
            case ConstantStrings.BUS:
               objectName = ConstantStrings.BUS;
                break;
            case ConstantStrings.DRIVER:
                objectName = ConstantStrings.DRIVER;
                break;
            case ConstantStrings.ROUTER:
                objectName = ConstantStrings.ROUTER;
                break;
            case ConstantStrings.STATION:
                objectName = ConstantStrings.STATION;
                break;
        }

        responseBody.put(ConstantStrings.MESSAGE, "Incorrect input of " + objectName +" data");
    }
}
