package com.services.dice;

import com.services.dice.dice.diceController;
import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@WebMvcTest(diceController.class)
class DiceApplicationTests {

    @Autowired
    private MockMvc mvc;
    @Test
    void contextLoads() throws Exception {
        int anzahlWurf = 20;
        int anzahlAugen = 6;
        RequestBuilder request = MockMvcRequestBuilders.get(String.format("/dice/%dd%d",anzahlWurf,anzahlAugen));
        MvcResult result = mvc.perform(request).andReturn();
        String strResult = result.getResponse().getContentAsString();
        String[] strResultarr = strResult.substring(1,strResult.indexOf(']')).split(",");
        assertEquals(anzahlWurf,strResultarr.length);
        for (String item :strResultarr){
            assertTrue(Integer.parseInt(item.strip())<anzahlAugen+1);
        }

    }

}