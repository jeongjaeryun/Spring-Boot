package com.yedam.app.config;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 빈으로 읽어들이는 부분에서 이자체가 빈이 아니고 이내부에 설정된 메소드를 기반으로 빈을 등록함, 여기서 빈은 리턴하는 대상
public class JasyptConfig {
	@Value("${jasypt.encryptor.password}") // 환경변수 이름은 무조건 얘가 돼야함
	private String password;
	
    @Bean("jasyptStringEncryptor")
    public StringEncryptor stringEncryptor() {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor(); //실제 인스턴스, 빈으로 등록할 대상
        
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(password); //핵심이 password 변수로 선언해줌, 설정하는 순간부터 프로젝트에 올라가면 안됨
        config.setAlgorithm("PBEWITHHMACSHA512ANDAES_256");
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
        config.setStringOutputType("base64");
        
        encryptor.setConfig(config);
        return encryptor;
    }
}
