﻿package liuzh.poker.factory;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import java.io.*;

/**
 * title:Factory
 * descript:用于从配置文件中创建指定的对象
 * @author liuzh
 * @date 2016年4月28日 下午12:11:53
 */
public class Factory {
	public static Object getBean(String className) {
		try {
			// 创建文档对象
			DocumentBuilderFactory dFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = dFactory.newDocumentBuilder();
			Document doc;
			doc = builder.parse(new File("src/liuzh/poker/factory/config.xml"));

			// 获取包含类名的文本节点
			NodeList nl = doc.getElementsByTagName(className);
			Node classNode = nl.item(0).getFirstChild();
			String cName = classNode.getNodeValue();

			// 通过类名生成实例对象并将其返回
			return Class.forName(cName).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
