package service.impl;

import dao.impl.MemberDaoImpl;
import model.Member;
import service.MemberService;

public class MemberServiceImpl implements MemberService{
	
	private static MemberDaoImpl mdi=new MemberDaoImpl();
	@Override
	//新增會員
	public boolean addMember(Member member) {
		boolean isUsed=false;
		Member m=mdi.selectUser(member.getUsername());
		if(m==null)
		{
			mdi.addMember(member);
			isUsed=true;
		}
		return isUsed;
	}

	@Override
	//登入
	public Member login(String username, String password) {
		
		return mdi.select(username, password);
	}

	@Override
	//根據帳號修改會員資料
	public boolean updateMemberData(Member member) {
		Member m = mdi.selectUser(member.getUsername());
		boolean isUsed=false;
		mdi.update(member);
		if(m!=null)
		{
			mdi.update(member);
			isUsed=true;
		}
		return isUsed;
	}
	@Override
	public boolean deleteMemberData(Member member) {
		Member m = mdi.select(member.getUsername(),member.getPassword());
		boolean isUsed=false;
		if(m!=null)
		{
			mdi.delete(member);
			isUsed=true;
		}
		return isUsed;
	}

	

}
