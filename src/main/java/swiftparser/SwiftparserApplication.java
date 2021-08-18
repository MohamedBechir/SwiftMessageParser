package swiftparser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import swiftparser.fileUpload.property.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
	FileStorageProperties.class
	})
	@EnableJpaAuditing
public class SwiftparserApplication {
	public static void main(String[] args) {
		SpringApplication.run(SwiftparserApplication.class, args);
	}
}
