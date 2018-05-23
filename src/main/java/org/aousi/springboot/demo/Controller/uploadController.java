package org.aousi.springboot.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/upload")
public class uploadController {

    @RequestMapping("/fileUpload")
    @ResponseBody
    public Map<String,Object> upload(@RequestParam("fileName") MultipartFile file){
        Map<String ,Object> back = new HashMap<>();

        if (file.isEmpty()){
            back.put("statusCode",400);
            return back;
        }
        String fileName = file.getOriginalFilename();
        int size = (int) file.getSize();
        System.out.println(fileName + "-->" + size);

        String path = "D:/upload" ;
        File dest = new File(path + "/" + fileName);
        if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest); //保存文件
            back.put("statusCode",200);
            return back;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            back.put("statusCode",400);
            return back;
        } catch (IOException e) {

            e.printStackTrace();
            back.put("statusCode",400);
            return back;
        }
    }
}
