package com.mrdfood.demo.boot.controller;

import com.google.common.collect.Maps;
import com.mrdfood.demo.boot.util.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import static java.nio.file.Files.readAllBytes;

@Controller
@RequestMapping("/api")
class SourceController {

    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping("/source")
    @ResponseBody
    Map<String, Object> source(@RequestParam String path) throws IOException {
        Resource resource = applicationContext.getResource("classpath:/static/" + path);
        if (!resource.exists()) {
            resource = applicationContext.getResource("file:src/main/java/" + path);
            if (!resource.exists()) {
                throw new ResourceNotFoundException(path);
            }
        }

        String content = new String(readAllBytes(resource.getFile().toPath()), StandardCharsets.UTF_8);
        Map<String, Object> response = Maps.newHashMapWithExpectedSize(2);
        response.put("Content", content);
        response.put("File", path);
        return response;
    }
}
