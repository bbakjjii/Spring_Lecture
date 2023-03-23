package com.ezen.springdb.board.service.Impl;

import javax.servlet.http.Cookie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.ezen.springdb.board.mapper.ServiceBoardMapper;
import com.ezen.springdb.board.service.BoardListService;
import com.ezen.springdb.dto.BoardDTO;

import lombok.extern.log4j.Log4j;

// -- 8 --
// Service와 Mapper는 다대다 관계 // -- 14 --
//@Service
@Log4j
public class BoardListServiceImpl implements BoardListService {

	//@Autowired
	ServiceBoardMapper board_mapper;

	// -- 17 --
	//@Override
	public BoardDTO clickTitle(Integer board_id, 
			HttpServletRequest request, HttpServletResponse response) {

		// 최근에 조회한적이 있는지 검사한 후 (쿠키 검사, 추가 또는 갱신)
		// -- 20 --
		Cookie[] cookies = request.getCookies();

		boolean viewed = false;

		// -- 21 --
		JSONObject obj = null;

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie != null && cookie.getName().equals("viewed")) {
					// 조회가 된다는 것(쿠키가 존재한다는 것)은 본적이있다는 뜻 
					// viewed = true;
					// 쿠키에서 값을 꺼내면 {"ids":[1,2,3,4]} 형태의 문자열이 나온다
					String jsonString = cookie.getValue();

					// 문자열을 SJONObject 타입으로 파싱하기 위한 객체
					JSONParser parser = new JSONParser();

					try {
						// 파싱을 실행
						obj = (JSONObject)(parser.parse(jsonString)); //JSONObject타입으로 다운캐스팅

						// 값으로 꺼낸 것이 자바스크립트 배열이기 때문에 JSONArray로 받음
						JSONArray ids = (JSONArray) obj.get("ids"); // JSONArray로 다운캐스팅

						viewed = ids.contains(board_id);

						// 하나씩 반복을 돌릴 수도 있다
						// for (int i = 0; i < ids.size(); ++i) {
						//	ids.get(i);
						// }

					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
			}
		}


		if (!viewed) {

			// -- 10 --
			// 해당 글의 조회수를 1 올린다 (영속 계층)
			board_mapper.plusView(board_id);

			// -- 21 --
			if (obj == null) {
				// 조회한 적도 없고 쿠키도 없는 경우
				// 자바스크립트 오브젝트(Map타입)처럼 사용할 수 있다
				// const json = { ids: [board_id] }와 같은 형태
				JSONObject json = new JSONObject();
				JSONArray arr = new JSONArray();
				arr.add(board_id);
				json.put("ids", arr);
				
				log.info(json.toJSONString());

				Cookie viewCookie = new Cookie("viewd", json.toJSONString()); // 문자열로 변환
				viewCookie.setPath("/service/board"); // 여기서 다 쓰겠다

				response.addCookie(viewCookie); 
			} else {
				// 이 글을 오늘 처음 보지만 쿠키는 있는 경우
				JSONArray ids = (JSONArray) obj.get("ids");
				ids.add(board_id);
				obj.put("ids",  ids);

				Cookie viewCookie = new Cookie("viewd", obj.toJSONString()); // 문자열로 변환
				viewCookie.setPath("/service/board"); // 여기서 다 쓰겠다

				response.addCookie(viewCookie);
			}
		}
		// -- 21 끝 --

		// 글의 상세 내용을 가져온다 (영속 계층)
		// - Mapper는 서비스보다는 테이블이나 DTO 단위로 생각해주는게 좋다
		// -- 14 --
		BoardDTO board = board_mapper.get(board_id);
		// -- 14 끝 --

		// -- 14 --
		return board;
	}
	// -- 20 끝 --

}
