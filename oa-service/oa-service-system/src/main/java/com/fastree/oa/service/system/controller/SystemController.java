package com.fastree.oa.service.system.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
//@RefreshScope
public class SystemController {
//    @Autowired
//    private ProcessService processService;
//    @Autowired
//    private RestTemplate restTemplate;
//
//    @GetMapping("/system/rest/{id}")
//    public String systemRest(@PathVariable("id") Integer id) {
//        ResponseEntity<String> entity = restTemplate.getForEntity("http://micro-oa-service-process/process/rest/{id}", String.class, id);
//        return entity.getBody();
//    }
//
//    @GetMapping("/system/feign")
//    public String systemFeign() {
//        return processService.processFeign();
//    }
//
//    @SentinelResource(value = "hello", blockHandler = "sentinelResourceHandler", fallback = "sentinelResourceFallback", defaultFallback = "sentinelDefaultFallback")
//    @GetMapping("/system/sentinel")
//    public String sentinelResource() {
////        int i = 10 / 0;
//        return "sentinelResource";
//    }
//
//    public String sentinelResourceHandler(BlockException e) {
//        return e.getMessage() + " ===> sentinelResourceHandler";
//    }
//
//    public String sentinelResourceFallback(Throwable e) {
//        return e.getMessage() + " ===> sentinelResourceFallback";
//    }
//
//    public String sentinelDefaultFallback(Throwable e) {
//        return e.getMessage() + " ===> sentinelDefaultFallback";
//    }
}
