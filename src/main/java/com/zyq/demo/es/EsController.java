package com.zyq.demo.es;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EsController {
    @Autowired
    private EsService esService;

    @PutMapping("/EsTest")
    public void EsTest() throws Exception {
       esService.EsTest();
    }
    @GetMapping("query")
    public EsResponse<?> queryEsTest(@RequestBody EsRequest request) throws Exception {
        return esService.queryEs(request);
    }
}
