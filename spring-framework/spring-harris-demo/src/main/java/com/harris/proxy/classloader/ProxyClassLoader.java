package com.harris.proxy.classloader;

import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * @author Harris
 * @version 1.0
 * @ClassName: spring
 * @Description: 自定义类加载器
 * @date 2022/1/17 20:17
 */
public class ProxyClassLoader extends ClassLoader {

	private File file;

	private String proxyClassPackage;

	public ProxyClassLoader(String filePath, String proxyClassPackage) {
		this.file = new File(filePath);
		this.proxyClassPackage = proxyClassPackage;
	}

	public File getFile() {
		return file;
	}

	public String getProxyClassPackage() {
		return proxyClassPackage;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		if (!Objects.isNull(file)) {
			File classFile = new File(file, name + ".class");
			if (classFile.exists()) {
				try {
					// 生成class的二进制流
					byte[] bytes = FileCopyUtils.copyToByteArray(classFile);
					return defineClass(proxyClassPackage + "." + name, bytes, 0, bytes.length);
				} catch (IOException e) {
					e.printStackTrace();
					throw new ClassNotFoundException(e.getLocalizedMessage());
				}
			}
		}
		// 若没有加载自定义类，则走默认的加载方式
		return super.findClass(name);
	}

	public Class<?> find(String name) throws ClassNotFoundException {
		return findClass(name);
	}
}
