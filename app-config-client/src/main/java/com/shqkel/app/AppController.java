package com.shqkel.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class AppController {

	@Value("${message.text:default}") // @Value에 $사용시 초기값을 넣어주어야함.그냥 default문자열을 넣음.
	private String messageValue;
	
	@RequestMapping(value = "/")
	public String getMessageValue() {
		return messageValue;
	}
}
