package com.test.restaurant.shiro;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

import com.test.restaurant.service.AuthorityService;
import com.test.restaurant.service.ManagerService;
import com.test.restaurant.service.RoleService;

public class ManagerRealm extends AuthorizingRealm {

	@Autowired
	ManagerService managerservice;
	
	@Autowired
	RoleService roleservice;
	
	@Autowired
	AuthorityService authorityService;
	
	/**
	 * 获取授权信息
	 * @param principals
	 * @return 授权信息
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String email = (String) principals.getPrimaryPrincipal();
		Set<String> roles = getRolesByEmail(email);
		Set<String> permissions = getPermissionsByRoles(roles);
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		authorizationInfo.setStringPermissions(permissions);
		authorizationInfo.setRoles(roles);
		return authorizationInfo;
	}
	
	/**
	 * 根据角色集合获取角色对应的权限集合
	 * @param role 角色
	 * @return 权限集合
	 */
	private Set<String> getPermissionsByRoles(Set<String> roles) {
		List<String> list = new ArrayList<String>();
		for (String str : roles) {
			List<String> userPermissionsList = authorityService.getPermissionsByRole(str);
			list.addAll(userPermissionsList);
		}
		Set<String> set = new HashSet<>(list);
		return set;
	}
	
	/**
	 * 根据管理员邮箱获取相应的角色
	 * @param email 邮箱
	 * @return 角色集合
	 */
	private Set<String> getRolesByEmail(String email){
		List<String> list = roleservice.getRolesByEmail(email);
		Set<String> set = new HashSet<>(list);
		return set;
	}
	
	/**
	 * 获取认证信息
	 * @param token
	 * @return
	 * @throws AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//从页面获取邮箱
		String email = (String) token.getPrincipal();
		String password = getPasswordByEmail(email);
		if(password==null)
			return null;
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(email,password,"managerRealm");
		authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(email));
		return authenticationInfo;
	}

	private String getPasswordByEmail(String email) {
		String password = managerservice.getPasswordByEmail(email);
		return password==null ? null : password;
	}

}
