package ezen.mvcframework.web.member.controller;

import java.util.Map;
import ezen.mvcframework.core.web.controller.WebController;
import ezen.mvcframework.domain.common.database.DaoFactory;
import ezen.mvcframework.domain.member.dao.MemberDao;
import ezen.mvcframework.domain.member.dto.Member;

/**
 * 아이디 중복 체크 세부 컨트롤러
 */
public class IdCheckController implements WebController {
	
	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		String viewName = "member/idcheck-result";
		String id = paramMap.get("id");
		MemberDao memberDao = DaoFactory.getInstance().getMemberDao();
		boolean exist = memberDao.findById(id);
		model.put("exist", exist);
		return viewName;
	}

}
