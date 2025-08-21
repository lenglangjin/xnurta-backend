package com.leda.controller;


import com.leda.dto.LedaLoginDto;
import com.leda.entity.LedaUser;
import com.leda.service.ILedaUserService;
import com.leda.utils.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "用户管理")
@RestController
@RequestMapping("/user")
public class LedaUserController extends BaseController {

    @Autowired
    private ILedaUserService ledaUserService;

    /**
     * 查询当前用户信息
     */
    @ApiOperation("查询当前用户")
    @GetMapping("/{id}")
    public AjaxResult selectUser(@PathVariable Long id) {
        LedaUser ledaUser = ledaUserService.getById(id);
        return AjaxResult.ok(ledaUser);
    }

    /**
     * 修改用户信息
     */
    @ApiOperation("修改用户信息")
    @PutMapping("/{id}/edit")
    public AjaxResult<Boolean> editSave(@PathVariable Long id, @RequestBody LedaUser ledaUser){
        ledaUser.setId(id);
        ledaUserService.updateById(ledaUser);
        return AjaxResult.ok(true);
    }


    /**
     * 登陆
     */
    @PostMapping("/login")
    @ResponseBody
    @ApiOperation("登陆")
    public AjaxResult login(@RequestBody LedaLoginDto ledaLoginDto){
        return AjaxResult.ok(ledaUserService.login(ledaLoginDto));
    }

}
