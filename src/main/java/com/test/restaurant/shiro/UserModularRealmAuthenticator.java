package com.test.restaurant.shiro;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.realm.Realm;

/**
 * 配置多个Realm时，通常使用的是shiro自带的org.apache.shiro.authc.pam.ModularRealmAuthenticator
 * 自定义Authenticator
 * 当需要分别定义用户和管理员验证的Realm时，对应Realm的全类名应包含字符串"user" "manager"'
 * 并且他们不能相互包含
 * @author aabbcczhy
 *
 */
public class UserModularRealmAuthenticator extends ModularRealmAuthenticator {

	@Override
	protected AuthenticationInfo doAuthenticate(AuthenticationToken authenticationToken)
			throws AuthenticationException {
		//判断getRealms是否为空
		assertRealmsConfigured();
		//强制转换回自定义的Token
		UserToken userToken = (UserToken) authenticationToken;
		//登陆方式
		String logintype = userToken.getLoginType();
		//获取所有的Realm
		Collection<Realm> realms = getRealms();
		//登陆类型对应所有的Realm
		Collection<Realm> loginRealms = new ArrayList<Realm>();
		for (Realm realm : realms) {
			if(realm.getName().contains(logintype)) {
				loginRealms.add(realm);
			}
		}
		//判断是单Realm还是多Realm
		if(loginRealms.size() == 1) {
			return doSingleRealmAuthentication(loginRealms.iterator().next(), userToken);
		}else {
			return doMultiRealmAuthentication(loginRealms, userToken);
		}
	}

}
