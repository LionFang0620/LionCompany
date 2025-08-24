package dao;

import model.Member;

public interface MemberDao {
	//create
	public void  addMember(Member member); //新增會員
	
	//read
	Member select(String username,String password); //登入
	Member selectUser(String username);
	
	//update
	public void update(Member member);
	//修改會員資料，可改姓名、密碼、地址、電話
	
	//delete
	public void delete(Member member) ;
	//輸入帳號、密碼，可以刪除會員資料或訂單資料

}
