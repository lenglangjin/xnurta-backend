package com.leda.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "file.file-storage")
public class FileStorageProperty {

    private String type;

    @NestedConfigurationProperty
    private LocalStorage localStorage = new LocalStorage();
    @NestedConfigurationProperty
    private MinioStorage minioStorage = new MinioStorage();
    @NestedConfigurationProperty
    private OssStorage ossStorage = new OssStorage();

    @Getter
    @Setter
    public static class LocalStorage{
        private String path = "/data";

    }
    @Getter
    @Setter
    public static class MinioStorage{
       private String endpoint;

        private String accessKey;

        private String secretKey;

        private String bucketName;

    }
    @Getter
    @Setter
    public static class OssStorage{
        private String endpoint;

        private String accessKey;

        private String secretKey;

        private String bucketName;

    }
}
