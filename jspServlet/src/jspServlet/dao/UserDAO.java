package jspServlet.dao;

import jspServlet.vo.User;

public interface UserDAO {
	public int queryByUsername(User user) throws Exception;
	public User listByUsername(String username) throws Exception;
}
