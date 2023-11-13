package es.capitole.demo.application.boundary;

import es.capitole.demo.infra.entity.PricesEntity;
import es.capitole.demo.infra.h2.SpringDataH2PricesRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest()
@AutoConfigureMockMvc
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PricesResourceTest {

    private static final String BASE_URL = "/v1/product";
    private static final String PRICE_URL = "/price";

    @Autowired
    SpringDataH2PricesRepository springDataH2PricesRepository;

    @Autowired
    private MockMvc mockMvc;

    @BeforeAll
    void setup(){
        PricesEntity entity1 = new PricesEntity();
        entity1.setBrandId(1);
        entity1.setPriceList(1);
        entity1.setProductId(35455L);
        entity1.setCurr("EUR");
        entity1.setPrice(35.50);
        entity1.setPriority(0);
        entity1.setStartDate(LocalDateTime.of(2020, Month.JUNE,14,0,0,0));
        entity1.setEndDate(LocalDateTime.of(2020, Month.DECEMBER,31,23,59,59));

        PricesEntity entity2 = new PricesEntity();
        entity2.setBrandId(1);
        entity2.setPriceList(2);
        entity2.setProductId(35455L);
        entity2.setCurr("EUR");
        entity2.setPrice(25.45);
        entity2.setPriority(1);
        entity2.setStartDate(LocalDateTime.of(2020, Month.JUNE,14,15,0,0));
        entity2.setEndDate(LocalDateTime.of(2020, Month.JUNE,14,18,30,0));

        PricesEntity entity3 = new PricesEntity();
        entity3.setBrandId(1);
        entity3.setPriceList(3);
        entity3.setProductId(35455L);
        entity3.setCurr("EUR");
        entity3.setPrice(30.50);
        entity3.setPriority(1);
        entity3.setStartDate(LocalDateTime.of(2020, Month.JUNE,15,0,0,0));
        entity3.setEndDate(LocalDateTime.of(2020, Month.JUNE,15,11,0,0));

        PricesEntity entity4 = new PricesEntity();
        entity4.setBrandId(1);
        entity4.setPriceList(4);
        entity4.setProductId(35455L);
        entity4.setCurr("EUR");
        entity4.setPrice(38.95);
        entity4.setPriority(1);
        entity4.setStartDate(LocalDateTime.of(2020, Month.JUNE,15,16,0,0));
        entity4.setEndDate(LocalDateTime.of(2020, Month.DECEMBER,31,23,59,59));

        List<PricesEntity> entities = Arrays.asList(entity1, entity2, entity3, entity4);

        springDataH2PricesRepository.saveAll(entities);
    }

    @Test
    public void peticion_10h_junio_14_2020_producto_35455_brand_1() throws Exception {
        String fullBody = "{" +
                "\"brandId\": 1," +
                "\"productId\": 35455," +
                "\"appDate\": \"2020-06-14T10:00:00\"" +
                "}";

        this.mockMvc.perform(post(BASE_URL+PRICE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(fullBody)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price", is(35.50)));
        //Should be only 1 result -> Entity 1 which price is 35.50
    }

    @Test
    public void peticion_16h_junio_14_2020_producto_35455_brand_1() throws Exception {
        String fullBody = "{" +
                "\"brandId\": 1," +
                "\"productId\": 35455," +
                "\"appDate\": \"2020-06-14T16:00:00\"" +
                "}";

        this.mockMvc.perform(post(BASE_URL+PRICE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(fullBody)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price", is(25.45)));
        //Should be 2 result -> Entity 1 and Entity 2 but Entity 2 has higher priority. Price is 25.45
    }

    @Test
    public void peticion_21h_junio_14_2020_producto_35455_brand_1() throws Exception {
        String fullBody = "{" +
                "\"brandId\": 1," +
                "\"productId\": 35455," +
                "\"appDate\": \"2020-06-14T21:00:00\"" +
                "}";

        this.mockMvc.perform(post(BASE_URL+PRICE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(fullBody)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price", is(35.50)));
        //Should be 1 result -> Entity 1 because Entity 2 is out of date. Price is 25.45
    }

    @Test
    public void peticion_10h_junio_15_2020_producto_35455_brand_1() throws Exception {
        String fullBody = "{" +
                "\"brandId\": 1," +
                "\"productId\": 35455," +
                "\"appDate\": \"2020-06-15T10:00:00\"" +
                "}";

        this.mockMvc.perform(post(BASE_URL+PRICE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(fullBody)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price", is(30.50)));
        //Should be 1 result -> Entity 3. Price is 30.50
    }

    @Test
    public void peticion_21h_junio_16_2020_producto_35455_brand_1() throws Exception {
        String fullBody = "{" +
                "\"brandId\": 1," +
                "\"productId\": 35455," +
                "\"appDate\": \"2020-06-16T21:00:00\"" +
                "}";

        this.mockMvc.perform(post(BASE_URL+PRICE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(fullBody)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price", is(38.95)));
        //Should be 2 result -> Entity 1 & 4 but 4 has higher priority. Price is 38.95
    }

    @Test
    public void noContent_ok_parametros() throws Exception {
        String fullBody = "{" +
                "\"brandId\": 1," +
                "\"productId\": 111," +
                "\"appDate\": \"2020-06-16T21:00:00\"" +
                "}";

        this.mockMvc.perform(post(BASE_URL+PRICE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(fullBody)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    public void badrequest_faltan_parametros() throws Exception {
        String bodyKo = "{" +
                "\"brandId\": 1," +
                "\"appDate\": \"2020-06-16T21:00:00\"" +
                "}";

        this.mockMvc.perform(post(BASE_URL+PRICE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bodyKo)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}
