package com.springjdbc;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext wac;


    @Before
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testWwwform() throws Exception {
        String res = mvc.perform(MockMvcRequestBuilders.post("/user/findPassword")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .content("username=zhangshan & newPassword=1234")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString();
        assertEquals(true,res.equals("true"));
    }

    @Test
    public void testParamform() throws Exception {
        JSONObject param = new JSONObject();
        param.put("username","admin");
        param.put("password","123456");
        param.put("name","张珊");
        param.put("sex","F");
        param.put("age","18");
        param.put("born","2000/12/12");
        param.put("departmentId","1");
        param.put("telephone","12111111111");
        param.put("email","123456@qq.com");
        param.put("address","地址");
        String res = mvc.perform(MockMvcRequestBuilders.post("/admin/addUser")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(param.toString())
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString();
        int r = Integer.parseInt(res);
        assertEquals(1,r);
    }

    @Test
    public void testGetMsg() throws Exception {
        String res = mvc.perform(MockMvcRequestBuilders.get("/user/getUserMsg")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .content("id=2")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString();
        JSONArray resJSON = new JSONArray(res);
        System.out.println(resJSON);
        //assertEquals(true,res.equals("true"));

    }

}
