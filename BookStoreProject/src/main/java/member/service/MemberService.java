package member.service;

import member.dao.MemberDAO;
import member.vo.Member;

/* Business Method가 나와야 한다 */
public class MemberService {
	
	// login 처리하는 business method
	public Member login(Member member) {
		// 로그인이 되는지 확인하는 로직처리
		// Database 처리
		// Database 처리를 위해 DAO가 있어야 해요. (class도 존재해야 해요)
		try {
			MemberDAO dao = new MemberDAO();
			member = dao.select(member);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return member;	
	}
}
