package cn.com.amber;import org.springframework.boot.SpringApplication;import org.springframework.boot.autoconfigure.SpringBootApplication;import org.springframework.cloud.client.discovery.EnableDiscoveryClient;import org.springframework.cloud.openfeign.EnableFeignClients;/** * 启动类 * * @author yangying * @version 1.0 * @since 2022/9/3 **/@SpringBootApplication@EnableDiscoveryClient@EnableFeignClients(basePackages = { "cn.com.amber.remote" })public class AmberArchetypeApplication {    public static void main(String[] args) {        SpringApplication.run(AmberArchetypeApplication.class);    }}