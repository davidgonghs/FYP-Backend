package com.dghs.fyp.backend;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.sun.prism.PixelFormat;
import org.junit.jupiter.api.Test;

/**
 * Mybatis generator test
 * @Author: David Gong
 * @Date: 2023/06/13
 */
public class MybatisGeneratorTest {
    @Test
    public void generator(){
        String url = "jdbc:mysql://localhost:3306/fyp?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&serverTimezone=GMT%2B8";
        String username = "root";
        String password = "";
        String author = "David Gong";

        String dir = "E:\\FCUC\\DavidGong-FYP\\FYP-Backend\\src\\main\\java";
        String packageName = "com.dghs.fyp.backend";
        String tables = "user,role,usage_history,user_daily_statistics,user_roles,user_settings";

        FastAutoGenerator.create(url,username,password)
                .globalConfig(builder -> {
                    builder.outputDir(dir)
                            .author(author)
                            .enableSwagger()
                            .dateType(DateType.TIME_PACK)
                            .disableOpenDir()
                            .commentDate("yyyy-MM-dd");
                })
                .packageConfig(builder -> {
                    builder.parent(packageName)
                            .moduleName("sys")
                            .entity("entity")
                            .service("service")
                            .serviceImpl("service.impl")
                            .mapper("mapper")
                            .xml("mapper.xml")
                            .controller("controller")
                            .other("other");
                })
                .strategyConfig(builder -> {
                    builder.addInclude(tables)
                            .entityBuilder()
                            .enableLombok()
                            .enableTableFieldAnnotation()
                            .controllerBuilder()
                            .enableHyphenStyle()
                            .enableRestStyle()
                            .serviceBuilder()
                            .formatServiceFileName("%sService")
                            .formatServiceImplFileName("%sServiceImpl")
                            .mapperBuilder()
                            .enableBaseResultMap()
                            .enableBaseColumnList();
                })
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();

    }
}
