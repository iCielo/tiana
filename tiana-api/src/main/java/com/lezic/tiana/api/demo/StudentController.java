/**
 * lincl
 * 2016年8月26日 下午3:20:37
 * 
 */
package com.lezic.tiana.api.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lezic.tiana.constant.AjaxResult;
import com.lezic.tiana.constant.StatusCode;
import com.lezic.tiana.util.DataUtil;
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

	private static int id = 4;

	static {
		list.add(new Student(1, "张三", "男", 16, "高二"));
		list.add(new Student(2, "小明", "男", 15, "高一"));
		list.add(new Student(3, "小红", "女", 14, "高一"));
	}

	/**
	 * 根据学生属性进行搜索
	 * 
	 * @param req
	 * @return
	 * @author lincl
	 * @date 2016年8月26日 下午6:25:36
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ApiOperation(value = "根据学生属性进行搜索", notes = "根据学生属性进行搜索")
	public AjaxResult list(@RequestBody Student req) {
		AjaxResult ajaxResult = new AjaxResult();
		List<Student> rows = new ArrayList<Student>();
		if (req.getId() == null && req.getName() == null
				&& req.getAge() == null && req.getSex() == null
				&& req.getGrade() == null) {
			rows = list;
		} else {
			for (Student item : list) {
				if (item.getId() == req.getId()) {
					rows.add(item);
					continue;
				}
				if (req.getName() != null
						&& item.getName().indexOf(req.getName()) != -1) {
					rows.add(item);
					continue;
				}
				if (item.getAge() == req.getAge()) {
					rows.add(item);
					continue;
				}
				if (item.getSex().equals(req.getSex())) {
					rows.add(item);
					continue;
				}
				if (req.getGrade() != null
						&& item.getGrade().indexOf(req.getGrade()) != -1) {
					rows.add(item);
					continue;
				}
			}
		}

		ajaxResult.setRows(rows);
		ajaxResult.setTotal((long) rows.size());
		return ajaxResult;
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
	public AjaxResult getStudent(@PathVariable Integer id) {
		AjaxResult ajaxResult = new AjaxResult();
		for (Student item : list) {
			if (id == item.getId()) {
				ajaxResult.setResult(item);
				return ajaxResult;
			}
		}
		ajaxResult.setCode(StatusCode.APP_1004);
		return ajaxResult;
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
	public AjaxResult delete(@PathVariable Integer id) {
		for (Student item : list) {
			if (id == item.getId()) {
				list.remove(item);
				return new AjaxResult();
			}
		}
		return new AjaxResult(StatusCode.APP_1004);
	}

	/**
	 * 新增学生实例
	 * 
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST,produces="application/json; charset=UTF-8")
	@ApiOperation(value = "新增学生实例", notes = "新增学生实例")
	public AjaxResult add(@RequestParam String name, @RequestParam String sex,
			@RequestParam Integer age, @RequestParam String grade) {
		Student student = new Student(id++, name, sex, age, grade);
		list.add(student);
		AjaxResult ajaxResult = new AjaxResult();
		ajaxResult.setResult(student.getId());
		return ajaxResult;
	}

	/**
	 * 根据ID更新学生实例
	 * 
	 * @param entity
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	@ApiOperation(value = "根据ID更新学生实例", notes = "根据ID更新学生实例")
	public AjaxResult update(@RequestParam(required = false) String name,
			@RequestParam(required = false) String sex,
			@RequestParam(required = false) Integer age,
			@RequestParam(required = false) String grade,
			@PathVariable Integer id) {

		Student entity = null;
		for (Student item : list) {
			if (id == item.getId()) {
				entity = item;
			}
		}

		if (entity == null) {
			return new AjaxResult(StatusCode.APP_1004);
		} else {
			if (DataUtil.isNotNull(name)) {
				entity.setName(name);
			}
			if (DataUtil.isNotNull(sex)) {
				entity.setSex(sex);
			}
			if (age != null) {
				entity.setAge(age);
			}
			if (DataUtil.isNotNull(grade)) {
				entity.setGrade(grade);
			}
			return new AjaxResult();
		}
	}

}
