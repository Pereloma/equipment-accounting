package ml.tentaclestruck.equipmentaccounting;

import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;

import java.awt.image.BufferedImage;

@SpringBootApplication
public class EquipmentAccountingApplication {

    public static void main(String[] args) {
        SpringApplication.run(EquipmentAccountingApplication.class, args);
    }

    @Bean
    public HttpMessageConverter<BufferedImage> createImageHttpMessageConverter() {
        return new BufferedImageHttpMessageConverter();
    }
    @Bean
    public QRCodeWriter barcodeWriter(){
        return new QRCodeWriter();
    }

}
