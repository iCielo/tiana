/**
 * lincl
 * 2016年8月26日 下午3:20:37
 * 
 */
package com.lezic.tiana.api.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lezic.tiana.constant.AjaxResult;
import com.lezic.tiana.constant.StatusCode;
import com.lezic.tiana.web.BaseController;
import com.wordnik.swagger.annotations.ApiOperation;

/**
 * 这是关于学生的例子
 * 
 * @author lincl
 * 
 */
@RestController
@RequestMapping("/students")
public class StudentController extends BaseController {

    private static List<Student> list = new ArrayList<Student>();

    static {
        list.add(new Student(1, "张三", "男", 16, "高二"));
        list.add(new Student(2, "小明", "男", 15, "高一"));
        list.add(new Student(3, "小红", "女", 14, "高一"));
    }

    /**
     * 根据ID主键获取学生
     * 
     * @return
     * @author lincl
     * @date 2016年8月26日 下午2:55:56
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "根据ID主键获取学生", notes = "根据ID主键获取学生")
    public Student getStudent(@PathVariable Integer id) {
        for (Student item : list) {
            if (id == item.getId()) {
                return item;
            }
        }
        return null;
    }

    /**
     * 根据ID主键删除学生
     * 
     * @param id
     * @return
     * @author lincl
     * @date 2016年8月26日 下午3:51:20
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "根据ID主键删除学生", notes = "根据ID主键删除学生")
    @ResponseBody
    public AjaxResult delete(@PathVariable Integer id) {

        for (Student item : list) {
            if (id == item.getId()) {
                list.remove(item);
                return new AjaxResult();
            }
        }
        return new AjaxResult(StatusCode.APP_1004);
    }

}
