package com.test.restaurant.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.test.restaurant.service.UserService;

public class UserRealm extends AuthorizingRealm {

	@Autowired
	UserService usersevice;
	
	/**
	 * 获取授权信息
	 * @param principals
	 * @return 授权信息
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		authorizationInfo.addRole("user");
		return authorizationInfo;
	}
	
	/**
	 * 获取认证信息
	 * @param token
	 * @return 认证信息
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String email = (String) token.getPrincipal();
		String password = getPasswordByEmail(email);
		if(password==null) {
			return null;
		}
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(email,password,"userRealm");
		authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(email));
		return authenticationInfo;
	}

	private String getPasswordByEmail(String email) {
		String password = usersevice.getPasswordByEmail(email);
		return password==null ? null : password;
	}
	
}
