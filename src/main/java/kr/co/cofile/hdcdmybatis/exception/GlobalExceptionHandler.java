package kr.co.cofile.hdcdmybatis.exception;

import org.apache.ibatis.binding.BindingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(BindingException.class)
	public ResponseEntity<String> handlerMybatisConfigurationException(BindingException e) {
		return ResponseEntity.internalServerError().body("An error occurred: " + e.getMessage());
	}

}
