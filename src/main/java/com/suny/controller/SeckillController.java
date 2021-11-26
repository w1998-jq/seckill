package com.suny.controller;

import com.suny.pojo.Seckill;
import com.suny.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @ClassName SeckillController
 * Description
 * @Author jqWang
 * Date 2021/11/26 10:55
 **/
@Controller()
@RequestMapping("/seckill")
public class SeckillController {
    private final SeckillService seckillService;

    @Autowired
    public SeckillController(SeckillService seckillService) {
        this.seckillService = seckillService;
    }

    @RequestMapping(value = {"/list","","index"},method = RequestMethod.GET)
    public String list(Model model){
        List<Seckill> seckillList = seckillService.getSeckillList();
        model.addAttribute("list" , seckillList);
        return "list";
    }


}
