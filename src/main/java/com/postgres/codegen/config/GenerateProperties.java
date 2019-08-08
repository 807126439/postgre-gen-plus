package com.postgres.codegen.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author River
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "generate")
public class GenerateProperties {
    private String schema;
    private String author;
    private String moduleName;
    private String packageName;
    private String mainPath;
}
