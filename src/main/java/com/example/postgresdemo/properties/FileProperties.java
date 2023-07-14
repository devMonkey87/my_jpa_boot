package com.example.postgresdemo.properties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

// By the prefix "file" we tell this class to trigger entry in application.properties starting with file:
//upload.file.extensions=jpg,jpeg,gif,png

@ConfigurationProperties(prefix = "upload.file")
@Getter
@Setter
public class FileProperties {
    public List<String> extensions;
}
