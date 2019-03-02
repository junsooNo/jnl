package com.spring.study;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.spring.study.dto.LearnPostDTO;
import com.spring.study.dto.MenuDTO;
import com.spring.study.service.LearnPostService;
import com.spring.study.service.MenuService;
import com.spring.study.util.JnlUtil;

@Controller
public class LearnPostContoller {

	@Autowired
	private MenuService menuService;
	
	@Autowired
	private LearnPostService learnPostService;
	
	@Autowired
	private JnlUtil jnlUtil;
	
	@RequestMapping(value="post",method=RequestMethod.GET)
	public String post(Model model,MenuDTO menuDTO) {
		MenuDTO menuInfo = menuService.selectOneMenu(menuDTO);
		model.addAttribute("menuName",menuInfo.getName());
		model.addAttribute("center","post.jsp");
		return "main";
	}
	
	@RequestMapping(value="learnPost",method=RequestMethod.POST)
	@ResponseBody
	public String learnPost(LearnPostDTO learnPostDTO,@RequestParam(name="file") MultipartFile[] file) throws IllegalStateException, IOException {
		System.out.println(learnPostDTO.getTitle());

		for(int i=0; i<file.length-1; i++) {
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String fileName = file[i].getOriginalFilename();
			File f = new File(jnlUtil.filePath()+sdf.format(date)+System.currentTimeMillis()+"_"+fileName);
			file[i].transferTo(f);
		}
		
		return null;
	}
}
