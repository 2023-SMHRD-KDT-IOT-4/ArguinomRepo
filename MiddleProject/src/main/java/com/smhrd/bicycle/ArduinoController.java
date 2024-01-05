package com.smhrd.bicycle;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smhrd.bicycle.mapper.ArduinoMapper;
import com.smhrd.bicycle.model.Gps;

@Controller
public class ArduinoController {
	
	@Mapper
	ArduinoMapper mapper;
	

	//아두이노 to java test
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public @ResponseBody String test(@RequestParam("data") String data) {
		
		System.out.println(data);
		return  "iqwufes"; //아두이노로 리턴
		
	}
	
	//ToDo 
	//     (완료)센서값 받아와서 db로 저장하기(아두이노에서 딜레이 간격으로 한번 보낼때 위 메서드 한번 타는거면 그냥 한줄만 입력해도 딜레이간격만큼 디비에 저장할듯)
	//     받아온 센서값 웹에 출력할 수 있어야함(자전거 도난시 gps위치값 웹에 바로바로 보내줘야함)
	//	   주차 잠금/이동 -> 자바에서 아두이노로 데이터 보내야함(이거어케하지 // 리턴이아니라 그냥 아두이노로 보내야하는데 어떻게하냐 이거)
	
	
	//gps센서값 라이딩기록 남기기 위해 db저장
	//아두이노에서 쿼리스트링으로 보내야함
	//?latitude=00.00000000&longitude=000.00000000 ... user_id도 아두이노 코드에 입력해놔서 받아와야할듯..;
	@RequestMapping(value="/#", method=RequestMethod.GET)
	public void locationSave(@RequestParam("latitude") Double lat,@RequestParam("longitude") Double lng,@RequestParam("speed") Double speed,@RequestParam("altitude") Double alt,
							 @RequestParam("user_id") String user_id) {
		
		Gps gps = new Gps(lat,lng,speed,alt,user_id);
		
		int res = mapper.locationSave(gps);
		
		if(res>0) {
			System.out.println("저장 성공");
		}else {
			System.out.println("저장 실패");
		}
	}
}
