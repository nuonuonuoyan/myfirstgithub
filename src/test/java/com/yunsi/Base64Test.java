package com.yunsi;

import com.yunsi.utils.B64Util;
import org.junit.Test;

public class Base64Test {

    @Test
    public void testBase64() throws Exception {
        String fromPath = "C:\\Users\\RUIRUI\\Desktop\\20200713\\测试使用车牌图片\\carImage\\1.jpg";
        String b64String = B64Util.encodeBase64File(fromPath);//将文件路径下的文件编码成base64的格式
        String toPath = "C:\\Users\\RUIRUI\\Desktop\\1.jpg";
        B64Util.decoderBase64File(b64String,toPath);//将1.jpg编码的base64字符串解码成1.jpg，放在桌面上

    }
}
