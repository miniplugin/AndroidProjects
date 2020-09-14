package org.edu.controller;

import java.util.List;

import javax.inject.Inject;

import org.edu.vo.MemberVO;
import org.edu.dao.IF_MemberDAO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonDataController {

	@Inject
	private IF_MemberDAO memberDAO;
	
	@RequestMapping(value="/android/login", method = RequestMethod.POST) //안드로이드 외부로그인용
	public ResponseEntity<List<MemberVO>> loginMember(@RequestParam("txtUsername") String user_id,@RequestParam("txtPassword") String user_pw) {
		ResponseEntity<List<MemberVO>> entity = null;
		try {
			entity = new ResponseEntity<>(memberDAO.loginMember(user_id, user_pw), HttpStatus.OK);
			System.out.println("OK... user_id = " + user_id);
			System.out.println("OK... entity = " + entity);
		
		} catch (Exception e) {
			System.out.println("Error ...........");
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}	
		return entity;
		
	}
	
	@RequestMapping(value="/android/list", method = RequestMethod.POST) //안드로이드 외부로그인용
	public ResponseEntity<List<MemberVO>> androidMember() {
		ResponseEntity<List<MemberVO>> entity = null;
		try {
			entity = new ResponseEntity<>(memberDAO.androidMember(), HttpStatus.OK);
			System.out.println("OK... entity = " + entity);
		
		} catch (Exception e) {
			System.out.println("Error ...........");
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}	
		return entity;
		
	}
	
	@RequestMapping(value = "/android/delete/{user_id}", method = RequestMethod.POST)
	public ResponseEntity<String> deleteReply(@PathVariable("user_id") String user_id) {
	
		System.out.println("delete PUT/PATCH called ...........");
		ResponseEntity<String> entity = null;
		try {
			memberDAO.delete(user_id);
			System.out.println("OK... rno = " + user_id);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("Error ...........");
			e.printStackTrace();
			entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
}