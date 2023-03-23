package com.ezen.springmvc.util;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class AppleUtilitiesTest {
	
	// 다른 폴더에 있지만 같은 패키지 내부에 있기 때문에 import가 필요없다
	// AppleUtilities util = new AppleUtilities();

	
	AppleUtilities util;
	
	@Before // org.Junit
	// 시작할 때마다 새로운 사과를 만들어서 진행
	public void beforeTest() {
		util = new AppleUtilities();
		System.out.println("Create new apple utils.");
	}
	
//	@After
//	public void afterTest() {
//		System.out.println("After!!");
//	}
	
	// @Ignore - Ignore이 없어여 Before, After가 두번 찍힌다
	@Test
	public void test1() {
		util.setBasketSize(10);
		
		// 기대하는 값은 6입니다.
		// 실패 했을 때 메세지를 달 수 있다.
		assertEquals("실패했다", 6, util.getBasketCount(55));
	}
	
	@Test
	public void test2() {
		// assertThrows() : 나는 예외가 발생할 것을 기대하는 중입니다.
		// 람다식 함수
		assertThrows(BasketSizeTooSmallException.class, () -> {
			util.setBasketSize(-5);
		});
	}
	
	@Test
	public void test3() {
		// 바구니 크기 설정을 하지 않고 계산하는 경우에 대한 처리가 잘 되는지 확인하고 싶다
		assertThrows(BasketSizeUnsetException.class, () -> {
			util.getBasketCount(99);
		});
	}
}
