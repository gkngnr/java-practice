package demo1;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@Builder
public class Message {
    @JsonProperty("header")
    private Header header;

    @JsonProperty("body")
    private Body body;

    // Constructors, getters, and setters

    @JsonRootName("header")
    @Getter
    @Setter
    @Builder
    public static class Header {
        private String sender;
        private String receiver;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
        private Date timestamp;

        // Constructors, getters, and setters
    }

    @JsonRootName("body")
    @Getter
    @Setter
    @Builder
    public static class Body {
        private String from;
        private String to;
        private String message;

        // Constructors, getters, and setters
    }

    public static void main(String[] args) {
        try {
            // Create an instance of your POJO


            Header header = Header.builder()
                    .sender("John")
                    .receiver("Doe")
                    .timestamp(new Date())
                    .build();

            Body body = Body.builder()
                    .from("Alice")
                    .to("Bob")
                    .message("Hello dada")
                    .build();

            Message message = Message.builder()
                    .header(header)
                    .body(body)
                    .build();

            // Create an XmlMapper
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"));

            // Convert the POJO to XML
            String xmlString = xmlMapper.writeValueAsString(message);

            // Print the generated XML
            System.out.println(xmlString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
