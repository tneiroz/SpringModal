package common;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class CommonExceptionHandler {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)   //code지우면 자동완성이 안됨 사실 안적어도 되긴 함 
	public String notFoundPage(NoHandlerFoundException exception , Model model) {
		model.addAttribute("url",exception.getRequestURL());
		return "errorPage/_404";
	}
	
	//@ExceptionHandler(Exception.class)
	//@ResponseStatus(code= HttpStatus.BAD_REQUEST)
	public String badRequestHandle() {
		return "errorPage/_400";
	}
}
