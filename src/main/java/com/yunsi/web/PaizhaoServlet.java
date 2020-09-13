package com.yunsi.web;

import com.yunsi.auth.AuthService;
import com.yunsi.domain.Msg;
import com.yunsi.utils.HttpUtil;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Set;

@WebServlet("/paizhao")
public class PaizhaoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收前端发过来的图片的b64编码和文件扩展名
        String imgdata = request.getParameter("imgdata");
        String extName = request.getParameter("extName");
        //调用百度的api提供的方法，把图片的b64编码发送给百度的服务器，进行车牌号的识别
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/ocr/v1/license_plate";
        try {
            String imgParam = URLEncoder.encode(imgdata, "UTF-8");
            String param = "image=" + imgParam;

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = AuthService.getAuth();

            String result = HttpUtil.post(url, accessToken, param);
            System.out.println("result--->"+result);

            //利用JSONObject类把result解析为json对象（result为json类型的字符串）
            JSONObject jsonobj1 = JSONObject.parseObject(result);
            //利用result的不同，判断车牌是否识别成功
            //成功result:result--->{"words_result":{"number":"苏E05EV8","vertexes_location":[{"x":139,"y":160},{"x":216,"y":176},{"x":212,"y":199},{"x":135,"y":183}],"color":"blue","probability":[0.9010677337646484,0.9027934074401855,0.9028690457344055,0.9004943370819092,0.9008733034133911,0.9011093378067017,0.9009025692939758]},"log_id":"1282934667833507840"}
            //失败result:result--->{"log_id":"1282949248597360640","error_msg":"recognize error","error_code":216630}
            //利用JSONObject类对象可以获取result的键集
            Set<String> keyset = jsonobj1.keySet();
            System.out.println(keyset);
            Msg msg = new Msg();//用于存储识别的结果
            response.setContentType("application/json;charset=utf-8");//指定响应的数据类型和编码方式
            //如果键集中包含words_result,说明车牌号识别成功
            if(keyset.contains("words_result")){//为什么Set类型对象可以直接调用cantains方法？这是Set的contains方法，不是String的。
                //获取json对象的属性words_result
                String words_result = jsonobj1.getString("words_result");
                //再把words_result解析为json对象，然后获取属性number
                JSONObject jsonobj2 = JSONObject.parseObject(words_result);
                String number = jsonobj2.getString("number");
                System.out.println("车牌号:"+number);
                //把判断标识和车牌号放到msg中，准备发送给浏览器
                msg.setCode(1);
                msg.setMsg(number);
                //把msg转换成json字符串的形式
                String msgJson = JSONObject.toJSONString(msg);
                response.getWriter().write(msgJson);
            }

            //如果键集中包含error_msg,说明车牌号识别失败
            if(keyset.contains("error_msg")){
                msg.setCode(0);
                //把msg转换成json字符串
                String msgjson = JSONObject.toJSONString(msg);
                response.getWriter().write(msgjson);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
