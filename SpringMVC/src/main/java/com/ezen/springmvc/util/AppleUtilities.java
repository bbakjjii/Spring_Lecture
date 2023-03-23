package com.ezen.springmvc.util;

public class AppleUtilities {

	private Integer basketSize;
	
	public void setBasketSize(int basketSize) throws BasketSizeTooSmallException {
		// 예외처리
		if (basketSize <= 0) {
			// 이 예외를 던져버릴 수도 있는 메서드라는 의미
			throw new BasketSizeTooSmallException("Basket size is too small");
		}
		
		this.basketSize = basketSize;
	}

	public int getBasketCount(int apple) {
		if (basketSize == null) {
			throw new BasketSizeUnsetException("basket size not initialized.");
		}
		
		return apple % basketSize == 0 ?
				apple / basketSize : apple / basketSize + 1;
	}

	// main으로 테스트하는 것이 아니라 JUnit으로 테스트한다.
	//	public static void main(String[] args) {
	//		AppleUtilities util = new AppleUtilities();
	//		
	//		util.basketSize = 10;
	//		
	//		System.out.println(util.getBasketCount(33));
	//	}
}
