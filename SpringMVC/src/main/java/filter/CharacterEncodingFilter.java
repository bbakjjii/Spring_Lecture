package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

// -- 6 --
public class CharacterEncodingFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("필터에서 처리중입니다.");
		
		// 앞으로 들어오는 모든 요청들은 이곳을 지나기 때문에 EUC-KR로 실행된다.
		request.setCharacterEncoding("EUC-KR");
		
		System.out.println("처리가 끝났습니다.. 다음 필터로 이동합니다.");
		
		// 여기서 처리가 끝났으니 다음으로 보내겠다.
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {	
	}

}
