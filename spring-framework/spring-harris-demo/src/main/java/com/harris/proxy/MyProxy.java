package com.harris.proxy;

import com.harris.proxy.classloader.ProxyClassLoader;
import org.springframework.util.FileCopyUtils;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author Harris
 * @version 1.0
 * @ClassName: spring
 * @Description: 自定义Proxy
 * @date 2022/1/17 20:26
 */
public class MyProxy {

	private static final String str = "\r";

	public static Object newProxyInstance(ProxyClassLoader classLoader, Class<?> interfaces, InvocationHandler handler) {
		if (Objects.isNull(handler)) {
			throw new NullPointerException("InvocationHandler is null");
		}
		// 根据接口构建代理类：$MyProxy0
		Method[] methods = interfaces.getMethods();
		StringBuffer proxyClassStr = new StringBuffer();
		proxyClassStr.append("package com.harris.").append(classLoader.getProxyClassPackage()).append(";").append(str)
				.append("import java.lang.reflect.Method;").append(str)
				.append("public class $MyProxy0 implements ").append(interfaces.getName()).append(" { ").append(str)
				.append(" InvocationHandler handler; ").append(str)
				.append("public $MyProxy0 (InvocationHandler handler) { ").append(str)
				.append(" this.handler = handler; }").append(str)
				.append(getMethodToString(methods, interfaces)).append("}");
		// 写入Java文件 进行编译
		String fileName = classLoader.getFile() + File.separator + "$MyProxy0.java";
		File proxyFile = new File(fileName);
		try {
			compile(proxyClassStr, proxyFile);
			Class<?> $MyProxy0 = classLoader.find("$MyProxy0");
			// $MyProxy0初始化 利用构造器
			Constructor<?> constructor = $MyProxy0.getConstructor(InvocationHandler.class);
			return constructor.newInstance(handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static String getMethodToString(Method[] methods, Class<?> interfaces) {
		StringBuffer methodStr = new StringBuffer();
		for (Method method : methods) {
			methodStr.append("public void ").append(method.getName())
					.append("() throws Throwable { ")
					.append(" Method method = ").append(interfaces.getName())
					.append(".class.getMethod(\"").append(method.getName())
					.append("\", new Class[]{});")
					.append(" this.handler.invoke(this, method, null);}").append(str);
		}
		return methodStr.toString();
	}

	private static void compile(StringBuffer proxyClassStr, File proxyFile) throws IOException {
		FileCopyUtils.copy(proxyClassStr.toString().getBytes(), proxyFile);
		JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager standardFileManager = javaCompiler.getStandardFileManager(null, null, null);
		Iterable<? extends JavaFileObject> javaFileObjects = standardFileManager.getJavaFileObjects(proxyFile);
		CompilationTask task = javaCompiler.getTask(null, standardFileManager, null, null, null, javaFileObjects);
		task.call();
		standardFileManager.close();
	}
}
