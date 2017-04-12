package generator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * @author LIANGBING
 * @date Create on 2016-7-15 下午5:06:55
 * @version  1.0
 * 
 */
public class GeneratorSqlMap {
	
	public void generator() throws Exception{

		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		//指定 逆向工程配置文件/nlbmanages/src/test/java/generator/GeneratorSqlMap.java
		File configFile = new File("D:\\MyWorkspaces\\nlbmanages\\generatorConfig.xml"); 
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
				callback, warnings);
		myBatisGenerator.generate(null);

	} 
	public static void main(String[] args) throws Exception {
		try {
			GeneratorSqlMap generatorSqlmap = new GeneratorSqlMap();
			generatorSqlmap.generator();
			System.out.println("已生成源码");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
