package com.github.yhs0092.springbootdemo.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/hello")
@RestController
public class HelloService {
  private static final Logger LOGGER = LoggerFactory.getLogger(HelloService.class);

  private final RestTemplate restTemplate = new RestTemplate();

  private final String basePath = "http://127.0.0.1:8080/hello";

  @RequestMapping("/sayHello")
  public String sayHello(/*@RequestParam*/ Person person, Address address) {
    LOGGER.info("sayHello is called, person = [{}]", person);
    if (null == person) {
      return "Param is null";
    }
    return person.toString() + "|" + address.toString();
  }

  @RequestMapping(value = "/sayHello", method = RequestMethod.POST)
  public String postHello(@RequestBody Person person) {
    LOGGER.info("postHello is called, person = [{}]", person);
    if (null == person) {
      return "Param is null";
    }
    return person.toString();
  }

  @RequestMapping("/stringArray")
  public String stringArray(ArrayList<String> strings) {
    LOGGER.info("stringArray is called, strings = [{}]", strings);
    return strings.toString();
  }

  @RequestMapping("/stringSet")
  public String stringSet(HashSet<String> strings) {
    LOGGER.info("stringSet is called, strings = [{}]", strings);
    return strings.toString();
  }

  @RequestMapping("/stringMap")
  public String stringMap(Map<String, String> stringMap) {
    LOGGER.info("stringMap is called, stringMap = [{}]", stringMap);
    return stringMap.toString();
  }

  @RequestMapping("/address/ab{city}/{country}")
  public String address(Address address) {
    LOGGER.info("address is called, address = [{}]", address);
    if (null == address) {
      return "address is null";
    }
    return address.toString();
  }

  @RequestMapping("/sayHelloPath/{name}/{age}/{address.city}/{address.country}/{child.name}/{child.age}/{child.address.city}/{child.address.country}")
  public String sayHelloPath(Person person) {
    LOGGER.info("sayHelloPath is called, person = [{}]", person);
    if (null == person) {
      return "person is null";
    }
    return person.toString();
  }

  @RequestMapping("/stringArrayInvoke")
  public String stringArrayInvoke() {
    final ArrayList<String> strings = new ArrayList<>();
    strings.add("p1");
    strings.add("p2");
    final ResponseEntity<String> responseEntity = restTemplate
        .getForEntity(basePath + "/stringArray", String.class, strings);
    return responseEntity.getStatusCodeValue() + ":" + responseEntity.getBody();
  }

  @RequestMapping("/stringSetInvoke")
  public String stringSetInvoke() {
    final HashSet<Object> strings = new HashSet<>();
    strings.add("s1");
    strings.add("s2");
    final ResponseEntity<String> responseEntity = restTemplate
        .getForEntity(basePath + "/stringSet", String.class, strings);
    return responseEntity.getStatusCodeValue() + ":" + responseEntity.getBody();
  }

  @RequestMapping("/stringMapInvoke")
  public String stringMapInvoke() {
    final HashMap<String, Object> stringMap = new HashMap<>();
    stringMap.put("k1", "v1");
    stringMap.put("k2", "v2");
    final ResponseEntity<String> responseEntity = restTemplate
        .getForEntity(basePath + "/stringMap?k1={k1}&k2={k2}", String.class, stringMap);
    return responseEntity.getStatusCodeValue() + ":" + responseEntity.getBody();
  }
}
