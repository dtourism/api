package org.api.controller.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.api.domain.dto.UserDTO;
import org.api.domain.po.UserPO;
import org.api.domain.vo.UserVO;
import org.api.enums.StatusCode;
import org.api.service.UserService;
import org.api.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author fox
 * @since 2020-04-26
 */
@CrossOrigin
@Api(tags = {"用户管理"})
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/page")
    @ApiOperation(value = "分页查询用户列表")
    public Result<?> Page() {
        List<UserVO> list = userService.userList(new UserDTO());
        LinkedHashMap<Date, List<UserVO>> map = list.stream()
                .collect(Collectors.groupingBy(UserVO::getCreateTime, LinkedHashMap::new, Collectors.toList()));
        return Result.success(map);
    }

    @GetMapping("user")
    @ApiOperation(value = "根据条件查询用户列表")
    public Result<?> queryByCondition(UserDTO userDTO) {
        return Result.success(userService.userList(userDTO));
    }

    @PostMapping("user")
    @ApiOperation(value = "增加用户")
    public Result<?> addUser(@RequestBody UserPO userPO) {
        if(userService.addUser(userPO)){
            return Result.success();
        }
        return Result.fail(StatusCode.INSERT_ERROR);
    }

    @PutMapping("user")
    @ApiOperation(value = "更新用户信息")
    public Result<?> updateUser(@RequestBody UserPO userPO) {
        if(userService.updateUser(userPO)){
            return Result.success();
        }
        return Result.fail(StatusCode.UPDATE_ERROR);
    }

    @DeleteMapping("user/{id}")
    @ApiOperation(value = "根据Id删除用户")
    public Result<?> deleteUser(@PathVariable("id") Long id) {
        if(userService.deleteUser(id)){
            return Result.success();
        }
        return Result.fail(StatusCode.DELETE_ERROR);
    }

}

