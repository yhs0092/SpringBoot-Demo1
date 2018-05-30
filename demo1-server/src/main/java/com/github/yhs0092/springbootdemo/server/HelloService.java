package com.github.yhs0092.springbootdemo.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hello")
@RestController
public class HelloService {
  private static final Logger LOGGER = LoggerFactory.getLogger(HelloService.class);

  @RequestMapping("/sayHello")
  public String sayHello(/*@RequestParam*/ Person person) {
    LOGGER.info("sayHello is called, person = [{}]", person);
    if (null == person) {
      return "Param is null";
    }
    return person.toString();
  }

  @RequestMapping(value = "/sayHello", method = RequestMethod.POST)
  public String postHello(@RequestBody Person person) {
    LOGGER.info("postHello is called, person = [{}]", person);
    if (null == person) {
      return "Param is null";
    }
    return person.toString();
  }
}
