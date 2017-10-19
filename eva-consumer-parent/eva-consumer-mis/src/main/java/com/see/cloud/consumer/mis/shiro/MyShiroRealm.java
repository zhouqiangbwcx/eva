package com.see.cloud.consumer.mis.shiro;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

public class MyShiroRealm extends AuthorizingRealm {

	/**
	 * 用于认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("使用了自定义的realm,用户认证...");

		System.out.println("用户名:" + ((UsernamePasswordToken) token).getUsername());
		System.out.println("密码:" + new String(((UsernamePasswordToken) token).getPassword()));

		// 模拟账号不存在
		// if (true) {
		// throw new UnknownAccountException();
		// }

		// 获取用户名
		String userName = (String) token.getPrincipal();
		// 依据用户名去数据库查询
		// 模拟从数据库中查询出来的散列值密码
		String password = "36f2dfa24d0a9fa97276abbe13e596fc";
		// 查询到了数据，验证密码是否正确
		// 密码正确，认证通过
		// 密码错误,认证失败
		// 没有查询到数据，认证失败

		// 模拟从数据库中获取salt
		String salt = "qwerty";

		return new SimpleAuthenticationInfo(userName, password, ByteSource.Util.bytes(salt), this.getName());
	}

	/**
	 * 用于授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("使用了自定义的realm,用户授权...");

		// 获取用户名
		// String userName = (String) principals.getPrimaryPrincipal();
		// 依据用户名在数据库中查找权限信息

		// 角色
		List<String> roles = new ArrayList<>();
		roles.add("admin");
		roles.add("user");
		// 权限
		List<String> permissions = new ArrayList<>();
		permissions.add("admin:select");
		permissions.add("admin:delete");

		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		simpleAuthorizationInfo.addStringPermissions(permissions);
		simpleAuthorizationInfo.addRoles(roles);
		return simpleAuthorizationInfo;
	}
}
